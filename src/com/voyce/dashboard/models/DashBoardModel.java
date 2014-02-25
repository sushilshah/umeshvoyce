/**
 * 
 */
package com.voyce.dashboard.models;

import java.io.Serializable;
import java.util.List;

/**
 * @author DeadCode
 *
 */
public class DashBoardModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7805957017671694110L;
	private String                      id;
	private CustomerHIModel 			chi;
	private NotificationTemplateModel 	template;
	private RightWrongGoingModel        rightWrong;
	private ComparisionGraphModel       comparisionGraph;
	private List<LevelOneStatsModel>    levelOneStats;
	
	/**
	 * @return the chi
	 */
	public CustomerHIModel getChi() {
		return chi;
	}
	/**
	 * @param chi the chi to set
	 */
	public void setChi(CustomerHIModel chi) {
		this.chi = chi;
	}
	/**
	 * @return the template
	 */
	public NotificationTemplateModel getTemplate() {
		return template;
	}
	/**
	 * @param template the template to set
	 */
	public void setTemplate(NotificationTemplateModel template) {
		this.template = template;
	}
	/**
	 * @return the rightWrong
	 */
	public RightWrongGoingModel getRightWrong() {
		return rightWrong;
	}
	/**
	 * @param rightWrong the rightWrong to set
	 */
	public void setRightWrong(RightWrongGoingModel rightWrong) {
		this.rightWrong = rightWrong;
	}
	/**
	 * @return the comparisionGraph
	 */
	public ComparisionGraphModel getComparisionGraph() {
		return comparisionGraph;
	}
	/**
	 * @param comparisionGraph the comparisionGraph to set
	 */
	public void setComparisionGraph(ComparisionGraphModel comparisionGraph) {
		this.comparisionGraph = comparisionGraph;
	}
	/**
	 * @return the levelOneStats
	 */
	public List<LevelOneStatsModel> getLevelOneStats() {
		return levelOneStats;
	}
	/**
	 * @param levelOneStats the levelOneStats to set
	 */
	public void setLevelOneStats(List<LevelOneStatsModel> levelOneStats) {
		this.levelOneStats = levelOneStats;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}      
}
