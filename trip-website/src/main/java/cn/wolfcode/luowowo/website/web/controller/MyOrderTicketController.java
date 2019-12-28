package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.AirTicket;
import cn.wolfcode.luowowo.article.domain.AirTicketOrder;
import cn.wolfcode.luowowo.article.service.IAirTicketOrderService;
import cn.wolfcode.luowowo.article.service.IAirTicketService;
import cn.wolfcode.luowowo.article.service.ITicketOrderService;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.hotel.domain.Hotel;
import cn.wolfcode.luowowo.hotel.service.IHotelRoomOrderService;
import cn.wolfcode.luowowo.hotel.service.IHotelService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MyOrderTicketController {

    @Reference
    private ITicketOrderService ticketOrderService;
    @Reference
    private IAirTicketOrderService airTicketOrderService;
    @Reference
    private IAirTicketService airTicketService;
    @Reference
    private IHotelService hotelService;
    @Reference
    private IHotelRoomOrderService hotelRoomOrderService;

    @RequestMapping("/mytivketorder")
    public String mytivketorder(Model model, @UserParam UserInfo userInfo){
        model.addAttribute("list",ticketOrderService.selectByUserId(userInfo.getId()));
        List<AirTicketOrder> airlist =  airTicketOrderService.selectByUserId(userInfo.getId());
        List<Long> ids = new ArrayList<>();

        for (AirTicketOrder airTicketOrder : airlist) {
            Long id = airTicketOrder.getAirticket().getId();
            ids.add(id);
        }

        /*List<AirTicket> airTicketsList =  airTicketService.selectByIds(ids);*/

       /* model.addAttribute("airTicketsList",airTicketsList);*/
        model.addAttribute("airlist",airlist);

        /* 酒店订单信息*/

        List<Hotel> hotels = hotelService.queryHotelDeatilInfomationByUserId(userInfo.getId());
        model.addAttribute("hotels",hotels);

        return "/personcenter/mytivketorder";
    }
    @RequestMapping("/deletemytivketorder")
    @ResponseBody
    public Object deletemytivketorder(Long id){
        ticketOrderService.deleteById(id);
        return AjaxResult.SUCCESS;
    }
    @RequestMapping("/deletemytivketorder1")
    @ResponseBody
    public Object deletemytivketorder1(Long id){
        airTicketOrderService.deleteByPrimaryKey(id);
        return AjaxResult.SUCCESS;
    }
    @RequestMapping("/deletemytivketorder2")
    @ResponseBody
    public Object deletemytivketorder2(Long id){
        hotelRoomOrderService.deleteByPrimaryKey(id);
        return AjaxResult.SUCCESS;
    }

}
