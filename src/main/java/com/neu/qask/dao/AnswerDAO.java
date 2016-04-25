package com.neu.qask.dao;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.Answer;
import com.neu.qask.pojo.User;


public class AnswerDAO extends DAO {
	public AnswerDAO() {
    }

    public Answer get(long answerid)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Answer where answerid = :answerid");
            q.setLong("answerid", answerid);
            Answer answer = (Answer) q.uniqueResult();
            commit();
            return answer;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get answer for the id " + answerid, e);
        }
    }

    public Answer create(String message, User user)
            throws AdException {
        try {
            begin();
            System.out.println("inside Answer DAO");
            Answer answer = new Answer(message,user);
            getSession().save(answer);
            
            commit();
            return answer;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while posting the answer: " + e.getMessage());
        }
    }

    public void delete(Answer answer)
            throws AdException {
        try {
            begin();
            getSession().delete(answer);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete answer " + answer.getId(), e);
        }
    }

}
