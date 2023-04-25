package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Media;

@Service
public interface MediaService {
	 @Transactional
	 Media saveMedia(Media media);
	 List<Media> getAllMedia();
	 Media getMediaById(long id);
	 Media updateMedia(Media media, long id);
	 void deleteMedia(long id);

}
