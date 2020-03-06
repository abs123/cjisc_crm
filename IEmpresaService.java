package com.mx.cji.crm.models.service;

import java.util.List;


import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.models.entity.Grupo;
import com.mx.cji.crm.models.entity.Patio;
import com.mx.cji.crm.models.entity.Representante;
import com.mx.cji.crm.util.paginador.PageHibernate;;

public interface IEmpresaService {
	
	
	 public List<Empresa> findAll();
	 
	 public Empresa findById(int id);
	 
	 public void save(Empresa empresa);
	 
	 public void delete(Empresa  empresa);
	 
	 
	 public List<Grupo> findAllGrupo();
	 public Grupo findByIdGrupo(int id);
	 
	 
	 public List<Representante> findAllLegal();
     public Representante findByIdLegal(int id);
     
     public List<Patio> findAllPatio();
     public Patio findByIdPatio(int id);
     
      public List<Empresa> findallEmpresa();	 
     	 
      public  PageHibernate findAllPager(String page, int resultsPerPage, String orderBy);	 
	 
	  public List<Empresa> findByRfc(String rfc);

}
