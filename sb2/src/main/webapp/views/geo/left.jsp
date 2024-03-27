<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jstl 사용 : if문/for문/c:url 등을 구현 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-pills flex-column">
    <p>Geo</p>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/geo/geo1"/> ">Geo1</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/geo/geo2"/> ">Geo2</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/geo/geo3"/> ">Geo3</a>
    </li>
</ul>