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

import com.example.demo.models.Oc;
import com.example.demo.services.OcService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/oc")
public class OcController {

	@Autowired
	private OcService ocService;
	public OcController(OcService ocService) {
		this.ocService = ocService;
	}
	
	//build create oc rest API
			@PostMapping
			public  ResponseEntity<Oc> saveOc(@RequestBody Oc oc){
				return new ResponseEntity<Oc>(ocService.saveOc(oc),HttpStatus.CREATED);
			}
			
			
			//build get all oc REST API
			@GetMapping
			public List<Oc> getAllOc(){
				return ocService.getAllOc();
						}
			//build get oc by id
			@GetMapping("{id}")
			public ResponseEntity<Oc> getOcById(@PathVariable("id") long ocId){
		     return new ResponseEntity<Oc>(ocService.getOcById(ocId), HttpStatus.OK);		
				
			}
			//build update oc REST API 
			@PutMapping("{id}")
			public ResponseEntity<Oc> updateOc(@PathVariable("id") long ocId,@RequestBody Oc oc){ 
				
				return  new  ResponseEntity<Oc>(ocService.updateOc(oc, ocId),HttpStatus.OK);  
				
			}

			//build DELETE oc REST API
			@DeleteMapping("{id}")
			public ResponseEntity<String> deleteOc(@PathVariable("id") long ocId){
				ocService.deleteOc(ocId);
				return new ResponseEntity<String>("Oc deleted Successfully",HttpStatus.OK);
			}
			
		
	}
	
	
	

