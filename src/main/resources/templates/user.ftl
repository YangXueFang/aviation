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
        <form method="post">
            <div class="content">
                <label class="ziti">
                    手机号:${phone}
                    <input type="hidden" name="" value="${phone}" id="phone">
                    <input placeholder="手机号" class="layui-input x-input" type="text" name="userPhone" id="userPhone">
                </label>
                <button class="layui-btn layui-btn-primary x-btn" id="mohu">搜索</button>
            </div>
        </form>
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
                            <input type="radio" name="${user.userId}" value="0" title="免费" <#if (user.userType)==0>checked</#if>>
                            <input type="radio" name="${user.userId}" value="1" title="付费" <#if (user.userType)==1>checked</#if>>
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
<script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function(){
        var userPhone=$("#userPhone").val();//文本值
        var phone=parseInt($("#phone").val());//隐藏域值
        if(phone!=null && phone!=1){
            $("#userPhone").val(phone);
        }else{
            $("#userPhone").val("");
        }
        $("#mohu").click(function () {
            $("form").attr("action",listUserController);
            $("form").submit();
        })
    });
</script>
<script>
    var a="${user.pageNum}";
    var b="${user.pageSize}";
    var c="${user.getTotal()}"
    layui.use('form',function () {
        var form = layui.form;
    })
    layui.use(['laypage','layer'],function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page'
            ,count: c
            ,curr:  a //获取起始页
            ,hash: 'fenye'
            ,limit: b
            ,limits: [10, 20, 30 ,50 ,100]
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj,first){
                if(!first){
                    var phone=parseInt($("#phone").val());
                    window.location.href="listUserController?userPhone="+phone+"&pageNumber="+obj.curr+"&pageSize="+obj.limit;
                }
            }
        });
    })
</script>
</body>
</html>


