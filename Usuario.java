package com.mx.cji.crm.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

 

 

@Entity
@Table(name="users")
public class Usuario implements Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
 
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido_Pat")
	private String apellidoPat;
	
	@Column(name="apellido_Mat")
	private String apellidoMat;
		
	private Boolean enabled;
	
	 
	
	@NotEmpty
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_user_profile", 
             joinColumns = { @JoinColumn(name = "user_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "user_profile_id") })
	private Set<UserRole> userProfiles = new HashSet<UserRole>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	 
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public Set<UserRole> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserRole> userProfiles) {
		this.userProfiles = userProfiles;
	}


	private static final long serialVersionUID = 1L;


   
	

	// toString for debugging
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled +" ,userProfiles="+userProfiles+"]";
	}

 
	
	
	
	
	
	
	
}
