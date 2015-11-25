package tn.mario.moovtn.implementations;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.mario.moovtn.entities.Claim;
import tn.mario.moovtn.entities.TransportMean;
import tn.mario.moovtn.remotes.IClaimsImplementationRemote;

@Stateless
public class ClaimsImplementation  implements IClaimsImplementationRemote{
	@PersistenceContext(unitName="persist")
	EntityManager entityManager;
	@Override
	public void addClaims(Claim c) {
		entityManager.persist(c);
		
		
	}

	@Override
	public List<Claim> findall() {
		Query query = entityManager.createQuery("SELECT c FROM Claim c");
		return query.getResultList();
	}
	@Override
	public Claim findClaimById(int id) {

		Claim c=entityManager.find(Claim.class, id);
		if(c!=null)
		{
			return c;

		}
		return null;
		
	}

	
	
@Override
	public Boolean deleteClaim(int id) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Claim.class,id));
			b = true;
		} catch (Exception e) {
			System.err.println("erreur ..."+e.toString()+"");
		}
		return b;
		
	}

@Override
public Claim findbyDate(String c) {
	
	Claim found = null;
		
		String jpql = "select g from Claim g where g.claimDate=:claimDate";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("claimDate",c);
		try{
			found = (Claim) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
		
		
}
@Override
public void update(Claim c) {
	entityManager.merge(c);
	
}

}
