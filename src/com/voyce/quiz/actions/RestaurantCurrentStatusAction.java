package com.voyce.quiz.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.voyce.quiz.models.RestaurantCurrentStatus;
import com.voyce.quiz.models.Question;
import com.voyce.quiz.models.TableStatus;
import com.voyce.util.JsonUtils;

public class RestaurantCurrentStatusAction extends ActionSupport implements  ServletRequestAware, ServletContextAware,
ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private RestaurantCurrentStatus restaurantCurrentStatus;
	
	private ServletContext servletcontext;  
	
	@Override
    public String execute(){
		
		String filePath = servletcontext.getRealPath("WEB-INF/data/tableStatus.json");
System.out.println("filePath tableStatus.json : " + filePath);
		RestaurantCurrentStatus sessionRestaurantCurrentStatus = JsonUtils.readTableStatusJsonFile(filePath); //from server
		System.out.println(JsonUtils.convertToJson(sessionRestaurantCurrentStatus));
		setRestaurantCurrentStatus(sessionRestaurantCurrentStatus);
		/* need to convert it from json */
		System.out.println("[] request.getParameter(resCusStat) : " + request.getParameter("resCusStat"));
		String str = request.getParameter("resCusStat");
		TableStatus responseTableStatus = null;
		if(str != null){
			responseTableStatus = JsonUtils.tableStatusJsonToObj(str);
			System.out.println(" JsonUtils.convertToJson(foo1) : " + JsonUtils.convertToJson(responseTableStatus));
		}
		
		if(sessionRestaurantCurrentStatus != null && responseTableStatus != null){
			
			int restaurantId = 	responseTableStatus.getRestaurantId();
			List<TableStatus> sessionRestTableStatus = sessionRestaurantCurrentStatus.getRestaurantCurrentStatus().get(restaurantId);
			List<TableStatus> _sessionRestTableStatus = sessionRestTableStatus;
			if(sessionRestTableStatus != null){ //check if table already exists .. TODO: instead of using tableNumber think about using more unique id
			//TODO: get rid of two loops. This could get a bottle neck if the sessionRestTableStatus gets very large.
				
				for(int i = 0; i < _sessionRestTableStatus.size(); i++){
					TableStatus cusTableStatus = sessionRestTableStatus.get(i);
					if(_sessionRestTableStatus.get(i).getTableNumber() == responseTableStatus.getTableNumber() && _sessionRestTableStatus.get(i).getRestaurantId() == restaurantId ){ //only change of one table will come
						
						if(cusTableStatus.getCurrentStatus() == 1 ){ 
							//this means the customer is still seated (as per system). May be he left without giving the feedback. 
							//So the user is trying to assign a new cust to this table.
							//TODO: Save the record to "FEEDBACK NOT GIVEN"  collection.
						}
						sessionRestTableStatus.remove(i);
						sessionRestTableStatus.add(responseTableStatus);
					}
				}
				//JsonUtils.createJsonFile(filePath, restaurantCurrentStatus); //persist the current state 
				//need to set the same in session as well.
			}else{ //add if the table doesnot exits.
				System.out.println("[ERROR ] : Restaurant id :  " + responseTableStatus.getRestaurantId() + " is not found.");
			}
			setRestaurantCurrentStatus(sessionRestaurantCurrentStatus);
		// request.getSession().setAttribute("restaurantCurrentStatus",sessionRestaurantCurrentStatus); //setting the values in session 
		}else if (sessionRestaurantCurrentStatus == null && responseTableStatus != null) { //for first time request. set the values in session and persist it
		//setRestaurantCurrentStatus(sentAsInput_restaurantCurrentStatus); currently not done. The table related data should come from the master table database of the restaurant. 
		// request.getSession().setAttribute("restaurantCurrentStatus", sentAsInput_restaurantCurrentStatus);
		}else{ //if just a read request came then send the session object
			setRestaurantCurrentStatus(sessionRestaurantCurrentStatus);
		}
		System.out.println("Restaurant Current Status end");
		return SUCCESS;
    }
	
	@Override
	public void setServletResponse(HttpServletResponse httpservletresponse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public RestaurantCurrentStatus getRestaurantCurrentStatus() {
		return restaurantCurrentStatus;
	}

	public void setRestaurantCurrentStatus(
			RestaurantCurrentStatus restaurantCurrentStatus) {
		this.restaurantCurrentStatus = restaurantCurrentStatus;
	}

	@Override
	public void setServletContext(ServletContext servletcontext ) {
		this.servletcontext = servletcontext;   
		
	}

}
