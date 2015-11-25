package tn.mario.moovtn.remotes;

import java.util.List;

import javax.ejb.Remote;

import tn.mario.moovtn.entities.Notification;
import tn.mario.moovtn.entities.Trip;

@Remote
public interface TripManagerRemote {
	public void add(Trip u);
	public  Trip findById(Integer id);
	public List<Trip>getAllTrips();
	public void update(Trip u);
	public void delete(Trip u);
}
