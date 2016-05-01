package com.neu.qask.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="Answerbank")
public class Answer {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="answerid",unique=true,nullable=false)
    private long id;
	
	
	@Column(name="message")
    private String message;
	
	@Column(name="postedBy") 
    private String postedBy;
	
	@Column(name="postedTime") 
    private String postedTime;
	
	@ManyToOne
	@JoinColumn(name="questionid")
	private Question question;
	
/*    @OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user")
    private User user;*/
    
  
    public Answer(String message, String username) {
        this.message = message;
        //this.user = user;
        this.postedBy = username;
        System.out.println("Here is the problem");
        this.postedTime = new Timestamp(new Date(id).getTime()).toString();
        System.out.println("After the crash");
    }

    Answer() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(String postedTime) {
		this.postedTime = postedTime;
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
/*	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

    
}
