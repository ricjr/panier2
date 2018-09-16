package com.nexio.ricardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexio.ricardo.model.entity.Produit;

/**
 * Cette composant donne accès à la base de données du produit
 * @author ricardo
 *
 */
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
