package com.mx.cji.crm.validator;


import org.springframework.validation.Errors;
import com.mx.cji.crm.models.entity.FileInfo;

public class BuscaIdValidator implements  org.springframework.validation.Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return FileInfo.class.equals(clazz);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		FileInfo buscaId= (FileInfo) target;
		
		if(buscaId.getFile() == null || buscaId.getFile().getOriginalFilename().equals("")) {
		 	errors.rejectValue("file", null, "Se requiere adjuntar un archivo del tipo");
		 	
		 return;	
			
		}
		 if(! (buscaId.getFile().getContentType().equals("application/pdf"))){
				errors.rejectValue("file", null, "Se requiere un archivo tipo PDF!!");
				return;	
			}
		
	}

}
