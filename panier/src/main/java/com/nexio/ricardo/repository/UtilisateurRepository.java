package com.nexio.ricardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexio.ricardo.model.entity.Utilisateur;

/**
 * Cette composant donne accès à la base de données d'utilisateur
 * @author ricardo
 *
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{

}
