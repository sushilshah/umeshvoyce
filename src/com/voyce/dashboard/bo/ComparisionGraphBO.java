/**
 * 
 */
package com.voyce.dashboard.bo;

import com.voyce.dashboard.models.ComparisionGraphModel;

/**
 * @author DeadCode
 *
 */
public class ComparisionGraphBO {

	public ComparisionGraphModel GetComparisionGraph(String id,String typeOfCpmaprision)
	{
		//Based On the type of comparison a Comparison Will be generated
		ComparisionGraphModel model = new ComparisionGraphModel();
		model.setBeforeStats(35.6);
		model.setAfterStats(30);
		return model;
	}
	
}
