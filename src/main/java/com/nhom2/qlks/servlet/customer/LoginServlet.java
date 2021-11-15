package com.nhom2.qlks.servlet.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nhom2.qlks.hibernate.daos.UserDao;
import com.nhom2.qlks.hibernate.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String err_msg = "";
		
		String tenDangNhap = request.getParameter("username");
		String matKhau = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		if (userDao.loginUser(tenDangNhap, matKhau)) {
			User user = userDao.getUserByUsername(tenDangNhap);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		} else {
			request.setAttribute("errMessage", "Tên đăng nhập hoặc mật khẩu không đúng");
			request.getRequestDispatcher("/WEB-INF/views/customer/login.jsp").forward(request, response);
			return;
		}
	}

}
