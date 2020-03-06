package com.mx.cji.crm.controller;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mx.cji.crm.models.entity.Empresa;
import com.mx.cji.crm.models.service.IEmpresaService;
import com.mx.cji.crm.upload.FileUploadUtility;
import com.mx.cji.crm.validator.DocumentoValidator;
 


 
@Controller
@RequestMapping("/manage")
@SessionAttributes("empresa")
public class ConsultaController {
	 private String code ="";
	
	@Autowired
	IEmpresaService empresaServicio;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/empresas")
	
	public ModelAndView manageEmpresa(@RequestParam(name="success",required=false)String success) {		
		System.out.println("/product y el success" + success);
		ModelAndView mv = new ModelAndView("empresas/empresasDocto");	
		mv.addObject("titulo","Asignar - Acta Constitutiva");		

		Empresa emp = new Empresa();
 
		mv.addObject("empresa", emp);

		if(success != null) {
			if(success.equals("empresa")){					
				mv.addObject("message", "Se Registro Exitosamente !!!");
			}

		}	 

		return mv;
	}
	
	
	@RequestMapping("/{id}/empresas")
	 
	public ModelAndView manageEmpresaEdit(@PathVariable int id) {		

		ModelAndView mv = new ModelAndView("empresas/empresasDocto");	 
	 
		mv.addObject("empresa", empresaServicio.findById(id));
		return mv;
	}
	 
	
	@RequestMapping(value = "/empresas", method=RequestMethod.POST)
	public String managePostEmp(@Valid @ModelAttribute("empresa") Empresa mEmpresa, 
			BindingResult results, Model model, HttpServletRequest request) {

		if (mEmpresa.getId()==0) {
			new DocumentoValidator().validate(mEmpresa, results);

		}else {
			// edit check only when the file has been selected
			if(!mEmpresa.getFile().getOriginalFilename().equals("")) {
				new DocumentoValidator().validate(mEmpresa, results);
			}			
		}


		if(results.hasErrors()) {
			model.addAttribute("message", "Se requiere seleccionar un  archivo!");
			return "redirect:/manage/empresas";
		}else
		{

			if(!mEmpresa.getFile().getOriginalFilename().equals("")) {

				this.code = "ACTA C-" + UUID.randomUUID().toString().substring(26).toUpperCase();
				mEmpresa.setCode(code);
				FileUploadUtility.uploadFile(request,mEmpresa.getFile(),mEmpresa.getCode());			
			}

			empresaServicio.save(mEmpresa);
			model.addAttribute("message", "Se Registro Exitosamente !!");

		}		 

		return "redirect:/manage/empresas?success=empresa";

	}
	
}
