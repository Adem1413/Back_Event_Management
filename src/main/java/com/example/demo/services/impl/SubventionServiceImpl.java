package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Subvention;
import com.example.demo.repositories.SubventionRepository;
import com.example.demo.services.SubventionService;
@Service
public class SubventionServiceImpl implements SubventionService {

	private final SubventionRepository subventionRepository;
    @Autowired
	public SubventionServiceImpl(SubventionRepository subventionRepository) {
		this.subventionRepository = subventionRepository;
	}
    
    
    @Transactional
	
	@Override
	public Subvention saveSubvention(Subvention subvention) {
    	return subventionRepository.save(subvention);
	}

	@Override
	public List<Subvention> getAllSubvention() {
		return subventionRepository.findAll();
	}

	@Override
	public Subvention getSubventionById(long id) {
		Optional<Subvention> subvention = subventionRepository.findById(id);
	    return subvention.get();
	}

	@Override
	public Subvention updateSubvention(Subvention subvention, long id) {
		
		Subvention existingSubvention = subventionRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Subvention not found"));
		    
		existingSubvention.setArticle(subvention.getArticle());
		existingSubvention.setEmail(subvention.getEmail());
		existingSubvention.setNumtel(subvention.getNumtel());
		existingSubvention.setSociete(subvention.getSociete());

	    subventionRepository.save(existingSubvention);
        return existingSubvention;
	}

	@Override
	public void deleteSubvention(long id) {
		
		subventionRepository.deleteById(id);

	}

}
