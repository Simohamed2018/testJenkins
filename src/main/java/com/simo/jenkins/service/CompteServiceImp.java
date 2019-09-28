package com.simo.jenkins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simo.jenkins.dao.CompteDao;
import com.simo.jenkins.model.Compte;


@Service
public class CompteServiceImp  implements  CompteService{

    @Autowired
    CompteDao compteDao;

    // Affiche la liste de tous les produits disponibles
    public List<Compte> listeDesComptes() {

        List<Compte> Comptes = compteDao.findAll();
        return Comptes;

    }

    // Récuperer un produit par son id

    public Compte recupererUnCompte(int id) {

        Compte compte = compteDao.findById(id);
     return compte;
    }

    // Ajouter un produit

    public Compte ajouterUnCompte( Compte compte) {


        return compteDao.save(compte);
    }


    public void updateCompte( Compte compte) {

    	compteDao.save(compte);
    }


    public void supprimerCompte(int id) {

    	compteDao.deleteById(id);
    }    


    
    // ajouter un produit

    public Compte ajouterCompte(Compte compte) {

        Compte compteAdded = compteDao.save(compte);

        return compteAdded;
    }


   
}


