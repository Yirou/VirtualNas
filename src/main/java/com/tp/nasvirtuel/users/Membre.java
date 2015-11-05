/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.users;

import com.tp.nasvirtuel.FactoryGroupe;
import com.tp.nasvirtuel.Groupe;
import com.tp.nasvirtuel.TypeGroupe;
import com.tp.nasvirtuel.objets.Objet;
import com.tp.nasvirtuel.objets.ObjetFactory;
import com.tp.nasvirtuel.objets.TypeObjet;
import com.tp.nasvirtuel.services.Formation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yirou
 */
public abstract class Membre {

    protected String nom;
    protected List<Objet> mesObjets = new ArrayList<>();
    protected List<Groupe> groupesCrees = new ArrayList<>();
    protected List<Groupe> groupesAbonne = new ArrayList<>();
    protected List<TypeGroupe> listeGroupeAuthoriseACreer = new ArrayList<>();
    protected Groupe groupeParDefaut;
    private final FactoryGroupe factoryGroupe = FactoryGroupe.getInstance();

    public Membre(String nom, Groupe groupeParDefaut) {
        this.nom = nom;
        this.groupeParDefaut = groupeParDefaut;
    }

    public Groupe getGroupeParDefaut() {
        return groupeParDefaut;
    }

    public void setGroupeParDefaut(Groupe groupeParDefaut) {
        this.groupeParDefaut = groupeParDefaut;
    }

    public String getNom() {
        return nom;
    }

    public List<Groupe> getGroupesAbonne() {
        return groupesAbonne;
    }

    public void setGroupesAbonne(List<Groupe> groupesAbonne) {
        this.groupesAbonne = groupesAbonne;
    }
    
    
    public void setListeGroupeAuthoriseACreer(List<TypeGroupe> listeGroupeAuthoriseACreer) {
        this.listeGroupeAuthoriseACreer = listeGroupeAuthoriseACreer;
    }

    public List<TypeGroupe> getListeGroupeAuthoriseACreer() {
        return listeGroupeAuthoriseACreer;
    }

    public List<Objet> getMesObjets() {
        return mesObjets;
    }

    public void setMesObjets(List<Objet> mesObjets) {
        this.mesObjets = mesObjets;
    }

    public void setGroupesCrees(List<Groupe> groupesCrees) {
        this.groupesCrees = groupesCrees;
    }

    public List<Groupe> getGroupesCrees() {
        return groupesCrees;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Groupe creerGroupe(int i, String nomGroupe, int i0, String typeGroupe) {
        TypeGroupe type = TypeGroupe.getGroupe(typeGroupe);
        Groupe groupe = factoryGroupe.creerGroupe(type);
        groupe.setIdGroupe(i);
        groupe.setNom(nomGroupe);
        groupe.setAuteur(this);
        System.out.println("Nouveau groupe crée " + groupe.getNom());
        this.groupesCrees.add(groupe);
        return groupe;
    }

    public Objet ajouterObjet(String nomDocument, TypeObjet typeObjet) {
        System.out.println("Nouveau objet crée " + nomDocument);
        return ObjetFactory.getInstance().createObjet(nomDocument,typeObjet , this);
    }

    public boolean accederAuGroupe(Groupe groupe) {
        return groupesAbonne.contains(groupe) || groupesCrees.contains(groupe) || groupeParDefaut.equals(groupe);
    }

    

}
