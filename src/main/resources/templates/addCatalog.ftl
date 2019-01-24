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
        <div class="daohang">法规管理 / 新增目录</div>
        <div class="title">新增目录</div>
    </header>
    <footer>

        <div>
            <form method="post" action="/cataLogDoAddController">
            <table class="biaodan" style="border-collapse:separate; border-spacing:0px 50px;" >
                <tr>
                    <td style="width: 300px;">*目录名称:</td>
                    <td><input class="layui-input x-input" type="text" name="cateText"></td>
                </tr>
                <tr>
                    <td>统计目录排序:</td>
                    <td><input class="layui-input x-input" type="text" name="cateNumber"></td>
                </tr>
                <tr>
                    <td>选择所属法规:</td>
                    <td class="layui-form">
                        <div class="layui-input-inline x-select">
                            <select name="cataLaws" lay-filter="tests" id="ajaxLaws">
                                <option value="请选择">请选择</option>
                                <#list llist.list as laws>
                                    <option value="${laws.lawsId}">${laws.lawsId}</option>
                                </#list>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*选择父级目录:</td>
                    <td class="layui-form">
                        <div class="layui-input-inline x-select">
                            <select name="cateRank" id="fulei" lay-filter="fuji">
                                <option value="请选择">请选择</option>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <button class="layui-btn-primary x-btn-sm" type="submit">新增目录</button>
                    </td>
                </tr>
            </table>
        </form>
        </div>

    </footer>
</div>
<script src="../static/layui/lay/modules/jquery-3.3.1.min.js"></script>
<script src="../static/layui/layui.js"></script>
<script src="../static/layui/layui.all.js"></script>
<script src="../static/layui/layui.js"></script>
<script>
    //Demo
    layui.use('form', function() {
        var form = layui.form;
        form.on('select(tests)',function(data){
           var cataLaws=$("select").val();
           console.log(data)
            $.post("ajax",{"cataLaws":cataLaws},function(returnData,status){
                if ("success"==status) {
                    var result = "<option value='0'>--请选择--</option>";
                    for(var i = 0;i<returnData.length;i++){
                        result += "<option value='"+returnData[i].catalogId+"'>"+
                                returnData[i].cateText+"</option>";
                    }
                    $("#fulei").html(result);
                    form.render('select');
                }
            },"json");

        })
    })
</script>

</body>
</html>


