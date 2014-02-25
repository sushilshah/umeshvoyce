package com.voyce.dashboard.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.voyce.model.User;
import com.voyce.notification.LiveFeedNotification;

public class DashBoardLiveFeedsAction extends ActionSupport implements  ServletRequestAware  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7101406895105617652L;
	private HttpServletRequest request;
	private String channelKey;
	private String token;
	
	@Override
	public String execute() throws Exception {
		
	   User user = (User)request.getSession().getAttribute("USER");
	   String channelKey = LiveFeedNotification.getChannelKey(user.getUser());
	   setChannelKey(channelKey);
	   ChannelService channelService = ChannelServiceFactory.getChannelService();
	   String token = channelService.createChannel(channelKey);
       setToken(token);
	   return "success";
	   
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
  


	/**
	 * @return the channelKey
	 */
	public String getChannelKey() {
		return channelKey;
	}


	/**
	 * @param channelKey the channelKey to set
	 */
	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}


	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}


	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	
	
}
