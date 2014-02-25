package com.voyce.quiz.models;

import java.io.Serializable;
import java.util.Date;

public class TableStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -927245360236612564L;
	
	private int tableNumber;
	private String phoneNumber;
	private String custName;
	private int currentStatus; // -1: occupied 0: reserved 1: vacant
	private Date occupiedSince;
	private int restaurantId;
	//TODO:  This features can help the restaurant organize tables and quickly find out which table are free and guide them to those table. 
	//private Map<Integer, String> reservedMap; // multiple reserves can be on a tables through the day. A new data might be required.
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
		
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	public Date getOccupiedSince() {
		return occupiedSince;
	}
	public void setOccupiedSince(Date occupiedSince) {
		this.occupiedSince = occupiedSince;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
} //TableStatus end

