<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="/styles/base.css" rel="stylesheet" type="text/css">
    <link href="/styles/homepage.css" rel="stylesheet" type="text/css">
    <link href="styles/mytivketorder.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/system/common.js"></script>
    <script type="text/javascript" src="/js/homepage.js"></script>
    <script>
        $(function () {


            //顶
            //顶：点赞
            $("._j_support_btn").click(function () {
                var sid = $(this).data("sid");
                $.get("/travel/travelThumbup", {sid:sid}, function (data) {
                    if(data.success){
                        $("#thumbnum").html(data.data.thumbsupnum);
                        popup("顶成功啦"); //
                        window.location.reload();
                    }else{
                        if(data.code == 102){
                            popup(data.msg);
                        }else{
                            popup("今天你已经定过了"); //
                        }
                    }
                });
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
        <div class="tags_bar">
            <div class="center clearfix">
                <ul class="flt2">
                    <li ><a class="tags_link" href="/mine/home" title="我的窝">我的窝</a></li>
                    <li><a class="tags_link" href="/mytravelnotes" title="我的游记">我的游记</a></li>
                    <li><a class="tags_link" href="/review" title="我的点评">我的点评</a></li>
                    <li id="_j_pathnav"><a class="tags_link" href="/travelcollection" title="我的收藏">我的收藏</a></li>
                    <li class="on"><a class="tags_link" href="/mytivketorder" title="我的订单">我的订单</a></li>
                    <li><a class="tags_link" href="/setting" title="设置">设置</a></li>
                </ul>
            </div>
        </div>
    </div>


    <table  style="width: 60%;margin:auto">
        <th>景点门票订单信息</th>
        <tr bgcolor="#d8bfd8">
            <th>封面</th>
            <th>景点名称</th>
            <th>景点地址</th>
            <th>订单号</th>
            <th>购买时间</th>
            <th>编辑</th>
        </tr>
        <#list list as order>
            <tr style="text-align: center">
                <td><img src="${(order.ticketId.coverUrl)!}"  width="150" height="60"></td>
                <td>${(order.ticketId.name)!}</td>
                <td>${(order.ticketId.address)!}</td>
                <td>${order.order_num!}</td>
                <td>${order.creatime?string("yyyy-MM-dd HH:mm:ss")!}</td>
                <td>
                    <a id="deleteOrder" href="#" data-id="${order.id}">取消订单</a>
                </td>
            </tr>
        </#list>
        <script>
            $(function () {
                $("#deleteOrder").click(function () {
                    var id = $(this).data("id");
                    $.get("/deletemytivketorder",{id:id},function (data) {
                        if(data.success){
                            alert("取消订单成功");
                            window.location.reload();
                        }else{
                            alert("删除失败,稍后重试");
                        }
                    })
                })
            })
        </script>
    </table>
    <#--航班-->
    <table  style="width: 60%;margin:auto">
       <th>航班订单信息</th>
        <tr bgcolor="#d8bfd8">
            <th>航班号</th>
            <th>机型</th>
            <th>出发时间</th>
            <th>到达时间</th>
            <th>下单时间</th>
            <th>编辑</th>
        </tr>
        <#list airlist as order>
            <tr style="text-align: center">
                <td>${(order.airticket.aircode)!}</td>
                <td>${(order.airticket.planeType)!}</td>
                <td>${(order.airticket.startDate)!?string("yyyy-MM-dd")} +${order.airticket.startTime}</td>
                <td>${(order.airticket.arriveDate)!?string("yyyy-MM-dd")} + ${order.airticket.arriveTime}</td>
                <td>${order.creatime?string("yyyy-MM-dd HH:mm:ss")!}</td>
                <td>
                    <a id="deleteOrder1" href="#" data-id="${order.id}">取消订单</a>
                </td>
            </tr>
        </#list>
        <script>
            $(function () {
                $("#deleteOrder1").click(function () {
                    var id = $(this).data("id");
                    $.get("/deletemytivketorder1",{id:id},function (data) {
                        if(data.success){
                            alert("取消订单成功");
                            window.location.reload();
                        }else{
                            alert("删除失败,稍后重试");
                        }
                    })
                })
            })
        </script>
    </table>

    <#--酒店-->
    <table  style="width: 60%;margin:auto">
        <th>酒店订单信息</th>
        <tr bgcolor="#d8bfd8">
            <th>酒店封面</th>
            <th>酒店名称</th>
            <th>酒店地址</th>
            <th>入住时间</th>
            <th>退房时间</th>
            <th>编辑</th>
        </tr>
        <#list hotels as order>
            <tr style="text-align: center">
                <td><img src="${(order.coverUrl)!}"width="120" height="60"> </td>
                <td>${(order.name)!}</td>
                <td>${(order.address)!}</td>
                <td>${(order.tool.checkIn)!?string("yyyy-MM-dd")}</td>
                <td>${(order.tool.checkOut)!?string("yyyy-MM-dd")}</td>
                <td>
                    <a id="deleteOrder2" href="#" data-id="${order.tool.orderId}">取消订单</a>
                </td>
            </tr>
        </#list>
        <script>
            $(function () {
                $("#deleteOrder2").click(function () {
                    var id = $(this).data("id");
                    $.get("/deletemytivketorder2",{id:id},function (data) {
                        if(data.success){
                            alert("取消订单成功");
                            window.location.reload();
                        }else{
                            alert("删除失败,稍后重试");
                        }
                    })
                })
            })
        </script>
    </table>



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