package com.voyce.quiz.actions;

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

public class CreateQuestions extends ActionSupport implements SessionAware, ModelDriven<User>, ServletRequestAware,
ServletResponseAware{

    @Override
    public String execute(){
    	HttpSession mySession = request.getSession();
    	String questionLists = request.getParameter("questionsList");
        //System.out.println("inside execute");
        /*if("saty".equals(user.getUser()) && "admin".equals(user.getPassword())){
            user.setUserName("Satyyyyww");
            sessionAttributes.put("USER", user);
            HttpSession mySession = request.getSession();
            mySession.setAttribute("USER",user);*/
            return SUCCESS;
       // }
      //  return null;
    }
    
    private HttpServletRequest request = null;
    
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		// TODO Auto-generated method stub
		this.request = httpServletRequest;
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
}
