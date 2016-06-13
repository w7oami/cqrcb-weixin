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
        imgUrl: imgUrl, // 分享图标
        success: function () {
            // 用户确认分享后执行的回调函数
            $(".start_name.game_share").hide();
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
            $(".start_name.game_share").hide();
        }
    });

    //QQ
    wx.onMenuShareQQ({
        title: title, // 分享标题
        desc: desc, // 分享描述
        link: link, // 分享链接
        imgUrl: imgUrl, // 分享图标
        success: function () {
            // 用户确认分享后执行的回调函数
            $(".start_name.game_share").hide();
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
            $(".start_name.game_share").hide();
        }
    });

    //朋友圈
    wx.onMenuShareTimeline({
        title: title, // 分享标题
        link: link, // 分享链接
        imgUrl: imgUrl, // 分享图标
        success: function () {
            // 用户确认分享后执行的回调函数
            $(".start_name.game_share").hide();
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
            $(".start_name.game_share").hide();
        }
    });
});

var onMenuShareTimeline = function() {
    $(".start_name.game_share").unbind("click");
    $(".start_name.game_share").show();
    $(".start_name.game_share").on("click", function() {
        $(".start_name.game_share").hide();
    });
}