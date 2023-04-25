package com.example.demo.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.PackType;

import lombok.Data;

@Entity
@Data
@Table(name="Pack")
public class Pack {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="Nom_Societe" )
	private String nom;
	@Column(name="type" )
	private PackType packtype;
	@Column(name="montant" )
	private int montant;
	
}
