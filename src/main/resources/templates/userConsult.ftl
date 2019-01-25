<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="../static/css/mui.min.css">
    <link rel="stylesheet" href="../static/css/Xq.css">
    <link rel="stylesheet" href="../static/fonts/font_acyazmtbuxi/iconfont.css">
    <link rel="stylesheet" href="../static/fonts/mimasuo/iconfont.css">
    <link rel="stylesheet" href="../static/css/login2.css">
    <style>
        html,body {
            background-color: #efeff4;

        }
        .title{
            margin: 20px 15px 10px;
            color: #6d6d72;
            font-size: 15px;
        }
        .mui-input-group:before {
            position: absolute;
            top: 0;
            right: 0;
            left: 0;
            height: 0px;
            content: '';
            -webkit-transform: scaleY(.5);
            transform: scaleY(.5);
            background-color: #c8c7cc;
        }
        .mui-input-group:after {
            position: absolute;
            right: 0;
            bottom: 0;
            left: 0;
            height: 0px;
            content: '';
            -webkit-transform: scaleY(.5);
            transform: scaleY(.5);
            background-color: #c8c7cc;
        }
    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 id="title" class="mui-title">历史查询</h1>
    <a class="mui-icon mui-icon-more mui-pull-right"></a>
</header>
<div class="mui-content">
    <#list consult as userConsult>
    <div class="x-lishi">
        <div>
            <img style="width: 16.5px;height: 15.5px;" src="../static/images/date.png" alt="">
            <span class="x-riqi">${userConsult.consultTime}</span>
        </div>
        <div>
            <span class="x-content" style="font-size: 15px;color: #333333;">
                ${userConsult.consultText}
            </span>
            <a class="gengduo" href="javascript:void(0)" name="consultId">更多</a>
            <span style="display:none">${userConsult.consultId}</span>
        </div>
    </div>
    </#list>
</div>






<script src="../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../static/js/login.js"></script>
<script src="../static/layui/lay/modules/jquery-3.3.1.min.js"></script>
<script src="../static/js/mui.min.js"></script>
<script src="../static/layui/layui.js"></script>
<script>

    mui.init({
        swipeBack:true //启用右滑关闭功能
    });

</script>
<script>
    $(function () {
        $(".x-content").each(function() {
            var words = $(this).text().length;
            if(words > 59){
                $(this).text($(this).text().slice(0,59)+"...");
            }
        });
    });
</script>
<script type="text/javascript">
    $(function(){
        layui.use('layer',function () {
            layer=layui.layer;
        })
        $("a[name=consultId]").click(function(){
            var consultId=$(this).next().html();
            $.post("detailConsultPhone",{"consultId":consultId},function(returnData,status){
                if ("success"==status) {
                    var title=returnData.consultClause;
                    var content=returnData.consultText;
                    var consultTime=returnData.consultTime;
                    var d = new Date(consultTime);
                    var times=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
                    layer.open({
                        type: 1
                        ,skin:'tan-yangshi'
                        ,title:'咨询问题<span style="color: #007aff;padding-left: 5px;">('+times+')</span>'
                        ,area: ['100%', '525px']
                        ,offset: 'b' //具体配置参考：offset参数项,
                        ,content: content
                        ,btnAlign: 'b' //按钮居中
                        ,shade: 0.5 //不显示遮罩
                    });
                }
            },"json");
        })
    })
</script>
</body>
</html>


