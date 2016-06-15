var width = window.screen.width;
var height = window.screen.height;
var number = 0;
var i = 0;
var ballList = null;
var time = 0;
var score = 0;
var isPlay = false;
$(function() {
    getBallList();
    $("#music").on("touchstart", function(e) {
        if(isPlay) {
            isPlay = false;
            $("#music audio").get(0).pause();
            $("#music div.play").addClass("musicno");
            $("#music span").html("开启");
        } else {
            isPlay = true;
            $("#music audio").get(0).play();
            $("#music div.play").removeClass("musicno");
            $("#music span").html("关闭");
        }
    });
    $("#music audio").get(0).play();
    $("#music span").html("关闭");
    isPlay = true;
});

function countDown(count_time) {
    if(count_time > 0) {
        $(".start_name.game_num").find("img").hide();
        $(".start_name.game_num").find("img").eq(count_time - 1).show();
        $(".start_name.game_num").show();
        setTimeout(function () {
            countDown(count_time - 1);
        }, 1000);
    } else {
        $(".start_name.game_num").hide();
        showBall();
        setTime();
    }
}

function getBallList() {
    $.showLoading('正在准备气球...');
    $(".start_name.game_score").hide();
    $.ajax({
        async:true,
        url: path + "/cqrcb/getRandomPoint",
        type: "GET",
        dataType: "html",
        data: {},
        success: function(data){
            $.hideLoading();
            ballList = eval("(" + data + ")");
            number = ballList.length;
            if(number > 0) {
                i = 0;
                time = 20;
                score = 0;
                $(".gm_score").html(score);
                $(".gm_time").html("00:" + time);
                countDown(3);
            } else {
                $.toast("您今天的游戏次数已用完", "cancel");
                window.location.href = home_url;
            }
        }
    });
};

function setTime() {
    setTimeout(function() {
        time--;
        if(time >= 0) {
            if (time < 10) {
                $(".gm_time").html("00:0" + time);
            } else {
                $(".gm_time").html("00:" + time);
            }

            setTime();
        }
    }, 1000);
}

var timer = null;

function showBall() {
    timer = setTimeout(function(){
        if(i == number) {
            return false;
        }
        var map = ballList[i];
        i++;

        for(var key in map) {
            var ball = i%5 + "";
            if(ball == "0" || ball == "1") {
                ball = "";
            }
            var left = Math.floor(Math.random()*220);
            var speed = Math.floor(Math.random()*3) + 1;
            var html = "<div class=\"gm_ballbox\" style=\"left:" + left + "px; top:" + (height - 260) + "px;\">";
            html += "<img src=\"" + path + "/static/images/gm_ball" + ball + ".png\" >";
            html += "</div>";

            var $html = $(html);

            $(".gm_ball").append($html);

            $html.animate({top: "0px"}, speed * 1000, function() {
                $html.remove();
                if(time < 0 && $(".gm_ball").find(".gm_ballbox").length == 0) {
                    clearTimeout(timer);
                    $.showLoading('正在上传成绩...');
                    updateScore();
                }
            });

            $html.on("touchstart", function() {
                var $that = $(this);
                $that.unbind("touchstart");
                $that.stop();
                $that.html("<div class=\"gm_ballgif\"><img src=\"" + path + "/static/images/gm_ball" + ball + ".gif\" ></div>");
                setTimeout(function(){
                    $that.html("<i>+" + map[key] + "</i>");
                    score += map[key];
                    $(".gm_score").html(score);
                    setTimeout(function() {
                        $that.remove();

                        setTimeout(function() {
                            if(time < 0 && $(".gm_ball").find(".gm_ballbox").length == 0) {
                                clearTimeout(timer);
                                $.showLoading('正在上传成绩...');
                                updateScore();
                            }
                        }, 100);
                    }, 200);
                }, 200);


            });
            break;
        }

        showBall();
    }, 20 / number * 1000);
};

function updateScore() {
    $.ajax({
        async:true,
        url: path + "/cqrcb/updateScore",
        type: "POST",
        dataType: "html",
        data: {score: score},
        success: function(data){
            $.hideLoading();
            data = eval("(" + data + ")");
            if("ok" == data.code) {
                if(data.count == 10) {
                    $(".start_name.game_score").find("a").eq(0).replace("<a href=" + home_url + "><img src=\"" + path + "/static/images/rank_01.png\"></a>");
                }
                $(".start_name.game_score").find("div.sc_num").find("p").find("i").html(data.score);
                $(".start_name.game_score").show();
            } else if("userIsNull" == data.code) {
                $.toast("用户不存在!", "cancel");
                window.location.href = home_url;
            } else if("scoreIsMore" == data.code) {
                $.toast("用户分数异常！!", "cancel");
                window.location.href = home_url;
            }
        }
    });
};

function closeWin() {
    $(".start_name.game_score").hide();
}