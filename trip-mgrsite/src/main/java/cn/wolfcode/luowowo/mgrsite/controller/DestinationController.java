package cn.wolfcode.luowowo.mgrsite.controller;

import cn.wolfcode.luowowo.article.query.DestinationQuery;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("destination")
public class DestinationController {


    @Reference
    private IDestinationService destinationService;


    @RequestMapping("/list2")
    public String list(Model model, @ModelAttribute("qo")DestinationQuery qo){
        //pageInfo
        model.addAttribute("pageInfo",destinationService.query(qo));
        model.addAttribute("toasts", destinationService.getToasts(qo.getParentId()));

        return "destination/list";
    }
    @RequestMapping("/list")
    public String list2(Model model, @ModelAttribute("qo")DestinationQuery qo){

        //pageInfo
        model.addAttribute("pageInfo",destinationService.query(qo));
        model.addAttribute("toasts", destinationService.getToast2s(qo.getParentId()));
        return "destination/list";

    }

    @RequestMapping("/changeHotValue")
    @ResponseBody
    public Object changeHotValue(Long id,int hot){
        try {
            destinationService.changeHotValue(id,hot);
        }catch (Exception e){
            e.printStackTrace();
            return  AjaxResult.FAIL;
        }
        return AjaxResult.SUCCESS;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Long id){
        destinationService.deleteById(id);
        return AjaxResult.SUCCESS;
    }

    /*@RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Region region){



        return AjaxResult.SUCCESS;
    }*/

















}
