package com.nhom2.qlks.hibernate.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nhom2.qlks.hibernate.HibernateUtils;
import com.nhom2.qlks.hibernate.pojo.Booking;
import com.nhom2.qlks.hibernate.pojo.HoaDon;
import com.nhom2.qlks.hibernate.pojo.KhachHang;
import com.nhom2.qlks.hibernate.pojo.LoaiPhong;
import com.nhom2.qlks.hibernate.pojo.TrangThai;

public class BookingDao {
	public String insertBooking(Booking booking, KhachHang[] dataKH) {
		String err_msg = "";
		
		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            // save the student object
            session.save(booking);       
            System.out.println("saved booking");
            System.out.printf("id booking: %d\n", booking.getIdBooking());
            
            
            KhachHangDao khachHangDao = new KhachHangDao();
            khachHangDao.insertKhachHangs(dataKH, booking, session);
            
            
            // commit transaction
            transaction.commit();
            System.out.println("commited transaction");
            
            System.out.printf("id booking: %d\n", booking.getIdBooking());
            
            err_msg = "successed";
        } catch (Exception e) {
            if (transaction != null) {
            	System.out.println("roll back transaction");
                transaction.rollback();
                err_msg = "failed";
            }
            e.printStackTrace();
        } finally {
        	   session.close();
        }
        return err_msg;
	}
	
	public void payBookings(List<Booking> bookings, HoaDon hoaDon, Session session) {
		for (Booking bk : bookings) {
			
			Query q = session.createQuery(
					"UPDATE Booking "
					+ "SET hoaDon=:hoaDon "
					+ "WHERE idBooking=:idBooking");
			
			q.setParameter("hoaDon", hoaDon);
			q.setParameter("idBooking", bk.getIdBooking());
			
			q.executeUpdate();
		}
	}
	
	public String updateBooking(int id, int soNguoi, Date checkIn, Date checkOut) {
		String err_msg = "";
		
		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            Query query = session.createQuery(
            		"UPDATE Booking "
            		+ "SET soNguoi=:soNguoi, checkIn=:checkIn, checkOut=:checkOut"
            		+ " WHERE idBooking=:id");
			query.setParameter("soNguoi", soNguoi);
			query.setParameter("checkIn", checkIn);
			query.setParameter("checkOut", checkOut);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			
            System.out.println("update Booking");
            
            // commit transaction
            transaction.commit();
            System.out.println("commited transaction");
            
            err_msg = "successed";
        } catch (Exception e) {
            if (transaction != null) {
            	System.out.println("roll back transaction");
                transaction.rollback();
                err_msg = "failed";
            }
            e.printStackTrace();
        } finally {
        	   session.close();
        }
        return err_msg;
	}
	
	public String deleteBooking(int id) {
		String err_msg = "";
		
		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            Query query = session.createQuery("DELETE FROM Booking WHERE idBooking=:id");
			query.setParameter("id", id);
			int result = query.executeUpdate();
			
            System.out.println("delete Booking");
            
            // commit transaction
            transaction.commit();
            System.out.println("commited transaction");
            
            err_msg = "successed";
        } catch (Exception e) {
            if (transaction != null) {
            	System.out.println("roll back transaction");
                transaction.rollback();
                err_msg = "failed";
            }
            e.printStackTrace();
        } finally {
        	   session.close();
        }
        return err_msg;
	}
	
	public List<Booking> getAllBooking() {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking");//HQL
		
		List<Booking> bookings = q.getResultList();
		
		session.close();
		
		return bookings;
	}
	
	public List<Booking> getAllBookingOffline() {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE datOnline=0");//HQL
		
		List<Booking> bookings = q.getResultList();
		
		session.close();
		
		return bookings;
	}
	
	public List<Booking> getAllBookingOnline() {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE datOnline=1");//HQL
		
		List<Booking> bookings = q.getResultList();
		
		session.close();
		
		return bookings;
	}
	
	public Booking getBookingById(int id) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE idBooking=:id");//HQL
		
		q.setParameter("id", id);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Booking> bookings = q.getResultList();
		
		if (bookings.size() > 0) {
			return bookings.get(0);
		}
		
		session.close();
		
		return null;
	}
	
	public List<Booking> getBookingsByRoomName(String roomName) {
		Session session = HibernateUtils.getFactory().openSession();
		
		Query q = session.createQuery("FROM Booking "
				+ "WHERE phong.tenPhong LIKE :roomName "
				+ "AND hoaDon is null");//HQL
		
		q.setParameter("roomName", "%" + roomName + "%");
		
		List<Booking> bookings = q.getResultList();
		
		session.close();
		
		return bookings;
	}
	
	private boolean checkRoomBooked(int idPhong, Date checkIn, Date checkOut) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE checkIn=:checkin");//HQL
		
		session.close();
		return false;
	}
	
	private boolean checkCheckIn(Date checkin) {
		if (getCheckIn(checkin) != null) {
			return true;
		}
		return false;
	}
	
	public Booking getCheckIn(Date checkin) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE checkIn=:checkin");//HQL
		
		q.setParameter("checkin", checkin);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Booking> bookings = q.getResultList();
		
		if (bookings.size() > 0) {
			return bookings.get(0);
		}
		
		session.close();
		
		return null;
	}
	
	private boolean checkCheckOut(Date checkout) {
		if (getCheckIn(checkout) != null) {
			return true;
		}
		return false;
	}
	
	public Booking getCheckOut(Date checkout) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE checkOut=:checkout");//HQL
		
		q.setParameter("checkout", checkout);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Booking> bookings = q.getResultList();
		
		if (bookings.size() > 0) {
			return bookings.get(0);
		}
		
		session.close();
		
		return null;
	}
	
	//dongia
	private boolean checkDonGia(Float checkdongia) {
		if (getCheckDonGia(checkdongia) != null) {
			return true;
		}
		return false;
	}
	
	public Booking getCheckDonGia(Float dongia) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE donGia=:dongia");//HQL
		
		q.setParameter("dongia", dongia);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Booking> bookings = q.getResultList();
		
		if (bookings.size() > 0) {
			return bookings.get(0);
		}
		
		session.close();
		
		return null;
	}
	
}
