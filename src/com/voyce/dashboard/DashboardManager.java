package com.voyce.dashboard;

import com.voyce.dashboard.bo.DashBoardBO;
import com.voyce.dashboard.models.DashBoardModel;

public class DashboardManager   {

  public DashBoardModel GetDashBoard(int restaurentId)
  {
	  DashBoardBO dashboard = new DashBoardBO();
	  return  dashboard.GetDashBoard();
  }
	
}
