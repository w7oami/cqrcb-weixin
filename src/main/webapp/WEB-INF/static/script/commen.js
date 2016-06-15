wx.ready(function() {
    var title = "重庆农村商业银行成立八周年客户回馈活动";
    var desc = "重庆农商行成立八周年，惊喜大礼享不停！赶快参与“点气球 抽大奖”客户回馈活动，iPhone 6s plus等多重好礼等您带回家！";
    var link = home_url;
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