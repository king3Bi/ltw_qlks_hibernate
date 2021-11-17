package com.nhom2.qlks.hibernate.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nhom2.qlks.hibernate.HibernateUtils;
import com.nhom2.qlks.hibernate.pojo.Booking;
import com.nhom2.qlks.hibernate.pojo.TrangThai;

public class BookingDao {
	public String insertBooking(Booking booking) {
		String err_msg = "";
		
		if (checkCheckIn(booking.getCheckIn())) {
    		return err_msg = "Check in đã tồn tại";
        }
        
        if (checkCheckOut(booking.getCheckOut())) {
        	return err_msg = "Check out đã tồn tại";
        }
        
        if (checkDonGia(booking.getDonGia())) {
        	return err_msg = "Đơn giá đã tồn tại";
        }
        
        if (checkSoNguoi(booking.getSoNguoi())) {
        	return err_msg = "Đơn giá đã tồn tại";
        }
        
//        if (checkCoNguoiNuocNgoai(booking.isCoNguoiNuocNgoai())) {
//        	return err_msg = "Có người nước ngoài";
//        }
//        
//        if (checkDatOnline(booking.setDatOnline())) {
//        	return err_msg = "Có đặt online";
//        }
		
		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            // save the student object
            session.save(booking);       
            System.out.println("saved user");
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
	
	private boolean checkSoNguoi(int checksonguoi) {
		if (getCheckSoNguoi(checksonguoi) != null) {
			return true;
		}
		return false;
	}
	
	public Booking getCheckSoNguoi(int songuoi) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Booking WHERE soNguoi=:songuoi");//HQL
		
		q.setParameter("songuoi", songuoi);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Booking> bookings = q.getResultList();
		
		if (bookings.size() > 0) {
			return bookings.get(0);
		}
		
		return null;
	}
	
//	private boolean checkCoNguoiNuocNgoai(Boolean conguoinuocngoai) {
//		if (getCheckCoNguoiNuocNgoai(conguoinuocngoai) != null) {
//			return true;
//		}
//		return false;
//	}
//	
//	public Booking getCheckCoNguoiNuocNgoai(Boolean conguoinuocngoai) {
//		Session session = HibernateUtils.getFactory().openSession();
//		Query q = session.createQuery("FROM Booking WHERE coNguoiNuocNgoai=:conguoinuocngoai");//HQL
//		
//		q.setParameter("conguoinuocngoai", conguoinuocngoai);
//		q.setFirstResult(0);
//		q.setMaxResults(1);
//		
//		List<Booking> bookings = q.getResultList();
//		
//		if (bookings.size() > 0) {
//			return bookings.get(0);
//		}
//		
//		return null;
//	}
	
//	private boolean checkDatOnline(Boolean datonline) {
//	if (getcheckDatOnline(datonline) != null) {
//		return true;
//		}
//	return false;
//	}
//
//	public Booking getcheckDatOnline(Boolean datonline) {
//	Session session = HibernateUtils.getFactory().openSession();
//	Query q = session.createQuery("FROM Booking WHERE datOnline=:datonline");//HQL
//	
//	q.setParameter("datonline", datonline);
//	q.setFirstResult(0);
//	q.setMaxResults(1);
//	
//	List<Booking> bookings = q.getResultList();
//	
//	if (bookings.size() > 0) {
//		return bookings.get(0);
//		}
//	
//	return null;
//	}
}
