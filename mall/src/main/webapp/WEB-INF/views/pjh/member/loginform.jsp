<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
</head>

<body>
	<div class="container">
		<div class='login'>
			<h2>Login</h2>
			<form id="formRegist" action="/mall/myaccount/login.action" method="post">
				<input name='memberId' placeholder='아이디' type='text'> 
				<input name='passwd' placeholder='비밀번호' type='password'>
				<input class='animated' type='submit' value='로그인'> 
			</form>
			<a class='forgot' href='/mall/home.action'>홈으로 돌아가기</a>
		</div>
	</div>
	
</body>
</html>
