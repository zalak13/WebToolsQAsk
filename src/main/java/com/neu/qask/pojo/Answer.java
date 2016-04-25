package com.neu.qask.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="Answerbank")
public class Answer {

	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property",value="user"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="answerid",unique=true,nullable=false)
    private long id;
	
	
	@Column(name="message")
    private String message;
	
	@Column(name="postedBy") 
    private String postedBy;
	
	@Column(name="postedTime") 
    private String postedTime;
	
    @OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user")
    private User user;
    
  
    public Answer(String message, User user) {
        this.message = message;
        this.user = user;
        this.postedBy = user.getUserName();
        this.postedTime = new Timestamp(new Date(id).getTime()).toString();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    
}
