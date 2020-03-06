package com.mx.cji.crm.controller;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.cji.crm.converter.GrupoPropertyEditor;
import com.mx.cji.crm.converter.LegalPropertyEditor;
import com.mx.cji.crm.converter.PatioPropertyEditor;
import com.mx.cji.crm.converter.RoleToUserProfileConverter;
import com.mx.cji.crm.models.dao.IUserDao;
import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.models.entity.Grupo;
import com.mx.cji.crm.models.entity.Patio;
import com.mx.cji.crm.models.entity.Representante;
import com.mx.cji.crm.models.entity.Role;
import com.mx.cji.crm.models.entity.UserRole;
import com.mx.cji.crm.models.entity.Usuario;
import com.mx.cji.crm.models.service.IEmpresaService;
import com.mx.cji.crm.models.service.IGrupoService;
import com.mx.cji.crm.models.service.IPatioService;
import com.mx.cji.crm.models.service.IRepresentanteService;
import com.mx.cji.crm.util.paginador.Page;
import com.mx.cji.util.paginador.render.PagerRender;
 


/**
 * @author jetcom
 *
 */
@Controller
@RequestMapping("/catalogos")
@SessionAttributes("usuario")


public class CatalogoController {
	protected final Logger logger = LoggerFactory.getLogger(CatalogoController.class);
	@Autowired
	IUserDao usuarioDao;

	@Autowired
	IGrupoService grupoService;

	@Autowired
	IRepresentanteService representanteService;

	@Autowired
	IPatioService patioService;

	@Autowired
	IEmpresaService empresaServicio;

	 
	
	
	private Usuario usuario =null;
	private Role role=null;
	private Grupo grupo=null;
	private Representante representante=null;
	private Patio patio=null;
	private Empresa empresa=null;







	/**
	 * @param binder
	 */
	/**
	 * @param binder
	 */
	@InitBinder  
	public void initBinderGrupo( WebDataBinder  binder) {

		binder.registerCustomEditor(Grupo.class, new GrupoPropertyEditor(empresaServicio));
		binder.registerCustomEditor(Patio.class, new PatioPropertyEditor(empresaServicio));
		binder.registerCustomEditor(Representante.class, new LegalPropertyEditor(empresaServicio) );
		binder.registerCustomEditor(Set.class,
	                new RoleToUserProfileConverter(Set.class, usuarioDao));
		
	}
	 


	// Metodo handler formulario, para listar el usurio
	@RequestMapping(value = "/listaUsuarios", method = RequestMethod.GET)
	@ModelAttribute("usuarios")
	public List<Usuario> viewLista(Map<String, Object> map) throws Exception {
		map.put("titulo", "Listado de usuarios");
		//System.out.println("listado de roles----->" +getRole());
		return usuarioDao.findAll();
	}

	// Metodo handler formulario, para crear al crear el usurio
	@RequestMapping(value = "/addUsuario.htm", method = RequestMethod.GET)
	@ModelAttribute("usuario")
	public Usuario edita(Model model, Map<String, Object> map, @RequestParam(value="id", required = false ,defaultValue="0") int id)throws Exception {
		map.put("titulo", "Agrega Usuario");

		if (id>0) {
			System.out.println("El usuario " +id);
			usuario = usuarioDao.findById(id);
		} else {
			usuario = new Usuario();
		}
				
		model.addAttribute("listRoles",usuarioDao.findAllRol());
		 
		
		return usuario;
	}


	
	@RequestMapping(value = "/addUsuario.htm", method = RequestMethod.POST)
	public String processSubmitUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
			BindingResult result, SessionStatus status,Model model) {
		
		
		    Set<UserRole> rol = new  HashSet <UserRole>();
		              rol = (Set<UserRole>) usuario.getUserProfiles();   
		             
		              usuario.setUserProfiles(rol);
		        
		  
		     
		
		if (result.hasErrors()) {
			model.addAttribute("listRoles",usuarioDao.findAllRol());
			return "catalogos/addUsuario";
		} else {
			usuarioDao.save(usuario);		
			status.setComplete();	 			
			return "redirect:/catalogos/listaUsuarios";
		}
	}





	@RequestMapping(value="/rolUsuario",method=RequestMethod.GET)
	@ModelAttribute("role")
	public List<Role> listRol(Map<String, Object> map,@RequestParam(value = "id", required = false) int id) throws Exception {
		map.put("titulo", "Listado de Rol");
		Usuario u=new Usuario();
		u=usuarioDao.findById(2);
		System.out.println(u.getUsername() );
		 

		return  null;
	}



	/***************************************
	 * CRUD  Modulo GRUPOS 
	 *****************************************/
	@RequestMapping(value="/listaGrupo",method=RequestMethod.GET)
	@ModelAttribute("grupos")
	public List<Grupo>listaGrupo( Model model,@RequestParam(name="success",required=false)String success) throws Exception{
		model.addAttribute("titulo", "Listado de Grupos");	
		
	   if(success!=null) {	
		if(success.equals("1")){
			
			model.addAttribute("error", "El Registro ya Esta Asignado,No Se Puede Eliminar!");
		}else {
			model.addAttribute("error", "Registro Eliminado!!");
		}
			
	   }	
		success="";
		return grupoService.findAll();
	}


	@RequestMapping(value ="/addGrupo.htm", method = RequestMethod.GET)
	@ModelAttribute("grupo")
	public Grupo setupForm(Model model,@RequestParam(value = "id", required = false, defaultValue = "0") int id) throws Exception{

		model.addAttribute("titulo", "Crear un Grupo");
		grupo = null;

		if (id > 0) {
			grupo = grupoService.findById(id);
			System.out.println("Se edita ------->");
		} else {
			grupo = new Grupo();
		}

		return grupo;
	}


	@RequestMapping(value = "/addGrupo.htm", method = RequestMethod.POST)
	public String processSubmit(@Valid Grupo grupo,
			BindingResult result, SessionStatus status) {

		String username = getPrincipal();

		Usuario u = usuarioDao.findByUsername(username);
		grupo.setUser_id(u.getId());
	        System.out.println("CREATE AT"+ grupo.getCreat_At());

		if (result.hasErrors()) {
			return "catalogos/addGrupo";
		} else {
			System.out.println("Se modifica ------->"+status);
			grupoService.save(grupo);
			status.setComplete();
			return "redirect:/catalogos/listaGrupo";
		}
	}


	@RequestMapping(value = "/eliminar.htm", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") int id) throws Exception{
		grupo = grupoService.findById(id);
       
		
		if (null != grupo) {
			
			
		 try {
			 grupoService.delete(grupo);
				System.out.println("Se elimina el id------>"+id);
		} catch (Exception e) {
			// TODO: handle exception
			
			return "redirect:/catalogos/listaGrupo?success=1";
			 
		}	
			
		}
		return "redirect:/catalogos/listaGrupo";
	}


	/* ************************************************************
	 *		CRUD		 Modulo Representantes
	 ************************************************************/

	@RequestMapping(value="/listaRepresentante",method=RequestMethod.GET)	  
	@ModelAttribute("representantes")
	public List<Representante> listRepresentante (Model model) throws Exception {
		model.addAttribute("titulo","Lista Repr. Legal");
  
		return representanteService.findAll(); 
	}


	@RequestMapping(value="/addRepresentante.htm" ,method=RequestMethod.GET)
	@ModelAttribute("representante")
	public Representante formAgrega( Model model, @RequestParam(value="id",required=false,defaultValue="0")int id) {
		model.addAttribute("titulo", "Agregar Representante");
		representante=null;
		if(id>0) {
			representante= representanteService.findById(id);
		}else {
			representante = new Representante();
		}

		return representante;   
	}


	@RequestMapping(value="/addRepresentante.htm" ,method=RequestMethod.POST)
	public String processSubmit(@Valid @ModelAttribute("representante") Representante representante,BindingResult result, 
		 RedirectAttributes flash,	SessionStatus status,Model model,  HttpServletRequest request )  {
		String username = getPrincipal();
		Usuario u = usuarioDao.findByUsername(username);
		representante.setUser_id(u.getId());
		
		/*if (representante.getId()==0) {
			new RepresentanteValidator().validate(representante, result);
			
		}else {
			new RepresentanteValidator().validate(representante, result);
		}
		*/
					 
		if (result.hasErrors()) {
            model.addAttribute("message"," El representante no se registro !!");
			return "catalogos/addRepresentante";
		}else {
						
						
			/*if(!representante.getFile().getOriginalFilename().equals("")) {
				System.out.println("Vamos por el file---->");
				FileUploadUtility.uploadFile(request,representante.getFile(),representante.getRfc());			
			}*/
			representanteService.save(representante);
			 model.addAttribute("message", "El representante se registro existosamente !!");
			
            //			return "catalogos/addRepresentante" ;
			return "redirect:listaRepresentante";
		}	   
	}

	/* ************************************************************
	 *		Elimina Patios
	 ************************************************************/
	
	@RequestMapping(value="/eliminar",method=RequestMethod.GET)
	public String deleteRepresentante(@RequestParam("id") int id ) {
		representante = representanteService.findById(id);
		if(null!=representante) {
			representanteService.delete(representante);
 
		} 
		return "redirect:listaRepresentante";


	}


	/* ************************************************************
	 *		CRUD		 Modulo Patios
	 ************************************************************/

	@RequestMapping(value="/listaPatio",method=RequestMethod.GET)	   
	public String listaPatios(Model model) throws Exception {
		model.addAttribute("titulo","Listado de Patios.");
		model.addAttribute("patios", this.patioService.findAll());
		System.out.println("lista patios----->");
		return  "catalogos/listaPatio"; 
	}


	@RequestMapping(value="/addPatio.htm" ,method=RequestMethod.GET)
	@ModelAttribute("patio")
	public Patio formAgregaPatio( Model model, @RequestParam(value="id",required=false,defaultValue="0")int id) {
		model.addAttribute("titulo", "Agregar Patio");
		patio=null;
		if(id>0) {
			patio= patioService.findById(id);
		}else {
			patio = new Patio();
		}

		return patio;   
	}



	@RequestMapping(value = "/addPatio.htm", method = RequestMethod.POST)
	public String submit(@Valid Patio patio,
			BindingResult result, SessionStatus status) {
		String username = getPrincipal();
		Usuario u = usuarioDao.findByUsername(username);
		patio.setUser_Id(u.getId());

		if (result.hasErrors()) {
			return "catalogos/addPatio";
		} else {
			System.out.println("Se modifica ------->"+status);
			patioService.save(patio);
			status.setComplete();
			return "redirect:/catalogos/listaPatio";
		}
	}


	@RequestMapping(value = "/eliminaPatio.htm", method = RequestMethod.GET)
	public String eliminaPatio(@RequestParam("id") int id) {
		patio = patioService.findById(id);
		if (null != patio) {
			patioService.delete(patio);
			System.out.println("Se elimina el PATIO------>"+id);
		}

		return "redirect:/catalogos/listaPatio";
	}



	/*********************************************************
	 * 	CRUD		 Modulo Empresa
	 * ********************************************************/

	@RequestMapping(value="/listaEmpresa",method=RequestMethod.GET)
	@ModelAttribute("empresas")
	public ModelMap  listaEmpresa(@RequestParam (value="page",required=false)String page , Model model,HttpServletRequest request) throws Exception {
		
		
		Page pager = empresaServicio.findAllPager(page, 10, "");
		PagerRender pagerRender = pager.getRender("Bootstrap");
		pagerRender.setRequestUri(request.getContextPath()+"/catalogos/listaEmpresa");
		pagerRender.render();
		
		
		model.addAttribute("empresas", pager.getResults());
		model.addAttribute("pager", pagerRender.getOutput());
		model.addAttribute("titulo","Lista de Empresas");
		
		return  (ModelMap) model;
	}



	@RequestMapping(value ="/addEmpresa.htm", method = RequestMethod.GET)

	public String formEmpresa(Model model,@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		model.addAttribute("titulo", "Crear Empresas");
		empresa=null;	     

		empresa =empresaServicio.findById(id);

		if (id > 0) {
			model.addAttribute("empresa",empresa); 
		} else {
			empresa = new Empresa();
		}

		model.addAttribute("grupos_",empresaServicio.findAllGrupo()) ;
		model.addAttribute("patios_",empresaServicio.findAllPatio());
		model.addAttribute("legal_",empresaServicio.findAllLegal()); 
		model.addAttribute("empresa",empresa); 

		return "catalogos/addEmpresa";
	}


	@RequestMapping(value = "/addEmpresa.htm", method = RequestMethod.POST)
	public String submitEmpresa(Model model, @Valid @ModelAttribute("empresa") 
	Empresa empresa,BindingResult result, SessionStatus status ,HttpServletRequest request){
		
	    //se valida rfc empresa
	     List<Empresa> emp=	empresaServicio.findByRfc(empresa.getRfc());
	     Empresa empCode=null;
	        
	     if (emp.size()>0) {
	        	  empCode= emp.get(0);
			}
	       
	     
		

		//obtiene usuario
		String username = getPrincipal();
		Usuario u = usuarioDao.findByUsername(username);
		empresa.setUserId(u.getId());

		if (result.hasErrors()) {
			model.addAttribute("grupos_",empresaServicio.findAllGrupo());
			model.addAttribute("patios_",empresaServicio.findAllPatio());
			model.addAttribute("legal_",empresaServicio.findAllLegal());

			return "catalogos/addEmpresa";

		} else {
		   
			if (empresa.getId()>0) {
				 empresa.setCode(empCode.getCode());
				 empresaServicio.save(empresa);
				 status.setComplete();
				 return "redirect:/catalogos/listaEmpresa";
				 
			} else {
				 
				if (emp.size()>0) {
					 model.addAttribute("message", "La Empresa Ya Se Encuentra Registrada!!");	
					
			   }else {
				   empresa.setCode(""); 
				    empresa.setExisteFile("0");
					 empresaServicio.save(empresa);
					 status.setComplete();
					 return "redirect:/catalogos/listaEmpresa";
				   
			   }
			}
			
		} 
		 return "catalogos/addEmpresa";
		} 
	


	@RequestMapping(value = "/deleteEmpresa.htm", method = RequestMethod.GET)
	public String deleteEmpresa(@RequestParam("id") int id) {
		empresa = empresaServicio.findById(id);

		if (null != empresa) {
			empresaServicio.delete(empresa);
		}
		return "redirect:/catalogos/listaEmpresa";
	}





	/************************************************************
	 * This method returns the principal[user-name] of logged-in user.
	 ******************************************************************/





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

	/*@SuppressWarnings("unchecked")
	private List<Role> getRole() {
		usuario= usuarioDao.findById(1);
		Role rol = (Role) usuario.getUserProfiles();
		
		
		
		System.out.println("Los roles ---------------->"+usuario.getId());
		return (List<Role>) rol;
	}*/

	 
	public  Map<String,String> cargaRoles () {

		Map<String,String> llenaRoles = new LinkedHashMap<String,String>();
		llenaRoles.put("1", "Administrador");
		llenaRoles.put("2", "Usuario");
		llenaRoles.put("3", "Operador"); 

		return llenaRoles;	
	}


}
