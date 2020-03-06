package com.mx.cji.crm.converter;

import java.beans.PropertyEditorSupport;

import com.mx.cji.crm.models.service.IEmpresaService;

public class LegalPropertyEditor  extends PropertyEditorSupport{

	private IEmpresaService iempresaService;

	public LegalPropertyEditor(IEmpresaService iempresaService) {
		super();
		this.iempresaService = iempresaService;
	}
	
	
	public void setAsText(String idStr) throws IllegalArgumentException  {
	    System.out.println("Obtienen representante ------------>");
		setValue(iempresaService.findByIdLegal(Integer.parseInt(idStr)));
		 	
	}


	
	
	
}
