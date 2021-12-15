<%@page import="com.nhom2.qlks.hibernate.pojo.TrangThai"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.LoaiPhong"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.User"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.Quyen"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Thêm Nhân Viên</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<jsp:include page="/WEB-INF/views/layouts/layout-admin/_header-admin.jsp"></jsp:include>
			<script>
				document.querySelector(".navbar-nav").children[2].classList.add('active')
			</script>
			
			<div id="content">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
                	<div class="container-fluid">
                    	<div class="col-11 ">
                         	<h1 class="h3 text-center text-gray-800 mb-0">Quản lý Nhân Viên</h1>
                    	</div>
                	</div>
            	</nav>
            	
            	
				<form action="" method="post">
								<div class="form-group">
									<label for="user-id">Id User:</label>
									<input type="text" id="user-id" 
										class="form-control"
										name="user-id" value="${user.id}" readonly="readonly">
								</div>
												
								<div class="form-group">
									<label for="username">Tên Nhân viên:</label>
									<input type="text" id="user-name" 
										class="form-control" placeholder="Nhập tên nhân viên" 
										name="user-name" value="${user.hoTen}" required>
								</div>
								<div class="form-group">
									<label for="usersn">Ngày sinh:</label>
									<p>Date: <input type="text" id="user-sn"  name="user-sn"value="${user.ngaySinh}"></p>
										</div>
								<div class="form-group">
									<label for="usergt">Giới Tính Nhân Viên:</label>
														 	
								</div>
								<div class="form-group">
									<label for="usercmnd">Tên CMND:</label>
									<input type="text" id="user-cmnd" 
										class="form-control" placeholder="Nhập CMND" 
										name="user-cmnd" value="${user.cmnd}" required>
								</div>
								<div class="form-group">
									<label for="userem">Tên Email:</label>
									<input type="text" id="user-em" 
										class="form-control" placeholder="Nhập email" 
										name="user-em" value="${user.email}" required>
								</div>
								<div class="form-group">
									<label for="usersdt">Tên Sdt:</label>
									<input type="text" id="user-sdt" 
										class="form-control" placeholder="Nhập sdt" 
										name="user-sdt" value="${user.sdt}" required>
								</div>
								<div class="form-group">
									<label for="usertdn">Tên Dang Nhap:</label>
									<input type="text" id="user-tdn" 
										class="form-control" placeholder="Nhập Ten Tai Khoan" 
										name="user-tdn" required>
								</div>
								<div class="form-group">
									<label for="usermk">MK:</label>
									<input type="text" id="user-mk" 
										class="form-control" placeholder="Nhập MK" 
										name="user-mk" value="${user.sdt}" required>
								</div>
							
								<div class="form-group">
									<label for="userkh">Kích hoạt:</label>
									<input checked="" class="form-control-lg" id="user-kh" name="user-kh" type="checkbox" value="1">
								</div>
								
								<div class="form-group">
									<label for="userq">Quyền Nhân Viên:</label>
									<select id="user-q" name="user-q" class="custom-select">
										<option disabled>Chọn Quyền Nhân Viên</option>
										
								   		<c:forEach items="${quyen}" var="quyen">								   													
											<c:choose>
												<c:when test="${user.quyen.idQuyen ==quyen.idQuyen}">
													<option value="${quyen.idQuyen}" selected="selected">${user.quyen.tenQuyen}</option>		
												</c:when>												
												<c:otherwise>
													<option value="${quyen.idQuyen}">${quyen.tenQuyen}</option>
												</c:otherwise>
											</c:choose>																							
										</c:forEach>
								 	</select>								 	
								</div>
								
								<input type="submit" class="btn btn-success" value="Sửa">

							<!-- end form -->	
				</form>
			</div>
		</div>
	</body>
</html>