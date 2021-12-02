package com.nhom2.qlks.servlet.admin.room;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nhom2.qlks.hibernate.daos.LoaiPhongDao;
import com.nhom2.qlks.hibernate.daos.PhongDao;
import com.nhom2.qlks.hibernate.daos.TrangThaiDao;
import com.nhom2.qlks.hibernate.pojo.LoaiPhong;
import com.nhom2.qlks.hibernate.pojo.Phong;
import com.nhom2.qlks.hibernate.pojo.TrangThai;

/**
 * Servlet implementation class InsertRoomServlet
 */
@WebServlet("/admin/room/insert")
public class InsertRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.gson = new Gson();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		
		List<LoaiPhong> lps = new LoaiPhongDao().getAllLoaiPhong();
		request.setAttribute("loaiPhongs", lps);
		
		List<TrangThai> tts = new TrangThaiDao().getAllTrangThai();
		request.setAttribute("trangThais", tts);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/room-admin/create-room-admin.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		request.setCharacterEncoding("UTF-8");
		String err_msg = "";
		
		String tenPhong = request.getParameter("room-name");
		String loaiPhongStr = request.getParameter("room-type");
		String trangThaiStr = request.getParameter("room-status");
		
		LoaiPhong loaiPhong = new LoaiPhongDao().getLoaiPhongById(Integer.parseInt(loaiPhongStr));
		TrangThai trangThai = new TrangThaiDao().getTrangThaiId(Integer.parseInt(trangThaiStr));
		
		Phong phong = new Phong();
		phong.setTenPhong(tenPhong);
		phong.setLoaiPhong(loaiPhong);
		phong.setTrangThai(trangThai);
		
		Hashtable<String, Object> result = new Hashtable<String, Object>();
		
		PhongDao phongDao = new PhongDao();
		err_msg = phongDao.insertPhong(phong);
		if ("successed".equals(err_msg)) {
			result.put("code", 200);
			result.put("msg", "Thêm phòng thành công");
		} else {
			result.put("code", 404);
			result.put("msg", "Đã có lỗi xảy ra, vui lòng thực hiện lại");
		}
		
		PrintWriter out = response.getWriter();
		
		String rsJson = this.gson.toJson(result);
		
		out.write(rsJson);
		out.flush();
	}

}
