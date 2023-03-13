<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 페이지</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
         
         <section class="section d-block">
         
                <div class="mt-4">
                    <h2 class="font-weight-bold text-center">예약하기</h2>
                </div>
                
                <div class="mt-3"><b>이름</b></div>
                <input id="nameInput" type="text" class="form-control mt-2">
   
                <div class="mt-3"><b>예약날짜</b></div>
                <input type="text" class="form-control mt-2" id="dateInput">

                <div class="mt-3"><b>숙박일수</b></div>
                <input type="text" class="form-control mt-2" id="dayInput">
                
                <div class="mt-3"><b>숙박인원</b></div>
                <input id="headcountInput" type="text" class="form-control mt-2" >
                
              	<div class="mt-3"><b>전화번호</b></div>
                <input id="phoneNumberInput" type="text" class="form-control mt-2" >
                
 			     <button type="button" class="form-control bg-warning mt-3" id="addBtn"><b>예약하기</b></button>
                

            </section>
         
         <footer class="mt-4 ml-4">
                <address>
                    제주특별자치도 제주시 애월읍  <br>
                    사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
                    Copyright 2025 tongnamu All right reserved
         		</address>
                </footer>       
             
    </div>    
            
	<script>
	
	$(document).ready(function(){
		
		// 데이트 피커 셋팅
        $( "#dateInput" ).datepicker({
            dateFormat: "yy년 mm월 dd일",
         });
			
		$("#addBtn").on("click", function(){
				
				let name = $("#nameInput").val();
				let date = $("#dateInput").val();
				let day = $("#dayInput").val();
				let headcount = $("#headcountInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				
				if(name == ""){
					alert("이름을 입력하세요.");
					return;
				}
				
				if(date == ""){
					alert("예약날짜를 입력하세요.");
					return;
				}
				
				if(day == ""){
					alert("숙박일수를 입력하세요.");
					return;
				}
				
				// lodgment 가 숫자면 입력된 경우
				// lodgment 에 숫가가 아닌 문자가 포함된 경우
				// Not a Number 의 약자이다!
				if(isNaN(day)){
					alert("숙박일수는 숫자만 입력 가능합니다.");
					return;
				}
				
				if(headcount == ""){
					alert("숙박인원을 입력하세요.");
					return;
				}
				
				if(isNaN(headcount)){
					alert("숙박인원은 숫자만 입력 가능합니다.");
					return;
				}
				
				if(phoneNumber == ""){
					alert("전화번호를 입력하세요.");
					return;
				}
				
				 if(!phoneNumber.startsWith("010"))   {
                     alert("010 으로 시작하는 번호만 입력가능합니다. ");
                     return;
                 }
				
				$.ajax({
					
					// type. url, data만 있어도 일단 호출은 가능하다!!
					type:"get"
					, url:"/ajax/booking/add"
					, data:{"name":name, "day":day, "date":date, "headcount":headcount, "phoneNumber":phoneNumber}
					, success:function(data){
				
						if(data.result == "success"){
					
							location.href = "/ajax/booking/list";
						
						}else{
							
							alert("예약 실패");
						}
			
					}
					, error:function(){
						alert("예약 에러");
					}
				
				});
	
				
			});
	
		});
	
	</script>
	
	
</body>
</html>