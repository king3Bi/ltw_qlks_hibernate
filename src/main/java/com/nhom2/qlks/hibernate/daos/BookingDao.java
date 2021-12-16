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
	
	public String updateBooking(int id,int songuoi,boolean conguoinuocngoai,Date checkin,Date checkout) {
		String err_msg = "";
		
		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            Query query = session.createQuery("UPDATE Booking SET soNguoi=:songuoi,coNguoiNuocNgoai=:conguoinuocngoai,checkIn=:checkin,CheckOut=:checkout"
            		+ " WHERE idBooking=:id");
			query.setParameter("songuoi", songuoi);
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
		
		return null;
	}
	
	public List<Booking> getBookingsByRoomName(String roomName) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE phong.tenPhong LIKE :roomName");//HQL
		
		q.setParameter("roomName", "%" + roomName + "%");
		
		List<Booking> bookings = q.getResultList();
		
		if (bookings.size() > 0) {
			return bookings;
		}
		
		return null;
	}
	
	private boolean checkRoomBooked(int idPhong, Date checkIn, Date checkOut) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE checkIn=:checkin");//HQL
		
		
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
		
		return null;
	}
	
}
