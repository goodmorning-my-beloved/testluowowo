<html class=" hasFontSmoothing-true">
<head>
    <script type="text/javascript" async="" charset="utf-8"
            src="http://c.cnzz.com/core.php?web_id=30065558&amp;t=q"></script>
    <script type="text/javascript" async="" charset="utf-8"
            src="http://w.cnzz.com/c.php?id=30065558&amp;async=1"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>【酒店预订】${theSearchDest.name}酒店价格查询，${theSearchDest.name}酒店推荐 - 骡窝窝</title>
    <meta name="Description"
          content="骡窝窝酒店预订，为您搜索${theSearchDest.name}各区域酒店价格查询及预订信息。通过对酒店价格、位置、设施、品牌、星级及用户真实点评为你推荐高性价比酒店，在线预订酒店，价格优惠实时折扣.">
    <meta name="Keywords" content="${theSearchDest.name}酒店预订，${theSearchDest.name}酒店价格查询，${theSearchDest.name}酒店推荐">
    <script src="https://hm.baidu.com/hm.js?8288b2ed37e5bc9b4c9f7008798d2de0"></script>
    <link href="http://css.mafengwo.net/css/cv/css+base:css+jquery.suggest:css+plugins:css+plugins+jquery.jgrowl:css+other+popup:css+mfw-header.2015^YlVS^1559526017.css"
          rel="stylesheet" type="text/css">
    <script language="javascript"
            src="http://js.mafengwo.net/js/cv/js+jquery-1.8.1.min:js+global+json2:js+M+Module:js+M+M:js+M+Log:js+m.statistics:js+advert+inspector^alw^1563531411.js"
            type="text/javascript" crossorigin="anonymous"></script>
    <script type="text/javascript">
        var __mfw_uid = parseInt('32085284');
        /* 查看价格 */
        $(function () {
            $(".btn-sss").click(function () {
                $("#editForm").submit()
            })
        })
    </script>

    <script language="javascript"
            src="http://js.mafengwo.net/js/cv/js+common+jquery.plugins:js+common+widgets:js+mfw.storage^ZlI^1537192880.js"
            type="text/javascript" crossorigin="anonymous"></script>
    <link href="http://css.mafengwo.net/css/cv/css+hotel+new_hotel_v6.2:css+mdd+map-mark.v2:css+hotel+datepicker-range:css+hotel+number_guests_picker:css+mdd+hotel_fav:css+sales+m-toolbar:css+jquery-ui-1.9.1.custom.min^YlJS^1552035728.css"
          rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="http://css.mafengwo.net/css/plugins/leaflet/leaflet.css?1537192876">
    <script async="" src="http://js.mafengwo.net/js/plugins/leaflet.js?1537192880" crossorigin="anonymous"></script>
    <script async="" src="http://js.mafengwo.net/js/BrowserState.js?1542357400" crossorigin="anonymous"></script>
</head>
<body style="position: relative;">
<style>
    @keyframes glowling {
        0% {
            background-position: -820px 0;
        }
        100% {
            background-position: 820px 0;
        }
    }

    .hotel-btns {
        position: relative;
    }

    .room_loading_wrapper {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: #fff;
    }

    .room_loading_wrapper li {
        height: 15px;
        margin-top: 20px;
        -webkit-animation-duration: 1.5s;
        animation-duration: 1.5s;
        -webkit-animation-fill-mode: forwards;
        animation-fill-mode: forwards;
        -webkit-animation-iteration-count: infinite;
        animation-iteration-count: infinite;
        -webkit-animation-name: glowling;
        animation-name: glowling;
        -webkit-animation-timing-function: linear;
        animation-timing-function: linear;
        background: no-repeat #f6f6f6;
        background-image: linear-gradient(270deg, #f6f6f6, #ebebeb 20%, #f6f6f6 40%, #f6f6f6);
    }

    .room_loading_wrapper li:nth-child(2) {
        width: 80%;
    }

    .room_loading_wrapper li:nth-child(3) {
        width: 45%;
    }

    .room_loading_wrapper li:nth-child(4) {
        width: 55%;
    }

    .room_loading_wrapper li:nth-child(5) {
        width: 70%;
    }

    .icon-sale0417 {
        margin: 2px 0 0 4px;
        display: inline-block;
        width: 70px;
        height: 20px;
        background-image: url(http://images.mafengwo.net/images/hotel/hotel_index/20180417-icon.png);
        background-position: bottom;
        background-size: contain;
        background-repeat: no-repeat;
        overflow: hidden;
        vertical-align: top;
    }

    .icon-sale0420 {
        margin: 2px 0 0 4px;
        display: inline-block;
        width: 60px;
        height: 20px;
        background-image: url(http://images.mafengwo.net/images/hotel/activity/2018_0417/20180420-icon.png);
        background-position: bottom;
        background-size: contain;
        background-repeat: no-repeat;
        overflow: hidden;
        vertical-align: top;
    }

    .hotel-sale-banner {
        position: relative;
        width: 100%;
        height: 120px;
        background-image: url(http://images.mafengwo.net/images/hotel/hotel_index/20180417-banner.png);
        background-repeat: no-repeat;
        background-size: cover;
        background-position: bottom;
        margin-bottom: 20px;
    }

    .hotel-new-icon {
        position: absolute;
        display: block;
        width: 238px;
        height: 210px;
        bottom: -1px;
        left: 5px;
        z-index: -1;
        background-image: url('http://css.mafengwo.net/images/hotel/new-customer-icon.gif');
        background-size: 100% 100%;
    }

    .hotel-new-icon:hover {
        z-index: 0;
        background-image: url('http://css.mafengwo.net/images/hotel/new-customer-hover-icon.png');
    }

    .hotel-new-icon .close {
        position: absolute;
        display: block;
        width: 25px;
        height: 25px;
        right: 0;
        bottom: 83px;
        border-radius: 50%;
    }

    .toolbar-item-top, .toolbar-item-feedback, .toolbar-item-code {
        padding-left: 40px;
    }
</style>

<div class="wrapper">
    <div class="top-info clearfix">

        <#include "../common/hotelToasts.ftl"/>
    <#-- 这是天气预报 -->
    <#--<div class="weather-wrapper">
        <link href="http://css.mafengwo.net/weather/littleWeather.css?1530619858" rel="stylesheet" type="text/css">
    </div>-->
    </div>
    <form class="form-hotel" action="/hotel/h" method="get" id="editForm">
        <div class="hotel-searchbar clearfix">
            <div class="hs-item hs-item-search" id="_j_hotel_search">
                <input type="text" value="${(qo.name)!}" id="_j_search_input" autocomplete="off" name="name">
                <div class="hotel-suggest simsun" id="_j_search_suggest" style="display:none;"></div>
                <a class="hs-icon hs-icon-search" href="javascript:;" id="_j_search_btn"></a>
            </div>
            <div class="hs-item hs-item-date-wrapper" id="_j_booking_date">
                <div class="hs-item hs-item-date" id="_j_check_in_date">
                    <span>${(qo.checkIn)?string("yyyy-MM-dd")}</span>
                    <input type="text" placeholder="入住日期" readonly="" id="dp1563708930698" class="hasDatepicker"
                           name="checkIn">
                    <i class="hs-icon hs-icon-date"></i>
                </div>
                <div class="hs-item hs-item-date" id="_j_check_out_date">
                    <span>${(qo.checkOut)?string("yyyy-MM-dd")}</span>
                    <input type="text" placeholder="离店日期" readonly="" id="dp1563708930699" class="hasDatepicker"
                           name="checkOut">
                    <i class="hs-icon hs-icon-date"></i>
                </div>
            </div>
            <div class="hs-item hs-item-people number-guests-picker" id="_j_booking_number_guests">
                <span>${(qo.adult)!0}</span>
                <i class="icon-person"></i>
                <div class="ngp-dropdown _j_ngp_dropdown" style="display:none;">
                    <div class="item _j_ngp_room_item">
                        <div class="row-guests clearfix _j_ngp_row_guests"><span class="label"></span>
                            <div class="ngp-select">
                                <div class="select-trigger _j_ngp_select_trigger"><span></span>
                                    <div class="caret"><i></i></div>
                                </div>
                                <ul style="display:none;">
                                    <li data-value="1">1</li>
                                    <li data-value="2">2</li>
                                    <li data-value="3">3</li>
                                    <li data-value="4">4</li>
                                    <li data-value="5">5</li>
                                    <li data-value="6">6</li>
                                    <li data-value="7">7</li>
                                </ul>
                            </div>
                            <div class="ngp-select">
                                <div class="select-trigger _j_ngp_select_trigger"><span>0 儿童</span>
                                    <div class="caret"><i></i></div>
                                </div>
                                <ul style="display:none;">
                                    <li data-value="0">0</li>
                                    <li data-value="1">1</li>
                                    <li data-value="2">2</li>
                                    <li data-value="3">3</li>
                                    <li data-value="4">4</li>
                                </ul>
                            </div>
                        </div>
                        <div class="row-children clearfix _j_ngp_row_children" style="display:none;"><span
                                class="label">儿童年龄</span>
                        </div>
                    </div>
                    <div class="item item-action clearfix _j_ngp_action_item"><span class="tips"></span><a
                            class="btn-action" href="javascript:;">确 认</a></div>
                </div>
            </div>
            <div class="hs-item hs-item-action btn-search" id="_j_price_btn">
                <a class="hs-btn" href="javascript:;" class="btn-sss">查看价格</a>
            </div>
        </div>
    </form>
    <script>

    </script>
    <div class="area-main clearfix">
        <div class="area-wrapper" id="_j_area_wrapper" style="">
            <dl class="item-area clearfix _j_area_list">
                <dt>区域:</dt>
                <dd>
                    <ul class="area-nav clearfix restrictheight" style="height: 84px;">
                        <li><a href="javascript:;" class="_j_area_name on" data-id="-1">全部</a></li>
                        <#list hotelRegions as hr >
                            <li>
                            <#--<a href="javascript:;" class="_j_area_name" id="R${hr.id}">${hr.name}</a>-->
                                <button type="button" id="R${hr.id}">${hr.name}></button>
                            </li>
                        <script>
                            $(function () {
                                $("#R${hr.id}").click(function () {
                                    $(this).addClass("style", 'background-color: goldenrod');
                                })
                            })
                        </script>
                        </#list>
                    </ul>
                </dd>
            </dl>
            <dl class="item-info clearfix _j_area_desc_list" style="height: 105px;">
                <dt style="">攻略:</dt>
                <#list hotelRegions as hr >
                <dd id="${hr.id}" style="display:none;">
                    <div>
                        <p>
                            <em>${hr.hotScore}</em>分游客热度&nbsp;&nbsp;&nbsp;&nbsp;共<em>${hr.hotelNum}</em>家酒店
                            <a class="icon-photos" href="/hotel/area_view/1764.html" target="_blank"></a>
                        </p>
                        <span>${hr.info}</span>
                    </div>
                </dd>
                </#list>
                <dd id="dest${theSearchDest.id}" style="display:on; height: 105px ;">
                    <div>
                        <p>${theSearchDest.info}</p>
                    </div>
                </dd>
            </dl>
        <#-- 均价 -->
            <dl class="item-price clearfix _j_area_price_list">
                <dt data-id="" style="" class="anim-show">均价
                    <sup class="warn-mark">
                        <span class="warn-mark-icon"></span>
                        <span class="warn-tips">地区均价由平日价格计算得出，节假日价格会有上浮。<i></i></span>
                    </sup>:
                </dt>
                <#list hotelRegions as hr >
                <dd id="P${hr.id}" style="display:none;">
                    <ul class="clearfix">
                        <li><span class="hotel-rate rate3"></span>${hr.avgPrice}</li>
                    </ul>
                </dd>
                </#list>
            </dl>
        </div>
    <#--  等待处理  总地点介绍 -->
        <div class="area-wrapper" id="_j_region_wrapper" style="display:none;">
            <dl class="item-info clearfix _j_region_desc_list">
                <dt style="">攻略:</dt>
                <dd data-id="-1" style="">
                    <div>
                        <span>${theSearchDest.info}</span>
                    </div>
                </dd>
            </dl>
        </div>
    <#-- 通过地图查找 -->
        <div class="area-maps" id="_j_map">
            <a class="map-link" href="/hotel/list_map?mddid=10819" target="_blank">通过地图查找酒店</a>
            <div class="map-container leaflet-container leaflet-fade-anim" tabindex="0" style="position: relative;">
                <div class="leaflet-map-pane" style="transform: translate3d(0px, 0px, 0px);">
                    <div class="leaflet-tile-pane">
                        <div class="leaflet-layer">
                            <div class="leaflet-tile-container"></div>
                            <div class="leaflet-tile-container leaflet-zoom-animated"><img
                                    class="leaflet-tile leaflet-tile-loaded"
                                    src="https://maps.google.cn/maps/vt/pb=!1m5!1m4!1i12!2i3430!3i1753!4i256!2m3!1e0!2sm!3i258145710!5m1!5f2!3m2!2szh-CN!3sCN"
                                    style="height: 256px; width: 256px; left: -119px; top: -44px;"><img
                                    class="leaflet-tile leaflet-tile-loaded"
                                    src="https://maps.google.cn/maps/vt/pb=!1m5!1m4!1i12!2i3431!3i1753!4i256!2m3!1e0!2sm!3i258145710!5m1!5f2!3m2!2szh-CN!3sCN"
                                    style="height: 256px; width: 256px; left: 137px; top: -44px;"><img
                                    class="leaflet-tile leaflet-tile-loaded"
                                    src="https://maps.google.cn/maps/vt/pb=!1m5!1m4!1i12!2i3430!3i1754!4i256!2m3!1e0!2sm!3i258145710!5m1!5f2!3m2!2szh-CN!3sCN"
                                    style="height: 256px; width: 256px; left: -119px; top: 212px;"><img
                                    class="leaflet-tile leaflet-tile-loaded"
                                    src="https://maps.google.cn/maps/vt/pb=!1m5!1m4!1i12!2i3431!3i1754!4i256!2m3!1e0!2sm!3i258145710!5m1!5f2!3m2!2szh-CN!3sCN"
                                    style="height: 256px; width: 256px; left: 137px; top: 212px;"></div>
                        </div>
                    </div>
                    <div class="leaflet-objects-pane">
                        <div class="leaflet-shadow-pane"></div>
                        <div class="leaflet-overlay-pane">
                            <svg class="leaflet-zoom-animated" width="354" height="229" viewBox="-7 -5 354 229"
                                 style="transform: translate3d(-7px, -5px, 0px);">
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M5 56L4 65L0 74L14 77L16 80L17 88L25 90L24 103L51 108L94 108L93 100L90 93L90 87L85 87L73 83L74 81L68 74L64 64L47 63L26 57L14 58L6 56z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M0 74L-7 82L-7 118L-5 118L3 112L8 96L15 99L24 99L25 90L17 89L16 79L1 74z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M15 10L40 11L40 28L44 38L43 62L26 57L14 58L6 56L8 49L10 11L15 10z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M152 66L151 135L145 144L148 147L161 148L174 136L175 126L196 126L210 115L214 115L226 110L231 100L234 97L239 97L236 92L236 88L239 85L239 81L235 81L229 74L225 67L225 61L200 68L194 68L190 66L154 66z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M46 11L80 12L91 22L90 86L86 87L75 84L68 74L63 63L59 64L43 62L44 38L40 29L40 18L41 11L45 11z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M92 64L90 93L94 103L94 123L151 125L152 67L143 65L94 64z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable" d="M0 0"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M111 129L110 150L119 152L120 162L123 165L149 140L151 135L151 126L149 125L111 124L111 128z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable" d="M0 0"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M106 5L98 5L97 6L99 8L99 12L81 13L91 22L91 64L126 65L127 44L131 35L135 33L141 33L142 28L145 26L145 24L160 20L161 21L171 19L168 15L166 15L176 10L181 10L181 8L107 5z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M31 127L41 142L55 154L68 168L77 159L84 158L85 145L82 135L80 133L71 136L48 132L36 125L32 127z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable"
                                          d="M54 117L63 122L61 133L64 135L73 136L81 133L78 124L79 123L93 124L94 108L57 108L55 116z"></path>
                                </g>
                                <g>
                                    <path stroke-linejoin="round" stroke-linecap="round" fill-rule="evenodd"
                                          stroke="#0a89e4" stroke-opacity="0.7" stroke-width="2" fill="#0a89e4"
                                          fill-opacity="0" class="leaflet-clickable" d="M0 0"></path>
                                </g>
                            </svg>
                        </div>
                        <div class="leaflet-marker-pane">
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(7.5px, 90.5px, 0px);"><span class="m-icon clickstat"
                                                                                           data-cs-p="酒店map标记"
                                                                                           data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(27.5px, 79.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(33.5px, 70.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(58.5px, -26.5px, 0px);"><span class="m-icon clickstat"
                                                                                             data-cs-p="酒店map标记"
                                                                                             data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(-8.5px, 85.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(22.5px, 80.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(189.5px, 102.5px, 0px);"><span class="m-icon clickstat"
                                                                                              data-cs-p="酒店map标记"
                                                                                              data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(24.5px, 66.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(7.5px, 83.5px, 0px);"><span class="m-icon clickstat"
                                                                                           data-cs-p="酒店map标记"
                                                                                           data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(16.5px, 82.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(26.5px, 72.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(37.5px, 130.5px, 0px);"><span class="m-icon clickstat"
                                                                                             data-cs-p="酒店map标记"
                                                                                             data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(28.5px, 62.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(17.5px, 89.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(60.5px, 110.5px, 0px);"><span class="m-icon clickstat"
                                                                                             data-cs-p="酒店map标记"
                                                                                             data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(121.5px, 57.5px, 0px);"><span class="m-icon clickstat"
                                                                                             data-cs-p="酒店map标记"
                                                                                             data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(17.5px, 54.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(128.5px, 95.5px, 0px);"><span class="m-icon clickstat"
                                                                                             data-cs-p="酒店map标记"
                                                                                             data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(13.5px, 37.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                            <div class="map-mark mark-hotel  _j_map_overlay _j_hotel_marker"
                                 style="transform: translate3d(-0.5px, 82.5px, 0px);"><span class="m-icon clickstat"
                                                                                            data-cs-p="酒店map标记"
                                                                                            data-cs-d="酒店map标记"></span>
                            </div>
                        </div>
                        <div class="leaflet-popup-pane"></div>
                    </div>
                </div>
                <div class="leaflet-control-container">
                    <div class="leaflet-top leaflet-left"></div>
                    <div class="leaflet-top leaflet-right">
                        <div class="leaflet-control-zoom leaflet-bar leaflet-control"><a class="leaflet-control-zoom-in"
                                                                                         href="#"
                                                                                         title="Zoom in">+</a><a
                                class="leaflet-control-zoom-out" href="#" title="Zoom out">-</a></div>
                    </div>
                    <div class="leaflet-bottom leaflet-left">
                        <div class="leaflet-control-scale leaflet-control">
                            <div class="leaflet-control-scale-line" style="width: 77px;">3 km</div>
                        </div>
                    </div>
                    <div class="leaflet-bottom leaflet-right">
                        <div class="leaflet-control-attribution leaflet-control">Map data ©Google</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(function () {
            var name = ${qo.name}
            var destId = ${theSearchDest.destId}
            var checkIn=${qo.checkIn}
            var checkOut=${qo.checkOut}


            $.get("/hotel/checkHotel", {name:name,destId:destId,checkIn:checkIn,checkOut:checkOut}, function (data) {
                $("#hotelConten").prepend(data);
            })
        })
    </script>

    <div id="hotelConten" class="container">



        <script language="javascript" src="http://js.mafengwo.net/js/hotel/sign/index.js?1552035728"
                type="text/javascript"
                crossorigin="anonymous"></script>
        <link href="http://css.mafengwo.net/css/hotel/captcha.css?1552035728" rel="stylesheet" type="text/css">




        <script language="javascript" src="http://js.mafengwo.net/js/corelib/underscore-1.6.0.js?1537192880"
                type="text/javascript" crossorigin="anonymous"></script>

        <script language="javascript"
                src="http://js.mafengwo.net/js/cv/js+underscore1.3.3:js+corelib+backbone-1.1.2^Z1E^1537192880.js"
                type="text/javascript" crossorigin="anonymous"></script>

        <script language="javascript" src="http://js.mafengwo.net/js/jquery-ui-1.11.0.min.js?1537192880"
                type="text/javascript" crossorigin="anonymous"></script>

        <script language="javascript" src="http://js.mafengwo.net/js/MouseTip.js?1537192880" type="text/javascript"
                crossorigin="anonymous"></script>


        <link href="http://css.mafengwo.net/css/mfw-footer.css?1558532347" rel="stylesheet" type="text/css">


        <style>
            #banner-con-gloable {
                display: block;
                position: fixed;
                bottom: 0;
                left: -100%;
                z-index: 110;
                width: 100%;
                height: 179px;
                overflow-x: hidden;
            }

            #banner-con-gloable .banner-btn-con {
                width: 100%;
                height: 162px;
                background: rgba(30, 15, 8, 0.95);
                position: absolute;
                bottom: 0;
            }

            #banner-con-gloable .banner-btn-con .close-btn {
                position: absolute;
                right: 35px;
                top: 24px;
                z-index: 120;
                height: 24px;
                width: 24px;
                cursor: pointer;
            }

            #banner-con-gloable .banner-image-con {
                position: absolute;
                right: 50%;
                bottom: 0;
                width: 1000px;
                margin-right: -500px;
            }

            #float-pannel-gloable {
                padding-left: 28px;
                padding-bottom: 20px;
                display: block;
                position: fixed;
                bottom: 0;
                z-index: 110;
                left: -230px;
            }

            #float-pannel-gloable .float-btn {
                width: 24 pxpx;
                height: 24px;
                position: absolute;
                right: 0;
                top: 0;
                z-index: 100;
            }

            #closed {
                height: 24px;
                width: 24px;
                vertical-algin: top;
                border: none;
                cursor: pointer;
            }
        </style>

        <div id="float-pannel-gloable">
            <img class="float-image" src="https://p4-q.mafengwo.net/s14/M00/BB/8C/wKgE2l0r2W-ALHaeAACAt6lqXyA464.png"
                 style="width:178px;">
            <div class="float-btn">
                <img id="closed" src="https://n4-q.mafengwo.net/s13/M00/46/AC/wKgEaVy2xHeAZJhRAAADGY-wozY871.png"></div>
        </div>


        <script>
            $(function () {

                var flag_page = location.href.match(/^(https|http):\/\/www\.mafengwo\.cn\/?$/g) ||
                        location.href.match(/^(https|http):\/\/www\.mafengwo\.cn(\/\?\S*)/g) ||
                        location.href.match(/(cn\/gonglve|cn\/yj\/|cn\/i\/|cn\/jd\/|cn\/xc\/|cn\/schedule\/|cn\/baike\/|cn\/poi\/|mdd|travel-scenic-spot)/g)

                if (!!flag_page && getCookie('ad_hide') != '1' && getCookie('ad_close_num') < 2) {
                    handleBannerShow();
                }
            });

            // 浮标关闭按钮点击
            $("#float-pannel-gloable .float-btn").click(function () {
                $("#float-pannel-gloable").animate({left: -230,}, 800, 'swing');
                add_cookie('ad_hide', '1', 1);
                if (!getCookie('ad_close_num')) {
                    add_cookie('ad_close_num', 1, 9999)
                } else if (!!getCookie('ad_close_num')) {
                    add_cookie('ad_close_num', getCookie('ad_close_num') * 1 + 1, 9999)
                }
            });

            function add_cookie(name, value, n) {
                var exp = new Date();
                exp.setTime(exp.getTime() + 24 * 60 * 1000 * 60 * n);
                document.cookie = name + '=' + value + ';expires=' + exp.toGMTString() + ';path=/';
            }

            function getCookie(cname) {
                var name = cname + "=";
                var ca = document.cookie.split(';');

                for (var i = 0; i < ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0) == ' ') c = c.substring(1);
                    if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
                }

                return "";
            }

            function delCookie(name) {
                var exp = new Date();
                exp.setTime(exp.getTime() - 1);
                var cval = getCookie(name);
                if (cval != null)
                    document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
            }

            function handleBannerShow() {
                $("#float-pannel-gloable").animate({left: 0,}, 500, 'swing');
            }


            $(".sales-sort").click(function (data) {

            })

        </script>


        <link href="http://css.mafengwo.net/css/mfw-toolbar.css?1537192876" rel="stylesheet" type="text/css">

        <div class="mfw-toolbar" id="_j_mfwtoolbar" style="display: block;">
            <div class="toolbar-item-top" style="display: none;">
                <a role="button" class="btn _j_gotop">
                    <i class="icon_top"></i>
                    <em>返回顶部</em>
                </a>
            </div>
            <div class="toolbar-item-feedback">
                <a role="button" data-japp="feedback" class="btn">
                    <i class="icon_feedback"></i>
                    <em>意见反馈</em>
                </a>
            </div>
            <div class="toolbar-item-code">
                <a role="button" class="btn">
                    <i class="icon_code"></i>
                </a>
                <a role="button" class="mfw-code _j_code">


                    <img src="https://p1-q.mafengwo.net/s1/M00/6C/51/wKgIC1t_6TuASybrAADGUPUHjr021.jpeg?imageMogr2%2Fthumbnail%2F%21450x192r%2Fgravity%2FCenter%2Fcrop%2F%21450x192%2Fquality%2F90"
                         width="450" height="192">
                </a>
                <!--<div class="wx-official-pop"><img src="http://images.mafengwo.net/images/qrcode-weixin.gif"><i class="_j_closeqrcode"></i></div>-->
            </div>

        </div>


    </div>

</body>
</html>