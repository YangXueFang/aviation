<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title></title>

</head>
<body>

//姓名 手机号  相关条款编号  问题描述
<form method="post" action="/doAddConsultController">
    <table>
        <tr>
            <th>姓名</th>
            <td>
                <input type="hidden" name="user" value="1">
                <input type="text" name="consultName" id="consultName">
            </td>
        </tr>
        <tr>
            <th>手机号</th>
            <td>
                <input type="text" name="consultPhone" id="consultPhone">
            </td>
        </tr>
        <tr>
            <th>相关条款编号</th>
            <td>
                <input type="text" name="consultClause" id="consultClause">
            </td>
        </tr>
        <tr>
            <th>问题描述</th>
            <td>
                <input type="text" name="consultText" id="consultText">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>


