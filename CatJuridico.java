package com.mx.cji.crm.models.entity;
// Generated 19/06/2019 04:57:48 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CatJuridico generated by hbm2java
 */
@Entity
@Table(name = "cat_juridico", catalog = "cji")
public class CatJuridico implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private CatJuridicoId id;

	public CatJuridico() {
	}

	public CatJuridico(CatJuridicoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idJuridico", column = @Column(name = "id_juridico")),
			@AttributeOverride(name = "nombre", column = @Column(name = "nombre", length = 100)) })
	public CatJuridicoId getId() {
		return this.id;
	}

	public void setId(CatJuridicoId id) {
		this.id = id;
	}

}
