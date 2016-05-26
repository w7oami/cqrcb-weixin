<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ch-zn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1,minimum-scale=1,user-scalable=no">
    <link rel="stylesheet" href="${path}/static/css/weui.min.css" />
    <link rel="stylesheet" href="${path}/static/css/jquery-weui.min.css" />
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
      <a href="${path}${toUrl}" class="weui_btn weui_btn_primary">确定</a>
    </p>
  </div>
  <div class="weui_extra_area">
  	<!-- 
    <a href="">查看详情</a>
     -->
  </div>
</div>
</body>
<script type="text/javascript" src="${path}/static/script/jquery.min.js"></script>
<script type="text/javascript" src="${path}/static/script/jquery-weui.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>
<script type="application/javascript">
  wx.config({
    debug: true,
    appId: '${jsApiConfig.appId}',
    timestamp: ${jsApiConfig.timestamp},
    nonceStr: '${jsApiConfig.nonceStr}',
    signature: '${jsApiConfig.signature}',
    jsApiList: [
      // 所有要调用的 API 都要加到这个列表中
      'checkJsApi',
      'openLocation',
      'getLocation',
      'chooseImage',
      'uploadImage'
    ]
  });
</script>
</html>
