<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <%-- 웹앱 아래 폴더만 적어도 된다! --%>
        <link rel="stylesheet" href="/jstl/style.css" type="text/css">

</head>
<body>

	<div id="wrap" class="container">
		<section class="contents d-flex">
			 <div class="menu bg-primary row">
			 	<div class="container">
			 		<img alt="기상청 로고" width="80%" src="data:image/png;base64,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">
			 	</div>
	                <ul class="nav flex-column">
	                   <li class="nav-item"><a class="nav-link text-white font-weight-bold" href="#">날씨</a></li>
	                   <li class="nav-item"><a class="nav-link text-white font-weight-bold" href="#">날씨 입력</a></li>
	                   <li class="nav-item"><a class="nav-link text-white font-weight-bold" href="#">테마날씨</a></li>
	                   <li class="nav-item"><a class="nav-link text-white font-weight-bold" href="#">관측 기후</a></li>
	                </ul>
	          	</div>
				<div class="information ml-5 table text-center d-block">
					
					<table>
						<h1 class="justify-content-start">과거 날씨</h1>
							<tr>
								<th>날짜</th>
								<th>날씨</th>
								<th>기온</th>
								<th>강수량</th>
								<th>미세먼지</th>
								<th>풍속</th>
							</tr>
							<c:forEach var="weatherhistory" items="${weatherhistoryList}" varStatus="status">
								<tr>
									<td><fmt:formatDate value="${weatherhistory.date }" pattern="yyyy년 M월 d일" /></td>
									<c:choose>
										<c:when test="${weatherhistory.weather eq '맑음'}">
											<td><img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg"></td>
										</c:when>
										<c:when test="${weatherhistory.weather eq '구름조금'}">
											<td><img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg"></td>
										</c:when>
										<c:when test="${weatherhistory.weather eq '흐림'}">
											<td><img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg"></td>
										</c:when>
										<c:when test="${weatherhistory.weather eq '비'}">
											<td><img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg"></td>
										</c:when>
										<c:otherwise>
											<td>${weatherhistory.weather}</td>
										</c:otherwise>
									</c:choose>									
									<td>${weatherhistory.temperatures }℃</td>
									<td>${weatherhistory.precipitation }mm</td>                          
									<td>${weatherhistory.microDust }</td>
									<td>${weatherhistory.windSpeed }km/h</td>
								</tr>
							</c:forEach>	
					</table>
				</div>
			
		</section>
	</div>



</body>
</html>