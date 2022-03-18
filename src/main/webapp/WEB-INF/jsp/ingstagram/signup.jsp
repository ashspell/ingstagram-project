<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<c:import url = "/WEB-INF/jsp/include/header.jsp" />
	
	<section>
	<div class = "justify-content-center">
		<h1>회원가입</h1>
			<input type = "text"  id = "loginInput"class = "form-control" placeholder = "아이디">
			<button type = "submit"  id = "confirmBtn"class = "btn btn-info">중복확인</button>
			<input type = "password" id = "passwordInput"class = "form-control" placeholder = "비밀번호">
			<input type = "password" id = "confirmpassword" class = "form-control" placeholder = "비밀번호 확인">
			<input type = "text"  id = "emailInput"class = "form-control" placeholder = "이름">
			<input type = "text" id = "nameInput" class = "form-control" placeholder = "이메일">
			<button type = "submit" id = "signupBtn"class = "btn btn-info form-control">회원가입</button>
	</div>
	</section>
	
	<c:import url = "/WEB-INF/jsp/include/footer.jsp" />
	
	<script>
		$(document).ready(function(){
			$("#confirmBtn").on("click",function(){
					
				if("#confirmpassword" == "#passwordInput") {
					alert("패스워드가 일치합니다");
				} else {
					alert("패스워드가 일치하지않습니다");
				}
			});
		});
		
		$(document).ready(function(){
			$("#signupBtn").on("click",function(){
			
				
	
		
			});
		});
	
	</script>
</body>
</html>