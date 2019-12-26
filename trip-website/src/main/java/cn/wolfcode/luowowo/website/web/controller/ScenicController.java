package cn.wolfcode.luowowo.website.web.controller;

import cn.woldcode.luowowo.scenic.domain.Scenic;
import cn.woldcode.luowowo.scenic.service.IScenicService;
import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("scenic")
public class ScenicController {

    @Reference
    private IScenicService scenicService;

    @Reference
    private IDestinationService destinationService;

    @RequestMapping("list")
    public String list(Model model, Long destId){
        // 面包屑
        List<Destination> toasts = destinationService.getToasts(destId);
        Destination destination = toasts.remove(toasts.size() - 1);
        model.addAttribute("toasts",toasts);
        model.addAttribute("dest",destination);

        // 必去景点top5  scenics_top5
        List<Scenic> scenics_top5 = scenicService.queryScenicTop5();
        model.addAttribute("scenics_top5", scenics_top5);

        // hotScenics 热门景点
        List<Scenic> hotScenics = scenicService.queryHotScenics();
        model.addAttribute("hotScenics", hotScenics);
        return "scenic/list";
    }
}
