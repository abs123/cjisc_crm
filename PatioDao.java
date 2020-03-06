package com.mx.cji.crm.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.cji.crm.models.entity.Patio;


@Repository
public class PatioDao implements IPatioDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Patio> findAll() {
		// TODO Auto-generated method stub
		return (List<Patio>) hibernateTemplate.find("from Patio");
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public Patio findById(int id) {
		// TODO Auto-generated method stub
		return  hibernateTemplate.get(Patio.class, id);
	}
	
	
	@Transactional
	@Override
	public void save(Patio patio) {
		// TODO Auto-generated method stub
	  hibernateTemplate.saveOrUpdate(patio);	
	}
	
	

	@Transactional
	@Override
	public void delete(Patio patio) {
		// TODO Auto-generated method stub
	 hibernateTemplate.delete(patio);	
	}

}
