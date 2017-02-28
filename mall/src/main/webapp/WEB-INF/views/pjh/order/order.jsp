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

<!-- 지도API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">	
$(document).ready(function(){
	
	function numberWithCommas(x) {
	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
	
	function uncomma(str) {
	    str = String(str);
	    return str.replace(/[^\d]+/g, '');
	}
	
	$("#form_rec_btnAddress").on("click", function() {			
		new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('form_rec_zipCode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('form_rec_address1').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('form_rec_address2').focus();
            }
        }).open();		
	});
	
	
	//총가격 넣기
	function calTotAmount() {
		var tot = 0;
		var small = $(".smallAmount");
		for(var i = 0; i < small.length; i++) {
			tot += Number(small[i].innerText);
		}
		
		$("#totAmount").text("₩ " + numberWithCommas(tot));
	}
	calTotAmount();
	
	
	//상품주문하기
	$("#btnPayForOrder").on("click", function(){
		
		$.ajax({
			url:"/mall/product/payfororder.action",      
		    type:"POST",
		    data:{
		    	arrCartNo : $("#form_arrCartNo").text(),
		    	recName : $("#form_rec_name").val(),
		    	recPhone : $("#form_rec_phone").val(),
		    	recZipCode : $("#form_rec_zipCode").val(),
		    	recAddress1 : $("#form_rec_address1").val(),
		    	recAddress2 : $("#form_rec_address2").val(),
		    	paypalEmail : $("#form_paypalEmail").val(),
		    	paypalPasswd : $("#form_paypalPw").val()
		    },
		    dataType:'text',
		    success:function(json){
		   
		    	if($("#checkPayPalIdPw").attr("checked") == "checked") {
			    	var reg = /\d+/g;
			    	var splitedJson = json.split(",");		
					var savedOrderListNo = splitedJson[1].match(reg).toString();
					
			    	//페이팔에 키값 보냄
			    	$.ajax({
						url:"http://210.16.214.202:8888/paypal/returnorderinfo.action",      
					    type:"POST",
					    data:{
					    	key : json
					    },
					    dataType:'text',
					    success:function(json){
					    	
					    	var splited = json.split("_@");
					    	
					    	if(splited[0] == "success") {				    	
						    	//서버에 페이팔로 데이터 보내게 요청
						     	$.ajax({
									url:"/mall/product/requestorderinfo.action",      
								    type:"POST",
								    data:{
								    	key : splited[1],
						    			paypalEmail : $("#form_paypalEmail").val(),
						    			paypalPasswd : $("#form_paypalPw").val()						     			
								    },
						     		complete:function(){
						     			//주문 목록페이지로
								    	location.href="/mall/myorder/orderlist.action";
						     		}
								});
					    	} else {
					    		
					    		$.ajax({
									url:"/mall/product/cancelordered.action",      
								    type:"POST",
								    data:{
								    	orderListNo : savedOrderListNo
								    },
								    error:function(request,status,error){
								    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
								    }
								});
					    		
					    		alert("PayPal에 일치하는 계정이 없습니다. \r\n 계정을 확인해주세요.");
					    	}
					     	
					    },
					    error:function(request,status,error){  
					    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					    	
					    	alert("PayPal 전산장애 오류 \r\n 잠시후 다시 시도해 주세요.");
					    },
					    timeout: 2000
					});
		    	} else {
		    		//주문 목록페이지로
			    	location.href="/mall/myorder/orderlist.action";
		    	}
		    },
		    error:function(request,status,error){  
		    	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		});  
		
	});
	
	
	$("input:radio[name='payMethod']").on("change", function(){
		
		if($("#checkPayPalIdPw").attr("checked") == "checked") {
			$("#divPapalIdPw").show();
		} else {
			$("#divPapalIdPw").hide();
		}
		
	})
	
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
										<h4>제품주문</h4>
									</div>
									<div class="clear"></div>
								</div>	
							
								<!-- 오른쪽 상품공간 시작 -->
								
								<table class="table table-hover">
									<thead>
										<tr>
											<th>No</th>
											<th>이미지</th>
											<th>상품명</th>
											<th>가격</th>
											<th>수량</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${arrResult}">
											<tr id="tr_titleNo_" class="tr_row">
												<td>${item.cartNo}</td>
												<td><img src="${item.fileName}" alt=" " height="70" width="60"></td>
												<td>${item.name}</td>
												<td><fmt:formatNumber value="${item.price}" pattern="₩ #,###.##" /></td>
												<td>${item.qty}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div>
									<c:forEach var="item" items="${arrResult}">
										<span class="smallAmount" hidden="true">${item.price * item.qty}</span>										
									</c:forEach>
									<span>총 가격 : <a id="totAmount"></a></span>
								</div>
								
								<div class="col span_3_of_3">
								
									<span id="form_arrCartNo" hidden="true">${arrCartNo}</span>
									<div class="contact-form">										
										<div>
											<div>
												<span>보내시는 분 정보</span>
											</div>
											<div>
												<span><label>아이디</label></span> 
												<span><input type="text" id="form_send_memberId" class="textbox" readonly="readonly" value="${ session.memberId }"></span>
											</div>
											<div>
												<span><label>이  름</label></span> 
												<span><input type="text" id="form_send_name" class="textbox" readonly="readonly" value="${ session.name }"></span>
											</div>
											<div>
												<span><label>핸드폰 번호</label></span> 
												<span><input type="text" id="form_send_phone" class="textbox" value="${ session.phone }"></span>
											</div>
										</div>


										<div>
											<div>
												<span>받으시는 분 정보</span>
											</div>
											<div>
												<span><label>이  름</label></span> 
												<span><input type="text" id="form_rec_name" class="textbox"></span>
											</div>
											<div>
												<span><label>핸드폰 번호</label></span> 
												<span><input type="text" id="form_rec_phone" class="textbox"></span>
											</div>
											<div>
												<span><label>우편번호</label></span>							
												<span><input type="text" id="form_rec_zipCode" class="textbox"readonly="readonly"></span>
												<span><input type="button" id="form_rec_btnAddress" value="우편번호 찾기"></span> 
											</div>
											<div>
												<span><label>주소</label></span> 
												<span><input type="text" id="form_rec_address1" class="textbox"readonly="readonly"></span>
											</div>
											<div>
												<span><label>상세주소</label></span> 
												<span><input type="text" id="form_rec_address2" class="textbox"></span>
											</div>	
											
										</div>
									</div>
									
									<div>
										<div>
											<span>결제 정보</span>
										</div>
										
										<div>
											<input type="radio" id="checkPayPalIdPw" name="payMethod" checked="checked">PayPal <br/>
												<div id="divPapalIdPw">
													<span>&nbsp;&nbsp;&nbsp;&nbsp;PayPal 이메일</span><br/>
													<span>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="form_paypalEmail" class="textbox"></span><br/>
													<span>&nbsp;&nbsp;&nbsp;&nbsp;PayPal 비밀번호</span><br/>
													<span>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="form_paypalPw" class="textbox"></span>
												</div>
											<input type="radio" name="payMethod">무통장 입금 <br/>
											<input type="radio" name="payMethod">신용카드 <br/>
											<input type="radio" name="payMethod">체크카드 <br/>
											<input type="radio" name="payMethod">핸드폰결제 <br/>											
											<input type="radio" name="payMethod">YellowPay <br/>
										</div>
										
										<div>
											<br/>
											<br/>
											<a id="btnPayForOrder" class="btn btn-danger">결제하기</a>
										</div>
									</div>
									
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

