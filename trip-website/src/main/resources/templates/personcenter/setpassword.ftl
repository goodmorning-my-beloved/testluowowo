<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>设置新密码 - 马蜂窝</title>
    <meta property="mfw:partner-platform" content="">
    <link href="https://css.mafengwo.net/css/cv/css+login+login_v2:mobile+css+omc+login-omc+login-omc^ZlY^1574732649.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery-upload/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="/js/jquery-upload/jquery.iframe-transport.js"></script>
    <script type="text/javascript" src="/js/jquery-upload/jquery.fileupload.js"></script>
    <script src="/js/datepicker/datepicker.js"></script>
    <script type="text/javascript" src="/js/setting.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script src="/js/plugins/jquery-form/jquery.form.js"></script>


</head>
<body>

<div class="wrapper form-wrapper">
    <div class="container">
        <a href="http://www.mafengwo.cn" title="返回首页" class="logo">马蜂窝</a>
        <div class="form-box">
            <div class="form-info">
                <div class="form-title">设置新密码</div>
                <div class="form-description">
                    <div class="alert alert-info">短信验证码已下发，请注意查收
                </div>
                <form action="/updatepassword" method="post" id="_j_reset_password_form">
                    <div class="form-list" id="_js_resetForm">
                        <div class="form-item form-item-first">
                            <input name="password" type="password" placeholder="请输入密码" autocomplete="off" />
                            <div class="form-tips" defaultTips="请输入8-20位字母 (区别大小写)、数字或符号"></div>
                            <div class="grade">
                                <span class="b1"></span>
                                <span class="b2"></span>
                                <span class="b3"></span>
                            </div>
                        </div>

                        <div class="form-item">
                            <input name="smscode" type="text" placeholder="请输入短信验证码" autocomplete="off" />
                            <div class="form-tips" defaultTips="未输入短信验证码">未输入短信验证码</div>
                        </div>
                        <div class="form-submit">
                            <a id="_js_submit">完成</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    $(function () {
      $("#_js_submit").click(function () {
          $("#_j_reset_password_form").ajaxSubmit(function (data) {
              if(data.success){
                 location.href="login.html";
              }else{
                  alert(data.msg);
              }
          })
      })
    });
</script>

</body>
</html>
