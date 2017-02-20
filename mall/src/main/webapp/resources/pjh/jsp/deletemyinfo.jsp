<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<div class="main">
	<div class="content">
		<div class="section group">
			<div class="col span_2_of_3">
				<div class="contact-form">
					<h2>회원 탈퇴</h2>		
						<div>
							<span><label>아이디</label></span> 
							<span><input id="form_memberId" type="text" class="textbox" readonly="readonly" value="${ session.memberId }"></span>
						</div>			
						<div>
							<span><label>계정 비밀번호를 입력하세요</label></span> 
							<span><input id="form_passwd" type="password" class="textbox"></span>
						</div>
						<c:if test="${session != null}">
							<div>
								<span><input type="button" id="btnDelSession" class="myButton" value="회원탈퇴"></span>
							</div>			
						</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
</html>