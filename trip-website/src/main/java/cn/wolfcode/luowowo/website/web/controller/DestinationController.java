package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.*;
import cn.wolfcode.luowowo.article.query.DestinationFilterQuery;
import cn.wolfcode.luowowo.article.query.StrategyCatalogQuery;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.article.service.*;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    @Reference
    private IDestinationCommendThemeService destinationCommendThemeService;
    @Reference
    private IDestinationFilterService destinationFilterService;

    @RequestMapping("")
    public Object index(Model model){
        model.addAttribute("hotRegions", regionService.queryHotRegions());

        List<DestinationCommendTheme> list = destinationCommendThemeService.selectAll();
        List<DestinationCommendTheme> yearSuitableList = new ArrayList<>();//全年适宜
        List<DestinationCommendTheme> seasonList = new ArrayList<>();//季节
        List<DestinationCommendTheme> wayTravelList = new ArrayList<>();//出行方式
        List<DestinationCommendTheme> holidayList = new ArrayList<>();//季节

        for (DestinationCommendTheme destinationCommendTheme : list) {
            if(destinationCommendTheme.getType()==0){
                yearSuitableList.add(destinationCommendTheme);
            }

            if(destinationCommendTheme.getType()==1){
                seasonList.add(destinationCommendTheme);
            }

            if(destinationCommendTheme.getType()==2){
                wayTravelList.add(destinationCommendTheme);
            }

            if(destinationCommendTheme.getType()==3){
                holidayList.add(destinationCommendTheme);
            }
        }

        model.addAttribute("yearSuitableList",yearSuitableList);
        model.addAttribute("seasonList",seasonList);
        model.addAttribute("wayTravelList",wayTravelList);
        model.addAttribute("holidayList",holidayList);
        return "destination/index";
    }

    @RequestMapping("/destFilter")
    public Object destFilter(Model model,@ModelAttribute("qo") DestinationFilterQuery qo){
        //根据主题id查询目的地推荐
        List<DestinationFilter> destinationFilterslist =  destinationFilterService.selectByThemeId(qo.getThemeId());
        model.addAttribute("destinationFilterslist",destinationFilterslist);

        PageInfo pageInfo = destinationFilterService.query(qo);
        model.addAttribute("pageInfo",pageInfo);

        List<DestinationCommendTheme> list = destinationCommendThemeService.selectAll();
        List<DestinationCommendTheme> yearSuitableList = new ArrayList<>();
        List<DestinationCommendTheme> seasonList = new ArrayList<>();//季节
        List<DestinationCommendTheme> wayTravelList = new ArrayList<>();//出行方式
        List<DestinationCommendTheme> holidayList = new ArrayList<>();//节假日

        for (DestinationCommendTheme destinationCommendTheme : list) {
            if(destinationCommendTheme.getType()==0){
                yearSuitableList.add(destinationCommendTheme);
            }

            if(destinationCommendTheme.getType()==1){
                seasonList.add(destinationCommendTheme);
            }

            if(destinationCommendTheme.getType()==2){
                wayTravelList.add(destinationCommendTheme);
            }

            if(destinationCommendTheme.getType()==3){
                holidayList.add(destinationCommendTheme);
            }
        }
        model.addAttribute("yearSuitableList",yearSuitableList);//全年适宜
        model.addAttribute("seasonList",seasonList);//季节
        model.addAttribute("wayTravelList",wayTravelList);//出行方式
        model.addAttribute("holidayList",holidayList);//节假日
        return "destination/destFilter";
    }

    //目的地筛选高查询
    @RequestMapping("/getlist")
    public Object getlist(Model model,@ModelAttribute("qo") DestinationFilterQuery qo){
        PageInfo pageInfo = destinationFilterService.query(qo);
        model.addAttribute("pageInfo",pageInfo);
        return "";
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
