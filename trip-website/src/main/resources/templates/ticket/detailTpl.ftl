<!-- 主题列表 -->
<div class="recommend_list_content" style="display: block;">
    <div class="main_content_l ticket_icon">
        <ul class="recommend_tab_l">
            <#list list as l>
                <li class="active subject_js" data="${l.theme.id}">${l.theme.name}<i class="ticket_icon"></i></li>
            </#list>
            <#-- <li class=" subject_js" data="3">温泉<i class="ticket_icon"></i></li>
             <li class=" subject_js" data="9">动植物园<i class="ticket_icon"></i></li>
             <li class=" subject_js" data="10">都市观光<i class="ticket_icon"></i></li>
             <li class=" subject_js" data="1531">水乡古镇<i class="ticket_icon"></i></li>
             <li class=" subject_js" data="43">登山徒步<i class="ticket_icon"></i></li>
             <li class=" subject_js" data="1538">湖光山色<i class="ticket_icon"></i></li>
             <li class=" subject_js" data="11">田园度假<i class="ticket_icon"></i></li>-->
        </ul>
    </div>

        <ul class="promotion_list clearfix" style="display: block;">

            <#list list as l>
            <#--推荐门票-->
            <li>
                <a href="/ticket/detail?tid=${l.id}" target="_blank" onclick="cmcTag('门票频道页-PC-站点-P4-景点推荐-${l.theme.name}-001-${l.name}','PC门票频道页景点推荐');">
                    <div class="promotion_img_box">
                        <img src="${l.coverUrl!}" width="222" height="150" alt="">
                    </div>
                    <div class="promotion_footer">
                        <h5 title="${l.name}">${(l.name)!}</h5>

                        <p><span>¥<dfn>${(l.price)!}</dfn></span><samp>起</samp></p>
                    </div>
                </a>
            </li>
            </#list>
        </ul>

</div>