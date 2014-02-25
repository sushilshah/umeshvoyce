package com.voyce.dashboard.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.voyce.dashboard.DashboardManager;
import com.voyce.dashboard.models.DashBoardModel;


public class DashboardAction extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5521812207786073958L;
	private DashBoardModel dashboard;
	
	@Override
	public String execute() throws Exception {
		
		DashboardManager manager = new DashboardManager();
		setDashboard(manager.GetDashBoard(1));
		getDashboard().setId("helli os");
		return SUCCESS;
	}

	/**
	 * @return the dashboard
	 */
	public DashBoardModel getDashboard() {
		return dashboard;
	}

	/**
	 * @param dashboard the dashboard to set
	 */
	public void setDashboard(DashBoardModel dashboard) {
		this.dashboard = dashboard;
	}

	
}