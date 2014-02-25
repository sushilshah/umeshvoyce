package com.voyce.assessment.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.voyce.notification.NotificationManager;

public class AssessmentAction extends ActionSupport implements ServletRequestAware {
              
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1000728761196974912L;
	HttpServletRequest request;
	@Override
	public String execute() throws Exception {
		String usertosend = request.getParameter("user"); 
		
		NotificationManager manager = new NotificationManager();
		manager.NotifyLiveFeed(usertosend);
	    return NONE;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
