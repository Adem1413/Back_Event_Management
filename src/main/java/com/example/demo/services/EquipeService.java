package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Equipe;

@Service
public interface EquipeService {
 @Transactional
 
 Equipe saveEquipe(Equipe equipe);
 List<Equipe> getAllEquipe();
 Equipe getEquipeById(long id);
 Equipe updateEquipe(Equipe equipe, long id);
 void deleteEquipe(long id);
 
}
