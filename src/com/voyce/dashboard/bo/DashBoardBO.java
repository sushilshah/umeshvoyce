/**
 * 
 */
package com.voyce.dashboard.bo;

import com.voyce.dashboard.models.DashBoardModel;

/**
 * @author DeadCode
 *
 */
public class DashBoardBO {

	public DashBoardModel GetDashBoard()
	{
		DashBoardModel 		model 		= new DashBoardModel();
		CustomerHIBO 		chiBo 		= new CustomerHIBO();
		ComparisionGraphBO 	compBo 		= new ComparisionGraphBO();
		LevelOneStatsBO    	leveloneBo 	= new LevelOneStatsBO();
		RightWrongGoingBO   rgBo 		= new RightWrongGoingBO();
		
		model.setChi(chiBo.CustomerHi("1"));
		model.setComparisionGraph(compBo.GetComparisionGraph("1","yt"));
		model.setLevelOneStats(leveloneBo.GetLevelOneStats("1"));
		model.setRightWrong(rgBo.GetRightWrongGoing());
		return model;
		
	}
}
