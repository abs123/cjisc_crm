package com.mx.cji.crm.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cat_grupos")
public class Grupo implements Serializable {

 
 
 @Id
 @GeneratedValue(strategy =GenerationType.IDENTITY)
 @Column(name="id")
 private int id;

 @NotEmpty
 private String nombre; 

 private Integer user_id;
 
 @Column(name="creat_At")
 @Temporal(TemporalType.TIMESTAMP)
 private Date creatAt;
  
 @PrePersist
 public void prePersist() {
	 this.creatAt=new Date();
 }
 
 
 
 
    public Grupo() {
    	
    	
    }
 



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getCreat_At() {
		return creatAt;
	}
	 

	public void setCreat_At(Date creat_At) {
		
		this.creatAt = creat_At;
	}
		
	 
  



	 @Override
	    public String toString() {
	        final StringBuilder builder = new StringBuilder();
	        builder.append("Grupo [id=").append(id).append(", nombre=").append(nombre).append("]");
	        return builder.toString();
	    }





	private static final long serialVersionUID = 1L;

}
