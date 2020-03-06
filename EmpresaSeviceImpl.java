package com.mx.cji.crm.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.cji.crm.models.dao.EmpresaDao;
import com.mx.cji.crm.models.dao.IEmpresaDao;
import com.mx.cji.crm.models.dao.IGrupoDao;
import com.mx.cji.crm.models.dao.IPatioDao;
import com.mx.cji.crm.models.dao.IRepresentanteDao;
import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.models.entity.Grupo;
import com.mx.cji.crm.models.entity.Patio;
import com.mx.cji.crm.models.entity.Representante;
import com.mx.cji.crm.util.paginador.PageHibernate;

@Service
public class EmpresaSeviceImpl implements IEmpresaService {
	
	@Autowired
	private IEmpresaDao iempresaDao;
	@Autowired
	private IGrupoDao igrupoDao;
	@Autowired
	private IPatioDao ipatioDao;
	@Autowired
	private IRepresentanteDao irepresentanteDao;
	
	

	@Override
	@Transactional(readOnly=true)
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return iempresaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Empresa findById(int id) {
		// TODO Auto-generated method stub
		return iempresaDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Empresa empresa) {
		// TODO Auto-generated method stub
		iempresaDao.save(empresa);
	}

	@Override
	@Transactional
	public void delete(Empresa empresa) {
		// TODO Auto-generated method stub
		iempresaDao.delete(empresa);
		
	}
	
	
    //codigo para los form-optio del JSP de empresa
	
   @Transactional(readOnly=true)
   public List<Grupo> findAllGrupo(){	   
	   return igrupoDao.findAll();	   
   }
   @Transactional(readOnly=true)
   public Grupo findByIdGrupo(int id) {
   return  igrupoDao.findById(id);	   
   }
   	
   @Transactional(readOnly=true)
   public List<Patio> findAllPatio(){
	   	   return ipatioDao.findAll();
    }   
   
   @Override
   @Transactional(readOnly=true)
    public Patio findByIdPatio(int id) {
    	return ipatioDao.findById(id);
    }
   
   
   @Override 
   @Transactional(readOnly=true)
   public List<Representante> findAllLegal(){
	   return irepresentanteDao.findAll();	   
   }
   
   @Transactional(readOnly=true)
   public Representante findByIdLegal(int id) {
   	return irepresentanteDao.findById(id);
   }
 
 
   @Override
public List<Empresa> findallEmpresa() {
	// TODO Auto-generated method stub
	return  iempresaDao.findallEmpresas();
}
 
   @Override
   @Transactional(readOnly = true)
   public PageHibernate findAllPager(String page, int resultsPerPage, String orderBy){
   	return iempresaDao.findAllPager(page, resultsPerPage, orderBy);
   }
	   
	  
   public List<Empresa> findByRfc(String rfc) {
	   
	 return   iempresaDao.findByRfc(rfc);
   }
   
   
}
