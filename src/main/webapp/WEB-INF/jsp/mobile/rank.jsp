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
<div class="rank">
    <div class="rank_main">
        <div class="rm_btn">
            <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appId}&redirect_uri=${basePath}/cqrcb/active&response_type=code&scope=snsapi_base#wechat_redirect"><img src="${path}/static/images/rank_01.png"></a>
        </div>
        <img src="${path}/static/images/rank_main.jpg" class="rm_main">
    </div>
    <div class="rank_list">
        <table  border="0" cellspacing="0" cellpadding="0">
            <thead>
            <td class="20%">排名</td>
            <td class="50%">电话</td>
            <td class="30%">积分</td>
            </thead>

        </table>
        <a href="javascript:queryList(100);"><img src="${path}/static/images/rank_more.png"></a>
    </div>
</div>
</body>
<%@ include file="/WEB-INF/jsp/common/import-js.jsp" %>
<script type="text/javascript">
    $(function() {
        queryList(10);
    });

    function queryList(number) {
        $.showLoading('正在准备数据...');
        $.ajax({
            async:true,
            url: path + "/cqrcb/getRankList",
            type: "GET",
            dataType: "html",
            data: {number: number},
            success: function(data){
                $.hideLoading();
                data = eval("(" + data + ")");
                var html = "<thead><td class=\"20%\">排名</td><td class=\"50%\">电话</td><td class=\"30%\">积分</td></thead>";
                for(var i=0; i<data.length; i++) {
                    html += "<tr>";
                    html += "<td>" + (i + 1) + "</td>";
                    html += "<td>" + hidePhone(data[i].phone) + "</td>";
                    html += "<td>" + data[i].point + "</td>";
                    html += "</tr>";
                }

                $(".rank_list > table").html(html);
            }
        });
    }

    function hidePhone(phone) {
        var s1 = phone.substring(0, 3);
        var s2 = phone.substring(7, 11);
        return s1 + "****" + s2;
    }
</script>
</html>