<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
<script type="text/javascript" src="/mall/resources/template/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#toIndex").on("click", function() {
		location.href = "/mall/home.action";
	});
	
	$("#toMyProduct").on("click", function() {
		location.href = "/mall/myProduct.action";
	});
	
});


</script>


<html>
<div id="registerSuccessForm">
	<div class="notice jumbotron">
		<h2>상품 등록을 완료했습니다.</h2>
		<span>상품은 ID당 최대 20개까지 등록 가능하며, 90일간 판매됩니다.
		등록된 상품은 HOME SHOPEE, HOME SHOPEE APP을 통하여 판매됩니다.</span>
		
		<button id="toIndex">메인화면으로</button>
		<button id="toMyProduct">내 상품으로</button>
	</div>
</div>
</html>