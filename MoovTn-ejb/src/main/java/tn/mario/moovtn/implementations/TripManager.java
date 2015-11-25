package tn.mario.moovtn.implementations;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.mario.moovtn.entities.Notification;
import tn.mario.moovtn.entities.Trip;
import tn.mario.moovtn.remotes.TripManagerLocal;
import tn.mario.moovtn.remotes.TripManagerRemote;

/**
 * Session Bean implementation class TripManager
 */
@Stateless
@LocalBean
public class TripManager implements TripManagerRemote, TripManagerLocal {
	@PersistenceContext(unitName="persist")
    EntityManager em;
    /**
     * Default constructor. 
     */
    public TripManager() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Trip u) {
		em.persist(u);
	}

	@Override
	public Trip findById(Integer id) {
		Trip u=em.find(Trip.class, id);
		return u;
	}

	@Override
	public List<Trip> getAllTrips() {
		Query query=em.createQuery("select trip from Trip trip");
		return query.getResultList();
	}

	@Override
	public void update(Trip u) {
		em.merge(u);
		
	}

	@Override
	public void delete(Trip u) {
		em.remove(em.merge(u));
		
	}

}
