package cn.wolfcode.luowowo.mgrsite.controller;

import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.article.service.ITravelService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("travel")
public class TravelController {

    @Reference
    private ITravelService travelService;

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo")TravelQuery qo){

        model.addAttribute("pageInfo", travelService.query(qo));
        return "travel/list";  //TODO
    }




}
