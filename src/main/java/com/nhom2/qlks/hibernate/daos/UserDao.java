package com.nhom2.qlks.hibernate.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nhom2.qlks.hibernate.HibernateUtils;
import com.nhom2.qlks.hibernate.pojo.User;

public class UserDao {
	public String insertUser(User user) {
		String err_msg = "";
		
		if (checkUsername(user.getTenDangNhap())) {
    		return err_msg = "Username đã tồn tại";
        }
        
        if (checkEmail(user.getEmail())) {
        	return err_msg = "Địa chỉ email đã tồn tại";
        }
        
        if (checkIdCard(user.getCmnd())) {
        	return err_msg = "Số chứng minh nhân dân đã tồn tại";
        }
        
        if (checkPhone(user.getSdt())) {
        	return err_msg = "Số điện thoại đã tồn tại";
        }
		
		Transaction transaction = null;
        Session session = HibernateUtils.getFactory().openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();            
            System.out.println("created transaction");
            
            // save the student object
            session.save(user);       
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
	
	private boolean checkUsername(String username) {
		if (getUserByUsername(username) != null) {
			return true;
		}
		return false;
	}
	
	private boolean checkEmail(String email) {
		if (getUserByEmail(email) != null) {
			return true;
		}
		return false;
	}
	
	private boolean checkIdCard(String idCard) {
		if (getUserByIdCard(idCard) != null) {
			return true;
		}
		return false;
	}
	
	private boolean checkPhone(String phone) {
		if (getUserByPhone(phone) != null) {
			return true;
		}
		return false;
	}
	
	public User getUserByUsername(String username) {
        Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM User WHERE tenDangNhap=:username");//HQL
		
		q.setParameter("username", username);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<User> users = q.getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}
	
	public User getUserByEmail(String email) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM User WHERE email=:email");//HQL
		
		q.setParameter("email", email);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<User> users = q.getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}
	
	public User getUserByIdCard(String idCard) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM User WHERE cmnd=:cmnd");//HQL
		
		q.setParameter("cmnd", idCard);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<User> users = q.getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}
	
	public User getUserByPhone(String phone) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.createQuery("FROM User WHERE sdt=:sdt");//HQL
		
		q.setParameter("sdt", phone);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<User> users = q.getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}

	public boolean loginUser(String username, String password) {
		Session session = HibernateUtils.getFactory().openSession();
		Query q = session.
				createQuery("FROM User WHERE tenDangNhap=:username AND matKhau=:password AND idQuyen=3");//HQL
		
		q.setParameter("username", username);
		q.setParameter("password", password);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<User> users = q.getResultList();
		
		if (users.size() == 1) {
			return true;
		}
		
		return false;
	}
}

