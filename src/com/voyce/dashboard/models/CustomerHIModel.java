/* @author: Satendra Singh@ Voyce
 * Date: 25th-Dec-2013
 * Note: The class will be used to hold the 
 * Customer happiness index to be shown on the
 * dash board.
 * 
 * */
package com.voyce.dashboard.models;

import java.io.Serializable;

public class CustomerHIModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6974339758347802754L;
	private String imageUrl;
	private double customerHappyIndex;
	private int    customersGivenFeedback;
	private int    customerHappy;
	private int    customerNoFeeling;
	private int    customerHateUs;
	
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the customerHappyIndex
	 */
	public double getCustomerHappyIndex() {
		return customerHappyIndex;
	}
	/**
	 * @param customerHappyIndex the customerHappyIndex to set
	 */
	public void setCustomerHappyIndex(double customerHappyIndex) {
		this.customerHappyIndex = customerHappyIndex;
	}
	/**
	 * @return the customersGivenFeedback
	 */
	public int getCustomersGivenFeedback() {
		return customersGivenFeedback;
	}
	/**
	 * @param customersGivenFeedback the customersGivenFeedback to set
	 */
	public void setCustomersGivenFeedback(int customersGivenFeedback) {
		this.customersGivenFeedback = customersGivenFeedback;
	}
	/**
	 * @return the customerHappy
	 */
	public int getCustomerHappy() {
		return customerHappy;
	}
	/**
	 * @param customerHappy the customerHappy to set
	 */
	public void setCustomerHappy(int customerHappy) {
		this.customerHappy = customerHappy;
	}
	/**
	 * @return the customerNoFeeling
	 */
	public int getCustomerNoFeeling() {
		return customerNoFeeling;
	}
	/**
	 * @param customerNoFeeling the customerNoFeeling to set
	 */
	public void setCustomerNoFeeling(int customerNoFeeling) {
		this.customerNoFeeling = customerNoFeeling;
	}
	/**
	 * @return the customerHateUs
	 */
	public int getCustomerHateUs() {
		return customerHateUs;
	}
	/**
	 * @param customerHateUs the customerHateUs to set
	 */
	public void setCustomerHateUs(int customerHateUs) {
		this.customerHateUs = customerHateUs;
	}
	
}
