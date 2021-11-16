<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <nav class="navbar navbar-expand-sm bg-light navbar-light">
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/admin">Trang chủ</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/create-bill">Lập hóa đơn</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/room">Phòng</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/room-type">Loại Phòng</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/room-type">Trạng thái phòng</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/online-booking">Đơn hàng online</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/offline-booking">Đơn hàng offline</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/bill">Hóa đơn</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/online-customer">Khách hàng online</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/offline-customer">Khách hàng offline</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/employee">Nhân viên</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/role">Quyền</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/stats">Thống kê</a>
	    </li>
	    <li class="nav-item">
	      <a href="<%=request.getContextPath()%>/login">Đăng nhập</a>
	    </li>
	  </ul>
	</nav>
    <%--  		<%User user = (User) session.getAttribute("user");%>
    		<% if (user != null) { %>
    			<a class="fas fa-shopping-cart" href=""></a>
    			<a href="<%=request.getContextPath()%>/<%=user.getTenDangNhap()%>/">
	              <%= user.getHoTen() %>  
	            </a>
    			<a href="<%=request.getContextPath()%>/logout">Đăng xuất</a>
    		<% } else { %>  --%>
     <!--   <!--  {% if current_user.is_authenticated %} 
            <a class="fas fa-shopping-cart" href=""></a>
            <a href="/">
              {{ current_user.ho_ten }}  
            </a>
            <a class="nav-link" href="/logout">Đăng xuất</a> -->
       <!--  {% else %} -->
       		
            
       <%--      <% } %> --%>
       <!--  {% endif %} -->