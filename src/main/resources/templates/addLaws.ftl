<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title></title>
    <!-- Include external CSS. -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.css">

    <!-- Include Editor style. -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/css/froala_editor.pkgd.min.css" rel="stylesheet" type="text/css" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/css/froala_style.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <link rel="stylesheet" href="../static/css/Xq.css">
</head>
<body>
<div class="overall">
    <header>
        <div class="daohang">法规管理 / 新增法规</div>
        <div class="title">新增法规</div>
    </header>
    <footer>

        <div>
            <form action="doAddLawsController" method="post">
            <table class="biaodan" cellspacing="10px">
                <tr>
                    <td style="width: 300px;">*法规部号:</td>
                    <td><input class="layui-input x-input" type="text" name="lawsPart"></td>
                </tr>
                <tr>
                    <td>法规号别名:</td>
                    <td><input class="layui-input x-input" type="text" name="lawsId"></td>
                </tr>
                <tr>
                    <td>法规版本号:</td>
                    <td><input class="layui-input x-input" type="text" name="lawsVersion"></td>
                </tr>
                <tr>
                    <td>*法规名称:</td>
                    <td><input class="layui-input x-input" type="text" name="lawsName"></td>
                </tr>
                <tr>
                    <td>*是否显示:</td>
                    <td class="layui-form">
                        <div class="layui-input-block" style="margin-left: 0px">
                            <input type="radio" name="lawsStauts" value="0" title="显示">
                            <input type="radio" name="lawsStauts" value="1" title="不显示">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*首页法规图标:</td>
                    <td style="position: relative;width: 400px;">
                        <div class="layui-upload-drag" id="shangchuan">
                            <i class="layui-icon"></i>
                            <p>点击上传，或将文件拖拽到此处</p>
                        </div>
                        <div style="position: absolute;left:300px;bottom: 0;">
                            <p>图片格式支持：jpg/png，</p>

                            <p>图片尺寸：90*90px</p>

                            <p>图片大小：不超过50K</p>
                        </div>
                        <input type="hidden" value="" name="lawsLogo" id="file_base64">
                    </td>
                    <#--<td style="position: relative;width: 400px;">-->
                        <#--<div class="layui-upload-drag" id="shangchuan">-->
                            <#--<i class="layui-icon"></i>-->
                            <#--<p>点击上传，或将文件拖拽到此处</p>-->
                        <#--</div>-->

                        <#--&lt;#&ndash;这里要换成file&ndash;&gt;-->
                        <#--<input type="text" name="lawsLogo"/>-->


                        <#--<div style="position: absolute;left:300px;bottom: 0;">-->
                            <#--<p>图片格式支持：jpg/png，</p>-->

                            <#--<p>图片尺寸：90*90px</p>\-->

                            <#--<p>图片大小：不超过50K</p>-->
                        <#--</div>-->
                    <#--</td>-->
                </tr>
                <tr>
                    <td>法定PDF文件名称:</td>
                    <td><input class="layui-input x-input" type="text" name="lawsFDBName"></td>
                </tr>
                <tr>
                    <td>法规PDF文件下载链接:</td>
                    <td><input class="layui-input x-input" type="text" name="lawsDownload"></td>
                </tr>
                <tr>
                <td style="vertical-align: top;">*法规版本说明:</td>
                <td>
                    <#--<div id="froala-editor" style="width: 500px;">-->
                        <textarea id="froala-editor" name="lawsState" hidden></textarea>
                <#--</div>-->


                    <button class="layui-btn layui-btn-primary x-btn" style="margin-top: 20px;" type="submit">保存</button>
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
<script type="text/javascript" src="../static/js/zh_cn.js" ></script>
<script src="../static/layui/layui.js"></script>
<script>
    $(function() {
        $('#froala-editor').froalaEditor({
            language: 'zh_cn',
            dragInline: true,
            toolbarButtons: ['bold', 'italic', 'underline', 'insertImage', 'undo', 'redo'],
            height:300,
            placeholderText: '请输入内容',


        })
    });
    layui.use('form', function(){
        var form = layui.form;

    });
    layui.use('upload',function () {
        var $ = layui.jquery
                ,upload = layui.upload;
        upload.render({
            elem: '#shangchuan'
            ,url: '/upload/'
            ,done: function(res){
                console.log(res)
            }
        });
    });


    $(function () {
        layui.use('upload',function () {
            var $ = layui.jquery
                    ,upload = layui.upload;
            upload.render({
                elem: '#shangchuan'
                , url: '/'
                , auto: false //选择文件后不自动上传
                , bindAction: '#testListAction'
                , done: function (res) {
                    console.log(res); //得到文件base64编码，比如图片
                }
                , choose: function (obj) {
                    //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
                    obj.preview(function (index, file, result) {
                        $('#file_base64').val(result);
                    });
                }
            });
        })
    });

</script>

</body>
</html>


