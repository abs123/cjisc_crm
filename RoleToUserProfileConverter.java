package com.mx.cji.crm.converter;

import java.util.Collection;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.core.convert.converter.Converter;

import com.mx.cji.crm.models.dao.IUserDao;
import com.mx.cji.crm.models.entity.Role;
import com.mx.cji.crm.models.entity.UserRole;
import com.mx.cji.crm.models.entity.Usuario;
 
 

public class RoleToUserProfileConverter extends CustomCollectionEditor  {
	
	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	IUserDao usuarioDao;
	  
	

	@SuppressWarnings("unchecked")
	public RoleToUserProfileConverter(Class<?> collectionType, IUserDao usuarioDao) {
        
        super((Class<? extends Collection>) collectionType);
        this.usuarioDao = usuarioDao;
        logger.info("Entro al validador del los datos");
    }
	
	 
	@Override
    public Object convertElement(Object element) {
		String rolId = (String) element;
        UserRole rol = usuarioDao.findByIdRole(Integer.parseInt(rolId));    
              
        return rol;
	}
	
	
}
