package com.example.demo.controllers;

import java.util.List;
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
import com.example.demo.services.ProcessusService;
import com.example.demo.models.Processus;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/processus")
public class ProcessusController {
    
	private ProcessusService processusService;
	public ProcessusController(ProcessusService processusService) {
		this.processusService = processusService;
	}

	//build create employee rest API
	@PostMapping
	public  ResponseEntity<Processus> saveProcessus(@RequestBody Processus processus){
		
		return new ResponseEntity<Processus>(processusService.saveProcessus(processus),HttpStatus.CREATED);
	}

	//build get all Processus REST API
	@GetMapping
	public List<Processus> getAllProcessus(){
		return processusService.getAllProcessus();
				}
	//build get Processus by id
	@GetMapping("{id}")
	public ResponseEntity<Processus> getProcussusById(@PathVariable("id") long processusId){
     return new ResponseEntity<Processus>(processusService.getProcessusById(processusId), HttpStatus.OK);		
		
	}
	//build update Processus REST API 
	@PutMapping("{id}")
	public ResponseEntity<Processus> updateProcessus(@PathVariable("id") long processusId,@RequestBody Processus processus){ 
		
		return  new  ResponseEntity<Processus>(processusService.updateProcessus(processus, processusId),HttpStatus.OK);  
		
	}

	//build DELETE Processus REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProcessus(@PathVariable("id") long processusId){
		processusService.deleteProcessus(processusId);
		return new ResponseEntity<String>("Processus deleted Successfully",HttpStatus.OK);
	}
	
}
