<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<header class="header">

    <a href="#" class="logo"> <i class="fas fa-hotel"></i> Maris </a>

    <nav class="navbar">
        <a href="#home">Trang chủ</a>
        <a href="#home">Tìm phòng</a>
        <a href="#room-type">Loại phòng</a>
        <a href="#features">Đặc trưng</a>
        <a href="#contact">Liên hệ</a>

    </nav>

    <nav class="navbar">
     <!--   <!--  {% if current_user.is_authenticated %} 
            <a class="fas fa-shopping-cart" href=""></a>
            <a href="/">
              {{ current_user.ho_ten }}  
            </a>
            <a class="nav-link" href="/logout">Đăng xuất</a> -->
       <!--  {% else %} -->
            <a href="<%=request.getContextPath()%>/login">Đăng nhập</a>
            <a href="<%=request.getContextPath()%>/register">Đăng ký</a>
       <!--  {% endif %} -->
    </nav>

</header>