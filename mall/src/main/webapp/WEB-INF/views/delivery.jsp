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
<script type="text/javascript" src="/mall/resources/template/js/jquery.accordion.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#posts").accordion({ 
			header: "div.tab", 
			alwaysOpen: false,
			autoheight: false
		});
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
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="/mall/resources/template/images/delivery-img1.jpg" alt="" />
					  <h3>Lorem Ipsum is simply dummy text </h3>
					  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="/mall/resources/template/images/delivery-img2.jpg" alt="" />
					  <h3>Lorem Ipsum is simply dummy text </h3>
					  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="/mall/resources/template/images/delivery-img3.jpg" alt="" />
					  <h3>Lorem Ipsum is simply dummy text </h3>
					  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>
			</div>	
		<div class="faqs">
    	  <h2>Frequently Asked Questions</h2>	          	
            <div id="posts">
			    <div class="tab bar">
                    <h4 class="post-title">1.What is Lorem Ipsum?</h4>
                </div>
			    <div class="panel margin-lr-7">
            		<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			    </div>		   
                <div class="tab bar">
                     <h4 class="post-title"> 2.What is Lorem Ipsum Lorem Ipsum has been the industry's standard dummy text?</h4>
                </div>
				<div class="panel margin-lr-7">
	        		 <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                </div>
                <div class="tab bar">
                     <h4 class="post-title"> 3.What is Lorem Ipsum Lorem Ipsum has been the industry's?</h4>
                </div>
				<div class="panel margin-lr-7">
	        		 <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                </div>
				<div class="tab bar">
                    <h4 class="post-title"> 4.What is Lorem Ipsum dummy text of the printing?</h4>
            	</div>
			 	<div class="panel margin-lr-7">
	        		<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
             	</div>
                <div class="tab bar">
                    <h4 class="post-title"> 5.What is Lorem Ipsum printing and typesetting industry?</h4>
                </div>
			    <div class="panel margin-lr-7">
	        	     <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                </div>
                <div class="tab bar">
                    <h4 class="post-title"> 6.What is Lorem Ipsum text of the printing?</h4>
            	</div>
				<div class="panel margin-lr-7">
                      <p>Pellentesque ornare sem lacinia quam venenatis vestibulum. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Donec id elit non mi porta gravida at eget metus.</p>
                </div>
                <div class="tab bar">
                    <h4 class="post-title"> 7.What is Lorem Ipsum?</h4>
            	</div>
				<div class="panel margin-lr-7">
	        	     <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                </div>
                <div class="tab bar">
                    <h4 class="post-title"> 8.What is Lorem Ipsum dummy text ever since the 1500s?</h4>
            	</div>
				<div class="panel margin-lr-7">
	        	     <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                </div>
                <div class="tab bar">
                    <h4 class="post-title"> 9.What is Lorem Ipsum  Lorem Ipsum has been the industry's standard dummy text?</h4>
            	</div>
				<div class="panel margin-lr-7">
                      <p>Pellentesque ornare sem lacinia quam venenatis vestibulum. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Donec id elit non mi porta gravida at eget metus.</p>
                </div>
                <div class="tab bar">
                    <h4 class="post-title"> 10.What is Lorem Ipsum typesetting industry?</h4>
            	</div>
				<div class="panel margin-lr-7">
	        	     <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                </div>
		       </div>
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

