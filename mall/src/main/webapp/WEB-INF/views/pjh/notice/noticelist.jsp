<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<title>Free Home Shoppe Website Template | About :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link type="text/css" href="/mall/resources/template/css/style.css" rel="stylesheet" media="all" />

<script type="text/javascript" src="/mall/resources/template/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/move-top.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easing.js"></script>

<!-- 부트스트랩 수정함 -->
<link rel="stylesheet" href="/mall/resources/templatenotice/css/editedbootstrap.css">

<script type="text/javascript">
$(document).ready(function(){
	
	$().UItoTop({ easingType: 'easeOutQuart' });
	
	// 공지사항 내용 토글기능
	$(".tr_row").on("click", function() {		
		var currentRow = $(this).closest("tr");
		var currentRowNo = currentRow.children("td:nth-child(1)").text();
		
		//열린공지 접기
		$(".tr_contentNo").hide();
		
		//공지 토글
		if($("#tr_contentNo_" + currentRowNo).css('display') == 'none') {
			$("#tr_contentNo_" + currentRowNo).show('slow');
		} else {
			$("#tr_contentNo_" + currentRowNo).hide('slow');
		}		
	});
	
	
	//게시글 수정
	$(".btnEditNotice").on("click", function(){
		
		var currentRow = $(this).closest("tr");		
		var currentRowNo = currentRow.attr("id").split("_")[2];
	
		// 작성폼 로드
		$("#div_writeNotice").load("/mall/resources/pjh/jsp/formeditnotice.jsp", function() {
						
			//네이버 에디터 전역변수선언
		    var editor_object = [];
						
			//네이버 에디터
			$(function(){
			     
			    nhn.husky.EZCreator.createInIFrame({
			        oAppRef: editor_object,
			        elPlaceHolder: "form_edit_content",
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
			
			
			//데이터 불러와서 넣기
			$.ajax({
				url:"/mall/notice/editnotice.action",      
			    type:"GET",
			    data:{
			    	noticeNo : currentRowNo
			    },
			    dataType:'JSON',
			    success:function(json){
			    	$("#form_edit_noticeNo").val(json.noticeNo);
			    	$("#form_edit_title").val(json.title);
			    	$("#form_edit_content").val(json.content);
			    },
			    error:function(request,status,error){  
			    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			});
			
			//수정적용 버튼에 이벤트
			$("#btnSendEditNotice").on("click", function() {

				//스마트 에디터 id가 form_content인 textarea에 에디터에서 대입
		        editor_object.getById["form_edit_content"].exec("UPDATE_CONTENTS_FIELD", []);
				
				sendEditNoticeAjax();
			})
			
			//취소 버튼에 이벤트
			$("#btnCancelEditNotice").on("click", function() {
				$("#div_writeNotice").empty();
			})
			
		});			
	});
	
	function sendEditNoticeAjax(){
		$.ajax({     
			url:"/mall/notice/editnotice.action",      
		    type:"POST",
		    data:{
		    	noticeNo : $("#form_edit_noticeNo").val(),
		    	memberId : $("#form_edit_memberId").val(),
				title : $("#form_edit_title").val(),
				content : $("#form_edit_content").val()
		    },
		    dataType : 'text',
		    success:function(text){
		    	location.href="/mall/notice/noticelist.action";
		    },
		    error:function(request,status,error){  
		    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		});
	}
	
	
	//게시글 작성
	$("#btnWriteNotice").on("click", function(){
		
		// 작성폼 로드
		$("#div_writeNotice").load("/mall/resources/pjh/jsp/formwritenotice.jsp", function() {
			
			
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
			
			
			//보내기 버튼에 이벤트
			$("#btnSendWriteNotice").on("click", function() {
				
				//스마트 에디터 id가 form_content인 textarea에 에디터에서 대입
		        editor_object.getById["form_content"].exec("UPDATE_CONTENTS_FIELD", []);
				
				sendWriteNoticeAjax();
			})
			
			//취소 버튼에 이벤트
			$("#btnCancelEditNotice").on("click", function() {
				$("#div_writeNotice").empty();
			})
			
		});
	});
	
	function sendWriteNoticeAjax(){
		$.ajax({     
			url:"/mall/notice/writenotice.action",      
		    type:"POST",
		    data:{
		    	memberId : $("#form_memberId").val(),
				title : $("#form_title").val(),
				content : $("#form_content").val()
		    },
		    dataType : 'text',
		    success:function(text){
		    	location.href="/mall/notice/noticelist.action";
		    },
		    error:function(request,status,error){  
		    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		});
	}
	
});
</script>

</head>
<body>
	<div class="wrap">
		
		<div class="header">
			<jsp:include page="/WEB-INF/views/header.jsp" />
		</div>
		
		<div class="main">
			<div class="content">
				<div class="section group">

					<!-- 본문시작 -->
					<div>
						<h2>공지사항</h2>
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th>No</th>
									<th>제    목</th>
									<th>작성자</th>
									<th>등록일자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${arrResult}">
									<tr id="tr_titleNo_${item.noticeNo}" class="tr_row">
										<td>${item.noticeNo}</td>
										<td>${item.title}</td>
										<td>${item.memberId}</td>
										<td><fmt:formatDate value="${item.regdate}" pattern="yyyy-MM-dd"/></td>
									</tr>
									<tr id="tr_contentNo_${item.noticeNo}" class="tr_contentNo" style="display: none">
										<td colspan="4">
											<div>
												<p>${item.content}</p>
												<c:if test="${session.userType eq 1}">
													<a class="btnEditNotice btn btn-info btn-sm">수정</a>
												</c:if>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<div>
							<c:if test="${session.userType eq 1}">
								<a id="btnWriteNotice" class="btn btn-success">게시글 작성</a>							
								<div id="div_writeNotice"></div>
							</c:if>
						</div>
					</div>

					<!-- 본문종료 -->

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />

	<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

