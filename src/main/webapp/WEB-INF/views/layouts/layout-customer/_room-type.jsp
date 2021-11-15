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
        {% for room_type in room_types %}
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="card">
                    <img class="card-img-top" src="static/image/banner-hotel.jpg" alt="Card image">
                    <div class="card-body">
                        <h3 class="card-title">{{room_type.ten_loai_phong}}</h3>
                        <h4 class="card-title">{{room_type.don_gia}} VND / 1 đêm</h4>
                        <a href="#" class="btn">Đặt phòng</a>
                    </div>
                </div>
            </div>
        {% endfor %}
    </div>

</section>