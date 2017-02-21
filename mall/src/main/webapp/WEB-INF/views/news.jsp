<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link type="text/css" href="/mall/resources/template/css/style.css" rel="stylesheet" media="all"/>

<script type="text/javascript" src="/mall/resources/template/js/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="/mall/resources/template/js/move-top.js"></script>
<script type="text/javascript" src="/mall/resources/template/js/easing.js"></script>

</head>
<body>
  <div class="wrap">
	<div class="header">
		
	<jsp:include page="/WEB-INF/views/header.jsp" />
	         	
   </div>
 <div class="main">
    <div class="content">
    	<div class="image group">
				<div class="grid images_3_of_1">
					<img src="/mall/resources/template/images/newsimg1.jpg" alt="" />
				</div>
				<div class="grid news_desc">
					<h3>Lorem Ipsum is simply dummy text </h3>
					<h4>Posted on Aug 13th, 2013 by <span><a href="#">Finibus Bonorum</a></span></h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur <a href="#" title="more">[....]</a></p>
			   </div>
		   </div>	
		   <div class="image group">
				<div class="grid images_3_of_1">
					<img src="/mall/resources/template/images/newsimg2.jpg" alt="" />
				</div>
				<div class="grid news_desc">
					<h3>Lorem Ipsum is simply dummy text </h3>
					<h4>Posted on Aug 8th, 2013 by <span><a href="#">Finibus Bonorum</a></span></h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur <a href="#" title="more">[....]</a></p>
			   </div>
		   </div>
		   <div class="image group">
				<div class="grid images_3_of_1">
					<img src="/mall/resources/template/images/newsimg3.jpg" alt="" />
				</div>
				<div class="grid news_desc">
					<h3>Lorem Ipsum is simply dummy text </h3>
					<h4>Posted on Aug 1st, 2013 by <span><a href="#">Finibus Bonorum</a></span></h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur <a href="#" title="more">[....]</a></p>
			   </div>
		   </div>
		   <div class="content-pagenation">
						<li><a href="#">Frist</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><span>....</span></li>
						<li><a href="#">Last</a></li>
						<div class="clear"> </div>
					</div>	
         </div> 
    </div>
 </div>
  
<jsp:include page="/WEB-INF/views/footer.jsp" />

   <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

