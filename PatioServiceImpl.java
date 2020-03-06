package com.mx.cji.crm.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.cji.crm.models.dao.IPatioDao;
import com.mx.cji.crm.models.entity.Patio;


@Service
public class PatioServiceImpl  implements IPatioService{
	
	@Autowired
	IPatioDao patioDao;
	
	@Override
	public List<Patio> findAll() {
		// TODO Auto-generated method stub
		
		return patioDao.findAll();
	}
	
	@Override
	public Patio findById(int id) {
		// TODO Auto-generated method stub
		return  patioDao.findById(id);
	}
	
	@Override
	public void save(Patio patio) {
		// TODO Auto-generated method stub
	  patioDao.save(patio);	
	}
	
	@Override
	public void delete(Patio patio) {
		// TODO Auto-generated method stub
		patioDao.delete(patio);
	}
	

}
