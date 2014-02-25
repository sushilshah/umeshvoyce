/**
 * 
 */
package com.voyce.dashboard.models;

import java.io.Serializable;

/**
 * @author: Satendra Singh@ Voyce
 * Date: 25th-Dec-2013
 * Note: The class will be used to hold the 
 * Level One stats like how many given feed back
 * out of which how many bad , good etc.
 * 
 * */

public class LevelOneStatsModel implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1802256518480751047L;
private int    levelOneId;
  private String levelOneText;
  private int    totalFeedBack;
  private double cumalative;
  private double industryStandards;
  
/**
 * @return the levelOneId
 */
public int getLevelOneId() {
	return levelOneId;
}
/**
 * @param levelOneId the levelOneId to set
 */
public void setLevelOneId(int levelOneId) {
	this.levelOneId = levelOneId;
}
/**
 * @return the levelOneText
 */
public String getLevelOneText() {
	return levelOneText;
}
/**
 * @param levelOneText the levelOneText to set
 */
public void setLevelOneText(String levelOneText) {
	this.levelOneText = levelOneText;
}
/**
 * @return the totalFeedBack
 */
public int getTotalFeedBack() {
	return totalFeedBack;
}
/**
 * @param totalFeedBack the totalFeedBack to set
 */
public void setTotalFeedBack(int totalFeedBack) {
	this.totalFeedBack = totalFeedBack;
}
/**
 * @return the cumalative
 */
public double getCumalative() {
	return cumalative;
}
/**
 * @param cumalative the cumalative to set
 */
public void setCumalative(double cumalative) {
	this.cumalative = cumalative;
}
/**
 * @return the industryStandards
 */
public double getIndustryStandards() {
	return industryStandards;
}
/**
 * @param industryStandards the industryStandards to set
 */
public void setIndustryStandards(double industryStandards) {
	this.industryStandards = industryStandards;
}
	
}
