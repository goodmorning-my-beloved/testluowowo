<div class="hotel-loading" id="_j_hotel_list_loading" style="display: none;"><i class="loading-m"></i></div>
            <div class="hotel-list" id="_j_hotel_list">
            <#list hotel as h>
                <div class="hotel-item clearfix _j_hotel_item" data-id="9031088" data-is-merge_room="0"
                     data-name="${h.name}" data-lat="25.042788" data-lng="121.50931" data-is-airbnb="0"
                     data-cs-t="酒店list页点击入口分布">
                    <div class="hotel-pic">
                        <a href="${h.url}" class="_j_hotel_info_link" target="_blank"
                           data-cs-p="图片">
                            <img src="${h.coverUrl}"
                                 alt="" style="width: 330px;">
                        </a>

                    </div>
                    <div class="hotel-title">
                        <div class="title">
                            <h3><a href="${h.url}" class="_j_hotel_info_link" target="_blank"
                                   title="${h.id}" data-cs-p="标题">${h.name}</a></h3>
                            <br>
                            <span>Hotel Midtown Richardson</span>
                        </div>
                    </div>
                    <div class="hotel-info ">
                        <ul class="nums clearfix">
                            <li class="rating rating2">
                                <em>${h.score}</em>分
                            </li>
                            <li class="split"></li>
                        </ul>

                        <div class="location">
                            <span><i class="icon-location"></i>详细地址: <a href="javascript:;" data-id="1762"
                                                                        data-type="area">${h.address}</a></span>
                        </div>

                    </div>
                    <div class="hotel-btns">
                        <a class="btn-booking _j_booking_btn" href="javascript:" rel="nofollow" style=""
                           data-ota="ctrip"
                           data-url=""
                           data-price="626" data-is-cache-price="0" data-is-sold-out="0" data-pay-type="">
                            <div class="ota">
                                <div class="name">
                                    <strong>骡窝窝</strong>


                                </div>
                                <p class="tips" style="display:none;"></p>
                            </div>
                            <div class="price _j_booking_price">
                                <strong>￥</strong><strong>${h.price}</strong><strong
                                    style="font-size: 12px;color: #666;padding-left: 2px;vertical-align: 1px;">起</strong>
                                <i class="arrow"></i>
                            </div>
                            <div class="price _j_booking_sold_out" style="display:none;">
                                <span>已售罄</span>
                            </div>

                        </a>
                    </div>
                    <!--<div class="hotel-other">
                        <div class="collect">
                            <a class="btn-addCollect _j_add_fav" href="javascript:;" data-id="9031088" data-type_id="2"
                               data-cs-p="收藏"><i></i>
                                收藏
                            </a>
                            <a class="btn-cancelCollect _j_del_fav" style="display:none;" href="javascript:;"
                               data-id="9031088" data-type_id="2"><i></i>

                                取消收藏
                            </a>
                        </div>
                    </div>-->
                </div>
            </#list>
            </div>


            <div style="margin-bottom: 24px;padding-left: 12px;">
                <a style="color: #666;font-weight: bold;text-decoration: none;cursor: default;" target="_blank"
                   href="/hotel/license">骡窝窝酒店平台合作伙伴</a>
            </div>