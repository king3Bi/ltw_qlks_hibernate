<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <%@ page import="com.TransportPortal.MyFunctions.* "%> -->
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
	<link rel="stylesheet" href="static/css/register-customer.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

</head>
<body>
    <div class="container">
		<div class="img">
			<img src="static/image/background-login.svg">
		</div>
		<div class="login-content">
			<form action="<%=request.getContextPath()%>/register" method="post" accept-charset="utf-8">
				<img src="static/image/avatar.svg">
				<h2 class="title">Đăng ký</h2>

				<div class="info">
					<div>
						<div class="input-div one">
							<div class="i">
									<i class="fas fa-user"></i>
							</div>
							<div class="div">
									<h5>Họ tên</h5>
									<input type="text" name="name" class="input">
							</div>
						 </div>

						 <div class="select-div one">
							<div class="i">
									<i class="fas fa-calendar-day"></i>
							</div>
							<div class="div">
									<h5>Ngày sinh</h5>
									<input type="date" name="dob" class="select">
							</div>
						 </div>

						 <div class="select-div one">
							<div class="i">
								<i class="fas fa-venus-mars"></i>
							</div>
							<div class="div">
								<h5>Giới tính</h5>
								<select name="gender" name="gender" class="select">
									<option selected disabled>Chọn giới tính</option>
									<option value="Nam">Nam</option>
									<option value="Nữ">Nữ</option>
								</select>
							</div>
						 </div>

						<div class="input-div one">
							<div class="i">
									<i class="fas fa-id-card"></i>
							</div>
							<div class="div">
									<h5>CMND</h5>
									<input type="text" name="id-card" class="input">
							</div>
						</div>

						<div class="input-div one">
							<div class="i">
									<i class="fas fa-envelope"></i>
							</div>
							<div class="div">
									<h5>Email</h5>
									<input type="email" name="email" class="input">
							</div>
						 </div>

						 <div class="input-div one">
							<div class="i">
									<i class="fas fa-phone"></i>
							</div>
							<div class="div">
									<h5>Số điện thoại</h5>
									<input type="text" name="phone" class="input">
							</div>
						 </div>
					</div>

					<div>
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
                    <div class="input-div pass">
                      <div class="i">
							   <i class="fas fa-lock"></i>
						  </div>
						  <div class="div">
							   <h5>Nhập lại mật khẩu</h5>
							   <input type="password" name="confirm-password" class="input">
						   </div>
						</div>
					</div>

				</div>
				
				<!-- <h5>hiện lỗi</h5> -->
				<div>${errMessage}</div>
				<!-- {% if err_msg %}
					<div class="alert">
						{{ err_msg }}
					</div>
				{% endif %} -->
				
            	<input type="submit" class="btn" value="Đăng ký">
				<a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
            </form>
        </div>
    </div>
    
    <script type="text/javascript" src="static/js/login-customer.js"></script>
</body>
</html>