/**
 * 
 */
package com.voyce.dashboard.bo;

import java.util.ArrayList;

import com.voyce.dashboard.models.RightWrongGoingModel;

/**
 * @author DeadCode
 *
 */
public class RightWrongGoingBO {

	public RightWrongGoingModel GetRightWrongGoing(){
		
		RightWrongGoingModel  model = new RightWrongGoingModel();
		
		ArrayList<String> goodSaying = new ArrayList<String>();
		goodSaying.add("I found the food good!!!");
		goodSaying.add("I found the ambience good!!!");
		model.setGoodSaying(goodSaying);
		
		ArrayList<String> badSaying = new ArrayList<String>();
		badSaying.add("I found the temperature worst!!!");
		badSaying.add("I found the hospitality worst!!!");
		model.setBadSaying(badSaying);
		
		return model;
	}
}
