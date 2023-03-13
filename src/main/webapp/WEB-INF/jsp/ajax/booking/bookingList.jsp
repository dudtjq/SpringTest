<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 목록</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	 <link rel="stylesheet" href="/jstl/bookingStyle.css" type="text/css">
	
</head>
<body>
	<div class="container">
		 <div class="text-center display-4">통나무 팬션</div>
                <nav class="mt-4">
                    <ul class="nav nav-fill">
                        <li class="nav-item"><a class="nav-link" href="#">팬션소개</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">객실보기</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">예약안내</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">커뮤니티</a></li>
                    </ul>
                </nav>
		
			<h2 class="text-center mt-3">예약 목록 보기</h2>
			<table class="table text-center">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
				
					<c:forEach var="booking" items="${bookingList}" varStatus="status">
					<tr>
						<td>${booking.name }</td>
						<td><fmt:formatDate value="${booking.date }" pattern="yyyy년 M월 d일" /></td>
						<td>${booking.day }</td>
						<td>${booking.headcount }</td>
						<td>${booking.phoneNumber }</td>
						<c:choose >
							<c:when test="${booking.state eq '대기중'}">
								<td class="text-info">${booking.state }</td>
							</c:when>
							<c:when test="${booking.state eq '확정'}">
								<td class="text-success">${booking.state }</td>
							</c:when>
							<c:otherwise>
								<td>${booking.state }</td>
							</c:otherwise>
						</c:choose>
						<td class="delete-btn btn bg-danger text-white btn-sm" data-booking-id="${booking.id }">삭제</td>
					</tr>		
					</c:forEach>
						
				</tbody>
			
			
			</table>
			
			<footer class="mt-3 ml-4">
                <address>
                    제주특별자치도 제주시 애월읍  <br>
                    사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
                    Copyright 2025 tongnamu All right reserved
                </address>

            </footer>
	
	</div>
	
	<script>
	
		$(document).ready(function(){
			// class로 설정을 해둔다 id로 해둘 경우에는 각각이 아닌 하나의 객체로 보기 때문에 class로 지정!!
			$(".delete-btn").on("click", function(){
				// $(this). 을 사용하여 사용자가 사용하려는 하나의 객체를 불러온다!
				// data-booking-id 에서 booking-id을 가로 안에 지정한다!
				let id = $(this).data("booking-id");

				$.ajax({
					type:"get"
					, url:"/ajax/booking/delete"
					, data:{"id":id}
					, success:function(data){
						if(data.result == "success"){
							// 삭제 location.reload(); 를 활용!!
							location.reload();
						}else{
							alert("삭제 실패");
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