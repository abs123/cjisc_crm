package com.mx.cji.crm.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.cji.crm.models.entity.FileInfo;
@Repository()
public class FielInfoDao implements IFielInfoDao{
	
	
	@Autowired 
	private HibernateTemplate hibernateTemplate;

	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	 @Override
	public List<FileInfo> findAll() {
		// TODO Auto-generated method stub
		 return (List <FileInfo>) hibernateTemplate.find("from FileInfo f ");
	}
	 
	 
	 
	 @Override
	 @Transactional(readOnly=true)
	public FileInfo findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(FileInfo.class, id);
	}
	 
	 
	 @Override
	public void save(FileInfo fileInfo) {
		// TODO Auto-generated method stub		 
		 hibernateTemplate.saveOrUpdate(fileInfo);
	}
	 
	 @Override
	public void delete(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		 
		 hibernateTemplate.delete(fileInfo);
	}
	
	
	
	

}
