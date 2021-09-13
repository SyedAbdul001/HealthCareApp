package com.tahauddin.syed.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tahauddin.syed.entity.Specialization;
import com.tahauddin.syed.service.SpecializationService;

@Controller
@RequestMapping("/specialization")
public class SpecializationController {

	
	@Resource
	private SpecializationService specializationService;
	
	@GetMapping("/showall")
	public String showAllSpecialization(Model model){
		
		List<Specialization> allSpecailization = 
				specializationService.getAllSpecailization();
		
		model.addAttribute("specializationList", allSpecailization);
		
	
		return "specializationdata";
	}
}
