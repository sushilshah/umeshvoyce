/**
 * 
 */
package com.voyce.registration.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author DeadCode
 *
 */
@Entity
public class Services {

	/*Part of Service Now*/
	@Id
	private String  		emailId;
	
	private Facilities 	  	facilitiesAvail;
	private Features      	featuresAvail;
	private PaymentOption 	paymentOptionsAvail;
    private List<String>  	cusines;
	
	
    String restaurantCategory;
     /**
	 * @return the restaurantCategory
	 */
	public String getRestaurantCategory() {
		return restaurantCategory;
	}
	/**
	 * @param restaurantCategory the restaurantCategory to set
	 */
	public void setRestaurantCategory(String restaurantCategory) {
		this.restaurantCategory = restaurantCategory;
	}
	/**
	 * @return the facilitiesAvail
	 */
	public Facilities getFacilitiesAvail() {
		return facilitiesAvail;
	}
	/**
	 * @param facilitiesAvail the facilitiesAvail to set
	 */
	public void setFacilitiesAvail(Facilities facilitiesAvail) {
		this.facilitiesAvail = facilitiesAvail;
	}
	/**
	 * @return the featuresAvail
	 */
	public Features getFeaturesAvail() {
		return featuresAvail;
	}
	/**
	 * @param featuresAvail the featuresAvail to set
	 */
	public void setFeaturesAvail(Features featuresAvail) {
		this.featuresAvail = featuresAvail;
	}
	/**
	 * @return the paymentOptionsAvail
	 */
	public PaymentOption getPaymentOptionsAvail() {
		return paymentOptionsAvail;
	}
	/**
	 * @param paymentOptionsAvail the paymentOptionsAvail to set
	 */
	public void setPaymentOptionsAvail(PaymentOption paymentOptionsAvail) {
		this.paymentOptionsAvail = paymentOptionsAvail;
	}
	/**
	 * @return the cusines
	 */
	public List<String> getCusines() {
		return cusines;
	}
	/**
	 * @param cusines the cusines to set
	 */
	public void setCusines(List<String> cusines) {
		this.cusines = cusines;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
}
