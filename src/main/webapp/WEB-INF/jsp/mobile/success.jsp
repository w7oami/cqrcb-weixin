<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ch-zn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="http://cdn.bootcss.com/weui/0.4.0/style/weui.css" />
	<title>操作成功</title>
</head>
<body>
<div class="weui_msg">
  <div class="weui_icon_area"><i class="weui_icon_success weui_icon_msg"></i></div>
  <div class="weui_text_area">
    <h2 class="weui_msg_title">操作成功</h2>
    <c:if test="${null != msg }">
    	<p class="weui_msg_desc">${msg }</p>
    </c:if>
  </div>
  <div class="weui_opr_area">
    <p class="weui_btn_area">
      <a href="javascript:;" class="weui_btn weui_btn_primary">确定</a>
    </p>
  </div>
  <div class="weui_extra_area">
  	<!-- 
    <a href="">查看详情</a>
     -->
  </div>
</div>
</body>
</html>
