package com.mx.cji.crm.models.dao;

import java.util.List;

import com.mx.cji.crm.models.entity.FileInfo;

public interface IFielInfoDao {
	
	
	
List <FileInfo> findAll();
	
	FileInfo findById(int id);
	
	public void save(FileInfo fileInfo);
	
	public void delete(FileInfo fileInfo);

}
