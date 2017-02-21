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
	
	function numberWithCommas(x) {
	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
	
	function uncomma(str) {
	    str = String(str);
	    return str.replace(/[^\d]+/g, '');
	}
	
	//선택상품 페이지로 이동
	$(".productItem").on("click",function(event) {
		location.href="/mall/product/preview.action?boardNo=" + event.target.id.split("_")[1];
	});
	
	//카트 삭제
	$(".btnCancelItem").on("click", function(event) {
		
		var confirmIs = confirm("선택된 제품을 삭제할까요?");
    	if(confirmIs) {
    		
    		var curRow = $(this).closest("tr");
    		
    		$.ajax({
    				url:"/mall/mycart/deleteproduct.action",      
    			    type:"GET",
    			    data:{
    			    	cartNo : curRow.children(':nth-child(1)').text()			    	
    			    },
    			    dataType:'text',
    			    success:function(json){    			    	
    			    	curRow.remove();
    			    	alert("삭제완료");
    			    },
    			    error:function(request,status,error){  
    			    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    			    }
    		});  
    	}
	});
	
	//카트 수량변경
	$(".btnEditItem").on("click", function() {
		
		var curRow = $(this).closest("tr");
		var inRowBtnEdit = curRow.children(':nth-child(7)').children();
		var inRowQty = curRow.children(':nth-child(6)').children();
		var inRowCartNo = curRow.children(':nth-child(1)');
		
		if(inRowBtnEdit.text()=="변경") {
			inRowQty.removeAttr("readonly");
			inRowBtnEdit.text("적용");
		} else {		
			$.ajax({
				url:"/mall/mycart/editproduct.action",      
			    type:"POST",
			    data:{
			    	cartNo : inRowCartNo.text(),
			    	qty : inRowQty.val()	
			    },
			    dataType:'text',
			    success:function(json){
			    	if(json == "success"){
			    		inRowBtnEdit.text("변경");
			    		alert("수량변경 완료");
			    	} else {
			    		alert("재시도 하세요");
			    	}
			    },
			    error:function(request,status,error){  
			    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			}); 
		}
		
		//가격계산
		calAmount();
	});
	
	
	//체크한 상품 가격계산
	$(".checkedItem").on("click", function(){
		calAmount();	
	});
	
	//가격계산
	function calAmount(){
		var arrChecked = $(".checkedItem:checked");
		var totAmount = 0;		
		
		for(var i=0; i<arrChecked.length; i++) {
			
			var curRow = arrChecked[i].closest("tr");			
			var curPrice = uncomma(curRow.cells[4].innerText);
			var curQty = curRow.cells[5].children["0"].value;
			
			totAmount += curPrice * curQty;
		}
		
		$("#totMoney").text("₩ " + numberWithCommas(totAmount));
	}
	
	//체크상품 주문
	$("#btnOrderCheckedItem").on("click", function(){
		
		var confirmIs = confirm("선택된 상품을 주문할까요?");
		if(confirmIs) {
			
			//데이터 만들기
			var CartNoList = [];			
			var arrChecked = $(".checkedItem:checked");
				for(var i=0; i<arrChecked.length; i++) {
					var curRow = arrChecked[i].closest("tr");			
					CartNoList[i] = curRow.cells[0].innerText;
				}
		    var json = JSON.stringify(CartNoList);
		        
		    //폼생성후 POST
		    $("#divForm").append(
		    	$("<form></form>").attr("id", "formData").attr("method", "post").attr("action","/mall/myorder/order.action").append(
		    		$("<input></input>").attr("type","hidden").attr("name","json").val(json)
		    	)
		    );
		    $("#formData").submit();
		}
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
										<h4>My Cart</h4>
									</div>
									<div class="clear"></div>
								</div>	
							
								<!-- 오른쪽 상품공간 시작 -->
								
								
								
								
								
								<table class="table table-hover">
									<thead>
										<tr>
											<th>No</th>
											<th>선택</th>
											<th>이미지</th>
											<th>상품명</th>
											<th>가격</th>
											<th>수량</th>
											<th>수량변경</th>
											<th>삭제</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${arrResult}">
											<tr id="tr_titleNo_" class="tr_row">
												<td>${item.cartNo}</td>
												<td><input type="checkbox" class="checkedItem"></td>
												<td><img src="${item.fileName}" alt=" " height="70" width="60"></td>
												<td>${item.name}</td>
												<td><fmt:formatNumber value="${item.price}" pattern="₩ #,###.##" /></td>
												<td><input type="number" value="${item.qty}" readonly="readonly"></td>
												<td><a href="#" class="btnEditItem btn btn-default btn-sm">변경</a></td>
												<td><a href="#" class="btnCancelItem btn btn-default btn-sm">삭제</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
								
								<!-- 카테고리 명 -->
								<div >
									<span>총 가격 : 
										<a id="totMoney">0</a>
									</span>
									<br/>
									<br/>
									<c:if test="${session != null}">
										<a id="btnOrderCheckedItem" class="btn btn-danger">선택상품 주문</a>
										<div id="divForm">
										</div>
									</c:if>
								</div>	
								
								
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

