package com.mx.cji.crm.models.dao;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.mx.cji.crm.models.entity.UserRole;
import com.mx.cji.crm.models.entity.Usuario;

@Repository
public class UsuarioDaoHibernateTemplate implements IUserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByUsername(String username) {
		
		List<Usuario> results = (List<Usuario>) hibernateTemplate.findByNamedParam("from   Usuario u where u.username = :username", "username", username);
		System.out.println("estoy UsuarioDaoHibernateTemplate xxxxxxxxxxxxxxxxxxxxxxxxxx" );
		if (results.size() == 1) {
			return results.get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) hibernateTemplate.find("from Usuario u order by u.username asc ");
	}

	@Override
	public Usuario findById(Integer id) {
		return   hibernateTemplate.get(Usuario.class, id);
	}

	@Override
	public void save(Usuario user) {
		hibernateTemplate.saveOrUpdate(user);
	}

	@Override
	public void delete(Usuario user) {
		hibernateTemplate.delete(user);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> findAllRol() {
		return (List<UserRole>) hibernateTemplate.find("from UserRole");
		
		
	}
	
	 @Override
	public UserRole findByIdRole(Integer id) {
		// TODO Auto-generated method stub
		return  hibernateTemplate.get(UserRole.class, id);
	}

	public void saveRole(UserRole role) {
		hibernateTemplate.save(role);
		
	} 
	 
}
