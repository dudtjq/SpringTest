<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 팬션</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <link rel="stylesheet" href="/jstl/bookingStyle.css" type="text/css">
</head>
<body>

	 <div id="wrap" >
            <header class="mt-4">
                <div class="text-center display-4">통나무 팬션</div>
                <nav class="mt-4">
                    <ul class="nav nav-fill">
                        <li class="nav-item"><a class="nav-link" href="#">팬션소개</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">객실보기</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">예약안내</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">커뮤니티</a></li>
                    </ul>
                </nav>
            </header>

            <section class="banner">
                <img  width="1200" height="400" src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg" id="bannerImage">
            </section>
            <sction class="d-flex">
                <article class="reservation d-flex justify-content-center align-items-center">
                    <div class="display-4">
                        실시간 <br>
                        예약 하기 
                    </div>
                </article>
                <article class="reservation-confirm">
                    <div class="m-4">
                        <div class="d-flex align-items-end">
                            <h3 class="mr-4">예약 확인</h3>
                       
                        </div>
                        <div class="member-input mt-3" id="member">
                            <div class="input-gorup form-inline">
                                <label class="input-label">이름 :</label>
                                <input type="text" class="form-control text-input" id="nameInput">
                            </div>
                            <div class="input-gorup form-inline mt-3">
                                <label class="input-label">전화번호 :</label>
                                <input type="text" class="form-control text-input" id="phoneNumberInput">
                            </div>

                        </div>

                        <div class="d-flex justify-content-end">
                            <button class="btn btn-success mt-3 mr-5" id="findBtn">조회 하기</button>
                        </div>
                    </div>
                </article>
                <article class="reservation-call d-flex justify-content-center align-items-center">
                    <div>
                        <h3>예약문의 : </h3>
                        <h1>010-</h1>
                        <h1>000-1111</h1>
                    </div>
                </article>
            </sction>

            <footer class="mt-3 ml-4">
                <address>
                    제주특별자치도 제주시 애월읍  <br>
                    사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
                    Copyright 2025 tongnamu All right reserved
                </address>

            </footer>


        </div>

    <script>
        $(document).ready(function() {

        	
        	$("#findBtn").on("click", function() {
				let name = $("#nameInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				if(name == "") {
					alert("이름을 입력하세요");
					return ;
				}
				
				if(phoneNumber == "") {
					alert("전화번호를 입력하세요");
					return ;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/booking/search"
					, data:{"name":name, "phoneNumber":phoneNumber}
					, success:function(data) {
						// result가 success 면 조회 결과 있다. 
						// fail 이면 없다. 
						
						if(data.result == "fail") {
							alert("조회된 결과가 없습니다");
						} else {
							let message = "이름 : " + data.info.name + "\n날짜 : " + data.info.date.substring(0, 10)
							+ "\n일수 : " + data.info.day + "\n인원 : " + data.info.headcount + "\n상태 : " + data.info.state;
							
							alert(message);
						}
						
						
					}
					, error:function() {
						alert("조회 에러");
					}
				});
        	});
        	
        	
        	
            // 데이트 피커 셋팅
            $( "#date" ).datepicker({
                minDate:0, 
                dateFormat: "yyyy년 mm월 dd일",
            });

            $("#lookupBtn").on('click', function() {
                if($("input[name=type]:checked").val() == "member") {

                    // 회원 입력 항목 유효성 검사 
                    if($("#name").val() == '')   {
                        alert("아이디를 입력하세요.");
                        return;
                    }

                    if($("#phoneNumber").val() == '')   {
                        alert("비밀번호를 입력하세요.");
                        return;
                    }

                    alert("조회 성공");

                } 
            });

            var bannerList = ["http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg"
            	, "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner2.jpg"
            	, "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner3.jpg"
            	, "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner4.jpg"];
            var currentImageIndex = 0;
            setInterval(function() {
                $("#bannerImage").attr("src", bannerList[currentImageIndex]);
                currentImageIndex++;

                if(currentImageIndex == bannerList.length) {
                    currentImageIndex = 0;
                }
            }, 3000); 
        } );
    </script>


</body>
</html>