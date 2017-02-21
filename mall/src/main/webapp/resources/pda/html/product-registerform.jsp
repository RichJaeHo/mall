<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<script type="text/javascript">
$(document).ready(function(){
	
	$.ajax({
		url : "/mall/registerform.action",
		type : "GET",
		dataType : "json",
		success : function(data) {
			
			//카테고리 리스트 분류
			var list = data.split('#');
			eval ('categorylist = ' + list[0]);
	 		eval ('categorylist2 = ' + list[1]);
			
	 		//카테고리 목록 불러오기
	 		showCategoryList();
	 		
		},
		error : function(data) {
			alert(data);
		}
	});
	
	//상품 카테고리 목록 조회
	function showCategoryList() {
		
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
	}
	
$("#registerBtn").on("click", function() {
		//form submit
		$("#product-select").submit();
	});
		
});
</script>


<div class="main">
	<div class="content">
		<div class="section group">
			<div class="col span_3_of_3">
				<div class="contact-form">
					<div id="registerProductForm">
						<form action="/mall/register.action" id="product-select" method="post" enctype="multipart/form-data">
							<!-- <input type="hidden" name="memberId" value="${ session.memberId }"> -->
							<div class="notice jumbotron">
								<h2>상품 등록</h2>
								<span>상품은 ID당 최대 20개까지 등록 가능하며, 90일간 판매됩니다.
								등록된 상품은 HOME SHOPEE, HOME SHOPEE APP을 통하여 판매됩니다.</span>
							</div>
							<div class="form-group">
								<label>상품 카테고리1</label>
								<select id="form_category1" name="category1" class="form-control categorylist"></select>
								<label>상품 카테고리2</label>
								<select id="form_category2" name="category2" class="form-control categorylist2"></select>
							</div>
							<div class="product-info">
								<div class="form-group">
									<span><label>상품명</label></span>
									<span><input id="form_name" name="name" class="form-control"></span>
								</div>
								<div class="form-group">
									<span><label>가격 (원)</label></span>
									<span><input id="form_price" name="price" class="form-control"></span>
								</div>
								<div class="form-group">
									<span><label>수량</label></span>
									<span><input id="form_qty" name="qty" class="form-control"></span>
								</div>
								<div class="selectImage">
									등록할 이미지를 선택하세요.<br>
									<input id="form_image" type="file" name="fileUp"><br>
									<input id="form_image2" type="file" name="fileUp"><br>
									<input id="form_image3" type="file" name="fileUp"><br>
								</div>
								<br>
								<button id="registerBtn">상품 등록하기</button>
							</div>
						</form>
					</div> 
				</div>
			</div>
		</div>
	</div>
</div>

</html>