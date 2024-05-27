<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.net.URLDecoder"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jh/css/imrwnlogin.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
#define {
	width: 200px;
	margin-left: 20px;
}

#definelabel {
	margin-left: 30px;
}

#definesubmit {
	width: 110px;
	margin: 20px 10px 10px 150px;
}
</style>
</head>
<body>
	<script type="/jh/js/changePwd.js"></script>
	<form name="loginForm" id="loginFrm"
		action="<c:url value='/changepwd' />" method="post">
		<div class="imgcontainer">
			<a href="<c:url value='/'/>"><img
				src="/jh/img/IMRWN로고-removebg-preview.png" alt="imrwn" class="logo"></a>
		</div>

		<div class="container">
			<input type="hidden" name="id" value="${id }"> <label
				for="user_pw"><b>Password</b></label>
			<div id="pwBox"></div>
			<input type="password" id="user_pw"
				placeholder="비밀번호는 특수문자 포함 8~20글자 입니다." name="pwd" oninput="pwCk()">
			<label for="user_pwck"><b>Password Check</b></label>
			<div id="doubleCk"></div>
			<input type="password" id="user_pwck" placeholder="비밀번호를 다시 입력해 주세요."
				name="user_pwck" oninput="pwCk2()">

			<button type="button" onclick="changeCk()" id="loginbtn">비밀번호
				변경</button>
		</div>
		<div id="find"></div>
	</form>
	<script>
		//모든 조건 완성시 submit
		function changeCk() {
			let user_pw = document.getElementById("user_pw").value;
			let user_pwck = document.getElementById("user_pwck").value;

			if (!pwCheck(user_pw)) {

				document.getElementById("pwBox").innerText = "비밀번호는 8자 이상 영문 대소문자, 숫자, 특수문자를 하나씩 포함해야합니다"

			} else if (!((user_pw) == (user_pwck))) {

			} else {
				document.querySelector("#loginbtn").type = "submit";
			}
		}
		function pwCk() {
			let user_name = document.getElementById("user_pw").value;

			if (pwCheck(user_name)) {
				document.getElementById("pwBox").innerText = ""
			}
		}
		//비밀번호 양식
		function pwCheck(user_pw) {
			var pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;

			//비밀번호는 영문 대소문자 숫자 특수문자 하나씩 포함
			return pwReg.test(user_pw);
		}
		//비밀번호와 비밀번호 확인이 일치하는지 테스트
		function pwCk2() {
			let password = document.getElementById("user_pw").value;
			let passwordCk = document.getElementById("user_pwck").value;

			if (password == passwordCk) {
				document.getElementById("doubleCk").innerText = "비밀번호가 일치합니다."
				document.getElementById("doubleCk").style.color = "white"
				
			} else {
				document.getElementById("doubleCk").innerText = "비밀번호가 일치하지않습니다."
				document.getElementById("doubleCk").style.color = "rgb(229,9,20)"
			}
		}
	</script>

</body>
</html>