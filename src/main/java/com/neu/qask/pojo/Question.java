package com.neu.qask.pojo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="questionbank")
public class Question {

	@Id @GeneratedValue
	@Column(name="questionid", unique = true, nullable = false)
    private long id;
	
	@Transient
	private Set<Topic> topics = new HashSet<Topic>(0);
	
	@Column(name="title")
    private String title;
	
	@Column(name="message")
    private String message;
	
	@Column(name="postedby") //will stored in question Bank table
    private String postedby;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Question_Topic", joinColumns = { @JoinColumn(name = "questionid") }, inverseJoinColumns = { @JoinColumn(name = "topicid") })
	public Set<Topic> getTopics() {
		return this.topics;
	}
	
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	
    @OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user")
    private User user;
    
    @Transient //
    private Map<Answer,User> answerDetails; 
    

    public Question(String title, String message, User user) {
        this.title = title;
        this.message = message;
        this.user = user;
        this.postedby = user.getUserName();
    }

    Question() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

	public String getPostedBy() {
        return this.postedby;
    }

    public void setPostedBy(String pb) {
        this.postedby = pb;
    }

	public Map<Answer, User> getAnswerDetails() {
		return answerDetails;
	}

	public void setAnswerDetails(Map<Answer, User> answerDetails) {
		this.answerDetails = answerDetails;
	}

}