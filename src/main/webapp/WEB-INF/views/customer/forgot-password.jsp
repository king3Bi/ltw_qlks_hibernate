<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <%@ page import="com.TransportPortal.MyFunctions.* "%> -->
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
	<link rel="stylesheet" href="static/css/register-customer.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

</head>
<body>
    <div class="container">
		<div class="img">
			<img src="static/image/background-login.svg">
		</div>
		<div class="login-content">
			<form action="${pageContext.request.contextPath}/forgot-password" method="post">
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
            	
            	<!-- <h5>hiện lỗi</h5> -->
            	<div>${errMessage}</div>
				<!-- {% if err_msg %}
					<div class="alert">
						{{ err_msg }}
					</div>
				{% endif %} -->
				<input type="submit" class="btn" value="Tiếp theo">
				<a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
            </form>
        </div>
    </div>
    
    <script type="text/javascript" src="static/js/login-customer.js"></script>
</body>
</html>