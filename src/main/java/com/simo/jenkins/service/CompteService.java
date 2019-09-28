package com.simo.jenkins.service;


import org.springframework.stereotype.Service;

import com.simo.jenkins.model.Compte;

import java.util.List;
//@Service
public interface CompteService {


    List<Compte> listeDesComptes();

    Compte recupererUnCompte(int id);

    Compte ajouterUnCompte(Compte produit);

    void supprimerCompte(int id);    

    Compte ajouterCompte(Compte product);

   
}
