package com.nexio.ricardo.service;

import java.util.List;

import com.nexio.ricardo.model.PanierItem;
/**
 * Représente l'interface des services de panier.
 * @author ricardo
 *
 */
public interface PanierService {
	
	public static final String PANIER_UTILISATEUR = "PANIER_UTILISATEUR";
	
	public List<PanierItem> listerTout();
	
	public void ajouterProduit(Long idProduit, Integer quantiteAjouter);
	
	public void enleverProduit(Long idProduit, Integer quantiteEnvlever);
	
}
