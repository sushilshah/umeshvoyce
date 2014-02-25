package com.voyce.quiz.models;

import com.voyce.quiz.models.TableStatus;

public enum TableStatusCodes {
	OCCUPIED("O"),IDLE("I"),RESERVED("R");
	
	private String tableStatusCode;
	private  TableStatusCodes(String s){
		tableStatusCode = s;
	}
	public String getTableStatusCode(){
		return tableStatusCode;
	}
	public static TableStatusCodes getTableStatusCodes(String tableStatusCode){
		for(TableStatusCodes t : TableStatusCodes.values())
			if(tableStatusCode.equalsIgnoreCase(t.getTableStatusCode()))
				return t;
		return null;
	}
}
