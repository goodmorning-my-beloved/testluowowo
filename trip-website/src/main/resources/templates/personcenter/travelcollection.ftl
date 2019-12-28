<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="./styles/base.css" rel="stylesheet" type="text/css">
    <link href="./styles/travelcollection.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/travelcollection.js"></script>
    <script type="text/javascript" src="./js/common.js"></script>
    
    <script>
        //游记收藏删除
        $(function () {
            $(".delPost").click(function () {
                var sid = $(this).data("sid");
                $.get("/travel/favor", {sid:sid},function (data) {
                    window.location.reload();
                })
            })
        })
        
    </script>
</head>

<body style="position: relative;">
    <div class="topBar">
        <div class="topBarC">
            <div class="logo"><a title="马蜂窝自由行" href="javascript:;">马蜂窝自由行</a></div>
            <div class="t_nav">
                <ul id="pnl_nav" data-cs-t="headnav_wo">
                    <li data-cs-p="index">
                        <strong class="t"><a href="javascript:;">首页</a></strong>
                    </li>
                    <li data-cs-t="wenda" data-cs-p="wenda">
                        <strong class="t"><a data-cs-p="from_wo_nav" href="javascript:;">问答</a></strong>
                    </li>
                    <li data-cs-t="things" data-cs-p="things">
                        <strong class="t"><a data-cs-p="from_wo_nav" href="javascript:;">马蜂窝周边</a></strong>
                    </li>
                    <li data-cs-p="together">
                        <strong class="t"><a href="javascript:;">结伴</a></strong>
                    </li>
                    <li data-cs-p="group">
                        <strong class="t"><a href="javascript:;">小组</a></strong>
                    </li>
                    <li data-cs-p="mall">
                        <strong class="t"><a href="javascript:;">蜂首俱乐部</a></strong>
                    </li>
                    <li class="drop" data-cs-p="other">
                        <strong class="t"><a href="javascript:;">更多<b></b></a></strong>
                    </li>
                </ul>
            </div>
            <div class="t_search">
                <form method="GET" action="/search/s.php" name="search">
                    <input type="text" class="key" value="" name="q" id="word">
                    <input type="submit" value="" class="btn">
                </form>
            </div>

            <div class="t_info">
                <div class="pagelet-block">
                    <ul class="user_info">
                        <li class="daka">
                            <span class="daka_btn" id="_j_dakabtn" data-japp="daka">
                                <a role="button" title="打卡" class="daka_before">打卡</a>
                                <a role="button" title="打卡推荐" class="daka_after">打卡推荐</a>
                            </span>
                        </li>
                        <li id="pnl_user_msg" data-hoverclass="on" class="msg _j_hoverclass">
                            <span id="oldmsg" class="oldmsg"><a href="javascript:;"
                                    class="infoItem">消息<b></b></a></span>
                            <ul id="head-msg-box" class="drop-bd">
                                <li><a href="javascript:;" rel="nofollow">私信</a></li>
                                <li><a href="javascript:;" rel="nofollow">小组消息</a></li>
                                <li><a href="javascript:;" rel="nofollow">系统通知</a></li>
                                <li><a href="javascript:;" rel="nofollow">问答消息</a></li>
                                <li><a href="javascript:;" rel="nofollow">回复消息</a></li>
                                <li><a href="javascript:;" rel="nofollow">喜欢与收藏</a></li>
                                <li><a href="javascript:;" rel="nofollow">好友动态</a></li>
                            </ul>
                        </li>
                        <li class="ub-item ub-new-msg" id="head-new-msg">
                        </li>
                        <li class="account _j_hoverclass" data-hoverclass="on" id="pnl_user_set">
                            <span class="t"><a class="infoItem" href="javascript:;"><img
                                        src="${user.headImgUrl}"
                                        width="32" height="32" align="absmiddle"><b></b></a></span>
                            <div class="uSet c">
                                <div class="asset">
                                    <a class="coin" href="javascript:;" target="_blank" rel="nofollow">蜂蜜 0</a>
                                    /
                                    <a class="coin" href="javascript:;" target="_blank" id="head-my-honey"
                                        rel="nofollow" data-cs-p="coin">金币 579</a>
                                </div>
                                <a href="javascript:;">我的马蜂窝<b class="tb-level">LV.3</b></a>
                                <a href="javascript:;" target="_blank">写游记</a>
                                <a href="javascript:;" target="_blank">预约游记</a>
                                <a href="javascript:;" target="_blank">我的足迹</a>
                                <a href="javascript:;" target="_blank">我的问答</a>
                                <a href="javascript:;" target="_blank">我的好友</a>
                                <a href="javascript:;" target="_blank">我的收藏</a>
                                <a href="javascript:;" target="_blank">我的路线</a>
                                <a href="javascript:;" target="_blank">我的订单</a>
                                <a href="javascript:;" target="_blank">我的优惠券</a>
                                <a href="javascript:;" target="_blank">设置</a>
                                <a href="javascript:;">退出</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="banner">
            <div class="banner_img banner_note" id="_j_banner">
            </div>
            <div class="tags_bar second_tags_bar">
                <div class="center clearfix">
                    <div class="MAvatar clearfix">
                        <div class="MAvaImg flt1">
                            <img width="120" height="120" alt=""
                                src="${user.headImgUrl}">
                        </div>
                        <div class="MAvaEasyWord flt1">
                            <span class="MAvaName">${user.nickname}(${user.city})</span>
                            <span class="MAvaLevel">Lv.${user.level}</span>
                        </div>
                    </div>
                    <ul class="flt2">
                        <li><a class="tags_link" href="/mine/home" title="我的窝">我的窝</a></li>
                        <li><a class="tags_link" href="/mytravelnotes" title="我的游记">我的游记</a></li>
                        <li><a class="tags_link" href="/review" title="我的点评">我的点评</a></li>
                        <li id="_j_pathnav" class="on"><a class="tags_link" href="/travelcollection" title="我的收藏">我的收藏</a>
                        </li>
                        <li><a class="tags_link" href="javascript:;" title="我的订单">我的订单</a></li>
                        <li><a class="tags_link" href="/setting" title="设置">设置</a></li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
    <div class="wrapper">
        <div class="home-extra">
            <div class="s_title">
                <ul>
                    <li class="s_curr"><a href="javascript:;">地点收藏</a></li>
                    <li><a href="javascript:;">游记收藏</a></li>
                    <li><a href="javascript:;">攻略收藏</a></li>
                    <li><a href="javascript:;">旅行社收藏</a></li>
                </ul>
            </div>
            <div class="p-country">
                <div class="p-hd">
                    泰国
                </div>
                <div class="p-item">
                    <div class="p-item-main clearfix">
                        <div class="p-toggle">
                            <a class="btn-toggle" href="javascript:void(0)" data-mddid="11047"><span>收起</span><i
                                    class="arr-up"></i></a>
                        </div>
                        <div class="p-content">
                            <div class="img"><a href="javascript:;" target="_blank"><img
                                        src="http://n3-q.mafengwo.net/s8/M00/3D/B0/wKgBpVU5sFKADn9ZAAU2Y9xlTRg773.png?imageMogr2%2Fthumbnail%2F%21170x110r%2Fgravity%2FCenter%2Fcrop%2F%21170x110%2Fquality%2F100"
                                        width="140" height="90"></a></div>
                            <div class="p-title">
                                <a href="javascript:;" target="_blank"><strong>普吉岛</strong></a><span class="en">Phuket
                                    Island</span><span class="s-pull"><b>13344</b>人去过</span>
                            </div>
                            <p class="favtip">该目的地收藏了<em>2</em>个POI</p>
                            <p class="summary">幽蓝的海，水色纯净，天色蔚蓝，有着美丽的白色沙滩和碧绿海水。这里被称作泰国的珍珠。</p>

                        </div>
                    </div>
                    <div class="p-item-poi">
                        <div class="p-nav clearfix">
                            <a class="on" href="javascript:void(0)"><i class="p-icon-hotel"></i>住宿<span>2</span></a>
                        </div>
                        <ul class="p-poi clearfix">
                            <li>
                                <a href="javascript:;" target="_blank">
                                    <div class="img"><img
                                            src="http://b4-q.mafengwo.net/s6/M00/9E/0C/wKgB4lMOLoWANyARAAET45U6C3w68.jpeg?imageMogr2%2Fthumbnail%2F%21240x240r%2Fgravity%2FCenter%2Fcrop%2F%21240x240%2Fquality%2F90"
                                            width="162" height="100"></div>
                                    <div class="info">
                                        <p class="title">普吉岛芭东巴尔米拉度假酒店</p>
                                        <p><em>2397</em>条评论</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;" target="_blank">
                                    <div class="img"><img
                                            src="http://b1-q.mafengwo.net/s12/M00/9C/8A/wKgED1uk79OAK7C2AAc7O4pWYic23.jpeg?imageMogr2%2Fthumbnail%2F%21240x240r%2Fgravity%2FCenter%2Fcrop%2F%21240x240%2Fquality%2F90"
                                            width="162" height="100"></div>
                                    <div class="info">
                                        <p class="title">阿玛塔拉康体度假村</p>
                                        <p><em>62</em>条评论</p>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="p-country favPost hide">
                <ul id="favlist">
                    <form name="favorite" action="" method="post">
                        <#list travels as travel>
                        <li class="post_item">
                            <a class="delPost hide" href="javascript:void(0)" data-id="6555539" data-type="0" data-sid="${travel.id}"
                                title="删除"></a>
                            <div class="pic"><a href="javascript:;" target="_blank"><img
                                        src="http://n1-q.mafengwo.net/s8/M00/7B/C7/wKgBpVhrvpKAa9hdAAtQcGOc1Bw13.jpeg?imageMogr2%2Fthumbnail%2F%21196x140r%2Fgravity%2FCenter%2Fcrop%2F%21196x140%2Fquality%2F90"></a>
                            </div>
                            <dl class="clearfix">
                                <dd>
                                    <h2><a href="/travel/detail?id=${travel.id}" target="_blank">${travel.title}</a></h2>
                                    <div class="count"><b></b><a href="javascript:void(0);">${travel.thumbsupnum}/${travel.viewnum}</a></div>
                                    <div class="author">
                                        <p class="authorA">
                                            <a href="javascript:;" target="_blank"><img
                                                    src="${travel.author.headImgUrl}" width="20" height="20"></a>作者：<a
                                                href="javascript:;" target="_blank">${travel.author.nickname}</a>
                                        </p>
                                        <p class="authorB"><a href="javascript:;" target="_blank"><img
                                                    src="http://p1-q.mafengwo.net/s10/M00/5F/2C/wKgBZ1kJcr-AUMHaAABJG_1xQP070.jpeg?imageMogr2%2Fthumbnail%2F%2116x16r%2Fgravity%2FCenter%2Fcrop%2F%2116x16%2Fquality%2F90"></a>回复：<a
                                                href="javascript:;" target="_blank">80後_.</a> 2017-01-08 22:22:35
                                        </p>
                                    </div>
                                    <div class="post_info">
                                        <p>${travel.summary}
                                        </p>
                                    </div>
                                </dd>
                            </dl>
                        </li>
                        </#list>
                    </form>
                </ul>
            </div>
            <div class="p-country post-list hide">
                <ul>
                    <#list strategies as strategie>
                    <li class="post-item clearfix">
                        <div class="post-cover">
                            <a href="/strategy/detail?id=${strategie.id}" target="_blank">
                                <img class="lazy" width="215" height="135" alt="带着母亲去三亚悠闲的自由行，高性价比的出行方式_游记"
                                    src="${strategie.coverUrl}"
                                    style="display: inline;"></a>
                        </div>

                        <h2 class="post-title yahei ">
                            <a href="javascript:;" class="title-link" target="_blank">${strategie.subTitle}</a>
                        </h2>
                        <div class="post-author">
                            <span class="author">
                                <a href="javascript:;" target="_blank" rel="nofollow"><img class="lazy"
                                        src="http://n2-q.mafengwo.net/s11/M00/8C/44/wKgBEFrd5bOAGGFYAAAY-AmpOe094.jpeg?imageMogr2%2Fthumbnail%2F%2116x16r%2Fgravity%2FCenter%2Fcrop%2F%2116x16%2Fquality%2F90"
                                        style="display: inline;"></a>
                                作者：<a href="javascript:;" target="_blank" rel="nofollow">${user.nickname}</a>
                            </span>
                            <span class="last-comment">
                                <a href="javascript:;" target="_blank" rel="nofollow"><img
                                        src="http://p3-q.mafengwo.net/s12/M00/35/CD/wKgED1uqIt-AG3w5AAAbM62rsh0384.png?imageMogr2%2Fthumbnail%2F%2116x16r%2Fgravity%2FCenter%2Fcrop%2F%2116x16%2Fquality%2F90"></a>
                                回复：<a href="javascript:;" target="_blank" rel="nofollow">马蜂窝用户</a>
                                <span class="comment-date">19-05-20 23:03</span>
                            </span>
                        </div>
                        <div class="post-content">
                           ${strategie.subTitle}
                        </div>
                        <span class="status"><i class="icon_view"></i>${strategie.viewnum}<i class="icon_comment"></i>${strategie.replynum}</span>
                    </li>
                    </#list>
                </ul>
            </div>
            <div class="p-country hot-list hide">
                <div class="hot-about clearfix _j_hotel" data-id="15735096">
                    <div class="flt1">
                        <a href="javascript:;" target="_blank" class="_j_search_link"><img
                                src="http://b2-q.mafengwo.net/s13/M00/D6/30/wKgEaVyle-2AUoVNAAX-JArlBT856.jpeg?imageMogr2%2Fthumbnail%2F%21480x300r%2Fgravity%2FCenter%2Fcrop%2F%21480x300%2Fquality%2F90"
                                style="width:150px;height:90px;"></a>
                    </div>
                    <div class="ct-text">
                        <h3>
                            <a href="javascript:;" target="_blank" class="_j_search_link">华安华侨<span
                                    class="sr-keyword">旅行社</span></a>
                        </h3>
                        <div class="seg-desc">
                            <p>地址:华安大同路40号</p>
                        </div>
                    </div>
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
                    href="http://www.onlylady.com/">Onlylady女人志</a><a target="_blank"
                    href="http://trip.elong.com/">艺龙旅游指南</a><a target="_blank" href="http://www.cncn.com">欣欣旅游网</a>
                <a target="_blank" href="http://www.8264.com/">户外运动</a><a target="_blank"
                    href="http://www.yue365.com/">365音乐网</a><a target="_blank"
                    href="http://ishare.iask.sina.com.cn/">爱问共享资料</a><a target="_blank"
                    href="http://www.uzai.com/">旅游网</a>
                <a target="_blank" href="http://www.zongheng.com/">小说网</a>
                <a target="_blank" href="http://www.xuexila.com/">学习啦</a><a target="_blank"
                    href="http://www.yododo.com">游多多自助游</a><a target="_blank" href="http://www.zhcpic.com/">问答</a><a
                    target="_blank" href="http://huoche.mafengwo.cn/">火车时刻表</a>
                <a target="_blank" href="http://www.lvmama.com">驴妈妈旅游网</a>
                <a target="_blank" href="http://www.haodou.com/">好豆美食网</a><a target="_blank"
                    href="http://www.taoche.com/">二手车</a><a target="_blank" href="http://www.lvye.cn">绿野户外</a><a
                    target="_blank" href="http://www.tuniu.com/">途牛旅游网</a>
                <a target="_blank" href="http://www.mapbar.com/">图吧</a>
                <a target="_blank" href="http://www.chnsuv.com">SUV联合越野</a><a target="_blank"
                    href="http://www.uc.cn/">手机浏览器</a><a target="_blank" href="http://sh.city8.com/">上海地图</a><a
                    target="_blank" href="http://www.tianqi.com/">天气预报查询</a>
                <a target="_blank" href="http://www.ly.com/">同程旅游</a>
                <a target="_blank" href="http://www.tieyou.com/">火车票</a><a target="_blank"
                    href="http://www.yunos.com/">YunOS</a><a target="_blank" href="http://you.ctrip.com/">携程旅游</a><a
                    target="_blank" href="http://www.jinjiang.com">锦江旅游</a>
                <a target="_blank" href="http://www.huoche.net/">火车时刻表</a>
                <a target="_blank" href="http://www.tripadvisor.cn/">TripAdvisor</a><a target="_blank"
                    href="http://www.tianxun.com/">天巡网</a><a target="_blank" href="http://www.mayi.com/">短租房</a><a
                    target="_blank" href="http://www.zuzuche.com">租租车</a>
                <a target="_blank" href="http://www.5fen.com/">五分旅游网</a>
                <a target="_blank" href="http://www.zhuna.cn/">酒店预订</a><a target="_blank"
                    href="http://www.ailvxing.com">爱旅行网</a><a target="_blank"
                    href="http://360.mafengwo.cn/all.php">旅游</a><a target="_blank"
                    href="http://vacations.ctrip.com/">旅游网</a>
                <a target="_blank" href="http://www.wed114.cn">wed114结婚网</a>
                <a target="_blank" href="http://www.chexun.com/">车讯网</a><a target="_blank"
                    href="http://www.aoyou.com/">遨游旅游网</a><a target="_blank" href="http://www.91.com/">手机</a>
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