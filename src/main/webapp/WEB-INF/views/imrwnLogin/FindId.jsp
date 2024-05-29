<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jh/css/imrwnlogin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
    <form  name="writeFrm" id="loginFrm">
        <div class="imgcontainer">
            <a href="<c:url value='/'/>"><img src="/jh/img/IMRWN로고-removebg-preview.png" alt="imrwn" class="logo"></a>
        </div>
      
		<div class="container">
			<label for="user_id"><b>아이디</b></label>
        	<input type="text" placeholder="아이디를 입력해 주세요." name="id" id="user_id" class="textInput" value="">
          
          	<label for="user_email"><b>Email</b></label>
          	<input type="text" placeholder="이메일을 입력해 주세요." name="email" id="user_email" class="textInput" value="">
          	<button type="button" onclick="" id="loginbtn">회원 정보 찾기</button>
        </div>
		<div id="find">

		</div>
      </form>

	<script>
		$(document).ready(function(){
			
	    	
			$("#loginbtn").click(function(){
				let email = $("#user_email").val();
				let id = $("#user_id").val();
				if(email.trim()==''){
		    		alert("입력해주세요");
		    	}else {
		    		findId();
		    	}
			
		})
			function findId() {
				let email = $("#user_email").val();
				let id = $("#user_id").val();
				$.ajax({
		            type:'POST',       // 요청 메서드
		            url: '${pageContext.request.contextPath}/findid/',  // 요청 URI
		            data : {id : id, email : email},
		            success : function(result){
			            	if(result === "err") {
			            		alert("아이디를 확인해 주세요");
			            		
			            	}else {
					            	uuid = result;
					            		$("#find").html(toHtml(result));	
					         }
						 },
		            error: function(request, status, error){ alert("이메일을 확인해주세요"); } // 에러가 발생했을 때, 호출될 함수
		        }); // $.ajax()
		        
				}
			
		
		})
		let toHtml =function(email){		
			let tmp = '<form>'
				tmp +='<label for="define" id="definelabel"><b>인증키</b></label>'
				tmp += '<input type="text" placeholder="8자리 인증키를 입력해 주세요" name="uuid" id="define" class="textInput" value="">'
				tmp += '<button type="button" onclick="defineFn()" id="definesubmit">입력 완료</button>'				
			return tmp + '</form>';
		}
		function defineFn(){
			let checkVal = document.getElementById("define").value;

 			if(uuid == checkVal){
				let form = document.writeFrm;
				form.method="post";
				form.action="change";
				form.submit();			
			}else {
				alert("인증키가 다릅니다.")
			}
		}
	</script>
</body>
</html>