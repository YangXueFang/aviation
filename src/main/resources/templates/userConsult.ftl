<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title></title>

</head>
<body>
<h1>咨询问题</h1>
//时间  内容   点击更多到详情页面()
<ul>
    <#list consult as consult>
        <li>${consult.consultTime}</li>
        <li>${consult.consultText}<a href="detailConsultController?consultId=${consult.consultId}">更多</a></li>
    </#list>

</ul>

</body>
</html>


