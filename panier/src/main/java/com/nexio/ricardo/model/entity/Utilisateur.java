package com.nexio.ricardo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Représente les données d'un utilisateur
 * @author ricardo
 *
 */
@Entity
@Table(name="UTILISATEUR")
public class Utilisateur {
	
	@Id
	@Column(name="NOM")
	private String nom;
	
	@Column(name="MOT_PASSE")
	private String motPasse;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String motPasse) {
		super();
		this.nom = nom;
		this.motPasse = motPasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
}
