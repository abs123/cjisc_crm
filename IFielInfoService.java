package com.mx.cji.crm.models.service;

import java.util.List;

import com.mx.cji.crm.models.entity.FileInfo;

public interface IFielInfoService {
	
	
	
	List <FileInfo> findAll();
	
	FileInfo findById(int id);
	
	public void save(FileInfo fileInfo);
	
	public void delete(FileInfo fileInfo);

}
