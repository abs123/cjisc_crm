package com.mx.cji.crm.converter;

import java.beans.PropertyEditorSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import com.mx.cji.crm.models.service.IEmpresaService;

public class EmpresaPropertyEditor extends PropertyEditorSupport {
	private static  final Logger logger = LoggerFactory.getLogger((EmpresaPropertyEditor.class));
	
	
	IEmpresaService iempresaService;
	
	public EmpresaPropertyEditor(IEmpresaService service) {
		// TODO Auto-generated constructor stub
		
		super();
		this.iempresaService=service;
		
	}
	
	
	public void setAsText(String str)throws IllegalArgumentException{
		
		logger.info("valor del dato------>" + str);
		setValue(iempresaService.findByIdGrupo(Integer.parseInt(str)));
	}
	
	

}
