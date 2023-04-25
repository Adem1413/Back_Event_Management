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
import com.example.demo.models.Formateur;
import com.example.demo.services.FormateurService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/formateur")
public class FormateurController {

	
	@Autowired
	private FormateurService formateurService;
	public FormateurController(FormateurService formateurService) {
		this.formateurService = formateurService;
	}
	
	
	      //build create formateur rest API
			@PostMapping
			public  ResponseEntity<Formateur> saveFormateur(@RequestBody Formateur formateur){
				return new ResponseEntity<Formateur>(formateurService.saveFormateur(formateur),HttpStatus.CREATED);
			}
			
			
			//build get all Formateur REST API
			@GetMapping
			public List<Formateur> getAllFormateur(){
				return formateurService.getAllFormateur();
						}
			//build get Formateur by id
			@GetMapping("{id}")
			public ResponseEntity<Formateur> getFormateurById(@PathVariable("id") long formateurId){
		     return new ResponseEntity<Formateur>(formateurService.getFormateurById(formateurId), HttpStatus.OK);		
				
			}
			//build update Formateur REST API 
			@PutMapping("{id}")
			public ResponseEntity<Formateur> updateFormateur(@PathVariable("id") long formateurId,@RequestBody Formateur formateur){ 
			 
				return new ResponseEntity<Formateur>(formateurService.updateFormateur(formateur, formateurId),HttpStatus.OK);  
				
			}

			//build DELETE Formateur REST API
			@DeleteMapping("{id}")
			public ResponseEntity<String> deleteFormateur(@PathVariable("id") long formateurId){
				formateurService.deleteFormateur(formateurId);
				return new ResponseEntity<String>("Formateur deleted Successfully",HttpStatus.OK);
			}
			
	
}
