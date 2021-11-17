package com.nhom2.qlks.hibernate.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nhom2.qlks.hibernate.HibernateUtils;
import com.nhom2.qlks.hibernate.pojo.HoaDon;
import com.nhom2.qlks.hibernate.pojo.TrangThai;

public class HoaDonDao {
	public String inserHoaDon(HoaDon hoadon) {
		String err_msg = "";
		
        
        if (checkNgayTao(hoadon.getNgayTao())) {
        	return err_msg = "Ngày tạo đã tồn tại";
        }
        
        Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            // save the student object
            session.save(hoadon);       
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
	
	public HoaDon getHoaDonById(int id) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM HoaDon WHERE idHD=:id");//HQL
		
		q.setParameter("id", id);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<HoaDon> hoadons = q.getResultList();
		
		if (hoadons.size() > 0) {
			return hoadons.get(0);
		}
		
		return null;
	}
	
	private boolean checkNgayTao(Date checkngaytao) {
		if (getNgayTao(checkngaytao) != null) {
			return true;
		}
		return false;
	}
	
	public HoaDon getNgayTao(Date ngaytao) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM HoaDon WHERE ngayTao=:ngaytao");//HQL
		
		q.setParameter("ngaytao", ngaytao);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<HoaDon> hoadons = q.getResultList();
		
		if (hoadons.size() > 0) {
			return hoadons.get(0);
		}
		
		return null;
	}
}
