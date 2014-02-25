/**
 * 
 */
package com.voyce.registration.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * @author DeadCode
 *
 */

@Entity
public class VoyceUsers {
    
	@Id
	private Key userId;
	
	private String  username;// we will use the user name as the Email Id only...
	
	private String  password;//we will do the secure way of storing the password
	private int     active;//1 for active and 0 for inactive
	private String  role;//We are just keeping this field for future use
	private String  groupid;//This is also to keep it for future user
	private int     permission;//This is also kept for future use 
	private Date    dateOfRegistration;
	private boolean istrial;
	private int     periodOfTrial;
	
	
	/**
	 * @return the istrial
	 */
	public boolean isIstrial() {
		return istrial;
	}
	/**
	 * @param istrial the istrial to set
	 */
	public void setIstrial(boolean istrial) {
		this.istrial = istrial;
	}
	/**
	 * @return the periodOfTrial
	 */
	public int getPeriodOfTrial() {
		return periodOfTrial;
	}
	/**
	 * @param periodOfTrial the periodOfTrial to set
	 */
	public void setPeriodOfTrial(int periodOfTrial) {
		this.periodOfTrial = periodOfTrial;
	}

	
	/**
	 * @return the dateOfRegistration
	 */
	public Date getDateOfRegistration() {
		
		return dateOfRegistration;
	}
	/**
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(Date dateOfRegistration) {
		
		this.dateOfRegistration = dateOfRegistration;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		
		this.password = password;
	}
	/**
	 * @return the active
	 */
	public int getActive() {
		
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		
		this.active = active;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the groupid
	 */
	public String getGroupid() {
		return groupid;
	}
	/**
	 * @param groupid the groupid to set
	 */
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	/**
	 * @return the permission
	 */
	public int getPermission() {
		return permission;
	}
	/**
	 * @param permission the permission to set
	 */
	public void setPermission(int permission) {
		this.permission = permission;
	}
	/**
	 * @return the userId
	 */
	public Key getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Key userId) {
		this.userId = userId;
	}

}
