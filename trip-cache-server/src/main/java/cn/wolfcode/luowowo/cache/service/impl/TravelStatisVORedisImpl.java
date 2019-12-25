package cn.wolfcode.luowowo.cache.service.impl;

import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.cache.domain.TravelStatisVO;
import cn.wolfcode.luowowo.cache.service.ITravelStatisVOredisService;
import cn.wolfcode.luowowo.cache.util.RedisKeys;
import cn.wolfcode.luowowo.common.util.BeanUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

@Service
public class TravelStatisVORedisImpl implements ITravelStatisVOredisService {
    @Autowired
    private StringRedisTemplate template;//约定key跟value必须是String类型
    @Reference
    private ITravelService travelService;

    @Override
    public void viewnumIncrease(Long id) {
        String key = RedisKeys.TRAVEL_STATIS_VO.join(Long.toString(id));
        //判断key在redis中是否存在,
        if (keyisExists(key)) {
            //存在,加一
            String sVO = template.opsForValue().get(key);
            TravelStatisVO travelStatisVO = JSON.parseObject(sVO, TravelStatisVO.class);
            travelStatisVO.setViewnum(travelStatisVO.getViewnum() + 1);
            this.settravelVO(key, travelStatisVO);
        } else {
            //不存在,初始化,加一
            TravelStatisVO travelStatisVO = new TravelStatisVO();
            this.initTravelStatisVO(id,travelStatisVO);
            this.settravelVO(key, travelStatisVO);
        }

    }

    @Override
    public TravelStatisVO selectById(Long id) {
        String key = RedisKeys.TRAVEL_STATIS_VO.join(Long.toString(id));
        //判断key在redis中是否存在,
        if (keyisExists(key)) {
            //存在.查出来
            return getByKeyUtil(key);
        }
        //不存在.初始化
        TravelStatisVO travelStatisVO = new TravelStatisVO();
        this.initTravelStatisVO(id,travelStatisVO);
       return travelStatisVO;

    }

    @Override
    public void userTravelCommentAddNum(Long id) {
        //用户点评游记时,为这个用户保存一个点评数
        String key = RedisKeys.USER_TRAVEL_COMMENT.join(Long.toString(id));

        String sValue = template.opsForValue().get(key);
        if(sValue==null){
            //如果点评数不存在,创建出来,加1
            template.opsForValue().set(key,String.valueOf(1));
        }else{
        //如果存在,加一
        template.opsForValue().set(key,String.valueOf(Integer.parseInt(sValue)+1));
        }
    }

    @Override
    public int selectUserCommentNum(Long id) {
        //查询用户点评过的游记数
        String key = RedisKeys.USER_TRAVEL_COMMENT.join(Long.toString(id));
        String sNum = template.opsForValue().get(key);
        //如果是null,返回0
        if(sNum==null){
            return 0;
        }
        return Integer.parseInt(sNum);
    }

    public TravelStatisVO getByKeyUtil(String key){
        String s = template.opsForValue().get(key);
        return JSON.parseObject(s, TravelStatisVO.class);
    }

    public void initTravelStatisVO(Long id, TravelStatisVO travelStatisVO) {
        //从mysql中查出来
        Travel travel = travelService.selectById(id);
        BeanUtil.copyProperties(travelStatisVO, travel);
        travelStatisVO.setTravelId(travel.getId());
    }

    public void settravelVO(String key, TravelStatisVO travelStatisVO) {
        template.opsForValue().set(key, JSON.toJSONString(travelStatisVO));
    }

    public boolean keyisExists(String key) {
        return template.hasKey(key);
    }
}
