package com.nexio.ricardo.service;

import com.nexio.ricardo.model.entity.Utilisateur;

/**
 * Représente l'interface des services d'utilisateur.
 * @author ricardo
 *
 */
public interface UtilisateurService {
	
	public static final String UTILISATEUR = "UTILISATEUR";
	
	public boolean connecter(Utilisateur utilisateur);
	
	public void deconnecter();
}
