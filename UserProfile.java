package com.mx.cji.crm.models.entity;

import java.io.Serializable;

public enum UserProfile  implements Serializable {
	
	
	USER("USER"),
	OPERADOR("OPERADOR"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfile(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}

}
