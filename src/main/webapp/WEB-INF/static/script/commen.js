wx.ready(function() {
    var title = "重庆农村商业银行8周年";
    var desc = "8周年重庆农村商业银行玩游戏抽好礼";
    var link = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7ca575640689ee53&redirect_uri=http://zhouji.ittun.com/cqrcb/active&response_type=code&scope=snsapi_base#wechat_redirect";
    var imgUrl = "";

    //微信朋友
    wx.onMenuShareAppMessage({
        title: title, // 分享标题
        desc: desc, // 分享描述
        link: link, // 分享链接
        imgUrl: imgUrl // 分享图标
    });

    //QQ
    wx.onMenuShareQQ({
        title: title, // 分享标题
        desc: desc, // 分享描述
        link: link, // 分享链接
        imgUrl: imgUrl // 分享图标
    });

    //朋友圈
    wx.onMenuShareTimeline({
        title: title, // 分享标题
        link: link, // 分享链接
        imgUrl: imgUrl // 分享图标
    });
});

var onMenuShareTimeline = function() {
    if (typeof WeixinJSBridge == "object" && typeof WeixinJSBridge.invoke == "function") {
        WeixinJSBridge.invoke('sendAppMessage', {
            "title": "36氪",
            "link": "http://zephyr.ittun.com",
            "desc": "关注互联网创业",
            "img_url": "http://zephyr.ittun.com/assets/images/apple-touch-icon.png"
        }, function(res) {
            alert(res.err_msg);
        });
    }
}