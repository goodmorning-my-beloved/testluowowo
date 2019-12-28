package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.Region;
import cn.wolfcode.luowowo.article.mapper.DestinationMapper;
import cn.wolfcode.luowowo.article.query.DestinationQuery;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.IRegionService;
import cn.wolfcode.luowowo.hotel.domain.HotelTheme;
import cn.wolfcode.luowowo.hotel.service.IHotelThemeServie;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DestinationServiceImpl implements IDestinationService {

    @Autowired
    private DestinationMapper destinationMapper;

    @Autowired
    private IRegionService regionService;

    // 注入住宿主题服务
    @Reference
    private IHotelThemeServie hotelThemeServie;

    @Override
    public List<Destination> getDestsByDeep(int deep) {
        return destinationMapper.selectDestsByDeep(deep);
    }

    @Override
    public void saveOrUpdate(Destination destination) {

    }

    @Override
    public List<Destination> getDestByRegionId(Long rid) {

        //rid ==-1  表示查询国内所有省份

        if (rid == -1) {
            //id = 1; 表示中国id
            return destinationMapper.selectSubDestParentId(1L);
        }


        //区域
        Region region = regionService.get(rid);
        //关联的目的地id
        Long[] destIds = region.getRefIds();

        return destinationMapper.selectDestByIds(destIds);
    }


    @Override
    public PageInfo query(DestinationQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo(destinationMapper.selectForList(qo));
    }

    @Override
    public List<Destination> getToasts(Long parentId) {
        //parentId: 广州
        //: 根 >> 中国  >> 广东 >> 广州
        List<Destination> list = new ArrayList<>();

        createToast(parentId, list);
        Collections.reverse(list);  //列表反序
        return list;
    }

    //创建吐司
    private void createToast(Long parentId, List<Destination> list) {
        //广州
        Destination destination = destinationMapper.selectByPrimaryKey(parentId);
        if (destination == null) {
            return;
        }

        list.add(destination);

        if (destination.getParent() != null) {
            createToast(destination.getParent().getId(), list);
        }

    }

    @Override
    public Destination getCountry(Long id) {
        List<Destination> list = this.getToasts(id);

        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Destination getProvince(Long id) {

        //必须是国内的才设置省份

        List<Destination> list = this.getToasts(id);
        if (list != null && list.size() > 0) {
            //国外
            if (list.get(0).getId() != 1) {
                return null;
            }
        }

        if (list.size() > 1) {
            return list.get(1);
        }

       /* Destination destination = destinationMapper.selectByPrimaryKey(id);

        //国家
        if(destination.getDeep() == 1){
            return null;
        }

        //省份
        if (destination.getDeep() == 2){
            return destination;
        }


        //城市
        if (destination.getDeep() == 3){
            return destination.getParent();
        }*/


        return null;
    }

    @Override
    public List<Destination> list() {
        return destinationMapper.selectAll();
    }

    @Override
    public List<Destination> getHotDestByRegionId(Long regionId) {
        /**
         * 需求:根据热门区域查询目的地及其子目的地
         先不管国内,因为国内不一样
         ============>先根据区域id拿到对应的目的地的数组,再根据数组查询出目的地的集合,
         因为还要查子目的地,我们在用额外sql去查子目的地,得到子目的地的集合
         */
        //-1是查国内,意思就是查国内的地区以及子地区
        if (regionId == -1L) {
            List<Destination> list = destinationMapper.selectDestsByParentId(1L);
            return list;
        }
        //得到ref数组
        Region region = regionService.get(regionId);
        Long[] refIds = region.getRefIds();
        //根据数组去查目的地集合
        List<Destination> list = destinationMapper.queryByDestIds(refIds);

        return list;
    }

    @Override
    public void changeHotValue(Long id, int hot) {
        destinationMapper.updateHot(id, hot);
    }

    @Override
    public List<Destination> getToast2s(Long parentId) {
        List<Destination> list = new ArrayList<>();
        //如果当前id为空,没必要查
        if (parentId == -1) {
            return list;
        }
        this.getToast2(parentId, list);
        return list;
    }

    /**
     * 自己再做一遍的递归
     */
    public void getToast2(Long parentId, List<Destination> list) {

        //查询出当前目的地的信息,才能进行下一步看有没有上级,在进行查询
        Destination destination = destinationMapper.selectByPrimaryKey(parentId);
        list.add(0, destination);
        if (destination.getParent() != null) {
            getToast2(destination.getParent().getId(), list);
        }
    }

    @Override
    public void deleteById(Long id) {
        destinationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Destination getById(Long destId) {

        return destinationMapper.selectByPrimaryKey(destId);
    }



    @Override
    public Destination getByIdOfNameAndId(Long id) {
        return destinationMapper.selectByIdOfNameAndId(id);
    }


    /**
     * 根据酒住宿,查找到符合主题住宿的目的地集
     * @param themeId 酒店主题id
     * @return
     */
    @Override
    public List<Destination> getByHotelThemeId(Long themeId) {
        HotelTheme hotelTheme = hotelThemeServie.getHotelTheme(themeId);
        Long[] destIds = hotelTheme.getRefIds();
        //根据数组去查目的地集合
        List<Destination> list = destinationMapper.queryByDestIds(destIds);

        return list;
    }

    @Override
    public Destination getByDestName(String name) {
        return destinationMapper.selectByDestName(name);
    }

}
