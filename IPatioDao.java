package com.mx.cji.crm.models.dao;

import java.util.List;

import com.mx.cji.crm.models.entity.Patio;

public interface IPatioDao  {
	
	public List<Patio>findAll();
	
	public void save(Patio patio);
	
	public void delete(Patio patio);
	
	public Patio findById(int id);
	

}
