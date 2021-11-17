package com.nhom2.qlks.hibernate.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nhom2.qlks.hibernate.HibernateUtils;
import com.nhom2.qlks.hibernate.pojo.Phong;

public class PhongDao {
	public String insertPhong(Phong phong) {
		String err_msg = "";
		
        
        if (checkTenPhong(phong.getTenPhong())) {
        	return err_msg = "Ten phòng đã tồn tại";
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
