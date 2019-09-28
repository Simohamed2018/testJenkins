package com.simo.jenkins.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simo.jenkins.model.Compte;
import com.simo.jenkins.service.CompteService;
import com.simo.jenkins.web.exceptions.CompteAlreadayExistException;
import com.simo.jenkins.web.exceptions.CompteNotFoundException;

import java.util.List;
import javax.validation.Valid;


@RestController
public class CompteController {

	@Autowired
	CompteService compteService;
	// Affiche la liste de tous les produits disponibles
	
	@GetMapping(value = "/comptes")
	public List<Compte> listeDesProduits() {

		List<Compte> comptes = compteService.listeDesComptes();
		if (comptes.isEmpty())
			throw new CompteNotFoundException("Aucun compte n'est disponible ");
int i= comptes.size();
		return comptes;

	}

	// Récuperer un compte par son id
	
	@GetMapping(value = "/comptes/{id}")
	public Compte recupererUnProduit(@PathVariable int id) {

		Compte compte = compteService.recupererUnCompte(id);

		if (compte == null)
			throw new CompteNotFoundException("Le compte correspondant à l'id " + id + " n'existe pas");

		return compte;
	}

	// Ajouter un compte
	@PostMapping(value = "/comptes")
	public Compte ajouterUnCompte(@Valid @RequestBody Compte compte) {
		// if(compte == null) throw new ProductAlreadayExistException("Le compte
		// correspondant ne peut etre null ");
		if (compte == null || compte.getCompte().isEmpty() || compte.getCompte() == null)
			throw new CompteAlreadayExistException("Le compte correspondant ne peut etre null ");

		return compteService.ajouterUnCompte(compte);
	}

	
	@PutMapping(value = "/comptes")
	public void updateProduit(@RequestBody Compte product) {

		compteService.ajouterUnCompte(product);
	}

	
	@DeleteMapping(value = "/comptes/{id}")
	public void supprimerProduit(@PathVariable int id) {

		compteService.supprimerCompte(id);
	}

	

		
	
}
