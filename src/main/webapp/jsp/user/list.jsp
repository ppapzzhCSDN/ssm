<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script type="text/javascript" src="../../js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../../css/bootstrap3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap3/css/bootstrap.css"/>
    <script type="text/javascript" src="../../js/axios.js"></script>
</head>
<body>
<form action="/user/listAll" method="get">
    姓名：<input type="text" name="name" value="${userQo.name}">
    <input type="submit" value="查询" class="btn btn-primary">&nbsp;&nbsp;
    性别：
    <select name="sex">
        <option value="-1"
                <c:if test="${userQo.sex=='-1' }">selected</c:if> >请选择
        </option>
        <option value="1"
                <c:if test="${userQo.sex==1}">selected</c:if> >男
        </option>
        <option value="0"
                <c:if test="${userQo.sex==0}">selected</c:if> >女
        </option>
    </select>
    <input type="submit" value="查询" class="btn btn-primary">
</form>
<hr/>
<a href="/user/toAdd" class="btn btn-success">添加</a><br>
<table class="table table-bordered">
    <tr>
        <td>序号</td>
        <td>id</td>
        <td>姓名</td>
        <td>密码</td>
        <td>年龄</td>
        <td>性别</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>

    <c:forEach var="user" items="${list}" varStatus="status">

        <tr>
            <td>${status.count}</td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>
                <c:choose>
                    <c:when test="${user.sex==1}">男</c:when>
                    <c:when test="${user.sex==0}">女</c:when>
                    <c:otherwise>人妖</c:otherwise>
                </c:choose>
            </td>
            <td>
                    <%--<fmt:parseDate>--%>
                    <%--<fmt:formatDate value=""></fmt:formatDate>--%>
                    <%--</fmt:parseDate>--%>
                    ${user.createTime}</td>
            <td>
                <a href="/user/toUpdate?id=${user.id}" class="btn btn-primary">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/user/delete?id=${user.id}" class="btn btn-danger">删除</a>
            </td>
            >
        </tr>
    </c:forEach>
</table>

当前页：${userQo.page},总页数：${userQo.pageTotal},总记录数：${userQo.count}
<a href="/user/listAll?page=${userQo.page-1}&name=${userQo.name}">上一页</a>
<a href="/user/listAll?page=${userQo.page+1}&name=${userQo.name}">下一页</a>
<%--<a href="/user/listAll?page=${userQo.page>=userQo.pageTotal?userQo.pageTotal:userQo.page+1}">下一页</a>--%>
</body>
</html>
