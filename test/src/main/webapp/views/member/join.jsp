<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입2</title>

    <!-- Main CSS : Header, Main, Footer -->
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/member/join.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

    <!-- Bootstarp JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

    <script>
        var join = function (){
            if(checkInputAll() && checkPw()){
                var form = document.joinForm;
                form.submit();
            };
        }

        var checkInputAll = function (){
            let id = $('#memberId').val();
            if(id == '' || id == null){
                alert('"아이디"가 입력되지 않았습니다.');
                $('#memberId').focus();
                return false;
            }

            let pw = $('#memberPw').val();
            if(pw == '' || pw == null){
                alert('"비밀번호"가 입력되지 않았습니다.');
                $('#memberPw').focus();
                return false;
            }

            let pwCheck = $('#memberPwCheck').val();
            if(pwCheck == '' || pwCheck == null){
                alert('"비밀번호 확인"이 입력되지 않았습니다.');
                $('#memberPwCheck').focus();
                return false;
            }

            let name = $('#memberName').val();
            if(name == '' || name == null){
                alert('"이름"이 입력되지 않았습니다.');
                $('#memberName').focus();
                return false;
            }

            let email = $('#memberEmail').val();
            if(email == '' || email == null){
                alert('"이메일"이 입력되지 않았습니다.');
                $('#memberEmail').focus();
                return false;
            }

            let pwQuestion = $("select[name=memberPwQuestion]").val();
            if(pwQuestion == '0'){
                alert('"비밀번호 확인시 질문"을 선택하지 않았습니다.');
                $('#memberPwQuestion').focus();
                return false;
            }

            let pwAnswer = $('#memberPwAnswer').val();
            if(pwAnswer == '' || pwAnswer == null){
                alert('"비밀번호 확인시 답변"이 입력되지 않았습니다.');
                $('#memberPwAnswer').focus();
                return false;
            }

            let birthday = $('#memberBirthDate').val();
            if(birthday == '' || birthday == null){
                alert('"생년월일"이 입력되지 않았습니다.');
                $('#memberBirthDate').focus();
                return false;
            }

            return true;
        }

        var checkPw = function (){
            let pw = $('#memberPw').val();
            let pwCheck = $('#memberPwCheck').val();

            if(pw.length < 4){
                alert('"비밀번호"는 4자리 이상이어야 합니다.');
                $('#memberPw').focus();
                return false;
            }

            if(pw != pwCheck){
                alert('암호가 일치하지 않습니다. 다시 입력해주세요.');
                return false;
            }

            return true;
        }

        var checkId = function(){
            let id = $('#memberId').val();

            $.ajax({
                url: '<c:url value="/checkId"/>',
                data:{'id':id},
                success:(result)=>{
                    if(result == '0'){
                        alert("이미 사용 중인 id 입니다.");
                        return false;
                    }else{
                        alert("사용 가능한 id 입니다.");
                        return true;
                    }
                }
            })
        }
    </script>
</head>
<body>
<!-- 메인 -->
<!-- COMMON -->
<div class="commonSection1">
    <div class="commonContent1">
        <img src="../img/member/sub-visual02.jpg"
             style="width: 100%; height: 100%;">
        <div class="commonContent2 text-center">
            <div>
                <h3>MEMBER</h3>
            </div>
            <div>
                <p><img src="../img/icon-home.png"> > 회원가입</p>
            </div>
        </div>
    </div>
</div>

<!-- 메인 -->
<!-- 회원가입 -->
<div class="joinForm container">

    <div class="joinSection1">
        <div><h3>회원가입</h3></div>
        <div><p>The design and maintenance are excellent.</p></div>
    </div>
    <div class="wellcome">
        <h3>OOO사이트에 오신 것을 환영합니다.</h3>
        <h5>-이름과 이메일을 입력해 주시면 가입여부를 확인 후 회원가입 절차가 이루어집니다.</h5>
    </div>
    <br><br>
    <div class="contents">
        <h3>회원가입을 위해서 아래의 양식에 있는 내용을 입력해 주셔야 합니다.</h3>
        <h5>-회원님의 개인정보를 신중하게 보호하고 있으며 회원님의 동의 없이는 기재하신 회원정보가 누출되지 않습니다.
            자세한 내용은 개인정보보호정책에서 확인하세요.</h5>
    </div>
    <!-- 입력폼 -->
    <div class="information1">
        <div>기본정보</div>
        <form action="/joinImpl" name="joinForm">
            <table>
                <tr>
                    <td>아이디</td>
                    <td>
                        <input type="text" id="memberId" name="memberId">
                        <img src="../img/member/btn_iddupl.gif" onclick="checkId()">
                        (영문 소문자, 숫자로 4~16자)
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td>
                        <input type="password" id="memberPw" name="memberPw">
                        영문/숫자/특수문자조합으로 8~16자리. 첫글자는 영문자로 사용
                    </td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="password" id="memberPwCheck"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" id="memberName" name="memberName"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" id="memberEmail" name="memberEmail">
                </tr>
                <tr>
                    <td>이메일 수신여부</td>
                    <td><input type="radio" name="memberEmailReceive" value="0" checked="checked">수신
                        <input type="radio" name="memberEmailReceive" value="1">수신안함</td>
                </tr>
                <tr>
                    <td>비밀번호 확인시 질문</td>
                    <td>
                        <select class="size" id="memberPwQuestion" name="memberPwQuestion">
                            <option value="0">========선택========</option>
                            <option value="1">기억에 남는 추억의 장소는?</option>
                            <option value="2">자신의 인생 좌우명은?</option>
                            <option value="3">자신의 보물 제1호는?</option>
                            <option value="4">가장 기억에 남는 선생님 성함은?</option>
                            <option value="5">내가 좋아하는 캐릭터는?</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>비밀번호 확인시 답변</td>
                    <td><input type="text" id="memberPwAnswer" name="memberPwAnswer" value=""></td>
                </tr>
                <tr>
                    <td>성별</td>
                    <td>
                        <input type="radio" name="memberGender" checked="checked">남자
                        <input type="radio" name="memberGender">여자
                    </td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td>
                        <input type="date" id="memberBirthDate" name="memberBirthDate">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="Information2">부가정보</div>
    <div class="imageBtn2">
        <input type="image" src="../img/member/btn_confirm.gif" onclick="join()">
        <input type="image" src="../img/member/btn_cancel.gif">
    </div>
</div>
</body>
</html>