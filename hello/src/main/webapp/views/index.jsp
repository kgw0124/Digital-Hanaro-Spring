<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello</h1>
<h2>${data}</h2>
<c: forEach var="s" items="${datas}">
    <h3>${s}</h3>
</c:>
</body>
</html>
