package tn.mario.moovtn.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Station
 *
 */
@Entity
public class Station implements Serializable, Comparable<Station> {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Double latitude;
	private Double longitude;
	private String type;

	private List<Line> lines;

	public Station() {
		// TODO Auto-generated constructor stub
	}

	public Station(String name, Double latitude, Double longitude, String type) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public int compareTo(Station arg0) {

		return this.getName().toUpperCase()
				.compareTo(arg0.getName().toUpperCase());
	}

	@ManyToMany(mappedBy="stations")
	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

}
