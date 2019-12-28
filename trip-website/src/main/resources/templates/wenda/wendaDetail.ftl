<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title></title>
  <link href="/styles/base.css" rel="stylesheet" type="text/css">
  <link href="/js/datepicker/datepicker.css" rel="stylesheet">
  <link href="/styles/wendaDetail.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="/js/jquery.js"></script>
  <script src="/js/plugins/jquery-form/jquery.form.js"></script>
</head>
<script>
    $(function () {
        var search = window.location.search;
        var split = search.split("=");
        console.log(split[1]);
        $("#questionId").val(split[1]);

        var index = 0;
        //回复
        $("._j_reply").click(function () {
            var username = $(this).data("username");
            var aid = $(this).data("aid");
            $("#content").focus();
            $("#content").attr("placeholder","回复：" + username );
            $("#commentType").val(1);
            $("#refAnswerId").val(aid);
        })
        //发表回复
        $("._j_submit_answer_btn").click(function () {
            if(!$("#content").val()){
                alert("评论不能为空");
                return;
            }
            /*$("#commentForm").ajaxSubmit(function (data) {
                $("#commentContent").val("");
                $("#commentContent").attr("placeholder","");

                $("#_j_reply_list").append(data);

            })*/
            //绑定事件,提交表单
            $("#editForm").ajaxSubmit(function (data) {
                if(data.success){
                    window.location.href = "/wenda/wendaDetail?id=" + data.data
                }else{
                    popup(data.msg);
                }
            })
            $("#commentType").val(0);
        })

        //顶操作
        $(".answerThumbsup").click(function () {
            var s = "";
            var userId = $(this).data("userid");
            var answerId = $(this).data("answerid");
            console.log(userId,answerId);
            $.get("/wenda/answerThumbsup",{answerId:answerId,userId:userId,questionId:split[1]},function (data) {
                if(data.success){
                    s = ("顶"+data.data);
                    //将这个数据设置到这个value值中
                    alert("顶成功了");
                    $.get("/wenda/subtractBrowseNum",{id:split[1]},function (data) {
                        if(data.success){
                            window.location.reload();
                            return;
                        }
                    })
                }else{
                    alert("顶失败了");
                }
            })
        })

        //查看所有的回答
        $(".view_all").click(function () {
            $(".view_one").show();
            $(".view_all").hide();
            $(".answer_one").hide();
            $(".answer_list").show();
        })

        $(".view_one").click(function () {
            $(".view_all").show();
            $(".view_one").hide();
            $(".answer_list").hide();
            $(".answer_one").show();
        })


        //关注操作和取消关注操作
        $("._j_same_question").click(function () {
            //获取状态
            var status = $(this).data("status");
            var questionId = $(this).data("questionId");
            $.get("/wenda/focusStatus",{questionId:split[1]},function (data) {
                if(data.success){
                    $(this).addClass("on-i02");
                    alert("关注成功");
                }else{
                    if(data.code==102){
                        alert(data.msg);
                    }else{
                        alert("取消关注");
                    }
                }
                $.get("/wenda/subtractBrowseNum",{id:split[1]},function (data) {
                    if(data.success){
                        window.location.reload();
                        return;
                    }
                })
            })

        })
    })


</script>
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
  <div class="wrapper">
    <div class="detail-wrap clearfix">
      <div class="col-main">
        <div class="q-detail">
          <div class="q-content">
            <div class="q-title">
              <a href="#" class="location"><i></i>${(question.destName)!}</a>
              <h1>
                <a href="#">${(question.title)!}</a>
              </h1>
            </div>
            <div class="q-desc">
                ${(question.content)!}
              </div>
            <div class="q-info1 clearfix">
              <div class="q-tags fl">
                <a class="a-tag" href="#">${(question.destName)!}</a>
              </div>
              <div class="pub-bar fr">
                <a href="#" class="photo _j_filter_click avatar" target="_blank"> <img
                    src="${(question.headUrl)!}"
                    width="30" height="30"></a>
                <a class="name" href="#">${(question.username)!}</a>
                <span class="time"><span>${(question.createTime)?string('yyyy-MM-dd HH:mm:ss')}</span></span>
              </div>
            </div>
          </div>
          <div class="q-operate clearfix">
            <div class="fl">
              <!-- 问题分享 -->
              <div class="q-share cate-share">
                <a class="_js_showShare"><i class="q-share-icon"></i>分享</a>
                <div class="share-pop _j_share_pop hide clearfix" data-title="为什么说在北京通勤等于取经？上下班到底有多苦？"
                  data-qid="18458675">
                  <a title="分享到新浪微博" class="sina _j_do_share" data-site="wb"></a>
                  <a title="分享到QQ空间" class="zone _j_do_share" data-site="qz"></a>
                  <a title="分享到微信" class="weixin _j_do_share_wx" data-site="wx"></a>
                </div>
              </div>
              <!-- 邀请回答 -->
              <div class="seek-help _j_tip_box">
                <a class="_j_seek_help_new">邀请蜂蜂回答</a>
              </div>
              <!-- 举报 -->
              <div class="admin_hide tip-off">
                <a data-japp="report" data-refer="#"
                  data-refer-uid="43303516" data-app="qa.question" data-busi-id="qid:18458675">举报</a>
              </div>
            </div>
            <div class="fr">
              <span class="atten-num">${(question.browsenum)!0}浏览</span>
              <span class="atten-num"><span class="_j_same_num">${(question.focusnum)!0}</span>人关注</span>

              <a class="btn-atten _j_same_question" rel="nofollow" data-status="1"
                 data-questionId="${(question.id)!}"><span id="focus_status">
                  ${(focusUserList?? && focusUserList?seq_contains((userInfo.id)!-1))?string('取消关注','关注')}
                  </span></a>
            </div>
          </div>
        </div>
        <div class="answer-wrap">
          <div class="hd">
            <a href="javascript:;" class="view_all">查看全部${(question.answernum)!}个回答</a>
            <a href="javascript:;" class="view_one">收起</a>
              <script>
                  $(".view_one").hide();
              </script>
            <div style="display:none;"><span id="_j_anum">${(question.answernum)!}</span>个回答</div>
          </div>
            <#if answer??>
            <div class="bd _j_pager_box answer_one">
                <ul class="answer-list answer_detail">
                    <div>
                        <li>
                            <div class="answer-side _js_answerAva">
                                <!-- <a class="btn-ding _js_zan "><i></i><span data-real_num="3">3</span></a> -->
                            </div>
                            <div class="answer-content _js_answer_content">
                                <div class="answer-info clearfix">
                                    <div class="user-bar fl">
                                        <a class="_j_filter_click avatar" href="javascript:;"><img
                                                src="${(answer.headUrl)!}"
                                                width="50" height="50" class="photo"></a>
                                        <a class="name" href="javascript:;" >${(answer.username)!}</a>
                                        <a class="level" href="javascript:;" rel="nofollow">LV.${(answer.level)!0}</a>
                                    </div>
                                    <#--<input class="btn-comment answerThumbsup" data-userId="${(answer.userId)!}"
                                           data-answerId="${(answer.id)!}"  type="button" value="顶${(answer.thumbsupnum)!}">-->
                      <#if (answer.medal)?? && answer.medal==1>
                      <ul class="answer-medal fr">
                          <li class="gold">
                              <div class="btn"><i></i><a href="javascript:;">金牌回答</a></div>
                          </li>
                      </ul>
                      </#if>
                            </div>
                            <!-- 回答内容 -->
                            <div class="_j_short_answer_item hide" style="display: block;">
                            ${(answer.content)!}
                            </div>
                            </div>
                        </li>
                    </div>
                </ul>
            </div>
            </#if>
          <#if (question.list)??>
          <#list (question.list)! as a>
          <div class="bd _j_pager_box answer_list">
            <ul class="answer-list answer_detail">
              <div>
                <li>
                  <div class="answer-side _js_answerAva">
                    <!-- <a class="btn-ding _js_zan "><i></i><span data-real_num="3">3</span></a> -->
                  </div>
                  <div class="answer-content _js_answer_content">
                    <div class="answer-info clearfix">
                      <div class="user-bar fl">
                        <a class="_j_filter_click avatar" href="javascript:";> <img src="${(a.headUrl)!}" width="50" height="50" class="photo"></a>
                        <a class="name" href="javascript:;">${(a.username)!}</a>
                        <a class="level" href="javascript:;" rel="nofollow">LV.${(a.level)!0}</a>
                      </div>
                      <input class="btn-comment answerThumbsup" data-userId="${(a.userId)!}"
                           data-answerId="${(a.id)!}"  type="button" value="顶${(a.thumbsupnum)!}">
                      <#if a.medal?? && a.medal==1>
                      <ul class="answer-medal fr">
                        <li class="gold">
                          <div class="btn"><i></i><a href="javascript:;">金牌回答</a></div>
                        </li>
                      </ul>
                      </#if>
                    </div>
                    <!-- 回答内容 -->
                      <#if a.type==0>
                    <div class="_j_short_answer_item hide" style="display: block;">
                      ${(a.content)!}
                    </div>
                      </#if>
                      <#if a.type==1>
                            <div class="_j_short_answer_item">
                                <p>引用 ${(a.refAnswer.username)!} 发表于 ${(a.refAnswer.replytime?string('yyyy-MM-dd HH:ss'))!} 的回答：</p>
                                <p class="_j_reply_content">${(a.refAnswer.content)!}</p>
                            </div>
                            <br>
                            <div class="_j_short_answer_item">
                                <p class="_j_reply_content" >回复${(a.refAnswer.username)!}：${(a.content)!}</p>
                            </div>
                      </#if>
                      <div class="_j_short_answer_item">
                          <br>
                          <div class="time">回答时间:${(a.replytime?string('yyyy-MM-dd HH:ss'))!}</div>
                          <div class="option">
                              <a role="button" class="reply-report">举报</a>
                              <a role="button" class="_j_reply replyBtn" data-username="${a.username!}" data-aid="${a.id!}">回复</a>
                          </div>
                      </div>
                  </div>
                </li>
              </div>
            </ul>
          </div>
          </#list>
          <script>
              $(".answer_list").hide();
          </script>
          </#if>
          <div class="bd _j_pager_box">
            <div class="aa-hd">
              <#--<a class="aa-avatar" href="/wenda/u/53383161/answer.html"><img
                  src="${(userInfo.headImgUrl)!}"
                  class="photo" width="20px" height="20px"></a>
              <a class="aa-name">${(userInfo.nickname)!}</a>-->
            </div>
              <form class="forms" action="/wenda/saveAnswer" method="post" id="editForm">
                  <input type="hidden" id="questionId" value="" name="questionId">
                  <input type="hidden" name="type" value="0" id="commentType">
                  <input type="hidden" name="refAnswer.id" id="refAnswerId">
            <div class="editor-outer _j_editorOuter _js_editorWrap _js_forFixTitle">
              <textarea name="content" id="content"></textarea>
            </div>
            <div class="aa-ft">
              <input class="btn-comment _j_submit_answer_btn" type="button" value="提交回答"/>
            </div>
              </form>
          </div>
        </div>
      </div>
      <div class="col-side"></div>
    </div>
  </div>
</body>

</html>