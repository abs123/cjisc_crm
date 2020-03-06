package com.mx.cji.crm.models.service;

import java.util.List;

import com.mx.cji.crm.models.entity.Grupo;
 
public interface IGrupoService {
	
	
     public List<Grupo> findAll();
     
     public Grupo findById(int id);
     
	 public void save(Grupo grupo);
	 
	 public void delete(Grupo  grupo);
   
}
