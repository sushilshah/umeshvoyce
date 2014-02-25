package com.voyce.notification;

import voyce.com.template.model.FeedTemplate;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class LiveFeedNotification {

	 /*Channel API Specific Codes*/	
	 public static String getChannelKey(String user) {
		 Key key = KeyFactory.createKey(user, user);
		    return user + KeyFactory.keyToString(key);
		  }
	
	public static void sendUpdateToUser(String user, FeedTemplate model) {
	    if (user != null) {
	      ChannelService channelService = ChannelServiceFactory.getChannelService();
	      String channelKey = LiveFeedNotification.getChannelKey(user);
	      channelService.sendMessage(new ChannelMessage(channelKey, model.toString()));
	    }
	  }

	public String getMessageString(){
		
		return "Retieevd Message";
	}
	 
}
