package com.nhom2.qlks.servlet.admin.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhom2.qlks.hibernate.daos.PhongDao;
import com.nhom2.qlks.hibernate.daos.UserDao;
import com.nhom2.qlks.hibernate.pojo.User;

/**
 * Servlet implementation class KichhoatEmployeeServlet
 */
@WebServlet(name="KichhoatEmployee", urlPatterns = {"/admin/employee/kichhoat"})
public class KichhoatEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KichhoatEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void kichhoatRequest(HttpServletRequest request, HttpServletResponse response)
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
        response.sendRedirect(request.getContextPath() + "/admin/employee");
      
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		kichhoatRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		kichhoatRequest(request,response);
	}

}
