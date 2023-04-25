package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Equipe;
import com.example.demo.repositories.EquipeRepository;
import com.example.demo.services.EquipeService;
@Service
public class EquipeServiceImpl implements EquipeService  {
     
	private final EquipeRepository equipeRepository;
    @Autowired
	public EquipeServiceImpl(EquipeRepository equipeRepository) {
		this.equipeRepository = equipeRepository;
	}
    
    
    
	@Override
	@Transactional

	public Equipe saveEquipe(Equipe equipe) {
	return equipeRepository.save(equipe);
	}
	
	
	@Override
	public List<Equipe> getAllEquipe() {
		return equipeRepository.findAll();
	}
	@Override
	public Equipe getEquipeById(long id) {
		 Optional<Equipe> equipe = equipeRepository.findById(id);
		    return equipe.get();
	}
	@Override
	public Equipe updateEquipe(Equipe equipe, long id) {
		Equipe existingEquipe = equipeRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Equipe not found"));
		    
		existingEquipe.setNom(equipe.getNom());
		existingEquipe.setComite(equipe.getComite());
	    existingEquipe.setOcs(equipe.getOcs());
	    
        equipeRepository.save(existingEquipe);
        return existingEquipe;
	}
	@Override
	public void deleteEquipe(long id) {
		equipeRepository.deleteById(id);
		
	}



}
