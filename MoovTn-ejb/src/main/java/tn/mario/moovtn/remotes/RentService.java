package tn.mario.moovtn.remotes;

 

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.mario.moovtn.entities.Rent;
import tn.mario.moovtn.entities.TransportMean;

@Local
public interface RentService   {
	 
 
	List<Rent> findAll();
	public Rent findById(int id);
	public boolean delete(Rent rent);
	List<Rent> findByDate(String date);
	boolean update(Rent rent);
 
 
	List<Rent> findByNow();
	List<Rent> findBySoon();
	List<Rent> findByYesterday();
 
	void add(Rent rent);
	 
	boolean isRent(TransportMean transport, Date rechDate);
 
	 
	
	 
	
	 

}
