package tn.mario.moovtn.remotes;


import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.mario.moovtn.entities.TransportMean;

@Local
public interface TransportMeanService {
	
	public boolean add(TransportMean transport);
	public void delete(TransportMean transport);
	public void update(TransportMean transport);
	public List<TransportMean> findAll();
	TransportMean findBySerial(String serial);
	public List<TransportMean> findAllByType(String type);
	public List<TransportMean> findAllAvailableByType(String type,Date tripStart,Date tripEnd);
	List<TransportMean> findByState();
	
}
