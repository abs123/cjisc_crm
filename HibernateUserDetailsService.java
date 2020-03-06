package com.mx.cji.crm.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.cji.crm.models.dao.IUserDao;
import com.mx.cji.crm.models.entity.Role;
import com.mx.cji.crm.models.entity.UserRole;
import com.mx.cji.crm.models.entity.Usuario;
 
@Service("hibernateUserDetailsService")
public class HibernateUserDetailsService implements UserDetailsService{

	protected final Logger logger = LoggerFactory.getLogger(HibernateUserDetailsService.class);
	
	@Autowired
	private IUserDao usuarioDao;
	
	
	
	 
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   
		Usuario usuario = usuarioDao.findByUsername(username);

		if (usuario == null) {
			logger.error("Error login: No se encuentra el usuario con '" + username + "'");
			throw new UsernameNotFoundException("Username " + username + " no encontrado");
		}
		
		logger.info("Username: " + usuario.getUsername());
		logger.info("Num. Roles: " + usuario.getUserProfiles().size());

		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>();
		
		for (UserRole role : usuario.getUserProfiles()) {
		 	logger.info("Role: " + role.getTipo());
		 	dbAuths.add(new SimpleGrantedAuthority("ROLE_"+role.getTipo()));
		 }
		
		if (dbAuths.size() == 0) {
			logger.error("Usuario '" + username
					+ "' no tiene roles asignados y será tratado como 'no encontrado'");
			throw new UsernameNotFoundException("Usuario ' " + username + " no tiene roles asignados");
		}
		
		return new User(username, usuario.getPassword(), usuario.getEnabled(), true, true, true, dbAuths);
	}
	@Transactional()
 	public void saveUser(Usuario user) {
		usuarioDao.save(user);
		
	}
	
	
	@Transactional()
 	public void saveRole(UserRole role) {
		usuarioDao.saveRole(role);
		
	}
	
	
	

}
