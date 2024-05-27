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
	h2{
		padding-left: 200px;
		padding-top: 20px;
		padding-bottom: 60px;
		font-size: 2.4em;
	}
	form{
		border-top: 4px solid #777;
		padding-left: 200px;
	}
	#writer {
		padding-left: 20px;
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
	#information {
		padding-left: 530px;
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
</style>
</head>
<body>
<script>
	let msg = "${msg}";
	if (msg == "error") alert("잠시 후 다시 시도해 주십시오.");
	if (msg == "update") alert("수정에 성공했습니다.");
</script>
	<div id="content">
		<%@ include file = "../imrwnHeader.jsp" %>
	 	<div id="main" style="display:block; background-color:black; color:white; height: 100%; padding-bottom: 50px;">
	 		<h2>${b.movieType eq "kor" ? "한국" : b.movieType eq "eng" ? "미국" : b.movieType eq "jpn" ? "일본" : b.movieType eq "eur" ? "유럽" : b.movieType eq "east" ? "동양" : "전체"} 영화</h2>
	 	
     		<form name="writeFrm" enctype="multipart/form-data" action="<c:url value='/board/modify'/>">
				<input type="hidden" name="bno" value="${b.bno }">
				<input type="hidden" name="page" value="${param.page }">
				<input type=text class="write-1" name="title" id="board_title" value="${b.title }" readonly>
				<div id="vinfo">
					<div id="writer">작성자  ${b.nickName }</div>
					<div id="information">
					<fmt:formatDate value="${b.postDate}" type="both" pattern="yyyy-MM-dd HH:mm" var="postdate" />
							
						<span>${postdate }</span>
						<span> 조회 수 ${b.viewCnt }</span>
						<span id="cntTxt">댓글 ${b.commentCnt }</span>
						<span id="likeTxt">좋아요 ${b.likeCnt }</span>
					</div>
				</div>
				<div id="vcontent">
					<div id="contentarea" class="write-2" name="content" style="width: 900px; height: 500px; padding: 5px; margin: 10px;"><c:if test="${not empty b.fileName }">
							<img style="width: 200px; height: 200px" id="previewImg" src="/jh/${b.fileName }">
							<br>
						</c:if>
						
						${b.content }</div>
				</div>
				<div id="btns">
				<c:if test="${not (empty sessionScope.id) && b.writer eq sessionScope.id }">
					<button type="submit" class="btns">수정하기</button>
					<button type="button" onclick="deleteBoard()" class="btns">삭제하기</button>
				</c:if>
					<button type="button" onclick="location.href='<c:url value='/board/${b.movieType}?page=${param.page }'/>'" class="btns">목록보기</button>
				</div>
		<%@ include file="./Like.jsp" %> 
		<%@ include file="./Comment.jsp" %>
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
	function deleteBoard(){
		let check = confirm("정말로 삭제하시겠습니까?");
		if(check){
			let form = document.writeFrm;
			form.method="post";
			form.action="remove";
			form.submit();			
		}
	}
</script>
</body>
</html>