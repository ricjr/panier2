package com.nexio.ricardo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexio.ricardo.model.entity.Produit;
import com.nexio.ricardo.service.ProduitService;

/**
 * 
 * @author ricardo
 * 
 * Faire le point final REST pour les services de produit.
 *
 */
@RestController
@RequestMapping("api/produit")
public class ProduitController {
	
	@Autowired
	private ProduitService produitService;
	
	@GetMapping("/catalogue")
	public List<Produit> catalogue(){
		return produitService.listerTout();
	}
	
	@GetMapping("/detail/{idProduit}")
	public Produit detail(@PathVariable(name="idProduit") Long idProduit){
		return produitService.detail(idProduit);
	}

}
