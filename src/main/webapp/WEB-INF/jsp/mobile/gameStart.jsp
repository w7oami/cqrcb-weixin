<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<meta charset="utf-8">
<title>点气球 抽大奖</title>
<link rel="stylesheet" href="${path}/static/css/index.css">
<link rel="stylesheet" href="${path}/static/css/weui.min.css" />
<link rel="stylesheet" href="${path}/static/css/jquery-weui.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="MobileOptimized" content="320">
</head>
<body>
<div class="start">
    <div class="startpic"><img src="${path}/static/images/gmbg_01.jpg"></div>
    <div class="startbtn">
        <div class="stb_ctn">
            <p>剩余次数：${3 - gameCount}次</p>
            <c:if test="${gameCount < 3}">
                <a href="${path}/cqrcb/game" class="st_start"><img src="${path}/static/images/start_01.png"></a>
            </c:if>
            <c:if test="${gameCount >= 3}">
                <a href="javascript:overEnd();" class="st_start"><img src="${path}/static/images/start_01.png"></a>
            </c:if>
        </div>
        <img src="${path}/static/images/gmbg_02.jpg" class="startbg">
    </div>
</div>
</body>
<%@ include file="/WEB-INF/jsp/common/import-js.jsp" %>
<script type="text/javascript">
    function overEnd() {
        $.toast("您今天的游戏次数已用完", "cancel");
    }
</script>
</html>


