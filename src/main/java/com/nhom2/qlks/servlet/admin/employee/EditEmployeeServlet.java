package com.nhom2.qlks.servlet.admin.employee;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.nhom2.qlks.hibernate.pojo.TrangThai;
import com.nhom2.qlks.hibernate.pojo.User;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet(name = "EditEmployee", urlPatterns = {"/admin/employee/edit"})
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String idPhongStr =request.getParameter("user-id");
		User user;
		if (idPhongStr == null || idPhongStr.equals("")) {
			user = null;
		} else {
			user = new UserDao().getUserByid(Integer.parseInt(idPhongStr));

		}
		request.setAttribute("user", user);
		
		List<Quyen> quyen = new QuyenDao().getAllQuyen();
		request.setAttribute("quyen", quyen);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/employee-admin/edit-employee-admin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        Integer userId = Integer.parseInt(request.getParameter("user-id"));
        String userName = request.getParameter("user-name");
       
        String parsed=request.getParameter("user-sn");
        Date ngaysinh = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
			ngaysinh=format.parse(parsed);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String userGioiTinh = request.getParameter("user-gt");
        String userCmnd = request.getParameter("user-cmnd");
        String userEmail = request.getParameter("user-em");
        String userSdt = request.getParameter("user-sdt");
        String userTdn=request.getParameter("user-tdn");
        String userMk=request.getParameter("user-mk");
        Integer check=0;
        try {
        	 check= Integer.parseInt(request.getParameter("user-kh"));
        }
        catch(Exception e){
        	e.printStackTrace();
        }
      
//        Boolean userKichHoat;
//        if(check==1) {
//        	 userKichHoat=true;
//        }
//        userKichHoat=false;
        
        //Boolean userKichHoat =Boolean.valueOf(String.valueOf(request.getAttribute("user-kh")));
        Integer userQuyen = Integer.parseInt(request.getParameter("user-q"));
        
    
        QuyenDao quyenList = new QuyenDao();
        Quyen quyenStatus = quyenList.getQuyenById(userQuyen); 
        UserDao userup = new UserDao();
        userup.updateUser(userId, userName,ngaysinh,userGioiTinh, userCmnd, userEmail, userSdt,userTdn,userMk, check,quyenStatus);
       
        
        response.sendRedirect(request.getContextPath() + "/admin/employee");      
	}

}
