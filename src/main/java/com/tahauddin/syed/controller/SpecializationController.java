package com.tahauddin.syed.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.tahauddin.syed.entity.Specialization;
import com.tahauddin.syed.service.SpecializationService;

@Controller
@RequestMapping("/specialization")
public class SpecializationController {

	
	@Resource
	private SpecializationService specializationService;
	
	@GetMapping("/edit")
	public String editSpecializationById(Model model,@RequestParam Long id) {
		
		Specialization oneSpecailizationById = specializationService.getOneSpecailizationById(id);
		model.addAttribute("specialization", oneSpecailizationById);
		
		return "specializationedit";
	}
	
	@PostMapping("/update")
	public RedirectView updateSpecialization(@ModelAttribute Specialization specialization) {
		
		Long savedSpecializationId = specializationService.saveSpecialization(specialization);
		
		
		return new RedirectView("showall");
	}
	
	
	
	
	
	
	@GetMapping("/delete")
	public RedirectView deleteSpecializationById(@RequestParam Long id) {
		
		specializationService.deleteOneSpecailizationById(id);
		
		return new RedirectView("showall");
//		return "redirect:showall";
	}
	
	
	@PostMapping("/save")
	public RedirectView saveSpecialization(Model model ,@ModelAttribute Specialization specialization) {
		
		Long savedSpecializationId = specializationService.saveSpecialization(specialization);
		
		String message = "Specialization with id " + savedSpecializationId + " Saved Successfully!";
		model.addAttribute("message", message);
		
		return new RedirectView("showall");
	//	return "redirect:showall";
	}
	

	@GetMapping("/register")
	public String showRegistrationPage() {
		
		return "specializationregister";
	}
	
	
	
	@GetMapping("/showall")
	public String showAllSpecialization(Model model){
		
		List<Specialization> allSpecailization = 
				specializationService.getAllSpecailization();
		
		model.addAttribute("specializationList", allSpecailization);
		
	
		return "specializationdata";
	}
}
