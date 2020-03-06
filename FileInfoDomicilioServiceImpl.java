package com.mx.cji.crm.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mx.cji.crm.models.dao.IFileInfoDomicilioDao;
import com.mx.cji.crm.models.entity.FileInfoDomicilio;

public class FileInfoDomicilioServiceImpl implements IFileInfoDomicilioService {
	
	
	@Autowired
	IFileInfoDomicilioDao dao;

	public FileInfoDomicilioServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public List<FileInfoDomicilio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(FileInfoDomicilio domicilio) {
		// TODO Auto-generated method stub
		
	}
	
}
