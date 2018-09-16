package com.nexio.ricardo.model;

import com.nexio.ricardo.model.entity.Produit;

/**
 * Représente un élément de panier.
 * @author ricardo
 *
 */
public class PanierItem {
	
	private Produit produit;
	private Integer quantite;
	
	public PanierItem() {
		super();
	}
	
	public PanierItem(Produit produit, Integer quantite) {
		this.produit = produit;
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
}
