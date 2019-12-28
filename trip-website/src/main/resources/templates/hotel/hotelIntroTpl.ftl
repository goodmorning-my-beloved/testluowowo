<div class="n-content">
    <div class="hotel-loading" id="_j_hotel_list_loading" style="display: none;"><i class="loading-m"></i></div>
    <div class="hotel-list" id="_j_hotel_list">
            <#list hotel as h>
                <div class="hotel-item clearfix _j_hotel_item" data-id="9031088" data-is-merge_room="0"
                     data-name="${h.name}" data-lat="25.042788" data-lng="121.50931" data-is-airbnb="0"
                     data-cs-t="酒店list页点击入口分布">
                    <div class="hotel-pic">
                        <a href="${h.url!}" class="_j_hotel_info_link" target="_blank"
                           data-cs-p="图片">
                            <img src="${h.coverUrl}"
                                 alt="" style="width: 330px;">
                        </a>

                    </div>
                    <div class="hotel-title">
                        <div class="title">
                            <h3><a href="${h.url!}" class="_j_hotel_info_link" target="_blank"
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
                    <#list (h.tool)! as type>
                    <div class="hotel-btns" id="type${(type.id)!}">
                        <a class="btn-booking _j_booking_btn" href="javascript:" rel="nofollow" style=""
                           data-ota="ctrip"
                           data-url=""
                           data-price="626" data-is-cache-price="0" data-is-sold-out="0" data-pay-type="">
                            <div class="ota">
                                <div class="name">
                                    <strong>房型:${(type.roomType)!}(可容${(type.maxLiveNum)!}人)${((type.tool==true)?string('','售罄'))!}</strong>
                                </div>
                                <p class="tips" style="display:none;"></p>
                            </div>
                            <div class="price _j_booking_price">
                                <strong>￥</strong><strong>${(type.roomPrice)!}</strong><strong
                                    style="font-size: 12px;color: #666;padding-left: 2px;vertical-align: 1px;">均价</strong>
                                <i class="arrow"></i>
                            </div>
                            <#-- 等待 -->
                            <#--<div class="price _j_booking_sold_out" style="display:block;">-->
                                <#--<span>已售罄</span>-->
                            <#--</div>-->
                        </a>
                    </div>
                    <script>
                        /* 点击弹出模态框,模态框中有确定和取消按钮,编辑预订信息:备注||||||||||显示信息:用户id,房型,几人间,酒店名*/
                        $(function () {
                            $('#type${type.id}').click(function () {
                                // 有机会再修补模态框的事情,现在直接用alert就好了
                                var a=confirm("是否下订单??!!");
                                if(a){
                                    var hotelRoomTypeId = ${(type.id)!};
                                    var userId = ${(userInfo.id)!};
                                    var checkIn =  $('#theCheckIn').html()
                                    var checkOut = $('#theCheckOut').html()
                                   /* $.get('/hotel/h',{name:'上海'},function(){
                                        alert(11.)
                                    })*/
                                    $.get('/hotel/takeOrder',{hotelRoomTypeId:hotelRoomTypeId,userId:userId,checkIn:checkIn,checkOut:checkOut,state:1},function (data) {
                                        if(data.success){
                                            alert("下订单成功")
                                            $('#kkk').detach()
                                            $('.n-content').detach();
                                            $('#contentForm').ajaxSubmit(function(data){
                                                $('.hotel-sortbar').after(data);
                                            })

                                        }else {
                                            alert("系统异常,请稍后再做尝试")
                                        }
                                    })
                                }
                                else{
                                    alert("停止下订单");
                                }


                                <#--$("#editFormTpl").clearForm(true);-->
                                <#--// 用户看到的信息回显-->
                                <#--var hname = $('._j_hotel_item').data('name')-->
                                <#--$('#jiudianming').html(hname)-->

                                <#--// 用户id-->

                                <#--$('#fangxingming').html(${type.roomType})-->
                                <#--$('#jirenjian').html(${type.maxLiveNum})-->

                                <#--// 真实的信息回显-->
                                <#--$("#editFormTpl input[name='hotelRoomTypeId']").val(${type.roomType}); // 房型-->
                                <#--// 用户名-->
<#--//                                     $("#editFormTpl input[name='name']").val(data.name);-->
<#--//                                     $("#editFormTpl input[name='sn']").val(data.sn);-->
<#--//                                     $("#editFormTpl input[name='sequence']").val(data.sequence);-->
<#--//                                     $("#editFormTpl select[name='ishot']").val(data.ishot+'');-->
<#--//                                     $("#editFormTpl select[name='type']").val(data.type);-->
<#--//                                     //$("#editFormTpl select[name='refIds']").val(data.refIds);-->
<#--//                                     $("#editFormTpl textarea[name='info']").val(data.info);-->
<#--//                                 //弹出模态框-->
                                <#--$("#editModal").modal("show");-->
                            })
                        })
                    </script>


                    </#list>

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
</div>
<div id="kkk">
    <div style="float: right">
        <div style="float: left;"><span style="line-height:30px"> 共${pageInfo.pages}页 / ${pageInfo.total}条&nbsp;&nbsp;&nbsp;</span>
        </div>
        <div id="pagination" class="jq-pagination" style="display: inline;"></div>
    </div>
    <script>
        $("#pagination").jqPaginator({
            totalPages: ${pageInfo.pages}|| 1,
                visiblePages
        :
        5,
                currentPage
        : ${pageInfo.pageNum}||
        1,
                prev
        :
        '<a class="prev" href="javascript:void(0);">上一页<\/a>',
                next
        :
        '<a class="next" href="javascript:void(0);">下一页<\/a>',
                page
        :
        '<a href="javascript:void(0);">{{page}}<\/a>',
                last
        :
        '<a class="last" href="javascript:void(0);" >尾页<\/a>',
                onPageChange
        :

        function (page, type) {
            if (type == 'change') {
                $("#currentPage").val(page);
                $('#kkk').detach()
                $('.n-content').detach();
                $('#contentForm').ajaxSubmit(function (data) {
                    $('.hotel-sortbar').after(data);
                })
            }
        }
        })
    </script>
</div>

<#--<div class="modal fade" id="editModal">-->
    <#--<div class="modal-dialog">-->
        <#--<div class="modal-content">-->
            <#--<div class="modal-header">-->
                <#--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span> </button>-->
                <#--<h4 class="modal-title">酒店订单编辑</h4>-->
            <#--</div>-->
            <#--<div class="modal-body">-->
                <#--<form class="form-horizontal" action="/###" method="post" id="editFormTpl">-->
                    <#--<input type="hidden" value="" name="id">-->
                    <#--<div class="form-group">-->
                        <#--<label  class="col-sm-3 control-label">用户名称：</label>-->
                        <#--<div class="col-sm-6">-->
                            <#--<span id="yonghuming">&lt;#&ndash;  用户名称 &ndash;&gt;</span>-->
                        <#--</div>-->
                        <#--<div class="col-sm-6">-->
                            <#--<input type="hidden" class="form-control" readonly id="userId" name="userId" value="用户id">-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="form-group">-->
                        <#--<label  class="col-sm-3 control-label">房型：</label>-->
                        <#--<div class="col-sm-6">-->
                            <#--<span id="fangxingming">&lt;#&ndash;  房型名称 &ndash;&gt;</span>-->
                        <#--</div>-->
                        <#--<div class="col-sm-6">-->
                            <#--<input type="hidden" class="form-control" name="hotelRoomTypeId" readonly value="写id" >-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="form-group">-->
                        <#--<label  class="col-sm-3 control-label">房间容纳人数：</label>-->
                        <#--<div class="col-sm-6">-->
                            <#--<span id="jirenjian">&lt;#&ndash;  几人间 &ndash;&gt;</span>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="form-group">-->
                        <#--<label  class="col-sm-3 control-label">酒店名称：</label>-->
                        <#--<div class="col-sm-6">-->
                            <#--<span id="jiudianming">&lt;#&ndash;  酒店名 &ndash;&gt;</span>-->
                        <#--</div>-->
                    <#--</div>-->

                <#--</form>-->
            <#--</div>-->
            <#--<div class="modal-footer">-->
                <#--<button type="button" class="btn btn-primary submitBtn" >保存</button>-->
                <#--<button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->


