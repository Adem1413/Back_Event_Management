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

import com.example.demo.models.Entreprise;
import com.example.demo.services.EntrepriseService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/entreprise")
public class EntrepriseController {
	@Autowired
	private EntrepriseService entrepriseService;
	public EntrepriseController(EntrepriseService entrepriseService) {
		this.entrepriseService = entrepriseService;
	}
	
	//build create entreprise rest API
			@PostMapping
			public  ResponseEntity<Entreprise> saveEntreprise(@RequestBody Entreprise entreprise){
				return new ResponseEntity<Entreprise>(entrepriseService.saveEntreprise(entreprise),HttpStatus.CREATED);
			}
			
			
			//build get all entreprise REST API
			@GetMapping
			public List<Entreprise> getAllEntreprise(){
				return entrepriseService.getAllEntreprise();
						}
			//build get entreprise by id
			@GetMapping("{id}")
			public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable("id") long entrepriseId){
		     return new ResponseEntity<Entreprise>(entrepriseService.getEntrepriseById(entrepriseId), HttpStatus.OK);		
				
			}
			//build update entreprise REST API 
			@PutMapping("{id}")
			public ResponseEntity<Entreprise> updateEquipe(@PathVariable("id") long entrepriseId,@RequestBody Entreprise entreprise){ 
			 
				return  new  ResponseEntity<Entreprise>(entrepriseService.updateEntreprise(entreprise, entrepriseId),HttpStatus.OK);  
				
			}

			//build DELETE entreprise REST API
			@DeleteMapping("{id}")
			public ResponseEntity<String> deleteEquipe(@PathVariable("id") long entrepriseId){
				entrepriseService.deleteEntreprise(entrepriseId);
				return new ResponseEntity<String>("Entreprise deleted Successfully",HttpStatus.OK);
			}
			
	
}
