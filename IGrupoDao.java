package com.mx.cji.crm.models.dao;


import java.util.List;

import com.mx.cji.crm.models.entity.Grupo;


public interface IGrupoDao {
	public List<Grupo>  findAll();  
	
    public void save(Grupo grupo);
    
    public void delete(Grupo  grupos);
    
    public Grupo findById(int id);
    

}
