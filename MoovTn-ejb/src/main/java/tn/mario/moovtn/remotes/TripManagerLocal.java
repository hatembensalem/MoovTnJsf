package tn.mario.moovtn.remotes;

import java.util.List;

import javax.ejb.Local;

import tn.mario.moovtn.entities.Notification;
import tn.mario.moovtn.entities.Trip;

@Local
public interface TripManagerLocal {
	public void add(Trip u);
	public  Trip findById(Integer id);
	public List<Trip>getAllTrips();
	public void update(Trip u);
	public void delete(Trip u);
}
