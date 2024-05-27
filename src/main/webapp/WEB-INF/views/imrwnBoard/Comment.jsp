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

.clist {
	width: 800px;
}

#commentList {
	display: flex;
}

#sendBtn, .btn-default {
	width: 70px;
	height: 35px;
	border: 1px solid #d3d3d3;
	background-color: #fff;
	margin-left: 10px;
}

#sendBtn {
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

.comment {
	width: 500px;
	resize: none;
	padding: 0px;
	margin: 0px;
	border: 1px solid #777;
	color: white;
	background-color: black;
	line-height: 30px;
	outline: none;
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

.reg_date {
	padding-left: 20px;
	width: 110px;
}

.form-control {
	resize: none;
	height: 100px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<div class="commentAll">
		<h3>댓글</h3>
		<div class="mod"></div>
		<div id="commentList"></div>
		<div class="send">
			<textarea class="form-control" name="comment" id="comment"></textarea>
			<button class="btn btn-default" id="sendBtn" type="button">등록</button>
		</div>
	</div>

	<script>
	let bno = "${param.bno}"
	let mode = false;
	
	let showList= function(bno){
		let comment = $('input[name=comment]').val("");
		
        $.ajax({
            type:'GET',       // 요청 메서드
            url: '${pageContext.request.contextPath}/comments?bno='+bno,  // 요청 URI
            success : function(result){
				$("#commentList").html(toHtml(result));
            },
            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
        
	}
	
	// 문서가 로드가 되었을 때 실행되는 함수 - main함수와 동일한 역할로 생각
	$(document).ready(function(){
			showList(bno);
		    $("#sendBtn").click(function(){
		    	let comment = $('textarea[name=comment]').val();
		    	if(comment.trim()==''){
		    		alert("입력해주세요");
		    		return;
		    	}
		    	comment = comment.replace(/\n/g, '<br>');
		        $.ajax({
		            type:'POST',       // 요청 메서드
		            url: '${pageContext.request.contextPath}/comments',  // 요청 URI
		            headers : {"Content-Type" : "application/json"},
		            data : JSON.stringify({ bno:bno , comment:comment }) ,// 전달 데이터
		            success : function(result){ // 요청이 성공일 때 실행되는 이벤트
		            	result = JSON.parse(result)
		            $("#cntTxt").text("댓글 " + result.count);
		            	showList(bno);
		            	document.getElementById("comment").value = "";
		            },
		            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
		        }); // $.ajax()
	    	});
	    
			// 각 버튼의 수정 버튼이 눌렀을 경우 
			$("#commentList").on("click", ".modBtnb" , (function(){
		    	let cno = $(this).parent().attr('data-cno');
		    	let bno = $(this).parent().attr('data-bno');
		    	let updateBtn = document.getElementById("modBtn");
				// 요소 추가 (수정버튼, input)
				if(updateBtn == null){
				$(".mod").append('<textarea class="form-control" name="recomment" id="recomment"></textarea>');
				$(".mod").append('<button class="btn btn-default btns2" id="modBtn" type="button">수정</button>');
				//텍스트 가져오기 (해당 수정글에))	
				let comment = $('textarea[name=recomment]').val($('div.comment', $(this).parent()).html().replace(/(<br>|<br\/>|<br \/>)/g, '\r\n'));
				
				//수정 댓글 번호를 저장하기
			    $("#modBtn").attr('data-cno', cno);
				}
			}));
			
		   // 등록 옆에 수정 버튼을 눌렀을 경우
			$(".mod").on("click", "#modBtn" , (function(){
				let comment = $('textarea[name=recomment]').val();
				comment = comment.replace(/\n/g, '<br>');
		    	if(comment.trim()==''){
		    		("입력해주세요");
		    		return;
		    	}alert
		    	let cno = $("#modBtn").attr('data-cno');
		    	// 수정, input 메서드 보이지 않게 요소 숨김
		    	//제이쿼리 데이터나 이벤트는 삭제되지 않고, 계속 유지 append로 복구 가능
		    	let del = $("#recomment").detach();
		    	let btn = $("#modBtn").detach();
		    	$.ajax({
		            type:'PATCH',       // 요청 메서드
		            url: '${pageContext.request.contextPath}/comments/'+ cno,  // 요청 URI
		            headers : {"Content-Type" : "application/json"},
		            data : JSON.stringify({cno:cno, comment:comment}),
		            success :function(result){
		        		showList(bno);
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
			    	let cno = $(this).parent().attr('data-cno');	    	
			        $.ajax({
			            type:'DELETE',       // 요청 메서드
			            url: '${pageContext.request.contextPath}/comments/' + cno+"?bno="+bno,  // 요청 URI
			            headers : {"Content-Type" : "application/json"},
			            success : function(result){
			            	showList(bno);

				            $("#cntTxt").text("댓글 수 " + result);
			            },
			            error: function(request, status, error){ alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error) } // 에러가 발생했을 때, 호출될 함수
			        }); // $.ajax()
			       // alert("the request is sent")
			}));	
		}); //ready
	
		let toHtml =function(comments){
			
			var today = new Date();
			var year = today.getFullYear();
			var month = today.getMonth()+1;
			var day = today.getDate();
			
			var todayStr = year+"-"+(("00"+month.toString()).slice(-2))+"-"+(("00"+day.toString()).slice(-2));
			
			
			let tmp ="<ul class=clist>"
			comments.forEach(function(comment){
				tmp +='<li data-cno='+comment.cno
				tmp +=' data-bno='+comment.bno+'>'
				tmp +='<span class="commenter" style="width: 150px; padding-left: 10px; "> '+comment.nickName+'</span>'
				tmp +='   <div class="comment" style="line-height: 20px;" readonly> '+comment.comment+' </div>'
				
				let regDate = new Date(comment.regDate);
				let regYear = regDate.getFullYear();
				let regMonth = regDate.getMonth()+1;
				let regDay = regDate.getDate();
				let regHour = String(regDate.getHours()).padStart(2, "0");
				let regMin = String(regDate.getMinutes()).padStart(2, "0");
				
				let regDateStr = regYear+"-"+(("00"+regMonth.toString()).slice(-2))+"-"+(("00"+regDay.toString()).slice(-2));
				let regHourStr = regHour+":"+regMin;
				
				if(regDateStr === todayStr) {
					tmp +='<span class="reg_date">  '+ regHourStr +' </span>';
				} else {
					regDateStr = String(regYear).slice(-2)+"-"+(("00"+regMonth.toString()).slice(-2))+"-"+(("00"+regDay.toString()).slice(-2));
					tmp +='<span class="reg_date">  '+ regDateStr +' </span>';
				} 
				
				if(comment.commenter== "${sessionScope.id}"){
					tmp +='<button type = "button" class="delBtn">삭제</button>'
					tmp +='<button type = "button"  class="modBtnb">수정</button>'
				}
				tmp +='</li>'


					
			})
			return tmp +'</ul>';
		}
	
	</script>
</body>
</html>