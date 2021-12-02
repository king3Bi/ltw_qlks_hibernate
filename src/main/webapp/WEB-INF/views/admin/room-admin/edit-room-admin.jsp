<%@page import="com.nhom2.qlks.hibernate.pojo.Phong"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.TrangThai"%>
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
		<title>Chỉnh sửa thông tin phòng</title>
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
                         	<h1 class="h3 text-center text-gray-800 mb-0">Chỉnh sửa thông tin phòng</h1>
                    	</div>
                	</div>
            	</nav>
            	
				<% Phong phong = (Phong) request.getAttribute("phong"); %>
				<ul class="nav nav-tabs">
					<%  %>
				  <li class="nav-item">
				    <a class="nav-link" href="<%=request.getContextPath()%>/admin/room">All</a>
				  </li>
				  <% List<LoaiPhong> lps = (List<LoaiPhong>) request.getAttribute("loaiPhongs"); %>
				  <% for (LoaiPhong lp : lps) { %>
				  <li class="nav-item">
				    <a class="nav-link" href="<%=request.getContextPath()%>/admin/room?room-type=<%= lp.getIdLoaiPhong() %>"><%= lp.getTenLoaiPhong() %></a>
				  </li>
				  <% } %>
				  <li class="nav-item">
				    <a class="nav-link" href="<%=request.getContextPath()%>/admin/room/insert">Create</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link active" href="<%=request.getContextPath()%>/admin/room/edit?room-id=<%= phong.getIdPhong() %>">Edit</a>
				  </li>
				</ul>
				
				<% if (phong != null) { %>
				<form action="" method="post">
				  <div class="form-group">
				    <label for="room-name">Tên phòng:</label>
				    <input type="text" id="room-name" 
				    	class="form-control" placeholder="Nhập tên phòng" 
				    	name="room-name" value="<%= phong.getTenPhong() %>">
				  </div>
				  <div class="form-group">
				    <label for="room-type">Loại phòng:</label>
				    <select id="roomType" name="room-type" class="custom-select">
					    <option disabled>Chọn loại phòng</option>
						<% for (LoaiPhong lp : lps) { %>
						<option value="<%= lp.getIdLoaiPhong() %>"><%= lp.getTenLoaiPhong() %></option>
			      		<% } %>
			      	</select>
				  </div>
				  <div class="form-group">
				    <label for="room-status">Trạng thái:</label>
				    <select id="roomStatus" name="room-status" class="custom-select">
					    <option disabled>Chọn trạng thái</option>
					    <% List<TrangThai> tts = (List<TrangThai>) request.getAttribute("trangThais"); %>
						<% for (TrangThai tt : tts) { %>
						<option value="<%= tt.getIdTrangThai() %>"><%= tt.getTenTrangThai() %></option>
			      		<% } %>
			      	</select>
			      	<script type="text/javascript">
			      		roomType.value = <%= phong.getLoaiPhong().getIdLoaiPhong()%>;
			      		roomStatus.value = <%= phong.getTrangThai().getIdTrangThai()%>
			      		</script>
				  </div>
				  <button type="submit" class="btn btn-primary">Lưu</button>
				</form>
				<% } %>
			</div>
			
		</div>
		
	</body>
</html>