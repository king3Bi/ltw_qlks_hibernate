package com.nhom2.qlks.servlet.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhom2.qlks.hibernate.daos.UserDao;
import com.nhom2.qlks.hibernate.pojo.User;

/**
 * Servlet implementation class KichhoatCustomerServlet
 */
@WebServlet(name="/KichhoatCustomer", urlPatterns = {"/admin/online-customer/kichhoat"})
public class KichhoatCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KichhoatCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void kichhoatCusRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Integer userId = Integer.parseInt(request.getParameter("user-id"));
        Integer check=1;    
   
        UserDao userup = new UserDao();
        User getuser = userup.getUserByid(userId);
        if(getuser.getKichHoat()==1) {
        	check=0;
        }
        userup.updateUserQuyen(userId,check);
        response.sendRedirect(request.getContextPath() + "/admin/online-customer");
      
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		kichhoatCusRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		kichhoatCusRequest(request,response);
	}

}
