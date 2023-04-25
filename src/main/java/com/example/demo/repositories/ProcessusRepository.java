package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Processus;
@Repository
public interface ProcessusRepository extends JpaRepository<Processus,Long> {
	

}
 