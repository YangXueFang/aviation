<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title></title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <link rel="stylesheet" href="../static/css/Xq.css">
    <script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>

</head>
<body>

<div class="overall">
    <header>
        <div class="daohang">设置 / 管理员管理</div>
        <div class="title">管理员管理</div>
        <form method="post" action="addAdminController">
        <div class="content">
            <label class="ziti">
                *管理员姓名:
                <input placeholder="不超过100个字" style="width: 140px;" class="layui-input x-input" type="text" name="adminName">
            </label>
            <label class="ziti">
                *手机号:
                <input placeholder="请输入手机号" style="width: 140px;" class="layui-input x-input" type="text" name="adminPhone">
            </label>
            <label class="ziti">
                *密码:
                <input placeholder="6-20位字符" style="width: 140px;" class="layui-input x-input" type="text" name="adminPassword">
            </label>
            <button class="layui-btn layui-btn-primary x-btn" type="submit">新增管理员</button>
        </div>
        </form>
    </header>
    <footer>
        <div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>管理员手机号</th>
                    <th>管理员姓名</th>
                    <th>添加日期</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list admin as admin>
                <tr>
                    <td>${admin.adminPhone}</td>
                    <td>${admin.adminName}</td>
                    <td>${admin.adminTime}</td>
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
<script src="./layui/layui.js"></script>
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


