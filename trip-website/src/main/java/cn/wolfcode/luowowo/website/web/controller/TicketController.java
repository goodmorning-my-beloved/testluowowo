package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.AttractionTicket;
import cn.wolfcode.luowowo.article.domain.TicketDetail;
import cn.wolfcode.luowowo.article.domain.TicketOrder;
import cn.wolfcode.luowowo.article.service.IAttractionTicketService;
import cn.wolfcode.luowowo.article.service.ITicketDetailService;
import cn.wolfcode.luowowo.article.service.ITicketOrderService;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by acer on 2019/12/27.
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Reference
    private IAttractionTicketService attractionTicketService;
    @Reference
    private ITicketDetailService ticketDetailService;
    @Reference
    private ITicketOrderService ticketOrderService;

    @RequestMapping("")
    public Object index(Model model){
        List<AttractionTicket> list = attractionTicketService.selectAll();
        //当日可定票
        List<AttractionTicket> hotlist = new ArrayList<>();
        //城市列表
        List<AttractionTicket> destlist = new ArrayList<>();
        Set<Long> set = new HashSet<Long>();
        //主题
        List<AttractionTicket> themelist = new ArrayList<>();
        Set<Long> themeset = new HashSet<Long>();


        for (AttractionTicket attractionTicket : list) {
            if(attractionTicket.getState()==1){
                hotlist.add(attractionTicket);
            }

            //城市列表
            Long destId = attractionTicket.getDest().getId();
            if(!set.contains(destId)){
                set.add(destId);
                destlist.add(attractionTicket);
            }
            //主题
            Long themeId = attractionTicket.getTheme().getId();
            if(!themeset.contains(themeId)){
                themeset.add(themeId);
                themelist.add(attractionTicket);
            }

        }
        model.addAttribute("hotlist",hotlist);
        model.addAttribute("destlist",destlist);
        model.addAttribute("themelist",themelist);


        model.addAttribute("list",list);

        return "ticket/index";
    }
    @RequestMapping("/detail")
    public Object detail(Model model,Long tid){
        AttractionTicket ticketDetail = attractionTicketService.selectByPrimaryKey(tid);
        model.addAttribute("ticketDetail",ticketDetail);
        //ticketDetail
        TicketDetail ticketDetail1 = ticketDetailService.selectById(tid);
        model.addAttribute("ticketDetail",ticketDetail1);
        return "ticket/detail";
    }
    @RequestMapping("/addOrder")
    public Object addOrder(Model model,Long tid){
        //ticketDetail
        TicketDetail ticketDetail1 = ticketDetailService.selectById(tid);
        model.addAttribute("ticketDetail",ticketDetail1);
        //ticket
        AttractionTicket ticket = attractionTicketService.selectByPrimaryKey(tid);
        model.addAttribute("ticket",ticket);
        return "ticket/addOrder";
    }
    @RequestMapping("/pay")
    public Object pay(Model model, Long tid, @UserParam UserInfo userInfo){
        //id,哪个门票
        //uuid,订单号
        TicketDetail ticketDetail = ticketDetailService.selectById(tid);
        model.addAttribute("ticketDetail",ticketDetail);
        String uuid = UUID.randomUUID().toString();
        model.addAttribute("uuid",uuid);
        model.addAttribute("userInfo",userInfo);
        return "ticket/pay";
    }

    @RequestMapping("/ticketorder")
    @ResponseBody
    public Object ticketorder(TicketOrder ticketOrder){
        ticketOrderService.insert(ticketOrder);
        return AjaxResult.SUCCESS;
    }

   /* @RequestMapping("/test")
    public Object testindex(Model model){
        List<AttractionTicket> list = attractionTicketService.selectAll();
        //当日可定票
        List<AttractionTicket> hotlist = new ArrayList<>();
        //城市列表
        List<AttractionTicket> destlist = new ArrayList<>();
        Set<Long> set = new HashSet<Long>();
        //主题
        List<AttractionTicket> themelist = new ArrayList<>();
        Set<Long> themeset = new HashSet<Long>();


        for (AttractionTicket attractionTicket : list) {
            if(attractionTicket.getState()==1){
                hotlist.add(attractionTicket);
            }

            //城市列表
            Long destId = attractionTicket.getDest().getId();
            if(!set.contains(destId)){
                set.add(destId);
                destlist.add(attractionTicket);
            }
            //主题
            Long themeId = attractionTicket.getTheme().getId();
            if(!themeset.contains(themeId)){
                themeset.add(themeId);
                themelist.add(attractionTicket);
            }

        }
        model.addAttribute("hotlist",hotlist);
        model.addAttribute("destlist",destlist);
        model.addAttribute("themelist",themelist);


        model.addAttribute("list",list);

        return "ticket/testindex";
    }*/

}
