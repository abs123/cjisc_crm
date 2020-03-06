package com.mx.cji.crm.models.service;

import java.util.List;


import com.mx.cji.crm.models.entity.Representante;

public interface IRepresentanteService {
	
	 public List<Representante> findAll();
	 
	 public Representante findById(int id);
	 
	 public void save(Representante representante);
	 
	 public void delete(Representante  representante);
     
	

}
