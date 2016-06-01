<script type="text/javascript" src="${path}/static/script/jquery.min.js"></script>
<script type="text/javascript" src="${path}/static/script/jquery-weui.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>
<script type="text/javascript" src="${path}/static/script/commen.js"></script>
<script type="text/javascript">
	var path = '${path}';

	wx.config({
		debug: true,
		appId: "${jsApiConfig.appId}",
		timestamp: ${jsApiConfig.timestamp},
		nonceStr: "${jsApiConfig.nonceStr}",
		signature: "${jsApiConfig.signature}",
		jsApiList: [
			// 所有要调用的 API 都要加到这个列表中
			"checkJsApi",
			"onMenuShareTimeline",
			"onMenuShareAppMessage",
			"onMenuShareQQ",
			"onMenuShareWeibo",
			"onMenuShareQZone"
		]
	});
</script>