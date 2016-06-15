<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<meta charset="utf-8">
<title>重庆农村商业银行成立八周年客户回馈活动</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="MobileOptimized" content="320">
<link rel="stylesheet" type="text/css" href="${path}/static/css/amazeui.min.css">
<link rel="stylesheet" type="text/css" href="${path}/static/css/app.css">
<style>
    .main { max-width: 640px; min-width: 320px; margin: 0 auto;}
    .main img { width: 100%; display: block;}
    body{color: #ffffff; font-size: 16px; background-color: #fff;}
    input{height:60px;}
    button{height:50px;}
    .am-g { margin: 15px auto;}
    .am-g a { display: block; width: 60%; background-color: #dd514c; border-radius: 100px; padding: .5em 1em;
        font-size: 1.2rem;
        font-weight: 400;
        line-height: 1.2;
        text-align: center;
        white-space: nowrap; color: #fff; text-decoration: none; margin: 4px auto; }
    .am-g a:hover {  background-color: #d7342e;}
</style>
</head>
<body>
<div class="main">
    <img src="${path}/static/images/rule_01.gif">
    <img src="${path}/static/images/rule_02.jpg">
    <div class="am-g">
        <a href="${path}/cqrcb/ruleView" type="submit">活动规则</a>
        <a href="http://h5.yoois.com/" type="submit">看重庆农商行荣耀8载</a>
        <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appId}&redirect_uri=${basePath}/cqrcb/active&response_type=code&scope=snsapi_base#wechat_redirect" type="submit">点气球 抽大奖</a>
    </div>
    <img src="${path}/static/images/rule_03.gif">
</div>
</div>
<%@ include file="/WEB-INF/jsp/common/import-js.jsp" %>
</body>
</html>


