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
    	<div class="section group">
				<div class="col_1_of_3 span_1_of_3">
					<h3>Who We Are</h3>
					<img src="/mall/resources/template/images/about_img.jpg" alt="">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					<h3>Our History</h3>
				 <div class="history-desc">
					<div class="year"><p>1998 -</p></div>
					<p class="history">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
				 <div class="clear"></div>
				</div>
				 <div class="history-desc">
					<div class="year"><p>2001 -</p></div>
					<p class="history">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.</p>
				 <div class="clear"></div>
				</div>
				 <div class="history-desc">
					<div class="year"><p>2006 -</p></div>
					<p class="history">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
				 <div class="clear"></div>
				</div>
				 <div class="history-desc">
					<div class="year"><p>2010 -</p></div>
					<p class="history">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
				 <div class="clear"></div>
				</div>
				<div class="history-desc">
					<div class="year"><p>2013 -</p></div>
					<p class="history">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.</p>
				 <div class="clear"></div>
				</div>
			</div>
				<div class="col_1_of_3 span_1_of_3">
					<h3>Opportunities</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				    <div class="list">
					     <ul>
					     	<li><a href="#">Text of the printing</a></li>
					     	<li><a href="#">Lorem Ipsum has been the standard</a></li>
					     	<li><a href="#">Dummy text ever since the 1500s</a></li>
					     	<li><a href="#">Unknown printer took a galley</a></li>
					     	<li><a href="#">Led it to make a type specimen</a></li>
					     	<li><a href="#">Not only five centuries</a></li>
					     	<li><a href="#">Electronic typesetting</a></li>
					     	<li><a href="#">Unchanged. It was popularised</a></li>
					     	<li><a href="#">Sheets containing Lorem Ipsume</a></li>
					     </ul>
					 </div>
					 <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>
			</div>			
    </div>
 </div>
</div>
  
<jsp:include page="/WEB-INF/views/footer.jsp" />

 <!--   <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script> -->
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

