package com.mx.cji.crm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mx.cji.crm.models.entity.Representante;
 
public class RepresentanteValidator implements Validator {
	

	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	 
	@Override
	 public void validate(Object target,Errors errors) {
		// TODO Auto-generated method stub
		 Representante representante = (Representante) target;
		 
	  //  String name=	 representante.getFile().getContentType();
		 		 
		 
		 if (representante.getFile()==null || representante.getFile().getOriginalFilename().equals("")) {
			 errors.reject("file", null, "Requiere seleccionar un archivo!");
			return;
		}
		 
		 
		 
		 if(! (representante.getFile().getContentType().equals("application/pdf"))){
				errors.rejectValue("file", null, "Se requiere un archivo tipo PDF!!");
				return;	
			}
			
		 
		 
		
	}
	 
}
