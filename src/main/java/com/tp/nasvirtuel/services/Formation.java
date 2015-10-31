/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.services;

import com.tp.nasvirtuel.users.Chercheur;
import com.tp.nasvirtuel.users.Etudiant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yirou
 */
public class Formation {

    private String nom;
    List<Etudiant> listeEtudiant = new ArrayList<>();
    List<Chercheur> listeEnseignant = new ArrayList<>();
    Filiere filiere;

    public Formation(String nom, Filiere filiere) {
        this.nom = nom;
        this.filiere = filiere;
    }

    public List<Chercheur> getListeEnseignant() {
        return listeEnseignant;
    }

    public List<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }

    public void setListeEnseignant(List<Chercheur> listeEnseignant) {
        this.listeEnseignant = listeEnseignant;
    }

    public void setListeEtudiant(List<Etudiant> listeEtudiant) {
        this.listeEtudiant = listeEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
