package com.mx.cji.crm.converter;

import java.beans.PropertyEditorSupport;

import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.models.entity.Grupo;
import com.mx.cji.crm.models.service.IEmpresaService;

public class GrupoPropertyEditor extends PropertyEditorSupport {
	
	IEmpresaService iempresaService;

	public GrupoPropertyEditor(IEmpresaService iempresaService) {
		super();
		this.iempresaService = iempresaService;
	}
	
	
	public void setAsText(String idStr) throws IllegalArgumentException  {
	   		setValue(iempresaService.findByIdGrupo(Integer.parseInt(idStr)));
		 	
	}


	
	
	

}
