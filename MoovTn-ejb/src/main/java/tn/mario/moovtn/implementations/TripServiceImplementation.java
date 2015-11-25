package tn.mario.moovtn.implementations;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.mario.moovtn.entities.Rent;
import tn.mario.moovtn.entities.TransportMean;
import tn.mario.moovtn.entities.Trip;
import tn.mario.moovtn.remotes.TripRemote;

@Stateless
public class TripServiceImplementation implements TripRemote{
	
	@PersistenceContext(unitName="persist")
	EntityManager entityManager;

	@Override
	public boolean isOnTrip(TransportMean transport, Date tripStart, Date tripEnd) {
		Query query= entityManager.createQuery("select t from Trip t where (:p1>=t.departureTime and :p1<=t.arrivalTime) or (:p2>=t.departureTime and :p2<=t.arrivalTime) and :p3=t.transportMean");
		query.setParameter("p1", tripStart);
		query.setParameter("p2", tripEnd);
		query.setParameter("p3", transport);
		List<Rent> rents = query.getResultList();
		System.out.println("Triiiip: "+rents.size());
		if(rents.size()==0){
			return false;
		}
		return true;
	}

	@Override
	public List<Trip> findAll() {
		try {
			Query query = entityManager.createQuery("select t from Trip t");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Trip findById(int id) {
		try {
			return entityManager.find(Trip.class, id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void delete(Trip trip) {
		entityManager.remove(findById(trip.getId()));
		
	}

	@Override
	public void update(Trip trip) {
		entityManager.merge(trip);
		
	}

	@Override
	public void add(Trip trip) {
		
		
			entityManager.persist(trip);
			
	}

}
