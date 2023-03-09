<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>email Input</title>

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<label>제목</label>
		<input type="text" name="name" id="nameInput" class="form-control"> <br>
		<label>주소</label> <br>
		<div class="d-flex">
			<input type="text" name="url" id="urlInput" class="form-control col-11">
			<button type="button" id="duplicateBtn" class="text-white bg-info form-control col-1">중복확인</button>  <br>
		</div>
		
		<div class="d-block">
			<div class="text-danger small d-none" id="urlText1">중복된 url 입니다.</div>
			<div class="text-danger small d-none" id="urlText2">사용 가능한 url 입니다.</div>
		</div>

		<button type="button" class="form-control bg-success mt-3" id="addBtn">추가</button>
	
	
	
	</div>

	<script>
	
		$(document).ready(function(){
			
			$("#duplicateBtn").on("click", function(){
				
				let url = $("#urlInput").val();
				
				
				if(url == ""){
					alert("주소를 입력하세요.");
					return;
				}
				
				if(!url.startsWith("http://") && !url.startsWith("https://")){
					
					alert("잘못된 주소 경로입니다.");
					return;
					
				}
				
				$.ajax({
					type:"Post"
					, url:"/ajax/email/is_duplicate"
					, data:{"url":url}
					, success:function(data){
						if(data.is_duplicate){
							// 중복된 경우
							$("#urlText1").removeClass("d-none");
							$("#urlText2").addClass("d-none");
						}else{
							// 중복이 안된 경우
							$("#urlText2").removeClass("d-none");
							$("#urlText1").addClass("d-none");
						}
					}
					, error:function(){
						alert("중복확인 에러");
					}
					
					
				});
		
			});
			
			
			
			
			$("#addBtn").on("click", function(){
				
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				if(name == ""){
					alert("이름을 입력하세요.");
					return;
				}
				
				if(url == ""){
					alert("주소를 입력하세요.");
					return;
				}
				
				if(!url.startsWith("http://") && !url.startsWith("https://")){
					
					alert("잘못된 주소 경로입니다.");
					return;
					
				}
				
				
				$.ajax({
					
					type:"get"
					, url:"/ajax/email/add"
					, data:{"name":name, "url":url}
					, success:function(data){
						
						if(data.result == "success"){
							location.href = "/ajax/email/email";
						}else{
							alert("추가 실패");
						}
			
					}
					, error:function(){
						alert("추가 에러");
					}
				
				});
				
			});
			
		});
	
	</script>


</body>
</html>