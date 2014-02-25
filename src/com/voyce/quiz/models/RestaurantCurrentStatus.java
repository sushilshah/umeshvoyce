package com.voyce.quiz.models;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class RestaurantCurrentStatus {
	
	private Map<Integer, List<TableStatus>> restaurantCurrentStatus;
	
	public Map<Integer, List<TableStatus>> getRestaurantCurrentStatus() {
		return restaurantCurrentStatus;
	}
	public void setRestaurantCurrentStatus(
			Map<Integer, List<TableStatus>> restaurantCurrentStatus) {
		this.restaurantCurrentStatus = restaurantCurrentStatus;
	}
	
}
