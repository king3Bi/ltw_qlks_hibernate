
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
	<title>Quản lý nhân vien</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<script
		src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
	<script src='https://kit.fontawesome.com/a076d05399.js'
		crossorigin='anonymous'></script>
	<script src="<%=request.getContextPath()%>/static/js/script.js"></script>
	
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
						<h1 class="h3 text-center text-gray-800 mb-0">Quản lý Khách Hàng</h1>
					</div>
				</div>
			</section>

			<section class="content">

				<div class="container-fluid">												
				
					<ul class="nav nav-tabs">
						<li class="nav-item">							
							<a class="nav-link active" href="<c:url value='/admin/online-customer'/>">Tất cả</a>
						</li>								
																							   
					</ul>									
					
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Họ tên</th>
									<th>Ngày sinh</th>
									<th>Giới tính</th>
									<th>SDT</th>
									<th>Kích hoạt</th>
									<th>CMND</th>
									<th>Quyền</th>
								</tr>
							</thead>
							<tbody>																
								
								<c:forEach items="${user}" var="user">						
									<tr>
										<td><c:out value="${user.hoTen}"></c:out></td>
										<td><c:out value="${user.ngaySinh}"></c:out></td>
										<td><c:out value="${user.gioiTinh}"></c:out></td>
										<td><c:out value="${user.sdt}"></c:out></td>
										<c:if test="${user.kichHoat == 1}">
										<td><i class="fas fa-check"></i></td>
										</c:if>
										<c:if test="${user.kichHoat == 0}">
										<td><i class="fas fa-minus"></i></td>
										</c:if>
										
										<td><c:out value="${user.cmnd}"></c:out></td>
										<td><c:out value="${user.quyen.tenQuyen}"></c:out></td>							
										<td>
											<c:if test="${user.kichHoat == 1}">
											<a class="btn btn-primary" href="<c:url value='online-customer/kichhoat'/>?user-id=${user.id}">Vô hiệu hoá</a>
											</c:if>
											
											<c:if test="${user.kichHoat == 0}">
											<a class="btn btn-primary" href="<c:url value='online-customer/kichhoat'/>?user-id=${user.id}">Kích hoạt</a>
											</c:if>
											
											
										</td>
									</tr>															
								</c:forEach>
																						
							</tbody>
						</table>
					</div>
					<!-- end table-responsive -->
				</div>

			</section>

		</div>
		<!-- end content-wrapper -->
	</div>


</body>
</html>