package tn.mario.moovtn.implementations;

import java.security.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.Null;

import tn.mario.moovtn.entities.Rent;
import tn.mario.moovtn.entities.TransportMean;
import tn.mario.moovtn.remotes.RentService;

@Stateless
public class RentImplementation implements RentService {
	
	@PersistenceContext(unitName="persist")
	EntityManager entityManager;
	
	 

	@Override
	public List<Rent> findAll() {
		 
		Query query= entityManager.createQuery("SELECT r FROM Rent r ");
		return  query.getResultList(); 
	}
	
	@Override
	public boolean delete(Rent rent) {
		entityManager.remove(findById(rent.getId()));
		return true;
		
	}
	@Override
	public Rent findById(int id) {
		
		return entityManager.find(Rent.class, id);
	}
	 
	@Override
	public List<Rent>  findByDate(String date) {
		Query query= entityManager.createQuery(" SELECT r FROM Rent r where DATE(r.rentStart) <=:p and   DATE(r.rentEnd) >=:p   and  r.status=:p2 ");
		Calendar cal = Calendar.getInstance(); 
		int year =Integer.parseInt( date.substring(0,  4));
		int month = Integer.parseInt(date.substring(5,  7));
		int day = Integer.parseInt(date.substring(8,  10));
		 
		cal.set( year, month-1, day ); 

		Date expiryDate = cal.getTime(); 
		 
	 
		query.setParameter("p",expiryDate );
		query.setParameter("p2","Accepted" );
	 
		return  query.getResultList(); 
		 
	}
	
	@Override
	public boolean update(Rent rent) {
		entityManager.merge(rent);
		return true;
		
	}
	@Override
	public List<Rent>  findByNow() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        
	       Date date2 = new Date();
	      
String date=dateFormat.format(date2);
		
		
			System.out.println("ok Today IMPL");
		Query query= entityManager.createQuery(" SELECT r FROM Rent r where DATE(r.rentStart) =:p    and  r.status=:p2 ");
		Calendar cal = Calendar.getInstance(); 
		int year =Integer.parseInt( date.substring(0,  4));
		int month = Integer.parseInt(date.substring(5,  7));
		int day = Integer.parseInt(date.substring(8,  10));
		 
		cal.set( year, month-1, day ); 

		Date expiryDate = cal.getTime(); 
		 
	 
		query.setParameter("p",expiryDate );
		query.setParameter("p2","Accepted" );
	 
		return  query.getResultList(); 
		
		
		 
	 
	}
	@Override
	public List<Rent>  findBySoon() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        
	       Date date2 = new Date();
	      
String date=dateFormat.format(date2);
		
		
			System.out.println("ok Today IMPL");
		Query query= entityManager.createQuery(" SELECT r FROM Rent r where DATE(r.rentStart) >:p    and  r.status=:p2 ");
		Calendar cal = Calendar.getInstance(); 
		int year =Integer.parseInt( date.substring(0,  4));
		int month = Integer.parseInt(date.substring(5,  7));
		int day = Integer.parseInt(date.substring(8,  10));
		 
		cal.set( year, month-1, day ); 

		Date expiryDate = cal.getTime(); 
		 
	 
		query.setParameter("p",expiryDate );
		query.setParameter("p2","Accepted" );
	 
		return  query.getResultList(); 
		
		
		 
	 
	}
	@Override
	public List<Rent>  findByYesterday() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        
	       Date date2 = new Date();
	      
String date=dateFormat.format(date2);
		
		
			System.out.println("ok Today IMPL");
		Query query= entityManager.createQuery(" SELECT r FROM Rent r where DATE(r.rentStart) <:p    and  r.status=:p2 ");
		Calendar cal = Calendar.getInstance(); 
		int year =Integer.parseInt( date.substring(0,  4));
		int month = Integer.parseInt(date.substring(5,  7));
		int day = Integer.parseInt(date.substring(8,  10));
		 
		cal.set( year, month-1, day ); 

		Date expiryDate = cal.getTime(); 
		 
	 
		query.setParameter("p",expiryDate );
		query.setParameter("p2","Accepted" );
	 
		return  query.getResultList(); 
		
		
		 
	 
	}
	
	@Override
	public boolean isRent(TransportMean transport, Date rechDate) {
		Query query= entityManager.createQuery("select r from Rent r where :p1>=r.rentStart and :p1<=r.rentEnd and :p2=r.transportMean");
		query.setParameter("p1", rechDate);
		query.setParameter("p2", transport);
		List<Rent> rents = query.getResultList();
		System.out.println("Reeeeeeeeeent: "+rents.size());
		if(rents.size()==0){
			return false;
		}
		return true;
	}

	@Override
	public void add(Rent rent) {
		entityManager.persist(rent);
		
	}

}
