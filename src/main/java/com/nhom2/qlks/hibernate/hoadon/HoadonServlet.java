package com.nhom2.qlks.hibernate.hoadon;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhom2.qlks.hibernate.daos.BookingDao;

import com.nhom2.qlks.hibernate.daos.HoaDonDao;

import com.nhom2.qlks.hibernate.pojo.Dongia2;


/**
 * Servlet implementation class HoadonServlet
 */
@WebServlet(name ="HoadonServlet",urlPatterns = {"/admin/hoadon"})
public class HoadonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoadonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");				

		
//		ArrayList<Integer> iduser = new ArrayList<Integer>();
//		ArrayList<Integer> idbooking = new ArrayList<Integer>();
//	
	
		List<Dongia2> dongia = new HoaDonDao().getGiaTienHoaDOn();
	
//		for(int i=0;i<dongia.size()-1;i++) {
//			for(int j=0;j<dongia.size();j++) {
//				if(dongia.get(i).getIduser()==dongia.get(j).getIduser()) {
//					iduser.add(dongia.get(i).getIduser());
//					idbooking.add(dongia.get(i).getBooking());
//							
//					}
//			}
//		}
//		request.setAttribute("idbooking", idbooking);
//		request.setAttribute("idbooking", iduser);
		request.setAttribute("Dongia2", dongia);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/hoadon-admin/hoadon-admin.jsp");
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
