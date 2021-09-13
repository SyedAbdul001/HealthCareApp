package com.tahauddin.syed.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tahauddin.syed.entity.Specialization;
import com.tahauddin.syed.repo.SpecailizationRepo;
import com.tahauddin.syed.service.SpecializationService;

@Service
public class SpecializationServiceImpl implements SpecializationService {
	
	@Resource
	private SpecailizationRepo specailizationRepo;

	@Override
	public Long saveSpecialization(Specialization specialization) {
		Specialization savedObject = specailizationRepo.save(specialization);
		
		
		
		return savedObject.getSpecId();
	}

	@Override
	public List<Specialization> getAllSpecailization() {
		return specailizationRepo.findAll();
	}

	@Override
	public Specialization getOneSpecailizationById(Long specId) {
		Optional<Specialization> findById = specailizationRepo.findById(specId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteOneSpecailizationById(Long specId) {
		
		try {
			specailizationRepo.deleteById(specId);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

}
