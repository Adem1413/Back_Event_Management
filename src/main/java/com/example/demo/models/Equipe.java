package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.enums.Comité;

import lombok.Data;

@Entity
@Data
@Table(name="Equipe")
public class Equipe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom" )
	private String nom;
	@Column(name="Comité" )
	private Comité Comite;
	@OneToMany(targetEntity = Oc.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="occol",referencedColumnName = "id")
    private List<Oc> ocs;
}
