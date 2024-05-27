<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

		<script src="/jh/js/imrwnheader.js"></script>
        <div id="mySidenav" class="sidenav">
            <a href="<c:url value='/' />" id="logo" ><img src="/jh/img/IMRWN로고-removebg-preview.png" alt=""></a>
            <ul>
                <li><a href="<c:url value='/movie/search' />">영화 리뷰</a></li>
            </ul>
            <hr>
            <ul>
                <li><a href="<c:url value='/board/kor' />" id="first">한국 영화</a></li>
                <li><a href="<c:url value='/board/eng' />">미국 영화</a></li>
                <li><a href="<c:url value='/board/jpn' />">일본 영화</a></li>
                <li><a href="<c:url value='/board/eur' />">유럽 영화</a></li>
                <li><a href="<c:url value='/board/east' />">동양 영화</a></li>
            </ul>
        </div>

        <div class="topmenu">
                <div class="navbar">
                    <div id="searchbar">
                    	<form id="search" name="searchM" onsubmit="return false;">
	                        <button type="button" id="scicon"><img src="/jh/img/서치바.png" alt=""></button>>
	                        <input type="text" id="find">
	                        <a href="#" id="csicon"><img src="/jh/img/취소버튼.png" alt=""></a>
                    	</form>
                    </div>

                    <a href="javascript:;" id="info">검색</a>
	
                    <c:choose>
	                   	<c:when test="${not empty sessionScope.id }">
	                   		<a href="<c:url value='/myinfo' />">내 정보</a>
	                   	</c:when>
	                   	<c:otherwise>
	                   		<a href="<c:url value='/register/save' />">회원가입</a>
	                   	</c:otherwise>
                    </c:choose>
                   	<c:choose>
	                   	<c:when test="${not empty sessionScope.id }">
	                		<a href="<c:url value='/logout' />">로그아웃</a>
                       	</c:when>
	                   	<c:otherwise>
	                		<a href="<c:url value='/login' />">로그인</a>
                       	</c:otherwise>
                    </c:choose>
                  
                </div>
          </div>  

        
		 