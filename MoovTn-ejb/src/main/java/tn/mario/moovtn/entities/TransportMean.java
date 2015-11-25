package tn.mario.moovtn.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TransportMean
 *
 */
@Entity

public class TransportMean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String serial;
	private String type;
	
	private String state;
	private Set<Rent> rent;
	
	
	
	public TransportMean(String serial, String type, String state) {
		super();
		this.serial = serial;
		this.type = type;
		this.state = state;
	}
	@OneToMany
	public Set<Rent> getRent() {
		return rent;
	}
	public void setRent(Set<Rent> rent) {
		this.rent = rent;
	}
	public TransportMean() {
		super();
	}   
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	
	
	
	@Id
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
   
}
