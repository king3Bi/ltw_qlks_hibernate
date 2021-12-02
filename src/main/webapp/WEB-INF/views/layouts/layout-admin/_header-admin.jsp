<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin">Trang chủ</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/bill/insert">Lập hóa đơn</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/room">Phòng</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/room-type">Loại Phòng</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/room-type">Trạng thái phòng</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/booking">Booking</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/bill">Hóa đơn</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/online-customer">Khách hàng online</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/offline-customer">Khách hàng offline</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/employee">Nhân viên</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/role">Quyền</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/stats">Thống kê</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/admin/login">Đăng nhập</a>
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