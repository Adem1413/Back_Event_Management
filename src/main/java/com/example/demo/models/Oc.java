package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="Oc")
public class Oc {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom" )
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="niveau")
	private int niveau;
	@Column(name="specialite")
	private String specialite;
	@Column(name="numero_telephone")
	private long numtel;
	
	
	}
	
	
	
	