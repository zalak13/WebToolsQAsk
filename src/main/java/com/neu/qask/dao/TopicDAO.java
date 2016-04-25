package com.neu.qask.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.qask.exception.AdException;
import com.neu.qask.pojo.Topic;
import com.neu.qask.pojo.User;


public class TopicDAO extends DAO {
	public TopicDAO() {
    }

    public Topic get(String topicname)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Topic where topicname = :topicname");
            q.setString("topicname", topicname);
            Topic topic = (Topic) q.uniqueResult();
            commit();
            return topic;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named topic " + topicname + " " + e.getMessage());
        }
    }
    
    public List<Topic> getTopiclist() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Topic");
            List<Topic> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the topics", e);
        }
    }
    
    public List<Topic> getUserTopiclist(User user) throws AdException {
        try {
            begin();
            Criteria crit = getSession().createCriteria("from Topic");
            String userEmail = user.getEmail();
            Criteria userCrit = crit.createCriteria("from User where email = :userEmail");
            List<Topic> list = crit.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the topics", e);
        }
    }

    public Topic create(String topicname)
            throws AdException {
        try {
            begin();
            System.out.println("inside Topic DAO");
            Topic topic = new Topic(topicname);
            getSession().save(topic);
            commit();
            return topic;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating topic: " + e.getMessage());
        }
    }
    
    public void save(Topic topic) throws AdException {
        try {
            begin();
            getSession().update(topic);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save the topic", e);
        }
    }

    public void delete(Topic topic)
            throws AdException {
        try {
            begin();
            getSession().delete(topic);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete topic " + topic.getTopicname(), e);
        }
    }

}
