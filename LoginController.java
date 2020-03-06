package com.mx.cji.crm.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
 
public class LoginController {

	protected final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "mi_pagina_login", method = RequestMethod.GET)
	public String login(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout ,
			Principal principal) { 
		
		if(principal != null){
			
			return "redirect:/";
		}
		
		if (error != null) {
			model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña inválida, vuelva a intentarlo!");
			logger.info("Error en el login: Nombre de usuario o contraseña inválida!");
		}

		if (logout != null) {
			model.addAttribute("msg", "Ha cerrado la sesión con éxito!");
			logger.info("Ha cerrado la sesión con éxito!");
		}
		return "mi_pagina_login";
	}
     
	 
	 
	@SuppressWarnings("unused")
	@ModelAttribute("userName")
	public String populateTitulo() {
		Principal p =null;
		String name=null;
		if(p !=null) {
		  name =p.getName();
		}
		return name;
	}
	
	 
}