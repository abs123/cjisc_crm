package com.mx.cji.crm.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.cji.crm.models.dao.IFielInfoDao;
import com.mx.cji.crm.models.entity.FileInfo;

@Service 
public class FielInfoServiceImpl implements IFielInfoService {
	
	@Autowired	
	IFielInfoDao fielInfoDao;
	
	
	@Override
	public List<FileInfo> findAll() {
		// TODO Auto-generated method stub
		return fielInfoDao.findAll();
	}
	
	@Override
	public FileInfo findById(int id) {
		// TODO Auto-generated method stub
		return fielInfoDao.findById(id);
	}
	
	
	@Override
	public void save(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		
		fielInfoDao.save(fileInfo);
	}
	
	
	@Override
	public void delete(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		
		fielInfoDao.delete(fileInfo);
	}
	

 

}
