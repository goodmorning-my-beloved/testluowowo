<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="/styles/base.css" rel="stylesheet" type="text/css">
    <link href="/styles/destfilter.css" rel="stylesheet" type="text/css"><#---->
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-form/jquery.form.js"></script>
    <script type="text/javascript" src="/js/system/destfilter.js"></script><#---->
    <link href="/js/plugins/jqPaginator/jqPagination.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/plugins/jqPaginator/jq-paginator.min.js"></script>
    <script type="text/javascript" src="/js/system/common.js"></script>

    <script>
        $(function () {
           $('#searchForm').ajaxForm(function (data) {
              $('.row-list').html(data);
           });

           //月份
           $('.month a').click(function(){
               $('.month a').removeClass('on');
               $(this).addClass('on');
               var month = $(this).data('month');
               $('#month').val(month);
               $('#searchForm').submit();
           });
           //主题
            $('.theme a').click(function () {
                $('.theme a').removeClass('on');
                $(this).addClass('on');
                var themeId = $(this).data('id');
                $('#themeId').val(themeId);
                $('#searchForm').submit();
            })
            //天数
            $('.mydays a').click(function () {
                $('.mydays a').removeClass('on');
                $(this).addClass('on');
                var travelTimeType = $(this).data('traveltimetype');
                $('#travelTimeType').val(travelTimeType);
                $('#searchForm').submit();
            });

            var href = window.location.href;
            var strings = href.split("?");
            var str = strings[1];
            if (str) {
                //month/themeId
                var ss = str.split("=");
                if (ss[0] == "month") {
                    $(".month a").removeClass("on");
                    $(".month"+ss[1]).addClass("on");
                    $("#month").val(ss[1]);
                    $("#searchForm").submit();
                }else {
                    $(".theme a").removeClass("on");
                    $(".themeId"+ss[1]).addClass("on");
                    $("#themeId").val(ss[1]);
                    $("#searchForm").submit();
                }
            }else {
                $("#searchForm").submit();
            }

        });
    </script>

</head>

<body>
<div class="lww_header">
    <div class="header_wrap">
        <div class="header_logo">
            <a href="javascript:;" class="lww_logo"></a>
        </div>
        <ul class="header_nav">
            <li><a href="./index.ftl">首页</a></li>
            <li class="header_nav_active"><a href="./destination.ftl">目的地</a></li>
            <li><a href="./gonglve.ftl">旅游攻略</a></li>
            <li><a href="javascript:;">去旅行<i class="icon_caret_down"></i></a></li>
            <li><a href="javascript:;">机票</a></li>
            <li><a href="javascript:;">酒店</a></li>
            <li><a href="javascript:;">社区<i class="icon_caret_down"></i></a></li>
        </ul>
        <div class="header_search">
            <input type="text"/>
            <a class="icon_search"></a>
        </div>
        <div class="login_info">
            <div class="head_user">
                <a href="javascript:;">
                    <img src="./images/user.png"/>
                    <i class="icon_caret_down"></i>
                </a>
            </div>
            <div class="header_msg">
                消息<i class="icon_caret_down"></i>
            </div>
            <div class="header_daka">
                <a href="javascript:;">打卡</a>
            </div>
        </div>
    </div>
    <div class="shadow"></div>
</div>
<div class="container">

    <form action="/destination/getlist" method="post" id="searchForm">
        <input type="hidden" name="currentPage" id="currentPage" value="1">
        <input type="hidden" name="month" id="month" value="-1">
        <input type="hidden" name="themeId" id="themeId" value="-1">
        <input type="hidden" name="travelTimeType" id="travelTimeType" value="-1">
    </form>





    <div class="row-top">
        <div class="wrapper">
            <div class="top-bar">
                <div class="crumb">
                    <div class="item"><a href="javascript:;" target="_blank">目的地</a><em>&gt;</em></div>
                    <div class="item cur">目的地筛选</div>
                </div>
            </div>
            <div class="filter-title">目的地筛选</div>

            <div class="filter-nav">

                <dl class="clearfix">
                    <dt>时间</dt>
                    <dd class="J_dd">
                        <div class="month clearfix">
                            <a  href="javascript:void(0)" data-month="-1" class="on">不限</a>
                            <#list 1..12 as month>
                                <a href="javascript:void(0)" class="month${month_index+1}" data-month="${month_index+1}">${month_index+1}月</a>
                            </#list>
                        </div>

                        <div class="month clearfix">
                            <#list holidayList as holiday>
                                <a href="javascript:void(0)" data-month="${holiday.id}" class="month${holiday.id}">${holiday.name}</a>
                            </#list>
                        </div>
                    </dd>
                </dl>

                <dl class="clearfix">
                    <dt>主题</dt>
                    <dd class="J_dd theme">
                        <a class="on" href="javascript:void(0)" data-id="-1">不限</a>
                        <div class="sub-nav">

                            <dl class="clearfix">
                                <dt>全年适宜：</dt>
                                <dd>
                                    <#list  yearSuitableList as year>
                                        <a href="javascript:void(0)" class="themeId${year.id}"  data-id="${year.id}">${year.name!}</a>
                                    </#list>
                                </dd>
                            </dl>

                            <dl class="clearfix">
                                <dt>季节：</dt>
                                <dd>
                                    <#list seasonList as season>
                                        <a href="javascript:void(0)" class="themeId${season.id}" data-id="${season.id}">${season.name!}</a>
                                    </#list>
                                </dd>
                            </dl>

                            <dl class="clearfix">
                                <dt>出行方式：</dt>
                                <dd>
                                    <#list wayTravelList as wayTravel>
                                        <a href="javascript:void(0)" class="themeId${wayTravel.id}" data-id="${wayTravel.id}">${wayTravel.name!}</a>
                                    </#list>
                                </dd>

                            </dl>
                        </div>
                    </dd>
                </dl>
                <dl class="clearfix">
                    <dt>天数</dt>
                    <dd class="J_dd mydays">
                        <a class="on" href="javascript:void(0)" data-traveltimetype="-1">不限</a>
                        <a href="javascript:void(0)" data-traveltimetype="1">2-3天</a>
                        <a href="javascript:void(0)" data-traveltimetype="2">4-5天</a>
                        <a href="javascript:void(0)" data-traveltimetype="3">6-9天</a>
                        <a href="javascript:void(0)" data-traveltimetype="4">10天及以上</a>
                    </dd>
                </dl>

            </div>
        </div>
    </div>
    <div class="row-list">

    </div>
</div>

<div id="footer">
    <div class="ft-content" style="width: 1105px">
        <div class="ft-info clearfix">
            <dl class="ft-info-col ft-info-intro">
                <dt>马蜂窝旅游网</dt>
                <dd>叩丁狼是一家专注于培养高级IT技术人才，为学员提供定制化IT职业规划方案及</dd>
                <dd>意见咨询服务的教育科技公司，为您提供海量优质课程，以及创新的线上线下学</dd>
                <dd>习体验，帮助您获得全新的个人发展和能力提升。</dd>
            </dl>
            <dl class="ft-info-col ft-info-qrcode">
                <dd>
                    <span class="ft-qrcode-tejia"></span>
                </dd>
                <dd>
                    <span class="ft-qrcode-weixin"></span>
                </dd>
                <dd>
                    <span class="ft-qrcode-weixin"
                          style="background-image: url('https://p3-q.mafengwo.net/s10/M00/48/A9/wKgBZ1t_4sSAVJ6uAAAlzJ0PZgU881.png?imageMogr2%2Fthumbnail%2F%2194x90r%2Fgravity%2FCenter%2Fcrop%2F%2194x90%2Fquality%2F90')"></span>
                </dd>
            </dl>
            <dl class="ft-info-social">
                <dt>向崇尚自由的加勒比海盗致敬！</dt>
                <dd>
                    <a class="ft-social-weibo" target="_blank" href="javascript:;" rel="nofollow"><i
                                class="ft-social-icon"></i></a>
                    <a class="ft-social-qqt" target="_blank" href="javascript:;" rel="nofollow"><i
                                class="ft-social-icon"></i></a>
                    <a class="ft-social-qzone" target="_blank" href="javascript:;" rel="nofollow"><i
                                class="ft-social-icon"></i></a>
                </dd>
            </dl>
        </div>

        <div class="ft-links">
            <a target="_blank" href="http://china.makepolo.com/">马可波罗</a><a target="_blank"
                                                                            href="http://www.onlylady.com/">Onlylady女人志</a><a
                    target="_blank" href="http://trip.elong.com/">艺龙旅游指南</a><a target="_blank"
                                                                               href="http://www.cncn.com">欣欣旅游网</a>
            <a target="_blank" href="http://www.8264.com/">户外运动</a><a target="_blank" href="http://www.yue365.com/">365音乐网</a><a
                    target="_blank" href="http://ishare.iask.sina.com.cn/">爱问共享资料</a><a target="_blank"
                                                                                        href="http://www.uzai.com/">旅游网</a>
            <a target="_blank" href="http://www.zongheng.com/">小说网</a>
            <a target="_blank" href="http://www.xuexila.com/">学习啦</a><a target="_blank" href="http://www.yododo.com">游多多自助游</a><a
                    target="_blank" href="http://www.zhcpic.com/">问答</a><a target="_blank"
                                                                           href="http://huoche.mafengwo.cn/">火车时刻表</a>
            <a target="_blank" href="http://www.lvmama.com">驴妈妈旅游网</a>
            <a target="_blank" href="http://www.haodou.com/">好豆美食网</a><a target="_blank" href="http://www.taoche.com/">二手车</a><a
                    target="_blank" href="http://www.lvye.cn">绿野户外</a><a target="_blank" href="http://www.tuniu.com/">途牛旅游网</a>
            <a target="_blank" href="http://www.mapbar.com/">图吧</a>
            <a target="_blank" href="http://www.chnsuv.com">SUV联合越野</a><a target="_blank"
                                                                          href="http://www.uc.cn/">手机浏览器</a><a
                    target="_blank" href="http://sh.city8.com/">上海地图</a><a target="_blank"
                                                                           href="http://www.tianqi.com/">天气预报查询</a>
            <a target="_blank" href="http://www.ly.com/">同程旅游</a>
            <a target="_blank" href="http://www.tieyou.com/">火车票</a><a target="_blank" href="http://www.yunos.com/">YunOS</a><a
                    target="_blank" href="http://you.ctrip.com/">携程旅游</a><a target="_blank"
                                                                            href="http://www.jinjiang.com">锦江旅游</a>
            <a target="_blank" href="http://www.huoche.net/">火车时刻表</a>
            <a target="_blank" href="http://www.tripadvisor.cn/">TripAdvisor</a><a target="_blank"
                                                                                   href="http://www.tianxun.com/">天巡网</a><a
                    target="_blank" href="http://www.mayi.com/">短租房</a><a target="_blank" href="http://www.zuzuche.com">租租车</a>
            <a target="_blank" href="http://www.5fen.com/">五分旅游网</a>
            <a target="_blank" href="http://www.zhuna.cn/">酒店预订</a><a target="_blank" href="http://www.ailvxing.com">爱旅行网</a><a
                    target="_blank" href="http://360.mafengwo.cn/all.php">旅游</a><a target="_blank"
                                                                                   href="http://vacations.ctrip.com/">旅游网</a>
            <a target="_blank" href="http://www.wed114.cn">wed114结婚网</a>
            <a target="_blank" href="http://www.chexun.com/">车讯网</a><a target="_blank" href="http://www.aoyou.com/">遨游旅游网</a><a
                    target="_blank" href="http://www.91.com/">手机</a>
            <a href="javascript:;" target="_blank">更多友情链接&gt;&gt;</a>
        </div>
    </div>
</div>
<div class="mfw-toolbar" id="_j_mfwtoolbar" style="display: block;">
    <div class="toolbar-item-top" style="display: none;">
        <a role="button" class="btn _j_gotop">
            <i class="icon_top"></i>
            <em>返回顶部</em>
        </a>
    </div>
    <div class="toolbar-item-feedback">
        <a role="button" data-japp="feedback" class="btn">
            <i class="icon_feedback"></i>
            <em>意见反馈</em>
        </a>
    </div>
    <div class="toolbar-item-code">
        <a role="button" class="btn">
            <i class="icon_code"></i>
        </a>
        <a role="button" class="mfw-code _j_code">


            <img src="https://p1-q.mafengwo.net/s1/M00/6C/51/wKgIC1t_6TuASybrAADGUPUHjr021.jpeg?imageMogr2%2Fthumbnail%2F%21450x192r%2Fgravity%2FCenter%2Fcrop%2F%21450x192%2Fquality%2F90"
                 width="450" height="192">
        </a>
        <!--<div class="wx-official-pop"><img src="http://images.mafengwo.net/images/qrcode-weixin.gif"><i class="_j_closeqrcode"></i></div>-->
    </div>

</div>
</body>

</html>