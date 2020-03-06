/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.cji.crm.models.dao;

import java.util.List;

import com.mx.cji.crm.models.entity.Role;
import com.mx.cji.crm.models.entity.UserRole;
import com.mx.cji.crm.models.entity.Usuario;


/**
 *
 * @author Andres Guzman F
 */
public interface IUserDao {
    
	public Usuario findByUsername(String username);
	
	public List<Usuario> findAll();

    public Usuario findById(Integer id);

    public void save(Usuario user);

    public void delete(Usuario user);
    
    public List<UserRole> findAllRol();
    
    
    public UserRole findByIdRole(Integer id);

	public void saveRole(UserRole role);

}

