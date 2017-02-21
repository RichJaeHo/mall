<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<script type="text/javascript">
$(document).ready(function(){
	
	$.ajax({
		url : "/mall/list.action",
		type : "GET",
		dataType : "json",
		success : function(data) {
			
			$("#product-list").empty();
			$.each(data, function(i, v) {
				$("#product-list").append(

					$("<tr></tr>").addClass("list" + i)
					.append(
						$("<td></td>").attr("id", "id_" + data[i].productNo)
							.append($("<a></a>").attr("href", "#").text(data[i].productNo))
					)
					.append(
						$("<td></td>").text(data[i].category1)	
					)
					.append(
						$("<td></td>").text(data[i].category2)	
					)
					.append(
						$("<td></td>").text(data[i].name)	
					)
					.append(
						$("<td></td>").text(data[i].price)	
					)
					.append(
						$("<td></td>").text(data[i].qty)	
					)
					.append(
						$("<td></td>").text(data[i].regDate)	
					)
				)
				
			});	
			//상품번호 클릭 시 상품 상세정보로.
			$("td[id^=id_]").on("click", function(event) {
				var id = $(event.currentTarget).attr("id");
				var productNo = id.split("_")[1];
				location.href = "/mall/detail.action?productNo=" + productNo;
			});
		},
		error:function(request,status,error){
	        //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
		
	});	

});
</script>

<div class="main">
	<div class="content">
		<div class="section group">
			<div class="col span_3_of_3">
				<div class="contact-form">
					<h2>공지사항 수정</h2>
					<table class="table table-hover">
					<thead>
						<tr>
							<th>No</th>
							<th>카테고리1</th>
							<th>카테고리2</th>
							<th>상품명</th>
							<th>가격</th>
							<th>수량</th>
							<th>등록일</th>
						</tr>
					</thead>
					<tbody id="product-list">
					</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

</html>
