/**
 * 
 */
package com.voyce.registration.Entity;

/**
 * @author DeadCode
 *
 */
public class PaymentOption {

	private boolean  cash;
	private boolean  credit;
	private boolean  sodexo;
	private boolean  citiBankOffers;
	private boolean  onlineOders;
	private String   reservation;
	private String   fromOpenHours;
	private String   fromToOpenHours;
	/**
	 * @return the cash
	 */
	public boolean isCash() {
		return cash;
	}
	/**
	 * @param cash the cash to set
	 */
	public void setCash(boolean cash) {
		this.cash = cash;
	}
	/**
	 * @return the credit
	 */
	public boolean isCredit() {
		return credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(boolean credit) {
		this.credit = credit;
	}
	/**
	 * @return the sodexo
	 */
	public boolean isSodexo() {
		return sodexo;
	}
	/**
	 * @param sodexo the sodexo to set
	 */
	public void setSodexo(boolean sodexo) {
		this.sodexo = sodexo;
	}
	/**
	 * @return the citiBankOffers
	 */
	public boolean isCitiBankOffers() {
		return citiBankOffers;
	}
	/**
	 * @param citiBankOffers the citiBankOffers to set
	 */
	public void setCitiBankOffers(boolean citiBankOffers) {
		this.citiBankOffers = citiBankOffers;
	}
	/**
	 * @return the onlineOders
	 */
	public boolean isOnlineOders() {
		return onlineOders;
	}
	/**
	 * @param onlineOders the onlineOders to set
	 */
	public void setOnlineOders(boolean onlineOders) {
		this.onlineOders = onlineOders;
	}
	/**
	 * @return the reservation
	 */
	public String getReservation() {
		return reservation;
	}
	/**
	 * @param reservation the reservation to set
	 */
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	/**
	 * @return the fromOpenHours
	 */
	public String getFromOpenHours() {
		return fromOpenHours;
	}
	/**
	 * @param fromOpenHours the fromOpenHours to set
	 */
	public void setFromOpenHours(String fromOpenHours) {
		this.fromOpenHours = fromOpenHours;
	}
	/**
	 * @return the fromToOpenHours
	 */
	public String getFromToOpenHours() {
		return fromToOpenHours;
	}
	/**
	 * @param fromToOpenHours the fromToOpenHours to set
	 */
	public void setFromToOpenHours(String fromToOpenHours) {
		this.fromToOpenHours = fromToOpenHours;
	}
	
	
}
