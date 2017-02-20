<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<script type="text/javascript">
$(document).ready(function(){
});		
</script>
</head>

<div class="headertop_desc">
	<div class="call">
		<p>
			<span>도움이 필요하세요?</span> 
			<span class="number">010-4811-2727</span>
		</p>
	</div>
	<div class="account_desc">
		<ul>
			<c:choose>
				<c:when test="${session == null}">
					<li><a href="/mall/myaccount/regist.action">회원가입</a></li>
					<li><a href="/mall/myaccount/login.action">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/mall/myaccount/logout.action">로그아웃</a></li>
					<li><a href="/mall/myaccount.action">나의 계정</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<div class="clear"></div>
</div>
<div class="header_top">
	<div class="logo">
		<a href="/mall/home.action"><img
			src="/mall/resources/template/images/logo.png" alt="" /></a>
	</div>
	<div class="cart">

		<!-- #### 로그인시에 보여줌 #### -->
		<c:if test="${session.name != null}">
			<p>
				${session.name} 님 환영합니다. 
			</p>
		</c:if>

	</div>
	<script type="text/javascript">
	function DropDown(el) {
		this.dd = el;
		this.initEvents();
	}
	DropDown.prototype = {
		initEvents : function() {
			var obj = this;

			obj.dd.on('click', function(event){
				$(this).toggleClass('active');
				event.stopPropagation();
			});	
		}
	}

	$(function() {

		var dd = new DropDown( $('#dd') );

		$(document).click(function() {
			// all dropdowns
			$('.wrapper-dropdown-2').removeClass('active');
		});

	});

</script>
	<div class="clear"></div>
</div>
<div class="header_bottom">
	<div class="menu">
		<ul>
			<li class="active"><a href="/mall/home.action">홈</a></li>
			<li><a href="/mall/notice/noticelist.action">공지</a></li>
			<li><a href="/mall/product/list.action">상품리스트</a></li>
			<li><a href="/mall/mycart.action">카트</a></li>
			<li><a href="/mall/myorder/orderlist.action">주문목록</a></li>
			<!-- 
			<li><a href="#"></a></li>
			<li><a href="/mall/about.action"></a></li>
			<li><a href="/mall/delivery.action"></a></li>
			<li><a href="/mall/news.action"></a></li>
			<li><a href="/mall/contact.action"></a></li>
			 -->
		</ul>
	</div>
	<div class="search_box">
		<form action="/mall/product/searchlist.action" method="get">
			<input type="text" name="keyWord" placeholder="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
			<input type="submit" value="">
		</form>
	</div>
	<div class="clear"></div>
</div>

