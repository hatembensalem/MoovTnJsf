package tn.mario.moovtn.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Line
 *
 */
@Entity
public class Line implements Serializable, Comparable<Line> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String path;
	private String type;

	private Set<Trip> trips;
	private Set<Notification> notifications;
	private List<Station> stations;
	private List<User> listUsers;
	private List<SubscriptionCard> subscriptionCards;

	@OneToMany(mappedBy = "line")
	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	@OneToMany
	public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}

	

	public Line() {
		super();
	}

	public Line(String name, String path, String type) {
		super();
		this.name = name;
		this.path = path;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
	@ManyToMany(cascade = CascadeType.MERGE)
	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	@Column(columnDefinition = "text")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int compareTo(Line arg0) {

		return this.getName().toUpperCase()
				.compareTo(arg0.getName().toUpperCase());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToMany
	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	
	@ManyToMany
	public List<SubscriptionCard> getSubscriptionCards() {
		return subscriptionCards;
	}

	public void setSubscriptionCards(List<SubscriptionCard> subscriptionCards) {
		this.subscriptionCards = subscriptionCards;
	}

	@Override
	public String toString() {
		return name;
	}

}
