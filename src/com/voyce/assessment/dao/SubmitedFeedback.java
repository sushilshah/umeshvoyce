/**
 * 
 */
package com.voyce.assessment.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * @author DeadCode
 * 
 * We will be storing  the feedback result submitted by the user like a document format(JSON),
 * The reason is pretty simple , we will just persist the JSON String for future analysis...
 * And the JSON String we will de-serialize it, when the request came to the assessment manager
 * And we will use the Object to process our business logic and generate the template and 
 * other notification...
 * This will help us to reduce the call to the data store and hence our application will also become 
 * quite fast.
 * Later on if we have to port the storage to the other format we will be able to do it very easily 
 * as we are having the models ready which will help to de-serialize the JSON string and simply 
 * persists into the other storage format.
 */

@Entity
public class SubmitedFeedback {

	@Id
	private  Key restaurentID;

	
	private  String JsonSubmittedResult;

	/**
	 * @return the restaurentID
	 */
	public Key getRestaurentID() {
		return restaurentID;
	}

	/**
	 * @param restaurentID the restaurentID to set
	 */
	public void setRestaurentID(Key restaurentID) {
		this.restaurentID = restaurentID;
	}

	/**
	 * @return the jsonSubmittedResult
	 */
	public String getJsonSubmittedResult() {
		return JsonSubmittedResult;
	}

	/**
	 * @param jsonSubmittedResult the jsonSubmittedResult to set
	 */
	public void setJsonSubmittedResult(String jsonSubmittedResult) {
		JsonSubmittedResult = jsonSubmittedResult;
	}
	
}
