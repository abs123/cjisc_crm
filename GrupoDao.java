package com.mx.cji.crm.models.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.cji.crm.models.entity.Grupo;

@Repository
public class GrupoDao implements IGrupoDao {
	
	@Autowired 
	private HibernateTemplate hibernateTemplate;
	
  
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	 	public List<Grupo> findAll() {
		// TODO Auto-generated method stub
		return (List<Grupo>) hibernateTemplate.find("from Grupo g order by g.nombre asc");
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Grupo findById(int id) {
		// TODO Auto-generated method stub		
		return hibernateTemplate.get(Grupo.class, id);
	}

	
	
	
	@Override
	@Transactional
	public void save(Grupo grupo) {
		// TODO Auto-generated method stub
		System.out.println("Se inserto el registro" + grupo.getId()+" - "+grupo.getNombre()+" - "+grupo.getUser_id() +" - "+grupo.getCreat_At());
		hibernateTemplate.saveOrUpdate(grupo);
			}
	 
	@Override
	@Transactional
	public void delete(Grupo grupo) {
		// TODO Auto-generated method stub
		System.out.println("Nombre a eliminar ------->"+grupo.getNombre() +"  "+ grupo.getId());
		hibernateTemplate.delete(grupo);
	}
	
	
}
