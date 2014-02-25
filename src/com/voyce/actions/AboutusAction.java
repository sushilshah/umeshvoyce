package com.voyce.actions;

import com.opensymphony.xwork2.ActionSupport;

 
public class AboutusAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String data;
	
	
	@Override
    public String execute(){	
		setData("helll0000000000");
        return "success";
    }
     
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
 
}