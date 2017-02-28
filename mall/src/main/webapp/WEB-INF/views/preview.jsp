<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link type="text/css" href="/mall/resources/template/css/style.css" rel="stylesheet" media="all" />
<link type="text/css" href="/mall/resources/template/css/easy-responsive-tabs.css" rel="stylesheet" media="all" />
<link type="text/css" href="/mall/resources/template/css/global.css" rel="stylesheet">

<script type="text/javascript" src="/mall/resources/template/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/move-top.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easing.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easyResponsiveTabs.js"></script>

<script src="/mall/resources/template/js/slides.min.jquery.js"></script>

<script type="text/javascript">
   $(document).ready(function () {
       
	   function numberWithCommas(x) {
		    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
	   
	   $('#horizontalTab').easyResponsiveTabs({
           type: 'default', //Types: default, vertical, accordion           
           width: 'auto', //auto or any width like 600px
           fit: true   // 100% fit in a container
       });
       
       $(function(){
    	   funcImgView();
    	});
       
       function funcImgView(){
	       $('#products').slides({
				/* preload: true, */
				preloadImage: 'img/loading.gif',
				effect: 'slide, fade',
				crossfade: true,
				slideSpeed: 350,
				fadeSpeed: 250,
				/* generateNextPrev: true, */
				generatePagination: false 
			});
       }
       
       
       //카트에담기 이벤트
       $("#btn_addToCart").on("click", function() {
    	   
    	   var arrCartData = [];
    	   
    	   var arrAddedItem = $(".hidden_addedItemRow");
    	   for(var i = 0; i < arrAddedItem.length; i++) {
    		   
    		   var cartData = [];
    		   cartData[0] = arrAddedItem[i].cells[0].innerText; //productNo
    		   cartData[1] = arrAddedItem[i].cells[1].innerText; //name
    		   cartData[2] = arrAddedItem[i].cells[2].innerText; //qty
    		   
    		   arrCartData[i] = cartData;
    	   }
    	   
    	 	//카트에 데이터 보내기
			 $.ajax({
				url:"/mall/mycart/addproduct.action",      
			    type:"POST",
			    data:{
			    	cartData : JSON.stringify(arrCartData)			    	
			    },
			    dataType:'text',
			    success:function(json){
			    	var confirmIs = confirm("카트에 선택된 제품을 넣었습니다. \n\n내 카트로 이동 할까요?");
			    	if(confirmIs) {
			    		location.href='/mall/mycart.action';
			    	}
			    },
			    error:function(request,status,error){  
			    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			});    	  
       }); 
             
       
       //추가버튼 클릭시 추가
       $("#btn_addSelectedItem").on("click", function(){
    	   
    	   $("#tbody_addedItem").append(
    		   $("<tr></tr>").addClass("hidden_addedItemRow").append(
		    		$("<td></td>").text($("#hidden_productNo").val())
		    	).append(
		    		$("<td></td>").text($("#hidden_name").text())
		    	).append(
		    		$("<td></td>").text($("#hidden_qty").val())
				).append(
		    		$("<td></td>").append(
		    				$("<a></a>").addClass("btnDelAddedItem btn btn-default btn-sm").text("취소")		    				
		    		)
    	   		)
    		);
    	   
    	   //취소버튼 클릭시
    	   $(".btnDelAddedItem").on("click", function(){
    		   $(this).closest("tr").remove();
    	   });    	   
       });
       
       //상품선택시
       $(".selItemNo").on("click", function(event){
    	   
    	 	//선택된 상품정보 조회
			$.ajax({
				url:"/mall/product/productinfo.action",      
			    type:"GET",
			    data:{
			    	productNo : event.target.id.split("_")[1]	    	
			    },
			    dataType:'JSON',
			    success:function(json){
			    	
			    	//이미지 세팅
			    	setImageOfProduct(json);
			    },
			    error:function(request,status,error){  
			    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			});
       });
       
       //대표상품 이미지
       function setPreImageOfProduct() {
    	 	//선택된 상품정보 조회
			$.ajax({
				url:"/mall/product/productinfo.action",      
			    type:"GET",
			    data:{
			    	productNo : $("#hidden_productNo").val()	    	
			    },
			    dataType:'JSON',
			    success:function(json){
			    	
			    	//이미지 세팅
			    	setImageOfProduct(json);
			    },
			    error:function(request,status,error){  
			    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			});
       }
       
       
       function setImageOfProduct(json) {
    	   $("#hidden_productNo").val(json.productNo);
	    	$("#hidden_name").text(json.name);
	    	$("#hidden_price").text("₩ " + numberWithCommas(json.price));
	    	
	    	$("#hidden_imageDiv").empty();
	    	$("#hidden_imageUl").empty();
	    	for(var i = 0; i < json.arrPjhImageDto.length; i++) {
	    		
	    		//큰이미지 넣기
		    	$("#hidden_imageDiv").append(
	    			$("<a></a>").attr("href","#").append(
	    				$('<img src="'+ json.arrPjhImageDto[i].fileName +'" />').attr("alt", " ")	
	    			)			    			
		    	);
	    		
		    	//이미지 리스트 넣기
	    		$("#hidden_imageUl").append(
	    			$("<li></li>").append(
	    				$("<a></a>").attr("href","#").append(
			    			$('<img src="'+ json.arrPjhImageDto[i].fileName +'" />').attr("alt", " ")	
			    		)	
	    			)			
	    		);
	    	}
	    	
	    	//이미지뷰 이벤트 추가
	    	funcImgView();
       }
       
       
	    //연관상품상품 페이지로 이동
	   	$(".productItem").on("click",function(event) {
	   		location.href="/mall/product/preview.action?boardNo=" + event.target.id.split("_")[1];
	   	});
       
       
	   	setPreImageOfProduct();
   });
</script>
   
   
</head>
<body>
	<div class="wrap">
		<div class="header">

			<jsp:include page="/WEB-INF/views/header.jsp" />

		</div>
		<div class="main">
			<div class="content">
				<div class="content_top">
					<input id="hidden_memberId" type="hidden" value="${session.memberId}">
					<input id="hidden_productNo" type="hidden" value="${result.preProductNo}">					
				</div>
				
				<div class="section group">
					<div class="cont-desc span_1_of_2">
						<div class="product-details">
						
							<div class="grid images_3_of_2">
								<div id="container">
									<div id="products_example">
										<div id="products">
												
											<!-- 대표사진 -->	
											<div id="hidden_imageDiv" class="slides_container">
												<a href="#"><img src="${result.fileName}" alt=" " /></a>
											</div>
											
											<!-- 선택사진 -->
											<ul id="hidden_imageUl" class="pagination">
												<li><a href="#"><img src="${result.fileName}" alt=" " /></a></li>
											</ul>
											
										</div>
									</div>
								</div>
							</div>
							
							<div class="desc span_3_of_2">
								
								<h2>${result.title}</h2>
								
								<p>작성자 : ${result.memberId}</p>
								
								<p>등록일 : <fmt:formatDate value="${result.regdate}" pattern="yyyy-MM-dd"/></p>
																
								<div>									
									<table class="table">
										<thead>
											<tr>
												<th>상품 선택</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${result.arrPjhProductDto}">
												<tr>
													<td><a id="selItemNo_${item.productNo}" class="selItemNo" href="#"> - ${item.name}</a></td>
												</tr>
											</c:forEach>						
										</tbody>
									</table>
								</div>
								
																
								<div>
									<p>
										<c:forEach var="item" items="${result.arrPjhProductDto}">											
											<c:if test="${result.preProductNo eq item.productNo}">
												<span>상품명: <span id="hidden_name">${item.name}</span></span>
											</c:if>
										</c:forEach>
									</p>
								</div>								
								<div class="price">
									<p>
										가격: <span id="hidden_price"><fmt:formatNumber value="${result.price}" pattern="₩ #,###.##" /></span>
									</p>
								</div>
								
								
								<c:if test="${session != null}">								
									<div id=needLogin>								
										<div class="available">
											<p>수량 선택</p>
											<ul>										
												<li>
													<select id="hidden_qty">
															<option>1</option>
															<option>2</option>
															<option>3</option>
															<option>4</option>
															<option>5</option>
													</select>
												</li>
											</ul>
											<br/>
											<a id="btn_addSelectedItem" class="btn btn-danger btn-sm">선택추가</a>
										</div>
										
										<div id="list_selectedItem">
											<p>추가된 상품</p>
											<table class="table">
												<thead>
													<tr>
														<th>상품번호</th>
														<th>상품명</th>
														<th>수량</th>
														<th>취소</th>
													</tr>
												</thead>
												<tbody id=tbody_addedItem>										
												</tbody>
											</table>
											
										</div>
										
										
										
										<div class="share-desc">
											<!-- 
											<div class="share">
												<p>Share Product :</p>
												<ul>
													<li><a href="#"><img
															src="/mall/resources/template/images/facebook.png" alt="" /></a></li>
													<li><a href="#"><img
															src="/mall/resources/template/images/twitter.png" alt="" /></a></li>
												</ul>
											</div>
											 -->
											<div class="button">
												<span><a id="btn_addToCart">장바구니에 담기</a></span>
											</div>
											
											<div class="clear"></div>
										</div>
										<!-- 
										<div class="wish-list">
											<ul>
												<li class="wish"><a href="#">Add to Wishlist</a></li>
												<li class="compare"><a href="#">Add to Compare</a></li>
											</ul>
										</div>
										 -->
									 </div>
								 </c:if>
								 
							</div>
							<div class="clear"></div>
						</div>
						<div class="product_desc">
							<div id="horizontalTab">
								<ul class="resp-tabs-list">
									<li>제품 상세정보</li>
									<!-- 
									<li>product Tags</li>
									 -->
									<li>제품 리뷰</li>
									<div class="clear"></div>
								</ul>
								<div class="resp-tabs-container">
									<div class="product-desc">
										<p>${result.content}</p>
									</div>
									<!-- 
									<div class="product-tags">
										<p>Lorem Ipsum is simply dummy text of the printing and
											typesetting industry. Lorem Ipsum has been the industry's
											standard dummy text ever since the 1500s, when an unknown
											printer took a galley of type and scrambled it to make a type
											specimen book. It has survived not only five centuries, but
											also the leap into electronic typesetting, remaining
											essentially unchanged.</p>
										<h4>Add Your Tags:</h4>
										<div class="input-box">
											<input type="text" value="">
										</div>
										<div class="button">
											<span><a href="#">Add Tags</a></span>
										</div>
									</div>
 									-->
									<div class="review">
										<h4>
											이 제품은 최고입니다 by <a href="#">판매자</a>
										</h4>
										<ul>
											<li>가격 :<a href="#"><img
													src="/mall/resources/template/images/price-rating.png"
													alt="" /></a></li>
											<li>성능 :<a href="#"><img
													src="/mall/resources/template/images/value-rating.png"
													alt="" /></a></li>
											<li>가성비 :<a href="#"><img
													src="/mall/resources/template/images/quality-rating.png"
													alt="" /></a></li>
										</ul>
										
										<div class="your-review">
											<h3>당신의 상품 평가는?</h3>
											<p>당신의 리뷰를 작성하세요.</p>
											<form>
												<div>
													<span><label>작성자<span class="red">*</span></label></span>
													<span><input type="text" value=""></span>
												</div>
												<div>
													<span><label>요약<span
															class="red">*</span></label></span> <span><input type="text"
														value=""></span>
												</div>
												<div>
													<span><label>리뷰 내용<span class="red">*</span></label></span>
													<span><textarea> </textarea></span>
												</div>
												<div>
													<span><input type="submit" value="SUBMIT REVIEW"></span>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						
						
						<div class="content_bottom">
							<div class="heading">
								<h3>연관상품</h3>
							</div>
							<div class="see">
								<p>
									<a href="/mall/product/list.action">모든 상품 보기</a>
								</p>
							</div>
							<div class="clear"></div>
						</div>
						<div class="section group">
						
						
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
						
							<!-- <div class="grid_1_of_4 images_1_of_4">
								<a>
									<img src="/mall/resources/template/images/new-pic1.jpg" alt="">
								</a>
								<div class="price" style="border: none">
									<div class="add-cart" style="float: none">
										<h4>
											<a href="#">Add to Cart</a>
										</h4>
									</div>
									<div class="clear"></div>
								</div>
							</div> -->
						</c:forEach>
							
							
							
							
							
						</div>
					</div>
					
						<div class="rightsidebar span_3_of_1">
						<!-- product category -->					
						<jsp:include page="/WEB-INF/views/productcategory.jsp" />
					</div>
						
					<div class="rightsidebar span_3_of_1">

					</div>
					
					
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

