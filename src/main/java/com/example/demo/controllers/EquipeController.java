package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Equipe;
import com.example.demo.services.EquipeService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/equipe")
public class EquipeController {
	@Autowired
	private EquipeService equipeService;
	public EquipeController(EquipeService equipeService) {
		this.equipeService = equipeService;
	}
	
	
	//build create equipe rest API
		@PostMapping
		public  ResponseEntity<Equipe> saveEquipe(@RequestBody Equipe equipe){
			return new ResponseEntity<Equipe>(equipeService.saveEquipe(equipe),HttpStatus.CREATED);
		}
		
		
		//build get all equipe REST API
		@GetMapping
		public List<Equipe> getAllEquipe(){
			return equipeService.getAllEquipe();
					}
		//build get equipe by id
		@GetMapping("{id}")
		public ResponseEntity<Equipe> getEquipeById(@PathVariable("id") long equipeId){
	     return new ResponseEntity<Equipe>(equipeService.getEquipeById(equipeId), HttpStatus.OK);		
			
		}
		//build update equipe REST API 
		@PutMapping("{id}")
		public ResponseEntity<Equipe> updateEquipe(@PathVariable("id") long equipeId,@RequestBody Equipe equipe){ 
		 
			return  new  ResponseEntity<Equipe>(equipeService.updateEquipe(equipe, equipeId),HttpStatus.OK);  
			
		}

		//build DELETE equipe REST API
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteEquipe(@PathVariable("id") long equipeId){
			equipeService.deleteEquipe(equipeId);
			return new ResponseEntity<String>("Equipe deleted Successfully",HttpStatus.OK);
		}
		
	
}




















