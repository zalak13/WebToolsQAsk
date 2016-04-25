package com.neu.qask.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.Question;
import com.neu.qask.pojo.User;



public class QuestionDAO extends DAO {
	public QuestionDAO() {
    }

    public Question get(long questionID )
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where id = :questionID");
            q.setLong("questionid", questionID);
            Question question = (Question) q.uniqueResult();
            commit();
            return question;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get question for the id =  " + questionID, e);
        }
    }

    public Question create(String title, String message, User user)
            throws AdException {
        try {
            begin();
            System.out.println("inside Question DAO");
            Question question=new Question( title, message, user);
            getSession().save(question);
            
            commit();
            return question;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while posting a question: " + e.getMessage());
        }
    }
    
//    public List list() throws AdException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from Question");
//            List list = q.list();
//            commit();
//            return list;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not list the Questions", e);
//        }
//    }

    public void save(Question question) throws AdException {
        try {
            begin();
            getSession().update(question);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not post the question", e);
        }
    }
    
    public void delete(Question question)
            throws AdException {
        try {
            begin();
            getSession().delete(question);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete question " + question.getTitle(), e);
        }
    }

}
