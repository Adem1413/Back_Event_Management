package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Processus")
public class Processus {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="nom")
    private String nom;

    @OneToOne(cascade = CascadeType.ALL)
    
    private Equipe equipe;
    
    @Column(name="besoinOC")
    private int besoinOC;

    @Column(name="besoinlog")
    private String besoinlog;

    @Column(name="duree")
    private int dureeJ;

    @Column(name="debut")
    private int debut;

    @Column(name="fin")
    private int fin;

    @Column(name="finalite")
    private String finalite;
}
