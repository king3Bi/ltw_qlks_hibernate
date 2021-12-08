<%@page import="com.nhom2.qlks.hibernate.pojo.User"%>
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
   		<%User user = (User) session.getAttribute("user");%>
   		<% if (user != null) { %>
   			<a class="fas fa-shopping-cart" href=""></a>
   			<a href="<%=request.getContextPath()%>/<%=user.getTenDangNhap()%>/">
              <%= user.getHoTen() %>  
            </a>
   			<a href="<%=request.getContextPath()%>/logout">Đăng xuất</a>
   		<% } else { %>       		
            <a href="<%=request.getContextPath()%>/login">Đăng nhập</a>
            <a href="<%=request.getContextPath()%>/register">Đăng ký</a>
        <% } %>
    </nav>

</header>