package com.mx.cji.crm.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mx.cji.crm.models.entity.FileInfoDomicilio;

@Component
public class FileInfoDomicilioDao implements IFileInfoDomicilioDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	public FileInfoDomicilioDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FileInfoDomicilio> findAll() {
		// TODO Auto-generated method stub
		return (List<FileInfoDomicilio>) hibernateTemplate.find("from FileInfoDomicilio");
	}
	
	
	@Override
	public void save(FileInfoDomicilio domicilio) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(domicilio);
	}
	

}
