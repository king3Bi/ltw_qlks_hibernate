<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Quản lý booking offline</title>
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
	<!-- link fontawesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/v4-shims.css">
	<script src="<%=request.getContextPath()%>/static/js/script.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include
			page="/WEB-INF/views/layouts/layout-admin/_header-admin.jsp"></jsp:include>
		<script>
			$( "li:nth-child(3)").addClass('menu-is-opening menu-open');
			$( "li:nth-child(3) > ul > li:nth-child(1)" ).children().addClass('active');
									
			/* function openCustomerList(bookingId) {
				var url = "<c:url value='booking-offline/customer'/>?booking-id=" + bookingId;
				$.ajax({
					type: "GET",
			    	url: url,
			     	success: function(data)
			    	{
			        	if (data.code == 200) {
			        		console.log(data);
			        		document.querySelector("#ten-phong-pt").value = data.data.tenPhong;
			        		document.querySelector("#check-in-pt").value = data.data.checkIn;
			        		document.querySelector("#check-out-pt").value = data.data.checkOut;
			        		document.querySelector("#so-nguoi-pt").value = data.data.soNguoi;
			        		   
			        		$("#room-form").attr("action", url);
			   				$("#customerListModal").modal();
			        	} else {
			        		$("#room-form").attr("action", url);
			   				$("#customerListModal").modal();
			       		}
			     	}
				});
			} */
		</script>

		<div class="content-wrapper">
			<section class="content-header">
				<div class="container-fluid">
					<div class="col-11 ">
						<h1 class="h3 text-center text-gray-800 mb-0">Quản lý booking offline</h1>
					</div>
				</div>
			</section>

			<section class="content">

				<div class="container-fluid">
					<ul class="nav nav-tabs">
						<li class="nav-item"><a class="nav-link active"
							href="<c:url value="booking-offline"/>">Tất cả</a></li>						
					</ul>

					<table class="table table-striped">
						<thead>
							<tr>
								<th>Mã booking</th>
								<th>Số người</th>
								<th>Check in</th>
								<th>Check out</th>
								<th>Đơn giá</th>
								<th>Phòng</th>
								<th>Nhân viên tạo</th>
								<th>Mã hóa đơn</th>
								<th>Khách</th>															
							</tr>
						</thead>
						<tbody>							
							
							<c:forEach items="${bookings}" var="booking">
								<tr>
									<td><c:out value="${booking.idBooking}"></c:out></td>
									<td><c:out value="${booking.soNguoi}"></c:out></td>								
									<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${booking.checkIn}"/></td>
									<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${booking.checkOut}"/></td>			
									<td><c:out value="${booking.phong.loaiPhong.donGia}"></c:out></td>
									<td><c:out value="${booking.phong.tenPhong}"></c:out></td>
									<td><c:out value="${booking.user.tenDangNhap}"></c:out></td>															
									<td><c:out value="${booking.hoaDon.idHD}"></c:out></td>															
									<td>	
										<c:choose>
	         										
									         <c:when test = "${booking.khachHangs.size() > 0}">
									            <a class="btn btn-primary" 
									            	onclick="openCustomerList(${booking.idBooking})" 
									            	href="javascript:void(0)">
									            	Xem
									            </a>
									         </c:when>										         										      
									         
									         <c:otherwise>
									            <a class="btn btn-success" 
									            	onclick="openAddCustomerList()"
									            	href="javascript:void(0)">
									            	Thêm
									            </a>
									         </c:otherwise>
										         
										</c:choose>
									</td>															
								</tr>															
							</c:forEach>							
							
						</tbody>
					</table>
				</div>

			</section>
		</div>
	</div>
	
	
	<div class="modal fade" id="customerListModal">
	    <div class="modal-dialog modal-lg modal-dialog-centered">
	        <div class="modal-content">
	
	            <!-- Modal Header -->
	            <div class="modal-header">
	                <h4 class="modal-title">Thông tin khách hàng</h4>
	                <button type="button" class="close" data-dismiss="modal">×</button>
	            </div>
	
	            <!-- Modal body -->
	            <div class="modal-body">
	                <div class="row">
	                    <div class="col">
	                        <label for="ten-phong-pt">Phòng</label></br>
	                        <input id="ten-phong-pt" type="text" disabled/>
	                    </div>
	                    <div class="col">
	                        <label for="check-in-pt">Check in</label></br>
	                        <input id="check-in-pt" type="date" disabled/>
	                    </div>
	                    <div class="col">
	                        <label for="check-out-pt">Check out</label></br>
	                        <input id="check-out-pt" type="date" disabled/>
	                    </div>
	                    <div class="col">
	                        <label for="so-nguoi-pt">Số người</label></br>
	                        <input id="so-nguoi-pt" type="number" disabled>
	                    </div>
	                </div>
	                <br>
	                <table class="table table-striped">
	                    <thead>
	                    <tr>
	                        <th>STT</th>
	                        <th>Khách hàng</th>
	                        <th>CMND</th>
	                        <th>Địa chỉ</th>
	                    </tr>
	                    </thead>
	                    <tbody id="tb-booking">
	                    
		                    <tr>
		                        <td>i</td>
		                        <td>
		                            <input type="text"/>
		                        </td>
		                        <td>
		                            <input type="text"/>
		                        </td>
		                        <td>
		                            <input type="text"/>
		                        </td>
		                    </tr>
	                
	                    </tbody>
	                </table>
	              
	            </div>
	
	        </div>
	    </div>
	</div>
	
	<script type="text/javascript">
		function openCustomerList(idBooking) {
			$.get(
					"<%=request.getContextPath()%>/api/get-customer-booking?idBooking=" + idBooking,
					function(data) {
						console.log(data);
						$("#customerListModal").modal();
					})
		}
		
		function openAddCustomerList() {
			$("#customerListModal").modal();
		}
	</script>
</body>
</html>