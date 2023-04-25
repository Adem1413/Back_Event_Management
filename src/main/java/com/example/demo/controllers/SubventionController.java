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
import com.example.demo.models.Subvention;
import com.example.demo.services.SubventionService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/subvention")
public class SubventionController {
	@Autowired
	private SubventionService subventionService;
	public SubventionController(SubventionService subventionService) {
		this.subventionService = subventionService;
	}
	
	//build create subvention rest API
	@PostMapping
	public  ResponseEntity<Subvention> saveSubvention(@RequestBody Subvention subvention){
		return new ResponseEntity<Subvention>(subventionService.saveSubvention(subvention),HttpStatus.CREATED);
	}
	
	
	//build get all subvention REST API
	@GetMapping
	public List<Subvention> getAllSubvention(){
		return subventionService.getAllSubvention();
				}
	//build get subvention by id
	@GetMapping("{id}")
	public ResponseEntity<Subvention> getSubventionById(@PathVariable("id") long subventionId){
     return new ResponseEntity<Subvention>(subventionService.getSubventionById(subventionId), HttpStatus.OK);		
		
	}
	//build update subvention REST API 
	@PutMapping("{id}")
	public ResponseEntity<Subvention> updateSubvention(@PathVariable("id") long subventionId,@RequestBody Subvention subvention){ 
	 
		return new ResponseEntity<Subvention>(subventionService.updateSubvention(subvention, subventionId),HttpStatus.OK);  
		
	}

	//build DELETE subvention REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSubvention(@PathVariable("id") long subventionId){
		subventionService.deleteSubvention(subventionId);
		return new ResponseEntity<String>("Subvention deleted Successfully",HttpStatus.OK);
	}

}
