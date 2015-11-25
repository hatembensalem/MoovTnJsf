package tn.mario.moovtn.remotes;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.mario.moovtn.entities.Line;
import tn.mario.moovtn.entities.Station;

@Local
public interface LineRemote {
	public boolean add(Line line);

	public Line findByName(String name);

	public List<Line> findAll();

	public boolean delete(Line line);

	public Line findById(int id);

	Boolean assignStationsToThisLine(Line line, List<Station> stations);

	Boolean updateLine(Line line);

	List<Station> findAllStationsByLineId(int lineId);
	
	public String findAllStationsByLineIdtoJSON(int lineId);
	
	List<Line> findLinesByType(String type);

}
