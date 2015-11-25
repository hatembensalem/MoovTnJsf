package tn.mario.moovtn.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.mario.moovtn.entities.Line;
import tn.mario.moovtn.entities.TransportMean;
import tn.mario.moovtn.entities.User;
import tn.mario.moovtn.remotes.UserService;

@Stateless
public class UserImplementation implements UserService {
	@PersistenceContext(unitName = "persist")
	EntityManager em;

	@Override
	public void addUser(User u) {

		em.persist(u);
	}

	@Override
	public User findUsrById(Integer id) {
		User u = null;
		try {
			u = em.find(User.class, id);
		} catch (Exception e) {

		}
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		Query query = em.createQuery("select u from User u where u.role like :x");
		query.setParameter("x", "user");
		return query.getResultList();
	}

	@Override
	public Boolean updateUser(User u) {
		try {
			em.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteUSer(User u) {
		try {
			em.remove(em.merge(u));
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public User loginAdmin(String pwd, String login) {
		User u = null;
		Query query = em
				.createQuery("select u from User u where u.password like :x and u.login like :y and u.role like :z");
		query.setParameter("x", pwd);
		query.setParameter("y", login);
		query.setParameter("z", "admin");
		try {
			u = (User) query.getResultList().get(0);
		} catch (Exception e) {
			u = null;
		}
		return u;
	}

	@Override
	public Integer findLineByUser() {
		Query query = em
				.createQuery("select u,l from User u,Line l where u member of l.ListUsers");
		return 1;
	}

	@Override
	public List<Line> getAllLines() {
		Query query = em.createQuery("select l from Line l");
		return query.getResultList();
	}

	@Override
	public Map<Integer, String> getNbrUserByLine() {
		List<Line> lines = this.getAllLines();
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for (Line line : lines) {
			map.put(line.getListUsers().size(), line.getName());

		}

		return map;
	}

	@Override
	public List<TransportMean> getBus() {
		Query query = em.createQuery("select t from TransportMean t where t.type like :x");
		query.setParameter("x", "bus");
		return query.getResultList();
	}

	@Override
	public List<TransportMean> getTrains() {
		Query query = em.createQuery("select t from TransportMean t where t.type like :x");
		query.setParameter("x", "train");
		return query.getResultList();
		
	}

	@Override
	public List<TransportMean> getMetro() {
		Query query = em.createQuery("select t from TransportMean t where t.type like :x");
		query.setParameter("x", "metro");
		return query.getResultList();
		
	}

	@Override
	public List<User> getBannUsers() {
		Query query = em.createQuery("select u from User u where u.role like :x and u.isBanned is true");
		query.setParameter("x", "user");
		return query.getResultList();
	}

	@Override
	public List<User> getNoBannUsers() {
		Query query = em.createQuery("select u from User u where u.role like :x and u.isBanned is false");
		query.setParameter("x", "user");
		return query.getResultList();
		
	}

	//@Override
	//public Integer countUsers() {
		//Query query=em.createQuery("SELECT COUNT(u) FROM User u WHERE u.role = 'user'");
		//return (Integer) query.getSingleResult();
		//}

	
	

}
