package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Strategy;
import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.service.IStrategyDetailService;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.cache.service.IStrategyStatisVOredisService;
import cn.wolfcode.luowowo.cache.service.ITravelStatisVOredisService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserCollectionController {

    @Reference
    private IStrategyStatisVOredisService strategyStatisVOredisService;
    @Reference
    private IStrategyDetailService strategyDetailService;
    @Reference
    private ITravelStatisVOredisService travelStatisVOredisService;
    @Reference
    private ITravelService travelService;

    @RequestMapping("/travelcollection")
    @RequireLogin
    public String travelcollection(Model model,@UserParam UserInfo userInfo) {
        //用户信息
        model.addAttribute("user",userInfo);

        //用户游记收藏查询
        List<Long> travelList=travelStatisVOredisService.selectUserTravelCoolection(userInfo.getId());
        //去数据库里面查
        List<Travel> travels=new ArrayList<>();
        for (Long aLong : travelList) {
            travels.add(travelService.selectById(aLong));
        }
        model.addAttribute("travels",travels);



        //用户攻略收藏查询
        List<Long> strategyList=strategyStatisVOredisService.selectUserStrategyCoolection(userInfo.getId());
        //去数据库查
        List<StrategyDetail> strategies=new ArrayList<>();
        for (Long aLong : strategyList) {
            strategies.add(strategyDetailService.get(aLong));
        }
        model.addAttribute("strategies",strategies);
        return "personcenter/travelcollection";
    }
}
