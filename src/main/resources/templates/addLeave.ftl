<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title></title>

</head>
<body>
//用户  意见内容
<h1>意见反馈你</h1>
<form method="post" action="/doAddLeaveController">
    <table>
        <tr>
            <td>
                <input type="hidden" value="1">
                <input type="text" name="leaveText">
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


