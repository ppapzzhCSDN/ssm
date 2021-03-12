<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/css/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/bootstrap3/css/bootstrap.css"/>
<script type="text/javascript" src="/js/vue.js"></script>
<script type="text/javascript" src="/js/axios.js"></script>
<html>
<head>
    <title class="btn btn-success">添加</title>
</head>
<body>
<form action="/user/add" method="get">
    姓名：<input type="text" name="name" value=""><br><br>
    密码：<input type="text" name="password" value=""><br><br>
    年龄：<input type="text" name="age" value=""><br><br>
    性别：<select name="sex">
    <option value="1">男</option>
    <option value="0">女</option>
        </select><br/>
    <input type="submit" value="保存" class="btn btn-primary">
</form>
</body>
</html>
