<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
     
</head>
<body>
	<c:import url = "/WEB-INF/jsp/include/header.jsp" />
	
	<div id = "wrap">
	<section>
	<div class = "justify-content-center">
		<h1>회원가입</h1>
			<input type = "text"  id = "loginInput"class = "form-control mt-3" placeholder = "아이디">
			<button type = "button"  id = "confirmBtn"class = "btn btn-info mt-3">중복확인</button>
				<div id="duplicateText" class="d-none"><small class="text-danger">중복된 ID 입니다</small></div>
				<div id="possibleText" class="d-none"><small class="text-success">사용가능한 ID 입니다</small></div>
			<input type = "password" id = "passwordInput"class = "form-control mt-3" placeholder = "비밀번호">
			<input type = "password" id = "confirmpassword" class = "form-control mt-3" placeholder = "비밀번호 확인">
			<input type = "text"  id = "emailInput"class = "form-control mt-3" placeholder = "이메일">
			<input type = "text" id = "nameInput" class = "form-control mt-3" placeholder = "이름">
			<button type = "button" id = "signupBtn"class = "btn btn-info form-control mt-3">회원가입</button>
	</div>
	</section>
	
	<c:import url = "/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function(){
			
			var isChecked = false;
			
			var isDuplicate = true;
			
			$("#loginInput").on("input", function() {
				isChecked = false;
				isDuplicate = true;
				
				$("#duplicateText").addClass("d-none");
				$("#possibleText").addClass("d-none");
			});			


			$("#signupBtn").on("click",function(e){
				
				e.preventDefault();
				
				var loginid = $("#loginInput").val();
				var password = $("#passwordInput").val();
				var confirmpassword = $("#confirmpassword").val();
				var email = $("#emailInput").val().trim();
				var name = $("#nameInput").val().trim();
			
				if(loginid == "") {
					alert("아이디를 입력하세요");
					return;
				}
				if(!isChecked) {
					alert("중복체크를 하지 않았습니다");
					return ;
				}
				
				if(isDuplicate) {
					alert("중복된 아이디 입니다");
					return ;
				}
				if(password == "") {
					alert("비밀번호를 입력하세요");
					return;
				}	
				
				if(password != confirmpassword) {
					alert("비밀번호를 확인하세요");
					return ;
				}
				
				if(email == "") {
					alert("이메일을 입력하세요");
					return;
				}
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				
				$.ajax({
					type: "post",
					url: "/ingstagram/signup",
					data:{"loginid":loginid, "password":password, "email":email, "name":name},
					success:function(data) {
						if(data.result == "success") {
							location.href= "/ingstagram/signin_view";
						}else{
							alert("가입 실패");
						}
					},
					
					error:function(e) {
						alert("가입 에러");	
					}
					
					
					
				});
			
			});
			
			
			
		
			
			
			$("#confirmBtn").on("click", function(){
				var loginid = $("#loginInput").val();
				
				if(loginid == "") {
					alert("아이디를 입력하세요");
					return ;
				}
				
				$.ajax({
					type:"get",
					url:"/ingstagram/duplicate_id",
					data:{"loginid":loginid},
					success:function(data) {
						
						isChecked = true;

						$("#duplicateText").addClass("d-none");
						$("#possibleText").addClass("d-none");
						
						if(data.is_duplicate) {
							$("#duplicateText").removeClass("d-none");
						} else {
							$("#possibleText").removeClass("d-none");
						}
						
						isDuplicate = data.is_duplicate;
						
					}, 
					error:function() {
						alert("중복확인 에러");
					}
					
				});
					
			});	
	});
		

	
	</script>
</body>
</html>