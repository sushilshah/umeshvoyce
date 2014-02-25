/**
 * 
 */
package com.voyce.registration.action;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.voyce.registration.bo.UserManagementBo;


/**
 * @author DeadCode
 *
 */
public class SignupAction  extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest  request;
    private String signupSuccessFull;
    
    
	/**
	 * @return the isSignupSuccessFull
	 */
	public String getSignupSuccessFull() {
		return signupSuccessFull;
	}



	/**
	 * @param isSignupSuccessFull the isSignupSuccessFull to set
	 */
	public void setSignupSuccessFull(String isSignupSuccessFull) {
		this.signupSuccessFull = isSignupSuccessFull;
	}

	
	public String execute(){
	
		signupSuccessFull = "false";
		
		//Just to restrict the fact that users can only be created using the Post method only...
		if(request.getMethod().equalsIgnoreCase("GET"))
		{
			return "success";
		}
		
		String userName 	= request.getParameter("username");
		String password 	= request.getParameter("password");
		
		if(userName !=null && !userName.equalsIgnoreCase(""))
		{
		     if(!isUserExists(userName) && password!=null && !password.equalsIgnoreCase(""))
		     {
		         //Persists the Data to the Data store
		    	 UserManagementBo userManagementBo = new UserManagementBo();
		    	 signupSuccessFull 			   =String.valueOf(userManagementBo.RegisterNewUser(userName, password));
		     }
		     else
		     {
		    	 signupSuccessFull = "false";	    	 
		     }
		}
		
		return "success";
	}

	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request= request;
		
	}

	
	//even though we have client side validation of the fields....
	//but we are making it extra check for the smarts who  will still 
	//try to register...
	private boolean isUserExists(String userName){
		
		UserManagementBo userCheckBo = new UserManagementBo();
		return userCheckBo.isUserExists(userName);
	}
	
	
}
