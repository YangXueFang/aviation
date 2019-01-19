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
        <div class="daohang">法规管理 / 法规列表</div>
        <div class="title">法规列表</div>
        <form method="post" action="/queryAllLawsController">
        <div class="content">

            <label class="ziti">
                *法规编号:
                <input class="layui-input x-input" type="text" name="lawsPart"/>
            </label>
            <label class="ziti">
                *法规名称:
                <input class="layui-input x-input" type="text" name="lawsName">
            </label>
            <button class="layui-btn layui-btn-primary x-btn" type="submit">搜索</button>
        </div>
        </form>
    </header>
    <footer>
        <div>
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" style="float: right;" onclick="location.href='toAddLawsController'">新增法规</button>
            </div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>部号</th>
                    <th>法规部号别名</th>
                    <th>版本号</th>
                    <th>法规名称</th>
                    <th>前台显示</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list laws.list as laws>
                <tr>
                    <td>${laws.lawsPart}</td>
                    <td>${laws.lawsId}</td>
                    <td>${laws.lawsVersion}</td>
                    <td>${laws.lawsName}</td>
                    <td>${laws.lawsStauts}</td>
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
        var total=${laws.total};

        laypage.render({
            elem: 'page'
            ,count: total
            ,curr:${laws.pageNum}
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj,first){
                if (!first){
                    // JSON.stringify(obj);
                    window.location="queryAllLawsController?PageNumber="+obj.curr;
                }
            }
        });
    })
</script>
</body>
</html>


