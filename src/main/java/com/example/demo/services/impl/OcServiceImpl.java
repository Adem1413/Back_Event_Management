package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Oc;
import com.example.demo.repositories.OcRepository;
import com.example.demo.services.OcService;

@Service
public class OcServiceImpl implements OcService {

	private final OcRepository ocRepository;
    @Autowired
	public OcServiceImpl(OcRepository ocRepository) {
		this.ocRepository = ocRepository;
	}
	
	
	@Override
	@Transactional
	public Oc saveOc(Oc oc) {
		
		return ocRepository.save(oc);
	}

	@Override
	
	public List<Oc> getAllOc() {
		return ocRepository.findAll();
	}

	@Override
	public Oc getOcById(long id) {
		 Optional<Oc> oc = ocRepository.findById(id);
		    return oc.get();
	}

	@Override
	public Oc updateOc(Oc oc, long id) {
		
		Oc existingOc = ocRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Oc not found"));
		    
		existingOc.setNom(oc.getNom());
		existingOc.setPrenom(oc.getPrenom());
		existingOc.setSpecialite(oc.getSpecialite());
		existingOc.setNiveau(oc.getNiveau());
		existingOc.setNumtel(oc.getNumtel());

        ocRepository.save(existingOc);
        return existingOc;
	}

	@Override
	public void deleteOc(long id) {
		
		ocRepository.deleteById(id);
	}

}
