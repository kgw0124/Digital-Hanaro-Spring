<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jstl 사용 : if문/for문/c:url 등을 구현 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-pills flex-column">
    <p>Ajax</p>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/ajax/ajax1"/> ">Ajax1</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/ajax/ajax2"/> ">Ajax2</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/ajax/ajax3"/> ">Ajax3</a>
    </li>
</ul>