package com.voyce.model;

import java.io.Serializable;

import com.voyce.quiz.models.TableStatus;

public class User implements Serializable {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 7966846029258789337L;
	private String user;
    private String password;
    private String userName;
    private TableStatus tableStatus; //not a good idea. Only a hack need to change it later
    
    
    
    public TableStatus getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(TableStatus tableStatus) {
		this.tableStatus = tableStatus;
	}
	public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
     
}