package com.mx.cji.crm.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mx.cji.crm.models.dao.IRepresentanteDao;
import com.mx.cji.crm.models.entity.Representante;

@Service
public class RepresentanteServiceImpl implements IRepresentanteService {
	@Autowired 
	IRepresentanteDao representanteDao;

	@Override
	public List<Representante> findAll() {
		// TODO Auto-generated method stub
		return representanteDao.findAll();
	}

	 @Override
	public Representante findById(int id) {
		// TODO Auto-generated method stub
		return representanteDao.findById(id);
	}
	@Override
	public void save(Representante representante) {
		// TODO Auto-generated method stub
		representanteDao.save(representante);
	}

	@Override
	public void delete(Representante representante) {
		// TODO Auto-generated method stub
      representanteDao.delete(representante);
	}

}
