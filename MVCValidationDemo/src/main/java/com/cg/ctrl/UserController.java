package com.cg.ctrl;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Scope("session")
@Controller
@RequestMapping(value="user")
public class UserController {
	ArrayList<String> cityList;
	ArrayList<String> skillList;
	
	@RequestMapping(value="showLogin")
	public String prepareLogin(Model model){
		System.out.println("In prepareLogin() method");
		model.addAttribute("login", new Login());
		return "Login";
	}
	
	@RequestMapping(value="/checkLogin")
	public ModelAndView checkLogin(@ModelAttribute("login") Login l){
		//Validate username and password against database
		return new ModelAndView("loginSuccess","username",l.getUserName());
	}
	
	@RequestMapping(value="showRegister")
	public String prepareRegister(Model model){
		
		cityList = new ArrayList<String>();
		cityList.add("Mumbai");
		cityList.add("Pune");
		cityList.add("Hyderabad");
		cityList.add("Bangalore");
		
		skillList = new ArrayList<String>();
		skillList.add("Java");
		skillList.add("Spring");
		skillList.add("Hibernate");
		skillList.add("Struts");
		
		model.addAttribute("cityList", cityList);
		model.addAttribute("skillList", skillList);
		model.addAttribute("user", new User());
		return "Register";
			
	}
	
	@RequestMapping(value="/checkRegister")
	public String checkRegister(@ModelAttribute("user")@Valid User user,BindingResult result,Model model){
		if(result.hasErrors()){
			System.out.println("Errors");
			model.addAttribute("cityList", cityList);
			model.addAttribute("skillList", skillList);
			return "Register";
		}
		else{
			model.addAttribute("user", user);
			System.out.println("Valid user details");
			return "registerSuccess";			
		}
	}
	

}
