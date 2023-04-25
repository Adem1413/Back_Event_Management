package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Media;
import com.example.demo.models.Oc;
import com.example.demo.repositories.IntervenantRepository;
import com.example.demo.repositories.MediaRepository;
import com.example.demo.services.MediaService;

@Service
public class MediaServiceImpl implements MediaService {
	private final MediaRepository mediaRepository;
    @Autowired
	public MediaServiceImpl(MediaRepository mediaRepository) {
		this.mediaRepository = mediaRepository;
	}
    
    @Transactional
	@Override
	public Media saveMedia(Media media) {
    	return mediaRepository.save(media);
	}
	@Override
	public List<Media> getAllMedia() {
		return mediaRepository.findAll();
	}
	@Override
	public Media getMediaById(long id) {
		 Optional<Media> media = mediaRepository.findById(id);
		    return media.get();
	}
	@Override
	public Media updateMedia(Media media, long id) {
		Media existingMedia = mediaRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Media not found"));
		    
		existingMedia.setTache(media.getTache());
		existingMedia.setNomOc(media.getNomOc());
		
		mediaRepository.save(existingMedia);
        return existingMedia;
		
	}
	@Override
	public void deleteMedia(long id) {
		mediaRepository.deleteById(id);
		
	}
    
    
	
	
	
}
