package com.mx.cji.crm.models.service;

import java.util.List;

import com.mx.cji.crm.models.entity.FileInfoDomicilio;

public interface IFileInfoDomicilioService {
	
	public List <FileInfoDomicilio> findAll();
	
	public void  save(FileInfoDomicilio domicilio);
	

}
