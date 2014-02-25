package com.voyce.quiz.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.voyce.quiz.models.TableStatus;

public class TFAction  extends ActionSupport implements  ServletRequestAware,ServletContextAware, ServletResponseAware{

	private TableStatus tablestatus;
	
	
	@Override
	public String execute(){
		TableStatus foo = new TableStatus();
		foo.setPhoneNumber("444555444");
		foo.setCustName("The name of the cutomer");
		setTablestatus(foo);
		return SUCCESS;
	}
	
	
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}


	public TableStatus getTablestatus() {
		return tablestatus;
	}


	public void setTablestatus(TableStatus tablestatus) {
		this.tablestatus = tablestatus;
	}
	
	
	
}
