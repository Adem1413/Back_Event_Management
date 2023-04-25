package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Formateur;

@Service
public interface FormateurService {

	 @Transactional
	 
	 Formateur saveFormateur(Formateur formateur);
	 List<Formateur> getAllFormateur();
	 Formateur getFormateurById(long id);
	 Formateur updateFormateur(Formateur formateur, long id);
	 void deleteFormateur(long id);
}
