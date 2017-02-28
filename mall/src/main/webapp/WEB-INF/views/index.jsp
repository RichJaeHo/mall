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
$(document).ready(function() {
		
	function numberWithCommas(x) {
	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
	
	//선택상품 페이지로 이동
	function moveToClickAd(){
		$(".productItem").on("click",function(event) {
			location.href="/mall/product/preview.action?boardNo=" + event.target.id.split("_")[1];
		});
	}
	
	
	//로그인전 세팅
	function loadBasicProductList(){
		
		//top2 가져오기
		$.ajax({
			url:"/mall/product/listtop2.action",      
		    type:"GET",
		    data:{
		    },
		    dataType:'JSON',
		    success:function(json){    			    	
		    	
		    	//데이터 세팅
		    	setTop2Data(json);
		    },
		    error:function(request,status,error){  
		    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		});  
		
		//관련카테고리 
		$.ajax({
			url:"/mall/product/listtop1category.action",      
		    type:"GET",
		    data:{
		    },
		    dataType:'JSON',
		    success:function(json){
		    	
		    	//데이터 세팅
		    	setTopCategoryData(json);		    	
		    },
		    error:function(request,status,error){  
		    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		});  
	}
	
	//로그인후의 데이터 가져오기
	function afterLoginProductList(){
		
		//자료요청
		$.ajax({
			url:"/mall/product/makejsonforrequest.action",      
		    type:"GET",
		    data:{
		    },
		    dataType:'text',
		    success:function(json){
		    	
		    	$.ajax({
					url:"http://192.168.13.6:8888/paypal/analyze/analyze.action",      
				    type:"GET",
				    data:{
				    	request : json
				    },
				    dataType:'text',
				    success:function(json){
				    	
				    	//alert(json);
				    	
				    	//top2자료
				    	$.ajax({
							url:"/mall/product/listtop2afterlogin.action",      
						    type:"GET",
						    data:{
						    	paypal : json
						    },
						    dataType:'JSON',
						    success:function(json){

						    	//데이터 세팅
						    	setTop2Data(json);					    	
						    },
						    error:function(request,status,error){  
						    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						    }
						});  
						
						//관련카테고리 
						$.ajax({
							url:"/mall/product/listtop1categoryafterlogin.action",      
						    type:"GET",
						    data:{
						    	paypal : json
						    },
						    dataType:'JSON',
						    success:function(json){
						    	
						    	//데이터 세팅
						    	setTopCategoryData(json);		    	
						    },
						    error:function(request,status,error){  
						    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						    }
						}); 
				    },
				    error:function(request,status,error){  
				    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

				    	//에러시 기본세팅으로
				    	loadBasicProductList();
				    },
				    timeout: 2000
				});
		    	
		    },
		    error:function(request,status,error){  
		    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);		    	
		    }
		});  
	}
	
	//top2제품 세팅
	function setTop2Data(json){
		
    	$("#proNo1AdPath").attr("href","/mall/product/preview.action?boardNo=" + json[0].boardNo);
    	$("#proNo1AdPath2").attr("href","/mall/product/preview.action?boardNo=" + json[0].boardNo);
    	$("#proNo1Img").attr("src",json[0].fileName);
    	$("#proNo1Title").text(json[0].title);
    	$("#proNo1price").text("₩ " + numberWithCommas(json[0].price));
    	$("#proNo1Content").html(json[0].content);
    	$("#proNo1memberId").text("작성자 : " + json[0].memberId);
    	
    	if(json.length < 2) return;
    	
    	$("#proNo2AdPath").attr("href","/mall/product/preview.action?boardNo=" + json[1].boardNo);
    	$("#proNo2AdPath2").attr("href","/mall/product/preview.action?boardNo=" + json[1].boardNo);
    	$("#proNo2Img").attr("src",json[1].fileName);
    	$("#proNo2Title").text(json[1].title);
    	$("#proNo2price").text("₩ " + numberWithCommas(json[1].price));
    	$("#proNo2Content").html(json[1].content);
    	$("#proNo2memberId").text("작성자 : " + json[1].memberId);
	}
	
	
	//top1 카테고리 데이터 세팅
	function setTopCategoryData(json) {
		
		$("#divProListRel").empty();
    	$("#divProListSpecail").empty();
    	
    	for(var i = 0; i < json.length; i++) {
    		$("#divProListRel").append(
	    		$("<div></div>").addClass("grid_1_of_4 images_1_of_4").append(
	    			$("<a></a>").append(
	    				$("<img>").attr("id", "productItem_" + json[i].boardNo).addClass("productItem").attr("src", json[i].fileName).attr("alt", " ")		    					
	    			)		
	    		).append(
	    			$("<h2></h2>").text(json[i].title)
	    		).append(		    			
	    			$("<div></div>").addClass("price-details").append(
	    				$("<div></div>").addClass("price-number").append(
	    					$("<p></p>").append(
	    						$("<span></span>").addClass("rupees").text("₩ " + numberWithCommas(json[i].price))
	    					)
	    				)
	    			).append(
	    				$("<div></div>").addClass("add-cart").append(
	    					$("<h4></h4>").append( 
	    						$("<a></a>").attr("id", "productItem_" + json[i].boardNo).addClass("productItem").text("상세보기")
	    					)
	    				)
	    			).append(
	    				$("<div></div>").addClass("clear")	
	    			)
	    		)
    		)		    		
    	}
    	
    	//이벤트걸기
    	moveToClickAd();
	}
	
	
	// 많이팔린상품 분석
	if($("#checkLogin").val() == "" || $("#checkLogin").val() == null) {
		// 로그인상태가 아니면
		loadBasicProductList();
	} else {
		
		// 로그인상태이면
		afterLoginProductList();
	} 
	
});
</script>


</head>
<body>
	<div class="wrap">
		<div class="header">
			
			<!-- header -->
			<jsp:include page="/WEB-INF/views/header.jsp" />

			<div class="header_slide">
			
				<div>
					<input id="checkLogin" type="hidden" value="${session.memberId}">
				</div>
			
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
										<h4>베스트 상품 TOP 1</h4>
									</div>
									<div class="clear"></div>
								</div>	
											
								<!-- 상위상품1 -->
								<div id="slide-1" class="slide">
								
									<!-- 제목 -->
									<div class="slider-text">
										<h1 id="proNo1Title"></h1>
									</div>
									
									<!-- 사진주소 -->
									<div class="slider-img">
										<a id="proNo1AdPath"><img id="proNo1Img" alt=" " /></a>
									</div>
									
									<!-- 상세내용 -->
									<div class="slider-text">
										<div class="features_list">
											<h1 id="proNo1price"></h1>
										
											<h3 id="proNo1memberId"></h3>
											<!-- 본문 -->
											<h4 id="proNo1Content"></h4>
										</div>										
										<a id="proNo1AdPath2" class="btn btn-danger">바로가기</a>										
									</div>
									<div class="clear"></div>									
									
								</div>
								
								
								<br/>
								<br/>
								<br/>
								
								
								<!-- 카테고리 명 -->
								<div class="content_top">
									<div class="heading">
										<h4>베스트 상품 TOP 2</h4>
									</div>
									<div class="clear"></div>
								</div>	
								
								<!-- 상위상품2 -->
								<div class="slide">
									
									<!-- 제목 -->
									<div class="slider-text">
										<h1 id="proNo2Title"></h1>
									</div>
									
									<!-- 사진주소 -->
									<div class="slider-img">
										<a id="proNo2AdPath"><img id="proNo2Img" alt=" " /></a>
									</div>
									
									<!-- 상세내용 -->
									<div class="slider-text">
										<div class="features_list">
											<h1 id="proNo2price"></h1>
										
											<h3 id="proNo2memberId"></h3>
											<!-- 본문 -->
											<h4 id="proNo2Content"></h4>
										</div>										
										<a id="proNo2AdPath2" class="btn btn-danger">바로가기</a>										
									</div>
									<div class="clear"></div>
									
								</div>
								
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>
		
		
		<div class="main">
			<div class="content">
			
			
				<div class="content_top">
					<div class="heading">
						<h3>관련 카테고리 상품</h3>
					</div>
					<div class="see">
						<p>
							<a href="#">▲ 위</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				
				
				<div id="divProListRel" class="section group">
				</div>
				
				<!-- 
				<div class="content_bottom">
					<div class="heading">
						<h3>이색 상품</h3>
					</div>
					<div class="see">
						<p>
							<a href="#">▲ UP</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				 -->
				
				<div id="divProListSpecail" class="section group">
				</div>
				
				
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

