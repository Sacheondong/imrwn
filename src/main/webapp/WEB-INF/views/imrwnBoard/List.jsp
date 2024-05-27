<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jh/css/imrwn.css">
<link rel="stylesheet" href="/jh/css/imrwnboard.css">
</head>
<body>
	<script>
		let msg = "${msg}";
		if (msg == "del")
			alert("성공적으로 삭제되었습니다.");
		if (msg == "suc")
			alert("게시물 등록 완료");
		if (msg == "error")
			alert("잠시 후 다시 시도 부탁드립니다.");
	</script>
	<div id="content">
		<%@ include file="../imrwnHeader.jsp"%>
		<div id="main" style="display: block; background-color: black; color: white;">


			<h2>${movieType eq "kor" ? "한국" : movieType eq "eng" ? "미국" : movieType eq "jpn" ? "일본" : movieType eq "eur" ? "유럽" : movieType eq "east" ? "동양" : "전체"}
				영화</h2>

			<div id="movieCon">
				<table>
					<tr>
						<th class="board-no">번호</th>
						<th class="board-title">제목</th>
						<th class="board-like">좋아요</th>
						<th class="board-viewCnt">조회수</th>
						<th class="board-id">작성자</th>
						<th class="board-regDate">작성일</th>
					</tr>
					<c:choose>
						<c:when test="${empty list }">
							<tr>
								<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>

							<c:forEach var="blist" items="${ list }" varStatus="i">
								<tr>
									<td class="board-no">${ph.totalCnt -i.index - ph.sc.offset }</td>
									<td class="board-title"><a
										href="<c:url value='/board/read${ph.sc.getQueryString()}&bno=${blist.bno }'/>">${blist.title }<span
											id="comCnt">${blist.commentCnt !=0 ? [ blist.commentCnt ] : "" }</span></a></td>
									<td class="board-like">${blist.likeCnt }
									<td class="board-viewCnt">${blist.viewCnt }</td>
									<td class="board-id">${blist.nickName }</td>
									<fmt:formatDate value="${blist.postDate}" type="both"
										pattern="yyyy-MM-dd" var="postdate" />
									<fmt:formatDate value="${blist.postDate}" type="both"
										pattern="HH:mm" var="posttime" />
									<c:choose>
										<c:when test="${postdate eq now }">
											<td class="board-regDate">${posttime }</td>
										</c:when>
										<c:otherwise>
											<td class="board-regDate">${postdate }</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
				<div class="btn" id="movieWirteBtn">
					<button type="button" onclick="location.href='<c:url value="/board/write?movieType=${movieType }" />'"
						id="writeBtn">글쓰기</button>
				</div>
			</div>

			<div class="navpl">
				<c:if test="${ph.showPrev }">
					<a
						href="<c:url value='/board/${movieType }${ph.sc.getQueryString(ph.beginPage-1) }'/>">&laquo;</a>
				</c:if>
				<c:forEach var="i" begin="${ph.beginPage }" end="${ph.endPage }">
					<a class='${ph.sc.page== i ? "check" : "" }'
						href="<c:url value='/board/${movieType }${ph.sc.getQueryString(i) }'/>">${i}</a>
				</c:forEach>
				<c:if test="${ph.showNext }">
					<a
						href="<c:url value='/board/${movieType }${ph.sc.getQueryString(ph.endPage+1) }'/>">&raquo;</a>
				</c:if>
			</div>



			<form>
				<select name="option" class="searchF">
					<option value="A" ${ph.sc.option == 'A' || ph.sc.option == null ? "selected" : "" }>제목 + 내용</option>
					<option value="T" ${ph.sc.option == 'T' ? "selected" : "" }>제목</option>
					<option value="C" ${ph.sc.option == 'C' ? "selected" : "" }>내용</option>
					<option value="W" ${ph.sc.option == 'W' ? "selected" : "" }>글쓴이</option>
				</select> <input type="text" class="searchF" name="keyword"
					value="${empty param.keyword? '' : param.keyword}">
				<button type="submit" id="searchBtn">검색</button>
			</form>


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