package cn.wolfcode.luowowo.cache.service.impl;

import cn.wolfcode.luowowo.cache.domain.AnswerStatisVO;
import cn.wolfcode.luowowo.cache.service.IAnswerStatisVOService;
import cn.wolfcode.luowowo.cache.util.RedisKeys;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.member.service.IUserInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AnswerStatisVOServiceImpl implements IAnswerStatisVOService {

    @Autowired
    private StringRedisTemplate template;

    @Reference
    private IUserInfoService userInfoService;

    @Override
    public void replynumIncrease(String answerId,Long userId, int increase) {
        String key = RedisKeys.ANSWER_ZSET_SORT_REPLYNUM.getPrefix();
        this.numIncrease(answerId,userId,increase,key);
    }

    private void numIncrease(String answerId,Long userId, int increase ,String typeKey){
        UserInfo userInfo = userInfoService.get(userId);//查询出用户信息
        AnswerStatisVO vo = new AnswerStatisVO();
        vo.setCity(userInfo.getCity());
        vo.setHeadUrl(userInfo.getHeadImgUrl());
        //vo.setAnswerId(answerId);
        vo.setLevel(userInfo.getLevel());
        vo.setUserId(userInfo.getId());
        vo.setUsername(userInfo.getNickname());
        //无论key是否存在都可以添加添加进去
        template.opsForZSet().incrementScore(typeKey,
                JSON.toJSONString(vo),increase);
    }


    @Override
    public void medalnumIncrease(String answerId, Long userId, int increase) {
        this.numIncrease(answerId,userId,increase,RedisKeys.ANSWER_ZSET_SORT_MEDAL.getPrefix());
    }

    @Override
    public List<AnswerStatisVO> selectReplyRank() {
        //回复次数在redis中的key
        String key = RedisKeys.ANSWER_ZSET_SORT_REPLYNUM.getPrefix();
        Set<String> range = template.opsForZSet().reverseRange(key, 0, -1);
        List<AnswerStatisVO> replyRankList = new ArrayList<>();
        for (String voStr : range) {
            AnswerStatisVO vo = JSON.parseObject(voStr, AnswerStatisVO.class);
            Double score = template.opsForZSet().score(key, voStr);
            vo.setReplynum(score.intValue());
            replyRankList.add(vo);
        }
        return replyRankList;
    }

    @Override
    public List<AnswerStatisVO> selectMedalRankList() {
        String key = RedisKeys.ANSWER_ZSET_SORT_MEDAL.getPrefix();
        Set<String> range = template.opsForZSet().reverseRange(key, 0, -1);
        List<AnswerStatisVO> medalRankList = new ArrayList<>();
        for (String voStr : range) {
            AnswerStatisVO vo = JSON.parseObject(voStr, AnswerStatisVO.class);
            Double score = template.opsForZSet().score(key, voStr);
            vo.setMedalnum(score.intValue());
            medalRankList.add(vo);
        }
        return medalRankList;
    }

    @Override
    public void thumbsupnumIncrease(String answerId, long userId, int increase) {
        this.numIncrease(answerId,userId,increase,RedisKeys.ANSWER_ZSET_SORT_THUMBSUPNUM.getPrefix());
    }

    @Override
    public List<AnswerStatisVO> selectThumbsupRankList() {
        String key = RedisKeys.ANSWER_ZSET_SORT_THUMBSUPNUM.getPrefix();
        Set<String> range = template.opsForZSet().reverseRange(key, 0, -1);
        List<AnswerStatisVO> thumbsupRankList = new ArrayList<>();
        for (String voStr : range) {
            AnswerStatisVO vo = JSON.parseObject(voStr, AnswerStatisVO.class);
            Double score = template.opsForZSet().score(key, voStr);
            vo.setThumbsupnum(score.intValue());
            thumbsupRankList.add(vo);
        }
        return thumbsupRankList;
    }
}
