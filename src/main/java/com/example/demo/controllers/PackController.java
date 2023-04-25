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
import com.example.demo.models.Pack;
import com.example.demo.services.PackService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/pack")
public class PackController {
	@Autowired
	private PackService packService;
	public PackController(PackService packService) {
		this.packService = packService;
	}
	
	//build create pack rest API
	@PostMapping
	public  ResponseEntity<Pack> savePack(@RequestBody Pack pack){
		return new ResponseEntity<Pack>(packService.savePack(pack),HttpStatus.CREATED);
	}
	
	
	//build get all pack REST API
	@GetMapping
	public List<Pack> getAllPack(){
		return packService.getAllPack();
				}
	//build get pack by id
	@GetMapping("{id}")
	public ResponseEntity<Pack> getPackById(@PathVariable("id") long packId){
     return new ResponseEntity<Pack>(packService.getPackById(packId), HttpStatus.OK);		
		
	}
	//build update pack REST API 
	@PutMapping("{id}")
	public ResponseEntity<Pack> updatePack(@PathVariable("id") long packId,@RequestBody Pack pack){ 
		
		return  new  ResponseEntity<Pack>(packService.updatePack(pack, packId),HttpStatus.OK);  
		
	}

	//build DELETE pack REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteOc(@PathVariable("id") long packId){
		packService.deletePack(packId);
		return new ResponseEntity<String>("Pack deleted Successfully",HttpStatus.OK);
	}
	
	
	
	
}
