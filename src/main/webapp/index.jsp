<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script type="text/javascript" src="./js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="./css/bootstrap3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap3/css/bootstrap.css"/>
    <script type="text/javascript" src="./js/vue.js"></script>
    <script type="text/javascript" src="./js/axios.js"></script>
</head>
<body>
<form action="/login/login" method="post">
    姓名：<input type="text" name="name" value="" class="btn-primary"><br><br>
    密码：<input type="text" name="password" value="" class=" btn-primary"><br><br>
    <img id="img" src="/pic/getCode" alt="加载中..." onclick="change()">
    验证码：<input type="text" name="code" value=""><br><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
<script>
    function change() {
        $("#img").attr("src", $("#img").attr("src") + "?nocache=" + new Date().getTime());
    }

</script>