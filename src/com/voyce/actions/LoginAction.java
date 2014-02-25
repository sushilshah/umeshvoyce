package com.voyce.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.voyce.model.User;
import com.voyce.registration.bo.UserManagementBo;
 
public class LoginAction extends ActionSupport implements ModelDriven<User>, ServletRequestAware,
ServletResponseAware{
 
    private static final long serialVersionUID = -3369875299120377549L;
    private User user = new User();
    private HttpServletRequest request = null;
    
    
    @Override
    public String execute(){
   
    	UserManagementBo usermgbo = new UserManagementBo();
    	boolean isAuthenticated = usermgbo.AuthenticateUser(user.getUser(), user.getPassword());
    	
        if(isAuthenticated){
        	
            HttpSession mySession = request.getSession();
            mySession.setAttribute("USER",user);
            return SUCCESS;
        }
        return INPUT;
    }
     
    
         
    public User getModel() {
        return user;
    }

	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		
		this.request = httpServletRequest;
	}
     
}