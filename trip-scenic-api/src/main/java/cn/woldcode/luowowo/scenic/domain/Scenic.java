package cn.woldcode.luowowo.scenic.domain;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Getter@Setter
public class Scenic extends BaseDomain {
    // 景点名
    private String name;

    // 景点英文名
    private String enName;

    // 景点介绍
    private String intro;

    // 景点电话
    private String tel;

    // 景点网址
    private String url;

    // 景点用时参考
    private String travelTime;

    // 景点交通内容
    private String content;

    // 景点门票
    private String ticketInfo;

    // 子景点
    private List<Scenic> children;

    // 上级景点 Id
    private String parentId;

    // 景点所在的目的地
    private Destination destination;

    // 景点封面
    private String coverUrl;

    private String[] coverUrls;

    // 景点点评数
    private String commentNum;

    // 景点标签
    private String tag;

    // 是否热门
    private boolean ishot;

    //从数据库拿出的coverUrl是一个字符串, 需要分割
    public String[] getCoverUrls(){
        String[] coverUrls = this.coverUrl.split(",");
        return coverUrls;
    }

}
