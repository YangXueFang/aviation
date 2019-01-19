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
        <div class="daohang">法规管理 / 条款列表</div>
        <div class="title">条款列表</div>
        <form method="post">
            <div class="layui-form content">
                <label class="ziti">法&nbsp;&nbsp;&nbsp;规:</label>
                <div class="layui-input-inline x-select">
                    <select name="lawsId.lawsId" id="lawsId">
                        <option value="kong">请选择</option>
                    <#list clausePage.list as laws>
                    <option value="${laws.lawsId.lawsId}">${laws.lawsId.lawsId}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="content">
                <label class="ziti">
                    条款号:
                    <input class="layui-input x-input" type="text" id="clauseNumber" name="clauseNumber">
                </label>
                <label class="ziti">
                    关键词:
                    <input class="layui-input x-input" type="text" id="clauseKeyword" name="clauseKeyword">
                </label>
                <button class="layui-btn layui-btn-primary x-btn" id="mohu">搜索</button>
            </div>
        </form>
    </header>
    <footer>
        <div>
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" style="float: right;">新增法规</button>
            </div>
            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>条款号</th>
                    <th>条款号别名</th>
                    <th>条款标题</th>
                    <th>所属法规名称</th>
                    <th>版本号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list clausePage.list as clause>
                <tr>
                    <td>${clause.clauseNumber}</td>
                    <td>${clause.clauseName}</td>
                    <td>${clause.clauseTitle}</td>
                    <td>${clause.clauseText}</td>
                    <td>${clause.clauseVersions}</td>
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
<script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#mohu").click(function () {
            var clauseNumber=$("#clauseNumber").val();
            var regPos = /^\d+(\.\d+)?$/; //非负浮点数
            var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
            alert(clauseNumber+"++++++>clauseNumber")
            if(regPos.test(clauseNumber) || regNeg.test(clauseNumber)){
                alert(1)
                // $("form").attr("action",queryAllClauseController);
                // $("form").submit();
            }else{
                alert("请输入有效数字");
            }
        })
    });
</script>
<script>
    layui.use('form', function(){
        var form = layui.form;

    });
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
<script>
    var a="${clausePage.pageNum}";
    var b="${clausePage.pageSize}";
    var c="${clausePage.getTotal()}"
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
                    var lawsId=$("#lawsId").val();
                    var clauseNumber=parseInt($("#clauseNumber").val());
                    var clauseKeyword=$("#clauseKeyword").val();
                    // window.location.href="queryAllClauseController?lawsId="+lawsId+"&clauseNumber"+clauseNumber+"&clauseKeyword"+clauseKeyword+"&pageNumber="+obj.curr+"&pageSize="+obj.limit;
                }
            }
        });
    })
</script>
</body>
</html>


