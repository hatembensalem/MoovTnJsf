package tn.mario.moovtn.implementations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.mario.moovtn.entities.Station;
import tn.mario.moovtn.remotes.StationRemote;

@Stateless
public class StationServiceImplementation implements StationRemote{

	@PersistenceContext(unitName="persist")
	EntityManager entityManager;
	
	@Override
	public void add(Station station) {
		entityManager.persist(station);
	}

	@Override
	public List<Station> findAll() {
		try {
			Query query = entityManager.createQuery("select s from Station s");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String findAllToJSON() {
		List<Station> list = findAll();
		String json = "{beaches = {beaches: [";
		for(int i=0;i<list.size();i++){
			json +="{name: \""+list.get(i).getName()+"\", lat: "+list.get(i).getLatitude()+",lng: "+list.get(i).getLongitude()+", type: \""+list.get(i).getType()+"\"},";
		}
		
		json+="]}}";
		return json;
	}

	@Override
	public Station findById(int id) {
		
		try {
			return entityManager.find(Station.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String findAllToJSON(List<Station> list) {
		String json = "{beaches = {beaches: [";
		for(int i=0;i<list.size();i++){
			json +="{name: \""+list.get(i).getName()+"\", lat: "+list.get(i).getLatitude()+",lng: "+list.get(i).getLongitude()+", type: \""+list.get(i).getType()+"\"},";
		}
		
		json+="]}}";
		return json;
	}

	@Override
	public List<Station> findAllByType(String type) {
		
		try {
			Query query = entityManager.createQuery("select s from Station s where s.type = :p1 or s.type = 'transfert'");
			query.setParameter("p1", type);
			
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void update(Station station) {
		entityManager.merge(station);
		
	}

	@Override
	public void delete(Station station) {
		entityManager.remove(findById(station.getId()));
		
	}

}
