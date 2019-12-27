

            <dl class="item-info clearfix _j_area_desc_list" style="height: 105px;">
                <dt style="">攻略:</dt>
                <dd id='r${region.id!}' data-id="${region.id!}" class="_j_stregty_info" <#--style="display:none;"-->>
                    <div>
                        <#if flag??>
                            <p>
                                <em>${region.hotScore!}</em>分游客热度&nbsp;&nbsp;&nbsp;&nbsp;共<em>${region.hotelNum}</em>家酒店
                                <a class="icon-photos" href="/hotel/area_view/1764.html" target="_blank"></a>
                            </p>
                        </#if>
                        <span>${region.info}</span>
                    </div>
                </dd>
            </dl>


            <#if flag??>
            <dl class="item-price clearfix _j_area_desc_list" style="height: 105px;">
                <dt class="anim-show">均价
                    <sup class="warn-mark">
                        <span class="warn-mark-icon"></span>
                        <span class="warn-tips">等级均价由平日价格计算得出，节假日价格会有上浮。<i></i></span>
                    </sup>:
                </dt>
                <dd data-id="${region.id}" <#--style="display:none;"-->>
                    <ul class="clearfix">
                        <li><span class="hotel-rate rate3"></span>${region.avgPrice}</li>
                    </ul>
                </dd>
            </dl>
         </#if>
        