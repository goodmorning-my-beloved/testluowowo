package cn.wolfcode.luowowo.mgrsite.controller;

import cn.wolfcode.luowowo.article.domain.Strategy;
import cn.wolfcode.luowowo.article.query.StrategyQuery;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.IStrategyService;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("strategy")
public class StrategyController {

    @Reference
    private IStrategyService strategyService;

    @Reference
    private IDestinationService destinationService;




    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo")StrategyQuery qo){

        //pageInfo

        model.addAttribute("pageInfo", strategyService.query(qo));

        return "strategy/list";
    }


    @RequestMapping("/getDestByDeep")
    @ResponseBody
    public Object getDestByDeep(int deep){
        return destinationService.getDestsByDeep(deep);
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Strategy  strategy){

        strategyService.saveOrUpdate(strategy);

        return new AjaxResult();
    }

    @RequestMapping("/delete")
    public Object delete(long id){
       try {
           strategyService.deleteById(id);
       }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
       }
       return AjaxResult.SUCCESS;
    }

}
