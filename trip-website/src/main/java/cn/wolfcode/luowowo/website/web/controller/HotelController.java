package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.common.exception.LogicException;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.hotel.domain.*;
import cn.wolfcode.luowowo.hotel.query.HotelQuery;
import cn.wolfcode.luowowo.hotel.service.*;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Reference
    private IHotelService hotelService;

    @Reference
    private IDestinationService destinationService;
    @Reference
    private ITravelService travelService;
    @Reference
    private IHotelThemeServie hotelThemeServie;
    @Reference
    private IHotelRegionService hotelRegionService;
    @Reference
    private IHotelRoomTypeService hotelRoomTypeService;
    @Reference
    private IHotelRoomOrderService hotelRoomOrderService;

    /**
     * 订酒店 ____首页
     * @param model
     * @return
     */
    @RequestMapping("")
    public Object hotel(Model model) {
        /**
         *  hotelTags   酒店主题查询
         *          查询数据库,罗列出(所有的?)酒店主题,封装集合,响应页面
         *
         */
        List<HotelTheme> hotelThemes = hotelThemeServie.queryHotelThemeOnly6();
        model.addAttribute("hotelTags", hotelThemes);

        /**
         * dest 国内目的地   overseas 海外目的地
         *  .可以给予用户快速推荐的几个地区,用户可选可不选
         *      国内出行目的地应该让我们联想到出行旅游,之所以给用户推荐,是为方便用户.那么我们以什么为判断
         *      哪些地区是热门地区呢?此处 jkun 认为应该以游记关联的 用户浏览数 多寡来判断,游记集中描述的地区,应该
         *      是热点地区,推荐给用户热点地区,才能真正意义上实现推荐地区的功能.
         *  // 使用 redis 技术                                            XXXX不做
         *       先将游记的 的信息全部初始化到 redis 当中.                XXXX不做
         *  // 从 redis 当中查询浏览数排前面 的游记id                     XXXX不做
         *  // 根据游记id,查询出关联十个国内目的地的id
         *  // 根据游记id,查询出关联十个国外目的地的id
         *  // 根据目的地 查询出国内外目的地的集合,传送到页面
         *
         */
        // 按目的地分组,再查出每一组的最高阅读量,进行组的排行,获得排行靠前十的游记
        List<Travel> travels = travelService.getHotTravelsByViewnum();
        List<Destination> dests = new ArrayList<>();
        List<Destination> overseas = new ArrayList<>();
        List<Destination> hotelCitys = new ArrayList<>();
        for (Travel travel : travels) {
            Destination destination = destinationService.getByIdOfNameAndId(travel.getDest().getId());
            /**
             * hotelCity  特价酒店城市查询      热门城市的特价酒店
             *                                      游记比较多的城市就是热门城市,这些城市查询出来放到页面上去
             *          查询数据库,罗列出(所有的?)特价酒店城市,封装集合,响应页面
             */
            if (hotelCitys.size() < 6) {
                hotelCitys.add(destination);
            }
            if (destinationService.getToasts(destination.getId()).get(0).getId() == 1) {
                if (dests.size() < 11) {
                    dests.add(destination);
                }
            } else {
                if (overseas.size() < 11) {
                    overseas.add(destination);
                }
            }
            if (dests.size() + overseas.size() == 20) {
                break;
            }
        }
        model.addAttribute("hotelCity", hotelCitys);
        model.addAttribute("dests", dests);
        model.addAttribute("overseas", overseas);
        return "hotel/hotel";
    }

    /**
     * 异步请求
     * list 主题关联酒店查询
     *      根据页面请求的主题,查询对应的酒店内容,将酒店内容封装 ----> redis 主题酒店初始化
     *      使用 redis 技术,将对应的内容缓存起来,减少数据库压力  xxx 不做
     *      将封装结果响应到页面 hotelTpl.ftl 上
     *
     * @param id
     * @return
     */
    @RequestMapping("theme")
    public Object theme(Model model, Long id) {
        List<Destination> list = destinationService.getByHotelThemeId(id);
        model.addAttribute("list", list);
        return "hotel/hotelTpl";
    }

    /**
     * 异步请求
     * hotelScore 关联酒店城市的特价酒店查询
     * @param id  地点id
     * @return
     */
    @RequestMapping("theme1")
    public Object theme1(Model model, Long id) {
        // 搜索地点下的酒店,酒店的价格要低于600元,查询出前8个,共享到页面
        List<Hotel> hotels = hotelService.querySpecialOfferHotelByDestIdTop8(id);
        model.addAttribute("hotelScore", hotels);
        return "hotel/hotelDetailTpl";
    }


    /**
     *
     * 由于技术限制,暂时选择使用mysql的方式查询
     * 首页搜索功能 todo
     *  根据目的地 查询相关信息并跳转页面
     */
    @RequestMapping("/h")             // 回显搜索条件
    public Object goHotel(Model model, @ModelAttribute("qo") HotelQuery qo) {
//        if(qo.getName()==null){
//            throw new LogicException("请输入地名");
//        }
        // 根据输入地名,查询详细目的地信息
        Destination theSearchDest = destinationService.getByDestName(qo.getName());
        model.addAttribute("theSearchDest", theSearchDest);
        qo.setDestId(theSearchDest.getId());
        Long destId = theSearchDest.getId();
        // 面包屑
        List<Destination> toasts = destinationService.getToasts(destId);
        model.addAttribute("toasts", toasts);
        // 查询目的地的下级地区   todo  查询区域表,将区域的各信息共享到页面上
        List<HotelRegion> hotelRegions = hotelRegionService.queryAllHotelRegionByDestId(destId);
        model.addAttribute("hotelRegions", hotelRegions);
        // 查询出目的地的info介绍
//        Destination theSearchDest = toasts.get(toasts.size() - 1);
//        model.addAttribute("theSearchDest",theSearchDest);
        // 查询酒店主题
        List<HotelTheme> hotelThemes = hotelThemeServie.queryHotelThemeOnly6ByDestId(theSearchDest.getId());
        model.addAttribute("hotelThemes", hotelThemes);

        return "hotel/dingjiudian";
    }


    /**
     * 异步请求,查询酒店信息
     * @param model
     * @param qo
     * @return
     */
    @RequestMapping("/checkHotel")
    public Object checkHotel(Model model, @ModelAttribute("qo") HotelQuery qo, @UserParam UserInfo userInfo) {
        model.addAttribute("userInfo",userInfo);
        PageInfo<Hotel> pageInfo = hotelService.queryHotelByCityNameAndSoOn(qo); // 查时间
        List<Hotel> list = pageInfo.getList();
        for (Hotel hotel : list) {
            List<HotelRoomType> hotelRoomTypes = hotelRoomTypeService.queryHotelRoomTypeByHotelId(hotel.getId());
            for (HotelRoomType hotelRoomType : hotelRoomTypes) {
                Boolean flag = hotelRoomOrderService.checkSoldOut(qo, hotelRoomType);
                hotelRoomType.setTool(flag);
            }
            hotel.setTool(hotelRoomTypes);
        }
        model.addAttribute("hotel", list);
        model.addAttribute("pageInfo", pageInfo);
        return "hotel/hotelIntroTPL";
    }

    @RequestMapping("/takeOrder")
    @ResponseBody
    public Object takeOrder(HotelRoomOrder hotelRoomOrder) {
        hotelRoomOrderService.save(hotelRoomOrder);
        return AjaxResult.SUCCESS;
    }
    /**
     * 根据 酒店区域id,查询区域的详细信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/queryHotelRegion")
    public String queryHotelRegion(Model model, Long id, Long destId) {
        if (id == -1) {
            Destination region = destinationService.getById(destId);
            model.addAttribute("region", region);
        } else {
            HotelRegion region = hotelRegionService.getByPrimaryId(id);
            model.addAttribute("region", region);
            model.addAttribute("flag", 1);
        }
        return "hotel/hotelRegionDetail";
    }

//    /**
//     * 根据酒店id,获得酒店信息,跳转酒店页面
//     * @param model
//     * @param id
//     * @return
//     */
//    @RequestMapping("/hotelInfo")
//    public Object hotelInfo(Model model, Long id) {
//        Hotel hotel = hotelService.getHotelInfoByPrimaryKey(id);
//        List<Destination> toasts = destinationService.getToasts(hotel.getDestId());
//        model.addAttribute("toasts", toasts);
//        return "hotel/oneHotel";
//    }


}
