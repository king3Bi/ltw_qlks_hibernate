<%@page import="com.nhom2.qlks.hibernate.pojo.TrangThai"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.LoaiPhong"%>
<%@page import="com.nhom2.qlks.hibernate.pojo.Phong"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Quản lý phòng</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/static/js/script.js"></script>
		<script type="text/javascript">
			function openEditPhong(id_phong) {
				var url = "<%=request.getContextPath()%>/admin/room/edit?room-id=" + id_phong;
				$.ajax({
					type: "GET",
			    	url: url,
			     	success: function(data)
			    	{
			        	if (data.code == 200) {
			        		console.log(data);
			        		document.querySelector("#room-name").value = data.data.tenPhong;
			        		document.querySelector("#room-type").value = data.data.idLoaiPhong;
			        		document.querySelector("#room-status").value = data.data.idTrangThai;
			        		   
			        		$("#room-form").attr("action", url);
			   				$("#myModal").modal();
			        	} else {
			        		alert(data.msg);
			       		}
			     	}
				});
			}
	
			function openCreatePhong() {
				$("#room-form").attr("action", "<%=request.getContextPath()%>/admin/room/insert");
				$("#myModal").modal();
			}
	
			function saveEditPhong() {
				
			}
	
			function saveCreatePhong(btn) {
				const spinner = btn.firstElementChild;
				spinner.classList.add("spinner-border");
				spinner.classList.add("spinner-border-sm");
				
				btn.disabled = true;
				
				var form = $("#room-form");
				var url = form.attr('action');
				
				$.ajax({
			           type: "POST",
			           url: url,
			           data: form.serialize(), // serializes the form's elements.
			           success: function(data)
			           {
			        	   if (data.code == 200) {
			        		   alert(data.msg);
			        		   location.reload();
			        	   } else {
			        		   alert(data.msg);
			        	   }
			           }				    
				});
				
				spinner.classList.remove("spinner-border");
				spinner.classList.remove("spinner-border-sm");
			    btn.disabled = false;
			}
		</script>
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
                         	<h1 class="h3 text-center text-gray-800 mb-0">Quản lý phòng</h1>
                    	</div>
                	</div>
            	</nav>
			
			
				<% String idLoaiPhongStr = request.getParameter("room-type"); %>
				<% int idLoaiPhong; %>
				<ul class="nav nav-tabs">
				  <li class="nav-item">
				  	<% if (idLoaiPhongStr == null || idLoaiPhongStr.equals("")) { %>
				  	<% idLoaiPhong = -1; %>
				    <a class="nav-link active" href="<%=request.getContextPath()%>/admin/room">All</a>
				    <% } else { %>
				    <% idLoaiPhong = Integer.parseInt(idLoaiPhongStr); %>
				    <a class="nav-link" href="<%=request.getContextPath()%>/admin/room">All</a>
				    <% } %>
				  </li>
				  
				  <% List<LoaiPhong> lps = (List<LoaiPhong>) request.getAttribute("loaiPhongs"); %>
				  <% List<TrangThai> tts = (List<TrangThai>) request.getAttribute("trangThais"); %>
				  <% for (LoaiPhong lp : lps) { %>
				  <li class="nav-item">
				  	<% if (idLoaiPhong == lp.getIdLoaiPhong()) { %>
				    <a class="nav-link active" href="<%=request.getContextPath()%>/admin/room?room-type=<%= lp.getIdLoaiPhong() %>"><%= lp.getTenLoaiPhong() %></a>
				    <% } else {%>
				    <a class="nav-link" href="<%=request.getContextPath()%>/admin/room?room-type=<%= lp.getIdLoaiPhong() %>"><%= lp.getTenLoaiPhong() %></a>
				    <% } %>
				  </li>
				  <% } %>
				  <li class="nav-item">
				  <a class="nav-link" href="javascript:void(0)" onclick="openCreatePhong()">Create</a>
				  <!-- <a class="nav-link" data-toggle="modal" href="#myModal">Create</a> -->
				  </li>
				</ul>
			
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Tên phòng</th>
								<th>Loại phòng</th>
								<th>Trạng thái</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<% List<Phong> phongs = (List<Phong>) request.getAttribute("phongs"); %>
							<% for (Phong p : phongs) { %>
				         	<tr>
				         		<td><%= p.getIdPhong() %></td>
				         		<td><%= p.getTenPhong() %></td>
				         		<td><%= p.getLoaiPhong().getTenLoaiPhong() %></td>
				         		<td><%= p.getTrangThai().getTenTrangThai() %></td>
				         		<td>
				         			<a href="javascript:void(0)" onclick="openEditPhong(<%= p.getIdPhong() %>)">Edit</a>
				         			<a href="<%=request.getContextPath()%>/admin/room/delete?room-id=<%= p.getIdPhong() %>">Delete</a>
				         		</td>
				         	</tr>
				      		<% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<!-- The Modal -->
		<div class="modal fade" id="myModal">
	 		<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
			      
				   	<!-- Modal Header -->
					<div class="modal-header">
				   		<h4 class="modal-title">Thêm phòng</h4>
				  		<button type="button" class="close" data-dismiss="modal">&times;</button>
				  	</div>
				        
				  	<!-- Modal body -->
				  	<div class="modal-body">
				   		<form action="" method="post" id="room-form">
				   			<div class="form-group">
						    <label for="room-name">Tên phòng:</label>
						    <input type="text" id="room-name" class="form-control" placeholder="Nhập tên phòng" name="room-name" required>
						  </div>
						  <div class="form-group">
						    <label for="room-type">Loại phòng:</label>
						    <select id="room-type" name="room-type" class="custom-select">
							    <option disabled>Chọn loại phòng</option>
								<% for (LoaiPhong lp : lps) { %>
								
								<option value="<%= lp.getIdLoaiPhong() %>"><%= lp.getTenLoaiPhong() %></option>
					      		<% } %>
					      	</select>
						  </div>
						  <div class="form-group">
						    <label for="room-status">Trạng thái:</label>
						    <select id="room-status" name="room-status" class="custom-select">
							    <option disabled>Chọn trạng thái</option>
								<% for (TrangThai tt : tts) { %>
								
								<option value="<%= tt.getIdTrangThai() %>"><%= tt.getTenTrangThai() %></option>
					      		<% } %>
					      	</select>
						  </div>
				   		</form>
				   	</div>
				        
				   	<!-- Modal footer -->
				  	<div class="modal-footer">
				  		<button type="button" class="btn btn-primary" onclick="saveCreatePhong(this)">
				  			<span></span>
				  			Lưu
				  		</button>
				     	<button type="button" class="btn btn-danger" data-dismiss="modal">Thoát</button>
				   	</div>
			        
				</div>
			</div>
		</div>
  
		
	</body>
</html>