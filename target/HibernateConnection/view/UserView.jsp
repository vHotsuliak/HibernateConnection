<%--
  Created by IntelliJ IDEA.
  User: Vasyl
  Date: 19.08.2018
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Hibernate connection</title>
</head>
<body>
<table border="2px">
    <tr>
        <th>User name</th>
    </tr>
    <%--@elvariable id="users" type="java.util.List"--%>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user}</td>
    </tr>
    </c:forEach>
</body>
</html>
