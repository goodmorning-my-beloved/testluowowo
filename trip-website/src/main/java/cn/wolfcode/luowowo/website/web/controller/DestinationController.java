package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.StrategyCatalog;
import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.query.StrategyCatalogQuery;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.article.service.*;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("destination")
public class DestinationController {

    @Reference
    private IRegionService regionService;
    @Reference
    private IDestinationService destinationService;
    @Reference
    private IStrategyCatalogService strategyCatalogService;
    @Reference
    private IStrategyDetailService strategyDetailService;
    @Reference
    private ITravelService travelService;

    @RequestMapping("")
    public Object index(Model model){
        model.addAttribute("hotRegions", regionService.queryHotRegions());
        return "destination/index";
    }

    @RequestMapping("getHotDestByRegionId")
    public Object getHotDestByRegionId(Long regionId,Model model){
        List<Destination> list=destinationService.getHotDestByRegionId(regionId);
        model.addAttribute("regionId",regionId);
        //2:拆分数据
        int size = list.size();
        if(size%2==0){
            model.addAttribute("leftDests",list.subList(0, size / 2 ) );
            model.addAttribute("rightDests",list.subList(size / 2 ,size ));
        }else{
            model.addAttribute("leftDests",list.subList(0, size / 2 + 1) );
            model.addAttribute("rightDests",list.subList(size / 2 + 1,size ));
        }
        //3:拼接html模板
        model.addAttribute("regionId", regionId);
        return "/destination/hotdestTpl";
    }

    @RequestMapping("guide")
    public Object guide(Long id,Model model){
        //面包屑
        List<Destination> toasts = destinationService.getToasts(id);
        Destination destination = toasts.remove(toasts.size() - 1);

        model.addAttribute("strategyDetails",strategyDetailService.queryDetailsTop3ByDestId(id));
        model.addAttribute("catalogs",strategyCatalogService.selectCatalogByDestId(id));
        model.addAttribute("toasts",toasts);
        model.addAttribute("dest",destination);
        return "/destination/guide";
    }

    @RequestMapping("surveyPage")
    public Object surveyPage(@ModelAttribute("qo") StrategyCatalogQuery qo, Model model){
        //面包屑
        List<Destination> toasts = destinationService.getToasts(qo.getDestId());
        //dest
        model.addAttribute("dest",destinationService.getById(qo.getDestId()));
        //catalogs
        model.addAttribute("catalogs",strategyCatalogService.selectCatalogByDestId(qo.getDestId()));
        model.addAttribute("toasts",toasts);
        return "/destination/survey";
    }

    @RequestMapping("/survey")
    public String survey(Model model, @ModelAttribute("qo")StrategyCatalogQuery  qo ){
        //catalogs  某个目的地下的分类集合
        model.addAttribute("catalogs",strategyCatalogService.selectCatalogByDestId(qo.getDestId()));
        //catalog  选中的分类
        StrategyCatalog catalog = strategyCatalogService.get(qo.getCatalogId());
        model.addAttribute("catalog",catalog);
        //detail  选中的分类下的第一个明细
        List<StrategyDetail> details = catalog.getDetails();
        if(details != null && details.size() >0){
            StrategyDetail detail = details.get(0);
            detail.setStrategyContent(strategyDetailService.getContent(detail.getId()));
            model.addAttribute("detail",detail);
        }

        return "destination/surveyTpl";
    }

    @RequestMapping("travels")
    public String travels(Model model, @ModelAttribute("qo") TravelQuery qo){
       //pageInfo
        model.addAttribute("pageInfo",travelService.queryForListByDestId(qo));
        return "destination/travelTpl";
    }

}
