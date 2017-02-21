<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link type="text/css" href="/mall/resources/template/css/style.css" rel="stylesheet" media="all" />

<script type="text/javascript" src="/mall/resources/template/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/move-top.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easing.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/startstop-slider.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	//선택상품 페이지로 이동
	$(".productItem").on("click",function(event) {
		location.href="/mall/product/preview.action?boardNo=" + event.target.id.split("_")[1];
	});
	
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
										<h4>${repCategory}</h4>
									</div>
									<div class="clear"></div>
								</div>	
							
								<!-- 오른쪽 상품공간 시작 -->
								<c:forEach var="item" items="${arrResult}">
									<div class="grid_1_of_4 images_1_of_4">
										<a>
											<img id="productItem_${item.boardNo}" class="productItem" src="${item.fileName}" alt="" />
										</a>										
										<h2>${item.title}</h2>
										<div class="price-details">
											<div class="price-number">
												<p>
													<span class="rupees"><fmt:formatNumber value="${item.price}" pattern="₩#,###.##" /></span>
												</p>
											</div>
											<div class="add-cart">
												<h4>
													<a id="productItem_${item.boardNo}" class="productItem">상세보기</a>
												</h4>
											</div>
											<div class="clear"></div>
										</div>
									</div>
								</c:forEach>
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

