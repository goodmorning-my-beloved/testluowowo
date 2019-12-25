package cn.wolfcode.luowowo.mgrsite.jobs;


import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.service.IStrategyDetailService;
import cn.wolfcode.luowowo.article.vo.StrategyStatisPersistenceVO;
import cn.wolfcode.luowowo.cache.domain.StrategyStatisVO;
import cn.wolfcode.luowowo.cache.service.IStrategyStatisVOredisService;
import cn.wolfcode.luowowo.common.util.BeanUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * redis数据持久化
 */
@Component
public class RedisDataPersistenceJob {
    @Reference
    private IStrategyDetailService strategyDetailService;
    @Reference
    private IStrategyStatisVOredisService strategyStatisVOredisService;
    //秒 分 小时 月份中的日期 月份 星期中的日期 年份
    //0 0 0 1/1 *

    @Scheduled(cron="0/10 * * * * ?")
    public void redisDataPersistence(){
        System.out.println("===========开始持久化===================");
        //执行数据持久化
        //持久化DML的数据
        //获取攻略数据的持久化
        List<StrategyStatisVO> volist=strategyStatisVOredisService.listAll();
        //获取所有攻略统计对象
        //遍历,同时将这些数据update到数据库中
        for (StrategyStatisVO vo : volist) {
            StrategyStatisPersistenceVO pvo=new StrategyStatisPersistenceVO();
            BeanUtil.copyProperties(pvo,vo);
            strategyDetailService.updateStatis(pvo);
        }
        System.out.println("===========完成持久化===================");
    }
}
