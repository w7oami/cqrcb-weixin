<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ch-zn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
    <link rel="stylesheet" href="${path}/static/css/weui.min.css" />
    <link rel="stylesheet" href="${path}/static/css/jquery-weui.min.css" />
    <title>操作</title>
</head>
<body>
<form action="${path}/cqrcb/saveUser" method="get">
<div class="weui_cells weui_cells_form">
    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">姓名</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" placeholder="请输入真实姓名" name="name">
        </div>
    </div>

    <div class="weui_cell">
        <div class="weui_cell_hd">
            <label class="weui_label">手机</label>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" type="tel" placeholder="请输入手机号码" name="phone">
        </div>
    </div>

    <a href="javascript:submt();" class="weui_btn weui_btn_primary">提交</a>
</div>
</form>
</body>
<script type="text/javascript" src="${path}/static/script/jquery.min.js"></script>
<script type="text/javascript" src="${path}/static/script/jquery-weui.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>
<script type="application/javascript">

    var submt = function() {
        $.showLoading('正在提交中...');
        var name = $("input[name=name]").val();
        var phone = $("input[name=phone]").val();
        $.ajax({
            async:true,
            url: "${path}/cqrcb/saveUser",
            type: "GET",
            dataType: "html",
            data: {name: name, phone: phone},
            success: function(data){
                $.hideLoading();
                if("ok" == data) {
                    $.toast("提交成功!");
                } else {
                    $.toast("提交失败!", "cancel");
                }
            }
        });
    }
</script>
</html>
