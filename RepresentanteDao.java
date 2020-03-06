package com.mx.cji.crm.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.cji.crm.models.entity.Representante;

@Repository
public class RepresentanteDao implements IRepresentanteDao {
	
    @Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Representante> findAll() {
		// TODO Auto-generated method stub
		
		return (List<Representante>) hibernateTemplate.find("from Representante r order by r.nombre asc ");
	  }
	
	
	@Override
	@Transactional(readOnly=true)
	public Representante findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Representante.class, id);
	}
	

	@Override
    @Transactional
	public void save(Representante representante) {
		// TODO Auto-generated method stub
      hibernateTemplate.saveOrUpdate(representante);
	}

	@Override
	@Transactional
	public void delete(Representante representante) {
		// TODO Auto-generated method stub
      hibernateTemplate.delete(representante);
	}

	

}
