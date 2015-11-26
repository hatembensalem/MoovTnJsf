package tn.mario.moovtn.implementations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.mario.moovtn.entities.TransportMean;
import tn.mario.moovtn.remotes.RentService;
import tn.mario.moovtn.remotes.TransportMeanService;
import tn.mario.moovtn.remotes.TripRemote;

@Stateless
public class TransportMeanImplementation implements TransportMeanService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@EJB
	TripRemote tripRemote;
	@EJB
	RentService rentRemote;
	

	@Override
	public boolean add(TransportMean transport) {
		if(findBySerial(transport.getSerial())==null){
			entityManager.persist(transport);
			return true;
		}
		return false;
		
		
	}

	@Override
	public void delete(TransportMean transport) {
		entityManager.remove(findBySerial(transport.getSerial()));
		
	}

	@Override
	public void update(TransportMean transport) {
		entityManager.merge(transport);
		
	}

	@Override
	public List<TransportMean> findAll() {
		try {
			Query query = entityManager.createQuery("select tm from TransportMean tm");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public TransportMean findBySerial(String serial) {
		
		try {
			return entityManager.find(TransportMean.class, serial);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Boolean isAvailable(Timestamp start, Timestamp end){
		
		return null;
		
	}

	@Override
	public List<TransportMean> findAllAvailableByType(String type, Date tripStart, Date tripEnd) {
		List<TransportMean> transportMeans = findAllByType(type);
		List<TransportMean> list = new ArrayList<TransportMean>();
		for(int i=0;i<transportMeans.size();i++){
			if(!rentRemote.isRent(transportMeans.get(i), tripStart) && !rentRemote.isRent(transportMeans.get(i), tripEnd) && !tripRemote.isOnTrip(transportMeans.get(i), tripStart, tripEnd)){
				list.add(transportMeans.get(i));
			}
		}
		
		return list;
		
	}

	@Override
	public List<TransportMean> findAllByType(String type) {
		try {
			Query query = entityManager.createQuery("select tm from TransportMean tm where :p1 = type");
			query.setParameter("p1", type);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	 @Override
	public List<TransportMean> findByState() {

		Query query = entityManager.createQuery("select tm from TransportMean tm where tm.state=:p and tm.type=:p1");
		query.setParameter("p","working");
		query.setParameter("p1","Bus");
		return query.getResultList();
	}
	

}
