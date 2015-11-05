/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel;

import com.tp.nasvirtuel.objets.Document;
import com.tp.nasvirtuel.objets.Objet;
import com.tp.nasvirtuel.objets.Repertoire;
import com.tp.nasvirtuel.objets.TypeObjet;
import com.tp.nasvirtuel.services.Formation;
import com.tp.nasvirtuel.users.Chercheur;
import com.tp.nasvirtuel.users.Etudiant;
import com.tp.nasvirtuel.users.Membre;
import com.tp.nasvirtuel.users.PersonnelDSI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yirou
 */
public abstract class Groupe {

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

    public void ajouterMembre(Membre membre) {
        listeDesMembres.add(membre);
        membre.getGroupesAbonne().add(this);

        System.out.println(membre.getNom() + " ajouté ");
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

    public void deployerMembres(Formation formation) {
        for (Etudiant etudiant : formation.getListeEtudiant()) {
            ajouterMembre(etudiant);
            System.out.println("etudiant deployé " + etudiant.getNom());
        }
        for (Chercheur chercheur : formation.getListeEnseignant()) {
            ajouterMembre(chercheur);
            System.out.println("chercheur deployé " + chercheur.getNom());
        }
    }

    public Objet chercherObjet(String nomObjet) {
        for (Objet objet : listeObjets) {
            if (objet.getNom().equalsIgnoreCase(nomObjet)) {
                return objet;
            }
        }
        return null;
    }

    public void creerTrombinoscope(PersonnelDSI dsi, String nomObjet) {
        dsi.ajouterObjet(nomObjet, TypeObjet.Objet);
    }

    public void initialiserDossier() {
        System.out.println("Creation des dossiers ");
    }

    public void cloner(Groupe grACloner) {
        if (grACloner != null) {
            for (Objet object : grACloner.getListeObjets()) {
                if (object.getClass().equals(Repertoire.class)) {
                    listeObjets.add(object);
                }
            }
        }

    }

    void ajouterRelation(String str_objet1, String str_objet2, String relation) {
        Objet ob1 =chercherObjet(str_objet1);
        Objet ob2 = chercherObjet(str_objet2);
        ob1.ajouterObjetEnRelationAvec(ob2, relation);
        ob2.ajouterObjetEnRelationAvec(ob1, relation);
    }
}
