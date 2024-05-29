<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/imrwn.css">
<link rel="stylesheet" href="./css/imrwnboard.css">
<style>
	h2{
		border-bottom: 2px solid #777;
	}
	.btns {
	    color: black;
    	padding: 10px;
		cursor: pointer;
        background-color: #ddd;
        border: none;
        color: black;
        padding: 8px 16px;
        text-align: center;
        font-size: 14px;

        transition: 0.3s;
        border-radius: 8px;

	}
	.btns:hover {
	    background-color: rgb(229,9,20);
	    color: white;
   }	
   #btns1 {
		padding-top: 30px;
   }
   form{
		border-top: none;
   }
	input{
		height: 50px;
		width: 300px;
		padding: 20px;
		font-size: 20px;
   }
   laber {
		font-size : 20px;
		padding : 10px;
   }
   #myInfo {
   		width: 600px;
	    padding: 50px;
    	padding-left: 240px;
   }
   #infoFrm {
	    padding-left: 190px;
   }
   #items {
	   display: grid;
	   padding-top: 30px;
	   padding-left: 100px;
	   grid-template-columns: 1fr 1fr 1fr;
	   width: 80%;
	   height: 800px;
   }
   h4{
       text-align: center;
   }
   #trophy {
		height: 200px;
		padding-left: 53px;
   }
   .uls {
		padding-left: 50px;
      }
	.lis {
	    margin-top: 30px;
	    height: 21px;
   		overflow: hidden;
	}
	.lis :hover{
		color: rgb(229,9,20)
	}
	.itemNav {
		border-bottom: 4px solid #818181;
		padding-bottom: 20px;
	}
	#hilike {
	border: 6px solid #E9EDF1;
    border-radius: 10px;
    width: 300px;
    height: 200px;
    text-align: center;
	}
	.hip {
		margin-top: 10px;
	}
	.movlist {
	    width: 100px;
	    height: 50px;

	}
	.hrs {
		border: 1px solid #818181;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<script>
	let msg = "${msg}";
	if (msg == "no") alert("회원 수정에 실패했습니다.");
	if (msg == "ok") alert("회원 수정에 성공했습니다.");
</script>
 	 <div id="content">
	 	<%@ include file = "../imrwnHeader.jsp" %>
	 	<div id="main" style="display:block; background-color:black; color:white;">
	 	<h2>내 정보</h2>
			<div style="display:flex;" >
				<div id="myInfo">
					
			
					<c:choose>
					<c:when test="${ m.movieCnt <= 100 }">
						<img alt="" src="/jh/img/동트로피.png" id="trophy">
					</c:when>
					<c:when test="${ (m.movieCnt <= 200 )&& (m.movieCnt > 100) }">
						<img alt="" src="/jh/img/은트로피.png" id="trophy">
					</c:when>
					<c:otherwise>
						<img alt="" src="/jh/img/금트로피.png" id="trophy">
					</c:otherwise>
					</c:choose>
					<div id="hilike">
						<p class="hip">${m.nickName }님 반갑습니다</p>
						<p class="hip" style="padding-bottom: 30px">찜한 영화 수 : ${m.movielikeCnt }</p>
		        		<button type="button" onclick="location.href='<c:url value='/mymovielist'/>'" class="btns movlist" >찜 목록</button>
					</div>
					
				
				</div>
			
	        	<form  action="<c:url value='/myinfo' />" method="post" id="infoFrm">
	        	<c:set var="m" value="${m }" />
	        	<table>
	        		<tr>
		        		<td><label for="id" >아이디  </label></td>
		        		<td><input name="id" value="${m.id }" readonly></td>
	        		</tr>
	        		<tr>
		        		<td><label for="nickName">닉네임  </label></td>
		        		<td><input name="nickName" id="nickName" value="${m.nickName }"></td>
	        		</tr>
	        		<tr>
		        		<td><label for="pwd">비밀번호 </label></td> 
		        		<td><input type="password" name="pwd"  id="user_pw" oninput="pwCk()"></td>
	        		</tr>
	        		<tr>
		        		<td><label for="pwck">비밀번호 확인  </label></td>
		        		<td><input type="password" name="pwck" id="user_pwck" oninput="pwCk2()"></td>
	        		</tr>
	        		<tr>
		        		<td><label for="email">이메일  </label></td>
		        		<td><input name="email" value="${m.email }" readonly></td>
	        		</tr>
	        	</table>
	        		
	        		<div id="btns1">
	        		<button type="button" id="updateInfo" onclick="updateCk()" class="btns" >회원 정보 수정</button>
	        		<c:if test="${not (empty sessionScope.id) && 'dlawjdgur94' eq sessionScope.id }">
						<button type="button" onclick="location.href='<c:url value='/admin/dbindex'/>'" class="btns">회원 DB 관리</button>
					</c:if>
					
					</div>
				</form>
				
        	</div>
      		<div id="items">
				<div>
				<h4 class="itemNav">내가 남긴 리뷰</h4>
					<div id="myReview">
						<ul class="uls">
						<c:forEach var="rList" items="${rList }">
							<li class="lis"><a href="<c:url value="/movie/view?mno=${rList.mno }" />">${rList.review }</a></li>
							<hr class="hrs">
						</c:forEach>
						</ul>
					</div>
				</div>
			
				<div>
				<h4 class="itemNav">내가 남긴 게시글</h4>
					<div id="myBoard">
						<ul class="uls">
						<c:forEach var="bList" items="${bList }">
							<li class="lis"><a href="<c:url value="/board/read?bno=${bList.bno }" />">${bList.title }</a></li>
							<hr class="hrs">
						</c:forEach>
						</ul>
					</div>
				</div>
			
				<div>
				<h4 class="itemNav">내가 남긴 댓글</h4>
					<div id="myComment">
						<ul class="uls">
						<c:forEach var="cList" items="${cList }">
							<li class="lis"><a href="<c:url value="/board/read?bno=${cList.bno }" />">${cList.comment }</a></li>
							<hr class="hrs">
						</c:forEach>
						</ul>
					</div>
				</div>
			
			</div>
        
        </div>
        
        
        
        
        <button id="myBtn" title="Go to top">Top</button>
        <footer >
            <div id="foot">
                <a href="#">고객센터</a>
                
                <a href="#">광고 문의</a>
                
                <a href="#">이용 약관</a>
                
                <a href="#">개인정보 처리 방침</a>
            </div>
            <div id="copyright">
                <p> Copyright © 2024 by LIm jeong-hyeok. All rights reserved.</p>
            </div>
        </footer>
	 </div>
	 
	 <script>


	//ID 비밀번호 Email 양식 체크

		function updateCk(){
		let nickName = document.getElementById("nickName").value;
	    let user_pw = document.getElementById("user_pw").value;
	    let user_pwck = document.getElementById("user_pwck").value;
	    
	    if(nickName.trim() === ""){
	    	alert("닉네임은 공백일 수 없습니다.");
	    	
	    	return
	    }
	    
	    if(user_pw != "" && user_pw != null && user_pw != "null"){
		    if (!pwCheck(user_pw)){
		        
		        alert("비밀번호는 8자 이상 영문 대소문자, 숫자, 특수문자를 하나씩 포함해야합니다");
	
		    }
		    else if(!((user_pw) == (user_pwck))) {
				
			}
		    else {
		        document.querySelector("#updateInfo").type = "submit";
		    }
	    }else {
	      //   document.getElementById("updateInfo").type = "submit";
	         document.querySelector("#infoFrm").submit();
	    }
	}
	//양식에 맞게 입력하였을 경우 알림 해제
	    function pwCk() {
	        let user_name = document.getElementById("user_pw").value;
	        
	        if(pwCheck(user_name)) {
	            document.getElementById("pwBox").innerText = ""
	        }
	    }

	//비밀번호 양식

	    function pwCheck(user_pw){
	        var pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
	   		
	        //비밀번호는 영문 대소문자 숫자 특수문자 하나씩 포함
	        return pwReg.test(user_pw);
	    }


	//비밀번호와 비밀번호 확인이 일치하는지 테스트
	function pwCk2(){
	    let password = document.getElementById("user_pw").value;
	    let passwordCk = document.getElementById("user_pwck").value;

	    if ( password == passwordCk) {
	        document.getElementById("user_pwck").style.color = "green"
	    }
	    else {
	        document.getElementById("user_pwck").style.color = "rgb(229,9,20)"
		}
	}

	 </script>
</body>
</html>