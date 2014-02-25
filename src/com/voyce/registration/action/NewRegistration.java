/**
 * 
 */
package com.voyce.registration.action;



import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DeadCode
 *
 */
public class NewRegistration extends ActionSupport implements ServletRequestAware{

	HttpServletRequest request;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		
		
		
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request = request; 
		
	}

	
	
}
