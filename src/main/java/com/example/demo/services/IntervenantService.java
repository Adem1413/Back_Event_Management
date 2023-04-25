package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Intervenant;

@Service
public interface IntervenantService {

	 @Transactional
	 
	 Intervenant saveIntervenant(Intervenant intervenant);
	 List<Intervenant> getAllIntervenant();
	 Intervenant getIntervenantById(long id);
	 Intervenant updateIntervenant(Intervenant intervenant, long id);
	 void deleteIntervenant(long id);
}
