package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Oc;
import com.example.demo.models.Pack;
import com.example.demo.repositories.OcRepository;
import com.example.demo.repositories.PackRepository;
import com.example.demo.services.PackService;

@Service
public class PackServiceImpl implements PackService {
	private final PackRepository packRepository;
    @Autowired
	public PackServiceImpl(PackRepository packRepository) {
		this.packRepository = packRepository;
	}
    
	@Override
	public Pack savePack(Pack pack) {
		return packRepository.save(pack);

	}

	@Override
	public List<Pack> getAllPack() {
		return packRepository.findAll();
	}

	@Override
	public Pack getPackById(long id) {
		Optional<Pack> pack = packRepository.findById(id);
	    return pack.get();
	}

	@Override
	public Pack updatePack(Pack pack, long id) {
		
		Pack existingPack = packRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("pack not found"));
		    
		existingPack.setNom(pack.getNom());
		existingPack.setPacktype(pack.getPacktype());
		existingPack.setMontant(pack.getMontant());
	;

		packRepository.save(existingPack);
        return existingPack;
		
	}

	@Override
	public void deletePack(long id) {
		packRepository.deleteById(id);
		
	}

}
