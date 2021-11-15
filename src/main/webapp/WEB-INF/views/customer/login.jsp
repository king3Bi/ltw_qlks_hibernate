<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
	<link rel="stylesheet" href="static/css/login-customer.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="img">
			<img src="static/image/background-login.svg">
		</div>
		<div class="login-content">
			<form action="${pageContext.request.contextPath}/login" method="post">
				<img src="static/image/avatar.svg">
				<h2 class="title">Maris</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Tên đăng nhập</h5>
           		   		<input type="text" name="username" class="input">
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i">
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Mật khẩu</h5>
           		    	<input type="password" name="password" class="input">
            	   </div>
            	</div>
            	
            	<!-- <h5>hiện lỗi</h5> -->
            	<div>${errMessage}</div>
				<!-- {% if err_msg %}
					<div class="alert">
						{{ err_msg }}
					</div>
				{% endif %} -->
				<div class="link">
					<a href="${pageContext.request.contextPath}/register">Đăng ký</a>
					<a href="${pageContext.request.contextPath}/fogot-password">Quên mật khẩu</a>
				</div>
            	<input type="submit" class="btn" value="Đăng nhập">
            </form>
        </div>
    </div>
    
	<script type="text/javascript" src="static/js/login-customer.js"></script>
</body>
</html>