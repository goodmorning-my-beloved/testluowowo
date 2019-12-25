package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.AirTicket;
import cn.wolfcode.luowowo.article.service.IAirTicketService;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.data.elasticsearch.annotations.DateFormat.date;

@Controller
@RequestMapping("flight")
public class FlightController {

    @Reference
    private IAirTicketService airTicketService;

    @RequestMapping("")
    private String flightIndex(Model model){
        //hotFlights 航班城市
        // 查询热门航班的国内城市
        List<AirTicket> hotFlights = airTicketService.getStartSiteByIshot(null);
        model.addAttribute("hotFlights", hotFlights);

        //initialA
        // 查询拼音是abcde开头的热门航班城市
        String[] ABCDE = new String[]{"a", "b", "c", "d", "e"};
        List<AirTicket> initialA = airTicketService.getStartSiteByIshot(ABCDE);
        model.addAttribute("initialA", initialA);

        //initialF
        // 查询拼音是fghj开头的热门航班城市
        String[] FGHJ = new String[]{"f", "g", "h", "j"};
        List<AirTicket> initialF = airTicketService.getStartSiteByIshot(FGHJ);
        model.addAttribute("initialF", initialF);

        //initialK
        // 查询拼音是klmnp开头的热门航班城市
        String[] KLMNP = new String[]{"k", "l", "m", "n", "P"};
        List<AirTicket> initialK = airTicketService.getStartSiteByIshot(KLMNP);
        model.addAttribute("initialK", initialK);

        //initialQ
        // 查询拼音是qrstw开头的热门航班城市
        String[] QRSTW = new String[]{"q", "r", "s", "t", "w"};
        List<AirTicket> initialQ = airTicketService.getStartSiteByIshot(QRSTW);
        model.addAttribute("initialQ", initialQ);

        //initialX
        // 查询拼音是xyz开头的热门航班城市
        String[] XYZ = new String[]{"x", "y", "z"};
        List<AirTicket> initialX = airTicketService.getStartSiteByIshot(XYZ);
        model.addAttribute("initialX", initialX);

        return "flight/index";
    }

    @RequestMapping("/search")
    @ResponseBody
    public Object search(String orgCity, String dstCity,String depTime){
        List<AirTicket> list = airTicketService.search(orgCity,dstCity,depTime);
        return AjaxResult.SUCCESS.addData(list);
    }
}
