<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="/styles/base.css" rel="stylesheet" type="text/css">
    <link href="/styles/homepage.css" rel="stylesheet" type="text/css">
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
                        $("#topvote12894894").html(data.data.thumbsupnum);
                        popup("顶成功啦"); //
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
                            <span class="t"><a class="infoItem" href="javascript:;"><img
                                        src="http://b2-q.mafengwo.net/s12/M00/35/B7/wKgED1uqIs-AMYTwAAAX-VIKIo0071.png?imageMogr2%2Fthumbnail%2F%2132x32r%2Fgravity%2FCenter%2Fcrop%2F%2132x32%2Fquality%2F90"
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
            <div class="tags_bar">
                <div class="center clearfix">
                    <ul class="flt2">
                        <li class="on"><a class="tags_link" href="javascript:;" title="我的窝">我的窝</a></li>
                        <li><a class="tags_link" href="/mytravelnotes" title="我的游记">我的游记</a></li>
                        <li><a class="tags_link" href="/review" title="我的点评">我的点评</a></li>
                        <li id="_j_pathnav"><a class="tags_link" href="./travelcollection.html" title="我的收藏">我的收藏</a></li>
                        <li><a class="tags_link" href="javascript:;" title="我的订单">我的订单</a></li>
                        <li><a class="tags_link" href="./setting.html" title="设置">设置</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="center clearfix">
            <div class="side_bar flt1">
                <div class="MAvatar">
                    <div class="MAvaImg hasAva">
                        <img src="${userinfo.headImgUrl}"
                            height="120" width="120" alt="蚂蜂测试窝用户"><a href="javascript:;" class="MAvaUp"><i
                                class="Mphoto"></i></a>
                    </div>
                    <div class="MAvaName">${userinfo.nickname}

                        <i class="MGenderMale"></i>
                    </div>

                    <div class="its_tags">
                        <a href="javascript:;" target="_blank" title="VIP"><i class="vip"></i></a>
                        <a href="javascript:;" target="_blank" title="分舵"><i class="duo"></i>
                        </a><a href="javascript:;" target="_blank" title="指路人"><i class="zhiluren"></i></a>
                    </div>
                    <div class="MAvaInfo clearfix MAvaMyInfo">
                        <span class="MAvaLevel flt1">等级：<a href="javascript:;" title="Lv.5"
                                target="_blank">${userinfo.level}</a></span>
                        <span class="MAvaPlace flt1" title="广州">现居：${userinfo.city}</span> <span class="MAvaSet"><a title="设置"
                                href="javascript:;" target="_blank"></a></span>
                    </div>
                    <div id="_j_profilearea" class="MAvaProfile">
                        <div class="MProfile _j_showintrobox" data-intro="sdddds" style="display: block;">
                            <pre>${(userinfo.info)!}</pre>
                        </div>
                        <div class="MAvaInput _j_inputarea hide">
                            <textarea id="_j_introarea" placeholder="例：摄影师/旅居澳洲/潜水爱好者" maxlength="100"></textarea>
                            <a role="button" id="_j_introsaver" class="MAvaBtn" title="保存">保存</a>
                        </div>

                    </div>
                    <div class="MAvaMore clearfix">
                        <div class="MAvaNums">
                            <strong><a href="javascript:;" target="_blank">13</a></strong>
                            <p>关注</p>
                        </div>
                        <div class="MAvaNums">
                            <strong><a href="javascript:;" target="_blank">0</a></strong>
                            <p>粉丝</p>
                        </div>
                        <div class="MAvaNums last">
                            <strong><a href="javascript:;" target="_blank">20</a></strong>
                            <p>蜂蜜</p>
                        </div>
                    </div>
                </div>
                <div class="MUsers">
                    <div class="MUsersTitle">我的关注</div>
                    <div class="MUsersDetail" id="_j_followcnt">
                        <div class="MUsersAtom">
                            <ul class="clearfix _j_followlist">
                                <li>
                                    <a href="javascript:;" target="_blank">
                                        <img src="http://b4-q.mafengwo.net/s12/M00/03/71/wKgED1wW0XCALX2IAADYXbhIC3Q65.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                                            height="48" width="48" alt="桃小桃和她的喵" title="桃小桃和她的喵">
                                    </a>
                                    <p><a href="javascript:;" target="_blank" title="桃小桃和她的喵">桃小桃和她的喵</a></p>
                                </li>
                                <li>
                                    <a href="javascript:;" target="_blank">
                                        <img src="http://p3-q.mafengwo.net/s8/M00/ED/05/wKgBpVYUydOAKdaaAAlyxu5BVPc94.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                                            height="48" width="48" alt="云云" title="云云">
                                    </a>
                                    <p><a href="javascript:;" target="_blank" title="云云">云云</a></p>
                                </li>
                                <li>
                                    <a href="javascript:;" target="_blank">
                                        <img src="http://b1-q.mafengwo.net/s12/M00/B0/D7/wKgED1xEOeCAepriAADB6P4hrk080.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                                            height="48" width="48" alt="文刀水羊" title="文刀水羊">
                                    </a>
                                    <p><a href="javascript:;" target="_blank" title="文刀水羊">文刀水羊</a></p>
                                </li>
                                <li>
                                    <a href="javascript:;" target="_blank">
                                        <img src="http://n4-q.mafengwo.net/s11/M00/1A/8F/wKgBEFr-7WKAfFPiAABz4qeKy-c65.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                                            height="48" width="48" alt="翔太" title="翔太">
                                    </a>
                                    <p><a href="javascript:;" target="_blank" title="翔太">翔太</a></p>
                                </li>
                                <li>
                                    <a href="javascript:;" target="_blank">
                                        <img src="http://b3-q.mafengwo.net/s9/M00/B2/19/wKgBs1aVP9uAeflmAASv31idm1M01.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                                            height="48" width="48" alt="Sordino_Li" title="Sordino_Li">
                                    </a>
                                    <p><a href="javascript:;" target="_blank" title="Sordino_Li">Sordino_Li</a></p>
                                </li>
                                <li>
                                    <a href="javascript:;" target="_blank">
                                        <img src="http://n1-q.mafengwo.net/s9/M00/D3/93/wKgBs1da3ceAFTPMAACjdPpGr3M65.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                                            height="48" width="48" alt="butterflyvalley" title="butterflyvalley">
                                    </a>
                                    <p><a href="javascript:;" target="_blank"
                                            title="butterflyvalley">butterflyvalley</a></p>
                                </li>
                                <li>
                                    <a href="javascript:;" target="_blank">
                                        <img src="http://b4-q.mafengwo.net/s9/M00/C3/D2/wKgBs1hYqd-AIbARAAClh_wvlnc64.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                                            height="48" width="48" alt="幸存者格蕾丝" title="幸存者格蕾丝">
                                    </a>
                                    <p><a href="javascript:;" target="_blank" title="幸存者格蕾丝">幸存者格蕾丝</a></p>
                                </li>
                                <li>
                                    <a href="javascript:;" target="_blank">
                                        <img src="http://p1-q.mafengwo.net/s10/M00/5F/95/wKgBZ1mWdF6AFf2fAAB1tTikS6w24.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                                            height="48" width="48" alt="法系强迫症" title="法系强迫症">
                                    </a>
                                    <p><a href="javascript:;" target="_blank" title="法系强迫症">法系强迫症</a></p>
                                </li>

                            </ul>
                        </div>
                        <!-- <div class="MSimplePages _j_follow_page_action" data-total="13"><span
                                class="MPrev _j_prev disabled" title="上一页"></span><span class="MNext _j_next"
                                title="下一页"></span></div> -->
                    </div>
                </div>
            </div>
            <div class="content flt2">
                <div class="common_block my_notes">
                    <#list travels as map>
                        <div class="notes_list">
                            <ul>
                                <li data-order="1" data-top="0">
                                    <dl>
                                        <dt>
                                            <a href="javascript:;" target="_blank" id="_j_coverlink_12894894"><img
                                                    src="${map.travel.coverUrl!}"
                                                    height="400" width="680" alt="封面"></a>
                                            <div class="hover_item">
                                                <div class="thumb_description">
                                                    <strong>${(map.travel.dest.name)!}/</strong>
                                                    <span>中国/</span>
                                                </div>
                                            </div>
                                        </dt>
                                        <dd>
                                            <div class="note_title clearfix">
                                                <div class="MDing">
                                                    <span id="topvote12894894">${map.travel.thumbsupnum}</span><a role="button" class="_j_support_btn"
                                                        data-japp="articleding" rel="nofollow" data-sid="${map.travel.id!}"
                                                        data-vote="0" title="顶一下">顶</a>
                                                </div>
                                                <div class="note_info">
                                                    <h3>
                                                        <a href="javascript:;" target="_blank" title="游记1">${map.travel.title}</a></h3>
                                                    <div class="note_more">

                                                        <span class="MInfoNum"><i class="MIcoView"></i><em>${map.travel.favornum}/${map.travel.sharenum}</em></span>

                                                        <span class="MInfoNum"><i class="MIcoStar"></i><em>${map.travel.viewnum}</em></span>
                                                        <span class="time">${map.travel.releaseTime?string('yyyy-MM-dd')}</span>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="note_word">
                                               <#list map.travelComments as travelContent>
                                                   <img src="${travelContent.headUrl}" height="48" width="48"/>
                                                   ${travelContent.username}:
                                                   ${travelContent.content}<br/>
                                               </#list>
                                            </div>
                                        </dd>
                                    </dl>
                                </li>

                            </ul>
                        </div>
                    </#list>

                    <div class="more_notes">
                        <a class="btn_deleted" href="javascript:;"><i></i>已删除游记</a>
                        <a href="javascript:;">共<strong>${sum}</strong>篇游记 </a>
                    </div>

                </div>
                <div class="common_block my_ask my_dp" id="_j_commentwrap">
                    <div class="dp_list">
                        <ul>
                            <li class="first">
                                <dl>
                                    <dt>
                                        <div class="dp_handles flt2">
                                            <div class="dp_ding flt2"><a role="button" title="顶一下" class="disabled"
                                                    data-id="191713354"></a><strong class="_j_dingnum"
                                                    style="display:none">0</strong></div>
                                        </div>
                                        <div class="dp_title"><a href="javascript:;"
                                                target="_blank"><span>斯里纳斯国家海洋公园</span><br>SirinatMarineNationalPark</a>
                                        </div>
                                        <div class="MStar">
                                            <div class="MStarIco MStarL3"><span></span></div>
                                            <span class="MStarTips">一般般</span>
                                        </div>
                                    </dt>
                                    <dd>
                                        <div class="dp_detail">
                                            <div class="dp_word">ggg斯里纳斯国家海洋公园斯里纳斯国家海洋公园斯里纳斯国家海洋公园f<br>
                                                斯里纳斯国家海洋公园斯里纳斯国家海洋公园</div>
                                            <div class="dp_pics">
                                                <ul class="clearfix">
                                                </ul>
                                            </div>
                                            <div class="dp_comment MInfoNum"><i
                                                    class="MIcoComment"></i><span><strong>0</strong>条回复</span></div>
                                        </div>
                                    </dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>
                                        <div class="dp_handles flt2">
                                            <div class="dp_ding flt2"><a role="button" title="顶一下" class="disabled"
                                                    data-id="191713351"></a><strong class="_j_dingnum"
                                                    style="display:none">0</strong></div>
                                        </div>
                                        <div class="dp_title"><a href="javascript:;"
                                                target="_blank"><span>普吉岛机场酒店</span><br>Phuket Airport Inn</a></div>
                                        <div class="MStar">
                                            <div class="MStarIco MStarL3"><span></span></div>
                                            <span class="MStarTips">一般般</span>
                                        </div>
                                    </dt>
                                    <dd>
                                        <div class="dp_detail">
                                            <div class="dp_word">普吉岛机场酒店 Phuket Airport Inn</div>
                                            <div class="dp_pics">
                                                <ul class="clearfix">
                                                </ul>
                                            </div>
                                            <div class="dp_comment MInfoNum"><i
                                                    class="MIcoComment"></i><span><strong>0</strong>条回复</span></div>
                                        </div>
                                    </dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
                    <div class="more_notes">
                        <a href="javascript:;">共<strong>2</strong>点评</a>
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