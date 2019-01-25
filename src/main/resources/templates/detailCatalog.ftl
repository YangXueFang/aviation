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
    <style>
        html, body {
            background-color: #fff;
        }
    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 id="title" class="mui-title">标题</h1>
    <a class="mui-icon mui-icon-more mui-pull-right"></a>
</header>
<div class="mui-content" style="background-color: #fff;">
    <div class="x-title">
        <span>${fuji.cateText}  >  ${catalog.cateText}</span>
    </div>
    <#list clauseList as clause>
        <div class="x-biaoti">
            <span>第${clause.clauseNumber}条</span>
            <h4>${clause.clauseTitle}</h4>
            <div class="x-shoucang">
                <span class="iconfont icon-shoucang" style="color: #000;"></span>
                <span>收藏</span>
            </div>
        </div>
        <div style="padding: 5px;">
            <span>${clause.clauseText}</span>
        </div>
    </#list>
</div>
</body>
</html>