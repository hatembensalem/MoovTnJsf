package tn.mario.moovtn.remotes;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.mario.moovtn.entities.TransportMean;
import tn.mario.moovtn.entities.Trip;

@Local
public interface TripRemote {
	public boolean isOnTrip(TransportMean transport, Date tripStart, Date tripEnd);
	public List<Trip> findAll();
	public Trip findById(int id);
	void delete(Trip trip);
	void update(Trip trip);
	public void add(Trip trip);
}
