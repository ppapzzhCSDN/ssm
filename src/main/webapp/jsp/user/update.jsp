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
    <title class="btn btn-success">更新</title>
</head>
<body>
<form action="/user/update" method="get">
    id:${abc.id}<br/>
    <input type="text" name="id" value="${abc.id}" style="display: none">
    姓名：<input type="text" name="name" value="${abc.name}"><br><br>
    年龄：<input type="text" name="age" value="${abc.age}"><br><br>
    性别：<input type="radio" name="sex" value="1" <c:if test="${sex==1}"> checked </c:if>/>男
    <input type="radio" name="sex" value="0" <c:if test="${sex==0}"> checked </c:if>/>女
    <input type="submit" value="保存" class="btn btn-primary">

</form>
</body>
</html>
