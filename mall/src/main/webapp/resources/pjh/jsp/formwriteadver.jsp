<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<!-- 네이버에디터 -->
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/mall/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>



<script type="text/javascript">
$(document).ready(function() {
	
	//카테고리정보 가져오기
	$.ajax({     
		url:"/mall/category/list.action",      
	    type:"GET",
	    data:{
	    },
	    dataType : 'JSON',
	    success:function(json){
	    	
	    	$("#form_category1").empty();
	    	
	    	//대표상품 옵션 입력
	    	for(var i=0; i<json.length; i++){
		    	$("#form_category1").append(
		    		$("<option></option>").attr("value", json[i]).text(json[i]));
	    	}
	    },
	    error:function(request,status,error){  
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	});
	
	
	var productListInfo = null;
	
	//제품정보 가져오기
	$.ajax({     
		url:"/mall/product/writeadver.action",      
	    type:"GET",
	    data:{
	    },
	    dataType : 'JSON',
	    success:function(json){
	    	
	    	//재활용시
	    	productListInfo = json;
	    	
	    	//상품정보 입력
	    	for(var i=0; i<json.length; i++){
	    		
	    		//상품선택 입력
		    	$("#form_productNoList").append(
			    		$("<option></option>").attr("value", json[i].productNo).text("상품번호 : " + json[i].productNo + " 상품이름 : " + json[i].name + " 가격 : " + json[i].price)
			    );
	    		
	    		//대표상품 옵션 입력
		    	$("#form_preProductNo").append(
		    		$("<option></option>").addClass("proOption").attr("value", json[i].productNo).text(json[i].name));
	    	}
	    	
	    	//대표상품 1의 이미지 입력
	    	for(var i=0; i<1; i++){
	    		inputImageOption(json[i].arrPjhImageDto);
	    	}
	    	
	    	//상품선택시 대표상품 제한
	    	$("#form_productNoList").on("change", function(event){
	    		
	    		//선택옵션 value 가져오기
	    		var arrOption = [];
	    		var selectedOptions = $("#form_productNoList option:selected");
	    		for(var i = 0; i < selectedOptions.length; i++) {	    			
	    			arrOption[i] = selectedOptions[i].value;
	    		}	
	    		
	    		//값비교후 대표상품 다시 세팅
	    		$("#form_preProductNo").empty();
	    		for(var i = 0; i < productListInfo.length; i++) {
	    			for(var j = 0; j < arrOption.length; j++) {
	    				if(productListInfo[i].productNo == arrOption[j]) {
	    					//대표상품 옵션 입력
	    			    	$("#form_preProductNo").append(
	    			    		$("<option></option>").addClass("proOption").attr("value", json[i].productNo).text(json[i].name));
	    				}
	    			}
	    		}
	    		
	    		//이미지 다시가져오기
	    		proOptionAjax();
	    	});
	    	
	     	//대표상품 선택시 이벤트
	    	$("#form_preProductNo").on("change", function() {	    		
	    		proOptionAjax();
	    	}); 
	    },
	    error:function(request,status,error){  
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	});
		
 	//대표상품 선택시 이벤트
	function proOptionAjax() {		
		$.ajax({     
			url:"/mall/product/adverimagelist.action",      
		    type:"GET",
		    data:{
		    	productNo : $("#form_preProductNo").val()
		    },
		    dataType : 'JSON',
		    success:function(json){		    	
		    	inputImageOption(json);
		    },
		    error:function(request,status,error){  
		    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		});
	} 
	
 	
	//대표상품 1의 이미지 입력
	function inputImageOption(json) {		
		
		$("#form_preImageNo").empty();
		
		for(var i=0; i<json.length; i++) {
	    	$("#form_preImageNo").append(
		    	$("<option></option>").attr("value", json[i].imageNo).text(json[i].fileName)
		    );
		}
		
		//첫번째 사진세팅
		$("#form_disImage").attr("src", $("#form_preImageNo option:first-child").text());
	}
	

	//이미지 선택시 이미지 전환
	$("#form_preImageNo").on("change", function(){
		$("#form_disImage").attr("src", $("#form_preImageNo option[value='" + $("#form_preImageNo").val() + "']").text());
	});
	
});
</script>

<div class="main">
	<div class="content">
		<div class="section group">
			<div class="col span_3_of_3">
				<div class="contact-form">
					<h2>광고글 작성</h2>
					<div>
						<span><label>작 성 자</label></span> 
						<span><input id="form_memberId" type="text" class="textbox" readonly="readonly" value="${ session.memberId }"></span>
					</div>
					<div>
						<span><label>카테고리</label></span>
						<span><select id="form_category1" size="1">
								<option value="1">1번보기</option>
						</select></span>
					</div>
					<div>
						<span><label>제 목</label></span> 
						<span><input id="form_title" type="text" class="textbox"></span>
					</div>
					<div>
						<span><label>내 용</label></span> 
						<span><textarea id="form_content" name="form_content" rows="10" cols="100" style="width:100%; height:412px;"></textarea></span>
					</div>
					<div>
						<span><label>상품선택</label></span>
						<span><select id="form_productNoList" multiple  size="5"></select></span>
					</div>
					<div>
						<span><label>대표상품</label></span>
						<span><select id="form_preProductNo" size="1"></select></span>
					</div>
					<div>
						<span><label>대표 이미지</label></span>
						<span><select id="form_preImageNo" size="1"></select></span>
					</div>
					<div>
						<img id="form_disImage" alt="이미지를 선택하세요" height="300">
					</div>					
					<div>
						<c:if test="${session != null}">
							<div>
								<input type="button" id="btnSendWriteProAd" class="myButton"value="작성">
							</div>
						</c:if>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>
</html>