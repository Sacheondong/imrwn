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
<form id="fileFrm" name="fileFrm" enctype="multipart/form-data">
	<input type="text" name="content" value="${f.content }" readonly>
	<input type="text" name="fno" value="${f.fno }" readonly>
	<input type="text" name="fileName" value="${f.fileName }" readonly>
	<label for="lfileName" id="lfileName">${f.fileName }</label>
	<br>
	<input type="button" id="modifyBtn" value="수정">
	<input type="button" id="deleteBtnBoard" value="삭제">
	<div id="preview">
		<c:if test="${not empty f.fileName }">
			<img style="width: 200px; height: 200px" id="previewImg" src="/jh/resources/${f.fileName }">
		</c:if>
	</div>
</form>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script>
		
		$(document).ready(function(){
			$('#modifyBtn').click(function(){
				location.href="/bd/file/modify?fno=${param.fno}";
			});
			
			$('#deleteBtnBoard').click(function(){
				let frm = document.fileFrm;
				frm.action = '/bd/file/remove';
				frm.method="post";
				frm.submit();
			});
			
		});	// document ready END    
		</script>
</body>
</html>