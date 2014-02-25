/**
 * 
 */
package com.voyce.util;

import java.util.ArrayList;

/**
 * @author DeadCode
 * We are going to maintain the list in HardCode Constant values in string
 * As it will reduce the cost to data store access , though we will have to maintain the list 
 * in the code it self , we will port this to the XML file and keep it static
 *
 */
public class AutoCompleterLists {

	
   public static ArrayList<String> GetCountries(String searchParameter){
	   
	   ArrayList<String> countries = new ArrayList<String>();
	   for(String country:CountryList.countries)
	   {
		   if(country.contains(searchParameter.toUpperCase()))
		   {
			   countries.add(country);
		   }
	   }
	   
	   return countries;
   }
	
}
