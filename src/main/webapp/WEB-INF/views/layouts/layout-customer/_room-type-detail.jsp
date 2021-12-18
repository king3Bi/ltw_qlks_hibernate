<%@page import="com.nhom2.qlks.hibernate.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="container mt-5">
    <div class="row ng-scope">
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-body text-left">
                    <div><img class="mt-5 center-block img-responsive img-circle img-thumbnail thumb96"
                                       src='<c:url value="${roomTypeDetail.hinhAnh}"/>' alt="${roomTypeDetail.tenLoaiPhong} }">
                    </div>
                    <h1 class="mt-5 display-3 font-weight-bold">${roomTypeDetail.tenLoaiPhong}</h1>
                    <h2 class="mt-5 font-weight-bold">Số người: ${roomTypeDetail.soNguoi}</h2>
                    <div class="mv-lg">
                        <h4 class="">${roomTypeDetail.ghiChu}</h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 bg-white border rounded shadow p-5 mb-5">
            <div class="panel panel-default">
                <div class="panel-body mt-3 mb-3">
                    <div class="display-4 font-weight-bold text-center">Booking</div>
                    <div class="row mt-5">
                        <div class="col-lg-2"></div>
                        <div class="col-lg-10">
                            <form class="form-horizontal" action="">
                                <h1 class="col-sm font-weight-bold mb-5">Tổng tiền: <span id="total-price">0</span> VNĐ </h1>

                                <h3 class="col-sm font-weight-bold mb-3">Đơn giá: ${roomTypeDetail.getDonGia()} VNĐ / 1 đêm</h3>

                                <div class="form-group">
                                    <label class="font-weight-bold col-sm control-label"
                                           for="numPeople">Số người <strong style="color: red">*</strong></label>
                                    <div class="col-sm-10">
                                        <select class="form-control form-control-lg" id="numPeople" name="numPeople"
                                                onchange="totalPrice(${roomTypeDetail.getIdLoaiPhong()})">
                                        	<c:forEach var = "i" begin = "1" end = "${roomTypeDetail.getSoNguoi()}">
         										<option><c:out value = "${i}"/></option>
      										</c:forEach>
                                        </select>
                                    </div>
                                </div>                          

                                <div class="form-group">
                                    <label class="font-weight-bold col-sm control-label">Check in <strong
                                            style="color: red">*</strong></label>
                                    <div class="col-sm-10">
                                        <input id="check-in"
                                               class="form-control form-control-lg"
                                               type="date"
                                               name="checkin"
                                               required
                                               onchange="roomSearchCustomer(${roomTypeDetail.getIdLoaiPhong()});
                                                        totalPrice(${roomTypeDetail.getIdLoaiPhong()})">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="font-weight-bold col-sm control-label">Check out <strong
                                            style="color: red">*</strong></label>
                                    <div class="col-sm-10">
                                        <input id="check-out"
                                               class="form-control form-control-lg"
                                               type="date"
                                               name="checkout"
                                               onchange="roomSearchCustomer(${roomTypeDetail.getIdLoaiPhong()});
                                                            totalPrice(${roomTypeDetail.getIdLoaiPhong()})">
                                    </div>
                                </div>

                                <script>
                                    document.querySelector("#check-in").valueAsDate = new Date()
                                    document.querySelector("#check-in").min = document.querySelector("#check-in").value
                                    document.querySelector("#check-out").valueAsDate = new Date()
                                    document.querySelector("#check-out").stepUp(1)
                                    document.querySelector("#check-out").min = document.querySelector("#check-out").value
                                    document.querySelector("#check-out").value = ''
                                </script>

                                <div class="form-group">
                                    <label class="font-weight-bold col-sm control-label"
                                           for="room-list">Phòng <strong style="color: red">*</strong></label>
                                    <div class="col-sm-10">
                                        <select class="form-control form-control-lg" name="room" id="room-list">
                                        	<%-- <c:forEach items="rooms" value="room">
                                        		<option>${room.getTenPhong}</option>
                                        	</c:forEach> --%>
                                        </select>
                                    </div>
                                </div>
                                <!-- {% if err_msg %}
                                <div class="alert">
                                    {{ err_msg }}
                                </div>
                                {% endif %} -->
            
                            </form>
                            <div class="col-sm-offset-2 col-sm-10">
                            	<%User user = (User) session.getAttribute("user");%>
                                <% if (user != null) { %>
                                	<button id="btnCreateBooking" class="btn btn-info" type="button" onclick="createBookingOnline({{ current_user.id }},
                                                                                                    {{room_type_detail.id_loai_phong}})">Đặt phòng</button>
                                <% } else {%>
                                	<a href="<c:url value='login?next=/room-type'/>?id=${roomTypeDetail.getIdLoaiPhong()}">Đăng nhập để đặt phòng</a>
                                	
                                <% } %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
	function roomSearchCustomer(idRoomType) {
	    let checkIn = document.querySelector("#check-in").value;
	    let checkOut = document.querySelector("#check-out").value;
	
	    const uri = "<%=request.getContextPath()%>/api/find-rooms-by-room-type?" +
	        "room-type=" + idRoomType +
	        "&check-in=" + checkIn +
	        "&check-out=" + checkOut;
	
	    //chi khi nao nguoi dung dien thoi gian checkin, checkout thi se tao moi 1 request
	    if (checkIn == "" || checkOut == "") {
	        return;
	    }
	    fetch(uri, {
	        method: 'get',
	        headers: {
	            "Content-Type": "application/json"
	        }
	    }).then(function(res) {
	        console.info(res)
	        return res.json()
	    }).then(function(data) {
	        console.info(data)
	            document.getElementById("room-list").options.length = 0;
	
	            let roomList = document.getElementById("room-list")
	
	            if (data.length == 0) {
	                var opt = document.createElement('option');
	                opt.value = "room";
	                opt.innerHTML = "Không có phòng thỏa điều kiện";
	                roomList.appendChild(opt);
	            } else{
	                for (let room of data){
	                    var opt = document.createElement('option');
	                    opt.value = room.tenPhong;
	                    opt.innerHTML = room.tenPhong;
	                    roomList.appendChild(opt);
	                }
	            }
	    });
	}
</script>