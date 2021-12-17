package com.nhom2.qlks.servlet.admin.employee;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhom2.qlks.hibernate.daos.LoaiPhongDao;
import com.nhom2.qlks.hibernate.daos.PhongDao;
import com.nhom2.qlks.hibernate.daos.QuyenDao;
import com.nhom2.qlks.hibernate.daos.TrangThaiDao;
import com.nhom2.qlks.hibernate.daos.UserDao;
import com.nhom2.qlks.hibernate.pojo.LoaiPhong;
import com.nhom2.qlks.hibernate.pojo.Phong;
import com.nhom2.qlks.hibernate.pojo.Quyen;
import com.nhom2.qlks.hibernate.pojo.User;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/admin/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		List<Quyen> quyen = new QuyenDao().getAllQuyen();
		for(int i=0;i<quyen.size();i++){
		    System.out.println(quyen.get(i).getTenQuyen());
		} 

		List<User> user = new UserDao().getALLUser();
		
		request.setAttribute("quyen", quyen);
		request.setAttribute("user", user);
		
	
//		String idLoaiPhongStr = request.getParameter("room-type");
		
//		List<Phong> phongs;
		
//		if (idLoaiPhongStr == null || idLoaiPhongStr.equals("")) {
//		List<Phong> phongs = new PhongDao().getALLPhong();
//		} else {
//			LoaiPhong loaiPhong = new LoaiPhongDao().getLoaiPhongById(Integer.parseInt(idLoaiPhongStr));
//			phongs = new PhongDao().getPhongByLoaiPhong(loaiPhong);
//		}
		

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/employee-admin/employee-admin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
