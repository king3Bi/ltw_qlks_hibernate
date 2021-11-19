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
		<title>ADMIN</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	        <!-- custom css file link  -->
	        <!-- <link rel="stylesheet" href="static/css/style.css">  -->
	        <link href="https://fonts.googleapis.com/css?family=Poppins:100;300;400;500;600&display=swap" rel="stylesheet">
	        <script src="static/js/script.js"></script>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/layouts/layout-admin/_header-admin.jsp"></jsp:include>
		
		<div class="container">
			<% String idLoaiPhongStr = request.getParameter("room-type"); %>
			<% int idLoaiPhong; %>
			<ul class="nav nav-tabs">
			  <li class="nav-item">
			  	<% if (idLoaiPhongStr == null || idLoaiPhongStr.equals("")) { %>
			  	<% idLoaiPhong = -1; %>
			    <a class="nav-link active" href="<%=request.getContextPath()%>/room">All</a>
			    <% } else { %>
			    <% idLoaiPhong = Integer.parseInt(idLoaiPhongStr); %>
			    <a class="nav-link" href="<%=request.getContextPath()%>/room">All</a>
			    <% } %>
			  </li>
			  
			  <% List<LoaiPhong> lps = (List<LoaiPhong>) request.getAttribute("loaiPhongs"); %>
			  <% List<TrangThai> tts = (List<TrangThai>) request.getAttribute("trangThais"); %>
			  <% for (LoaiPhong lp : lps) { %>
			  <li class="nav-item">
			  	<% if (idLoaiPhong == lp.getIdLoaiPhong()) { %>
			    <a class="nav-link active" href="<%=request.getContextPath()%>/room?room-type=<%= lp.getIdLoaiPhong() %>"><%= lp.getTenLoaiPhong() %></a>
			    <% } else {%>
			    <a class="nav-link" href="<%=request.getContextPath()%>/room?room-type=<%= lp.getIdLoaiPhong() %>"><%= lp.getTenLoaiPhong() %></a>
			    <% } %>
			  </li>
			  <% } %>
			  <li class="nav-item">
			    <a class="nav-link" href="<%=request.getContextPath()%>/room/insert">Create</a>
			  </li>
			</ul>
			
			<table class="table table-striped">
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
		         			<a href="<%=request.getContextPath()%>/room/edit?room-id=<%= p.getIdPhong() %>">Edit</a>
		         			<a href="<%=request.getContextPath()%>/room/delete?room-id=<%= p.getIdPhong() %>">Delete</a>
		         		</td>
		         	</tr>
		      		<% } %>
				</tbody>
			</table>
		</div>
		
	</body>
</html>