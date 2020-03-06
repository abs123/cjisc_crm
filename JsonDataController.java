package com.mx.cji.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.cji.crm.models.dao.IFileInfoDomicilioDao;
import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.models.entity.FileInfoDomicilio;
import com.mx.cji.crm.models.service.IEmpresaService;



@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private IEmpresaService empresaServicio;
	 
	

	@RequestMapping("/all/empresas")
	@ResponseBody
	public List<Empresa> getAllProductsList() {		
		return empresaServicio.findallEmpresa();
				
	}	
	
	
	 @Autowired
	 private IFileInfoDomicilioDao iFileInfoDomicilioDao;
	 
  
	 public List<FileInfoDomicilio> obtieneEmpresas() {
		return  iFileInfoDomicilioDao.findAll();
	}


}
