<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>			
<meta charset="UTF-8">
<title>리스트</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>
	<div id  = "wrap">
		<c:import  url  = "/WEB-INF/jsp/include/header.jsp"></c:import>
			
		<section class="d-flex justify-content-center">
			<div class="col-6">
			
			<!--  입력 상자  -->
				<div class="border rounded mt-3  bg-white">
					<div>
						<textarea class="form-control w-100 border-0 non-resize" rows=3 id="contentInput"></textarea>
					</div>
					<div class="d-flex justify-content-between m-2">
						<a href="#" id="imageIcon"><i class="bi bi-image big-icon text-dark"></i> </a>
						
						<input type="file" id="fileInput" class="d-none">
						
						<button class="btn btn-sm btn-info" id="uploadBtn">업로드</button>
					</div>
				</div>

				
					<c:forEach var="post" items="${postList }" >
				<!--  피드  -->
				<div class="card border rounded mt-3">
					<!-- 타이틀 -->
					<div class="d-flex justify-content-between p-2 border-bottom">
						<div>
							${ingstagram.userName }
						</div>
						<div class="more-icon" >
							<a class="text-dark" href="#"> 
								<i class="bi bi-three-dots-vertical"></i> 
							</a>
						</div>
					
						
					</div>
					<!--이미지 -->
					<div>
						<img src="${ingstagram.imagePath }" class="w-100 imageClick">
					</div>
					
					<!-- 좋아요 -->
					<div class="m-2">
						
						<a href="#" class="likeBtn" data-post-id="${ingstagram.id }"><i class="bi bi-heart heart-icon text-dark"></i></a>
						
						<span class="middle-size ml-1"> 좋아요 11개 </span>
					</div>
					
					<!--  content -->
					<div class="middle-size m-2">
						<b>${ingstagram.userName }</b> ${ingstagram.content }
					</div>
					
					<!--  댓글 -->
					
					<div class="mt-2">
						<div class=" border-bottom m-2">
							<!-- 댓글 타이틀 -->
							<div  class="middle-size">
								댓글
							</div>
						</div>
						
						<!--  댓글  -->
						<div class="middle-size m-2">
							
							<div class="mt-1">
								<b>바다</b> 우왁 거기가 어딘가여?
							</div>
							<div class="mt-1">
								<b>신보람</b> 혼자 가니 좋냐?
							</div>
							<div class="mt-1">
								<b>남라</b> 냠냠
							</div>
						</div>
						<!--  댓글  -->
						
						<!-- 댓글 입력 -->
						<div class="d-flex mt-2 border-top">
							<input type="text" class="form-control border-0" id="commentInput${ingstagram.id }">
							<button class="btn btn-info ml-2 commentBtn" data-post-id="${ingstagram.id }">게시</button>
						</div>
						<!-- 댓글 입력 -->
					</div>
					<!--  댓글 -->
				</div>
				</c:forEach>		
			</div>	
					
		</section>
		
		<c:import url = "/WEB-INF/jsp/include/footer.jsp" />
	</div>
</body>

<script>

	$(document).ready(function(){
		
		$("#commentBtn").on("click", function(){
			
			let postId = $(this).data("post-id");
			let comment = $("#commentInput" + postId).val();
			
			alert(postId + " " + comment);
			
			if(comment == "") {
				alert ("댓글을 입력하세요");
				return;
			}
			
			
			
			$.ajax({
				type: "post",
				url:"/ingstagram/list",
				data: {"id":id,"comment":comment},
				success:function(data) {
					location.reload();
				}else {
					alert("댓글 올리기 실패");
				},
				error() {
					alert("댓글 에러");
				}
				
				
				
			});
		});
		
		$(".likeBtn").on("click", function(e){
			
			e.preventDefault();
			
			let postid = $(this).data("post-id");
			
			$.ajax({
				type:"get",
				url:"/ingstagram/like",
				data:{"postId":postId},
				success:function(data) {
					
					if(data.result == "success") {
						location.reload();
					} else {
						alert("좋아요 실패");
					}
				},
				error:function() {
					alert("좋아요 에러");
				}
				
			});
			
			
		});
	});



</script>
</html>