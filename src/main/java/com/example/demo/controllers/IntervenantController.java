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

import com.example.demo.models.Intervenant;
import com.example.demo.services.IntervenantService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/intervenant")
public class IntervenantController {

	@Autowired
	private IntervenantService intervenantService;
	public IntervenantController (IntervenantService intervenantService) {
		this.intervenantService = intervenantService;
	}
	
	//build create Intervenant rest API
	@PostMapping
	public  ResponseEntity<Intervenant> saveIntervenant(@RequestBody Intervenant intervenant){
		return new ResponseEntity<Intervenant>(intervenantService.saveIntervenant(intervenant),HttpStatus.CREATED);
	}
	
	
	//build get all Intervenant REST API
	@GetMapping
	public List<Intervenant> getAllIntervenant(){
		return intervenantService.getAllIntervenant();
				}
	//build get Intervenant by id
	@GetMapping("{id}")
	public ResponseEntity<Intervenant> getIntervenantById(@PathVariable("id") long intervenantId){
     return new ResponseEntity<Intervenant>(intervenantService.getIntervenantById(intervenantId), HttpStatus.OK);		
		
	}
	//build update Intervenant REST API 
	@PutMapping("{id}")
	public ResponseEntity<Intervenant> updateIntervenant(@PathVariable("id") long intervenantId,@RequestBody Intervenant intervenant){ 
	 
		return new ResponseEntity<Intervenant>(intervenantService.updateIntervenant(intervenant, intervenantId),HttpStatus.OK);  
		
	}

	//build DELETE Intervenant REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteFormateur(@PathVariable("id") long intervenantId){
		intervenantService.deleteIntervenant(intervenantId);
		return new ResponseEntity<String>("Intervenant deleted Successfully",HttpStatus.OK);
	}
	
	
	
	
	
}
