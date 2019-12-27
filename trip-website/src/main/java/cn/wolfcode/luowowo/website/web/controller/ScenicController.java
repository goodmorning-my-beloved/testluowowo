package cn.wolfcode.luowowo.website.web.controller;

import cn.woldcode.luowowo.scenic.domain.Scenic;
import cn.woldcode.luowowo.scenic.query.ScenicQuery;
import cn.woldcode.luowowo.scenic.service.IScenicService;
import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.comment.service.IScenicCommentService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("scenic")
public class ScenicController {

    @Reference
    private IScenicService scenicService;

    @Reference
    private IDestinationService destinationService;

    @Reference
    private IScenicCommentService scenicCommentService;

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

    /**
     * 分页
     */
    @RequestMapping("/page")
    public String page(Model model, @ModelAttribute("qo")ScenicQuery qo){
        model.addAttribute("pageInfo", scenicService.page(qo));
        return "scenic/listTpl";
    }

    @RequestMapping("detail")
    public String detail(Model model, Long id){
        // 景点查询
        model.addAttribute("scenic", scenicService.queryScenicById(id));

        // id查询子景点
        List<Scenic> innerScenic = scenicService.queryScenicByParentId(id   );
        model.addAttribute("innerScenic", innerScenic);

        // 查评论
        model.addAttribute("comments", scenicCommentService.selectCommentByScenicId(id));

        return "scenic/detail";
    }
}
