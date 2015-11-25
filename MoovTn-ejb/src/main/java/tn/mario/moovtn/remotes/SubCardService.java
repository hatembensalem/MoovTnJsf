package tn.mario.moovtn.remotes;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.mario.moovtn.entities.Line;
import tn.mario.moovtn.entities.SubscriptionCard;

@Local
public interface SubCardService {
	void add(SubscriptionCard subCard);
	void delete(SubscriptionCard subCard);
	void update(SubscriptionCard subCard);
	List<SubscriptionCard> findAll();
	SubscriptionCard findById(Integer id);

	List<SubscriptionCard> findSubCards(int id);
	List<Line> findAllLinesBySubscriptionCardId(int id);
}