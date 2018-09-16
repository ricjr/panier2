package com.nexio.ricardo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexio.ricardo.model.entity.Produit;
import com.nexio.ricardo.repository.ProduitRepository;
import com.nexio.ricardo.service.ProduitService;

/**
 * Représente la classe des services de produit.
 * @author ricardo
 *
 */
@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	private ProduitRepository repository;
	
	/**
	 * Liste tous les produits
	 */
	@Override
	public List<Produit> listerTout() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	/**
	 * Détailler un produit
	 */
	@Override
	public Produit detail(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	/**
	 * incluire un produit
	 */
	@Override
	public void incluire(Produit produit) {
		// TODO Auto-generated method stub
		repository.save(produit);
		
	}

	/**
	 * supprimer un produit
	 */
	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
