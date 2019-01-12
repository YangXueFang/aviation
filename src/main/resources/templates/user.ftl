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
        <div class="daohang">用户管理 / 用户列表</div>
        <div class="title">用户列表</div>
        <div class="content">
            <label class="ziti">
                手机号:
                <input placeholder="手机号" class="layui-input x-input" type="text">
            </label>
            <button class="layui-btn layui-btn-primary x-btn">搜索</button>
        </div>
    </header>
    <footer>
        <div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>手机号</th>
                    <th>会员类型</th>
                    <th>注册日期</th>
                </tr>
                </thead>

                <tbody>
                <#list user.list as user>
                <tr>
                    <td>${user.userPhone}</td>
                    <td class="layui-form">
                        <div class="layui-input-block" style="margin-left: 0px">
                          <#if (user.userType)==0>
                            <input type="radio" name="w" value="0" title="免费" checked>
                            <#elseif (user.userType)==1>
                            <input type="radio" name="w" value="1" title="付费" checked>
                            </#if>
                        </div>
                    </td>
                    <td>${user.userDate}</td>
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
    layui.use('form',function () {
        var form = layui.form;
    })
    layui.use(['laypage','layer'],function () {/.
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


