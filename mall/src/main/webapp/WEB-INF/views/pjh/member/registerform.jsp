<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<!-- 회원가입 css -->
	<link href='/mall/resources/templateregist/css/style.css' rel='stylesheet' type='text/css'>
	
	<!-- 제이쿼리/부트스트랩 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" ></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	
	
	<!-- 유효성검사 에러 -->
	<style type="text/css">
	.form_error{
		color: #B81D22;
	}
	</style>
	
	
	<!-- 지도API -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	
	<script type="text/javascript">	
	$(document).ready(function(){
		
		$("#addressButton").on("click", function() {			
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
	                document.getElementById('zipCode').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('address1').value = fullAddr;

	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById('address2').focus();
	            }
	        }).open();		
		});
	});	
	</script>
	
</head>

<body>
	<div class="container">
		<div class='login'>
			<h2>Regist</h2>
			<form:form id="formRegist" modelAttribute="pjhMemberRegisterFormDto" 
					   action="/mall/myaccount/regist.action" method="post">
				
				<form:input path='memberId' placeholder='아이디' />
				<form:errors path='memberId' class="form_error" />				 
				<form:password path='passwd' placeholder='비밀번호' />	
				<form:errors path='passwd' class="form_error" />					  
				<form:input path='name' placeholder='이름' />
				<form:errors path='name' class="form_error" />
				<br/>
				<br/>
				<span>생년월일</span>
				<input name='strBirth' placeholder='생년월일' type="date" />
				<br/><br/>
				<input type="radio" name="gender" value="M" checked="checked"/>남
				<input type="radio" name="gender" value="W" />여
				<br/>				
				<form:input path='phone' placeholder='핸드폰 번호' />
				<form:errors path='phone' class="form_error" />		
				<form:input path='email' placeholder='이메일@abc.com' />
				<form:errors path='email' class="form_error" />
				<br/><br/>
				<input type="button" id="addressButton" value="우편번호 찾기" />						
				<form:input id="zipCode" path="zipCode" placeholder="우편번호" readonly="true" />
				<form:input id="address1" path="address1" placeholder="주소" readonly="true" />
				<form:input id="address2" path="address2" placeholder="상세주소" />				
				<form:errors path='address2' class="form_error" />
				<br/><br/>
				<input type="radio" name="userType" value="2" />판매자
				<input type="radio" name="userType" value="3" checked="checked" />구매자
				<br/><br/>
				<input class='animated' type='submit' value='가입하기'> 
				
			</form:form>
			<a class='forgot' href='/mall/myaccount/login.action'>로그인 화면으로 가기</a>
			<a class='forgot' href='/mall/home.action'>홈으로 돌아가기</a>			
		</div>
	</div>
	
</body>
</html>




















