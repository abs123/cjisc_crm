package com.mx.cji.crm.models.dao;

import java.util.List;

import com.mx.cji.crm.models.entity.FileInfoDomicilio;

public interface IFileInfoDomicilioDao   {

	
	public List <FileInfoDomicilio> findAll();
	
	public void  save(FileInfoDomicilio domicilio);
}
