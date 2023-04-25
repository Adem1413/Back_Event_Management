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
@Table(name="Subvention")
public class Subvention {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private long id;
	   
	    @Column(name="Article")
	    private String Article;
	    @Column(name="Nom_Société")
	    private String societe;
	    @Column(name="email")
	    private String email;
	    @Column(name="Numero_telephone")
	    private long numtel;
}
