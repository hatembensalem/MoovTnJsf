package tn.mario.moovtn.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity

public class SubscriptionCard implements Serializable {
  
	
	private static final long serialVersionUID = 1123123123123L;
	
	private Integer id;
	private Date validityStart;
	private Date validityEnd;
	private boolean locked;
	private boolean expired;
	private List<Line> lines;
	
	
	private User user;

	public SubscriptionCard() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}  
	@Temporal(TemporalType.DATE)
	public Date getValidityStart() {
		return this.validityStart;
	}

	public void setValidityStart(Date validityStart) {
		this.validityStart = validityStart;
	}  
	@Temporal(TemporalType.DATE)
	public Date getValidityEnd() {
		return this.validityEnd;
	}

	public void setValidityEnd(Date validityEnd) {
		this.validityEnd = validityEnd;
	}   
	public boolean getLocked() {
		return this.locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}   
	public boolean getExpired() {
		return this.expired;
	}

	public void setExpired(boolean canceled) {
		this.expired = canceled;
	}
	
	@OneToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@ManyToMany(mappedBy="subscriptionCards")
	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	
	
	
	
   
}
