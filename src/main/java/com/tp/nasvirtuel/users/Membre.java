/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.users;

import com.tp.nasvirtuel.Groupe;
import com.tp.nasvirtuel.objets.DatesCreation;
import com.tp.nasvirtuel.objets.Document;
import com.tp.nasvirtuel.objets.Objet;
import com.tp.nasvirtuel.objets.Repertoire;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author yirou
 */
public class Membre {

    protected String nom;
    protected List<Objet> mesObjets = new ArrayList<>();
    protected List<Groupe> groupesCrees = new ArrayList<>();
    protected List<Groupe> groupesAbonne = new ArrayList<>();
    protected Groupe groupeParDefaut;

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

    public Groupe creerGroupe(int i, String nomGroupe, Membre membreActif, int i0) {
        Groupe groupe = new Groupe(i, nomGroupe, membreActif, i0);
        this.groupesCrees.add(groupe);
        return groupe;
    }

    public Objet ajouterObjet(String nomDocument, String typeDocument) {
        Objet objet = null;
        switch (typeDocument) {
            case "Document":

                objet = new Document(nomDocument, new DatesCreation(new Date(), this, null));
                objet.getDate().setObjetModifier(objet);
                break;
            case "Repertoire":
                objet = new Repertoire(nomDocument, new DatesCreation(new Date(), this, null));
                objet.getDate().setObjetModifier(objet);
                break;
            case "Service":
                break;
            case "Autre":
                break;
        }
        return objet;

    }

    public boolean accederAuGroupe(Groupe groupe) {
        return groupesAbonne.contains(groupe) || groupesCrees.contains(groupe) || groupeParDefaut.equals(groupe);
    }

}
