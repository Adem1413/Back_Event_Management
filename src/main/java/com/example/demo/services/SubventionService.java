package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Subvention;

@Service
public interface SubventionService {
 @Transactional
	 
     Subvention saveSubvention(Subvention subvention);
	 List<Subvention> getAllSubvention();
	 Subvention getSubventionById(long id);
	 Subvention updateSubvention(Subvention subvention, long id);
	 void deleteSubvention(long id);
}
