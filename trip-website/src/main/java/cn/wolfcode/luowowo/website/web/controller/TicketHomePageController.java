package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.AttractionTicket;
import cn.wolfcode.luowowo.article.service.IAttractionTicketService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/homePage")
public class TicketHomePageController {

    @Reference
    private IAttractionTicketService attractionTicketService;

    @RequestMapping("/reloadSubAndProd")
    public Object reloadSubAndProd(Model model,Long ajaxDestId){

        List<AttractionTicket> list =  attractionTicketService.selectByDestId(ajaxDestId);
        model.addAttribute("list",list);
        return "/ticket/detailTpl";
    }
}
