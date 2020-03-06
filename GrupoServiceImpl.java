package com.mx.cji.crm.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.cji.crm.models.dao.IGrupoDao;
 
import com.mx.cji.crm.models.entity.Grupo;

@Service()
public class GrupoServiceImpl implements IGrupoService {
	
	
	@Autowired 
	IGrupoDao grupoDao;
		
	@Override
 
	public List<Grupo> findAll() {
		// TODO Auto-generated method stub
		return grupoDao.findAll();
	}
 
	
	@Override
 
	public Grupo findById( int id) {
	    return grupoDao.findById(id);	
	}
	
	@Override
 
	public void save(Grupo grupo)  {
		// TODO Auto-generated method stub
		grupoDao.save(grupo);
		
	}

	
	@Override
 
	public void delete(Grupo grupo) {
		// TODO Auto-generated method stub
		System.out.println("paso por el service");
		  grupoDao.delete(grupo);
	}
	
	
	

}
