<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="${path}/static/css/index.css">
<link rel="stylesheet" href="${path}/static/css/weui.min.css" />
<link rel="stylesheet" href="${path}/static/css/jquery-weui.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="MobileOptimized" content="320">
</head>
<body>
<div class="gm_box">
    <div class="gm_ball">
        <!--<div class="gm_ballbox" style="left:50px;">
            <img src="${path}/static/images/gm_ball.png" style="display:block;">
            <img src="${path}/static/images/gm_ball.gif" style="display:block;">
            <i>+11</i>
        </div>
        <div class="gm_ballbox">
            <img src="${path}/static/images/gm_ball2.png">
            <img src="${path}/static/images/gm_ball2.gif">
            <i>+11</i>
        </div>-->
    </div>
    <div class="gm_bg">
        <img src="${path}/static/images/gm_bg.jpg">
    </div>
    <div class="gm_time">00:00</div>
    <div class="gm_score">0</div>
</div>
</body>
<%@ include file="/WEB-INF/jsp/common/import-js.jsp" %>
<script type="application/javascript">
    var width = window.screen.width;
    var height = window.screen.height;
    var number = 0;
    var i = 0;
    var ballList = null;
    var time = 0;
    var score = 0;
    $(function() {
        $.showLoading('正在准备气球...');
        getBallList();
    });

    function getBallList() {
        $.ajax({
            async:true,
            url: "${path}/cqrcb/getRandomPoint",
            type: "GET",
            dataType: "html",
            data: {},
            success: function(data){
                $.hideLoading();
                ballList = eval("(" + data + ")");
                number = data.length;
                i = 0;
                showBall();
                time = 20;
                score = 0;
                $(".gm_time").html("00:" + time);
                setTime();
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

    function showBall() {
        setTimeout(function(){
            if(i == number) {
                return;
            }
            var map = ballList[i];
            i++;

            for(var key in map) {
                var ball = "";
                if(i%2 == 1) {
                    ball = "2";
                }
                var left = Math.floor(Math.random()*220);
                var html = "<div class=\"gm_ballbox\" style=\"left:" + left + "px; top:" + (height - 260) + "px;\">";
                html += "<img src=\"${path}/static/images/gm_ball" + ball + ".png\" >";
                html += "</div>";

                var $html = $(html);

                $(".gm_ball").append($html);

                $html.animate({top: "0px"}, 5000, function() {
                    $html.remove();
                });

                $html.on("touchstart", function() {
                    var $that = $(this);
                    $that.stop();
                    $that.html("<img src=\"${path}/static/images/gm_ball" + ball + ".gif\" >");
                    setTimeout(function(){
                        $that.html("<i>+" + map[key] + "</i>");
                        score += map[key];
                        $(".gm_score").html(score);
                        setTimeout(function() {
                            $that.remove();
                        }, 200);
                    }, 200);
                });
                break;
            }

            showBall();
        }, 20 / 35 * 1000);
    };

</script>
</html>


