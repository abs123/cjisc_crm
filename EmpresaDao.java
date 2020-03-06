package com.mx.cji.crm.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.util.paginador.PageHibernate;

@Repository
public class EmpresaDao implements IEmpresaDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	 

	@SuppressWarnings("unchecked")
	@Override
	 
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		 return (List<Empresa>) hibernateTemplate.find("from Empresa e order by e.nombre asc ");
	}

	@Override
	 
	public Empresa findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Empresa.class, id);
	}

	@Override
 
	public void save(Empresa empresa) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(empresa);
	}

	@Override
	 
	public void delete(Empresa empresa) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(empresa);
	}
	
 
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> findallEmpresas(){
		
 
		return  (List<Empresa>) hibernateTemplate.find("select e.id,e.code,e.nombre,e.rfc, grupo.nombre,"
				+ "e.estatus,e.id from Empresa e "); 
		
	}
	
	
	public PageHibernate findAllPager(String page, int resultsPerPage, String orderBy){
	    PageHibernate paginador = new PageHibernate("from Empresa order by id asc", page, resultsPerPage);

	    hibernateTemplate.execute(paginador);

	    List<?> count = hibernateTemplate.find("SELECT count(*) from Empresa");

	    paginador.setTotalCount(Integer.parseInt(count.get(0).toString()));
	   
	    return paginador;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Empresa> findByRfc(String rfc) {
		
		return  (List<Empresa>)  hibernateTemplate.findByNamedParam("from Empresa e where e.rfc =:rfc" , "rfc",rfc);
		
		   
	}

}
