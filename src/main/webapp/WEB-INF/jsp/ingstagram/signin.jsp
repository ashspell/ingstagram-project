<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
</head>
<body>
	<div id = "wrap">
		
		<c:import url = "/WEB-INF/jsp/include/header.jsp"></c:import>
		
		<section class ="justify-content-center">
			<div>
				<input type = "text" class ="form-control" placeholder ="아이디">
				<input type = "password" class = "form-control" placeholder = "비밀번호">
				<button type = "submit"  id = "loginBtn" class = "form-control btn btn-block btn-info">로그인</button> 			
			</div>
			
			<div class = "text-center">
				<a href = "/ingstagram/signup">회원가입</a>
			</div>
		</section>
		
		<c:import url = "/WEB-INF/jsp/include/footer.jsp"></c:import>
	</div>
	
	<script>
		$(document).ready(function(){
			$("#loginBtn").on("click",function(){
				
				
				
			});
			
		});
	
	</script>
</body>
</html>