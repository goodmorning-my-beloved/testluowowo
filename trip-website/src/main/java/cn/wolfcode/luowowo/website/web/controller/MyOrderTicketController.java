package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.service.ITicketOrderService;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyOrderTicketController {

    @Reference
    private ITicketOrderService ticketOrderService;

    @RequestMapping("/mytivketorder")
    public String mytivketorder(Model model, @UserParam UserInfo userInfo){
        model.addAttribute("list",ticketOrderService.selectByUserId(userInfo.getId()));
        System.out.println(ticketOrderService.selectByUserId(userInfo.getId()).get(0));
        return "/personcenter/mytivketorder";
    }
    @RequestMapping("/deletemytivketorder")
    @ResponseBody
    public Object deletemytivketorder(Long id){
        ticketOrderService.deleteById(id);
        return AjaxResult.SUCCESS;
    }

}
