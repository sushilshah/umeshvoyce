/**
 * 
 */
package com.voyce.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DeadCode
 *
 */
public class CityList {

public static List<String> cities = new ArrayList<String>();
	
	public CityList()
	{
		
		if(cities.size() <1)
		{
			                 cities = Arrays.asList(new String[]{
			                        "Bangalore"
			                        ,"Mysore"
			                        ,"Hasan"
			                        ,"Shimoga"
			                  });
		}
	}
	
	
	
}
