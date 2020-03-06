package com.mx.cji.crm.models.dao;

import java.util.List;

import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.util.paginador.PageHibernate;

public interface IEmpresaDao {
		
public List<Empresa>  findAll();  
	
    public Empresa findById(int id);

    public void save(Empresa empresa);
    
    public void delete(Empresa  empresa);

	public List<Empresa> findallEmpresas();
	
	public  PageHibernate findAllPager(String page, int resultsPerPage, String orderBy);	 
	
	public List<Empresa> findByRfc(String rfc);
	 

}
