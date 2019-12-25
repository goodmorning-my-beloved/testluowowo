package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.IStrategyDetailService;
import cn.wolfcode.luowowo.article.service.IStrategyTagService;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.comment.service.IStrategyCommentService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.member.service.IUserInfoService;
import cn.wolfcode.luowowo.search.domain.DestinationTemplate;
import cn.wolfcode.luowowo.search.domain.StrategyTemplate;
import cn.wolfcode.luowowo.search.domain.TravelTemplate;
import cn.wolfcode.luowowo.search.domain.UserInfoTemplate;
import cn.wolfcode.luowowo.search.service.IDestinationSearchService;
import cn.wolfcode.luowowo.search.service.IStrategySearchService;
import cn.wolfcode.luowowo.search.service.ITravelSearchService;
import cn.wolfcode.luowowo.search.service.IUserInfoSearchService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataController {

    @Reference
    private IStrategyCommentService  strategyCommentService;
    @Reference
    private IUserInfoSearchService userInfoSearchService;
    @Reference
    private IStrategyDetailService strategyDetailService;
    @Reference
    private IStrategyTagService strategyTagService;
    @Reference
    private IDestinationService destinationService;
    @Reference
    private IStrategySearchService strategySearchService;
    @Reference
    private IUserInfoService userInfoService;
    @Reference
    private ITravelService travelService;
    @Reference
    private IDestinationSearchService destinationSearchService;
    @Reference
    private ITravelSearchService travelSearchService;

    @RequestMapping("initdata")
    @ResponseBody
    public Object save(){

        ///攻略----------------------------------------------------------------------------
       /* List<StrategyDetail> all = strategyDetailService.list();
        for (StrategyDetail detail : all) {
            StrategyTemplate t = new StrategyTemplate();

            t.setId(detail.getId());
            t.setTitle(detail.getTitle());
            t.setSubTitle(detail.getSubTitle());
            t.setDestId(detail.getDest().getId());
            t.setDestName(detail.getDest().getName());
            t.setThemeId(detail.getTheme().getId());
            t.setThemeName(detail.getTheme().getName());
            t.setSummary(detail.getSummary());
            t.setCreateTime(detail.getCreateTime());
            t.setViewnum(detail.getViewnum());
            t.setFavornum(detail.getFavornum());
            t.setReplynum(detail.getReplynum());
            t.setThumbsupnum(detail.getThumbsupnum());

            t.setCoverUrl(detail.getCoverUrl());

          *//*  List<String> list = strategyTagService.getTagsBySDetailId(detail.getId());
            t.setTags(list);*//*

            Destination dest = destinationService.getCountry(detail.getDest().getId());

            t.setCountryId(dest.getId());
            t.setCountryName(dest.getName());
            dest = destinationService.getProvince(detail.getDest().getId());
            if(dest != null){
                t.setProvinceId(dest.getId());
                t.setProvinceName(dest.getName());
            }

            strategySearchService.saveOrUpdate(t);
        }
*/
        //用户----------------------------------------------------------------------------
       /* List<UserInfo> us = userInfoService.list();
        for (UserInfo u : us) {
            UserInfoTemplate tt = new UserInfoTemplate();
            tt.setId(u.getId());
            tt.setDestName(u.getCity());
            tt.setFansnum(11);
            tt.setHeadUrl(u.getHeadImgUrl());
            tt.setInfo(u.getInfo());
            tt.setLevel(u.getLevel());
            tt.setNickname(u.getNickname());
            tt.setReplynum(10);
            tt.setTravelnum(2);
            userInfoSearchService.saveOrUpdate(tt);
        }
*/
        ///游记----------------------------------------------------------------------------
        List<Travel> ts = travelService.list();

        for (Travel t : ts) {
            TravelTemplate tt = new TravelTemplate();
            tt.setId(t.getId());
            tt.setAuthorId(t.getAuthor().getId());
            tt.setAuthorName(t.getAuthor().getNickname());
            tt.setCoverUrl(t.getCoverUrl());
            tt.setCreateTime(t.getCreateTime());
            tt.setDestId(t.getDest().getId());
            tt.setDestName(t.getDest().getName());
            tt.setReplynum(t.getReplynum());
            tt.setSummary(t.getSummary());
            tt.setTitle(t.getTitle());
            tt.setViewnum(t.getViewnum());
            travelSearchService.save(tt);
        }

        //目的地----------------------------------------------------------------------------
      /*  List<Destination> ds = destinationService.list();

        for (Destination d : ds) {

            DestinationTemplate tt = new DestinationTemplate();

            tt.setId(d.getId());
            tt.setCoverUrl(d.getCoverUrl());
            tt.setName(d.getName());
            tt.setInfo(d.getInfo());
            destinationSearchService.save(tt);
        }
*/

        return "ok";
    }


}
