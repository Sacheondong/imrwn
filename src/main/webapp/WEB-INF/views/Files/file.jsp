<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <!-- 실제 파일 정보가 저장됨  -->
	<input type="file" name="uploadFile" id="uploadFile"  accept="image/${ empty b.fileName ? '*' : b.fileName}"/>
	<br>
   <!-- 파일 이름이 저장됨 -->
	<input type="hidden" name="fileName" id="fileName" value="">
	<input type='hidden' name="fileEx" id="fileEx" value="0"><!--file등록여부 : 1 (등록)  0 (등록x)  -->
	<div id="preview"><img style="width: 200px; height: 200px;" id="previewImg" src="/jh/${ empty b.fileName ? 'pngwing.png' : b.fileName}"></div>

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script>
		$(document).ready(function(){
			//file업로드에서 변화가 있을 때 실행
		    $('#uploadFile').on('change', function() {
		    	let inputFile = $(this)
		    	console.log(inputFile)
		    	console.log(inputFile[0].files[0]) // 배열형태로 값을 가져오기 때문에, dom element에 접근위해서는 인덱스 활용
		        $('#fileName').val(inputFile[0].files[0].name);
		        $('#lfileName').text(inputFile[0].files[0].name);
		        $('#fileEx').val("1");
		      
		        
		        if(inputFile[0].files[0].length!=0){
		        	$("#del").val(1)
		        	let render = new FileReader();
		        	render.onload = function(e){
		        		console.log(e.target.result)
		        		$("#previewImg").attr("src", e.target.result);
		        	};
		        	render.readAsDataURL(inputFile[0].files[0]);
		        }else{
		        	$("#previewImg").attr("src", "");
		        	$("#del").val(2)
		        }
		    });			
		});	// document ready END    
		</script>
</body>
</html>