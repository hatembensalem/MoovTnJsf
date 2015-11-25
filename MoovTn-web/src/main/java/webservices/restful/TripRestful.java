package webservices.restful;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


import org.primefaces.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;






import tn.mario.moovtn.entities.Trip;

public class TripRestful {

public static	String chemin;
	
	public TripRestful(){
		
		chemin="http://localhost:44300/api/Services/Get";
		
		
	}
	
    
    public void test(){


        
        
    	
    	Client c = ClientBuilder.newClient();
    	String t = c.target(chemin).request().get(String.class);
    	
        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = new JSONObject(t);
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jObject.getString(key); 
            map.put(key, value);

        }

        System.out.println("json : "+jObject);
        System.out.println("map : "+map);
      
    	
    }
}
