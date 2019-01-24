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
        <form method="post" action="queryAllClauseController">
            <div class="layui-form content">
                <label class="ziti">法&nbsp;&nbsp;&nbsp;规:</label>
                <div class="layui-input-inline x-select">
                    <select name="lawsId.lawsId" id="lawsId">
                        <option value="kong">请选择</option>
                    <#list laws.list as laws>
                    <option value="${laws.lawsId}">${laws.lawsId}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="content">
                <label class="ziti">
                    条款号:
                    <input class="layui-input x-input" type="text" id="clauseNumber" name="clauseNumber">
                    <input type="hidden" name="pageSize" value="${clausePage.pageSize}" id="b">
                    <input type="hidden" name="pageNumber" value="${clausePage.pageNum}" id="a">
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
                    <B></B> <td>${clause.clauseText}</td>
                    <td>${clause.clauseVersions}</td>
                    <td>
                        <a href="toUpdateClause?clauseId=${clause.clauseId}" class="caozuo">编辑</a>
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
        var clauseNumber="${c.getClauseNumber()}";
        var clauseKeyword="${c.getClauseKeyword()}";
        var lawsId="${c.getLawsId().getLawsId()}";
        if(clauseNumber!=0){
            $("#clauseNumber").val(clauseNumber);
        }
        if(clauseKeyword!=null&&clauseKeyword!=" "){
            $("#clauseKeyword").val(clauseKeyword);
        }
        if(lawsId!=null&&lawsId!=" "&&lawsId!="kong"){
            $("#lawsId").attr("value",lawsId);
        }
        $("#mohu").click(function () {
            $("#a").val(1);
            var clauseNumber=$.trim($("#clauseNumber").val());
            var regPos = /^\d+(\.\d+)?$/; //非负浮点数
            var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
            if(clauseNumber!=null&&clauseNumber!="") {
                if (regPos.test(clauseNumber) || regNeg.test(clauseNumber)) {
                    $("form").attr("action",queryAllClauseController);
                    $("form").submit();
                } else {
                    alert("请输入有效数字");
                    return false;
                }
            }
            $("#clauseNumber").val(0);
            $("form").submit();
        })
    });
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
                    $("#a").val(obj.curr);
                    $("#b").val(obj.limit)
                    // window.location.href="queryAllClauseController?lawsId="+lawsId+"&clauseNumber"+clauseNumber+"&clauseKeyword"+clauseKeyword+"&pageNumber="+obj.curr+"&pageSize="+obj.limit;
                    var clauseNumber=$.trim($("#clauseNumber").val());
                    var regPos = /^\d+(\.\d+)?$/; //非负浮点数
                    var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
                    if(clauseNumber!=null&&clauseNumber!="") {
                        if (regPos.test(clauseNumber) || regNeg.test(clauseNumber)) {
                            $("form").submit();
                        } else {
                            alert("请输入有效数字");
                            return false;
                        }
                    }
                    $("#clauseNumber").val(0);
                    $("form").submit();
                }
            }
        });
    })
</script>
</body>
</html>


