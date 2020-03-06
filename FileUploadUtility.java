package com.mx.cji.crm.upload;



import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.mx.cji.crm.controller.CatalogoController;

 

public class FileUploadUtility {
	protected static final Logger logger = LoggerFactory.getLogger((FileUploadUtility.class));

	 private static final String ABS_PATH="C:\\Spring2019\\crm_cjimx\\src\\main\\webapp\\resources\\static\\uploads\\";
	 
	private static String  REAL_PATH="";
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// TODO Auto-generated method stub
		
		//Get RealPath
		// get the real server path
				 
		REAL_PATH=request.getSession().getServletContext().getRealPath("/resources/static/uploads/");
		logger.info(ABS_PATH );
		
		logger.info(REAL_PATH );
		
		//Valida que los directorios exsitan
		 if(!new File(ABS_PATH).exists()) {
			 new File(ABS_PATH).mkdir();
			 	 
		 }
	    
		 if(!new File(REAL_PATH).exists()) {
			 new File(REAL_PATH).mkdir();
			 	 
		 }
		 try {
			//transfer the file to both the location
				file.transferTo(new File(REAL_PATH + code + ".pdf"));
				file.transferTo(new File(ABS_PATH + code + ".pdf"));
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
	