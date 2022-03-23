<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
	<div id = "wrap">
		<c:import url = "/WEB-INF/jsp/include/header.jsp" />
			<section>
				<img src = ""  id = "imageInput"class = "form-control"> 
				<input type= text  id = "titleInput"class = "form-control mt-3">
				<i class="bi bi-person-circle"></i>
				<textarea  id = "contentInput"class = "form-control mt-3"></textarea>
				<button type = "submit" id = "uploadBtn"class = "btn btn-block btn-info form-control">업로드</button>
			</section>
		<c:import url= "/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	
	<script>
		$(document).ready(function(){
			$("#uploadBtn").on("click" ,function(){
				let imagePath = $("#imageInput").val();
				let title = $("#titleInput").val();
				let content = $("#contentInput").trim();
			
				if(title == "") {
					alert("제목을 입력하세요");
					return;
				}
				
				var formdata = new FormData();
				FormData.append("file", imageInput);
				FormData.append("title", titleInput);
				FormData.append("content", contentInput);
				
				
				
				$.ajax({
					type:"post",
					url : "/ingstagram/upload",
					data:{"imagePath":imagePath, "title":title, "content":content},
					enctype:"multipart/form-data",
					processdata:false,
					contentType:false,
					success:function(data) {
						if(data.result == "success") {
							alert("업로드 성공");
						}else{
							alert("업로드 실패");
						}
					},
					error:function() {
						alert("업로드 에러");
					}
					
				
				});
			});
		});
	
	
	
	
	</script>
</body>
</html>