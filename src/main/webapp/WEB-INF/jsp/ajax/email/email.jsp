<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>email</title>

		<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
	
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	
	<div class="container">
		<table class="table text-center">
			<h1>즐겨 찾기 목록</h1>
				<thead>
					<tr>
						<th>No.</th>
						<th>이름</th>
						<th>주소</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="email" items="${emailList }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${email.name }</td>
							<td>${email.url }</td>
							<td class="delete-btn btn bg-danger text-white btn-sm" data-email-id="${email.id }">삭제</td>
						</tr>
					</c:forEach>
	
				</tbody>
		
		</table>
		
	
	
	</div>
	
	<script>
	
		$(document).ready(function(){
			
			$(".delete-btn").on("click", function(){
				
				// 가지고 하려고 하는 값을 객채화 한다$(this)
				let id = $(this).data("email-id");
			//	alert(id);
				
				$.ajax({
					type:"get"
					, url:"/ajax/email/delete"
					, data:{"id":id}
					, success:function(data){
						if(data.result == "success"){
							// 삭제
							location.reload();
						}else{
							alert("삭제 에러");
						}
						
					}
					, error:function(){
						alert("삭제 에러");
					}
					
					
				});

			});
			
		});
	
	
	</script>


</body>
</html>