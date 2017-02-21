<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
 
<link type="text/css" href="/mall/resources/template/css/style.css" rel="stylesheet" media="all" />

<script type="text/javascript" src="/mall/resources/template/js/move-top.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easing.js"></script>

<!-- 부트스트랩 수정함 --> 
<link rel="stylesheet" href="/mall/resources/templatenotice/css/editedbootstrap.css">
 
<script type="text/javascript">
$(document).ready(function(){
	
	//카테고리 데이터 불러오기
	$.ajax({
		url:"/mall/category/list.action",      
	    type:"GET",
	    data:{
	    },
	    dataType:'JSON',
	    success:function(json){
	    	
	    	//crate element and insert
	    	for(var i=0; i<json.length; i++){
	    		$("#cat_ul").append(
		    		$("<li></li>").append(
		    			$("<a></a>").addClass("catItem").text(json[i])
		    		)
	    		);
	    	}
	    	
	    	//클릭이벤트 달기
	    	$(".catItem").on("click", function(event) {	    		
	    		location.href="/mall/product/list.action?category=" + event.target.text;
	    	});
	    },
	    error:function(request,status,error){  
	    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	});
	
});
</script>

</head>

<div class="categories">
	<ul id = "cat_ul">
		<h3>카테고리</h3>
	</ul>
</div>

