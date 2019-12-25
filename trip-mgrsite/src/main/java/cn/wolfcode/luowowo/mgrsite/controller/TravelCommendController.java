package cn.wolfcode.luowowo.mgrsite.controller;

import cn.wolfcode.luowowo.article.query.TravelCommendQuery;
import cn.wolfcode.luowowo.article.service.ITravelCommendService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("travelCommend")
public class TravelCommendController {

    @Reference
    private ITravelCommendService travelCommendService;
    @RequestMapping("/list")
    public String commend(Model model, @ModelAttribute("qo")TravelCommendQuery qo){
        model.addAttribute("pageInfo",travelCommendService.query(qo));
        return "travelCommend/list";  //TODO
    }

}
