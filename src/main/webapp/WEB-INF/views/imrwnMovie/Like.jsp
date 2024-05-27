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

.likeAll {
    width: 50%;
    margin-right: auto;
    margin-left: 600px;
    margin-top: 20px;
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
 .rating__input {
	display: none; /* 라디오버튼 hide */
}
.rating__label {
	width: 12px; /* 원본 사이즈/2 */
	overflow: hidden;
	cursor: pointer;
	margin: 0px;
	padding: 0px;
}
.rating__label .star-icon {
	width: 12px; /* 원본 사이즈/2 */
	height: 24px;
	display: flex;
	position: relative;
	left: 0;
	background-image: url("/jh/img/star.svg");
	background-repeat: no-repeat;
}
.rating__label--full .star-icon {
	background-position: right;
}
.rating__label--half .star-icon {
	background-position: left;
}
.rating {
    display: flex;
    width: 200px;
    justify-content: center;
    height: 50px;
    margin-top: -30px;
}
.filled {
	background-image: url('/jh/img/fullstar.svg') !important;
}

.star{
display:flex

}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<body>

			<div class="likeAll">
				<c:choose>
					<c:when test="${empty like }">
						<a id="likeBtn" type="button" data-value="good" class="popcorn"><img id="likeImg" alt="" src="/jh/img/plus-black-symbol.png"></a>
					</c:when>
					<c:otherwise>
						<a id="likeBtn" type="button" data-value="nope" class="popcorn"><img id="likeImg" alt="" src="/jh/img/long-check-mark.png"></a>
					</c:otherwise>
				</c:choose>
			<div class="rating">
    			<label class="rating__label rating__label--half" for="starhalf">
        		<input type="radio" id="starhalf" class="rating__input" name="rating" value="0.5" ${lm.score eq 0.5 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--full" for="star1">
        		<input type="radio" id="star1" class="rating__input" name="rating" value="1" ${lm.score eq 1.0 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--half" for="starhalf2">
        		<input type="radio" id="starhalf2" class="rating__input" name="rating" value="1.5" ${lm.score eq 1.5 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--full" for="star3">
        		<input type="radio" id="star3" class="rating__input" name="rating" value="2" ${lm.score eq 2.0 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--half" for="starhalf4">
        		<input type="radio" id="starhalf4" class="rating__input" name="rating" value="2.5" ${lm.score eq 2.5 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--full" for="star5">
        		<input type="radio" id="star5" class="rating__input" name="rating" value="3" ${lm.score eq 3.0 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--half" for="starhalf6" >
        		<input type="radio" id="starhalf6" class="rating__input" name="rating" value="3.5" ${lm.score eq 3.5 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--full" for="star7">
        		<input type="radio" id="star7" class="rating__input" name="rating" value="4" ${lm.score eq 4.0 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--half" for="starhalf8">
        		<input type="radio" id="starhalf8" class="rating__input" name="rating" value="4.5" ${lm.score eq 4.5 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>
    			<label class="rating__label rating__label--full" for="star9">
        		<input type="radio" id="star9" class="rating__input" name="rating" value="5" ${lm.score eq 5.0 ? "checked" : "" }>
        		<span class="star-icon"></span>
    			</label>    			
			</div>				
		</div>
<script>
	mno = "${param.mno}";
	$(document).ready(function(){
	    $("#likeBtn").click(function(){
	    	let likeMode = document.getElementById("likeBtn").getAttribute('data-value');
	    	$.ajax({
	            type:'POST',       // 요청 메서드
	            url: '${pageContext.request.contextPath}/mlike/'+likeMode,  // 요청 URI
	            headers : {"Content-Type" : "application/json"},
	            data : JSON.stringify({ mno:mno}) ,// 전달 데이터
	            success : function(result){ // 요청이 성공일 때 실행되는 이벤트
	            	result = JSON.parse(result);
	            	 if(result.nextLikeMode == "nope") {
						$("#likeImg").attr("src", "/jh/img/long-check-mark.png");	
						document.getElementById("likeBtn").setAttribute('data-value','nope');
					}else {
						$("#likeImg").attr("src", "/jh/img/plus-black-symbol.png");
						document.getElementById("likeBtn").setAttribute('data-value','good');
					} 
		            $("#likeTxt").text("좋아요 " + result.count);
					
		            // $("#like2").load(window.location.href + ' #like2'); 
		    		// <span id="like2">좋아요 ${dto.likeCnt }</span> 
	            },
	            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
	        }); // $.ajax()
		});
	    
	    // 별점 기능
	    $(".rating__input").click(function(){
	    	let score =  $('input[name=rating]:checked').val();
	    	$.ajax({
	            type:'POST',       // 요청 메서드
	            url: '${pageContext.request.contextPath}/score',  // 요청 URI
	            headers : {"Content-Type" : "application/json"},
	            data : JSON.stringify({ score:score , mno:mno}) ,// 전달 데이터
	            success : function(result){ // 요청이 성공일 때 실행되는 이벤트

	            },
	            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
	        }); // $.ajax()
	    });
		
	 });

	const rateWrap = document.querySelectorAll('.rating'),
    label = document.querySelectorAll('.rating .rating__label'),
    input = document.querySelectorAll('.rating .rating__input'),
    labelLength = label.length,
    opacityHover = '0.5';

let stars = document.querySelectorAll('.rating .star-icon');

checkedRate();


rateWrap.forEach(wrap => {
    wrap.addEventListener('mouseenter', () => {
        stars = wrap.querySelectorAll('.star-icon');

        stars.forEach((starIcon, idx) => {
            starIcon.addEventListener('mouseenter', () => {
                if (wrap.classList.contains('readonly') == false) {
                    initStars(); // 기선택된 별점 무시하고 초기화
                    filledRate(idx, labelLength);  // hover target만큼 별점 active

                    // hover 시 active된 별점의 opacity 조정
                    for (let i = 0; i < stars.length; i++) {
                        if (stars[i].classList.contains('filled')) {
                            stars[i].style.opacity = opacityHover;
                        }
                    }
                }
            });

            starIcon.addEventListener('mouseleave', () => {
                if (wrap.classList.contains('readonly') == false) {
                    starIcon.style.opacity = '1';
                    checkedRate(); // 체크된 라디오 버튼 만큼 별점 active
                }
            });

            // rate wrap을 벗어날 때 active된 별점의 opacity = 1
            wrap.addEventListener('mouseleave', () => {
                if (wrap.classList.contains('readonly') == false) {
                    starIcon.style.opacity = '1';
                }
            });

            // readonnly 일 때 비활성화
            wrap.addEventListener('click', (e) => {
                if (wrap.classList.contains('readonly')) {
                    e.preventDefault();
                }
            });
        });
    });
});

// target보다 인덱스가 낮은 .star-icon에 .filled 추가 (별점 구현)
function filledRate(index, length) {
    if (index <= length) {
        for (let i = 0; i <= index; i++) {
            stars[i].classList.add('filled');
        }
    }
}

// 선택된 라디오버튼 이하 인덱스는 별점 active
function checkedRate() {
    let checkedRadio = document.querySelectorAll('.rating input[type="radio"]:checked');


    initStars();
    checkedRadio.forEach(radio => {
        let previousSiblings = prevAll(radio);

        for (let i = 0; i < previousSiblings.length; i++) {
            previousSiblings[i].querySelector('.star-icon').classList.add('filled');
        }

        radio.nextElementSibling.classList.add('filled');

        function prevAll() {
            let radioSiblings = [],
                prevSibling = radio.parentElement.previousElementSibling;

            while (prevSibling) {
                radioSiblings.push(prevSibling);
                prevSibling = prevSibling.previousElementSibling;
            }
            return radioSiblings;
        }
    });
}

// 별점 초기화 (0)
function initStars() {
    for (let i = 0; i < stars.length; i++) {
        stars[i].classList.remove('filled');
    }
}

</script>