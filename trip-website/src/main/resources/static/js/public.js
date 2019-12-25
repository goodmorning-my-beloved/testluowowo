$(function () {
  // 初始化富文本编辑器
  var ue = UM.getEditor('editor',{
      textarea:"content",
      imageUrl:"/wenda/contentImage",
      imageFieldName:"upfile",
      //UMEDITOR_HOME_URL:"/",
      imagePath:''
  });
});