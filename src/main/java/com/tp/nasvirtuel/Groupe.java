/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel;

import com.tp.nasvirtuel.objets.Objet;
import com.tp.nasvirtuel.users.Membre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yirou
 */
public class Groupe {

    protected int idGroupe;
    protected String nom;
    protected Membre auteur;
    protected int nombreAcces;
    protected List<Objet> listeObjets = new ArrayList<>();
    protected List<Membre> listeDesMembres = new ArrayList<>();

    public Groupe() {
    }

    public Groupe(int idGroupe, String nom, Membre auteur, int nombreAcces) {
        this.idGroupe = idGroupe;
        this.nom = nom;
        this.auteur = auteur;
        this.nombreAcces = nombreAcces;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Membre getAuteur() {
        return auteur;
    }

    public int getNombreAcces() {
        return nombreAcces;
    }

    public void setAuteur(Membre auteur) {
        this.auteur = auteur;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public void setListeDesMembres(List<Membre> listeDesMembres) {
        this.listeDesMembres = listeDesMembres;
    }

    public List<Objet> getListeObjets() {
        return listeObjets;
    }

    public List<Membre> getListeDesMembres() {
        return listeDesMembres;
    }

    public void setListeObjets(List<Objet> listeObjets) {
        this.listeObjets = listeObjets;
    }

    public void setNombreAcces(int nombreAcces) {
        this.nombreAcces = nombreAcces;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> lireContenu() {
        for (Objet objet : listeObjets) {
            System.out.println("Objet " + objet.getNom());
        }
        return null;
    }

    public void ajouterObjet(Objet objet) {
        listeObjets.add(objet);
    }
}
