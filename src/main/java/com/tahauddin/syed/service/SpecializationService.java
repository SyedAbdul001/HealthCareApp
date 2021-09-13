package com.tahauddin.syed.service;

import java.util.List;

import com.tahauddin.syed.entity.Specialization;

public interface SpecializationService {

	public Long saveSpecialization(Specialization specialization);
	
	public List<Specialization> getAllSpecailization();
	
	public Specialization getOneSpecailizationById(Long specId);
	
	public boolean deleteOneSpecailizationById(Long specId);
	
}
