package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Oc;

@Service
public interface OcService {
	 @Transactional
	 Oc saveOc(Oc oc);
	 List<Oc> getAllOc();
	 Oc getOcById(long id);
	 Oc updateOc(Oc oc, long id);
	 void deleteOc(long id);

}
