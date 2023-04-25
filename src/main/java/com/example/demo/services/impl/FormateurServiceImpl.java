package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Formateur;
import com.example.demo.repositories.FormateurRepository;
import com.example.demo.services.FormateurService;
@Service
public class FormateurServiceImpl implements FormateurService  {
	
	private final FormateurRepository formateurRepository;
    @Autowired
	public FormateurServiceImpl(FormateurRepository formateurRepository) {
		this.formateurRepository = formateurRepository;
	}
    
    
    @Transactional
    @Override
	public Formateur saveFormateur(Formateur formateur) {
    	return formateurRepository.save(formateur);
	}

	@Override
	public List<Formateur> getAllFormateur() {
		return formateurRepository.findAll();
	}

	@Override
	public Formateur getFormateurById(long id) {
		Optional<Formateur> formateur = formateurRepository.findById(id);
	    return formateur.get();
	}

	@Override
	public Formateur updateFormateur(Formateur formateur, long id) {
		Formateur existingFormateur = formateurRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Formateur not found"));
		    
		existingFormateur.setNom(formateur.getNom());
		existingFormateur.setPrenom(formateur.getPrenom());
		existingFormateur.setDomaine(formateur.getDomaine());
		existingFormateur.setEmail(formateur.getEmail());
		existingFormateur.setConfirmation(formateur.isConfirmation());
		existingFormateur.setNumtel(formateur.getNumtel());
    
        formateurRepository.save(existingFormateur);
        return existingFormateur;
	}

	@Override
	public void deleteFormateur(long id) {
		formateurRepository.deleteById(id);
		
	}

}
