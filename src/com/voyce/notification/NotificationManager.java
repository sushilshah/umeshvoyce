package com.voyce.notification;

import voyce.com.template.model.FeedTemplate;

public class NotificationManager {

	public void NotifyLiveFeed(String user){
		FeedTemplate feed = new FeedTemplate();
		feed.setTemlatexyz("Hello yyyy");
		feed.setTemplateType("I am template");
		LiveFeedNotification.sendUpdateToUser(user,feed);
	}
	
}
