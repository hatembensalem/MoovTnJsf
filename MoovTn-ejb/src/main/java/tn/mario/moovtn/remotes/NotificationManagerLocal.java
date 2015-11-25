package tn.mario.moovtn.remotes;

import java.util.List;

import javax.ejb.Local;

import tn.mario.moovtn.entities.Notification;

@Local
public interface NotificationManagerLocal {
	public void add(Notification u);
	public  Notification findById(Integer id);
	public List<Notification>getAllNotification();
	public void update(Notification u);
	public void delete(Notification u);
}
