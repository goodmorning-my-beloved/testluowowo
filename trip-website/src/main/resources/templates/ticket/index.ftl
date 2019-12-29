<!DOCTYPE html>
<html>

<script charset="utf-8" src="https://tag.baidu.com/vcard/v.js?siteid=651156&amp;url=http%3A%2F%2Fticket.lvmama.com%2F&amp;source=http%3A%2F%2Fwww.lvmama.com%2F%3Flosc%3D017878%26cm_mmc%3Dbaidu-_-cpt-_-zhuanqu-_-pc%26utm_source%3Dbaidu%26utm_medium%3Dzhuanqu%26utm_campaign%3Dpc&amp;rnd=1174736218&amp;hm=1"></script>
<script type="text/javascript" async="" src="http://static.mediav.com/mv.js"></script>
<script type="text/javascript" async="" src="http://material.mediav.com/bjjs/mba.js"></script>
<script src="http://push.zhanzhang.baidu.com/push.js"></script>
<script type="text/javascript" async="" src="//static.w3t.cn/fx/1/1/fx.js"></script>
<script type="text/javascript" async="" src="http://static.mediav.com/mvl.js"></script>
<script src="//hm.baidu.com/hm.js?cb09ebb4692b521604e77f4bf0a61013"></script>
<script async="" src="https://www.google-analytics.com/analytics.js"></script>
<script type="text/javascript" src="https://pics.lvjs.com.cn/mobile/lib/src/bdcTrace/dist/bdctrace-pc.js"></script>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="/styles/base.css" rel="stylesheet" type="text/css">
    <link href="/styles/index.css" rel="stylesheet" type="text/css">
    <link href="/js/plugins/jqPaginator/jqPagination.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-form/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jqPaginator/jq-paginator.min.js"></script>
    <script type="text/javascript" src="/js/system/index.js"></script>

    <meta charset="utf-8">
    <meta name="mobile-agent" content="format=html5; url=http://m.lvmama.com/ticket/">
    <link rel="dns-prefetch" href="//s1.lvjs.com.cn">
    <link rel="dns-prefetch" href="//s2.lvjs.com.cn">
    <link rel="dns-prefetch" href="//s3.lvjs.com.cn">
    <title>景点门票_景区门票预订_旅游门票价格,在线预订_骡窝窝旅游网</title>
    <meta name="keywords" content="门票预订,门票价格,门票推荐,门票预订">
    <meta name="description" content="驴妈妈旅游网(www.lvmama.com)-提供国内各大知名旅游景点打折门票预订,想要了解各大知名景区门票信息，购买到最优惠的 景区特价门票，请上驴妈妈旅游网门票预订频道.">
    <script async="" src="https://pics.lvjs.com.cn/js/common/sa-sdk-javascript-1.12.9/sensorsdata.min.js" charset="UTF-8"></script>
    <script src="//www.lvmama.com/2019homePage/getSensorsJs.do"></script>
    <link rel="canonical" href="http://ticket.lvmama.com/">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/channel/ticket/v1/ticket.css,/styles/lv/buttons.css,/styles/v5/modules/tip.css">

    <script type="text/javascript" src="//www.lvmama.com/2017index/ztRecommendInfoJson.do?blockId=219944&amp;station=superScript&amp;callback=success_jsoncallback"></script>
    <script src="//www.lvmama.com/php-seo/ads/ex?dest_id=229&amp;channel_id=10&amp;place_id=13&amp;jsonpCallback=jsonpCallback&amp;v=07256429595185749"></script>
    <script language="javascript" type="text/javascript" src="https://libs.de.coremetrics.com/configs/52710000.js"></script>
    <script>
        $(function () {
            //查询
            $("#_j_index_search_btn_all").click(function () {
                var type = $(".tab-selected").data("index");
                $("#searchType").val(type);
                $("#kwSearchForm").submit();
            })


            //默认游记list
            $("#searchForm").ajaxForm(function (data) {
                $("#_j_tn_content").html(data);
            });
            $("#searchForm").submit();

            //排序
            $(".orderTypeBtn").click(function () {
                $(this).closest("li").addClass("active");
                var type = $(this).data("type");
                $("#currentPage").val(1);
                $("#orderType").val(type);
                $("#searchForm").submit();
            });

        })


    </script>

</head>


<body class="ticket ticketChannel">
    <#assign currentNav="ticket">
    <#include "../common/navbar.ftl">

    <!-- 主体内容 -->
    <div class="wrap">
        <!-- 周末促销  开始 -->
        <div class="main_box">
            <h3 class="main_tit">
                打响周末
            </h3>
            <div class="main_content_box clearfix main_weekend weekend_js promotion_start">
                <div class="main_content_l">
                    <div class="promotion_l_bg">
                        <img src="http://pic.lvmama.com/uploads/pc/place2/2017-07-14/265cb99b-8bdb-4149-9eb2-5fd4d8c92b62.jpg" width="222" height="242" alt="">
                    </div>
                    <div class="promotion_weekend_time" style="display: none">
                        还有 <span id="weekend_time" data-time="19323000"><i>05</i>：<i>17</i>：<i>01</i></span> <samp>结束</samp>
                    </div>
                    <a href="http://s.lvmama.com/ticket/F1K440100?keyword=%E5%B9%BF%E5%B7%9E&amp;tabType=ticket#list" target="_blank" onclick="cmcTag('门票频道页-PC-站点-P2-打响周末-查看活动详情','PC门票频道页导航');">查看活动详情&gt;</a>
                </div>
                <ul class="promotion_list">
                    <#list hotlist as list>
                    <li>
                        <a href="/ticket/detail?tid=${list.id}" target="_blank" onclick="cmcTag('门票频道页-PC-站点-P2-打响周末-001-${list.name}','PC门票频道页导航');">
                            <div class="promotion_img_box">
                                <img src="${list.coverUrl}" width="222" height="150" alt="">
                                <span class="promotion_tag">可订今日票</span>
                                <p class="promotion_comment ticket_icon">${list.praisenum}% 好评</p>
                            </div>

                            <div class="promotion_footer">
                                <h5 title="${list.name}">${list.name}</h5>
                                <span class="btn btn-big btn-orange" href="/ticket/detail?tid=${list.id}" target="_blank">抢购</span>
                                <p><span>¥<dfn>${list.price}</dfn></span><samp>起</samp></p>
                            </div>
                        </a>
                    </li>
                    </#list>
                </ul>
            </div>
        </div>
        <!-- 周末促销  结束 -->











        <!-- 景点推荐 开始 -->
        <div class="main_box">
            <h3 class="main_tit">景点推荐<a id="smartShelfUrl" href="javascript:void(0);">查看更多<span>&gt;</span></a></h3>
            <div class="main_content_box main_recommend clearfix">

                <ul class="recommend_tab_t">
                    <#list destlist as list>
                    <li class="city_js active" data="${list.dest.id}" data2="">${list.dest.name}</li>

                    <#--<li class="city_js" data="231" data2="">深圳</li>
                    <li class="city_js" data="232" data2="">珠海</li>
                    <li class="city_js" data="234" data2="">佛山</li>
                    <li class="city_js" data="245" data2="">清远</li>
                    <li class="city_js" data="240" data2="">惠州</li>
                    <li class="city_js" data="246" data2="">东莞</li>-->
                    </#list>
                </ul>

                <!-- 主题列表 -->
                <div class="recommend_list_content" style="display: block;">
                    <div class="main_content_l ticket_icon">
                        <ul class="recommend_tab_l">
                            <#list themelist as list>
                            <li class="active subject_js" data="${list.theme.id}">${list.theme.name}<i class="ticket_icon"></i></li>
                            </#list>
                           <#-- <li class=" subject_js" data="3">温泉<i class="ticket_icon"></i></li>
                            <li class=" subject_js" data="9">动植物园<i class="ticket_icon"></i></li>
                            <li class=" subject_js" data="10">都市观光<i class="ticket_icon"></i></li>
                            <li class=" subject_js" data="1531">水乡古镇<i class="ticket_icon"></i></li>
                            <li class=" subject_js" data="43">登山徒步<i class="ticket_icon"></i></li>
                            <li class=" subject_js" data="1538">湖光山色<i class="ticket_icon"></i></li>
                            <li class=" subject_js" data="11">田园度假<i class="ticket_icon"></i></li>-->
                        </ul>
                    </div>
                    <#list list as l>
                    <ul class="promotion_list clearfix" style="display: block;">


                                <#--推荐门票-->
                                <li>
                                    <a href="/ticket/detail?tid=${l.id}" target="_blank" onclick="cmcTag('门票频道页-PC-站点-P4-景点推荐-${l.theme.name}-001-${l.name}','PC门票频道页景点推荐');">
                                        <div class="promotion_img_box">
                                            <img src="${l.coverUrl!}" width="222" height="150" alt="">
                                        </div>
                                        <div class="promotion_footer">
                                            <h5 title="${l.name}">${(l.name)!}</h5>

                                            <p><span>¥<dfn>${(l.price)!}</dfn></span><samp>起</samp></p>
                                        </div>
                                    </a>
                                </li>



                    </ul>
                    </#list>
                </div>
                <!-- 城市列表 -->
                <div class="recommend_list_content" style="display: none;">
                    <div class="main_content_l ticket_icon">
                        <ul class="recommend_tab_l">

                        </ul>
                    </div>
                    <ul class="promotion_list clearfix" style="display: none;">
                    </ul>
                    <ul class="promotion_list clearfix" style="display: none;">
                    </ul>
                    <ul class="promotion_list clearfix" style="display: none;">
                    </ul>
                    <ul class="promotion_list clearfix" style="display: none;">
                    </ul>
                    <ul class="promotion_list clearfix" style="display: none;">
                    </ul>
                    <ul class="promotion_list clearfix" style="display: none;">
                    </ul>
                    <ul class="promotion_list clearfix" style="display: none;">
                    </ul>
                </div>
                <!-- 城市列表 -->
                <div class="recommend_list_content" style="display: none;">
                    <div class="main_content_l ticket_icon">
                    </div>
                </div>
                <!-- 城市列表 -->
                <div class="recommend_list_content" style="display: none;">
                    <div class="main_content_l ticket_icon">
                    </div>
                </div>
                <!-- 城市列表 -->
                <div class="recommend_list_content" style="display: none;">
                    <div class="main_content_l ticket_icon">
                    </div>
                </div>
                <!-- 城市列表 -->
                <div class="recommend_list_content" style="display: none;">
                    <div class="main_content_l ticket_icon">
                    </div>
                </div>
                <!-- 城市列表 -->
                <div class="recommend_list_content" style="display: none;">
                    <div class="main_content_l ticket_icon">
                    </div>
                </div>
            </div>
        </div>
        <!-- 景点推荐  结束 -->

















        <!-- 专题活动 -->
        <div class="main_box">
            <h3 class="main_tit">官方旗舰店</h3>
            <div class="main_content_box main_zhuanti">
                <ul class="zhuanti_list clearfix">
                    <li>
                        <a href="http://www.lvmama.com/zt/promo/hygy/" target="_blank" onclick="cmcTag('门票频道页-PC-站点-P5-专题活动-001-','PC门票频道页专题活动');">
                            <h4></h4>
                            <img src="http://pic.lvmama.com/uploads/pc/place2/2017-05-19/21a448d2-b897-4b6b-855b-77b9be131bae.jpg" width="283" height="120" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="http://www.lvmama.com/zt/promo/2018gzhcldjq/" target="_blank" onclick="cmcTag('门票频道页-PC-站点-P5-专题活动-002-','PC门票频道页专题活动');">
                            <h4></h4>
                            <img src="http://pic.lvmama.com/uploads/pc/place2/2017-05-19/8250b6b1-2e92-4d4d-ba3d-5a8678f3828d.jpg" width="283" height="120" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="http://www.lvmama.com/zt/promo/hongkongdisney/" target="_blank" onclick="cmcTag('门票频道页-PC-站点-P5-专题活动-003-','PC门票频道页专题活动');">
                            <h4></h4>
                            <img src="http://pic.lvmama.com/uploads/pc/place2/2017-05-24/2a019a7e-5b1d-454d-987d-3a02af474687.jpg" width="283" height="120" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="http://www.lvmama.com/zt/promo/2018rjqjd/ " target="_blank" onclick="cmcTag('门票频道页-PC-站点-P5-专题活动-004-','PC门票频道页专题活动');">
                            <h4></h4>
                            <img src="http://pic.lvmama.com/uploads/pc/place2/2018-08-01/31a18704-6433-4eb3-af4f-905af60fbc41.jpg" width="283" height="120" alt="">
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 专题活动 结束-->
    </div>

    <div class="hh_cooperate">
        <!-- 友情链接 -->
        <p>
            <b>友情链接：</b>
            <span>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-10822149">合肥万达门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-10690393">扬州乐园门票</a>
			<a target="_blank" href="http://shanghai.gongjiao.com">上海公交</a>
			<a target="_blank" href="http://www.16fan.com/">十六番</a>
			<a target="_blank" href="http://www.myvacation.cn">小众旅游</a>
			<a target="_blank" href="http://shenzhen.tianqi.com/">深圳天气</a>
			<a target="_blank" href="http://www.xaoyo.com">天气预报查询</a>
			<a target="_blank" href="http://huoche.mipang.com">火车票网上订票</a>
			<a target="_blank" href="http://www.itrip.com/">欧洲自由行</a>
			<a target="_blank" href="http://www.qimaren.com/">成都中国青年旅行社</a>
			<a target="_blank" href="http://www.92rank.com">中国猕猴桃网</a>
			<a target="_blank" href="http://www.jutuw.com/">峨眉山旅游</a>
			<a target="_blank" href="http://www.yousc.com/">四川旅游网</a>
			<a target="_blank" href="http://www.xishiqu.com/">上海演唱会门票</a>
			<a target="_blank" href="http://down.znds.com/">智能电视软件</a>
			<a target="_blank" href="http://www.zhcpic.com/">哲狐旅行问答</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-121304">大宁郁金香公园</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-10812324">上海中心大厦</a>
			<a target="_blank" href="http://flight.lvmama.com/booking/PEK-SHA.html">北京到上海机票</a>
			<a target="_blank" href="http://flight.lvmama.com/booking/SHA-PEK.html">上海到北京机票</a>
			<a target="_blank" href="http://www.cct.cn/">康辉旅游</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-159996">云台山门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-456">峨眉山门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-127">黄山门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-344">华山门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-3577">长白山门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-105307">织金洞门票</a>
			<a target="_blank" href="http://www.kanzhun.com">查工资</a>
			<a target="_blank" href="http://www.yjldp.com">长岛渔家乐</a>
			<a target="_blank" href="http://www.zxart.cn/">艺术网</a>
			<a target="_blank" href="http://www.syoits.com">金运之旅</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-102901">乔家大院门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-162087">平遥古城门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-485">五台山门票</a>
			<a target="_blank" href="http://ticket.lvmama.com/scenic-175649">上海迪士尼门票</a>
			<a target="_blank" href="http://www.lvmama.com/lvyou/guide/2015-1208-199837.html" rel="nofollow">查看更多</a>
		</span>
        </p>
        <!-- // 友情链接 -->
        <!-- 热门精选 -->

        <script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/v5/modules/pandora-countdown.js,/js/channel/ticket/v1/ticket.js,/js/v5/modules/pandora-poptip.js"></script>
        <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js,/js/v5/ibm/coremetrics-initalize.js,/js/common/losc.js"></script>

        <script>
            $(function() {
                $("#smartShelfUrl").click(function() {
                    var destUrl = $(".recommend_tab_t").find("li.active").attr("data2");
                    var index = $(".recommend_tab_t li").index($(".recommend_tab_t li.active"));
                    var subjectid = $(".recommend_tab_l").find("li.active").eq(index).attr("data");
                    var cityName = $(".recommend_tab_t").find("li.active").html();

                    if(destUrl == "") {
                        window.open("http://s.lvmama.com/ticket/T" + subjectid + "?keyword=" + cityName + "#list");
                    } else {
                        window.open("http://" + destUrl);
                    }
                });

                //景点推荐上面的切换
                $(document).on('mouseover', '.recommend_tab_t li', function(e) {
                    var num = $(this).index();
                    $(this).addClass('active').siblings().removeClass('active');
                    var subjectDiv = $('.recommend_list_content').eq(num);
                    var destId = $(this).attr("data");
                    if(subjectDiv.find('ul').length == 0) {
                        $.ajax({
                            type: "POST",
                            url: "/homePage/reloadSubAndProd",
                            data: {
                                ajaxDestId: destId
                            },
                            success: function(data) {
                                if(subjectDiv.find('ul').length == 0) {
                                    var splitHtml = data.split("<!--&-->");
                                    subjectDiv.find('div.main_content_l').append(splitHtml[0]);
                                    subjectDiv.append(splitHtml[1]);
                                }
                            }
                        });
                    }
                    subjectDiv.show().siblings('.recommend_list_content').hide();
                });

                //景点推荐左侧的切换
                $(document).on('mouseover', '.recommend_tab_l li', function(e) {
                    var num = $(this).index();
                    $(this).addClass('active').siblings().removeClass('active');
                    var prodUl = $(this).parents('.main_content_l').siblings('.promotion_list').eq(num);
                    if(prodUl.find('li').length == 0) {
                        var subjectId = $(this).attr("data");
                        var destId = $("ul.recommend_tab_t").find("li.active").attr("data");
                        $.ajax({
                            type: "POST",
                            url: "/homePage/reloadProd",
                            data: {
                                ajaxDestId: destId,
                                ajaxSubjectId: subjectId
                            },
                            success: function(data) {
                                if(prodUl.find('li').length == 0) {
                                    prodUl.append(data);
                                }
                            }
                        });
                    }
                    prodUl.show().siblings('.promotion_list').hide();
                });

                //结束回调函数,如果是周四晚上24点，就执行下面这段代码，即可开放立减和抢购按钮
                $('.weekend_js').addClass('promotion_start');

                //还有多久结束
                $('.weekend_js').find('.promotion_weekend_time samp').text('结束');
                $('.weekend_js').find('.promotion_weekend_time').removeClass('time_start');
                $("#weekend_time").countdown({
                    format: "hh::mm::ss", // 时间格式类型 现支持 dd:hh:mm:ss(默认) hh:mm:ss,hh::mm::ss(无汉字),dd:hh:mm mm:ss 四种格式
                    prezero: true, // 前导零
                    effect: true, // 支持自定义格式
                    overtips: "<i>00</i>：<i>00</i>：<i>00</i>", // 自定义结束提醒
                    timeauto: false, // 默认不自适应格式
                    timediff: 0, // 调整时间差，单位毫秒
                    overFn: function() {
                        //结束回调函数,如果是周四晚上24点，就执行下面这段代码，即可开放立减和抢购按钮
                        $('.weekend_js').addClass('promotion_start');
                        $('.weekend_js').parent('.main_box').hide();

                    } //倒计时结束后的回调。
                });

            });

            function cmcTag(tag1, tag2) {
                cmCreateElementTag(tag1, tag2);
            }
            cmCreatePageviewTag("PC_景乐_频道页_门票_国内门票_广州", "景点门票首页", "", null, null, null, null, null, null, '路径页面');

            $('ul.banner_list li ').click(function() {
                var index = $(this).index() + 1;
                var tag1 = "门票频道页-PC-站点-BANNER-帧" + index;
                var tag2 = "PC门票频道页Banner";
                cmCreateElementTag(tag1, tag2);
            });

            //小程序码悬浮
            $(".JS_appletPop").poptip({
                place: 9
            });
        </script>

    </div>
    <div class="poptip tip-light poptip-default" style="left: 407px; top: 861.5px; display: none;" id="poptip1">
        <div class="tip-arrow tip-arrow-3"> <em>◆</em> <i>◆</i> </div>
        <div class="tip-content">
            <h5 class="tip-title" style="display: none;"></h5>
            <p><img src="http://pic.lvmama.com/img/v6/applet_poptip_ticket.png" width="160" height="184"></p>
        </div>
    </div>
    <div id="right-bottom-tools">
        <a id="goTopBtn" target="_self" href="javascript:;" title="返回顶部" class="" style="visibility: hidden;"></a>
        <a href="http://www.lvmama.com/userCenter/user/transItfeedBack.do" target="_blank" id="Feedback" title="意见反馈" class="" style="visibility: hidden;"></a><span id="rbtApplet" class="JS_appletPop" tip-content="<img src='http://pic.lvmama.com/img/v6/applet_poptip_ticket.png' width='160' height='184'>"></span></div>
    <div class="s_complete_box"></div>
    <div class="footBar P800 w12 open">
        <div class="syfootBar-overlay"></div>
        <div class="syfootBar-wrap">
            <a class="footBar-gnsyl-lv" href="http://www.lvmama.com/zt/promo/cjyoulun?losc=089761&amp;ict=i" target="_blank"></a>
            <a class="footBar-gnsyl_channel" href="http://www.lvmama.com/zt/promo/cjyoulun?losc=089761&amp;ict=i" target="_blank">买国内送邮轮</a>
            <div class="footBar-opt">
                <div class="footBar-opt-overlay"></div>
                <div class="footBar-opt-wei"><span class="footBar-sao"></span><em>微信扫一扫，小程序预订更优惠</em></div>
                <div class="footBar-opt-app">
                    <a class="T3D T3dY an5s" href="https://itunes.apple.com/cn/app/id443926246?mt=8" target="_blank">iPhone下载</a>
                    <a class="T3D T3dY an5s" href="http://m.lvmama.com/rewrite/d.php" target="_blank">Android下载</a>
                    <a class="T3D T3dY an5s" href="https://itunes.apple.com/cn/app/id443926246?mt=8" target="_blank">iPad下载</a>
                </div>
            </div><span class="footBar-close"></span></div>
    </div>
    <#include "../common/footer.ftl">
</body>

</html>