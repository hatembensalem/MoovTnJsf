package tn.mario.moovtn.remotes;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tn.mario.moovtn.entities.Notification;



@Remote

public interface NotificationManagerRemote {

	void add(Notification u);
	Notification findById(Integer id);

	List<Notification>getAllNotification();
	List<Notification>findByLevel(int level);
	void update(Notification u);
	void delete(Notification u);
	

}
