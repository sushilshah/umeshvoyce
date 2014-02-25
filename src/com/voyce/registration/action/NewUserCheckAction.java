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
public class NewUserCheckAction extends ActionSupport implements ServletRequestAware {

	

	private static final long serialVersionUID = 1L;
	private boolean exists;
	
	
	public String execute(){
			
		return "success";
	}

	
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}


	public boolean isExists() {
		return exists;
	}



	public void setExists(boolean exists) {
		this.exists = exists;
	}
	
	
	
}
