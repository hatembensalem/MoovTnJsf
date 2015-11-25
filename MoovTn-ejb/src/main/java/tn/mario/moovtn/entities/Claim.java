package tn.mario.moovtn.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class Claim implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String question;
	private String response;
	private Date claimDate;
	private Boolean questionRead;
	private Boolean responseRead;
	
	private User users;
	
	public Claim() {
		questionRead = false;
		responseRead = false;
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}   
	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}  
	@Temporal(TemporalType.DATE)
	
	
	@ManyToOne
	public User getUsers() {
		return users;
	}
	public Date getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Boolean getQuestionRead() {
		return questionRead;
	}
	public void setQuestionRead(Boolean questionRead) {
		this.questionRead = questionRead;
	}
	public Boolean getResponseRead() {
		return responseRead;
	}
	public void setResponseRead(Boolean responseRead) {
		this.responseRead = responseRead;
	}
	
	
	
	
	
   
}
