package tn.mario.moovtn.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity

public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date departureTime;
	private Date arrivalTime;
	private Boolean canceled;
	
	
	private TransportMean transportMean;
	private Line line;
	
	public Trip() {
		super();
		canceled = false;
	} 
	
	@ManyToOne
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	  
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	
	
	@ManyToOne
	public TransportMean getTransportMean() {
		return transportMean;
	}
	public void setTransportMean(TransportMean transportMean) {
		this.transportMean = transportMean;
	}
	public Boolean getCanceled() {
		return canceled;
	}
	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	  
	
   
}
