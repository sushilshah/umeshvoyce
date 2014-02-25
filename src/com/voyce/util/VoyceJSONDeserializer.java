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
public class VoyceJSONDeserializer<T> {
	
	public T PopulatePOJO(String jsonString,Class<T> classType)
	{
		ObjectMapper mapper = new ObjectMapper();
		 
		try {
	 
			T pojo = mapper.readValue(jsonString, classType);
	 
			// display to console
			System.out.println(pojo);
	        return pojo;
		} catch (JsonGenerationException e) {
	 
			e.printStackTrace();
	        return null;  
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
			return null;
	 
		} catch (IOException e) {
	 
			e.printStackTrace();
			return null;
	 
		}
		
		
	}
	
}
