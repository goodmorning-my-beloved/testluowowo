package cn.wolfcode.luowowo.cache.service.impl;

import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.service.IStrategyDetailService;
import cn.wolfcode.luowowo.cache.domain.StrategyStatisVO;
import cn.wolfcode.luowowo.cache.service.IStrategyStatisVOredisService;
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
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class StrategyStatisVORedisImpl implements IStrategyStatisVOredisService {

    public static final int STRATEGY_TYPE_VIEWNUM = 1;  //阅读量
    public static final int STRATEGY_TYPE_REPLYNUM = 2;  //回复量
    public static final int STRATEGY_TYPE_FAVORNUM = 3;  //收藏量
    public static final int STRATEGY_TYPE_SHARENUM = 4;  //分享量
    public static final int STRATEGY_TYPE_THUMBSUPNUM = 5;  //点赞量

    @Autowired
    private StringRedisTemplate template;//约定key跟value必须是String类型
    @Reference
    private IStrategyDetailService strategyDetailService;


    @Override
    public StrategyStatisVO viewnumIncrease(Long id, int increase, UserInfo userInfo) {
        return initIncrease(id,increase,STRATEGY_TYPE_VIEWNUM);
    }

    @Override
    public StrategyStatisVO replynumIncrease(Long detailId, int increase) {
        return initIncrease(detailId,increase,STRATEGY_TYPE_REPLYNUM);
    }

    @Override
    public boolean favor(Long sid, UserInfo userInfo) {
        //判断redis中是否存在key
        String key = RedisKeys.STRATEGY_STATIS_FAVOR.join(Long.toString(sid));
        List<Long> uids = null;
        StrategyStatisVO vo = null;
        if (template.hasKey(key)) {
            //存在
            //查当前用户有没有收藏
            String sUIds = template.opsForValue().get(key);
            uids = JSON.parseArray(sUIds, Long.TYPE);
            if (uids.contains(userInfo.getId())) {
                //取消收藏
                uids.remove(userInfo.getId());
                //收藏数减1
                favorUtil(sid,vo,-1,key,uids);
                return false;
            } else {
                //收藏
                uids.add(userInfo.getId());
                //收藏数加一
                favorUtil(sid,vo,1,key,uids);
                return true;
            }
        } else {
            //初始化
            uids = new ArrayList<>();
            uids.add(userInfo.getId());
            //收藏数加一
            favorUtil(sid,vo,1,key,uids);
            return true;
        }

    }



    @Override
    public boolean selectISFavorByUId(Long strategyID, Long userId) {
        if (userId == null) {
            return false;
        }
        String key = RedisKeys.STRATEGY_STATIS_FAVOR.join(Long.toString(strategyID));
        //如果redis不存在这个key
        if (!template.hasKey(key)) {
            return false;
        }
        String ulist = template.opsForValue().get(key);
        List<Long> list = JSON.parseArray(ulist, Long.TYPE);
        if (list.contains(userId)) {
            return true;
        }
        return false;
    }

    @Override
    public StrategyStatisVO selectStrategyStatisVOById(Long sid) {
        String s = template.opsForValue().get(RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(sid)));
        StrategyStatisVO vo = JSON.parseObject(s, StrategyStatisVO.class);
        return vo;

    }

    @Override
    public boolean Thumbup(Long sid, Long uid) {
        String key = RedisKeys.STRATEGY_STATIS_THUMBUP.join(sid.toString(), uid.toString());
        if (!template.hasKey(key)) {
            //第一次或者已经失效
            Date endDate = DateUtil.getEndDate(new Date());
            long time = DateUtil.getDateBetween(endDate, new Date());
            template.opsForValue().set(key, "置顶", time, TimeUnit.SECONDS);
            //点赞数加一
            String voKey = RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(sid));
            //todo 优化

            String uVO = template.opsForValue().get(voKey);
            StrategyStatisVO VO = JSON.parseObject(uVO, StrategyStatisVO.class);
            VO.setThumbsupnum(VO.getThumbsupnum() + 1);
            template.opsForValue().set(voKey, JSON.toJSONString(VO));
            return true;
        }
        //key已经存在,已经点赞(顶)
        return false;
    }

    @Override
    public boolean isExist(Long id) {
        String key = RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(id));
        return template.hasKey(key);
    }

    @Override
    public void save(StrategyStatisVO vo) {
        String key = RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(vo.getStrategyId()));
        template.opsForValue().set(key, JSON.toJSONString(vo));
    }

    @Override
    public List<StrategyStatisVO> listAll() {
        //redis命令: keys strategy_statis_vo + "*"
        //所有vo对象在redis里面key的集合
        String key = RedisKeys.STRATEGY_STATIS_VO.join("*");
        Set<String> keys = template.keys(key);
        List<StrategyStatisVO> list = new ArrayList<>();
        for (String s : keys) {
            String s1 = template.opsForValue().get(s);
            list.add(JSON.parseObject(s1, StrategyStatisVO.class));
        }
        return list;
    }

    @Override
    public List<StrategyStatisVO> hotCDsTop(int num) {
        String setKey = RedisKeys.STRATEGY_ZSET_SORT_HOT.getPrefix();
        Set<String> values = template.opsForZSet().reverseRange(setKey, 0, num);
        List<StrategyStatisVO> list = new ArrayList<>();
        if (values != null && values.size() > 0) {
            for (String value : values) {
                list.add(JSON.parseObject(template.opsForValue().get(value), StrategyStatisVO.class));
            }
        }
        return list;
    }

    @Override
    public void addHotScore(Long id, int num) {
        //判断key是否存在
        String setKey = RedisKeys.STRATEGY_ZSET_SORT_HOT.getPrefix();
        String sortValue = RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(id));
        template.opsForZSet().incrementScore(setKey, sortValue, num);
    }

    @Override
    public void addCommendScore(Long sid, int num) {
        String setKey = RedisKeys.STRATEGY_ZSET_SORT_COMMEND.getPrefix();
        String sortValue = RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(sid));
        template.opsForZSet().incrementScore(setKey, sortValue, num);
    }

    @Override
    public List<StrategyStatisVO> queryCommendList() {
        String setkey = RedisKeys.STRATEGY_ZSET_SORT_COMMEND.getPrefix();
        Set<String> values = template.opsForZSet().reverseRange(setkey, 0, -1);
        List<StrategyStatisVO> list = new ArrayList<>();
        if (values != null && values.size() > 0) {
            for (String value : values) {
                list.add(JSON.parseObject(template.opsForValue().get(value), StrategyStatisVO.class));
            }
        }
        return list;
    }

    @Override
    public boolean isZsetHasValue(String prefix, String value) {
        Long rank = template.opsForZSet().rank(prefix, value);
        return rank!=null;
    }

    @Override
    public void addHotScores(String value, int score) {
        String key = RedisKeys.STRATEGY_ZSET_SORT_HOT.getPrefix();
        template.opsForZSet().incrementScore(key,value,score);
    }

    @Override
    public void addCommendScores(String value, int score) {
        String key = RedisKeys.STRATEGY_ZSET_SORT_COMMEND.getPrefix();
        template.opsForZSet().incrementScore(key,value,score);
    }


    //抽取方法
    public StrategyDetail initStrategyStatisVO(Long id, StrategyStatisVO vo) {

        //3,如果不存在,创建vo对象,初始化相关属性
        vo = new StrategyStatisVO();
        //初始化
        StrategyDetail detail = strategyDetailService.get(id);
        vo.setViewnum(detail.getViewnum());
        vo.setReplynum(detail.getReplynum());
        vo.setFavornum(detail.getSharenum());
        vo.setThumbsupnum(detail.getThumbsupnum());
        return detail;
    }
    //参数1,文章id  参数二增加数
    private StrategyStatisVO initIncrease(Long id,int increase,int type){
        //判断对应的攻略的key是否存在
        Boolean key = template.hasKey(RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(id)));
        StrategyStatisVO vo = null;
        if (key) {
            // 2.如果存在,通过key获取vo对象对viewnum+1.并保存到redis
            String sVO = template.opsForValue().get(RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(id)));
            vo = JSON.parseObject(sVO, StrategyStatisVO.class);
            this.inncrease(vo,increase,type);
        } else {
            //3,如果不存在,创建vo对象,初始化相关属性,然后让viewnum+1,并保存到redis
            vo = new StrategyStatisVO();
            this.initStrategyStatisVO(id,vo);
            //初始化
            StrategyDetail detail = strategyDetailService.get(id);
            BeanUtil.copyProperties(vo, detail);
            vo.setDestName(detail.getDest().getName());
            vo.setDestId(detail.getDest().getId());
            vo.setStrategyId(detail.getId());
        }
        //存到redis中
        template.opsForValue().set(RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(id)), JSON.toJSONString(vo));
        return vo;
    }
    //增加的工具方法
    private void inncrease(StrategyStatisVO vo,int increaseNum,int type){
        switch (type){
            case STRATEGY_TYPE_VIEWNUM :
                vo.setViewnum(vo.getViewnum() + increaseNum); break;
            case STRATEGY_TYPE_REPLYNUM :
                vo.setReplynum(vo.getReplynum() + increaseNum); break;
            case STRATEGY_TYPE_FAVORNUM :
                vo.setFavornum(vo.getFavornum() + increaseNum); break;
            case STRATEGY_TYPE_THUMBSUPNUM :
                vo.setThumbsupnum(vo.getThumbsupnum() + increaseNum); break;
        }
    }
    //参数1文章id,参数2对象,参数3,增加或减少的数量,参数4key,参数5
    public void favorUtil(Long sid, StrategyStatisVO vo,int num, String key , List<Long> uids){
        String s = template.opsForValue().get(RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(sid)));
        vo = JSON.parseObject(s, StrategyStatisVO.class);
        vo.setFavornum(vo.getFavornum() +num);
        template.opsForValue().set(key, JSON.toJSONString(uids));
        template.opsForValue().set(RedisKeys.STRATEGY_STATIS_VO.join(Long.toString(sid)), JSON.toJSONString(vo));
    }
}
