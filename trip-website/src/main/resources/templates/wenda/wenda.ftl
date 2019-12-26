<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title></title>
  <link href="/styles/base.css" rel="stylesheet" type="text/css">
  <link href="/js/datepicker/datepicker.css" rel="stylesheet">
  <link href="/styles/wenda.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="/js/jquery.js"></script>
  <script type="text/javascript" src="/js/wenda.js"></script>
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
          <li data-cs-t="public" data-cs-p="public">
            <strong class="t"><a data-cs-p="from_wo_nav" href="/wenda/public">我要提问</a></strong>
          </li>
          <li data-cs-t="wenda" data-cs-p="wenda">
            <strong class="t"><a data-cs-p="from_wo_nav" href="/wenda/">问答</a></strong>
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
              <span id="oldmsg" class="oldmsg"><a href="javascript:;" class="infoItem">消息<b></b></a></span>
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
                    src="${(user.headImgUrl)!}"
                    width="32" height="32" align="absmiddle"><b></b></a></span>
              <div class="uSet c">
                <div class="asset">
                  <a class="coin" href="javascript:;" target="_blank" rel="nofollow">蜂蜜 0</a>
                  /
                  <a class="coin" href="javascript:;" target="_blank" id="head-my-honey" rel="nofollow"
                    data-cs-p="coin">金币 579</a>
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
  <div class="wrapper wrapper-new">
    <div class="col-main">
      <div class="newcate-wrap _j_qa_list">
          <#list questions as q>
        <div class="bd newcate-bd">
          <ul class="_j_pager_box">
            <li class="item clearfix _j_question_item" data-qid="793682">
              <div class="title">
                <a href="/wenda/wendaDetail?id=${(q.id)!}" target="_blank">${q_index+1} . ${(q.title)!}</a> </div>
              <div class="container">
                <#list q.list as a>
                <div class="avatar"><a href="javascript:;" target="_blank" class="_j_filter_click"><img
                      class="_j_filter_click"
                      src="${(a.headUrl)!}" width="30px" height="30px"></a>
                </div>
                <div class="user-info">
                  <a class="name _j_filter_click" href="javascript:;" target="_blank">${(a.username)!}</a>
                  <a class="level _j_filter_click" href="javascript:;" target="_blank" rel="nofollow">LV.${(a.level)!0}</a>
                </div>
                <div class="desc clearfix">
                  <p>
                    ${(a.summary)!}
                  </p>
                </div>
                <div class="operate">
                  <div class="zan"><i></i>${(a.thumbsupnum)!}</div>
                  <div class="mdd"><a href="javascript:;" class="_j_filter_click" target="_blank"><i
                        class="_j_filter_click"></i>${(q.destName)!}</a></div>
                  <div class="cate-share">
                    <a class="_js_showShare _j_filter_click">分享</a>
                  </div>
                  <span class="reply">回答 (${(q.answernum)!})</span>
                  <span class="browse">浏览 (${(q.browsenum)!})</span>
                  <span class="date">发布于${(q.createTime)?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                  </#list>
              </div>
            </li>
          </ul>
        </div>
          </#list>
      </div>
    </div>
    <div class="col-side">
      <div class="rank _j_rank" style="margin-top: 20px;">
        <div class="hd">排行榜<ul class="tab-time">
            <li class="_j_rank_change_date" data-type="0"><span>今日</span></li>
            <li class="_j_rank_change_date on" data-type="1"><span>本周</span></li>
            <li class="_j_rank_change_date" data-type="2"><span>本月</span></li>
          </ul>
        </div>
        <div class="bd">
          <ul class="tab-num" data-cs-p="rank_list">
            <li class="_j_rank_change_flag" data-rank="0" data-cs-d="金牌数">金牌数</li>
            <li class="_j_rank_change_flag on" data-rank="1" data-cs-d="回答数">回答数</li>
            <li class="_j_rank_change_flag" data-rank="2" data-cs-d="被顶次数">被顶次数</li>

          </ul>
          <ul class="rank-list _j_rank_list">
            <li class="r-top r-top1 clearfix">
              <em class="num">1</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://n4-q.mafengwo.net/s10/M00/EB/B7/wKgBZ1nHyJqAHa5AAARhrrVoCtE88.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank"
                    rel="nofollow">大愿尊者之王者归来</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.19</a></span>
              </div>
              <span class="num">144</span>
            </li>
            <li class="r-top r-top2 clearfix">
              <em class="num">2</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://p3-q.mafengwo.net/s10/M00/3B/2D/wKgBZ1jlwDiAEub5AABorL-ZUME853.png?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank"
                    rel="nofollow">藿香正气</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.35</a></span>
              </div>
              <span class="num">101</span>
            </li>
            <li class="r-top r-top3 clearfix">
              <em class="num">3</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://b3-q.mafengwo.net/s9/M00/C1/8E/wKgBs1fPrFKAEXzIAAClaEwD1QY29.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank"
                    rel="nofollow">azalea</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.17</a></span>
              </div>
              <span class="num">92</span>
            </li>
            <li class="clearfix">
              <em class="num">4</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://n4-q.mafengwo.net/s11/M00/89/CB/wKgBEFpjiE-AXxGMAAAQyvR6UoU51.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank"
                    rel="nofollow">新疆趣哪里-桃桃</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.19</a></span>
              </div>
              <span class="num">80</span>
            </li>
            <li class="clearfix">
              <em class="num">5</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://n1-q.mafengwo.net/s14/M00/E0/89/wKgE2l0q8v6AMky_AAb9GrkBRZg01.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank"
                    rel="nofollow">朗风丽日时</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.27</a></span>
              </div>
              <span class="num">77</span>
            </li>
            <li class="clearfix">
              <em class="num">6</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://n3-q.mafengwo.net/s5/M00/FD/37/wKgB21B4ECD5jGoTAAEmz8kxP0088.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank" rel="nofollow">一頁書</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.34</a></span>
              </div>
              <span class="num">62</span>
            </li>
            <li class="clearfix">
              <em class="num">7</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://b2-q.mafengwo.net/s14/M00/00/41/wKgE2l0pwvuAOgeXAAAOkfX1NwI78.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank"
                    rel="nofollow">马蜂窝用户</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.9</a></span>
              </div>
              <span class="num">61</span>
            </li>
            <li class="clearfix">
              <em class="num">8</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://p2-q.mafengwo.net/s13/M00/11/4F/wKgEaVycQk2AO4q9AAFVJZKc11k15.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank"
                    rel="nofollow">一路有你驴行网</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.15</a></span>
              </div>
              <span class="num">54</span>
            </li>
            <li class="clearfix">
              <em class="num">9</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://n2-q.mafengwo.net/s11/M00/4D/6F/wKgBEFqRGFaAXJECAAAMCbfJkzc01.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank" rel="nofollow">lorin
                    江流天地外</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.31</a></span>
              </div>
              <span class="num">52</span>
            </li>
            <li class="clearfix">
              <em class="num">10</em>
              <div class="user no_qid">
                <a class="avatar" href="javascript:;" target="_blank" rel="nofollow"><img
                    src="http://p1-q.mafengwo.net/s13/M00/78/D0/wKgEaVyIYJ6AJE9zAACxk3gGqLo65.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"></a>
                <span class="name"><a href="javascript:;" target="_blank"
                    rel="nofollow">享世界~陈奕佳</a></span>
                <span class="level"><a href="javascript:;" target="_blank"
                    rel="nofollow">LV.15</a></span>
              </div>
              <span class="num">50</span>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</body>

</html>