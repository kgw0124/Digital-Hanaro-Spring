<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>묻고답하기</title>

    <!-- Main CSS : Header, Main, Footer -->
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/customer/customer02.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!-- Bootstarp JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

    <script>
        var search = function (){
            let searchOption = $('select[name=searchOption]').val();
            let searchInput = $('#searchInput').val();

            console.log(searchOption + " : " + searchInput);

            $.ajax({
                url: '<c:url value="/customer/qna/search"/>',
                data:{
                    'option':searchOption,
                    'input':searchInput
                },
                success: function(data) {
                    console.log(data);

                    $('.qna table').empty();

                    var row = '<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>';
                    $('.qna table').append(row);

                    $.each(data, function(index, item) {
                        var row = '<tr>' +
                            '<td><a href="#" onclick="openWindow(' + item.qnaIdx + ')">' + item.qnaIdx + '</a></td>' +
                            '<td><a href="#" onclick="openWindow(' + item.qnaIdx + ')">' + item.qnaTitle + '</a></td>' +
                            '<td><a href="#" onclick="openWindow(' + item.qnaIdx + ')">' + item.qnaName + '</a></td>' +
                            '<td><a href="#" onclick="openWindow(' + item.qnaIdx + ')">' + item.qnaDate + '</a></td>' +
                            '</tr>';
                        $('.qna table').append(row);
                    });
                }
            })
        }

        var openWindow = function(no){
            console.log("no : " + no);
            window.open('<c:url value="/customer/qnaPw"/>?no=' + no, '비밀번호확인', 'width=430,height=300,location=no,status=no,scrollbars=no');
        }
    </script>
</head>
<body>
<!-- 메인 -->
<!-- 1:1문의 -->
<!-- COMMON -->
<div class="commonSection1">
    <div class="commonContent1">
        <img src="../img/member/sub-visual02.jpg"
             style="width: 100%; height: 100%;">
        <div class="commonContent2 text-center">
            <div>
                <h3>COSTOMER</h3>
            </div>
            <div>
                <p><img src="../img/icon-home.png"> > 고객지원 > 묻고답하기</p>
            </div>
        </div>
    </div>
</div>
<!-- COMMON - 드랍다운 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="../index.html"><button class="homeBtn">H</button></a>
    <ul class="navbar-nav mr-auto navbar-nav-scroll"
        style="max-height: 100px;">

        <li class="nav-item dropdown dropdownHide">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button"
               data-toggle="dropdown" aria-expanded="false">
                고객지원
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                <li><a class="dropdown-item" href="#">회사소개</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">사업분야</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">제품안내</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">커뮤니티</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">고객지원</a></li>
            </ul>
        </li>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown"
               role="button" data-toggle="dropdown" aria-expanded="false">
                묻고답하기
            </a>
            <ul class="dropdown-menu asd">
                <li><a class="dropdown-item" href="../customer/costomer01.html">1:1문의</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="../customer/costomer02.html">묻고답하기</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="../customer/costomer03.html">FAQ</a></li>
            </ul>
        </li>
    </ul>
    </div>
</nav>

<!-- 묻고답하기 -->
<div class="communitySection2 container text-center">
    <div>
        <div>묻고답하기</div>
        <div>The design and maintenance are excellent.</div>
    </div>
    <div class="qna">
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>

            <c:forEach var="q" items="${questions}">
                <tr>
                    <td><a href="#" onclick="openWindow(${q.qnaIdx})">${q.qnaIdx}</a></td>
                    <td><a href="#" onclick="openWindow(${q.qnaIdx})">${q.qnaTitle}</a></td>
                    <td><a href="#" onclick="openWindow(${q.qnaIdx})">${q.qnaName}</a></td>
                    <td><a href="#" onclick="openWindow(${q.qnaIdx})">${q.qnaDate}</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<!-- search bar -->
<div class="search container">
    <div>
        <img onclick="window.location.href='customer02_2.html'"
             src="../img/customer/write.gif">
    </div>
    <table>
        <tr>
            <td>
                <select id="searchOption" name="searchOption">
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                    <option value="writer">작성자</option>
                </select>
            </td>
            <td>
                <input type="text" id="searchInput">
            </td>
            <td>
                <input type="image" src="../img/customer/search.gif" onclick="search()">
            </td>
        </tr>
    </table>
</div>
</body>
</html>