<%@page import="com.nhom2.qlks.hibernate.pojo.LoaiPhong"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Loại phòng</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- link cdn admin template -->
<script
	src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<!-- link script -->
<script src="<%=request.getContextPath()%>/static/js/script.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include
			page="/WEB-INF/views/layouts/layout-admin/_header-admin.jsp"></jsp:include>
		<script>
			document.querySelector(".nav-sidebar").children[5].classList
					.add('menu-open');
			document.querySelector(".menu-open .nav-link").classList
					.add('active');
		</script>

		<div class="content-wrapper">
			<section class="content-header">
				<div class="container-fluid">
					<div class="col-11 ">
						<h1 class="h3 text-center text-gray-800 mb-0">Quản lý loại
							phòng</h1>
					</div>
				</div>
			</section>

			<section class="content">

				<div class="container-fluid">
					<ul class="nav nav-tabs">
						<li class="nav-item"><a class="nav-link active"
							href="<%=request.getContextPath()%>/room-type">Tất cả</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="modal"
							href="#myModal">Thêm</a></li>
					</ul>

					<table class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>Tên loại phòng</th>
								<th>Hình ảnh</th>
								<th>Đơn giá</th>
								<th>Số người</th>
								<th>Ghi chú</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
							List<LoaiPhong> loaiPhongs = (List<LoaiPhong>) request.getAttribute("loaiPhongs");
							%>
							<%
							for (LoaiPhong lp : loaiPhongs) {
							%>
							<tr>
								<td><%=lp.getIdLoaiPhong()%></td>
								<td><%=lp.getTenLoaiPhong()%></td>
								<td><%=lp.getHinhAnh()%></td>
								<td><%=lp.getDonGia()%></td>
								<td><%=lp.getSoNguoi()%></td>
								<td><%=lp.getGhiChu()%></td>
								<td>
									<a class="btn btn-primary"
									href="<%=request.getContextPath()%>/room-type/edit?room-type-id=<%=lp.getIdLoaiPhong()%>">Sửa</a>
									<a class="btn btn-primary"
									href="<%=request.getContextPath()%>/room-type/delete?room-type-id=<%=lp.getIdLoaiPhong()%>">Xóa</a>
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>

			</section>
		</div>
	</div>

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Thêm loại phòng</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="" id="room-form">
						<div class="form-group">
							<label for="room-name">Tên loại phòng:</label> <input type="text"
								id="room-name" class="form-control" placeholder="Nhập tên phòng"
								name="room-name">
						</div>
						<%-- <div class="form-group">
							<label for="room-type">Loại phòng:</label> <select id="room-type"
								name="room-type" class="custom-select">
								<option disabled>Chọn loại phòng</option>
								<%
								for (LoaiPhong lp : lps) {
								%>

								<option value="<%=lp.getIdLoaiPhong()%>"><%=lp.getTenLoaiPhong()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="form-group">
							<label for="room-status">Trạng thái:</label> <select
								id="room-status" name="room-status" class="custom-select">
								<option disabled>Chọn trạng thái</option>
								<%
								for (TrangThai tt : tts) {
								%>

								<option value="<%=tt.getIdTrangThai()%>"><%=tt.getTenTrangThai()%></option>
								<%
								}
								%>
							</select>
						</div> --%>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						onclick="saveCreateRoomType()">Lưu</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Thoát</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>