package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Entreprise;
import com.example.demo.models.Equipe;
import com.example.demo.repositories.EntrepriseRepository;
import com.example.demo.repositories.EquipeRepository;
import com.example.demo.services.EntrepriseService;
@Service
public class EntrepriseServiceImpl implements EntrepriseService {

	private final EntrepriseRepository entrepriseRepository;
    @Autowired
	public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
		this.entrepriseRepository = entrepriseRepository;
	}
    
    
    
	@Override
	@Transactional

	public Entreprise saveEntreprise(Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
	}

	@Override
	public List<Entreprise> getAllEntreprise() {
		return entrepriseRepository.findAll();
	}

	@Override
	public Entreprise getEntrepriseById(long id) {
		 Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
		    return entreprise.get();
	}

	@Override
	public Entreprise updateEntreprise(Entreprise entreprise, long id) {
		Entreprise existingEntreprise = entrepriseRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Entreprise not found"));
		    
		existingEntreprise.setNom(entreprise.getNom());
		existingEntreprise.setDomaine(entreprise.getDomaine());
		existingEntreprise.setEmail(entreprise.getEmail());
		existingEntreprise.setNumtel(entreprise.getNumtel());
		existingEntreprise.setConfirmation(entreprise.isConfirmation());	
	    
		entrepriseRepository.save(existingEntreprise);
        return existingEntreprise;
	}

	@Override
	public void deleteEntreprise(long id) {
		entrepriseRepository.deleteById(id);
		
	}
	

}
