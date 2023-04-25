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
@Table(name="Formateur")
public class Formateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom" )
	private String nom;
	@Column(name="prenom" )
	private String prenom;
	@Column(name="Domaine" )
	private String domaine;
	@Column(name="Email" )
	private String email;
	@Column(name="Numero_Telphone" )
	private long numtel;
	@Column(name="Confirmation" )
	private boolean confirmation;

}
