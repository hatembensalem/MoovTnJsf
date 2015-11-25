package tn.mario.moovtn.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rent
 *
 */
@Entity
public class Rent implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Timestamp rentStart;
	private Timestamp rentEnd;
	private Location departure;
	private Location destination;
	private TransportMean transportMean;
	private String status;
	private User user;
	private int members;
	
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne
	public TransportMean getTransportMean() {
		return transportMean;
	}
	public void setTransportMean(TransportMean transportmean) {
		this.transportMean = transportmean;
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Timestamp getRentStart() {
		return rentStart;
	}
	public void setRentStart(Timestamp rentStart) {
		this.rentStart = rentStart;
	}
	 
	public Timestamp getRentEnd() {
		return rentEnd;
	}
	public void setRentEnd(Timestamp rentEnd) {
		this.rentEnd = rentEnd;
	}
	
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn(name="idDepart")
	public Location getDeparture() {
		return departure;
	}
	
	public void setDeparture(Location departure) {
		this.departure = departure;
	}
	
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn(name="idDestination")
	public Location getDestination() {
		return destination;
	}
	
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	









}