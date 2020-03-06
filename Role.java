package com.mx.cji.crm.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Role implements Serializable {

	@Id
	
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	 
	@Column(name="user_id")
	private int userId;
	
	private String authority ;
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	 

	 


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}






	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "Rol [id=" + id + ", authority=" + authority +" ,userId=" + userId+"]";
	}
	
}
