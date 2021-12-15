package com.nhom2.qlks.servlet.admin.employee;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhom2.qlks.hibernate.daos.QuyenDao;
import com.nhom2.qlks.hibernate.daos.UserDao;
import com.nhom2.qlks.hibernate.pojo.Phong;
import com.nhom2.qlks.hibernate.pojo.Quyen;
import com.nhom2.qlks.hibernate.pojo.User;

/**
 * Servlet implementation class InsertEmployeeServlet
 */
@WebServlet(name = "InsertEmployee", urlPatterns = {"/admin/employee/create"})
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		xuli(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		xuli(request, response);
		
	}
	protected void xuli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
       
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
        String userTenDN = request.getParameter("user-tdn");
        String userMk = request.getParameter("user-mk");
        String userSdt = request.getParameter("user-sdt");
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
        User user = new User(userName,ngaysinh,userGioiTinh,userCmnd, userEmail, userSdt,userTenDN,userMk,check,quyenStatus);
        userup.insertUser(user);
//       
        
        response.sendRedirect(request.getContextPath() + "/admin/employee");      
	}

}
