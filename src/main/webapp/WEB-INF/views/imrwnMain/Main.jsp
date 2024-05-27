  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/imrwn.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

 	 <div id="content">
	 	<%@ include file = "../imrwnHeader.jsp" %>
	 	
		 <div id="main">
            <div id="slideshow">
                <div id="moviechart">
                    <h3><a href="#"  id="chart">무비 차트</a></h3>
                    <span id="movieCate"></span>
                </div>
                <!-- Slideshow container -->
                <div class="slideshow-container">

                    <!-- Full-width images with number and caption text -->

                
                    <!-- Next and previous buttons -->
                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>
                </div>
                <br>
                
            </div>
            <div id="hot">
                <input type="radio" id="tab1" name="tabs" checked>
                <label for="tab1">화제글</label>
                <input type="radio" id="tab2" name="tabs">
                <label for="tab2">공감글</label>
                
                <div id="fire" class="tabContent">
                    <h2>화제글</h2>
                    <ul>
						<c:forEach var="comment" items="${comment }">
						<li><a class="mainhotlist" href="<c:url value="/board/read?bno=${comment.bno }" />">[${comment.movieType eq "kor" ? "한국" : comment.movieType eq "eng" ? "미국" : comment.movieType eq "jpn" ? "일본" : comment.movieType eq "eur" ? "유럽" : comment.movieType eq "east" ? "동양" : "전체"}영화] ${comment.title }</a></li>
						</c:forEach>
                    </ul>  
                </div>
                <div id="good" class="tabContent">
                    <h2>공감글</h2>
                    <ul>
						<c:forEach var="like" items="${like }">
						<li><a class="mainhotlist" href="<c:url value="/board/read?bno=${like.bno }" />">[${like.movieType eq "kor" ? "한국" : like.movieType eq "eng" ? "미국" : like.movieType eq "jpn" ? "일본" : like.movieType eq "eur" ? "유럽" : like.movieType eq "east" ? "동양" : "전체"}영화] ${like.title }</a></li>
						</c:forEach>
                    </ul>
                </div>
            </div>
            <div id="today">
                <h2>오늘 뭐 볼까?</h2>
               
                <form id="suggestform" action="" onsubmit="return false;">
                <fieldset id="entryfield">
                    <input type="text" name="actor" class="actor" placeholder="배우"><label for="actor"> (이)가 나오는 영화</label>

                    <fieldset>
                        <legend>장르</legend>
                        <div class="container2">
                            <label class="container2">액션
                                <input type="checkbox" name="genre" value="액션">
                                <span class="checkmark2"></span>
                            </label>
                            
                            <label class="container2">멜로
                                <input type="checkbox" name="genre" value="멜로">
                                <span class="checkmark2"></span>
                            </label>
                            
                            <label class="container2">공포
                                <input type="checkbox" name="genre" value="공포">
                                <span class="checkmar2k"></span>
                            </label>
                            
                            <label class="container2">스릴러
                                <input type="checkbox" name="genre" value="스릴러">
                                <span class="checkmar2k"></span>
                            </label>                            
                            <label class="container2">SF
                                <input type="checkbox" name="genre" value="SF">
                                <span class="checkmar2k"></span>
                            </label>     
                                                      
                            <label class="container2">코미디
                                <input type="checkbox" name="genre" value="코메디">
                                <span class="checkmark2"></span>
                            </label>
                            <label class="container2">판타지
                                <input type="checkbox" name="genre" value="판타지">
                                <span class="checkmark2"></span>
                            </label>
                             <label class="container2">드라마
                                <input type="checkbox" name="genre" value="드라마">
                                <span class="checkmark2"></span>
                            </label>
                            
                        </div>
                    </fieldset>

                    <fieldset>
                        <legend>평점</legend>
                        <div class="custom-select" >
                            <select name="rating">
                            <option value="0.5">0.5 점</option>
                            <option value="1">1 점</option>
                            <option value="1.5">1.5 점</option>
                            <option value="2">2 점</option>
                            <option value="2.5" >2.5 점</option>
                            <option value="3" selected>3 점</option>
                            <option value="3.5">3.5 점</option>
                            <option value="4">4 점</option>
                            <option value="4.5">4.5 점</option>
                            <option value="5">5 점</option>
                            </select>
                            
                            <label for="rating">이상인 영화</label>
                        </div>
                    </fieldset>

                    <div class="abc">
                        <button type="button" id="suggest">추천</button>
                    </div>
                </fieldset>

                </form>
                <div class="abc">
                   <a href="" id="suggestlink"><img src="/jh/img/포스터 준비.png" alt="" id="suggestMovie"></a>
                </div>

            </div>
            <div id="event">
                <h2>이벤트</h2>
                <div id="event_list">
                    <ul>
                        <li>추후 공지 예정입니다</li>
                    </ul>
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
      <script src="./js/imrwnMain.js"></script>
 	
</body>
</html>