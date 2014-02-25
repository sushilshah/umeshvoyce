/* @author: Satendra Singh@Voyce
 * Date: 25th-Dec-2013
 * Note: The class will be used to hold the 
 * All the wrong and right feed back of the day
 * 
 * */

package com.voyce.dashboard.models;

import java.io.Serializable;
import java.util.List;

public class RightWrongGoingModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -337795035069663945L;
	private List<String> goodSaying;
	private List<String> badSaying;
	
	
	/**
	 * @return the goodSaying
	 */
	public List<String> getGoodSaying() {
		return goodSaying;
	}
	/**
	 * @param goodSaying the goodSaying to set
	 */
	public void setGoodSaying(List<String> goodSaying) {
		this.goodSaying = goodSaying;
	}
	/**
	 * @return the badSaying
	 */
	public List<String> getBadSaying() {
		return badSaying;
	}
	/**
	 * @param badSaying the badSaying to set
	 */
	public void setBadSaying(List<String> badSaying) {
		this.badSaying = badSaying;
	}
	
}
