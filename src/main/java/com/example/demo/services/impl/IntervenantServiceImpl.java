package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Intervenant;
import com.example.demo.repositories.IntervenantRepository;
import com.example.demo.services.IntervenantService;
@Service
public class IntervenantServiceImpl implements IntervenantService {

	private final IntervenantRepository intervenantRepository;
    @Autowired
	public IntervenantServiceImpl(IntervenantRepository intervenantRepository) {
		this.intervenantRepository = intervenantRepository;
	}
    
    
    @Transactional
	
	
	
	@Override
	public Intervenant saveIntervenant(Intervenant intervenant) {
    	return intervenantRepository.save(intervenant);
	}

	@Override
	public List<Intervenant> getAllIntervenant() {
		return intervenantRepository.findAll();
	}

	@Override
	public Intervenant getIntervenantById(long id) {
		Optional<Intervenant> intervenant = intervenantRepository.findById(id);
	    return intervenant.get();
	}

	@Override
	public Intervenant updateIntervenant(Intervenant intervenant, long id) {
		Intervenant existingIntervenant = intervenantRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Intervenant not found"));
		    
		existingIntervenant.setNom(intervenant.getNom());
		existingIntervenant.setPrenom(intervenant.getPrenom());
		existingIntervenant.setSujet(intervenant.getSujet());
		existingIntervenant.setEmail(intervenant.getEmail());
		existingIntervenant.setConfirmation(intervenant.isConfirmation());
		existingIntervenant.setNumtel(intervenant.getNumtel());
    
		intervenantRepository.save(existingIntervenant);
        return existingIntervenant;
	}

	@Override
	public void deleteIntervenant(long id) {
		intervenantRepository.deleteById(id);
		
	}

}
