package com.nhom2.qlks.servlet.admin.booking;

import java.beans.JavaBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nhom2.qlks.hibernate.daos.BookingDao;
import com.nhom2.qlks.hibernate.daos.PhongDao;
import com.nhom2.qlks.hibernate.pojo.Booking;
import com.nhom2.qlks.hibernate.pojo.KhachHang;
import com.nhom2.qlks.hibernate.pojo.Phong;

/**
 * Servlet implementation class OfflineBooking
 */
@WebServlet("/admin/offline-booking")
public class OfflineBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfflineBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.gson = new Gson();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String idPhongStr = request.getParameter("idPhong");
		String checkInStr = request.getParameter("checkIn");
		String checkOutStr = request.getParameter("checkOut");
		String soNguoiStr = request.getParameter("soNguoi");
		String dataKHStr = request.getParameter("dataKH");
		
		int idPhong = Integer.parseInt(idPhongStr);
		int soNguoi = Integer.parseInt(soNguoiStr);
		KhachHang[] dataKH = gson.fromJson(dataKHStr, KhachHang[].class);
		
//		for (KhachHang kh : dataKH) {
//			System.out.printf("ten: %s, cmnd: %s, diachi: %s", kh.getHoTen(), kh.getCmnd(), kh.getDiaChi());
//			
//		}
		
		Phong phong = new PhongDao().getPhongById(idPhong);
		try {
			Date checkIn = dateFormat.parse(checkInStr);
			Date checkOut = dateFormat.parse(checkOutStr);
			
			Booking booking = new Booking();
			booking.setCheckIn(checkIn);
			booking.setCheckOut(checkOut);
			booking.setSoNguoi(soNguoi);
			booking.setPhong(phong);
			
			BookingDao bookingDao = new BookingDao();
			
			bookingDao.insertBooking(booking, dataKH);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		Hashtable<String, Object> result = new Hashtable<String, Object>();
		
		result.put("checkIn", checkInStr);
		result.put("checkOut", checkOutStr);
		
		PrintWriter out = response.getWriter();
		
		String rs = this.gson.toJson(result);
		
		out.write(rs);
		out.flush();
	}

}
