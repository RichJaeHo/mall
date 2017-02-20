<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<div class="main">
	<div class="content">
		<div class="section group">
			<div class="col span_2_of_3">
				<div class="contact-form">
					<h2>내 정보</h2>					
						<div>
							<span><label>아이디</label></span> 
							<span><input type="text" class="textbox" readonly="readonly" value="${ session.memberId }"></span>
						</div>
						<div>
							<span><label>이름</label></span> 
							<span><input type="text" class="textbox" readonly="readonly" value="${ session.name }"></span>
						</div>
						<div>
							<span><label>생년월일</label></span>
							<fmt:formatDate var="formatedDate" value="${session.birth}" pattern="yyyy-MM-dd"/>
							<span><input type="text" class="textbox" readonly="readonly" value="${ formatedDate }"></span>
						</div>
						<div>
							<span><label>핸드폰 번호</label></span> 
							<span><input type="text" class="textbox" readonly="readonly" value="${ session.phone }"></span>
						</div>
						<div>
							<span><label>이메일</label></span> 
							<span><input type="text" class="textbox" readonly="readonly" value="${ session.email }"></span>
						</div>
						<div>
							<span><label>우편번호</label></span> 
							<span><input type="text" class="textbox" readonly="readonly" value="${ session.zipCode }"></span>
						</div>
						<div>
							<span><label>주소</label></span> 
							<span><input type="text" class="textbox" readonly="readonly" value="${ session.address1 } ${ session.address2 }"></span>
						</div>
						<div>
							<span><label>상세주소</label></span> 
							<span><input type="text" class="textbox" readonly="readonly" value="${ session.address3 }"></span>
						</div>
						<c:if test="${session != null}">
							<div>
								<span><input type="button" id="btnGoToEdit" class="myButton" value="수정하기"></span>
							</div>			
						</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
</html>