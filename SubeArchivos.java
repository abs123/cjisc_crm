package com.mx.cji.crm.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mx.cji.crm.models.dao.IFileInfoDomicilioDao;
import com.mx.cji.crm.models.dao.IUserDao;
import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.models.entity.FileInfo;
import com.mx.cji.crm.models.entity.FileInfoDomicilio;
import com.mx.cji.crm.models.entity.Usuario;
import com.mx.cji.crm.models.service.IEmpresaService;
import com.mx.cji.crm.models.service.IFielInfoService;
import com.mx.cji.crm.models.service.IFileInfoDomicilioService;

 

 
@Controller
@RequestMapping(value="/files")
public class SubeArchivos{
	private static final Logger logger = LoggerFactory.getLogger(SubeArchivos.class);
	 
 
	
 @Autowired
 IEmpresaService empresa;
 
 @Autowired
 IFielInfoService fielInfo;
 
 @Autowired
 IUserDao usuarioDao;
 
 @Autowired
 //IFileInfoDomicilioDao iFileInfoDomicilioDao;
 
 
  
 
 
 private File dir=null;

 
	@RequestMapping(method=RequestMethod.GET)   
	public String getEmpresas( Model  model, FileInfo info) {
    	model.addAttribute("empresas", empresa.findAll());        
		model.addAttribute("fileInfo", new FileInfo());
    	model.addAttribute("csd", true);		
    	model.addAttribute("titulo1", "Archivos Tipo CSD- Certificado Sellos Digitales");
    	
	return "pagefiles";	
	}
	
	// Carga Archivos Tipo CSD
	
	@RequestMapping(value = "/tipocsd", method = RequestMethod.POST)
	public ModelAndView   uploadMultipleFile( @ModelAttribute("fileInfo") FileInfo fileInfo,
			@RequestParam("file") List < MultipartFile > files,Model model) throws IOException {

		 List < FileInfo > uploadedFiles = new ArrayList < FileInfo > ();
		 String Ncarpea ="SELLOS DIGITAL";
		 String msg=null;
		
	        if (!files.isEmpty()) {
	        	//obtiene empresa
	         
				Empresa emp= empresa.findById(fileInfo.getEmpresa_id());
	   			String rfc=emp.getRfc();
	   		    Date fechainicio=null; 
	   		    Date fechafin=null;
	   		    
	   			String username = getPrincipal();
	   			Usuario u = usuarioDao.findByUsername(username);
	        
		        for (MultipartFile file : files) {				
				  String nameFile=	  file.getOriginalFilename();
				  			  
				  try {    	
			   		  			        	 
			   			String rootPath = System.getProperty("catalina.home");
						dir = new File(rootPath + File.separator + Ncarpea + File.separator + rfc);
			   			
			   			if(!dir.isDirectory()) {
			   				dir.mkdir();
			   				
			   			}
			   			//envia documento a la ruta del servidor
			   			File serverFile = new File(dir.getAbsolutePath() + File.separator + nameFile);
			   			
			   		   file.transferTo(serverFile);		
			   			
			   		 	if(serverFile.exists() && nameFile.endsWith(".cer")) {
			   				InputStream is = new FileInputStream(serverFile);
							  CertificateFactory cf = CertificateFactory.getInstance("X.509");
									  X509Certificate certificado=(X509Certificate)cf.generateCertificate(is);

									   byte[] byteArray= certificado.getSerialNumber().toByteArray(); //obtengo no. de serie
									//  String Noserie = new String(byteArray)

									    fechainicio=certificado.getNotBefore(); //obtengo fecha de inicio
									    fechafin=certificado.getNotAfter() ;//obtengo fecha de fin
							  					  
			   		 	}
						   
			   		   			
			   		  	    
			   		 FileInfo datosArchivos = new FileInfo();
			   		    
			   		 datosArchivos.setEmpresa_id(fileInfo.getEmpresa_id());
			   		 datosArchivos.setNombre(nameFile); //nombre archivo
			   		 datosArchivos.setRuta(rootPath); //ruta archivo
			   		 datosArchivos.setUsuario_id(u.getId()); //usuario
			   		 datosArchivos.setCodigo("CSD");// opcion 
			   		 datosArchivos.setFechaInicial(fechainicio);
			   		 datosArchivos.setFechaFinal(fechafin);
			   		 datosArchivos.setNombreEmpresa(emp.getNombre());   
			   		   
			   		 uploadedFiles.add(datosArchivos);
			   		
			   		    
			   		    
			   		   // System.out.println("datos del los archivos ------->"+ f.getEmpresa_id()+" --> " + f.getNombre()+"-->"+f.getRuta()+"-->"+f.getUsuario_id()+"-->"+" -->"+f.getFechaVencimiento());
			   		    
			   		  //  fielInfo.save(datosArchivos);
				       
			   		  
			            	  		       		  
		            } catch (Exception e) {
		                System.out.println(e.getMessage());
		                
		                msg="Se presento algun problema en el procesos !";
		            }
				    
		 
		           }//for
		          		          
	         }
		   
	        
	        ModelAndView modelAndView = new ModelAndView("/upload/success-csd");
	        modelAndView.addObject("info", uploadedFiles);
	        modelAndView.addObject("success", msg);
	        return modelAndView;
       }
	

	/************************************************************
	 ************************************************************
	  Carga Archivos Tipo FIEL
		
	*************************************************************/
	
	
	@RequestMapping(value="/listEmp",method=RequestMethod.GET)   
	public String getListEmpresas( Model  model, FileInfo info) {
    	model.addAttribute("listaEmpresas", empresa.findAll()); 		 	 
		model.addAttribute("fileInfo", new FileInfo());	 
    	model.addAttribute("fiel", true);		
    	model.addAttribute("titulo2", "Archivos Tipo FIEL- Firma Electrónica");
    	
	return "pagefiles";	
	}
	
	
	
	
	  @RequestMapping(value="/tipoFiel",method=RequestMethod.POST)
	  public ModelAndView UploadFiel(@ModelAttribute("fielInfo") FileInfo fileInfo,@RequestParam("file") List <MultipartFile> filesFiel,Model m) throws Exception{
		  
		List <FileInfo> listFilesFiel = new ArrayList<FileInfo>();
		 String Ncarpea ="FIRMA DIGITAL";
		  
		  
		  if(!filesFiel.isEmpty()) {
				Empresa emp= empresa.findById(fileInfo.getEmpresa_id());
	   			String rfc=emp.getRfc();
	   		    Date fechainicio=null; 
	   		    Date fechafin=null;
	   		    
	   			String username = getPrincipal();
	   			Usuario u = usuarioDao.findByUsername(username);
	        
	   			for (MultipartFile multipartFile : filesFiel) {
	   				
	   				String nameFiles = multipartFile.getOriginalFilename();
	   				
	   				try {
						
	   					//String rootPath = System.getProperty("catalina.home");
	   					String rootPath = System.getProperty("java.io.tmpdir");
	   					dir = new File(rootPath + File.separator + Ncarpea + File.separator + rfc);
	   				   

			   			if(!dir.isDirectory()) {
			   				dir.mkdir();
			   			  logger.info("La ruta No existe , Fue creada !");	
			   			}
			   			
			   		//envia documento a la ruta del servidor
			   			File serverFile = new File(dir.getAbsolutePath() + File.separator + nameFiles);
			   			multipartFile.transferTo(serverFile);		
	   					 
			   			if(serverFile.exists() && nameFiles.endsWith(".cer")) {
			   				InputStream is = new FileInputStream(serverFile);
							  CertificateFactory cf = CertificateFactory.getInstance("X.509");
									  X509Certificate certificado=(X509Certificate)cf.generateCertificate(is);

									   byte[] byteArray= certificado.getSerialNumber().toByteArray(); //obtengo no. de serie
									   String Noserie = new String(byteArray);
                                       System.out.println("Serie-- "+ Noserie );
									    fechainicio=certificado.getNotBefore(); //obtengo fecha de inicio
									    fechafin=certificado.getNotAfter() ;//obtengo fecha de fin
							  					  
			   		 	}
			   			
			   		 FileInfo datosArchivosFiel = new FileInfo();
			   		    
			   		datosArchivosFiel.setEmpresa_id(fileInfo.getEmpresa_id());
			   		datosArchivosFiel.setNombre(nameFiles); //nombre archivo
			   		datosArchivosFiel.setRuta(rootPath); //ruta archivo
			   		datosArchivosFiel.setUsuario_id(u.getId()); //usuario
			   		datosArchivosFiel.setCodigo("FIEL");// opcion 
			   		datosArchivosFiel.setFechaInicial(fechainicio);
			   		datosArchivosFiel.setFechaFinal(fechafin);
			   		datosArchivosFiel.setNombreEmpresa(emp.getNombre());   
			   		   
			   		listFilesFiel.add(datosArchivosFiel);
			   		
			   			
			   	   fielInfo.save(datosArchivosFiel);	
	   					
					} catch (Exception e) {
						// TODO: handle exception
						 System.out.println(e.getMessage());
					}
					
				}//for
			  			  
			  
		  }		
		
		
		
		
		  
		 ModelAndView modelAndView = new ModelAndView("/upload/success-fiel");
		 modelAndView.addObject("fileFile", listFilesFiel);
	  return modelAndView;  
		  
	  }
	 
	  
	  
	  /************************************************************
		 ************************************************************
		  Carga Archivos Tipo Comprobante de Domicilio
			
		*************************************************************/
	  
	  @RequestMapping(value="/listasEmp",method=RequestMethod.GET)   
		public String handlerEmpresa( Model  model, FileInfo info) {
	    	model.addAttribute("emp", empresa.findAll()); 		 	 
			model.addAttribute("fileInfo", new FileInfo());	 
	    	model.addAttribute("domicilio", true);		
	    	model.addAttribute("titulo3", "Archivos Tipo  - Comprobante de Domicilio");
	    	
		return "pagefiles";	
		}
		
	  
	
	
	
	  @RequestMapping(value="/tipoDomicilio",method=RequestMethod.POST)
	  public ModelAndView UploadDomicilio(@ModelAttribute("fielInfo") FileInfoDomicilio FileInfoDomicilio,@RequestParam("file")  MultipartFile filesDomicilio,Model m) throws Exception{
		  
	 	List <FileInfoDomicilio> listFilesDomicilio = new ArrayList<FileInfoDomicilio>();
		 String Ncarpea ="C_DOMICILIO";
		  
		  
		  if(!filesDomicilio.isEmpty()) {
				Empresa emp= empresa.findById(FileInfoDomicilio.getEmpresa_id());
	   			String rfc=emp.getRfc();
	   		 
	   		    
	   			String username = getPrincipal();
	   			Usuario u = usuarioDao.findByUsername(username);
	        
	   			//for (MultipartFile files : filesDomicilio) {
	   				
	   				String nameFiles = filesDomicilio.getOriginalFilename();
	   			 
	   					//String rootPath = System.getProperty("catalina.home");
	   					String rootPath = System.getProperty("java.io.tmpdir");
	   					dir = new File(rootPath + File.separator + Ncarpea + File.separator + rfc);
	   				   

			   			if(!dir.isDirectory()) {
			   				dir.mkdir();
			   			  logger.info("La ruta No existe , Fue creada !");	
			   			}
			   			
			   		//envia documento a la ruta del servidor
			   			File serverFile = new File(dir.getAbsolutePath() + File.separator + nameFiles);
			   			filesDomicilio.transferTo(serverFile);		
	   					 
			   			  					  
			   		 
			   		 FileInfoDomicilio  archivosDomicilio = new FileInfoDomicilio();
			   		    
			   		archivosDomicilio.setEmpresa_id(FileInfoDomicilio.getEmpresa_id());
			   		archivosDomicilio.setRuta(rootPath); //ruta archivo
			   		archivosDomicilio.setCodigo("CDOMICILIO");// opcion 			   		
			   		archivosDomicilio.setNombreEmpresa(emp.getNombre());
			   		archivosDomicilio.setNombre(nameFiles);
			   		
			   
			   		//agrega un objeto
			   		listFilesDomicilio.add(archivosDomicilio);
			   	    
			   		
			   		 
			   	  // domicilioService.save(archivosDomicilio);	
			   		
			   		
	   					
					 
					
			 
			  
			  		  
		  }	 
		  
		 ModelAndView modelAndView = new ModelAndView("/upload/success-domicilio");
		 modelAndView.addObject("listFilesDomicilio", listFilesDomicilio);
	  return modelAndView;  
		  
	  }
	  
	  
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();

		}
		return userName;
	}
	
	  
}



