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
<div class="gm_box">
    <div class="gm_ball">

    </div>
    <div class="gm_bg">
        <img src="${path}/static/images/gm_bg.jpg">
    </div>
    <div class="gm_time">00:00</div>
    <div class="gm_score">0</div>

    <!-- 获得分数 -->
    <div class="start_name game_score" style="display:none;">
        <div class="sn_info">
            <img src="${path}/static/images/sc_bg.png" class="sn_i_mainpic">
            <a href="javascript:closeWin();" class="sn_i_close"><img src="${path}/static/images/nameclose.png"></a>
            <div class="sc_num">
                <p>获得<i>999</i>积分</p>
                <div class="sc_btn">
                    <a href="javascript:getBallList();"><img src="${path}/static/images/sc_btn1.png"></a>
                    <a href="javascript:onMenuShareTimeline();"><img src="${path}/static/images/sc_btn2.png"></a>
                </div>
            </div>
        </div>
    </div>
    <!-- 倒计时 -->
    <div class="start_name game_num" style="display:none;">
        <img src="${path}/static/images/time_01.png" style="display:none;">
        <img src="${path}/static/images/time_02.png" style="display:none;">
        <img src="${path}/static/images/time_03.png" style="display:block;">
    </div>
    <!-- 朋友圈 -->
    <div class="start_name game_share" style="display:none;">
        <img src="${path}/static/images/share.png">
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/import-js.jsp" %>
<script type="text/javascript" src="${path}/static/script/game.js"></script>
</body>
</html>


