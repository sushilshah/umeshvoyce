/**
 * 
 */
package com.voyce.dashboard.bo;

import com.voyce.dashboard.models.CustomerHIModel;

/**
 * @author DeadCode
 *
 */
public class CustomerHIBO {

	public CustomerHIModel CustomerHi(String id)
	{
	    //Calculate the CustomerHi here and populate the result with the model
		CustomerHIModel model = new CustomerHIModel();
		model.setImageUrl("img/im.jpg");
		model.setCustomerHappy(40);
		model.setCustomerHappyIndex(3.6);
		model.setCustomerHateUs(30);
		model.setCustomerNoFeeling(50);
		model.setCustomersGivenFeedback(120);
		return model;
	}
	
}
