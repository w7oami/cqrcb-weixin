<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="${path}/static/css/index.css">
<link rel="stylesheet" href="${path}/static/css/weui.min.css" />
<link rel="stylesheet" href="${path}/static/css/jquery-weui.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="MobileOptimized" content="320">
</head>
<body>
<div class="main">
    <div class="mainpic"><img src="${path}/static/images/main_01.jpg"></div>
    <div class="mainbtn">
        <img src="${path}/static/images/main_02.jpg">
        <div class="mb_ctn">
            <a href="javascript:game();"><img src="${path}/static/images/main_btn.png"></a>
            <img src="${path}/static/images/maintitle.png" class="mb_title">
        </div>
    </div>
    <div class="mainfont">
        <div class="mf_box">
            <p>1.活动时间： 2016年6月29日至7月27日<br>2.活动期间登录微信公众号，参与打气球游戏。<br>3.当周参与游戏者，有机会被抽取为幸运大奖获得者。<br>4.每周抽取获奖者：<br>一等奖1名，奖Iphone 6s plus（16G）<br>二等奖8名，奖888元商城电子券<br>三等奖88名，奖88元商城电子券</p>
        </div>
        <img src="${path}/static/images/main_03.jpg">
    </div>
    <!-- 输入姓名手机号 -->
    <div class="start_name" style="display:none;">
        <div class="sn_info">
            <img src="${path}/static/images/name.png" class="sn_i_mainpic">
            <a href="javascript:closeWin('start_name');" class="sn_i_close"><img src="${path}/static/images/nameclose.png"></a>
            <div class="sn_i_ip">
                <input type="tel" name="phone"  placeholder="请输入手机号码">
                <input type="text" name="name" placeholder="请输入姓名">
                <a href="javascript:submt();" class="sn_i_btn"><img src="${path}/static/images/namebtn.png"></a>
            </div>
        </div>
    </div>
    <div class="main_code" style="display: none;">
        <div class="mc_ctn">
            <div class="mc_ctnbox">
                <a href="javascript:closeWin('main_code');" class="sn_i_close"><img src="${path}/static/images/nameclose.png"></a>
                <p><img src="${path}/static/images/mainfont.png" class="mc_title"></p>
                <img src="${path}/static/images/code.gif" class="mc_codepic">
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="/WEB-INF/jsp/common/import-js.jsp" %>
<script type="application/javascript">

    var isHas = ${isHas};
    var isAuth = ${isAuth};

    var closeWin = function(winName) {
        $("." + winName).hide();
    };

    var game = function() {
        if(!isAuth) {
            $(".main_code").show();
        } else {
            if(!isHas) {
                $(".start_name").show();
            } else {
                window.location.href = '${path}' + "/cqrcb/gameView";
            }
        }
    };

    var submt = function() {
        $.showLoading('正在提交中...');
        var name = $("input[name=name]").val();
        var phone = $("input[name=phone]").val();

        if(phone.length < 11) {
            $.toast("手机号不能小于11位!", "cancel");
            return false;
        }

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
                    setTimeout(function() {
                        window.location.href = '${path}' + "/cqrcb/gameView";
                    }, 2000);
                } else {
                    if("userMore" == data) {
                        $.toast("微信号重复!", "cancel");
                    } else if("phoneMore" == data) {
                        $.toast("手机号重复!", "cancel");
                    } else {
                        $.toast("提交失败!", "cancel");
                    }
                }
            }
        });
    }
</script>
</html>