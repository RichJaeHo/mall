<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<title>Free Home Shoppe Website Template | Home :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link type="text/css" href="/mall/resources/template/css/style.css" rel="stylesheet" media="all" />

<script type="text/javascript" src="/mall/resources/template/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/move-top.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easing.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/startstop-slider.js"></script>

<script type="text/javascript">
$(document).ready(function(){
		
});
</script>

</head>
<body>
	<div class="wrap">
		<div class="header">
			
			<!-- header -->
			<jsp:include page="/WEB-INF/views/header.jsp" />

			<div class="header_slide">
			
				<div class="header_bottom_left">
					<!-- product category -->
					<jsp:include page="/WEB-INF/views/productcategory.jsp" />
				</div>		
			
				<div class="header_bottom_right">
					<div class="slider">
						<div id="slider">
						
							<div id="mover">
								
								<!-- 카테고리 명 -->
								<div class="content_top">
									<div class="heading">
										<h4>주문목록</h4>
									</div>
									<div class="clear"></div>
								</div>	
							
								<!-- 오른쪽 상품공간 시작 -->
								
								
								<table class="table table-hover">
									<thead>
										<tr>
											<th>No</th>
											<th>주문일</th>
											<th>제품명</th>
											<th>가격</th>
											<th>수량</th>
											<th>받는분</th>
											<th>연락처</th>
											<th>주소</th>
											<th>배송상태</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${arrResult}">
											<tr id="tr_titleNo_" class="tr_row">
												<td>${item.orderListNo}</td>
												<td><fmt:formatDate value="${item.orderDate}" pattern="yyyy-MM-dd"/></td>
												<td>${item.name}</td>
												<td><fmt:formatNumber value="${item.price}" pattern="₩ #,###.##" /></td>
												<td>${item.qty}</td>
												<td>${item.reciever}</td>
												<td>${item.phone}</td>
												<td>${item.address1} ${item.address2} ${item.address3}</td>
												<td>${item.status}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
																
								
								<!-- 오른쪽 상품공간 종료 -->
								
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>
		
		
	</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/views/footer.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

