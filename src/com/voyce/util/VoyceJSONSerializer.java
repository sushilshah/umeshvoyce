/**
 * 
 */
package com.voyce.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;



/**
 * @author DeadCode
 *
 */
public class VoyceJSONSerializer<T> {

	public void POJOSerializer(T ser)
	{
		
	ObjectMapper mapper = new ObjectMapper();
	 
		try {
	 
			// convert user object to json string,
			String jsonString = mapper.writeValueAsString(ser);
	 
			// display to console
			System.out.println("JSON : "+jsonString);
	 
		} catch (JsonGenerationException e) {
	  
			e.printStackTrace();
	 
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
	 
		} catch (IOException e) {
	 
			e.printStackTrace();
	 
		}
	}
	
}
