package cn.wolfcode.luowowo.mgrsite.controller;

import cn.wolfcode.luowowo.article.domain.StrategyCatalog;
import cn.wolfcode.luowowo.article.domain.StrategyContent;
import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.query.StrategyDetailQuery;
import cn.wolfcode.luowowo.article.service.*;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("strategyDetail")
public class StrategyDetailController {

    @Reference
    private IStrategyDetailService strategyDetailService;

    @Reference
    private IDestinationService destinationService;

    @Reference
    private IStrategyService strategyService;

    @Reference
    private IStrategyThemeService strategyThemeService;

    @Reference
    private IStrategyCatalogService strategyCatalogService;

    @Reference
    private  IStrategyTagService strategyTagService;

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo")StrategyDetailQuery qo){
        //pageInfo
        model.addAttribute("pageInfo", strategyDetailService.query(qo));
        return "strategyDetail/list";
    }

    @RequestMapping("/input")
    public String input(Model model,Long id){
        //strategies
        model.addAttribute("strategies",strategyService.list());
        //themes
        model.addAttribute("themes",strategyThemeService.list());
        if(id!=null){
            StrategyDetail strategyDetail = strategyDetailService.get(id);
            strategyDetail.setStrategyContent(strategyDetailService.getContent(id));
            model.addAttribute("strategyDetail",strategyDetail);
            model.addAttribute("tags",strategyTagService.queryByDetailId(id));
        }
        return "strategyDetail/input";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(StrategyDetail detail,String tags){
        strategyDetailService.saveOrUpdate(detail,tags);
         return AjaxResult.SUCCESS;
    }

    @RequestMapping("/changeState")
    @ResponseBody
    public Object changeState(Long state,Long id){
        strategyDetailService.changeState(state,id);
        return AjaxResult.SUCCESS;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Long id){
        strategyDetailService.delete(id);
        return AjaxResult.SUCCESS;
    }


    @RequestMapping("/getCatalogByStrategyId")
    @ResponseBody
    public Object getCatalogByStrategyId(Long strategyId){
        List<StrategyCatalog> list=strategyCatalogService.selectCatalogByStrategyId(strategyId);
        return list;
    }

}
