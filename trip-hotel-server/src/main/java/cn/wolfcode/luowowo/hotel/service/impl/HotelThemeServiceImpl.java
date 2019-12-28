package cn.wolfcode.luowowo.hotel.service.impl;

import cn.wolfcode.luowowo.hotel.domain.HotelTheme;
import cn.wolfcode.luowowo.hotel.mapper.HotelThemeMapper;
import cn.wolfcode.luowowo.hotel.service.IHotelThemeServie;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelThemeServiceImpl implements IHotelThemeServie {
    @Autowired
    private HotelThemeMapper hotelThemeMapper;

    /**
     * 随机查询主题库中排前面的六个主题
     * @return
     */
    @Override
    public List<HotelTheme> queryHotelThemeOnly6() {
        return hotelThemeMapper.selectHotelThemeOnly6();
    }

    /**
     * 根据住宿主题id,查询主题
     * @param themeId
     * @return
     */
    @Override
    public HotelTheme getHotelTheme(long themeId) {
       return  hotelThemeMapper.selectByPrimaryKey(themeId);
    }

    /**
     * 查询目的地下酒店主题
     * @param destId
     * @return
     */
    @Override
    public List<HotelTheme> queryHotelThemeOnly6ByDestId(Long destId) {
        List<HotelTheme> list = new ArrayList<>();
        List<HotelTheme> selectAll = hotelThemeMapper.selectAll();
        for (HotelTheme hotelTheme : selectAll) {
            Long[] refIds = hotelTheme.getRefIds();
            for (Long refId : refIds) {
                if(refId.equals(destId)){
                    list.add(hotelTheme);
                    continue;
                }
            }
            if(list.size()==6){
                break;
            }
        }
        return list;
    }
}
