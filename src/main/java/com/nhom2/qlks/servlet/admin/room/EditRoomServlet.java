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
 * Servlet implementation class EditRoomServlet
 */
@WebServlet("/admin/room/edit")
public class EditRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.gson = new Gson();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		List<LoaiPhong> lps = new LoaiPhongDao().getAllLoaiPhong();
//		request.setAttribute("loaiPhongs", lps);
//		
//		String idPhongStr =request.getParameter("room-id");
//		Phong phong;
//		if (idPhongStr == null || idPhongStr.equals("")) {
//			phong = null;
//		} else {
//			phong = new PhongDao().getPhongById(Integer.parseInt(idPhongStr));
//		}
//		request.setAttribute("phong", phong);
//		
//		List<TrangThai> tts = new TrangThaiDao().getAllTrangThai();
//		request.setAttribute("trangThais", tts);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/room-admin/edit-room-admin.jsp");
//		dispatcher.forward(request, response);
		
		response.setContentType("application/json");
		request.setCharacterEncoding("UTF-8");
		String err_msg = "";
		
		String idPhongStr =request.getParameter("room-id");
		Phong phong;
		if (idPhongStr == null || idPhongStr.equals("")) {
			phong = null;
		} else {
			phong = new PhongDao().getPhongById(Integer.parseInt(idPhongStr));
		}
		
		Hashtable<String, Object> result = new Hashtable<String, Object>();
		
		if (phong != null) {
			Hashtable<String, Object> data = new Hashtable<String, Object>();
			data.put("tenPhong", phong.getTenPhong());
			data.put("idLoaiPhong", phong.getLoaiPhong().getIdLoaiPhong());
			data.put("idTrangThai", phong.getTrangThai().getIdTrangThai());
			
			result.put("code", 200);
			result.put("data", data);
		} else {
			result.put("code", 404);
			result.put("msg", "Đã có lỗi xảy ra, vui lòng thực hiện lại");
		}
		
		PrintWriter out = response.getWriter();
		
		String rsJson = this.gson.toJson(result);
		
		out.write(rsJson);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
