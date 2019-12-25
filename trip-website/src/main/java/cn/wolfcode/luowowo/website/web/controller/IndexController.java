package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.query.TravelCommendQuery;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.article.service.IStrategyCommendService;
import cn.wolfcode.luowowo.article.service.ITravelCommendService;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.search.domain.DestinationTemplate;
import cn.wolfcode.luowowo.search.domain.StrategyTemplate;
import cn.wolfcode.luowowo.search.domain.TravelTemplate;
import cn.wolfcode.luowowo.search.domain.UserInfoTemplate;
import cn.wolfcode.luowowo.search.query.SearchQueryObject;
import cn.wolfcode.luowowo.search.service.*;
import cn.wolfcode.luowowo.search.vo.SearchResultVO;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Reference
    private ITravelCommendService travelCommendService;
    @Reference
    private IStrategyCommendService strategyCommendService;
    @Reference
    private ITravelService travelService;
    @Reference
    private ITravelSearchService travelSearchService;
    @Reference
    private IDestinationSearchService destinationSearchService;
    @Reference
    private IStrategySearchService strategySearchService;
    @Reference
    private IUserInfoSearchService userInfoSearchService;
    @Reference
    private ISearchService searchService;

    @RequestMapping("")
    @RequireLogin
    public Object index(Model model) {
        //tcs
        model.addAttribute("tcs", travelCommendService.queryTop(5));
        //sc
        model.addAttribute("sc", strategyCommendService.queryTop(1).get(0));
        return "index/index";
    }

    @RequestMapping("/index/travelPage")
    public String travelPage(Model model, @ModelAttribute("qo") TravelQuery qo) {

        model.addAttribute("pageInfo", travelService.query(qo));

        return "index/travelPageTpl";
    }

    @RequestMapping("/q")
    public String search(Model model,@ModelAttribute("qo") SearchQueryObject qo) {
        switch (qo.getType()) {
            case SearchQueryObject.SEARCH_TYPE_DEST:
                selectDest(qo,model);
                return "index/searchDest";
            case SearchQueryObject.SEARCH_TYPE_STRATEGY:
                selectstrategy(qo,model);
                return "index/searchStrategy";
            case SearchQueryObject.SEARCH_TYPE_TRAVEL:
                selectTravel(qo,model);
                return "index/searchTravel";
            case SearchQueryObject.SEARCH_TYPE_USER:
                selectUser(qo,model);
                return "index/searchUser";
            default:
                selectAll(qo,model);
                return "index/searchAll";
        }
    }

    private void selectDest(SearchQueryObject qo,Model model) {
        if(qo.getKeyword()!=null){
            DestinationTemplate dest = destinationSearchService.getByName(qo.getKeyword());
            SearchResultVO data = new SearchResultVO();
            if (dest != null) {
                List<StrategyTemplate> sts = strategySearchService.selectByDestName(dest.getName());
                List<TravelTemplate> tts = travelSearchService.selectByDestName(dest.getName());
                List<UserInfoTemplate> uts = userInfoSearchService.selectByDestName(dest.getName());
                data.setStrategys(sts);
                data.setTravels(tts);
                data.setUsers(uts);
                data.setTotal((long) (sts.size()+tts.size()+uts.size()+1));
                model.addAttribute("data",data);
                model.addAttribute("dest",dest);
            }
        }


    }

    private void selectstrategy(SearchQueryObject qo, Model model) {
        Page<StrategyTemplate> page = searchService.searchWithHighlight(StrategyTemplate.INDEX_NAME, StrategyTemplate.TYPE_NAME
                , StrategyTemplate.class, qo, "title", "subTitle", "summary");
        model.addAttribute("page",page);

    }

    private void selectTravel(SearchQueryObject qo, Model model) {
        Page<TravelTemplate> page = searchService.searchWithHighlight(TravelTemplate.INDEX_NAME, TravelTemplate.TYPE_NAME
                , TravelTemplate.class, qo, "title", "summary");
        model.addAttribute("page",page);
    }


    private void selectUser(SearchQueryObject qo, Model model) {
        Page<UserInfoTemplate> page = searchService.searchWithHighlight(UserInfoTemplate.INDEX_NAME, UserInfoTemplate.TYPE_NAME
                , UserInfoTemplate.class, qo, "nickname", "destName");
        model.addAttribute("page",page);
    }

    private void selectAll(SearchQueryObject qo, Model model) {

        Page<DestinationTemplate> dests = searchService.searchWithHighlight(DestinationTemplate.INDEX_NAME, DestinationTemplate.TYPE_NAME,
                DestinationTemplate.class, qo, "name", "info");
        Page<UserInfoTemplate> users = searchService.searchWithHighlight(UserInfoTemplate.INDEX_NAME, UserInfoTemplate.TYPE_NAME,
                UserInfoTemplate.class, qo, "nickname", "destName");
        Page<TravelTemplate> travels = searchService.searchWithHighlight(TravelTemplate.INDEX_NAME, TravelTemplate.TYPE_NAME,
                TravelTemplate.class, qo, "title", "summary");
        Page<StrategyTemplate> strategys = searchService.searchWithHighlight(StrategyTemplate.INDEX_NAME, StrategyTemplate.TYPE_NAME,
                StrategyTemplate.class, qo, "title", "subTitle","summary");

        SearchResultVO data = new SearchResultVO();
        data.setUsers(users.getContent());
        data.setTravels(travels.getContent());
        data.setStrategys(strategys.getContent());
        data.setDests(dests.getContent());
        data.setTotal(dests.getTotalElements() + users.getTotalElements() +travels.getTotalElements() +  strategys.getTotalElements());

        model.addAttribute("data", data);
    }




}
