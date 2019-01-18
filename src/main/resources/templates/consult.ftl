<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title></title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <link rel="stylesheet" href="../static/css/Xq.css">
</head>
<body>

<div class="overall">
    <header>
        <div class="daohang">咨询管理 / 咨询列表</div>
        <div class="title">咨询列表</div>
        <form method="post" action="listConsultController">
        <div class="content">
            <label class="ziti">
                联系方式:
                <input placeholder="手机号" class="layui-input x-input" type="text" name="consultPhone">
            </label>
            <label class="ziti">
                咨询内容:
                <input class="layui-input x-input" type="text" name="consultText">
            </label>
            <button class="layui-btn layui-btn-primary x-btn" type="submit">搜索</button>
        </div>
        </form>
    </header>
    <footer>
        <div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>咨询内容</th>
                    <th>咨询时间</th>
                    <th>联系方式</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list consult.list as consult>
                <tr>
                    <td>${consult.consultName}</td>
                    <td>${consult.consultText}</td>
                    <td>${consult.consultTime}</td>
                    <td>${consult.consultPhone}</td>
                    <td>
                        <a href="" class="caozuo">编辑</a>
                        <a href="" class="caozuo">删除</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div id="page" class="fenye"></div>
        </div>
    </footer>
</div>
<script src="../static/layui/layui.js"></script>

<script>
    layui.use(['laypage','layer'],function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page'
            ,count: 100
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj){
            }
        });
    })

</script>
</body>
</html>


