package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Equipe;
import com.example.demo.models.Processus;
import com.example.demo.repositories.EquipeRepository;
import com.example.demo.repositories.ProcessusRepository;
import com.example.demo.services.EquipeService;
import com.example.demo.services.ProcessusService;
@Service

public class ProcessusServiceImpl implements ProcessusService {
	
	private final ProcessusRepository processusRepository;

	 @Autowired
	    private EquipeService equipeService;
    
	public ProcessusServiceImpl(ProcessusRepository processusRepository,EquipeRepository equipeRepository) {
		this.processusRepository = processusRepository;
	}

    
    
	
	@Override
	@Transactional
	public Processus saveProcessus(Processus processus) {
	     
		
		return processusRepository.save(processus);
	}

	@Override
	public List<Processus> getAllProcessus() {
		 return processusRepository.findAll() ; 
	}

	@Override
	public Processus getProcessusById(long id) {
		
	    Optional<Processus> processus = processusRepository.findById(id);
	    return processus.get();
	   
	
	}


	@Override
	public Processus updateProcessus(Processus processus, long id) {
		
		
		Processus existingProcessus = processusRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Processus not found"));
		    
	    existingProcessus.setNom(processus.getNom());
	    existingProcessus.setEquipe(processus.getEquipe());
	    existingProcessus.setBesoinOC(processus.getBesoinOC());
	    existingProcessus.setBesoinlog(processus.getBesoinlog());
	    existingProcessus.setDureeJ(processus.getDureeJ());
	    existingProcessus.setDebut(processus.getDebut());
	    existingProcessus.setFin(processus.getFin());
	    existingProcessus.setFinalite(processus.getFinalite());
        processusRepository.save(existingProcessus);
        return existingProcessus;
	}

@Override
	public void deleteProcessus(long id) {
		
		processusRepository.deleteById(id);
	}
}
	
	
	
	    