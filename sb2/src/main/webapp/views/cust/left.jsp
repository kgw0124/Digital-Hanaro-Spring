<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jstl 사용 : if문/for문/c:url 등을 구현 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-pills flex-column">
    <p>Cust</p>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/cust/add"/>">Add</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/cust/get"/>">Get</a>
    </li>
</ul>