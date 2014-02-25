package com.voyce.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.voyce.model.User;
 
public class AuthenticationInterceptor implements Interceptor {
 
    private static final long serialVersionUID = -5011962009065225959L;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

    public String intercept(ActionInvocation actionInvocation)
            throws Exception {
        
        HttpSession session = ServletActionContext.getRequest().getSession(true);
        User user 			= (User)session.getAttribute("USER");
        
        if( user == null)
        {
            return Action.LOGIN;
        }
        else
        {
            Action action = (Action) actionInvocation.getAction();
            if(action instanceof UserAware){
                ((UserAware) action).setUser(user);
                session.setAttribute("USER",user);
            }
            return actionInvocation.invoke();
        }
    }

 
	
	
 
}
