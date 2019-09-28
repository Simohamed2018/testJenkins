package com.simo.jenkins.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;



@Entity
public class Compte {
	


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @NotEmpty(message="le nomDetenteur ne peux pas etre null")
    private String detenteur;
   
    @Length(min=3, max=100, message ="description doit etre entre 3 et 20 caracteres")      
    private String banque;
   
    private String compte;   
   
   
    @Min( value = 0,message="le solde est obligatoire")
    private Double solde;


    public Compte() {
    }


	public Compte(int id, @NotEmpty(message = "le nomDetenteur ne peux pas etre null") String detenteur,
			@Length(min = 3, max = 100, message = "description doit etre entre 3 et 20 caracteres") String banque,
			String compte, @Min(value = 0, message = "le solde est obligatoire") Double solde) {
		super();
		this.id = id;
		this.detenteur = detenteur;
		this.banque = banque;
		this.compte = compte;
		this.solde = solde;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDetenteur() {
		return detenteur;
	}


	public void setDetenteur(String detenteur) {
		this.detenteur = detenteur;
	}


	public String getBanque() {
		return banque;
	}


	public void setBanque(String banque) {
		this.banque = banque;
	}


	public String getCompte() {
		return compte;
	}


	public void setCompte(String compte) {
		this.compte = compte;
	}


	public Double getSolde() {
		return solde;
	}


	public void setSolde(Double solde) {
		this.solde = solde;
	}


	@Override
	public String toString() {
		return "Compte [id=" + id + ", detenteur=" + detenteur + ", banque=" + banque + ", compte=" + compte
				+ ", solde=" + solde + "]";
	}


	

	

	
}
