<html>
<head>
    <title>在线支付</title>
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-form/jquery.form.js"></script>
</head>

<body>
<form action="/ticket/ticketorder" method="post" id="form"> <!--form规定当提交表单时向何处发送表单数据, 意思是当前的数据用post方法传递-->
    <table width="60%">
        <tr>

            <td bgcolor="#F7FEFF" colspan="4"> <!--colspan 属性规定单元格可横跨的列数。-->
                景点名称:<input type="text" value="${ticketDetail.name}" readonly="true"></br>
                <input type="hidden" name="userId.id" value="${userInfo.id}">
                <input type="hidden" name="ticketId.id" value="${ticketDetail.id}">
                订单号：<INPUT TYPE="text" NAME="order_num" value="${uuid}"></br>
                支付金额：<INPUT TYPE="text" NAME="money" size="6" value="${(ticketDetail.price)!}" readonly="true">元</br>
            </td>
        </tr>
        <tr><td><br/></td></tr>
        <tr>
            <td>请您选择在线支付银行</td>
        </tr>
        <tr>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBCHINA-NET">招商银行 </td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ICBC-NET">工商银行</td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ABC-NET">农业银行</td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CCB-NET">建设银行 </td>
        </tr>
        <tr>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBC-NET">中国民生银行总行</td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CEB-NET" >光大银行 </td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="BOCO-NET">交通银行</td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="SDB-NET">深圳发展银行</td>
        </tr>
        <tr>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="BCCB-NET">北京银行</td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CIB-NET">兴业银行 </td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="SPDB-NET">上海浦东发展银行 </td>
            <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ECITIC-NET">中信银行</td>
        </tr>
        <tr><td><br/></td></tr>
        <tr>
            <td><INPUT TYPE="button" id="subform" value="确定支付"></td>
        </tr>
    </table>
</form>
<script>
    $(function () {
        $("#subform").click(function () {
            $("#form").ajaxSubmit(function (data) {
                if(data.success){
                    alert("已经为您下单");
                    window.location.href="http://localhost:8888/mytivketorder"
                }else{
                    alert("下单失败")
                }
            })
        })
    })
</script>
</body>
</html>