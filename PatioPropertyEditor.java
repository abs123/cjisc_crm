package com.mx.cji.crm.converter;

import java.beans.PropertyEditorSupport;

import com.mx.cji.crm.models.service.IEmpresaService;

public class PatioPropertyEditor extends PropertyEditorSupport {
	
	 private IEmpresaService empresaService;

	public PatioPropertyEditor(IEmpresaService empresaService) {
		super();
		this.empresaService = empresaService;
	}

	 
	 @Override
	public void setAsText(String  idString) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		 System.out.println("-------obtiene Patio");
		 setValue(this.empresaService.findByIdPatio(Integer.parseInt(idString)));
		 
	}
	 
	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		return super.getAsText();
	}

}
