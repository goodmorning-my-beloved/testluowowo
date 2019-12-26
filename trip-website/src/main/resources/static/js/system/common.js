$.ajaxSetup({crossDomain:true,//允许跨域
  xhrFields:{withCredentials:true}});//允许携带跨域的cookie

$.ajaxSettings.traditional = true;


function getParams() {
  //获取问号及问号后面的内容
  var url = window.location.search;
  var params = new Object();
  if (url.indexOf("?") != -1) {
    //截取问号后面的内容,再使用&分割多个属性
    var arr = url.substr(1).split("&");
    for (var i = 0; i < arr.length; i++) {
      //使用=分割为keyvalue
      var keyValue = arr[i].split("=");
      params[keyValue[0]] = keyValue[1];
    }
  }
  return params;
}




//弹出，3秒消失
function popup(msg) {
    $('body').append('<div id="over_container"><div id="over_message">'+msg+'</div></div>')
    setTimeout(function () {
        $('#over_container').remove();
    }, 3000)
}

$(function () {
  $('._j_close').click(function () {
    $('#_j_layer_0').hide();
  })

  $('.collect_icon').click(function () {
    if ($(this).hasClass('on-i02')) {
      $('#_j_layer_0').show();
      $('.collect_icon').removeClass('on-i02')
    } else {
      $(this).addClass('on-i02');
    }
  });


  $(window).scroll(function () {
    if ($(this).scrollTop() > 280) {
      $('.toolbar-item-top').show();
    } else {
      $('.toolbar-item-top').hide();
    };
  });

  $('.toolbar-item-top').click(function () {
    $('html, body').animate({
      scrollTop: 0
    }, 250);
    return false;
  });
});