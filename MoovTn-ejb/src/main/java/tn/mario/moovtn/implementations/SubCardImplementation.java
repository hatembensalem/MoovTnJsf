package tn.mario.moovtn.implementations;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.mario.moovtn.entities.Line;
import tn.mario.moovtn.entities.SubscriptionCard;
import tn.mario.moovtn.remotes.SubCardService;

@Stateless
public class SubCardImplementation implements SubCardService {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void add(SubscriptionCard subCard) {
		em.persist(subCard);
	}		
	
	@Override
	public void delete(SubscriptionCard subCard) {
		em.remove(em.merge(subCard));
		
	}

	@Override
	public void update(SubscriptionCard subCard) {
		em.merge(subCard);
		
	}

	@Override
	public List<SubscriptionCard> findAll() {
		Query q = em.createQuery("select sc from SubscriptionCard sc");
		return q.getResultList() ;
	
	}
	
	@Override
	public List<Line> findAllLinesBySubscriptionCardId(int id) {
		SubscriptionCard card = findById(id);
		String Jpql = "select l from Line l where :param1 member of l.subscriptionCards ";
		Query query = em.createQuery(Jpql);
		query.setParameter("param1",card);
		return query.getResultList() ;
	
	}


	@Override
	public SubscriptionCard findById(Integer id) {
		
		return em.find(SubscriptionCard.class, id);
	}

	@Override
	public List<SubscriptionCard> findSubCards(int id) {
		// TODO Auto-generated method stub
		return null;

	}

}
