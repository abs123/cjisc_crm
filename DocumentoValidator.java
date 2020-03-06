package com.mx.cji.crm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import com.mx.cji.crm.models.entity.Empresa;

 

public class DocumentoValidator  implements Validator{

	
	public boolean supports(Class<?> clazz) {
		return Empresa.class.equals(clazz);
	}

 
	public void validate(Object target, Errors errors) {
			
		Empresa empresa = (Empresa) target;
		
		if (empresa.getFile()==null || empresa.getFile().getOriginalFilename().equals("")) {
			 errors.rejectValue("file", null, "Requiere seleccionar un archivo!");
			return;
		}
	
		
		
		
		if(! (empresa.getFile().getContentType().equals("application/pdf"))){
		    	errors.rejectValue("file", null, "Se requiere un archivo tipo PDF!!");
				return;	
			}
		 

	
		 
	
	}

	
}
