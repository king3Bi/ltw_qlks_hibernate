<%@page import="com.nhom2.qlks.hibernate.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="container" style="min-height:500px">
<h1 class="text-center mt-5 text-info display-4 font-weight-bold">Lịch sử đặt phòng</h1>

<table class="table mt-5 h3 ">
    <tr>
        <th>Mã booking</th>
        <th>Phòng</th>
        <th>Số người</th>
        <th>Check-in</th>
        <th>Check-out</th>
        <th>Đơn giá</th>
        <th></th>
    </tr>

	<%User user = (User) session.getAttribute("user");%>
	<% if (user != null) { %>
        <tr>
            <td colspan="7" class="text-center">Không có booking nào</td>
        </tr>
    
        
        <tr id="booking-id">
           <!--  <td>{{ booking.id_booking }}</td>
            <td>{{ booking.phong.ten_phong }}</td>
            <td>{{ booking.so_nguoi }}</td>
            <td>{{ booking.co_nguoi_nuoc_ngoai }}</td>
            <td>{{ booking.check_in }}</td>
            <td>{{ booking.check_out }}</td>
            <td>{{ '{:,.0f}'.format(booking.phong.loai_phong.don_gia|float)}} VNĐ</td>
        </tr> -->
        
    <% } %>
</table>

</div>
