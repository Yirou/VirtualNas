/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel;

import com.tp.nasvirtuel.services.Service;
import com.tp.nasvirtuel.users.Membre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yirou
 */
public class Universite {

    private List<Groupe> listeGroupeDisponible = new ArrayList<>();
    private List<Membre> listeDesMembres = new ArrayList<>();
    private List<Service> listeDesServices = new ArrayList<>();
    private String nom;

    public Universite(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Groupe> getListeGroupeDisponible() {
        return listeGroupeDisponible;
    }

    public void setListeGroupeDisponible(List<Groupe> listeGroupeDisponible) {
        this.listeGroupeDisponible = listeGroupeDisponible;
    }

    public void setListeDesServices(List<Service> listeDesServices) {
        this.listeDesServices = listeDesServices;
    }

    public List<Service> getListeDesServices() {
        return listeDesServices;
    }

    public List<Membre> getListeDesMembres() {
        return listeDesMembres;
    }

    public void setListeDesMembres(List<Membre> listeDesMembres) {
        this.listeDesMembres = listeDesMembres;
    }

    public void creerGroupe(final String name) {

    }

    public boolean accederAuGroupe(final int idGroupe) {
        return false;
    }

    public void misAjourGroupes(final Groupe groupe) {
        listeGroupeDisponible.add(groupe);
    }

    public void ajouterObjet(final String typeObjet, final String emplacement) {

    }

    public Membre verifierSiMembreExiste(final String pseudo) {
        for (Membre membre : listeDesMembres) {
            if (membre.getNom().equalsIgnoreCase(pseudo)) {
                return membre;
            }
        }
        return null;
    }

    public Groupe chercherGroupe(final String nom) {
        for (Groupe groupe : listeGroupeDisponible) {
            if ((nom).equalsIgnoreCase(groupe.getNom())) {
                return groupe;
            }
        }
        return null;
    }
}
