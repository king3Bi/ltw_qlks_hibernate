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
			<ul class="nav nav-tabs">
			  <li class="nav-item">
			    <a class="nav-link" href="<%=request.getContextPath()%>/room-type">List</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link active" href="<%=request.getContextPath()%>/room-type/insert">Create</a>
			  </li>
			</ul>
		
			<form action="" method="post" enctype="multipart/form-data">
			  <div class="form-group">
			    <label for="name">Tên Loại phòng:</label>
			    <input type="text" id="name" class="form-control" placeholder="Nhập tên phòng" name="name">
			  </div>
			  <div class="form-group">
			    <label for="image">Hình ảnh:</label>
			    <input type="file" id="image" class="form-control-file border" accept="image/png, image/gif, image/jpeg" name="image">
			  </div>
			  <img class="card-img-top" style="width: 200px; height: auto;"
			  	src="<%=request.getContextPath()%>/static/image/banner-hotel.jpg" alt="Hình ảnh loại phòng" id="showImage">
			  <div class="form-group">
			    <label for="price">Đơn giá:</label>
			    <input type="text" id="price" class="form-control" placeholder="Nhập tên phòng" name="price">
			  </div>
			  <div class="form-group">
			    <label for="quantity">Số người:</label>
			    <input type="text" id="quantity" class="form-control" placeholder="Nhập tên phòng" name="quantity">
			  </div>
			  <div class="form-group">
			  	<label for="note">Ghi chú:</label>
				<textarea class="form-control" rows="5" id="note" name="note"></textarea>
			  </div>
			  <button type="submit" class="btn btn-primary">Lưu</button>
			</form>
			<script>
				image.onchange = evt => {
					  const [file] = image.files
					  if (file) {
						  showImage.src = URL.createObjectURL(file)
					  }
					}
			</script>
		</div>
		
	</body>
</html>