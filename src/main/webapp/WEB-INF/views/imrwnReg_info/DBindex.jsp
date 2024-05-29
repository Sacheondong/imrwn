<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jh/css/imrwn.css">
<link rel="stylesheet" href="/jh/css/imrwnboard.css">
</head>
    <style>

          th, td {
            padding:10px;  /* 셀 안쪽의 여백(패딩) */
          }
          h2 {
          	text-align: center;
          	padding-left: 0px;
          	}
         section {
         	height: 100vh;
         }
		.btns {
	    color: black;
	    padding: 10px;

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
   		#backBtn {
	    color: black;
	    padding: 10px;
		
        background-color: #ddd;
        border: none;
        color: black;
        padding: 8px 16px;
        text-align: center;
        font-size: 18px;

        transition: 0.3s;
        border-radius: 8px;

		}
		#backBtn:hover {
	    background-color: rgb(229,9,20);
	    color: white;
   		}		
   		#backDiv {
   			padding-left : 350px;
   			padding-top : 30px;
   			padding-bottom: 30px;
   		}	
    </style>
<body>
	 <div id="content">
	 	<%@ include file = "../imrwnHeader.jsp" %>
	 	<div id="main" style="display:block; background-color:black; color:white;">
	 	

		<h2>회원 정보 DB</h2>
		
		<div id="backDiv">
			<button type="button" onclick="location.href='<c:url value='/myinfo'/>'" id="backBtn">돌아가기</button>
		</div>
		
		<table>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>이메일</th>
				<th>리뷰 수</th>
				<th>평점 남긴 영화 수</th>
				<th>가입일자</th>
				<th>관리</th>
			</tr>
	
				<c:forEach items="${mList }" var="m">
				
  
				<tr>
					<td>${m.id }</td>
					<td>${m.nickName }</td>
					<td>${m.email }</td>
					<td>${m.movieCnt }</td>
					<td>${m.movielikeCnt }</td>

					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${m.regDate }"/></td>
					
					<c:if test="${ m.id ne 'dlawjdgur94'  }">
					<td style="text-align: center;"><button type="button" onclick="deletef(this)" data-id='${m.id }' class="btns">삭제</button></td>
					</c:if>
					<c:if test="${ m.id eq 'dlawjdgur94'  }">
					<td style="text-align: center;">관리자</td>
					</c:if>
					</tr>

				</c:forEach>
				
		</table>
		
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
		function deletef(elm){
			let id = elm.getAttribute("data-id");
			if (confirm("삭제하시겠습니까?")){
				location.href='./iddelete?id='+id;
						
			}else {
				alert("취소되었습니다.");
			}
				
		}
	
	</script>
</body>
</html>