package com.neu.qask.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="topictable")
public class Topic {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="topicid", unique = true, nullable = false)
	
    private long id;
	
	@Column(name="topicname")
    private String topicname;

	@ManyToMany(mappedBy="topics")
	    private Set<Question> questions = new HashSet<Question>();
	 
	
    public Topic(String topicname) {
        this.topicname = topicname;
    }

    Topic() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopicname() {
		return topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}

}
