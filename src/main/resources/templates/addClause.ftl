<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Include external CSS. -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.css">

    <!-- Include Editor style. -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/css/froala_editor.pkgd.min.css" rel="stylesheet" type="text/css" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/css/froala_style.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="static/layui/css/layui.css">
    <link rel="stylesheet" href="static/css/Xq.css">
    <script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $('#froala-editor').froalaEditor({
                language: 'zh_cn',
                dragInline: true,
                toolbarButtons: ['bold', 'italic', 'underline', 'insertImage', 'insertLink', 'undo', 'redo'],
                height:300
             })
        });
    </script>
</head>
<body>
<div class="overall">
    <header>
        <div class="daohang">法规管理 / 新增条款</div>
        <div class="title">新增条款</div>
    </header>
    <footer>
        <div>
            <form method="post" action="doAddClauseController">
            <table class="biaodan" cellspacing="10px">
                <tr>
                    <td style="width: 300px;">*法规:</td>
                    <td class="layui-form">
                        <div class="layui-input-inline x-select">
                            <select name="lawsId.lawsId" lay-filter="tests" id="ajaxClause">
                                <option value="请选择">请选择</option>
                                <#list llist.list as laws>
                                    <option value="${laws.lawsId}">${laws.lawsId}</option>
                                </#list>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*所在目录:</td>
                    <td class="layui-form">
                        <div class="layui-input-inline x-select">
                            <select name="catalog.catalogId" id="mulu" lay-filter="mulu">
                                <option value="请选择">请选择</option>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*条款编号:</td>
                    <td><input class="layui-input x-input" type="text" name="clauseNumber"></td>
                </tr>
                <tr>
                    <td>*条款编号别名:</td>
                    <td><input class="layui-input x-input" type="text" name="clauseName"></td>
                </tr>
                <tr>
                    <td>条款版本号:</td>
                    <td><input class="layui-input x-input" type="text" name="clauseVersions"></td>
                </tr>
                <tr>
                    <td>*条款标题:</td>
                    <td><input class="layui-input x-input" type="text" name="clauseTitle"></td>
                </tr>
                <tr>
                    <td>*条款内容:</td>
                    <td>
                        <#--<div id="froala-editor" style="width: 500px;" name="clauseText" contentEditable="true" >-->
                        <#--</div>-->
                        <textarea id="froala-editor" name="clauseText" ></textarea>
                    </td>
                </tr>
                <tr>
                    <td>关键词:</td>
                    <td><input class="layui-input x-input" type="text" name="clauseKeyword"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <button class="layui-btn layui-btn-primary x-btn" style="margin-top: 20px;" type="submit" id="save">保存</button>
                        <button class="layui-btn layui-btn-primary x-btn" style="margin-top: 20px;">复制条款</button>
                    </td>
                </tr>
            </table>
        </form>
        </div>
    </footer>
</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/mode/xml/xml.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/js/froala_editor.pkgd.min.js"></script>
<script src="static/js/zh_cn.js"></script>
<script src="static/layui/layui.js"></script>

<script>

    layui.use('form',function () {
        var form = layui.form;
        form.on('select(tests)',function(data){
            var cataLaws=$("select").val();
            console.log(data)
            $.post("ajaxClause",{"cataLaws":cataLaws},function(returnData,status){
                if ("success"==status) {
                    var result = "<option value='0'>--请选择--</option>";
                    for(var i = 0;i<returnData.length;i++){
                        result += "<option value='"+returnData[i].catalogId+"'>"+
                                returnData[i].cateText+"</option>";
                    }
                    $("#mulu").html(result);
                    form.render('select');
                }
            },"json");

        })
    })
</script>

</body>
</html>