<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<title>Free Home Shoppe Website Template | Home :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link type="text/css" href="/mall/resources/template/css/style.css" rel="stylesheet" media="all" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
<script type="text/javascript" src="/mall/resources/template/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/move-top.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easing.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/startstop-slider.js"></script>


<!-- 지도API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">

$(document).ready(function(){

	$("#product-register").on("click", function() {		
		//상품 등록 form 로드
		$("#main_loadForm").load("/mall/resources/pda/html/product-registerform.html")
	});
	
	$("#my-product").on("click", function() {		
		//상품 목록 form 로드
		$("#main_loadForm").load("/mall/resources/pda/html/product-list.html")
	});
	
/* 	var productNo = ${product.productNo};
	var productNo = ${product.arrPdaProductImageDto[0].productNo}
	var imageNo = ${product.arrPdaProductImageDto[0].imageNo}
	var oriName = ${product.arrPdaProductImageDto[0].oriName} ==> koala.jsp  
	alert(productNo);
	alert(imageNo);
	alert(fileName); */
	
	//수정 버튼 이벤트 적용
	$("#modifyBtn").on("click", function() {
		var productNo = ${product.productNo};
		doModify(productNo);
	});
	
	//삭제 버튼 이벤트 적용
 	$("#deleteBtn").on("click", function() {
 		var productNo = ${product.productNo};
 		alert("삭제 버튼 클릭됨")
		doDelete(productNo);
	});
	
    function doDelete(productNo) {
    	yes = confirm(productNo + '번 글을 삭제할까요?');
    	if (yes) {
    		location.href = '/mall/delete.action?productNo=' + productNo;
    	}
    } 
	
    function doModify(productNo) {
    	yes = confirm(productNo + '번 글을 수정하시겠습니까?');
    	if (yes) {
    		location.href = '/mall/modify.action?productNo=' + productNo;
    	}
    }
	
	
});
</script>



</head>
<body>
	<div class="container">
		<div class="header">
			
			<!-- header -->
			<jsp:include page="/WEB-INF/views/header.jsp" />

			<div class="header_slide">
			
				<!-- category -->
				<div class="header_bottom_left">
					<div class="categories">
						<ul>
							<h3>Categories</h3>
							<li><a id="product-register" href="#">상품 등록</a></li>
							<li><a id="my-product" href="#">내 상품 목록</a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
						</ul>
					</div>
				</div>
				<div class="header_bottom_right">
					<div class="slider">
						<div id="slider">
							<div id="mover">
								<div id="main_loadForm">
								
									<div id="registerProductForm">
										<form action="/mall/register.action" id="product-select" method="post" enctype="multipart/form-data">
											<!-- <input type="hidden" name="memberId" value="${ session.memberId }"> -->
											<div class="notice jumbotron">
												<h2>상품 상세</h2>
												<span>상품을 수정하거나 삭제할 수 있습니다.</span>
											</div>
											<div class="form-group">
												<label>상품 카테고리1</label>
												<select id="form_category1" name="category1" disabled="disabled" class="form-control categorylist">
													<option>${product.category1}</option>
												</select>
												<label>상품 카테고리2</label>
												<select id="form_category2" name="category2" disabled="disabled" class="form-control categorylist2">
													<option>${product.category2}</option>
												</select>
											</div>
											<div class="product-info">
												<div class="form-group">
													<span><label>상품명</label></span>
													<span><input id="form_name" name="name" readonly="readonly"  value="${product.name}" class="form-control"></span>
												</div>
												<div class="form-group">
													<span><label>가격 (원)</label></span>
													<span><input id="form_price" name="price" readonly="readonly" value="${product.price}" class="form-control"></span>
												</div>
												<div class="form-group">
													<span><label>수량</label></span>
													<span><input id="form_qty" name="qty" readonly="readonly" value="${product.qty}" class="form-control"></span>
												</div>
												<div class="selectImage">
													등록할 이미지를 선택하세요.<br>
													<input id="form_image" type="file" disabled="disabled" name="fileUp"><br>
													<input id="form_image2" type="file" disabled="disabled" name="fileUp"><br>
													<input id="form_image3" type="file" disabled="disabled" name="fileUp"><br>
												</div>
												<br>
												
											</div>
										</form>
										<button id="modifyBtn">상품 수정하기</button>
										<button id="deleteBtn">상품 삭제하기</button>
									</div> 						

								</div>
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

