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
	h2{
		padding-left: 0px;
		padding-top: 50px;
	}
	.intro {
		display: flex;
	}
	.movtext {
		width: 600px;
		margin-right: 300px;
	}
	.movexp {
		padding-bottom: 20px;
	}
	.more-actor {
		height: 21px;
		overflow: hidden;
		margin-top: 30px;
	}
	.plot {
		margin-top: 30px;
	}
	img.poster {
		width: 300px;
		height: 430px;
	}
	#more {
	    margin-left: 50px;
	    color: #84868d;
	    background: none;
	    outline: none !important;
	    box-shadow: none !important;
	    cursor: pointer;
	    border: 0px;
	}
 }

</style>
</head>
<body>
	<div id="content">
		<%@ include file="../imrwnHeader.jsp"%>
		<div id="main" style="display: block; background-color: black; color: white;">
			<div id="movieCon">
			
			<h2>${m.title}</h2>
			<div class="movexp"><span>${m.genre }</span> | <span>${m.runtime }</span> 분 | <span>${m.repRlsDate } 개봉</span> | <span> 평점 ${l.avg } </span></div>
				<div class="intro">
					<div class="movtext">
						<div>감독 : ${m.directors }</div>
						<div class="more-actor">배우 : ${m.actors }</div>
						<button type="button" id="more" onclick="moreactor()">더보기</button>
						
						<div class="plot"> ${m.plots }</div>
					</div>
					<c:choose>
						<c:when test="${empty m.posters }">
							<img alt="" src="/jh/img/포스터 준비.png">
						</c:when>
						<c:otherwise>
							<img class="poster" alt="" src="${m.posters }">
						</c:otherwise>
					</c:choose>
 					
				</div>			
		<%@ include file="./Like.jsp" %>
		<%@ include file="./Comment.jsp" %>
			</div>
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

	<script>
		function moreactor() {
			document.getElementsByClassName('more-actor')[0].style.height = "fit-content";
			document.getElementById("more").style.display = "none";
			
		}
	</script>
</body>
</html>