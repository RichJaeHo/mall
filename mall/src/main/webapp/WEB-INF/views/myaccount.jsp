<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<title>Free Home Shoppe Website Template | Home :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link type="text/css" href="/mall/resources/template/css/style.css" rel="stylesheet" media="all" />

<script type="text/javascript" src="/mall/resources/template/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/move-top.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easing.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/startstop-slider.js"></script>

<!-- 지도API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	//회원탈퇴 Ajax
	$("#cat_delMyInfo").on("click", function(){
		//deletemyinfo form 로드
		$("#main_loadForm").load("/mall/resources/pjh/jsp/deletemyinfo.jsp", function() {
			
			//회원탈퇴 버튼에 이벤트 달기
			$("#btnDelSession").on("click", function() {
				delMyInfoAjx();
			});
		});
	});
	
	//회원탈퇴 Ajax
	function delMyInfoAjx(){
		$.ajax({     
			url:"/mall/myaccount/deletemyinfo.action",      
		    type:"POST",
		    data:{
		    	memberId : $("#form_memberId").val(),
				passwd : $("#form_passwd").val()
		    },
		    dataType : 'text',
		    success:function(text){
				alert("회원탈퇴 완료");
				location.href="/mall/home.action";
		    },
		    error:function(request,status,error){  
		    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		}); 
	}
	
	
	
	
	//내정보 Ajax
	$("#cat_myInfo").on("click", function() {		
		//myinfodetail form 로드
		$("#main_loadForm").load("/mall/resources/pjh/jsp/myinfodetail.jsp", function() {
			
			//페이지 이동버튼에 이벤트 달기
			$("#btnGoToEdit").on("click", function() {
				loadFormEditMyInfo();
			});
		});		
	});
	
	//formeditmyinfo 로드
	function loadFormEditMyInfo(){		
		$("#main_loadForm").load("/mall/resources/pjh/jsp/formeditmyinfo.jsp", function() {
			
			//주소찾기 버튼에 이벤트 등록
			$("#addressButton").on("click", function() {
				openAddressAPI();
			});
			
			//폼전송버튼에 이벤트 등록
			$("#btnSubmitToEdit").on("click", function() {
				submitFormAjax();
			});
		});
	}
	
	//우편번호 검색 기능
	function openAddressAPI(){
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
                document.getElementById('form_zipCode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('form_address1').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('form_address2').focus();
            }
        }).open();	
	}
	
	//폼 데이터 전송
	function submitFormAjax() {
		$.ajax({     
			url:"/mall/myaccount/editmyinfo.action",      
		    type:"POST",
		    data:{
		    	memberId : $("#form_memberId").val(),
				passwd : $("#form_passwd").val(),
				name : $("#form_name").val(),
				strBirth : $("#form_birth").val(),
				phone : $("#form_phone").val(),
				email : $("#form_email").val(),
				zipCode : $("#form_zipCode").val(),
				address1 : $("#form_address1").val(),
				address2 : $("#form_address2").val()
		    },
		    dataType : 'text',
		    success:function(text){
				alert("회원정보가 변경되었습니다");
				location.href="/mall/home.action";
		    },
		    error:function(request,status,error){  
		    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		}); 
	}
	
	
	
	//광고글 작성 이벤트
	$("#cat_addAdvInfo").on("click", function(){
		loadFormwriteadver();
	});
	
	//formwriteadver 로드
	function loadFormwriteadver(){
		$("#main_loadForm").load("/mall/resources/pjh/jsp/formwriteadver.jsp", function() {
			
			//네이버 에디터 전역변수선언
		    var editor_object = [];
			
			
			//네이버 에디터
			$(function(){
			     
			    nhn.husky.EZCreator.createInIFrame({
			        oAppRef: editor_object,
			        elPlaceHolder: "form_content",
			        sSkinURI: "/mall/resources/smarteditor/SmartEditor2Skin.jsp",
			        htParams : {
			            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			            bUseToolbar : true,            
			            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			            bUseVerticalResizer : true,    
			            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			            bUseModeChanger : true,
			        }
			    });			     
			});
			
			
			//작성버튼에 이벤트
			$("#btnSendWriteProAd").on("click", function(){
				
				//스마트 에디터 id가 form_content인 textarea에 에디터에서 대입
		        editor_object.getById["form_content"].exec("UPDATE_CONTENTS_FIELD", []);
				
				$.ajax({     
					url:"/mall/product/writeadver.action",      
				    type:"POST",
				    data:{
				    	memberId : $("#form_memberId").val(),
				    	preCategory1 : $("#form_category1").val(),
				    	title : $("#form_title").val(),
				    	content : $("#form_content").val(),
				    	arrProductNo : $("#form_productNoList").val(),
				    	preProductNo : $("#form_preProductNo").val(),
				    	preImageNo : $("#form_preImageNo").val(),
				    },
				    dataType : 'text',
				    success:function(text){
						alert("광고글 전송 완료");
						
						//재실행
						loadFormwriteadver();
				    },
				    error:function(request,status,error){  
				    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				    }
				});
			});
		});
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
			
				<!-- category -->
				<div class="header_bottom_left">
					<div class="categories">
						<ul>
							<h3>My Account</h3>
							<li><a id="cat_myInfo" href="#">내 정보</a></li>
							<li><a id="cat_delMyInfo" href="#">회원 탈퇴</a></li>
														
							<c:if test="${session.userType != 3}">
								<li><a id="cat_addAdvInfo" href="#">광고글 작성</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="header_bottom_right">
					<div class="slider">
						<div id="slider">
							<div id="mover">
								<div id="main_loadForm">
								
								
								
								메인페이지
								
								
								
								
								
								
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

