package cn.wolfcode.luowowo.mgrsite.listener;

import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.service.IStrategyDetailService;
import cn.wolfcode.luowowo.cache.domain.StrategyStatisVO;
import cn.wolfcode.luowowo.cache.service.IStrategyStatisVOredisService;
import cn.wolfcode.luowowo.cache.util.RedisKeys;
import cn.wolfcode.luowowo.common.util.BeanUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * redis数据初始化监听器
 * contextRefreshedEvent 容器重新加载或者重新加载触发的事件
 */
//@Component
public class RedisDataInitListener implements ApplicationListener<ContextRefreshedEvent> {
    @Reference
    private IStrategyStatisVOredisService strategyStatisVOredisService;
    @Reference
    private IStrategyDetailService strategyDetailService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        //查出所有的攻略文章
        List<StrategyDetail> details = strategyDetailService.list();
        System.out.println("...................vo初始化数据开始.........................");
        for (StrategyDetail detail : details) {
            //判断redis中是否存在需要的vo
            boolean exist = strategyStatisVOredisService.isExist(detail.getId());
            if (exist) {
                //存在跳过
                continue;
            }
            System.out.println("--------------------vo初始化进行中-------------------------");
            //不存在就初始化数据
            StrategyStatisVO vo = new StrategyStatisVO();
            BeanUtil.copyProperties(vo, detail);
            vo.setStrategyId(detail.getId());
            vo.setDestId(detail.getDest().getId());
            vo.setDestName(detail.getDest().getName());
            strategyStatisVOredisService.save(vo);
        }
        System.out.println("...................vo初始化数据完成.........................");
        System.out.println("------------zset 数据初始化--------------------------");
        for (StrategyDetail detail : details){

            String value = RedisKeys.STRATEGY_STATIS_VO.join(detail.getId().toString());
            //参数1: zset的key   参数2:zset 的value
            if(strategyStatisVOredisService.isZsetHasValue(RedisKeys.STRATEGY_ZSET_SORT_HOT.getPrefix(), value)){
                continue;
            }
            //取浏览数+评论数
            int score = detail.getViewnum() + detail.getReplynum();
            strategyStatisVOredisService.addHotScores(value, score);
        }

        for (StrategyDetail detail : details){

            String value = RedisKeys.STRATEGY_STATIS_VO.join(detail.getId().toString());
            //参数1: zset的key   参数2:zset 的value
            if(strategyStatisVOredisService.isZsetHasValue(RedisKeys.STRATEGY_ZSET_SORT_COMMEND.getPrefix(), value)){
                continue;
            }
            //点赞数+收藏数
            int score = detail.getThumbsupnum() + detail.getFavornum();
            strategyStatisVOredisService.addCommendScores(value, score);
        }

        System.out.println("------------zset 数据初始化完成--------------------------");
    }
}
