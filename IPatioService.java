package com.mx.cji.crm.models.service;

import java.util.List;

import com.mx.cji.crm.models.entity.Patio;


public interface IPatioService {
	
	public List<Patio> findAll();
 
	 
	 public Patio findById(int id);
	 
	 public void save(Patio patio);
	 
	 public void delete(Patio  patio);

}
