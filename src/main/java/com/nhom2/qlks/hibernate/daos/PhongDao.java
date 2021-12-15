package com.nhom2.qlks.hibernate.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nhom2.qlks.hibernate.HibernateUtils;
import com.nhom2.qlks.hibernate.pojo.HoaDon;
import com.nhom2.qlks.hibernate.pojo.LoaiPhong;
import com.nhom2.qlks.hibernate.pojo.TrangThai;
import com.nhom2.qlks.hibernate.pojo.Phong;

public class PhongDao {
	public String insertPhong(Phong phong) {
		String err_msg = "";
		
        if (checkTenPhong(phong.getTenPhong())) {
        	return err_msg = "Ten phong da ton tai";
        }
        Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            // save the student object
            session.save(phong);       
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
	
	public String updatePhong(int roomId, String roomName, LoaiPhong roomType, TrangThai roomStatus) {
		String err_msg = "";
		
		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
			/*
			 * Query query = session.createQuery("UPDATE Phong SET tenPhong=:tenphong" +
			 * " WHERE idPhong=:id"); query.setParameter("tenphong", tenphong);
			 * query.setParameter("id", id); int result = query.executeUpdate();
			 */
			
			Phong room = (Phong)session.get(Phong.class, roomId);
			room.setTenPhong(roomName);
			room.setLoaiPhong(roomType);
			room.setTrangThai(roomStatus);
            session.update(room);
            System.out.println("update phong");
            
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
	
	public String deletePhong(int id) {
		String err_msg = "";
		
		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            Query query = session.createQuery("DELETE FROM Phong WHERE idPhong=:id");
			query.setParameter("id", id);
			int result = query.executeUpdate();
			
            System.out.println("delete phong");
            
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
	
	public List<Phong> getAllPhong() {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Phong");//HQL
		
		List<Phong> phongs = q.getResultList();
		
		return phongs;
	}
	
	public List<Phong> getPhongByLoaiPhong(LoaiPhong loaiPhong) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Phong WHERE loaiPhong=:loaiPhong");//HQL
		
		q.setParameter("loaiPhong", loaiPhong);
		
		List<Phong> phongs = q.getResultList();
		
		return phongs;
	}
	
	public Phong getPhongById(int id) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Phong WHERE idPhong=:id");//HQL
		
		q.setParameter("id", id);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Phong> phongs = q.getResultList();
		
		if (phongs.size() > 0) {
			return phongs.get(0);
		}
		
		return null;
	}
	
	private boolean checkTenPhong(String checktenphong) {
		if (getTenPhong(checktenphong) != null) {
			return true;
		}
		return false;
	}
	
	public Phong getTenPhong(String tenphong) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM Phong WHERE tenPhong=:tenphong");//HQL
		
		q.setParameter("tenphong", tenphong);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Phong> phongs = q.getResultList();
		
		if (phongs.size() > 0) {
			return phongs.get(0);
		}
		
		return null;
	}
}
