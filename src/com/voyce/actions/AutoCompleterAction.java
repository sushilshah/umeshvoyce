/**
 * 
 */
package com.voyce.actions;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.voyce.util.AutoCompleterLists;

/**
 * @author DeadCode
 *
 */
public class AutoCompleterAction  extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -272888429663329041L;
	HttpServletRequest request;
    private ArrayList<String> country;
	
	public String execute() {  	
		String searchParameter = request.getParameter("search");
		setCountry(AutoCompleterLists.GetCountries(searchParameter)); 
	    return "success";
	   
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		
	}

	/**
	 * @return the country
	 */
	public ArrayList<String> getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(ArrayList<String> country) {
		this.country = country;
	}
	
}
