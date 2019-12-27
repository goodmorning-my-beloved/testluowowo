<#--
<div class="crumb">
    <span class="tit">您在这里：</span>
    <div class="item">
        <div class="drop">
            <span class="hd"><a href="/hotel/hotel" target="_blank">酒店<i></i></a></span>
        </div>
    </div>
</div>
-->
<div class="crumb">
    <div class="item"><span class="tit">您在这里：</span></div>
    <#list toasts as t>
    <div class="item">
      <div class="drop">
            <span class="hd"><a href="/hotel/hotel" target="_blank">${t.name!}酒店<i></i></a></span>
            <div class="bd">
                <i class="arrow"><b></b></i>
                <div class="col">
                    <h3>下属地区</h3>
                    <#--<ul class="clearfix">-->
                        <#list t.children as tc>
                        <#if tc_index lt 5 >
                        <li><a href="/hotel/h?name=${tc.name!}" target="_blank">${tc.name!}酒店</a></li>
                        </#if>
                        </#list>

                  </ul>
                </div>
                <div class="more"><a href="/hotel/h?name=${t.name}" target="_blank">&gt;&gt;更多地区</a></div>
            </div>
        </div>
        <em>&gt;</em>
    </div>
    </#list>
    <div class="item cur"><strong>${theSearchDest.name}酒店预览</strong></div>
</div>
 <script language="JavaScript" type="text/javascript">
     $(function () {
         //面包屑
         $('.drop').mouseenter(function (ev) {
             var target = $(ev.currentTarget);
             clearTimeout(target.data('hideTimer'));
             target.addClass('open');
             target.children('bd').fadeIn(200);
         });
         $('.drop').mouseleave(function (ev) {
             var target = $(ev.currentTarget);
             target.data("hideTimer", setTimeout(function () {
                 target.removeClass('open');
                 target.children('bd').fadeOut(200);
             }, 200));
         });
     });
 </script>
