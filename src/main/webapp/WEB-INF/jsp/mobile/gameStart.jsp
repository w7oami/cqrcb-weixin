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
<div class="start">
    <div class="startpic"><img src="${path}/static/images/gmbg_01.jpg"></div>
    <div class="startbtn">
        <div class="stb_ctn">
            <p>剩余次数：${10 - gameCount}次</p>
            <a href="${path}/cqrcb/game" class="st_start"><img src="${path}/static/images/start_01.png"></a>
            <div class="st_link">
                <a href="${path}/cqrcb/showRank"><img src="${path}/static/images/start_02.png"></a>
            </div>
        </div>
        <img src="${path}/static/images/gmbg_02.jpg" class="startbg">
    </div>
    <div class="startfont">
        <img src="${path}/static/images/gmbg_03.jpg" class="startbg">
        <p>游戏介绍：<i></i>1.每点击一个气球，随机获取5-20分；<i></i>2.游戏时长20s，每天10次；</p>
    </div>
</div>
</body>
<%@ include file="/WEB-INF/jsp/common/import-js.jsp" %>

</html>


