package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Pack;

@Service
public interface PackService {
	@Transactional
	 
	Pack savePack(Pack pack);
	 List<Pack> getAllPack();
	 Pack getPackById(long id);
	 Pack updatePack(Pack pack, long id);
	 void deletePack(long id);
	 
}
