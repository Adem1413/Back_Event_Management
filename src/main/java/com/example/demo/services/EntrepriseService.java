package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Entreprise;

@Service
public interface EntrepriseService {

	@Transactional
	 
	Entreprise saveEntreprise(Entreprise entreprise);
	 List<Entreprise> getAllEntreprise();
	 Entreprise getEntrepriseById(long id);
	 Entreprise updateEntreprise(Entreprise entreprise, long id);
	 void deleteEntreprise(long id);
	 
}
