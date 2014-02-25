package com.voyce.quiz.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;
import com.voyce.model.User;
import com.voyce.quiz.models.TableStatus;
import com.voyce.util.JsonUtils;

public class TakeFeedbackAction extends ActionSupport implements  ServletRequestAware, ServletContextAware,
ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
    String str1;
    TableStatus tableStatus;
	private HttpSession session;
	


	@Override
    public String execute(){
		
		//request arrivedd
		
	    //1.extract from request oparamete table  customer phone etc 
		//mark the status in DB as running....
		
		//as per the restaurant login take the seesion and restaurant id as 
	
   		//get the restaurant Id
		
		 
		
		//call the quiz_i.jsp and set the parameter value as hidden fields there using Struts S property
		
		setStr1("this is STR");
		String requestObj =  request.getParameter("requestObj");
		System.out.println(" requestObj : " + requestObj);
		TableStatus ts = new TableStatus();
		if(requestObj != null ){
			ts = JsonUtils.tableStatusJsonToObj(requestObj);
			System.out.println(" JsonUtils.convertToJson(ts) : " + JsonUtils.convertToJson(ts));
			System.out.println("cust name  : " + ts.getCustName());
			request.setAttribute("CustInfo", ts);
			setTableStatus(ts);
		}

		User user = new User();
		user.setTableStatus(ts);
		if(	request.getSession(false)==null)
		{
			HttpSession session = request.getSession(true);
			System.out.println("session have been set ");
			session.setAttribute("USER", user);
		}else{
			System.out.println("else statement");
			request.getSession().setAttribute("USER", user);
		}

		
		
		return SUCCESS;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}


	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public TableStatus getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(TableStatus tableStatus) {
		this.tableStatus = tableStatus;
	}

	
}
