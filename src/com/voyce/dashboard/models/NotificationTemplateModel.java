/**
 * 
 */
package com.voyce.dashboard.models;

import java.io.Serializable;

/**
 * @author Author: Satendra Singh@Voyce
 * Date: 25th-Dec-2013
 * Note: The class will be used to hold the 
 * the template to be generated for the 
 * notification  
 * 
 *
 */
public class NotificationTemplateModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6703835287263600332L;
	private String tableNo;
	private String customerName;
	private int    feedbackScore;
	private int    feedbackMood;
	private String whatWentWrongText;
	private String whatWentWrongImageUrl;
	private String whatWentRightText;
	private String whatWentRightImageUrl;
	private String superTip;
	/**
	 * @return the tableNo
	 */
	public String getTableNo() {
		return tableNo;
	}
	/**
	 * @param tableNo the tableNo to set
	 */
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the feedbackScore
	 */
	public int getFeedbackScore() {
		return feedbackScore;
	}
	/**
	 * @param feedbackScore the feedbackScore to set
	 */
	public void setFeedbackScore(int feedbackScore) {
		this.feedbackScore = feedbackScore;
	}
	/**
	 * @return the feedbackMood
	 */
	public int getFeedbackMood() {
		return feedbackMood;
	}
	/**
	 * @param feedbackMood the feedbackMood to set
	 */
	public void setFeedbackMood(int feedbackMood) {
		this.feedbackMood = feedbackMood;
	}
	/**
	 * @return the whatWentWrongText
	 */
	public String getWhatWentWrongText() {
		return whatWentWrongText;
	}
	/**
	 * @param whatWentWrongText the whatWentWrongText to set
	 */
	public void setWhatWentWrongText(String whatWentWrongText) {
		this.whatWentWrongText = whatWentWrongText;
	}
	/**
	 * @return the whatWentWrongImageUrl
	 */
	public String getWhatWentWrongImageUrl() {
		return whatWentWrongImageUrl;
	}
	/**
	 * @param whatWentWrongImageUrl the whatWentWrongImageUrl to set
	 */
	public void setWhatWentWrongImageUrl(String whatWentWrongImageUrl) {
		this.whatWentWrongImageUrl = whatWentWrongImageUrl;
	}
	/**
	 * @return the whatWentRightText
	 */
	public String getWhatWentRightText() {
		return whatWentRightText;
	}
	/**
	 * @param whatWentRightText the whatWentRightText to set
	 */
	public void setWhatWentRightText(String whatWentRightText) {
		this.whatWentRightText = whatWentRightText;
	}
	/**
	 * @return the whatWentRightImageUrl
	 */
	public String getWhatWentRightImageUrl() {
		return whatWentRightImageUrl;
	}
	/**
	 * @param whatWentRightImageUrl the whatWentRightImageUrl to set
	 */
	public void setWhatWentRightImageUrl(String whatWentRightImageUrl) {
		this.whatWentRightImageUrl = whatWentRightImageUrl;
	}
	/**
	 * @return the superTip
	 */
	public String getSuperTip() {
		return superTip;
	}
	/**
	 * @param superTip the superTip to set
	 */
	public void setSuperTip(String superTip) {
		this.superTip = superTip;
	}
	
}
