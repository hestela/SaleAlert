package salealert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonReader {
	
	public String getJsonQuery(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	    	//attempt to open url and obtain json text
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        //read each character from the json string
	        while ((read = reader.read(chars)) != -1){
	            buffer.append(chars, 0, read); 
	        }
	        //return json query
	        return buffer.toString();
	    } 
	    finally {
	    	//close BufferedReader
	        if (reader != null){
	            reader.close();
	        }
	    }
	}

}
