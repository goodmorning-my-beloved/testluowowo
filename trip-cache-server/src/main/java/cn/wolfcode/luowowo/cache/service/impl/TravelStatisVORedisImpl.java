package cn.wolfcode.luowowo.cache.service.impl;

import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.cache.domain.TravelStatisVO;
import cn.wolfcode.luowowo.cache.service.ITravelStatisVOredisService;
import cn.wolfcode.luowowo.cache.util.RedisKeys;
import cn.wolfcode.luowowo.common.util.BeanUtil;
import cn.wolfcode.luowowo.common.util.DateUtil;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Override
    public boolean Thumbup(Long sid, Long id) {
        String key = RedisKeys.TRAVEL_STATIS_THUMBUP.join(sid.toString(), id.toString());
        if (!template.hasKey(key)) {
            //第一次或者已经失效
            Date endDate = DateUtil.getEndDate(new Date());
            long time = DateUtil.getDateBetween(endDate, new Date());
            template.opsForValue().set(key, "置顶", time, TimeUnit.SECONDS);
            //点赞数加一
            String voKey = RedisKeys.TRAVEL_STATIS_VO.join(Long.toString(sid));
            String uVO = template.opsForValue().get(voKey);

            TravelStatisVO VO = JSON.parseObject(uVO, TravelStatisVO.class);
            VO.setThumbsupnum(VO.getThumbsupnum() + 1);
            template.opsForValue().set(voKey, JSON.toJSONString(VO));
            return true;
        }
        //key已经存在,已经点赞(顶)
        return false;

    }

    @Override
    public TravelStatisVO selecttravelStatisVOById(Long sid) {
        String s = template.opsForValue().get(RedisKeys.TRAVEL_STATIS_VO.join(Long.toString(sid)));
        //如果不存在创建出来,
        if(s==null){
            TravelStatisVO travelStatisVO = new TravelStatisVO();
            Travel travel = travelService.selectById(sid);
            travelStatisVO.setTravelId(travel.getId());
            travelStatisVO.setViewnum(travel.getViewnum());
            travelStatisVO.setReplynum(travel.getReplynum());
            travelStatisVO.setFavornum(travel.getFavornum());
            travelStatisVO.setSharenum(travel.getSharenum());
            travelStatisVO.setThumbsupnum(travel.getThumbsupnum());
            //创建出来
            template.opsForValue().set(RedisKeys.TRAVEL_STATIS_VO.join(Long.toString(sid)),JSON.toJSONString(travelStatisVO));
            return travelStatisVO;
        }
        TravelStatisVO vo = JSON.parseObject(s, TravelStatisVO.class);
        return vo;
    }

    @Override
    public boolean favor(Long sid, UserInfo userInfo) {
        String key = RedisKeys.USER_TRAVEL_COOLECTION.join(String.valueOf(userInfo.getId()));
        //判断当前用户有没有收藏,?在用户的角度去查key有没有包含这个游记的id
        if(!template.hasKey(key)){
            //如果key不存在,表示该用户还没收藏任何游记,创建出来,并返回true
            List<Long> list=new ArrayList<>();
            list.add(sid);
            template.opsForValue().set(key,JSON.toJSONString(list));
            return true;
        }
        //如果存在
        //判断下这个用户里有没有这个id看看是否收藏过
        String sList = template.opsForValue().get(key);
        List<Long> list = JSON.parseArray(sList, Long.TYPE);
        if(list.contains(sid)){
            //取消收藏,减掉这个id,保存回去
            list.remove(sid);
            template.opsForValue().set(key,JSON.toJSONString(list));
            return false;
        }
        //不包含则是收藏操作,保存进去,在设置回去
        list.add(sid);
        template.opsForValue().set(key,JSON.toJSONString(list));
        return true;

    }

    @Override
    public List<Long> selectUserTravelCoolection(Long id) {
        String key = RedisKeys.USER_TRAVEL_COOLECTION.join(String.valueOf(id));
        //如果key不存在,表示,用户没有收藏任何游记
        if(!template.hasKey(key)){
            return new ArrayList<>();
        }
        //存在,查出来
        String sList = template.opsForValue().get(key);
        return JSON.parseArray(sList,Long.TYPE);

    }

    @Override
    public boolean selectISFavorByUId(Long travelid, Long userId) {
        if (userId == null) {
            return false;
        }
        String key = RedisKeys.USER_TRAVEL_COOLECTION.join(String.valueOf(userId));
        //如果redis不存在这个key
        if (!template.hasKey(key)) {
            return false;
        }
        String ulist = template.opsForValue().get(key);
        List<Long> list = JSON.parseArray(ulist, Long.TYPE);
        if (list.contains(travelid)) {
            return true;
        }
        return false;

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
