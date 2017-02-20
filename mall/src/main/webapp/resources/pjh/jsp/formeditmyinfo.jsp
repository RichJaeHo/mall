<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<div class="main">
	<div class="content">
		<div class="section group">
			<div class="col span_2_of_3">
				<div class="contact-form">
					<h2>내 정보 수정</h2>
						<div>
							<span><label>아이디</label></span> 
							<span><input type="text" id="form_memberId" class="textbox" name="memberId" readonly="readonly" value="${ session.memberId }"></span>
						</div>
						<div>
							<span><label>비밀번호</label></span> 
							<span><input type="text" id="form_passwd" class="textbox" name="passwd" placeholder="비밀번호를 입력하세요"></span>
						</div>
						<div>
							<span><label>이름</label></span> 
							<span><input type="text" id="form_name" class="textbox" name="name" readonly="readonly" value="${ session.name }"></span>
						</div>
						<div>
							<span><label>생년월일</label></span>
							<fmt:formatDate var="formatedDate" value="${session.birth}" pattern="yyyy-MM-dd"/>
							<span><input type="date" id="form_birth" class="textbox" name="strBirth" value="${ formatedDate }"></span>
						</div>
						<div>
							<span><label>핸드폰 번호</label></span> 
							<span><input type="text" id="form_phone" class="textbox" name="phone" value="${ session.phone }"></span>
						</div>
						<div>
							<span><label>이메일</label></span> 
							<span><input type="text" id="form_email" class="textbox" name="email" value="${ session.email }"></span>
						</div>
						<div>
							<span><label>우편번호</label></span>							
							<span><input type="text" id="form_zipCode" class="textbox" name="zipCode" readonly="readonly" value="${ session.zipCode }"></span>
							<span><input type="button" id="addressButton" value="우편번호 찾기"></span> 
						</div>
						<div>
							<span><label>주소</label></span> 
							<span><input type="text" id="form_address1" class="textbox" name="address1" readonly="readonly" value="${ session.address1 } ${ session.address2 }"></span>
						</div>
						<div>
							<span><label>상세주소</label></span> 
							<span><input type="text" id="form_address2" class="textbox" name="address2" value="${ session.address3 }"></span>
						</div>
						<c:if test="${session != null}">
							<div>
								<span><input type="button" id="btnSubmitToEdit" class="myButton" value="제출하기"></span>
							</div>	
						</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
</html>