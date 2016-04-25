package com.neu.qask.dao;



import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.User;


public class UserDAO extends DAO {
	public UserDAO() {
    }

    public User checkUser(String email, String password)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where email = :email and password = :password");
            q.setParameter("email", email);
            q.setParameter("password", password);
            User user = (User) q.uniqueResult();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + email, e);
        }
    }

    public User create(String password,String emailId, String firstName, String lastName)
            throws AdException {
        try {
            begin();
            Random rnd = new Random();
            String username = firstName + (100000 + rnd.nextFloat() * 900000) ;
            User user=new User(username,password,emailId);
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUserName(username);
        
            getSession().save(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    
    
    public boolean checkEmail(String email)
            throws AdException {
    	try {
            begin();
            Query q = getSession().createQuery("from User where email = :email");
            
            q.setParameter("email", email);
            User user = (User) q.uniqueResult();
            if(user!=null){
            	return true;
            }
            return false;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("User already exists" + email, e);
        }
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getUserName(), e);
        }
    }

}
