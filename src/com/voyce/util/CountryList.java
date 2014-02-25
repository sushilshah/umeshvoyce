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
public class CountryList {

	public static List<String> countries = new ArrayList<String>();
	
	public CountryList()
	{
		
	 
	}
	
	static{
		    countries = Arrays.asList(new String[]{
                "INDIA"
               ,"USA"
               ,"UK"
               ,"SINGAPORE"
            }); 		
	}
}
