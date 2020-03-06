package com.mx.cji.crm.converter;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.Collection;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import com.mx.cji.crm.models.dao.IUserDao;
import com.mx.cji.crm.models.entity.Role;
import com.mx.cji.crm.models.entity.Usuario;
import com.mx.cji.crm.models.service.IEmpresaService;

public class UsuarioPropertyEditor extends PropertyEditorSupport {

	 private IUserDao usuarioDao ;

	 
	 public UsuarioPropertyEditor(IUserDao usuarioDao) {
			super();
			this.usuarioDao = usuarioDao;
		}

		 
		 @Override
		public void setAsText(String idString) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			 System.out.println("-------obtiene role" +getAsText());
			 setValue(this.usuarioDao.findByIdRole((Integer.parseInt(idString))));
			 
		}
		 
		@Override
		public String getAsText() {
			// TODO Auto-generated method stub
			return super.getAsText();
		}
	 
}
