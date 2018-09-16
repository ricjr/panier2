package com.nexio.ricardo.service;

import java.util.List;

import com.nexio.ricardo.model.entity.Produit;

/**
 * Représente l'interface des services de produit.
 * @author ricardo
 *
 */
public interface ProduitService {
	
	public List<Produit> listerTout();
	
	public Produit detail(Long id);
	
	public void incluire(Produit produit);
	
	public void supprimer(Long id);
}
