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

import com.example.demo.models.Media;
import com.example.demo.models.Oc;
import com.example.demo.services.MediaService;
import com.example.demo.services.OcService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/media")
public class MediaController {

	@Autowired
	private MediaService mediaService;
	public MediaController(MediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	//build create Media rest API
	@PostMapping
	public  ResponseEntity<Media> saveMedia(@RequestBody Media media){
		return new ResponseEntity<Media>(mediaService.saveMedia(media),HttpStatus.CREATED);
	}
	
	
	//build get all Media REST API
	@GetMapping
	public List<Media> getAllMedia(){
		return mediaService.getAllMedia();
				}
	//build get Media by id
	@GetMapping("{id}")
	public ResponseEntity<Media> getMediaById(@PathVariable("id") long mediaId){
     return new ResponseEntity<Media>(mediaService.getMediaById(mediaId), HttpStatus.OK);		
		
	}
	//build update Media REST API 
	@PutMapping("{id}")
	public ResponseEntity<Media> updateMedia(@PathVariable("id") long mediaId,@RequestBody Media media){ 
		
		return  new  ResponseEntity<Media>(mediaService.updateMedia(media, mediaId),HttpStatus.OK);  
		
	}

	//build DELETE Media REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteOc(@PathVariable("id") long mediaId){
		mediaService.deleteMedia(mediaId);
		return new ResponseEntity<String>("Oc deleted Successfully",HttpStatus.OK);
	}
	
}
