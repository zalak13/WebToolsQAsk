package com.neu.qask.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.Answer;
import com.neu.qask.pojo.Question;
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
    
    public List<Answer> getAnswerList(long questionID )
            throws AdException {
        try {
            begin();
            
            List<Answer> answerList = getSession().createCriteria(Answer.class)
            .createAlias("question", "q")
            .add(Restrictions.eq("q.questionid",questionID)).list();
            /*Criteria crit = getSession().createCriteria("from Answer");
            Criteria quescrit = crit.createCriteria("from Question");
            quescrit.add(Restrictions.eq("id",questionID));
            */
            System.out.println((answerList.size()));
            commit();
            return answerList;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get answer for the id =  " + questionID, e);
        }
    }

    public Answer create(Question question,String message, User user)
            throws AdException {
        try {
            begin();
            System.out.println("inside Answer DAO");
            Answer answer = new Answer(message,user.getUserName());
            answer.setQuestion(question);    
            question.getAnswerDetails().add(answer);
            System.out.println("where");
            getSession().save(answer);
            getSession().update(question);
            System.out.println("didn't left");
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
