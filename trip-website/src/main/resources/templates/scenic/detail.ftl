<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="/styles/base.css" rel="stylesheet" type="text/css">
    <link href="/styles/replyDetail.css" rel="stylesheet" type="text/css">


    <script type="text/javascript" src="/js/jquery.js"></script>
    <script src="/js/plugins/jquery-form/jquery.form.js"></script>
    <script type="text/javascript" src="/js/jquery-upload/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="/js/jquery-upload/jquery.iframe-transport.js"></script>
    <script type="text/javascript" src="/js/jquery-upload/jquery.fileupload.js"></script>

    <script src="/js/plugins/jquery-form/jquery.form.js"></script>



    <script type="text/javascript">
    </script>
</head>

<body>
<#assign currentNav="destination">
    <#include "../common/navbar.ftl">

<!----------------------------------------->
<form action="/coverImageUpload" method="post" id="coverForm">
    <input type="file" name="pic" id="coverBtn" style="display: none;">
</form>

<div class="container" data-cs-t="景点详情页">

    <div class="row row-top">
        <div class="wrapper">
            <div class="extra">
                <!-- 天气 S-->
                <div class="weather" data-cs-p="天气">
                    <a href="/weather/10088.html" target="_blank">
                        <img src="http://images.mafengwo.net/images/mdd_weather/icon/icon34.png" width="25" height="25">
                        <span>中雨 27℃~34℃</span>
                    </a>
                </div>
                <!-- 天气 E-->
                <!-- 收藏去过 S-->
                <div class="action _j_rside want-been">
                    <div class="been-box">
                        <a class="_j_beenpoi btn-been _j_hovergo" href="/path/" target="_blank" title="添加至我的足迹"
                           data-cs-p="足迹">
                            <i class="icon"></i>
                            <span class="txt">去过</span>
                        </a>
                        <div class="rate-pop" style="display:none;">
                            <div class="rank-star">
                                <span class="s-star s-star0"></span>
                                <div class="click_star">
                                    <a title="1星" rel="nofollow" data-num="1"></a>
                                    <a title="2星" rel="nofollow" data-num="2"></a>
                                    <a title="3星" rel="nofollow" data-num="3"></a>
                                    <a title="4星" rel="nofollow" data-num="4"></a>
                                    <a title="5星" rel="nofollow" data-num="5"></a>
                                </div>
                            </div>
                            <span class="rank-hint">必去推荐</span>
                        </div>
                    </div>
                    <a class="_j_favpoi btn-collect " href="/plan/fav.php?iMid=10088" target="_blank" title="添加收藏"
                       data-cs-p="收藏">
                        <i class="icon"></i>
                        <span class="txt">收藏</span>
                    </a>
                </div>
                <!-- 收藏去过 E-->
            </div>
            <!-- 面包屑 S-->
            <div class="crumb" data-cs-p="面包屑">
                <div class="item"><a href="/mdd/" target="_blank">目的地</a><em>&gt;</em></div>
                <div class="item">
                    <div class="drop">
                        <span class="hd"><a href="/travel-scenic-spot/mafengwo/10088.html">广州<i></i></a></span>
                        <div class="bd">
                            <i class="arrow"><b></b></i>
                            <div class="col">
                                <ul class="clearfix">
                                    <li><a href="/jd/10088/gonglve.html" target="_blank">广州景点</a></li>
                                    <li><a href="/hotel/10088/" target="_blank">广州酒店</a></li>
                                    <li><a href="/cy/10088/gonglve.html" target="_blank">广州美食</a></li>
                                    <li><a href="/gw/10088/gonglve.html" target="_blank">广州购物</a></li>
                                    <li><a href="/yl/10088/gonglve.html" target="_blank">广州娱乐</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <em>&gt;</em>
                </div>
                <div class="item cur">广州景点</div>
            </div>
            <!-- 面包屑 E-->


            <!-- POI名称 S-->
            <div class="title">
                <h1>${scenic.name!}</h1>
                <div class="en">${scenic.enName!}</div>
            </div>
            <!-- POI名称 E-->

            <!-- 快捷导航 S-->
            <div style="height: 60px;">
                <div class="r-nav" id="poi-navbar" data-cs-p="快捷导航">
                    <ul class="clearfix">
                        <li data-scroll="overview" class="on">
                            <a title="概况">概况</a>
                        </li>
                        <li data-scroll="attractions" style="display: none">
                            <a title="景点亮点">景点亮点</a>
                        </li>
                        <li data-scroll="commentlist">
                            <a title="蜂蜂点评" href="#commentlist">蜂蜂点评<span>（5592条）</span></a>
                        </li>


                        <li data-scroll="comment" class="nav-right">
                            <a class="btn-reviews" title="我要点评">我要点评</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- 快捷导航 E-->

        </div>
    </div>

    <script type="text/javascript">
        (function () {
            //面包屑
            $('.drop').hover(function () {
                var target = $(this);
                clearTimeout(target.data('hideTimer'));
                target.addClass('open');
                target.children('bd').fadeIn(200);
            }, function () {
                var target = $(this);
                target.data("hideTimer", setTimeout(function () {
                    target.removeClass('open');
                    target.children('bd').fadeOut(200);
                }, 100));
            });
            //导航
            var $navbar = $('#poi-navbar'),
                    offset_top,
                    $lis = $navbar.find("li").not('.nav-right');
            $('<div/>').insertBefore($navbar).append($navbar).height($navbar.outerHeight(true));
            $(function () {
                offset_top = $navbar.offset().top;
                $(window).bind('scroll.poinav', setFixed).trigger("scroll.poinav");
            });
            $(document).delegate("[data-scroll]", "click", function () {
                scrollTo($(this));
            });

            function setFixed() {
                var $rows = $('body >.container >[data-anchor]'),
                        scrolltop = $(document).scrollTop(),
                        h,
                        _lis = $lis.filter(":visible"),
                        currIndex;
                if (scrolltop > offset_top) {
                    if (!$navbar.hasClass('fixed')) {
                        $navbar.addClass('fixed');
                    }
                    h = $navbar.outerHeight(true);
                    for (var $li, $row, top, i = 0, j = _lis.length; i < j; i++) {
                        $row = $rows.filter("[data-anchor=" + ($li = _lis.eq(i)).attr("data-scroll") + "]");
                        if ($row[0] && (top = $row.offset().top) && (/*i == (j - 1) ||*/
                                        ((top - h <= scrolltop) && (top + $row.outerHeight() - h > scrolltop)))) {
                            currIndex = i;
                            break;
                        }
                    }
                    if (i == j) {
                        _lis.removeClass("on");
                    } else {
                        _lis.eq(currIndex || 0).addClass("on").siblings().removeClass("on");
                    }
                } else {
                    if ($navbar.hasClass('fixed')) {
                        $navbar.removeClass('fixed');
                    }
                    _lis.eq(0).addClass("on").siblings().removeClass("on");
                }
            }
        })();
    </script>
    <div data-anchor="overview">
        <div class="row row-picture row-bg">
            <div class="wrapper">
                <a class="photo" data-cs-p="相册" href="/photo/poi/25091.html" target="_blank">
                    <div class="bd">
                        <div class="pic-big"><img
                                src="${scenic.coverUrls[0]}"
                                width="690" height="370"></div>
                        <div class="pic-small"><img
                                src="${scenic.coverUrls[1]}"
                                width="305" height="183"></div>
                        <div class="pic-small"><img
                                src="${scenic.coverUrls[2]}"
                                width="305" height="183"></div>
                        <span>${(scenic.coverUrlsLength)!}张图片</span></div>
                </a></div>
        </div>

        <!-- 简介 S -->
        <div class="mod mod-detail" data-cs-p="概况">
            <div class="summary">
                ${scenic.summary!}
            </div>

            <ul class="baseinfo clearfix">
                <li class="tel">
                    <div class="label">电话</div>
                    <div class="content">${scenic.tel}</div>
                </li>
                <li class="item-site">
                    <div class="label">网址</div>
                    <div class="content"><a href="${scenic.url}" target="_blank" rel="nofollow">${scenic.url}</a>
                    </div>
                </li>
                <li class="item-time">
                    <div class="label">用时参考</div>
                    <div class="content">${(scenic.travelTime)!}</div>
                </li>
            </ul>

            <dl>
                <dt>交通</dt>
                <dd>${(scenic.content)!}</dd>
            </dl>
            <dl>
                <dt>门票</dt>
                <dd>
                    <div>
                        <div>
                            已售完~  明年再来叭
                        ${scenic.ticketInfo!}
                        </div>

                    </div>

                </dd>
            </dl>
            <dl>
                <dt>开放时间</dt>
                <dd>
                    <div>09:30-22:30；停止入场时间:22:00 (1月1日-12月31日 周一-周日)<br>
                        tips:<br>
                        摩天轮：10:00-22:30；逢周一：15:00-22:30；每月最后一周周一：17:00-22:30。<br>
                        极速云霄：10:00-22:30；逢周一：12:00-22:30；每月最后一周周一：17:00-22:30。<br>
                        广州塔实行分时段观光游览，门票以2小时为一个时段。入塔时间为:09:30、12:00、14:00、16:00、20:00
                    </div>

                </dd>
            </dl>

            <div style="color:#999;font-size:12px;" data-cs-p="概况-感谢蜂蜂">
                *信息更新时间：2019-07-14&nbsp;&nbsp;&nbsp;&nbsp;
                感谢蜂蜂 <a href="/u/79650791.html" target="_blank">一点点的爱</a>
                参与了编辑
            </div>
        </div>
        <!-- 简介 E -->

        <!-- 内部景点 S -->
        <div data-anchor="subPoilist">
            <div id="pagelet-block-bb456ee5b764682811223f9b8d30739e" class="pagelet-block"
                 data-api=":poi:pagelet:poiSubPoiApi" data-params="{&quot;poi_id&quot;:&quot;25091&quot;}"
                 data-async="1"
                 data-controller="/js/poi/ControllerPoiSubPoi">
                <div class="mod mod-innerScenic" data-cs-p="内部景点">
                    <div class="mhd">内部景点</div>
                    <div class="mbd">
                        <ul class="clearfix">
                        <#list innerScenic as insc>
                            <li>
                                <a href="#" target="_blank" title="${(insc.name)!}">
                                    <img src="${(insc.coverUrls[0])!}"
                                         width="235" height="150">
                                    <span class="num num-top">${(insc_index+1)!}</span>
                                    <div class="info">
                                        <h3>${(insc.name)!}</h3>
                                        <span><em>1341</em>人去过</span>
                                    </div>
                                </a>
                            </li>
                        </#list>
                        </ul>
                    </div>
                    <div class="more more-subpoi">
                        <a class="btn-subpoi" data-page="1">查看更多</a>
                    </div>
                </div>
                <style>
                    .mod-innerScenic .more {
                        margin-top: 20px;
                        text-align: center;
                    }

                    .mod-innerScenic .more a {
                        display: inline-block;
                        width: 160px;
                        height: 50px;
                        background-color: #fff;
                        border: 1px solid #fc9c27;
                        line-height: 50px;
                        color: #ff9d00;
                        font-size: 14px;
                        border-radius: 4px;
                        text-align: center;
                    }

                    .mod-innerScenic .num {
                        width: 40px;
                    }
                </style>
            </div>
        </div>
        <!-- 内部景点 E -->

    </div>

    <!--评论-->
    <div data-anchor="commentlist">

        <div id="pagelet-block-15f9d6d9ad9f6c363d2d27120e8a6198" class="pagelet-block"
             data-api=":poi:pagelet:poiCommentListApi" data-params="{&quot;poi_id&quot;:&quot;25091&quot;}"
             data-async="1"
             data-controller="/js/poi/ControllerPoiComment">
            <div class="mod mod-reviews" data-cs-p="评论列表">
                <div class="mhd mhd-large">蜂蜂点评<span>（共有<em>5592</em>条真实评价）</span></div>
                <div class="review-nav">
                    <ul class="clearfix">
                        <li data-type="0" data-category="0" class="on"><span class="divide"></span><a
                                href="javascript:void(0);"><span>全部</span></a></li>
                        <li data-type="0" data-category="2" class="">
                            <span class="divide"></span>
                            <a href="javascript:void(0);"><span>有图</span><span class="num"> (1356条)</span></a>
                        </li>
                        <li data-type="1" data-category="13" class="">
                            <span class="divide"></span>
                            <a href="javascript:void(0);">
                                <span>好评</span>
                                <span class="num">（4749条）</span>
                            </a>
                        </li>
                        <li data-type="1" data-category="12" class="">
                            <span class="divide"></span>
                            <a href="javascript:void(0);">
                                <span>中评</span>
                                <span class="num">（750条）</span>
                            </a>
                        </li>
                        <li data-type="1" data-category="11" class="">
                            <span class="divide"></span>
                            <a href="javascript:void(0);">
                                <span>差评</span>
                                <span class="num">（93条）</span>
                            </a>
                        </li>
                        <li data-type="2" data-category="178487584" class="">
                            <span class="filter-word divide"></span>
                            <a href="javascript:void(0);">标志性建筑<span class="num">（535人提及）</span></a>
                        </li>
                        <li data-type="2" data-category="103125314" class="">
                            <span class="filter-word divide"></span>
                            <a href="javascript:void(0);">人很多<span class="num">（141人提及）</span></a>
                        </li>
                        <li data-type="2" data-category="183864017" class="">
                            <span class="filter-word divide"></span>
                            <a href="javascript:void(0);">值得去<span class="num">（118人提及）</span></a>
                        </li>
                        <li data-type="2" data-category="104277092" class="">
                            <span class="filter-word divide"></span>
                            <a href="javascript:void(0);">恐高<span class="num">（112人提及）</span></a>
                        </li>
                        <li data-type="2" data-category="176664633" class="">
                            <span class="filter-word divide"></span>
                            <a href="javascript:void(0);">交通方便<span class="num">（92人提及）</span></a>
                        </li>
                        <li data-type="0" data-category="1" class="">
                            <span class="divide"></span>
                            <a href="javascript:void(0);"><span>金牌点评</span><span class="num"> (33条)</span></a>
                        </li>
                    </ul>
                </div>
                <div class="loading-img" style="display: none;"><img
                        src="http://images.mafengwo.net/images/weng/loading3.gif"> Loading...
                </div>

                <div class="_j_commentlist">
                    <div class="rev-list">
                        <ul>
                            <#list comments as c>
                                <li class="rev-item comment-item clearfix">
                                    <div class="user"><a class="avatar" href="/u/52068941.html" target="_blank"><img
                                            src="${c.headUrl!}"
                                            width="48" height="48"></a><span class="level">LV.21</span></div>
                                    <a class="useful" data-id="191407415" title="点赞">
                                        <i></i><span class="useful-num">1</span>
                                    </a>
                                    <a class="name" href="/u/52068941.html" target="_blank">${c.username}</a>
                                    <span class="s-star s-star4"></span>
                                    <p class="rev-txt">${(c.content)!}<br>

                                    </p>

                                    <div class="rev-img">
                                        <#if c.imgList??>
                                        <#list c.imgList as imgs>
                                            <a href="/photo/poi/25091_440424016.html" target="_blank"><img
                                                    src="${(imgs.img)!}"
                                                    width="200" height="120"></a>
                                        </#list>
                                        </#if>
                                    </div>

                                    <div class="info clearfix">
                                        <a class="btn-comment _j_comment" title="添加评论">评论</a>
                                        <span class="time">${(c.createTime)!?string('yyyy-MMdd HH:mm:ss')}</span>
                                        <span class="from">
                                此条点评来自游记<a href="/i/12601474.html" target="_blank">《南国花城正月中 ——2019年春节广州记（含长...》</a>
                            </span>
                                    </div>

                                    <div class="comment add-reply ">
                                        <ul class="more_reply_box comment_list">
                                        <#if c.commentList??>
                                        <#list c.commentList as list>
                                        <li>
                                            <a href="/u/63107989.html" target="_blank">
                                                <img src="http://b4-q.mafengwo.net/s9/M00/DA/0D/wKgBs1g919mAVdRVAACpgsqFw_Y38.jpeg?imageMogr2%2Fthumbnail%2F%2116x16r%2Fgravity%2FCenter%2Fcrop%2F%2116x16%2Fquality%2F90"
                                                     width="16" height="16">${list.username}
                                            </a>
                                            ：${list.content}
                                            <a class="_j_reply re_reply" data-id="625204" data-userId="${c.userId}" name="re_reply"
                                               data-username="${c.username}" title="添加回复">回复</a>
                                            <br><span class="time">${list.createTime?string('dd.MM.yyyy HH:mm:ss')}</span>
                                        </li>
                                        </#list>
                                        </#if>
                                        </ul>

                                        <div class="add-comment hide reply-form">
                                    <textarea class="comment_reply"
                                              data-poi_name="广州塔"
                                              data-parent_id="" data-parent_uid="" data-parent_username=""
                                              style="overflow: hidden; color: rgb(204, 204, 204);"></textarea>
                                            <a class="btn btn_submit_reply"
                                               data-userid="${c.userId}"
                                               data-username="${c.username}" data-scenicid="${c.scenicId}"  data-commentid="${c.id}"
                                            >回复</a>
                                        </div>
                                    </div>
                                </li>
                            </#list>
                        </ul>
                    </div>

                    <div align="right" class="m-pagination">
                        <span class="count">共<span>5</span>页 / <span>5592</span>条</span>

                        <span class="pg-current">1</span>
                        <a class="pi" data-page="2" rel="nofollow" title="第2页">2</a>
                        <a class="pi" data-page="3" rel="nofollow" title="第3页">3</a>
                        <a class="pi" data-page="4" rel="nofollow" title="第4页">4</a>
                        <a class="pi" data-page="5" rel="nofollow" title="第5页">5</a>

                        <a class="pi pg-next" data-page="2" rel="nofollow" title="后一页">后一页</a>
                        <a class="pi pg-last" data-page="5" rel="nofollow" title="末页">末页</a>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div data-anchor="comment">
        <div class="row row-reviewForm" id="comment_20190714202243" data-cs-p="点评">
            <div class="wrapper">

                <div class="mfw-reviews">
                    <div id="_j_commentform_cnt">
                        <h2>
                            <strong>广州塔</strong>
                            <em>*</em>为必填选项
                        </h2>
                        <form id="editForm" action="/scenic/addAnswer" method="post" class="_j_commentdialogform" data-typeid="3">
                            <input type="hidden" name="imgs" id="coverValue" >
                            <input type="hidden" name="scenicId" id="scenicId" value="${scenic.id}">
                        <#--利用当前登录用户赋值吧-->
                        <#--<input type="hidden" name="userId" id="userid" value="${user.id}">-->
                            <input type="hidden" name="type" value="0" id="commentType">
                            <input type="hidden" name="refComment.userId" id="refAuthorId">
                            <input type="hidden" name="refComment.username" id="refUsername">
                            <input type="hidden" name="refComment.id" id="commentid">
                            <textarea style="display:none" name="content" id="comment_reply"></textarea>

                            <div class="review-item item-star">
                                <div class="label"><em>*</em>总体评价</div>
                                <div class="review-star _j_rankblock" data-star="" name="rank">
                                    <input type="hidden" name="rank" value="" essential="1" data-inputname="总体评价">
                                    <span class="_j_starcount star0"></span>
                                    <div class="click-star _j_starlist">
                                        <a role="button" title="千万别去" rel="nofollow"></a>
                                        <a role="button" title="不推荐" rel="nofollow"></a>
                                        <a role="button" title="一般般" rel="nofollow"></a>
                                        <a role="button" title="值得一去" rel="nofollow"></a>
                                        <a role="button" title="必须推荐" rel="nofollow"></a>
                                    </div>

                                </div>
                                <span class="txt-tips _j_startip">点击星星打分</span>
                            </div>
                            <div class="review-group">
                                <div class="review-item item-rating"
                                     data-conf="{&quot;type&quot;:&quot;select&quot;,&quot;notnull&quot;:&quot;1&quot;,&quot;name&quot;:&quot;\u98ce\u5149&quot;,&quot;conf&quot;:{&quot;options&quot;:[&quot;1&quot;,&quot;2&quot;,&quot;3&quot;,&quot;4&quot;,&quot;5&quot;]},&quot;show&quot;:{&quot;style&quot;:&quot;starRank&quot;}}">
                                    <div class="label"><em>*</em>风光</div>
                                    <div class="review-score _j_rankblock" data-star="" name="scene_rank">
                                        <input type="hidden" name="scene_rank" value="" essential="1"
                                               data-inputname="给风光的评分">
                                        <span class="_j_starcount star0"></span>
                                        <div class="click-star _j_starlist">
                                            <a role="button" title="特别差" rel="nofollow"></a>
                                            <a role="button" title="不太好" rel="nofollow"></a>
                                            <a role="button" title="一般般" rel="nofollow"></a>
                                            <a role="button" title="很棒" rel="nofollow"></a>
                                            <a role="button" title="超出预期" rel="nofollow"></a>
                                        </div>
                                    </div>
                                    <span class="txt-tips _j_startip">给风光打分</span>
                                </div>
                                <div class="review-item item-rating"
                                     data-conf="{&quot;type&quot;:&quot;select&quot;,&quot;notnull&quot;:&quot;1&quot;,&quot;name&quot;:&quot;\u7279\u8272&quot;,&quot;conf&quot;:{&quot;options&quot;:[&quot;1&quot;,&quot;2&quot;,&quot;3&quot;,&quot;4&quot;,&quot;5&quot;]},&quot;show&quot;:{&quot;style&quot;:&quot;starRank&quot;}}">
                                    <div class="label"><em>*</em>特色</div>
                                    <div class="review-score _j_rankblock" data-star="" name="feature_rank">
                                        <input type="hidden" name="feature_rank" value="" essential="1"
                                               data-inputname="给特色的评分">
                                        <span class="_j_starcount star0"></span>
                                        <div class="click-star _j_starlist">
                                            <a role="button" title="特别差" rel="nofollow"></a>
                                            <a role="button" title="不太好" rel="nofollow"></a>
                                            <a role="button" title="一般般" rel="nofollow"></a>
                                            <a role="button" title="很棒" rel="nofollow"></a>
                                            <a role="button" title="超出预期" rel="nofollow"></a>
                                        </div>

                                    </div>
                                    <span class="txt-tips _j_startip">给特色打分</span>
                                </div>
                                <div class="review-item item-rating"
                                     data-conf="{&quot;type&quot;:&quot;select&quot;,&quot;notnull&quot;:&quot;1&quot;,&quot;name&quot;:&quot;\u670d\u52a1&quot;,&quot;conf&quot;:{&quot;options&quot;:[&quot;1&quot;,&quot;2&quot;,&quot;3&quot;,&quot;4&quot;,&quot;5&quot;]},&quot;show&quot;:{&quot;style&quot;:&quot;starRank&quot;}}">
                                    <div class="label"><em>*</em>服务</div>
                                    <div class="review-score _j_rankblock" data-star="" name="service_rank">
                                        <input type="hidden" name="service_rank" value="" essential="1"
                                               data-inputname="给服务的评分">
                                        <span class="_j_starcount star0"></span>
                                        <div class="click-star _j_starlist">
                                            <a role="button" title="特别差" rel="nofollow"></a>
                                            <a role="button" title="不太好" rel="nofollow"></a>
                                            <a role="button" title="一般般" rel="nofollow"></a>
                                            <a role="button" title="很棒" rel="nofollow"></a>
                                            <a role="button" title="超出预期" rel="nofollow"></a>
                                        </div>

                                    </div>
                                    <span class="txt-tips _j_startip">给服务打分</span>
                                </div>
                            </div>
                            <div class="review-item item-comment">
                                <div class="label"><em>*</em>评价</div>
                                <div class="content">
                                <textarea class="_j_commentarea" name="content" essential="1" data-inputname="点评内容"
                                          placeholder="详细、客观、真实，130字以上为佳！上传图片会加分哦！" data-minlen="15"
                                          data-maxlen="1000"></textarea>
                                    <p class="_j_commentcounttip">15-1000个字</p>
                                </div>
                            </div>







                            <div class="review-item item-photo">
                                <div class="label">上传照片</div>
                                <div class="avatar" id="_j_avatar_box">
                                    <img src=""
                                         width="120" height="120" border="0" id="headImage">
                                </div>
                                <input type="button" id="file_upload" value="选择图片">


                                <script>
                                    $(function () {
                                        $("#file_upload").click(function () {
                                            $("#coverBtn").click();
                                        })
                                        $("#coverBtn").change(function () {
                                            var hv;
                                            var value = ($("._j_commentarea").val());
                                            $("#comment_reply").val(value);
                                            if(this.value){
                                                $("#coverForm").ajaxSubmit(function (data) {
                                                    console.log(data);
                                                    hv=data;
                                                    //$(".choseBtn").html(" + 重新选择");
                                                    $("#headImage").attr("src", "/" +data);
                                                    $("#coverValue").val("/" + data);

                                                })
                                            }
                                        })
                                    })

                                </script>

                               <#-- <div class="content">
                                    <dl class="upload-box _j_piclist">
                                        <dd data-commentid="" id="_j_addpicbtns" ids="0" style="position: relative;">
                                            <a class="add-place"><i></i></a>
                                            <div id="html5_1dfo6usgd1maqh5812ivtkf1n223_container"
                                                 class="moxie-shim moxie-shim-html5"
                                                 style="position: absolute; top: 0px; left: 0px; width: 120px; height: 120px; overflow: hidden; z-index: -1;">
                                                <img src="" id="coverImage" >
                                                &lt;#&ndash;<input id="html5_1dfo6usgd1maqh5812ivtkf1n223" type="button"
                                                       style="font-size: 999px; opacity: 0; position: absolute; top: 0px; left: 0px; width: 100%; height: 100%;"
                                                       multiple="" accept="image/jpeg,image/gif,image/png,.JPEG"></div>&ndash;&gt;
                                        </dd>
                                    </dl>
                                </div>-->
                            </div>
                            <!--文件上传-->
                            <form action="/coverImageUpload" method="post" id="cover_form">
                                <input type="file" name="pic" id="coverBtn" style="display: none;">
                            </form>
                            <script>

                            </script>
                            <div class="review-item item-action">
                                <a class="btn-large _j_submit" role="button" title="提交点评">提交点评</a>
                            </div>
                        </form>
                    </div>
                </div>
                <script type="text/javascript">

                    $(function () {
                        $("._j_starlist a").mouseover(function () {
                            var index = $(this).index() + 1;
                            var text = $(this).attr("title");

                            $(this).closest("div").prev().addClass("star" + index);
                            $(this).closest("div").parent().next().html(text);
                        }).mouseout(function () {
                            var index = $(this).index() + 1;
                            var text = $(this).attr("title");
                            $(this).closest("div").prev().removeClass("star" + index);
                            $(this).closest("div").parent().next().html(text);

                            var x = $(this).closest("div").prev().prev().val();
                            if (x == index) {
                                $(this).closest("div").prev().addClass("star" + x);
                            }


                        }).click(function () {
                            var index = $(this).index() + 1;
                            var text = $(this).attr("title");
                            $(this).closest("div").prev().addClass("star" + index);
                            $(this).closest("div").parent().next().html(text);

                            $(this).closest("div").prev().prev().val(index);

                        })

                        $("._j_submit").click(function () {
                            //提交普通评论
                            $("#editForm").ajaxSubmit(function (data) {
                                if(data.success){
                                    window.location.href = "/scenic/detail?id=" + data.data
                                }else{
                                    popup("操作失败");
                                }
                            })
                        })

                        //回复评论
                        $(".btn_submit_reply").click(function () {
                            console.log("123");
                            //提交回复评论
                            var username = $(this).data("username");
//                            var scenicid = $(this).data(scenicid);已经有了 form
                            var userid = $(this).data("userid");
                            var commentid = $(this).data("commentid");

                            console.log(userid);
                            console.log(username);
                            console.log(commentid);
                            $("#commentType").val(1);
                            $("#refAuthorId").val(userid);
                            $("#refUsername").val(username);
                            $("#commentid").val(commentid);

                            var html = $(".comment_reply").val();
                            $("#comment_reply").val(html);

                            $("#editForm").ajaxSubmit(function (data) {
                                if(data.success){
                                    window.location.href = "/scenic/detail?id=" + data.data
                                }else{
                                    popup("操作失败");
                                }
                            })

                        })

                        //评论的评论
                        $(".re_reply").click(function () {
                            console.log("123");
                            //提交回复评论
                            var username = $(this).data("username");
//                            var scenicid = $(this).data(scenicid);已经有了 form
                            var userid = $(this).data("userid");
                            var commentid = $(this).data("commentid");

                            $("#commentType").val(1);
                            $("#refAuthorId").val(userid);
                            $("#refUsername").val(username);
                            $("#commentid").val(commentid);

                            /*$(".comment_reply").placeholderText("123");*/
                            $(".comment_reply").attr("placeholder", '回复:' +username);
                            var html = $(".comment_reply").val();
                            $("#comment_reply").val(html);

                            /*$("#editForm").ajaxSubmit(function (data) {
                                if(data.success){
                                    window.location.href = "/scenic/detail?id=" + data.data
                                }else{
                                    popup("操作失败");
                                }
                            })*/
                        })
                    })

                </script>


                <div class="mfw-reviews have-reviews" style="display: none">
                    <h2>
                        <strong>广州塔</strong>
                    </h2>
                    <div class="review-item item-star">
                        <div class="label">你已评价为</div>
                        <div class="review-star">
                            <span class="star0"></span>
                        </div>
                        <a class="edit-reviews" data-commentid="" title="修改评论"><i></i>我要修改</a>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>


<!----------------------------------------->
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