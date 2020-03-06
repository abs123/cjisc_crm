package com.mx.cji.crm.models.dao;

import java.util.List;

 
import com.mx.cji.crm.models.entity.Representante;

public interface IRepresentanteDao {
	
    public List<Representante>  findAll();  
	
    public Representante findById(int id);

    public void save(Representante representante);
    
    public void delete(Representante  representante);
    
   
}
