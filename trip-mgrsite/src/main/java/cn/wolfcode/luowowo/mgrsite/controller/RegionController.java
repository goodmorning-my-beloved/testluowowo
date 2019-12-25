package cn.wolfcode.luowowo.mgrsite.controller;

import cn.wolfcode.luowowo.article.domain.Region;
import cn.wolfcode.luowowo.article.query.RegionQuery;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.IRegionService;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("region")
public class RegionController {


    @Reference
    private IRegionService regionService;

    @Reference
    private IDestinationService destinationService;

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo")RegionQuery qo){
        //pageInfo
        model.addAttribute("pageInfo", regionService.query(qo));

        return "region/list";

    }

    //查询层次目的地数据
    @RequestMapping("/getDestByDeep")
    @ResponseBody
    public Object getDestByDeep(int deep){
      return destinationService.getDestsByDeep(deep);

    }

    //区域关联目的地
    @RequestMapping("/getDestByRegionId")
    @ResponseBody
    public Object getDestByRegionId(Long rid){
       return destinationService.getDestByRegionId(rid);

    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Region region){

        regionService.saveOrUpdate(region);

        return AjaxResult.SUCCESS;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Long id){
        try {
            regionService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return  AjaxResult.FAIL;
        }

        return AjaxResult.SUCCESS;
    }


    @RequestMapping("/changeHotValue")
    @ResponseBody
    public Object changeHotValue(Long id,int hot){
        try {
            regionService.changeHotById(id,hot);
        }catch (Exception e){
            e.printStackTrace();
            return  AjaxResult.FAIL;
        }

        return AjaxResult.SUCCESS;
    }

















}
