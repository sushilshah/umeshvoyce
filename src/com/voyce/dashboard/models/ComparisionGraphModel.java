/**
 * 
 */
package com.voyce.dashboard.models;

import java.io.Serializable;

/**
 * @author: Satendra Singh@ Voyce
 * Date: 25th-Dec-2013
 * Note: The class will be used to hold the 
 * Customer happiness index to be shown on the
 * dash board.
 *
 */
public class ComparisionGraphModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6921655452589935402L;
	private double beforeStats;
	private double afterStats;
	/**
	 * @return the beforeStats
	 */
	public double getBeforeStats() {
		return beforeStats;
	}
	/**
	 * @param beforeStats the beforeStats to set
	 */
	public void setBeforeStats(double beforeStats) {
		this.beforeStats = beforeStats;
	}
	/**
	 * @return the afterStats
	 */
	public double getAfterStats() {
		return afterStats;
	}
	/**
	 * @param afterStats the afterStats to set
	 */
	public void setAfterStats(double afterStats) {
		this.afterStats = afterStats;
	}
}
