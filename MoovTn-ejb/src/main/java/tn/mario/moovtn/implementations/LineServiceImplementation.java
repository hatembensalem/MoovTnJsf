package tn.mario.moovtn.implementations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.mario.moovtn.entities.Line;
import tn.mario.moovtn.entities.Station;
import tn.mario.moovtn.remotes.LineRemote;

@Stateless
public class LineServiceImplementation implements LineRemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean add(Line line) {
		if (findByName(line.getName()) == null) {
			entityManager.persist(line);
			return true;
		}
		return false;

	}

	@Override
	public Line findByName(String name) {
		try {
			Query query = entityManager
					.createQuery("select l from Line l where l.name = :p1");
			query.setParameter("p1", name);

			return (Line) query.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Line> findAll() {
		try {
			Query query = entityManager.createQuery("select l from Line l");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean delete(Line line) {
		try {
			entityManager.remove(findById(line.getId()));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Line findById(int id) {
		try {
			return entityManager.find(Line.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean assignStationsToThisLine(Line line, List<Station> stations) {
		Boolean b = false;
		try {
			line.setStations(stations);

			entityManager.merge(line);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateLine(Line line) {
		Boolean b = false;
		try {

			entityManager.merge(line);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public List<Station> findAllStationsByLineId(int lineId) {
		Line line = findById(lineId);
		String jpql = "select s from Station s where :param1 member of s.lines ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", line);
		return query.getResultList();
	}

	@Override
	public String findAllStationsByLineIdtoJSON(int lineId) {
		List<Station> list = findAllStationsByLineId(lineId);
		String json = "{beaches = {beaches: [";
		for(int i=0;i<list.size();i++){
			json +="{name: \""+list.get(i).getName()+"\", lat: "+list.get(i).getLatitude()+",lng: "+list.get(i).getLongitude()+", type: \""+list.get(i).getType()+"\"},";
		}
		
		json+="]}}";
		return json;
	}

	@Override
	public List<Line> findLinesByType(String type) {
		try {
			Query query = entityManager.createQuery("select l from Line l where l.type = :p1");
			query.setParameter("p1", type);
			
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
