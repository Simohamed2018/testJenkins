package com.simo.jenkins.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.simo.jenkins.model.Compte;


@Repository
public interface CompteDao extends JpaRepository<Compte, Integer>{
	
	    Compte findById(int id);	    
	   	    
	   
	    
	   
	}

