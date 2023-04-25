package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Processus;
@Service
public interface ProcessusService {
	@Transactional
 Processus saveProcessus(Processus processus);
 List<Processus> getAllProcessus();
 Processus getProcessusById(long id);
 Processus updateProcessus(Processus processus, long id);
 void deleteProcessus(long id);
}
