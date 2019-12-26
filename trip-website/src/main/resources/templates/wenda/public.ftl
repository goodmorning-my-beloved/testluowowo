<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title></title>
  <link href="/styles/base.css" rel="stylesheet" type="text/css">
  <link href="/styles/public.css" rel="stylesheet" type="text/css">
  <link href="/js/ueditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
  <link href="/js/datepicker/datepicker.css" rel="stylesheet">
  <link href="/js/plugins/chosen/chosen.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="/js/plugins/chosen/chosen.jquery.js"></script>
  <script type="text/javascript" src="/js/jquery.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/ueditor/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/ueditor/umeditor.min.js"></script>
  <script type="text/javascript" src="/js/ueditor/lang/zh-cn/zh-cn.js"></script>
  <script type="text/javascript" src="/js/common.js"></script>
  <script type="text/javascript" src="/js/public.js"></script>
  <script src="/js/plugins/jquery-form/jquery.form.js"></script>
</head>
<script>
    $(function () {
        //提出问题
        $(".qt-post-btn").click(function () {
            var val = $("._j_title").val;
            console.log(val);

            console.log(1);
            $("#editForm").ajaxSubmit(function (data) {
                if(data.success){
                    window.location.href = "/wenda/wendaDetail?id=" + data.data
                    return;
                }else{
                    alert(data.msg);
                }
            })
        })


    })

</script>


<body>
  <div class="lww_header">
    <div class="header_wrap">
      <div class="header_logo">
        <a href="javascript:;" class="lww_logo"></a>
      </div>
      <ul class="header_nav">
        <li><a href="/">首页</a></li>
        <li><a href="/destination">目的地</a></li>
        <li><a href="/strategy">旅游攻略</a></li>
        <li><a href="javascript:;">去旅行<i class="icon_caret_down"></i></a></li>
        <li><a href="/travel">游记</a></li>
        <li><a href="/hotel">酒店</a></li>
        <li><a href="/wenda">社区<i class="icon_caret_down"></i></a></li>
      </ul>
      <div class="header_search">
        <input type="text" />
        <a class="icon_search"></a>
      </div>
      <div class="login_info">
        <div class="head_user">
          <a href="javascript:;">
            <img src="/images/user.png" />
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
  <div class="wrapper">
    <div class="qt-container clearfix">
      <div class="qt-main">
        <div class="crumb">
          <a href="/wenda/">旅游问答</a> &gt; <span>我要提问</span>
        </div>
          <form class="forms" action="/wenda/save" method="post" id="editForm">
        <div class="qt-tit">
          <h5>问题标题</h5>
          <div class="qt-con">
            <input type="text" name="title" class="_j_title">
            <span class="count"><span class="_j_title_num"></span></span>
            <span class="_j_min_num hide">10</span>
            <span class="error err-tips _j_title_error"></span>
          </div>
        </div>
        <div class="pi-col pi-date" style="margin-left: 2%;"> <label for="isopen">旅游地点</label>
            <div class="pi-dropdown "style="text-align: left" >
                <select name="destId" data-placeholder="请选择目的地" id="region" style="width: 150px;">
                  <#list dests! as r>
                      <option value="${r.id!}">${r.name!}</option>
                  </#list>
                </select>
            </div>
        </div>
        <div class="qt-details">
          <h5><a title="添加问答内容" class="icon active" id="_j_show_content"></a>问题详细内容</h5>
          <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
        </div>

        <div class="publish_question">

          <input class="qt-post-btn _j_publish"  value="发布问题" type="button">
        </div>
      </div>
      </form>
      <div class="qt-sider">
        <div class="qts-tit">提问的正确姿势</div>
        <div class="qts-con">
          <p>1.问题要【具体】【真实】【诚恳】，问题较多，需全面阐述时，可以添加问题补充。结伴/交易/与旅行无关的提问将被删除。</p>
          <p>2.给问题添加目的地，并打上正确的标签将有助于更快地获得回答。</p>
        </div>
      </div>
    </div>
  </div>
</body>

</html>