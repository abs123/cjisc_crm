package com.mx.cji.crm.models.entity;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="tbl_domicilio")

public class FileInfoDomicilio {

	private static final long serialVersionUID = 1L;
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    
    @NotNull	
   	private int empresa_id;
    
    @NotNull
    @Column(name="user_id")
   	private int usuario_id;	
	
    @NotEmpty
	@Column(name="nombreArchivo")
    private String nombre;
    
	@NotEmpty
	@Column(name="rutaArchivo")
	private String ruta;
    
	
	
    @NotEmpty
	private String codigo;
	
     
    @Transient
    private String nombreEmpresa;
	
	
	@Column(name="create_At")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	 
	
	
	@PrePersist
	public void prePersist() {
		createAt=new Date();
	}
	
	
	public FileInfoDomicilio() {
		// TODO Auto-generated constructor stub
	}
	 

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	@Transient 
	private MultipartFile file;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	
	
	
}
