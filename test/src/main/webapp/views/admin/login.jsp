<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>회사홈페이지</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="stylesheet" href="/css/main.css" />
    <link rel="stylesheet" href="/css/common.css" />

    <!-- Bootstrap CSS -->
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
            integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
            crossorigin="anonymous"
    />
    <!-- Bootstarp JS -->
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"
    ></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"
    ></script>

    <script>
        var login = function(){
            let id = $('#loginID').val();
            let pw = $('#loginPW').val();

            $.ajax({
                url: '<c:url value="/admin/login"/>',
                data:{
                    'id':id,
                    'pw':pw
                },
                success:(result)=>{
                    switch (result){
                        case '0':
                            alert("로그인되었습니다.");
                            window.location.href = "<c:url value="/admin/member"/>";
                            return;
                        case '1':
                            alert("id가 존재하지 않습니다.");
                            return;
                        case '2':
                            alert("비밀번호가 다릅니다.");
                            return;
                    }
                }
            })
        }
    </script>
</head>

<body>
<!-- 탑메뉴 -->
<div class="toTopScroll">
    <img src="/img/icon-top.png" onClick="javascript:window.scrollTo(0,0)" />
</div>
<div class="top d-none d-md-block">
    <div class="topMenu d-none d-md-block container">
        <span class="home"><a href="/">HOME</a></span>

        <span><a href="/member/login">LOGIN</a></span>

        <span><a href="/member/join">JOIN</a></span>
        <span><a href="/company/company03">CONTACT US</a></span>
    </div>
</div>

<!-- 네비바 -->
<nav class="navbar navbar-expand-md navbar-light bg-white sticky-top">
    <div class="container">
        <a class="navbar-brand" href="/"
        ><img src="/img/logo.png" alt="로고"
        /></a>
        <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#collapsibleNavbar"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <!-- ml-auto : margin-left  -->
            <ul class="navbar-nav ml-auto">
                <!-- d-block : display: block  display: none -->
                <li class="nav-item d-sm-block d-md-none ljoin">
                    <a href="/member/login">
                        <img src="/img/icon-member.png" />&nbsp;&nbsp;Login</a
                    >&nbsp;
                    <a href="/member/join">
                        <img src="/img/icon-join.png" />&nbsp;&nbsp;Join</a
                    >
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="#">회사소개</a>
                    <div class="dropdown-content">
                        <a href="/company/company01">회사개요</a>
                        <a href="#">CEO인사말</a>
                        <a href="/company/company03">오시는길</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="#">사업분야</a>
                    <div class="dropdown-content">
                        <a href="/business/business01">사업분야01</a>
                        <a href="#">사업분야02</a>
                        <a href="#">사업분야03</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="#">제품안내</a>
                    <div class="dropdown-content">
                        <a href="/product/product01">제품안내01</a>
                        <a href="#">제품안내02</a>
                        <a href="#">제품안내03</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="#">커뮤니티</a>
                    <div class="dropdown-content">
                        <a href="/community/community01">공지사항</a>
                        <a href="#">홍보자료</a>
                        <a href="#">채용안내</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="#">고객지원</a>
                    <div class="dropdown-content">
                        <a href="/customer/customer01">1:1문의</a>
                        <a href="/customer/customer02">묻고답하기</a>
                        <a href="/customer/customer03">FAQ</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- main.jsp, login.jsp, ... -->

<link rel="stylesheet" href="/css/member/login.css" />

<!-- 메인 -->
<!-- COMMON -->
<div class="commonSection1">
    <div class="commonContent1">
        <img
                src="/img/member/sub-visual01.jpg"
                style="width: 100%; height: 100%"
        />
        <div class="commonContent2 text-center">
            <div>
                <h3>ADMIN</h3>
            </div>
            <div>
                <p><img src="/img/icon-home.png" /> > 관리자 로그인</p>
            </div>
        </div>
    </div>
</div>

<!-- 로그인 -->
<div class="loginForm container text-center">
    <div class="loginSection1">
        <div><h3>관리자 로그인</h3></div>
        <div><p>The design and maintenance are excellent.</p></div>
    </div>
    <div class="loginMain">
        <table class="main1">
            <tr>
                <td>
                    아이디 <br>
                    비밀번호
                </td>
                <td>
                    <input type="text" id="loginID"> <br>
                    <input type="password" id="loginPW">
                </td>
                <td>
                    <input type="image" class="loginImg" src="../img/member/btn_login.gif" onclick="login()"/>
                </td>
            </tr>
        </table>
    </div>
</div>

<!-- footer -->
<div class="footer">
    <div class="container text-center">
        <div>
            <a href="#">회사소개&nbsp;&nbsp;<span>|</span></a>
            <a href="#">개인정보보호정책&nbsp;&nbsp;<span>|</span></a>
            <a href="#">이메일무단수집거부&nbsp;&nbsp;<span>|</span></a>
            <a href="#">묻고답하기&nbsp;&nbsp;<span>|</span></a>
            <a href="#">오시는길&nbsp;&nbsp;<span>|</span></a>
        </div>
        <div>
          <span
          >회사 : 코딩강사 &nbsp; 주소 : 서울특별시 중구 명동 세종대로 110
            &nbsp; 대표 : 홍길동 <br />
            고객지원 : 010-2222-3333, FAX : 070-888-5555, EMAIL :
            support@gmail.com, 사업자등록번호 : 100-02-00033, 통신판매업 :
            제1111-경기-00000호<br />COPYRIGHT(C) 2021 CODINGGANSA. ALL RIGHT
            RESERVED.</span
          >
        </div>
        <div>
            <img src="/img/mf-icon01.png" alt="" />
            <img src="/img/mf-icon02.png" alt="" />
            <img src="/img/mf-icon03.png" alt="" />
            <img src="/img/mf-icon04.png" alt="" />
        </div>
    </div>
</div>

<script>
    // back to top 기능
    $(document).ready(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop() > 50) {
                console.log("fadeIn");
                $("#back-to-top").fadeIn();
            } else {
                console.log("fadeOut");
                $("#back-to-top").fadeOut();
            }
        });
        // scroll body to 0px on click
        $("#back-to-top").click(function () {
            console.log("click");
            $("#back-to-top").tooltip("hide");
            $("body,html").animate(
                {
                    scrollTop: 0,
                },
                500
            );
            return false;
        });
        $("#back-to-top").tooltip("show");
    });
</script>
</body>
</html>
