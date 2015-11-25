package tn.mario.moovtn.implementations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tn.mario.moovtn.entities.Notification;
import tn.mario.moovtn.remotes.NotificationManagerLocal;
import tn.mario.moovtn.remotes.NotificationManagerRemote;




@Stateless

public class NotificationManager implements NotificationManagerRemote, NotificationManagerLocal {
	@PersistenceContext(unitName="persist")
    EntityManager em;
    public NotificationManager() {
        
    }
	@Override
	public void add(Notification u) {
		// TODO Auto-generated method stub
		em.persist(u);
		
	}
	@Override
	public Notification findById(Integer id) {
		// TODO Auto-generated method stub
		Notification u=em.find(Notification.class, id);
		return u;
	}

	@Override
	public List<Notification> getAllNotification() {
		// TODO Auto-generated method stub
		Query query=em.createQuery("select notif from Notification notif");
		return query.getResultList();
	}
	@Override
	public void update(Notification u) {
		// TODO Auto-generated method stub
		em.merge(u);
		
	}
	@Override
	public void delete(Notification u) {
		// TODO Auto-generated method stub
		em.remove(em.merge(u));
		
	}
	@Override
	public List<Notification> findByLevel(int level) {
		Query query=em.createQuery("select notif from Notification notif where notif.level = :custlevel")
				.setParameter("custlevel", level);
				return query.getResultList();
	}

	

	
	
}
