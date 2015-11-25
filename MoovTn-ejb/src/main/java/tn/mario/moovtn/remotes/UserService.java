package tn.mario.moovtn.remotes;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.mario.moovtn.entities.Line;
import tn.mario.moovtn.entities.TransportMean;
import tn.mario.moovtn.entities.User;

@Local
public interface UserService {
	void addUser(User u);

	User findUsrById(Integer id);

	List<User> getAllUsers();

	Boolean updateUser(User u);

	Boolean deleteUSer(User u);

	User loginAdmin(String pwd, String login);
	
	Integer findLineByUser();
	
	List<Line> getAllLines ();
	
	Map<Integer, String> getNbrUserByLine ();

	List<TransportMean> getBus ();
	
	List<TransportMean> getTrains ();
	
	List<TransportMean> getMetro ();
	
	List<User> getBannUsers();
	
	List<User> getNoBannUsers();
	
	
	//Integer countUsers();
	
	
	

}
