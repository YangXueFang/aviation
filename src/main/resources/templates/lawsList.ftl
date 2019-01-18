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
                <button class="layui-btn layui-btn-normal" style="float: right;">新增法规</button>
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
            <div class="row" >
                <div class="col-sm-5">
                    <div class="dataTables_info" id="page_info" role="status" aria-live="polite" style="margin-top: 20px;margin-left: 10px">
                    <#--当前 1/10，共10页-->
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="dataTables_paginate paging_simple_numbers" id="example1_paginate" style="text-align: right;margin-right: 10px">
                    <#-- jqPaginator分页 -->
                        <ul class="pagination" id="pagination1"></ul>
                    </div>
                </div>

            </div>
        </div>
    </footer>
</div>
<script src="../static/layui/layui.js"></script>
<#-- jqPaginator分页 begin -->
<script type="text/javascript" src="/jqPaginator/js/jqPaginator.js"></script>
<#-- jqPaginator分页 end -->
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
<script type="text/javascript">
    $("#addCustomer").click(function () {
        window.location.href("toAddCustomer.controller");
    })
    // 设置分页信息
    var PageNumber = #{UserCustomer.pageNo};
    var pages =#{UserCustomer.pages};
    var total = #{UserCustomer.total};

    $('#page_info').html("当前 {0}/{1}页，共{2}条".format(PageNumber, pages, total));


    $('#pagination1').jqPaginator({
        totalPages: pages,
        visiblePages: 10,
        currentPage: PageNumber,
        onPageChange: function (num, type) {
            if (PageNumber != num) {
//                var projectState = $("#searchProjectState").val();
//                var searchKey = $("#searchKey").val();
                var url = "/page/admin/customerList?pageNo={0}".format(num);
                window.location.href = url;
            } else {
            }
        }
    });
</script>
</body>
</html>


