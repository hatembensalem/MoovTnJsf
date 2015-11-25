package tn.mario.moovtn.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Notification
 *
 */
@Entity

public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String description;
	private int level;
	private boolean broadcast;
	private Date creationDate;
	private Line line;
	
	@ManyToOne
	@JoinColumn(name="idLine")
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	public Notification() {
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
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}   
	public boolean getBroadcast() {
		return this.broadcast;
	}

	public void setBroadcast(boolean broadcast) {
		this.broadcast = broadcast;
	}   
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Notification [id=" + id + ", description=" + description
				+ ", level=" + level + ", broadcast=" + broadcast
				+ ", creationDate=" + creationDate + ", line=" + line + "]";
	}
   
}
