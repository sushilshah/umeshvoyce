package com.voyce.dashboard.models;

import java.io.Serializable;

public class LevelTwoStatsModel implements Serializable {

	  /**
	 * 
	 */
	private static final long serialVersionUID = -7449073301115046216L;
	private int    levelTwoId;
	  private String levelTwoText;
	  private int    totalFeedBack;
	  private double cumulative;
	  private double industryStandards;
	
	  /**
	   * @return the levelTwoId
	   */
	public int getLevelTwoId() {
		return levelTwoId;
	}
	/**
	 * @param levelTwoId the levelTwoId to set
	 */
	public void setLevelTwoId(int levelTwoId) {
		this.levelTwoId = levelTwoId;
	}
	/**
	 * @return the levelTwoText
	 */
	public String getLevelTwoText() {
		return levelTwoText;
	}
	/**
	 * @param levelTwoText the levelTwoText to set
	 */
	public void setLevelTwoText(String levelTwoText) {
		this.levelTwoText = levelTwoText;
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
	 * @return the cumulative
	 */
	public double getcumulative() {
		return cumulative;
	}
	/**
	 * @param cumalative the cumulative to set
	 */
	public void setcumulative(double cumulative) {
		this.cumulative = cumulative;
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
