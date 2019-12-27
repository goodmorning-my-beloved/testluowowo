package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.hotel.domain.Hotel;
import cn.wolfcode.luowowo.hotel.domain.HotelTheme;
import cn.wolfcode.luowowo.hotel.query.HotelQuery;
import cn.wolfcode.luowowo.hotel.service.IHotelService;
import cn.wolfcode.luowowo.hotel.service.IHotelThemeServie;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * 订酒店 ____首页
     * @param model
     * @return
     */
    @RequestMapping("")
    public Object hotel(Model model){
        /**
         *  hotelTags   酒店主题查询 todo
         *          查询数据库,罗列出(所有的?)酒店主题,封装集合,响应页面
         *
         */
        List<HotelTheme> hotelThemes = hotelThemeServie.queryHotelThemeOnly6();
        model.addAttribute("hotelTags",hotelThemes);

        /**
         * dest 国内目的地   overseas 海外目的地 todo
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
             * hotelCity  特价酒店城市查询 todo     热门城市的特价酒店
             *                                      游记比较多的城市就是热门城市,这些城市查询出来放到页面上去
             *          查询数据库,罗列出(所有的?)特价酒店城市,封装集合,响应页面
             */
            if(hotelCitys.size()<6){
                hotelCitys.add(destination);
            }
            if(destinationService.getToasts(destination.getId()).get(0).getId() == 1){
                if(dests.size()<11){
                    dests.add(destination);
                }
            }else{
                if(overseas.size()<11){
                    overseas.add(destination);
                }
            }
            if(dests.size()+overseas.size()==20){
                break;
            }
        }
        model.addAttribute("hotelCity",hotelCitys);
        model.addAttribute("dests",dests);
        model.addAttribute("overseas",overseas);
        return "hotel/hotel";
    }

    /**
     * 异步请求
     * list 主题关联酒店查询 todo
     *      根据页面请求的主题,查询对应的酒店内容,将酒店内容封装 ----> redis 主题酒店初始化
     *      使用 redis 技术,将对应的内容缓存起来,减少数据库压力  xxx 不做
     *      将封装结果响应到页面 hotelTpl.ftl 上
     *
     * @param id
     * @return
     */
    @RequestMapping("theme")
    public Object theme(Model model,Long id){
        List<Destination> list = destinationService.getByHotelThemeId(id);
        model.addAttribute("list",list);
        return "hotel/hotelTpl";
    }

    /**
     * 异步请求
     * hotelScore 关联酒店城市的特价酒店查询 todo
     * @param id  地点id
     * @return
     */
    @RequestMapping("theme1")
    public Object theme1(Model model,Long id){
        // 搜索地点下的酒店,酒店的价格要低于600元,查询出前8个,共享到页面
        List<Hotel> hotels = hotelService.querySpecialOfferHotelByDestIdTop8(id);
        model.addAttribute("hotelScore",hotels);
        return "hotel/hotelTpl1";
    }




    /**
     *
     * 由于技术限制,暂时选择使用mysql的方式查询
     * 搜索功能 todo
     *
     */
    @RequestMapping("/h")
    public Object goHotel(Model model, @ModelAttribute("qo") HotelQuery qo){
        PageInfo<Hotel> pageInfo = hotelService.queryHotelByCityNameAndSoOn(qo);
        List<Hotel> list = pageInfo.getList();
        model.addAttribute("hotel",list);
        return "222";
    }

}
