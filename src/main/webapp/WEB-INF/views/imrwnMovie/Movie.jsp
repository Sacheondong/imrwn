<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jh/css/imrwn.css">
<link rel="stylesheet" href="/jh/css/imrwnboard.css">
<title>Insert title here</title>
<style>
	#main {
		height: 100%;
		padding-top: 40px;
	}
	#movieCon {
		width: 1500px;
	}
	div.gallery {
	  border: 1px solid #ccc;
	  width: fit-content;
	}
	
	div.gallery:hover {
	  border: 1px solid #777;
	}
	
	div.gallery img {
	  width: 205px;
	  height: 292px;
	}
	
	div.desc {
	  padding: 15px;
	  text-align: center;
	  width: 205px;
      height: 52px;
      justify-content: center;
      align-items: center;
      display: flex;
	}
	
	* {
	  box-sizing: border-box;
	}
	
	.responsive {
	  padding: 15px 20px;
	  float: left;
	}
	
	@media only screen and (max-width: 700px) {
	  .responsive {
	    width: 49.99999%;
	    margin: 6px 0;
	  }
	}
	
	@media only screen and (max-width: 500px) {
	  .responsive {
	    width: 100%;
	  }
	}
	
	.clearfix:after {
	  content: "";
	  display: table;
	  clear: both;
	}
	.navpl {
	    width: 400px;
	    margin: auto;
	    font-size: 1.2em;
	    padding-bottom: 20px;
	    padding-top: 20px;
	}
</style>
</head>
<body>
	<div id="content">
		<%@ include file="../imrwnHeader.jsp"%>
		<div id="main" style="display: flex;background-color: black;color: white;flex-direction: column;">
			<div id="movieCon">
				<c:forEach var="mlist" items="${mList }">
				<div class="responsive">
					<div class="gallery">
						<c:choose>
						<c:when test="${empty mlist.posters }">
							<a href='<c:url value="/movie/view?mno=${mlist.mno }" />'><img alt="" src="/jh/img/포스터 준비.png"></a>
						</c:when>
						<c:otherwise>
							<a href='<c:url value="/movie/view?mno=${mlist.mno }" />'><img alt="" src="${mlist.posters }"></a>
						</c:otherwise>
						</c:choose>
						<div class="desc">${mlist.title }</div>
					</div>
				</div>
				</c:forEach>
			</div>
				<c:choose>
					<c:when test="${like eq 'ok' }" >
						<div class="navpl">
						<c:if test="${ph.showPrev }">
							<a
								href="<c:url value='/mymovielist${ph.sc.getQueryString(ph.beginPage-1) }'/>">&laquo;</a>
						</c:if>
						<c:forEach var="i" begin="${ph.beginPage }" end="${ph.endPage }">
							<a class='${ph.sc.page== i ? "check" : "" }'
								href="<c:url value='/mymovielist${ph.sc.getQueryString(i) }'/>">${i}</a>
						</c:forEach>
						<c:if test="${ph.showNext }">
							<a
								href="<c:url value='/mymovielist${ph.sc.getQueryString(ph.endPage+1) }'/>">&raquo;</a>
						</c:if>
				</div>
					
					 </c:when>
				
				
				<c:otherwise>
					<div class="navpl">
						<c:if test="${ph.showPrev }">
							<a
								href="<c:url value='/movie/search${ph.sc.getQueryString(ph.beginPage-1) }'/>">&laquo;</a>
						</c:if>
						<c:forEach var="i" begin="${ph.beginPage }" end="${ph.endPage }">
							<a class='${ph.sc.page== i ? "check" : "" }'
								href="<c:url value='/movie/search${ph.sc.getQueryString(i) }'/>">${i}</a>
						</c:forEach>
						<c:if test="${ph.showNext }">
							<a
								href="<c:url value='/movie/search${ph.sc.getQueryString(ph.endPage+1) }'/>">&raquo;</a>
						</c:if>
					</div>
				</c:otherwise>
				</c:choose>
		</div>

		<button id="myBtn" title="Go to top">Top</button>
		<footer>
			<div id="foot">
				<a href="#">고객센터</a> <a href="#">광고 문의</a> <a href="#">이용 약관</a> <a
					href="#">개인정보 처리 방침</a>
			</div>
			<div id="copyright">
				<p>Copyright © 2024 by LIm jeong-hyeok. All rights reserved.</p>
			</div>
		</footer>
	</div>
</body>
</html>