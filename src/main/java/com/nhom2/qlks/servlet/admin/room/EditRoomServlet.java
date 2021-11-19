package com.nhom2.qlks.servlet.admin.room;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhom2.qlks.hibernate.daos.LoaiPhongDao;
import com.nhom2.qlks.hibernate.daos.PhongDao;
import com.nhom2.qlks.hibernate.daos.TrangThaiDao;
import com.nhom2.qlks.hibernate.pojo.LoaiPhong;
import com.nhom2.qlks.hibernate.pojo.Phong;
import com.nhom2.qlks.hibernate.pojo.TrangThai;

/**
 * Servlet implementation class EditRoomServlet
 */
@WebServlet("/room/edit")
public class EditRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<LoaiPhong> lps = new LoaiPhongDao().getAllLoaiPhong();
		request.setAttribute("loaiPhongs", lps);
		
		String idPhongStr =request.getParameter("room-id");
		Phong phong;
		if (idPhongStr == null || idPhongStr.equals("")) {
			phong = null;
		} else {
			phong = new PhongDao().getPhongById(Integer.parseInt(idPhongStr));
		}
		request.setAttribute("phong", phong);
		
		List<TrangThai> tts = new TrangThaiDao().getAllTrangThai();
		request.setAttribute("trangThais", tts);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/room-admin/edit-room-admin.jsp");
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
