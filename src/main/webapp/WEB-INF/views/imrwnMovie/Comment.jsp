<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
h3 {
	padding-left: 20px;
	padding-top: 20px;
	padding-bottom: 20px;
	font-size: 1.8em;
}
.cSpan {
    justify-content: center;
    align-items: center;
    display: flex;	
    width: 150px;
    text-align: center;
}
}
.clist {
	width: 800px;
}

#commentList {
	display: flex;
}
.comment {
    width: 550px;
    height: 150px;
    word-break: break-all;
    padding-top: 10px;
    padding-left: 10px;
    overflow: scroll;   
    -ms-overflow-style: none;
}
.comment::-webkit-scrollbar{
    display:none;
}
#sendBtn, .btn-default {
	width: 70px;
	height: 35px;
	margin-left: 10px;
	text-align: center;
	outline: none;
	background-color: #ddd;
	border: none;
	color: black;
	font-size: 14px;
	transition: 0.3s;
	border-radius: 8px;
}

#sendBtn {

}

#sendBtn:hover {
	background-color: rgb(229, 9, 20);
	color: white;
}

.commentAll {
	display: flex;
	flex-direction: column;
	width: 95%;
	margin-right: auto;
	margin-left: auto;
}

.send {
	display: flex;
	width: 100%;
	margin: 10px;
	align-items: center;
}

.commentAll input[type='text'], .form-control {
	height: 30px;
	display: inline-block;
	
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

.clist li {
	display: flex;
	margin-top: 10px;
	line-height: 30px;
	font-size: 15px;
	list-style-type: none;
}

.clist button {
	width: 40px;
	height: 35px;
	border: 1px solid #d3d3d3;
	background-color: #fff;
	margin-left: 10px;
}

#commentList {
	border-top: 2px solid #777;
	border-bottom: 2px solid #777;
	padding-bottom: 12px;
	width: 820px;
}

#comment {
	width: 550px;
	resize: none;
	padding: 0px;
	margin: 0px;
	border: 1px solid #777;
	color: white;
	background-color: black;
	line-height: 30px;
	outline: none;
	padding-top: 10px;
    padding-left: 10px;
    -ms-overflow-style: none;
}
#comment::-webkit-scrollbar{
 	display:none;
}

.commenter {
	padding-right: 10px;
}

.delBtn {
	color: black;
	outline: none;
	background-color: #ddd;
	border: none;
	color: black;
	text-align: center;
	font-size: 14px;
	transition: 0.3s;
	border-radius: 8px;
}

.delBtn:hover {
	background-color: rgb(229, 9, 20);
	color: white;
}

.modBtnb {
	color: black;
	outline: none;
	background-color: #ddd;
	border: none;
	color: black;
	text-align: center;
	font-size: 14px;
	transition: 0.3s;
	border-radius: 8px;
}

.modBtnb:hover {
	background-color: rgb(229, 9, 20);
	color: white;
}
.updateBtnb:hover {
	background-color: rgb(229, 9, 20);
	color: white;
}

.reg_date {
	padding-left: 20px;
	width: 110px;
}

.form-control {
	resize: none;
	height: 100px;
}
span{

</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<div class="commentAll">
		<h3>리뷰</h3>
		<div class="mod"></div>		
		<div class="send">
			<span class="cSpan">${member.nickName }</span>
			<textarea class="form-control" name="comment" id="comment">${r.review }</textarea>
			<c:choose>
				<c:when test="${not empty r.review}">
					<button class="btn btn-default modBtnb" id="modBtnb" type="button" name="inputMod">수정</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-default" id="sendBtn" type="button" name="inputMod">등록</button>
				</c:otherwise>
			</c:choose>
		</div>
		<div id="commentList"></div>

	</div>

	<script>
	let mno = "${param.mno}"
	
	let mode = false;
	
	let showList= function(mno){
		let review = $('input[name=comment]').val("");
		
        $.ajax({
            type:'GET',       // 요청 메서드
            url: '${pageContext.request.contextPath}/review?mno='+mno,  // 요청 URI
            success : function(result){
            	$("#commentList").html(toHtml(result));
            	/* if(result != ""){
            	$(".send").append(`<button class="btn btn-default modBtnb" id="modBtnb" type="button" name="inputMod">수정</button>`);
            	$("#sendBtn").hide();
            	} */
            },
            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
        
	}
	
	// 문서가 로드가 되었을 때 실행되는 함수 - main함수와 동일한 역할로 생각
	$(document).ready(function(){
			showList(mno);
			if($('textarea[name=comment]').val() != "") {

            	document.getElementById("comment").readOnly = true;

          //  	<button type = "button"  class="modBtnb">수정</button>
            	
			}
			
		    $("#sendBtn").click(function(){
		    	let btn = $(this);
		    	let review = $('textarea[name=comment]').val();
		    	if(review.trim()==''){
		    		alert("입력해주세요");
		    		return;
		    	}
		    	if(review.length >= 140) {
		    		alert("140자 이내로 입력해 주세요");
		    		return;
		    	}
		    	review = review.replace(/\n/g, '<br>');
		        $.ajax({
		            type:'POST',       // 요청 메서드
		            url: '${pageContext.request.contextPath}/review',  // 요청 URI
		            headers : {"Content-Type" : "application/json"},
		            data : JSON.stringify({ mno:mno , review:review }) ,// 전달 데이터
		            success : function(result){ // 요청이 성공일 때 실행되는 이벤트
		            	result = JSON.parse(result)
		            	$("#cntTxt").text("댓글 " + result.count);
		            	showList(mno);
		            	document.getElementById("comment").readOnly = true;
		            	$(".send").append(`<button class="btn btn-default modBtnb" id="modBtnb" type="button" name="inputMod">수정</button>`);
		            	$(".modBtnb").attr('data-rno', result.rno);
		            	sendBtn = btn.detach();
						
						
		            },
		            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
		        }); // $.ajax()
	    	});
	    
			// 리뷰 화면의 수정 버튼을 눌렀을 경우 
			$(".send").on("click", ".modBtnb" , (function(){
            	document.getElementById("comment").readOnly = false;
				$(".send").append(`<button class="btn btn-default updateBtnb" id="updateBtnb" type="button" name="inputMod">수정완료</button>`);
				$(".updateBtnb").attr('data-rno', $(this).attr('data-rno'));
				modBtnb = $(".modBtnb").detach();
				
			}));
			
		   // 수정 완료 버튼을 눌렀을 경우
		   $(".send").on("click", ".updateBtnb" , (function(){
				let review = $('textarea[name=comment]').val();
				review = review.replace(/\n/g, '<br>');
				let rno = $(this).attr('data-rno')==undefined? "${r.rno}" : $(this).attr("data-rno");
				if(review.trim()==''){
		    		alert("입력해주세요");
		    		return;
		    	}
			   	if(review.length >= 140) {
			    	alert("140자 이내로 입력해 주세요");
			    	return;
		    	}
		    	// 수정, input 메서드 보이지 않게 요소 숨김
		    	//제이쿼리 데이터나 이벤트는 삭제되지 않고, 계속 유지 append로 복구 가능
		    	let del = $("#recomment").detach();
		    	let btn = $("#modBtn").detach();
		    	$(".send").append(modBtnb);
		    	$(".updateBtnb").detach();
		    	document.getElementById("comment").readOnly = true;
		    	$.ajax({
		            type:'PATCH',       // 요청 메서드
		            url: '${pageContext.request.contextPath}/review/'+ rno,  // 요청 URI
		            headers : {"Content-Type" : "application/json"},
		            data : JSON.stringify({rno:rno, review:review}),
		            success :function(result){
		        		showList(mno);
		            },
		            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
		             // 에러가 발생했을 때, 호출될 함수
		        }); // $.ajax()
			}));// function()
		
		     
			//삭제 버튼은 동적으로 생성되는 버튼이므로 이벤트를 추가하기에 적합하지 않음
			//$(".delBtn").click(function(){
			//	showList(bno);
			//});
			$("#commentList").on("click", ".delBtn" , (function(){
			    	let rno = $(this).parent().attr('data-rno');	    	
			        $.ajax({
			            type:'DELETE',       // 요청 메서드
			            url: '${pageContext.request.contextPath}/review/' + rno+"?mno="+mno,  // 요청 URI
			            headers : {"Content-Type" : "application/json"},
			            success : function(result){
			            	showList(mno);

				            $("#cntTxt").text("댓글 수 " + result);
			            },
			            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
			        }); // $.ajax()
			       // alert("the request is sent")
			}));	
		}); //ready
	
		let toHtml =function(review){
			
			var today = new Date();
			var year = today.getFullYear();
			var month = today.getMonth()+1;
			var day = today.getDate();
			
			var todayStr = year+"-"+(("00"+month.toString()).slice(-2))+"-"+(("00"+day.toString()).slice(-2));
			
			
			let tmp ="<ul class=clist>"
			let len = review.length;
			review.forEach(function(review, i){
				tmp +='<li data-rno='+review.rno
				tmp +=' data-mno='+review.mno+'>'
				tmp +='<span class="commenter cSpan" style="width: 150px; padding-left: 10px;"> '+review.nickName+'</span>'
				tmp +='   <div class="comment"> '+review.review+' </div>'
				
				let regDate = new Date(review.regDate);
				let regYear = regDate.getFullYear();
				let regMonth = regDate.getMonth()+1;
				let regDay = regDate.getDate();
				let regHour = String(regDate.getHours()).padStart(2, "0");
				let regMin = String(regDate.getMinutes()).padStart(2, "0");
				
				let regDateStr = regYear +"-"+(("00"+regMonth.toString()).slice(-2))+"-"+(("00"+regDay.toString()).slice(-2));
				let regHourStr = regHour+":"+regMin;
				
				if(regDateStr === todayStr) {
					tmp +='<span class="reg_date cSpan">  '+ regHourStr +' </span>';
				} else {
					regDateStr = String(regYear).slice(-2) +"-"+(("00"+regMonth.toString()).slice(-2))+"-"+(("00"+regDay.toString()).slice(-2));
					
					tmp +='<span class="reg_date cSpan">  '+ regDateStr +' </span>';
				} 
				
 				/* if(review.reviewer == "${sessionScope.id}"){
					tmp +='<button type = "button" class="delBtn">삭제</button>'
					}  */
				tmp +='</li>'
				if(len-1 != i)
					tmp +='<hr style="border:1px solid white"></hr>'
				
					
			})
			return tmp +'</ul>';
		}
	
	</script>
</body>
</html>