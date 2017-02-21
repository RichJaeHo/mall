<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<!-- 네이버에디터 -->
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/mall/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<div class="main">
	<div class="content">
		<div class="section group">
			<div class="col span_3_of_3">
				<div class="contact-form">
					<h2>공지사항 수정</h2>
						<div>
							<span><label>글 번 호</label></span> 
							<span><input id="form_edit_noticeNo" type="text" class="textbox" readonly="readonly"></span>
						</div>		
						<div>
							<span><label>아 이 디</label></span> 
							<span><input id="form_edit_memberId" type="text" class="textbox" readonly="readonly" value="${ session.memberId }"></span>
						</div>
						<div>
							<span><label>제    목</label></span> 
							<span><input id="form_edit_title" type="text" class="textbox"></span>
						</div>			
						<div>
							<span><label>내    용</label></span> 
							<span><textarea id="form_edit_content" rows="10" cols="100" style="width:100%; height:412px;"></textarea></span>
						</div>
						<div>
						<c:if test="${session != null}">
							<div>
								<input type="button" id="btnSendEditNotice" class="myButton" value="적용">
								<input type="button" id="btnCancelEditNotice" class="myButton" value="취소">
							</div>			
						</c:if>
						</div>
				</div>
			</div>
		</div>
	</div>
</div>
</html>