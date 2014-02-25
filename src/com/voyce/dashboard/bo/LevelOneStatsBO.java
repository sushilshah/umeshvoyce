/**
 * 
 */
package com.voyce.dashboard.bo;

import java.util.ArrayList;
import java.util.List;

import com.voyce.dashboard.models.LevelOneStatsModel;


/**
 * @author DeadCode
 *
 */
public class LevelOneStatsBO {

	public List<LevelOneStatsModel> GetLevelOneStats(String id)
	{
		ArrayList<LevelOneStatsModel> statsList = new ArrayList<LevelOneStatsModel>();
		
		LevelOneStatsModel model = new LevelOneStatsModel();
		model.setLevelOneText("Food");
		model.setTotalFeedBack(30);
		model.setCumalative(3.5);
		model.setIndustryStandards(4.3);
		statsList.add(model);
		
		model = new LevelOneStatsModel();
		model.setLevelOneText("Food");
		model.setTotalFeedBack(30);
		model.setCumalative(3.5);
		model.setIndustryStandards(4.3);
		statsList.add(model);
		
		return statsList;
	}
	
}
