<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="${path}/static/css/index.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="MobileOptimized" content="320">
</head>
<body>
<div class="gm_box">
    <div class="gm_ball">
        <div class="gm_ballbox" style="left:50px;">
            <img src="${path}/static/images/gm_ball.png" style="display:block;">
            <img src="${path}/static/images/gm_ball.gif" style="display:block;">
            <i>+11</i>
        </div>
        <div class="gm_ballbox">
            <img src="${path}/static/images/gm_ball2.png">
            <img src="${path}/static/images/gm_ball2.gif">
            <i>+11</i>
        </div>
    </div>
    <div class="gm_bg">
        <img src="${path}/static/images/gm_bg.jpg">
    </div>
    <div class="gm_time">00:00</div>
    <div class="gm_score">300</div>
</div>
</body>
<%@ include file="/WEB-INF/jsp/common/import-js.jsp" %>
</html>


