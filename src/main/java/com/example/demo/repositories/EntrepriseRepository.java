package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Entreprise;
@Repository
public interface EntrepriseRepository  extends JpaRepository<Entreprise,Long>  {

}
