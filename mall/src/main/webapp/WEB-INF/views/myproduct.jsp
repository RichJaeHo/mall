<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		//상품 등록 form 로드
		$("#main_loadForm").load("/mall/resources/pda/html/product-list.html")
	});
	
	//카테고리 목록 만들기
/* 	function showCategoryList() {
		
		$(".form-group").empty();
		$(".form-group").append(
			$("<label></label>").text("상품 카테고리1").append(
				$("<div></div>").addClass("list").append(
					$("<select id='form_category1'></select>").addClass("form-control categorylist")
				)
			)
		)
		$(".form-group").append(
			$("<label></label>").text("상품 카테고리2").append(
				$("<div></div>").addClass("list").append(
					$("<select id='form_category2'></select>").addClass("form-control categorylist2")
				)
			)
		)
 		$.each(categorylist, function(i, v){ 
			$(".categorylist").append(
	 			$("<option></option>")
		   			.text(categorylist[i].name)
		   	)
 		});
 		$.each(categorylist2, function(i, v){ 
			$(".categorylist2").append(
	 			$("<option></option>")
		   			.text(categorylist2[i].name)
		   	)
 		});
 		
	} */

	//상품 정보 입력
/* 	function showProductInfo() {
		$(".product-info").empty();
		$(".product-info").append(
			$("<div></div>").addClass("form-group").append(
				$("<span></span>").append(
					$("<label></label>").text("상품명 :")
				)		
			).append(
				$("<span></span>").append(
					$("<input id='form_name'>").addClass("form-control")
				)
			)
		).append(
			$("<div></div>").addClass("form-group").append(
				$("<span></span>").append(
					$("<label></label>").text("가격 (원) :")
				)		
			).append(
				$("<span></span>").append(
					$("<input id='form_price'>").addClass("form-control")
				)
			)
		).append(
			$("<div></div>").addClass("form-group").append(
				$("<span></span>").append(
					$("<label></label>").text("수량 :")
				)		
			).append(
				$("<span></span>").append(
					$("<input id='form_qty'>").addClass("form-control")
				)
			)
		).append(
				$("<button>").addClass("registerImageBtn").text("상품 이미지 등록하기")
		).append(
				$("<div></div>").addClass("selectImage")					
		).append(
			$("<div></div>").addClass("form-group").append(
				$("<span></span>").append(
					$("<label></label>").text("상품 설명 :")
				)		
			).append(
				$("<span></span>").append(
					$("<textarea>").addClass("form-control").attr('rows', '5')
				)
			)
		)
		
	} */
	
	//상품 등록 안내
/* 	function showNotice() {
		$(".notice").empty();
		$(".notice").append(
				$("<h2></h2>").text("상품 등록")
			).append(
					$("<span></span>").html(
						"상품은 ID당 최대 20개까지 등록 가능하며, 90일간 판매됩니다.<br>등록된 상품은 HOME SHOPEE, HOME SHOPEE APP을 통하여 판매됩니다.<br><br>")
		)
	} */
	
	//상품 등록
	/* function registerProduct() {
		//이미지 폼데이터 생성
		var formData = new FormData($("#image-select")[0]);
		alert(formData);
		$.ajax({
			url : "/mall/product-register.action",
			type : "POST",
			processData : false,
			data : {
				name : $("#form_name").val(),
				memberId : $("#form_memberId").val(),
				category1 : $("#form_category1").val(),
				category2 : $("#form_category2").val(),
				price : $("#form_price").val(),
				qty : $("#form_qty").val(),
				"formData" : formData
			},
			success : function(data) {
				alert("등록성공!");
				
				
			},
			error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
		
	} */
	
/* 	//상품등록 버튼 생성
	function registerButton() {
		$(".regi-btn").empty();
		$("#main_loadForm").append(
			$("<div></div>").addClass("regi-btn").append(
			$("<button>").addClass("registerBtn").text("상품 등록하기")
			)
		)
	} */
	
	//이미지 파일 등록
	/* function fileSubmit() {
		//이미지 폼데이터 생성
		var formData = new FormData($("#image-select")[0]);
        $.ajax({
            type : 'post',
            url : 'fileUpload',
            data : formData,
            processData : false,
            contentType : false,
            success : function(html) {
                alert("파일 업로드하였습니다.");
            },
            error : function(error) {
                alert("파일 업로드에 실패하였습니다.");
                
            }
        });
    } */
	
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
								
								무엇을 도와드릴까요!!!
								
									
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

