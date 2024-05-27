<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
.clist {
	width: 800px;
}

#commentList {
	display: flex;
}

#sendBtn, .btn-default {
	width:70px;
	height: 35px;
	border:1px solid #d3d3d3;
	background-color:#fff;
	margin-left: 10px;
}

.commentAll {
	display: flex;
	flex-direction: column;
	width: 80%;
	margin-right: auto;
	margin-left: auto;
}

.send {
	display: flex;
	width:100%;
	margin:10px;
	align-items: center;
}

.commentAll input[type='text'], .form-control{
	height:30px;
	display:inline-block;
}
.mod {
	width: 800px;
	display: flex;
	justify-content: center;
	align-items: center;
}

#recomment {
	width: 700px;
}

#comment {
	width: 700px;
}

.clist li{
	margin-top:10px;
	line-height:30px;
	font-size:15px;
	list-style-type:none;
}
.commentAll h2{
	margin:10px;
}

.clist button  {
	width:40px;
	height: 35px;
	border:1px solid #d3d3d3;
	background-color:#fff;
	margin-left: 10px;
}
.popcorn {
	width: 80px;
	height: 130px;
	margin-left: 180px;
}
#likeBtn {
	background-color: black;
	border: none;
	text-align: center;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<body>

			<div class="commentAll">
				<c:choose>
					<c:when test="${empty like }">
						<a id="likeBtn" type="button" data-value="good" class="popcorn"><img id="likeImg" src="/jh/img/팝콘빈통.png" class="popcorn" alt=""></a>
					</c:when>
					<c:otherwise>
						<a id="likeBtn" type="button" data-value="nope" class="popcorn"><img id="likeImg" src="/jh/img/팝콘풀통.png" class="popcorn" alt=""></a>
					</c:otherwise>
				</c:choose>
					
			
		</div>
<script>

	
	
	
	
	$(document).ready(function(){
	    $("#likeBtn").click(function(){
	    	let likeMode = document.getElementById("likeBtn").getAttribute('data-value');
	    	$.ajax({
	            type:'POST',       // 요청 메서드
	            url: '${pageContext.request.contextPath}/like/'+likeMode,  // 요청 URI
	            headers : {"Content-Type" : "application/json"},
	            data : JSON.stringify({ bno:bno}) ,// 전달 데이터
	            success : function(result){ // 요청이 성공일 때 실행되는 이벤트
	            	result = JSON.parse(result);
	            	 if(result.nextLikeMode == "nope") {
						$("#likeImg").attr("src", "/jh/img/팝콘풀통.png");	
						document.getElementById("likeBtn").setAttribute('data-value','nope');
					}else {
						$("#likeImg").attr("src", "/jh/img/팝콘빈통.png");
						document.getElementById("likeBtn").setAttribute('data-value','good');
					} 
		            $("#likeTxt").text("좋아요 " + result.count);
					
		            // $("#like2").load(window.location.href + ' #like2'); 
		    		// <span id="like2">좋아요 ${dto.likeCnt }</span> 
	            },
	            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
	        }); // $.ajax()
		});
	    
	 });

</script>