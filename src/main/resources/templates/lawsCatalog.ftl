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
        <div class="daohang">法规管理 / 法规目录管理</div>
        <div class="title">法规目录管理</div>
    </header>
    <footer>
        <div>
            <div class="layui-form" style="position: relative;margin: 50px 0px 30px 0px;">
                <label class="layui-form-label">选择法规：</label>
                <form method="post" action="/cataLogListController">
                    <input type="text" name="pageSize" value="${catalog.pageRecorders}" id="b">
                    <input type="text" name="pageNumber" value="${catalog.page}" id="a">
                <div class="layui-input-inline">
                    <select name="cataLaws">

                        <#list llist.list as laws>
                        <option value="${laws.lawsId}">${laws.lawsId}</option>
                        </#list>
                    </select>
                </div>
                <button class="layui-btn-primary x-btn-sm" style="margin-left: 50px;" type="submit">确定</button>
                </form>
                <button class="layui-btn layui-btn-normal" style="position: absolute;right: 0;bottom: 1px;" onclick="location.href='cataLogAddController'">新增目录</button>
            </div>

            <table class="layui-table" style="word-break:break-all; word-wrap: break-word">
                <thead>
                <tr>
                    <th>目录名称</th>
                    <th>排序</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list catalog.list  as cataLog>
                <tr>
                    <td>${cataLog.cateText}</td>
                    <td>${cataLog.cateNumber}</td>
                    <td>
                        <a href="toUpdate?catalogId=${cataLog.catalogId}" class="caozuo">编辑</a>
                        <a href="" class="caozuo" onclick="shan();">删除</a>
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
    var a="${catalog.getTotalRows()}";
    var b="${catalog.getPage()}";
    var c="${catalog.getPageRecorders()}";
    alert(a)
    alert(b)
    alert(c)

    layui.use('form',function () {
        var form = layui.form;
    })
    function shan() {
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            <#--window.location.href="cataLogDeleteController?catalogId="+${cataLog.catalogId};-->
        }, function(){
            layer.close(layer.index);
        });
    }
    layui.use(['laypage','layer'],function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page'
            ,count: a
            ,curr:  b //获取起始页
            ,hash: 'fenye'
            ,limit: c
            ,limits: [10, 20, 30 ,50 ,100]
            <#--,next:${catalog.isHasNextPage()}-->
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj,first){
                //console.log(000)
                // $("#a").val(obj.curr);
                // $("#b").val(obj.limit)
                //alert(first)
               if(!first){
                   window.location.href="cataLogListController?pageNumber="+obj.curr+"&pageSize="+obj.limit;

                    //console.log(obj)
                    //console.log(obj.curr);
                   // console.log(obj.limit);
                    //$("form").submit();

                }
            }
        });
    })
</script>
</body>
</html>


