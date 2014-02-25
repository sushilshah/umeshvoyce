/**
 * 
 */
package com.voyce.registration.Entity;

/**
 * @author DeadCode
 *
 */
public class Facilities {

	private boolean dineIn;
	private boolean delivery;
	private boolean takeAway;
	private boolean catering;
	
	
	/**
	 * @return the dineIn
	 */
	public boolean isDineIn() {
		return dineIn;
	}
	/**
	 * @param dineIn the dineIn to set
	 */
	public void setDineIn(boolean dineIn) {
		this.dineIn = dineIn;
	}
	/**
	 * @return the delivery
	 */
	public boolean isDelivery() {
		return delivery;
	}
	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	/**
	 * @return the takeAway
	 */
	public boolean isTakeAway() {
		return takeAway;
	}
	/**
	 * @param takeAway the takeAway to set
	 */
	public void setTakeAway(boolean takeAway) {
		this.takeAway = takeAway;
	}
	/**
	 * @return the catering
	 */
	public boolean isCatering() {
		return catering;
	}
	/**
	 * @param catering the catering to set
	 */
	public void setCatering(boolean catering) {
		this.catering = catering;
	}
	
	
}
