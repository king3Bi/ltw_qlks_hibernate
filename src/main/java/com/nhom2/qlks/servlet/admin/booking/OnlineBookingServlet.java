package com.nhom2.qlks.servlet.admin.booking;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhom2.qlks.hibernate.daos.BookingDao;
import com.nhom2.qlks.hibernate.daos.KhachHangDao;
import com.nhom2.qlks.hibernate.pojo.Booking;
import com.nhom2.qlks.hibernate.pojo.KhachHang;

/**
 * Servlet implementation class OnlineBooking
 */
@WebServlet(name = "BookingOnlineServlet", urlPatterns = {"/admin/booking-online"})
public class OnlineBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");			
		
		List<KhachHang> customers = new KhachHangDao().getAllKhachHang();
		request.setAttribute("customers", customers);
		
		List<Booking> bookings = new BookingDao().getAllBookingOnline();
		request.setAttribute("bookings", bookings);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/booking-admin/booking-online-admin.jsp");
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
