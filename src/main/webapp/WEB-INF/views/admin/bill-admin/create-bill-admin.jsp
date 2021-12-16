<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>ADMIN</title>
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
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="/WEB-INF/views/layouts/layout-admin/_header-admin.jsp"></jsp:include>
			<script>
				document.querySelector(".nav-sidebar").children[1].classList
						.add('menu-open');
				document.querySelector(".menu-open .nav-link").classList
						.add('active');
			</script>
			
			<div class="content-wrapper">
				<section class="content-header mb-5">
					<div class="container-fluid">
						<div class="col-11 ">
							<h1 class="h3 text-center text-gray-800 mb-0">Lập hóa đơn</h1>
						</div>
					</div>
				</section>
				
				<section class="content">
					<div class="container-fluid">
					<div class="row">
						<div class="col">
							<script type="text/javascript">
								function showResult(roomName) {
									$.get(
											"<%=request.getContextPath()%>/api/find-booking?roomName=" + roomName,
											function(data){
												console.log(data);
											});
								}
							</script>
							<h3>Thông tin booking</h3>
							<table class="m-auto">
					            <tbody>
					            <tr>
					                <td>Phòng</td>
					                <td style="position: relative;">
					                    <input class="form-control mr-sm-2" id="ten_phong" 
					                    	name="kw" type="text" placeholder="Nhập số phòng..." 
					                    	oninput="showResult(this.value)">
					                    <div id="livesearch"></div>
					                </td>
					            </tr>
					            <tr>
					                <td>Số người</td>
					                <td>
					                    <input type="number" id="so_nguoi" class="form-control" disabled="">
					                </td>
					            </tr>
					            <tr>
					                <td>Check in</td>
					                <td>
					                    <input type="date" id="check_in" class="form-control" disabled="">
					                </td>
					            </tr>
					            <tr>
					                <td>Check out</td>
					                <td>
					                    <input type="date" id="check_out" class="form-control" disabled="">
					                </td>
					            </tr>
					            <tr>
					                <td>Đơn giá</td>
					                <td>
					                    <input id="don_gia" class="form-control" disabled="">
					                </td>
					            </tr>
					            </tbody>
					        </table>
							<div class="mt-3 d-flex justify-content-around">
					            <input type="hidden" id="id_booking">
					            <input type="hidden" id="thoi_gian_thue">
					            <input type="hidden" id="thanh_tien">
					            <button class="btn btn-primary ml-5" onclick="themBooking()">
					                Thêm vào hóa đơn
					            </button>
					            <button class="btn btn-primary mr-5" onclick="taiLai()">
					                Tải lại
					            </button>
					
					        </div>
					        <div class="mt-3" style="height:250px; overflow-y: scroll;">
					        	<table class="table">
					        		<thead>
					        			<th>Id booking</th>
					        			<th>Phòng</th>
					                    <th>Số ngày thuê</th>
					                    <th>Đơn giá</th>
					                    <th>Thành tiền</th>
					        		</thead>
					        		<tbody>
					        		</tbody>
					        	</table>
					        </div>
					        
						</div>
						<div class="col">
							<div id="printJS-form">
					            <h4>Chi tiết hóa đơn</h4>
					            <h5 id="id-HD"></h5>
					            <h6 id="ngay-tao"></h6>
					
					            <table id="bill-detail" class="table table-striped">
					                <thead>
					                <tr>
					                    <th>STT</th>
					                    <th>Phòng</th>
					                    <th>Số ngày thuê</th>
					                    <th>Đơn giá</th>
					                    <th>Thành tiền</th>
					                </tr>
					                </thead>
					                <tbody id="tb_bill_detail"></tbody>
					            </table>
					            <label>Tổng tiền <span id="tong_tien">0</span> VNĐ</label>
					        </div>
					        <div>
					            <button type="button" class="btn btn-primary mb-2" onclick="pay()">Thanh toán</button>
					        </div>
						</div>
					</div>
					</div>
				</section>
				
			</div>
			
		</div>
		
	</body>
</html>