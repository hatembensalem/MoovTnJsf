package tn.mario.moovtn.remotes;

import javax.ejb.Remote;

@Remote
public interface GwMessageRemote {
	public void sendEmail(String to, String from, String subject, String content);

}
