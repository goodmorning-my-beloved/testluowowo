<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="/styles/base.css" rel="stylesheet" type="text/css">
    <link href="/styles/reply.css" rel="stylesheet" type="text/css">
    <link href="/js/plugins/jqPaginator/jqPagination.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/system/travelfilter.js"></script>
    <script type="text/javascript" src="/js/system/common.js"></script>
    <script type="text/javascript" src="/js/plugins/jqPaginator/jq-paginator.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-form/jquery.form.js"></script>

</head>

<body>
<div class="lww_header">
    <div class="header_wrap">
        <div class="header_logo">
            <a href="javascript:;" class="lww_logo"></a>
        </div>
        <ul class="header_nav">
            <li><a href="./index.html">首页</a></li>
            <li class="header_nav_active"><a href="./destination.html">目的地</a></li>
            <li><a href="./gonglve.html">旅游攻略</a></li>
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


    <div class="row row-placeTop" data-cs-p="面包屑">
        <div class="wrapper">
            <link href="http://css.mafengwo.net/css/cv/css+mdd+place-crumb:css+mdd+place-navbar^Z1U^1559788120.css"
                  rel="stylesheet" type="text/css">
            <script language="javascript" src="http://js.mafengwo.net/js/hotel/sign/index.js?1552035728"
                    type="text/javascript" crossorigin="anonymous"></script>
            <link href="http://css.mafengwo.net/css/mdd/place-crumb.css?1530619858" rel="stylesheet" type="text/css">

        <#--吐司开始-->
            <div class="crumb">
                <div class="item"><a href="/destination">目的地</a><em>&gt;</em></div>
        <#list toasts as t>
            <div class="item">
                <div class="drop">
                    <span class="hd"><a href="javascript:;" target="_blank">${(t.name)!}<i></i></a></span>
                    <div class="bd">
                        <i class="arrow"><b></b></i>
                        <div class="col">
                            <h3>热门地区</h3>
                            <ul class="clearfix">
                                <#list t.children as tc>
                                    <#if tc_index lt 5 >
                                    <li><a href="/destination/guide?id=${tc.id!}" target="_blank">${tc.name}</a></li>
                                    </#if>
                                </#list>
                            </ul>
                        </div>
                        <div class="more"><a href="/destination/guide?id=${t.id}" target="_blank">&gt;&gt;更多地区</a></div>
                    </div>
                </div>
                <em>&gt;</em>
            </div>
        </#list>
                <div class="item">
                    <div class="drop">
                        <span class="hd"><a href="javascript:;">${dest.name}<i></i></a></span>
                        <div class="bd">
                            <i class="arrow"><b></b></i>
                            <div class="col">
                                <ul class="clearfix">
                                    <li><a href="/destination/surveyPage?destId=${dest.id}" target="_blank">${dest.name}
                                        概括</a></li>
                                    <li><a href="#travel" target="_blank">${dest.name}游记</a></li>
                                    <li><a href="#strategy" target="_blank">${dest.name}攻略</a></li>
                                    <li><a href="javascript:;" target="_blank">${dest.name}跟团游</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <em>&gt;</em>
                </div>
                <div class="item cur"><strong>${dest.name}景点</strong></div>
            </div>
        <#--吐司结束-->

            <script language="JavaScript" type="text/javascript">
                $(function () {
                    //面包屑
                    $('.drop').mouseenter(function (ev) {
                        var target = $(ev.currentTarget);
                        clearTimeout(target.data('hideTimer'));
                        target.addClass('open');
                        target.children('bd').fadeIn(200);
                    });
                    $('.drop').mouseleave(function (ev) {
                        var target = $(ev.currentTarget);
                        target.data("hideTimer", setTimeout(function () {
                            target.removeClass('open');
                            target.children('bd').fadeOut(200);
                        }, 200));
                    });
                });
            </script>

            <div class="place-navbar" id="_j_mdd_place_nav_bar_warper" style="border-top: 0;" data-cs-t="目的地导航">
                <div class="navbar-con">
                    <ul class="navbar clearfix navbar-first-level-warper">
                        <li class="navbar-overview">
                            <a class="navbar-btn" href="http://localhost:8888/" data-cs-p="首页">
                                <i class="navbar-icon"></i><span>首页</span>

                            </a>
                        </li>
                        <li class="navbar-line">
                            <a class="navbar-btn" href="" data-cs-p="行程线路">
                                <i class="navbar-icon"></i><span>行程线路</span>

                            </a>
                        </li>
                        <li class="navbar-scenic">
                            <a class="navbar-btn" href="/jd/10088/gonglve.html" data-cs-p="景点">
                                <i class="navbar-icon"></i><span>景点</span>

                            </a>
                        </li>
                        <li class="navbar-hotels">
                            <a class="navbar-btn" href="/hotel/10088/?sFrom=mdd" data-cs-p="酒店">
                                <i class="navbar-icon"></i><span>酒店</span>

                            </a>
                        </li>
                        <li class="navbar-flight">
                            <a class="navbar-btn" href="/flight" target="_blank" data-cs-p="机票">
                                <i class="navbar-icon"></i><span>机票</span>

                            </a>
                        </li>

                    </ul>
                </div>
            </div>
            <div id="fill_area" style="height: 75px; display: none;"></div>

        </div>
    </div>


    <div class="row row-summary row-bg">
        <div class="wrapper">
            <h2 class="title">景点概况</h2>
            <div>
                <p style="">
                    这个城市没有冬天，没有寒冷，永远都是那么暖意洋洋，永远都是那么热火朝天；这个城市的每一条街道，都灯火辉煌，明亮耀眼；广州大多数景点都需要1天的时间来游览，最有特色是有着异域风情的沙面和拥有130多年历史的石室圣心大教堂。这个城市没有冬天，没有寒冷，永远都是那么暖意洋洋，永远都是那么热火朝天；这个城市的每一条街道，都灯火辉煌，明亮耀眼；广州大多数景点都需要1天的时间来游览，最有特色是有着异域风情的沙面和拥有130多年历史的石室圣心大教堂。另外陈家祠、现代化建筑广州塔和已有2100多年历史的南越王墓也是值得一看的地方。</span>
                </p>
            </div>
        </div>

    </div>
    <br>
    <br>


    <div class="row row-top5" data-cs-p="必游景点">
        <div class="wrapper">
            <h2 class="title">必游景点TOP5</h2>
           <#list scenics_top5 as sct>
            <div class="item clearfix">
                <div class="info">
                    <div class="middle">
                        <h3>
                            <span class="num">${sct_index+1}</span>
                            <a href="/scenic/detail?id=${sct.id}" target="_blank" title="广州塔">${sct.name}
                            </a><a href="/scenic/detail?id=${sct.id}" target="_blank" title="广州塔">
                            <span class="rev-total"><em>${sct.commentNum!}</em> 条点评</span>
                        </a>
                        </h3>
                        <p>${sct.intro}</p>
                        <div class="links">这里还包含景点：
                            <#list sct.children as c>
                                <a href="/scenic/detail?id=${c.id}" target="_blank">${c.name}</a>
                            </#list>
                        </div>
                    </div>
                </div>
                <div class="pic">
                    <a href="/poi/25091.html" target="_blank" title="广州塔">
                        <div class="large">
                            <img src="${(sct.coverUrls[0])!}"
                                 width="380" height="270">
                        </div>
                        <div>
                            <img src="${sct.coverUrls[1]!}"
                                 width="185" height="130">
                        </div>
                        <div>
                            <img src="${sct.coverUrls[2]!}"
                                 width="185" height="130">
                        </div>
                    </a>
                </div>
            </div>

            </#list>
        </div>
    </div>
    <br>
    <br>
    ,

    <div class="row row-hotScenic row-bg" data-cs-p="热门景点">
        <div class="wrapper">
            <h2 class="title">热门景点</h2>
            <#list hotScenics as hsc>
            <div class="bd">
                <div class="grid grid-two">
                    <div class="figure">
                        <a href="/poi/5178221.html" target="_blank" title="广州塔">
                            <img src="${hsc.coverUrls[0]}"
                                 width="485" height="320">
                            <h3 class="title">${hsc.name}</h3>
                            <div class="mask-container">
                                <div class="mask">
                                    <div class="middle">
                                        <h3>${hsc.name}</h3>
                                        <p>${hsc.intro}</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>

                </div>
            </#list>
        </div>
        </div>
    </div>


    <div class="row row-allScenic" data-cs-p="全部景点">
        <div class="wrapper">
            <h2 class="title" style="display: block">
                <#--广州全部景点-->
                <a class="btn-add" href="/poi/add.php?iId=10088" target="_blank" title="推荐新的景点"><i>+</i>推荐新的景点</a>
            </h2>
        <#--表单提交 分页-->
            <form action="/scenic/page" method="post" id="searchForm">
                <input type="hidden" name="currentPage" id="currentPage" value="1">
                <input type="hidden" name="destId" id="destId" value="${dest.id!}">

                <ul class="nav clearfix">
                    <li class="on sub"><a title="全部景点">全部景点</a></li>
                    <li class="sub" data-type="人间五月"><a title="人间五月">人间五月</a></li>
                    <li class="sub" data-type="羊城八景"><a title="羊城八景">羊城八景</a></li>
                    <li class="sub" data-type="赏花佳地"><a title="赏花佳地">赏花佳地</a></li>
                    <li class="sub" data-type="老地方等你"><a title="老地方等你">老地方等你</a></li>
                    <li class="sub" data-type="小清新地儿"><a title="小清新地儿">小清新地儿</a></li>
                </ul>
            </form>

            <script>
                $(function () {
                    //回显
                    $('.sub').click(function () {
                        $(this).addClass('on').siblings().removeClass('on');
                    });
                })

            </script>

            <div class="bd" id="allScenics">
                <script>
                    //发送ajax请求,获取全部景点,实现分页局部刷新
                    $(function () {

                        var destId =${dest.id};

                        //分页
                        $("#searchForm").ajaxForm(function (data) {
                            $("#allScenics").html(data);
                        });
                        $("#searchForm").submit();


                        $(".sub").click(function () {
                            var type = $(this).data('type');
                            $.get("/scenic/page", {destId: destId, type: type}, function (data) {
                                $("#allScenics").html(data);
                            })

                        })

                    })
                </script>
            </div>

        </div>
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
                target="_blank" href="http://trip.elong.com/">艺龙旅游指南</a><a target="_blank" href="http://www.cncn.com">欣欣旅游网</a>
            <a target="_blank" href="http://www.8264.com/">户外运动</a><a target="_blank" href="http://www.yue365.com/">365音乐网</a><a
                target="_blank" href="http://ishare.iask.sina.com.cn/">爱问共享资料</a><a target="_blank"
                                                                                    href="http://www.uzai.com/">旅游网</a>
            <a target="_blank" href="http://www.zongheng.com/">小说网</a>
            <a target="_blank" href="http://www.xuexila.com/">学习啦</a><a target="_blank" href="http://www.yododo.com">游多多自助游</a><a
                target="_blank" href="http://www.zhcpic.com/">问答</a><a target="_blank"
                                                                       href="http://huoche.mafengwo.cn/">火车时刻表</a>
            <a target="_blank" href="http://www.lvmama.com">驴妈妈旅游网</a>
            <a target="_blank" href="http://www.haodou.com/">好豆美食网</a><a target="_blank" href="http://www.taoche.com/">二手车</a><a
                target="_blank" href="http://www.lvye.cn">绿野户外</a><a target="_blank"
                                                                     href="http://www.tuniu.com/">途牛旅游网</a>
            <a target="_blank" href="http://www.mapbar.com/">图吧</a>
            <a target="_blank" href="http://www.chnsuv.com">SUV联合越野</a><a target="_blank"
                                                                          href="http://www.uc.cn/">手机浏览器</a><a
                target="_blank" href="http://sh.city8.com/">上海地图</a><a target="_blank" href="http://www.tianqi.com/">天气预报查询</a>
            <a target="_blank" href="http://www.ly.com/">同程旅游</a>
            <a target="_blank" href="http://www.tieyou.com/">火车票</a><a target="_blank" href="http://www.yunos.com/">YunOS</a><a
                target="_blank" href="http://you.ctrip.com/">携程旅游</a><a target="_blank" href="http://www.jinjiang.com">锦江旅游</a>
            <a target="_blank" href="http://www.huoche.net/">火车时刻表</a>
            <a target="_blank" href="http://www.tripadvisor.cn/">TripAdvisor</a><a target="_blank"
                                                                                   href="http://www.tianxun.com/">天巡网</a><a
                target="_blank" href="http://www.mayi.com/">短租房</a><a target="_blank"
                                                                      href="http://www.zuzuche.com">租租车</a>
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