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
<style>
	input{
		width:900px;
		height:30px;
	}
 	.writecon{
		margin:0 auto;
	} 
	textarea{
		width:900px;
		height:500px;
		padding: 5px;
		margin: 10px;

	}
	form{
		border-top: 4px solid #777;
		padding-left: 200px;
	}	
	h2{
		padding-left: 200px;
		padding-top: 20px;
		padding-bottom: 60px;
		font-size: 2.4em;
	}	
	.write-1 {
	    height: 50px;
	    border: 1px solid #777;
	    font-size: 40px;
	    color: white;
	    background-color: black;
	    outline: none;
	}
	.write-2 {
	    margin-top: 30px;
	    font-size: 15px;
	    border: 1px solid #777;	    
	    color: white;
	    background-color: black;
	    outline: none;
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
	}
</style>
</head>
<body>
 	 <div id="content">
	 	<%@ include file = "../imrwnHeader.jsp" %>
	 	<div id="main" style="display:block; background-color:black; color:white;">
	 		<h2>한국 영화</h2>

			<form name="updatefrm" action="<c:url value='/board/modify'/>" onsubmit="return formCheck(this)" method="post"id="fileFrm" enctype="multipart/form-data">
				
				<p>제목</p>
				<input type="hidden" name="bno" value="${b.bno }">
				<input type="hidden" name="page" value="${param.page }">
				<input type="hidden" name="del" id="del" value="0">
				<input class="write-1" type=text name="title" id="board_title" value="${b.title }">
				
				<div id="vcontent">
					<textarea id="contentarea" class="write-2" name="content" style="resize:none">${b.content }</textarea>
				</div>
				<div id="btns">
				<c:if test="${sessionScope.id ne null && sessionScope.id eq b.writer }">
				<%@ include file="../Files/file.jsp"%>
					<button class="btns">수정완료</button>
					<button type="reset" class="btns">다시입력</button>
				</c:if>
					<button type="button" onclick="location.href='<c:url value='/board/${b.movieType}?page=${param.page }'/>'" class="btns">목록보기</button>
				</div>
			</form>

	
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
		function formCheck(frm){
			if(frm.title.value.trim()==""){
				alert("제목을 입력하세요");
				frm.title.focus();
				return false;
			}
			if(frm.content.value.trim()==""){
				alert("내용을 입력하세요.");
				frm.content.focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>