<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.net.URLDecoder" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/imrwnlogin.css">
</head>
<body>
<script>
let msg = "${msg}";
if( msg == "logErr" ) alert("로그인 실패");
if( msg == "changeSuc") alert("비밀번호 변경 성공");

</script>

    <form name="loginForm" action="<c:url value='/login' />" id="loginFrm" method="post">
        <div class="imgcontainer">
            <a href="<c:url value='/' />"><img src="/jh/img/IMRWN로고-removebg-preview.png" alt="imrwn" class="logo"></a>
        </div>
      
        <div class="container">
          <label for="user_name"><b>Username</b></label>
          <input type="text" placeholder="아이디를 입력해 주세요." name="id" id="userId" class="textInput" value="${ cookie.id.value }">
      
          <label for="user_pw"><b>Password</b></label>
          <div id="message"></div>
          <input type="password" placeholder="비밀번호를 입력해 주세요." name="pwd" id="userPw" onkeyup="ckCapslock(event)" class="textInput">
      
          <button type="button" onclick="idpwCk()" id="loginbtn">Login</button>
          <label>
            <input type="checkbox" name="rememberId" ${empty cookie.id.value ? "" : "checked"}> 로그인 정보 기억
          </label>
          
		<input type="text" name="toURL" id="address" value="${param.toURL}" readonly style="display:none;">
        </div>
      
        <div class="container sign">
          <button type="button" class="cancelbtn" onclick="WinClose()">Cancel</button>
          <span class="psw"><a href="<c:url value='/findid' />">비밀번호를 잊어버리셨나요?</a></span>
          <span class="signup"><a href="<c:url value='/register/save' />">회원가입 하기</a></span>
        </div>
        <div>
            <p>다른 방법으로 로그인하기</p>
            <div id="sns">
                <a href="" class="he"><img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzOCIgaGVpZ2h0PSIzOCIgdmlld0JveD0iMCAwIDM4IDM4Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGNpcmNsZSBjeD0iMTkiIGN5PSIxOSIgcj0iMTkiIGZpbGw9IiNGQUU0MDAiLz4KICAgICAgICA8Zz4KICAgICAgICAgICAgPHBhdGggZD0iTTAgMEgyNFYyNEgweiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSIvPgogICAgICAgICAgICA8cGF0aCBmaWxsPSIjM0MxRTFFIiBmaWxsLXJ1bGU9Im5vbnplcm8iIGQ9Ik0xMS45OTIgMy42OTJjNS4wOTMgMCA5LjIyMiAzLjMwMyA5LjIyMiA3LjM3N3MtNC4xMjkgNy4zNzYtOS4yMjIgNy4zNzZjLS41NTIgMC0xLjA5Mi0uMDM4LTEuNjE2LS4xMTNsLTMuNjQgMi41MTJjLS4xNzIuMTItLjM2OC0uMDIxLS4zNDMtLjE5My4wMTQtLjEwMi4yNy0xLjIwMi43NjUtMy4yOTktMi42MzMtMS4yOTgtNC4zODktMy42MjctNC4zODktNi4yODMgMC00LjA3NCA0LjEzLTcuMzc3IDkuMjIzLTcuMzc3eiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSIvPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+Cg==" alt=""></a>
                <a href="" class="he"><img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzOCIgaGVpZ2h0PSIzOCIgdmlld0JveD0iMCAwIDM4IDM4Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGNpcmNsZSBjeD0iMTkiIGN5PSIxOSIgcj0iMTkiIGZpbGw9IiNGRkYiLz4KICAgICAgICA8Zz4KICAgICAgICAgICAgPHBhdGggZD0iTTAgMEgyNFYyNEgweiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSIvPgogICAgICAgICAgICA8ZyBmaWxsLXJ1bGU9Im5vbnplcm8iPgogICAgICAgICAgICAgICAgPHBhdGggZmlsbD0iIzQyODVGNCIgZD0iTTE2LjczNSA4LjczM2MwLS42MDYtLjA1NC0xLjE4OC0uMTU1LTEuNzQ3SDguNTM4djMuMzAzaDQuNTk2Yy0uMTk4IDEuMDY3LS44IDEuOTcxLTEuNzA0IDIuNTc3djIuMTQyaDIuNzZjMS42MTQtMS40ODYgMi41NDUtMy42NzUgMi41NDUtNi4yNzV6IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3IDcpIHRyYW5zbGF0ZSgzLjQ2MiAzLjQ2MikiLz4KICAgICAgICAgICAgICAgIDxwYXRoIGZpbGw9IiMzNEE4NTMiIGQ9Ik04LjUzOCAxNy4wNzdjMi4zMDYgMCA0LjIzOS0uNzY1IDUuNjUxLTIuMDY5bC0yLjc2LTIuMTQyYy0uNzY0LjUxMi0xLjc0Mi44MTUtMi44OS44MTUtMi4yMjQgMC00LjEwNy0xLjUwMi00Ljc3OC0zLjUySC45MDh2Mi4yMTJjMS40MDUgMi43OSA0LjI5MyA0LjcwNCA3LjYzIDQuNzA0eiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSB0cmFuc2xhdGUoMy40NjIgMy40NjIpIi8+CiAgICAgICAgICAgICAgICA8cGF0aCBmaWxsPSIjRkJCQzA1IiBkPSJNMy43NiAxMC4xNmMtLjE3LS41MTItLjI2Ny0xLjA1OS0uMjY3LTEuNjIyIDAtLjU2Mi4wOTctMS4xMS4yNjgtMS42MjJWNC43MDRILjkwOEMuMzMgNS44NTcgMCA3LjE2IDAgOC41MzhjMCAxLjM3OC4zMyAyLjY4Mi45MDggMy44MzVsMi44NTMtMi4yMTJ6IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3IDcpIHRyYW5zbGF0ZSgzLjQ2MiAzLjQ2MikiLz4KICAgICAgICAgICAgICAgIDxwYXRoIGZpbGw9IiNFQTQzMzUiIGQ9Ik04LjUzOCAzLjM5NmMxLjI1NCAwIDIuMzguNDMgMy4yNjQgMS4yNzdsMi40NS0yLjQ1QzEyLjc3MS44NDcgMTAuODQgMCA4LjUzNyAwIDUuMjAxIDAgMi4zMTMgMS45MTMuOTA4IDQuNzA0bDIuODUzIDIuMjEyYy42NzEtMi4wMTggMi41NTQtMy41MiA0Ljc3Ny0zLjUyeiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSB0cmFuc2xhdGUoMy40NjIgMy40NjIpIi8+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPgo=" alt=""></a>
                <a href="" class="he"><img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzOCIgaGVpZ2h0PSIzOCIgdmlld0JveD0iMCAwIDM4IDM4Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGNpcmNsZSBjeD0iMTkiIGN5PSIxOSIgcj0iMTkiIGZpbGw9IiMwMEEyRkEiLz4KICAgICAgICA8Zz4KICAgICAgICAgICAgPHBhdGggZD0iTTAgMEgyNFYyNEgweiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSIvPgogICAgICAgICAgICA8cGF0aCBmaWxsPSIjRkZGIiBmaWxsLXJ1bGU9Im5vbnplcm8iIGQ9Ik04LjU4NCAxOS41NTJjNi45NSAwIDEwLjc1LTUuNzM1IDEwLjc1LTEwLjcwOCAwLS4xNjMtLjAwNC0uMzI1LS4wMTEtLjQ4Ni43MzctLjUzMSAxLjM3OS0xLjE5NCAxLjg4NS0xLjk0OS0uNjc3LjMtMS40MDYuNTAyLTIuMTcuNTkzLjc4LS40NjYgMS4zNzktMS4yMDMgMS42NjEtMi4wODItLjczLjQzLTEuNTM4Ljc0NC0yLjM5OS45MTMtLjY5LS43MzEtMS42NzEtMS4xODktMi43NTgtMS4xODktMi4wODYgMC0zLjc3OCAxLjY4Ni0zLjc3OCAzLjc2MyAwIC4yOTYuMDMzLjU4My4wOTguODU4LTMuMTQtLjE1Ny01LjkyNS0xLjY1NC03Ljc4OC0zLjkzMi0uMzI1LjU1Ny0uNTEyIDEuMjAzLS41MTIgMS44OTIgMCAxLjMwNi42NjcgMi40NTggMS42ODIgMy4xMzMtLjYyLS4wMi0xLjIwMi0uMTg5LTEuNzEyLS40NzF2LjA0OGMwIDEuODIzIDEuMzAyIDMuMzQ0IDMuMDMgMy42OS0uMzE3LjA4NS0uNjUuMTMyLS45OTUuMTMyLS4yNDQgMC0uNDgtLjAyNC0uNzEtLjA2OC40OCAxLjQ5NSAxLjg3NSAyLjU4MyAzLjUzIDIuNjE0LTEuMjk0IDEuMDEtMi45MjMgMS42MS00LjY5MyAxLjYxLS4zMDUgMC0uNjA2LS4wMTctLjkwMi0uMDUyIDEuNjcyIDEuMDY4IDMuNjU4IDEuNjkgNS43OTIgMS42OSIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSIvPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+Cg==" alt=""></a>
                <a href="" class="he"><img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzOCIgaGVpZ2h0PSIzOCIgdmlld0JveD0iMCAwIDM4IDM4Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGNpcmNsZSBjeD0iMTkiIGN5PSIxOSIgcj0iMTkiIGZpbGw9IiNGRkYiLz4KICAgICAgICA8Zz4KICAgICAgICAgICAgPHBhdGggZD0iTTAuOTIzIDAuOTIzSDIzLjA3Njk5OTk5OTk5OTk5OFYyMy4wNzY5OTk5OTk5OTk5OThIMC45MjN6IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3IDcpIi8+CiAgICAgICAgICAgIDxwYXRoIGZpbGw9IiMwMDAiIGZpbGwtcnVsZT0ibm9uemVybyIgZD0iTTEyLjAyNCA0Ljk2Yy44OSAwIDIuMDA3LS41ODkgMi42NzEtMS4zNzQuNjAzLS43MTEgMS4wNDItMS43MDUgMS4wNDItMi42OTggMC0uMTM1LS4wMTMtLjI3LS4wMzgtLjM4LS45OTEuMDM2LTIuMTgzLjY1LTIuODk4IDEuNDcxLS41NjQuNjI2LTEuMDc4IDEuNjA3LTEuMDc4IDIuNjEzIDAgLjE0Ny4wMjUuMjk0LjAzNy4zNDMuMDYzLjAxMi4xNjMuMDI1LjI2NC4wMjV6TTguODg4IDE5LjhjMS4yMTcgMCAxLjc1Ni0uNzk3IDMuMjc0LS43OTcgMS41NDMgMCAxLjg4MS43NzIgMy4yMzYuNzcyIDEuMzMgMCAyLjIyLTEuMjAxIDMuMDYtMi4zNzkuOTQxLTEuMzQ5IDEuMzMtMi42NzQgMS4zNTUtMi43MzUtLjA4OC0uMDI0LTIuNjM0LTEuMDQyLTIuNjM0LTMuOSAwLTIuNDc4IDIuMDA3LTMuNTk0IDIuMTItMy42OC0xLjMzLTEuODY0LTMuMzUtMS45MTMtMy45MDEtMS45MTMtMS40OTMgMC0yLjcxLjg4My0zLjQ3NS44ODMtLjgyNyAwLTEuOTE5LS44MzQtMy4yMS0uODM0LTIuNDYgMC00Ljk1NSAxLjk4Ny00Ljk1NSA1Ljc0IDAgMi4zMy45MjggNC43OTYgMi4wNyA2LjM5Ljk3OCAxLjM1IDEuODMgMi40NTMgMy4wNiAyLjQ1M3oiIHRyYW5zZm9ybT0idHJhbnNsYXRlKDcgNykiLz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPgo=" alt=""></a>
                <a href="" class="he"><img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzOCIgaGVpZ2h0PSIzOCIgdmlld0JveD0iMCAwIDM4IDM4Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGNpcmNsZSBjeD0iMTkiIGN5PSIxOSIgcj0iMTkiIGZpbGw9IiMwMEM4MDEiLz4KICAgICAgICA8Zz4KICAgICAgICAgICAgPHBhdGggZD0iTTAgMEgyNFYyNEgweiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSIvPgogICAgICAgICAgICA8cGF0aCBmaWxsPSIjRkZGIiBmaWxsLXJ1bGU9Im5vbnplcm8iIGQ9Ik0xOS42MTQgMTUuNDY4Yy0yLjAzMiAyLjM0LTYuNTggNS4xOS03LjYxNCA1LjYyNS0xLjAzNC40MzUtLjg4Mi0uMjc4LS44NC0uNTIyLjAyNi0uMTQ2LjEzOS0uODMuMTM5LS44My4wMzMtLjI0Ny4wNjYtLjYzMS0uMDMyLS44NzYtLjEwOC0uMjctLjUzOC0uNDEtLjg1My0uNDc4LTQuNjU4LS42MTUtOC4xMDYtMy44Ny04LjEwNi03Ljc1NiAwLTQuMzM1IDQuMzQ4LTcuODYyIDkuNjkyLTcuODYyczkuNjkyIDMuNTI3IDkuNjkyIDcuODYyYzAgMS43MzUtLjY3MyAzLjI5Ny0yLjA3OCA0LjgzN3pNOC4yMDYgMTIuMTk0SDYuNzg4VjguODUyYzAtLjI4LS4yMjgtLjUwOC0uNTA4LS41MDhzLS41MDguMjI4LS41MDguNTA4djMuODVjMCAuMjguMjI4LjUwOC41MDguNTA4aDEuOTI2Yy4yOCAwIC41MDgtLjIyOC41MDgtLjUwOHMtLjIyNy0uNTA4LS41MDgtLjUwOHptMS45OTItMy4zNDJjMC0uMjgtLjIyOC0uNTA4LS41MDgtLjUwOHMtLjUwOC4yMjgtLjUwOC41MDh2My44NWMwIC4yOC4yMjguNTA4LjUwOC41MDhzLjUwOC0uMjI4LjUwOC0uNTA4di0zLjg1em00LjYzNiAwYzAtLjI4LS4yMjgtLjUwOC0uNTA4LS41MDhzLS41MDkuMjI4LS41MDkuNTA4djIuMzgybC0xLjk3NC0yLjY4N2MtLjA5NS0uMTI3LS4yNDctLjIwMy0uNDA2LS4yMDMtLjA1NCAwLS4xMDkuMDA5LS4xNjEuMDI2LS4yMDguMDctLjM0Ny4yNjMtLjM0Ny40ODJ2My44NWMwIC4yOC4yMjguNTA4LjUwOC41MDhzLjUwOC0uMjI4LjUwOC0uNTA4VjEwLjMybDEuOTc0IDIuNjg3Yy4wOTYuMTI3LjI0Ny4yMDMuNDA2LjIwMy4wNTUgMCAuMTA5LS4wMDkuMTYxLS4wMjYuMjA4LS4wNy4zNDgtLjI2My4zNDgtLjQ4MnYtMy44NXptMy4xMTYgMi40MzNjLjI4IDAgLjUwOC0uMjI4LjUwOC0uNTA4cy0uMjI4LS41MDgtLjUwOC0uNTA4aC0xLjQxN1Y5LjM2aDEuNDE3Yy4yOCAwIC41MDgtLjIyOC41MDgtLjUwOHMtLjIyOC0uNTA4LS41MDgtLjUwOGgtMS45MjZjLS4yOCAwLS41MDguMjI4LS41MDguNTA4VjEyLjcwMmMwIC4yOC4yMjguNTA4LjUwOC41MDhoMS45MjZjLjI4IDAgLjUwOC0uMjI4LjUwOC0uNTA4cy0uMjI4LS41MDgtLjUwOC0uNTA4aC0xLjQxN3YtLjkxaDEuNDE3eiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNyA3KSIvPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+Cg==" alt=""></a>
            </div>
        </div>
      </form>

      <script src="/jh/js/imrwnLogin.js"></script>
      
</body>
</html>