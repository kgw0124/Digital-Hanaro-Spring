<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<!-- 배포 시, css 파일 탐색 오류 방지를 위해 아래와 같이 경로를 설정해주어야 한다. : 반드시 위에 taglib 작성해야 한다. -->
	<link href="<c:url value="/css/main.css" />" rel="stylesheet">
</head>
<body>
<header>
	<h1>Main Page</h1>
	<ul>
		<li><a href="<c:url value="/" />">MAIN</a></li>
		<li><a href="<c:url value="/login" />">LOGIN</a></li>
		<li><a href="<c:url value="/register" />">REGISTER</a></li>
		<li><a href="<c:url value="/cust/add" />">CUST ADD</a></li>
		<li><a href="<c:url value="/cust/get" />">CUST GET</a></li>
		<li><a href="<c:url value="/item/add" />">ITEM ADD</a></li>
		<li><a href="<c:url value="/item/get" />">ITEM GET</a></li>
	</ul>	
</header>
<section>
	<c:choose>
		<c:when test="${centerpage == null }">
		   <jsp:include page="center.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
		   <jsp:include page="${centerpage}.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
</section>
<footer></footer>
</body>
</html>






