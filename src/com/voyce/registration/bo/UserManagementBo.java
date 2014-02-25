/**
 * 
 */
package com.voyce.registration.bo;


import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.voyce.registration.Entity.VoyceUsers;
import com.voyce.registration.dao.UserMangementDao;

/**
 * @author DeadCode
 *
 */
public class UserManagementBo {

	public boolean RegisterNewUser(String userName, String password){
		
		//Here we will use the Encryption Module to encrypt the password before 
		//persisting...but for now we are  not....
		//We need a key which is unique for persistence
		Key userId = KeyFactory.createKey("VoyceUsers", userName);
	
		
		VoyceUsers user = new VoyceUsers();
		user.setUserId(userId);
		user.setUsername(userName);
		user.setPassword(password);
		
		//Send it for persistence
		UserMangementDao dao = new UserMangementDao();
		return dao.RegisterNewUser(user);
	}
	
	
    public boolean isUserExists(String userName){
		
		//Get the user name from the data base 
    	UserMangementDao dao = new UserMangementDao();
		return dao.isUserExists(userName);
	}
	
    
    public boolean AuthenticateUser(String userName,String password){
    	
    	UserMangementDao  dao  = new UserMangementDao();
    	VoyceUsers        user = dao.GetUserData(userName);
    	
    	//if we have use the encryption module to encrypt the password and 
    	//persist then we need to repeat the encryption here as well
    	//So that password should match ,...for now we are not encrypting...
    	
    	if(null !=user && user.getPassword().equals(password)) 
    	{	
    	   return true;
    	}
    	
    	   return false;
    }
    
}
