package tn.mario.moovtn.remotes;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.mario.moovtn.entities.Claim;


@Local
public interface IClaimsImplementationRemote {
	public void addClaims(Claim c);
	public List<Claim>  findall();
	public Claim findbyDate(String c);
	public  Boolean deleteClaim(int id);
	public Claim findClaimById(int id);
	public void update(Claim c);
   
}
