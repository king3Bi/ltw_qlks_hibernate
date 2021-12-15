<%@page import="com.nhom2.qlks.hibernate.pojo.Phong"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.TrangThai"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.LoaiPhong"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Chỉnh sửa thông tin nhân viên</title>
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<script   src="https://code.jquery.com/jquery-2.2.3.min.js"   integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="   crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js"></script>
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/css/bootstrap-datepicker3.min.css">
		<script>
		$( document ).ready(function() {
		    $("#user-sn").datepicker({ 
		        format: 'yyyy-mm-dd'
		    });
		    $("#user-sn").on("change", function () {
		        var fromdate = $(this).val();
		        alert(fromdate);
		    });
		}); 
		</script>
		<script
			src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
		<script src='https://kit.fontawesome.com/a076d05399.js'
			crossorigin='anonymous'></script>
		<script src="<%=request.getContextPath()%>/static/js/script.js"></script>
	</head>
	<body>
		
		<div class="wrapper">

			<jsp:include
				page="/WEB-INF/views/layouts/layout-admin/_header-admin.jsp"></jsp:include>
			<script>
				document.querySelector(".nav-sidebar").children[6].classList
						.add('menu-open');
				document.querySelector(".menu-open .nav-link").classList
						.add('active');
				
			</script>
	
			<div class="content-wrapper">
				<section class="content-header">
					<div class="container-fluid">
						<div class="col-11 ">
							<h1 class="h3 text-center text-gray-800 mb-0">Chỉnh sửa thông tin nhân viên</h1>
						</div>
					</div>
				</section>
	
				<section class="content">
	
					<div class="container-fluid">																													
						
						<div class="table-responsive">
					
							<form action="edit" method="post">
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
									<select id="user-gt" name="user-gt" class="custom-select">
										<option disabled>Chọn Giới Tính Nhân Viên</option>
									
										<option value="Nam"<c:if test="${user.gioiTinh == 'Nam' || user.gioiTinh == 'nam'}">selected="selected"</c:if>>
                                                            Nam
                                                    </option>		
                                                    <option value="Nữ"<c:if test="${user.gioiTinh == 'Nữ' || user.gioiTinh == 'nữ'}">selected="selected"</c:if>>
                                                            Nữ
                                                    </option>
								 	</select>								 	
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

							</form>
							<!-- end form -->			
						</div>	
					</div>
	
				</section>
	
			</div>
			<!-- end content-wrapper -->
		</div>
		
	</body>
</html>