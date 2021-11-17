package com.nhom2.qlks.hibernate.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nhom2.qlks.hibernate.HibernateUtils;
import com.nhom2.qlks.hibernate.pojo.KhachHang;

public class KhachHangDao {
	public String insertKhachHang(KhachHang khachhang) {
		String err_msg = "";
		
		
        
        if (checkHoTen(khachhang.getHo_ten())) {
        	return err_msg = "Họ Tên đã tồn tại";
        }
        
        if (checkCmnd(khachhang.getCmnd())) {
        	return err_msg = "Cmnd đã tồn tại";
        }
        
        if (checkDiaChi(khachhang.getDiaChi())) {
        	return err_msg = "Địa chỉ đã tồn tại";
        }
        

		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            // save the student object
            session.save(khachhang);       
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
	
	
	
	public KhachHang getIdKhach(int idkhach) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM KhachHang WHERE idKhach=:idkhach");//HQL
		
		q.setParameter("idkhach", idkhach);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<KhachHang> khachhangs = q.getResultList();
		
		if (khachhangs.size() > 0) {
			return khachhangs.get(0);
		}
		
		return null;
	}
	//hoten
	private boolean checkHoTen(String checkhoten) {
		if (getHoTen(checkhoten) != null) {
			return true;
		}
		return false;
	}
	
	public KhachHang getHoTen(String hoten) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM KhachHang WHERE ho_ten=:hoten");//HQL
		
		q.setParameter("hoten", hoten);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<KhachHang> khachhangs = q.getResultList();
		
		if (khachhangs.size() > 0) {
			return khachhangs.get(0);
		}
		
		return null;
	}
	//cmnd
	private boolean checkCmnd(String checkcmnd) {
		if (getCmnd(checkcmnd) != null) {
			return true;
		}
		return false;
	}
	
	public KhachHang getCmnd(String cmnd) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM KhachHang WHERE cmnd=:cmnd");//HQL
		
		q.setParameter("idkhach", cmnd);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<KhachHang> khachhangs = q.getResultList();
		
		if (khachhangs.size() > 0) {
			return khachhangs.get(0);
		}
		
		return null;
	}
	//diachi
	private boolean checkDiaChi(String checkdiachi) {
		if (getDiaChi(checkdiachi) != null) {
			return true;
		}
		return false;
	}
	
	public KhachHang getDiaChi(String diachi) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM KhachHang WHERE diachi=:diachi");//HQL
		
		q.setParameter("diachi", diachi);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<KhachHang> khachhangs = q.getResultList();
		
		if (khachhangs.size() > 0) {
			return khachhangs.get(0);
		}
		
		return null;
	}
}
