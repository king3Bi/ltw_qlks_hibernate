<%@page import="com.nhom2.qlks.hibernate.pojo.LoaiPhong"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section class="room-type" id="room-type">

    <h1 class="heading"> Loại <span>phòng</span> </h1>

    <ul class="pagination">
      <!--   {% for i in range(1, page_num+1) %}
            <li class="page-item"><a class="page-link" href="/?page={{ i }}">{{ i }}</a></li>
        {% endfor %} -->
    </ul>

    <div class="row">
    	<% List<LoaiPhong> loaiPhongs = (List<LoaiPhong>) request.getAttribute("loaiPhongs"); %>
    	 
        <% for (LoaiPhong lp : loaiPhongs) { %>
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="card">
                    <img class="card-img-top" src="static/image/banner-hotel.jpg" alt="Card image">
                    <div class="card-body">
                        <h3 class="card-title"><%= lp.getTenLoaiPhong() %></h3>
                        <h3 class="card-title">Số người: <%= lp.getSoNguoi() %></h3>                        
                        <h4 class="card-title"><%= lp.getDonGia() %> VND / 1 đêm</h4>
                        <a href="#" class="btn">Đặt phòng</a>
                    </div>
                </div>
            </div>
         <% } %>
    </div>

</section>