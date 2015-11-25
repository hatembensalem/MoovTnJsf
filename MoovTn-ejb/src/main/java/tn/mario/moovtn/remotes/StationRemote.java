package tn.mario.moovtn.remotes;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.mario.moovtn.entities.Station;

@Local
public interface StationRemote {
	public void add(Station station);
	public List<Station> findAll();
	public String findAllToJSON();
	public String findAllToJSON(List<Station> list);
	public Station findById(int id);
	public List<Station> findAllByType(String type);
	public void update(Station station);
	public void delete(Station station);

}
