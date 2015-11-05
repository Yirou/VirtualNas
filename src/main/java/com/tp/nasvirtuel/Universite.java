/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel;

import com.tp.nasvirtuel.objets.Objet;
import com.tp.nasvirtuel.services.Filiere;
import com.tp.nasvirtuel.services.Formation;
import com.tp.nasvirtuel.services.Service;
import com.tp.nasvirtuel.users.Chercheur;
import com.tp.nasvirtuel.users.Etudiant;
import com.tp.nasvirtuel.users.FactoryMembre;
import com.tp.nasvirtuel.users.Membre;
import com.tp.nasvirtuel.users.TypeMembre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yirou
 */
public class Universite {

    private List<Groupe> listeGroupeDisponible = new ArrayList<>();
    private List<Membre> listeDesMembres = new ArrayList<>();
    private List<Service> listeDesFilieres = new ArrayList<>();
    Groupe etudiantGroupe;
    Groupe personnelGroupe;
    Groupe chercheurGroupe;
    Groupe dsiGroupe;
    private String nom;
    Membre admin;

    public Universite(String nom) {
        this.nom = nom;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdmin(Membre admin) {
        this.admin = admin;
    }

    public Membre getAdmin() {
        return admin;
    }

    public List<Groupe> getListeGroupeDisponible() {
        return listeGroupeDisponible;
    }

    public void setListeGroupeDisponible(List<Groupe> listeGroupeDisponible) {
        this.listeGroupeDisponible = listeGroupeDisponible;
    }

    public List<Service> getListeDesFilieres() {
        return listeDesFilieres;
    }

    public void setListeDesFilieres(List<Service> listeDesFilieres) {
        this.listeDesFilieres = listeDesFilieres;
    }

    public List<Membre> getListeDesMembres() {
        return listeDesMembres;
    }

    public void setListeDesMembres(List<Membre> listeDesMembres) {
        this.listeDesMembres = listeDesMembres;
    }

    private void cloneGroupe(String groupeACloner, Groupe groupe, Membre membreActif) {
        Groupe grACloner = chercherGroupe(groupeACloner);
        membreActif.clonerGroupe(grACloner, groupe);
    }

    public void creerGroupe(String nomGroupe, Membre membreActif, String type, String groupeACloner) {
        Groupe groupe1 = membreActif.creerGroupe(listeGroupeDisponible.size() + 1, nomGroupe, 0, type);
        cloneGroupe(groupeACloner, groupe1, membreActif);
        misAjourGroupes(groupe1);
    }

    public boolean accederAuGroupe(final int idGroupe) {
        return false;
    }

    public void misAjourGroupes(final Groupe groupe) {
        listeGroupeDisponible.add(groupe);
    }

    public Membre ajouterObjet(final Membre membre) {
        return verifierSiMembreExiste(membre);
    }

    public Membre verifierSiMembreExiste(final String pseudo) {
        for (Membre membre : listeDesMembres) {
            if (membre.getNom().toLowerCase().equalsIgnoreCase(pseudo)) {
                return membre;
            }
        }
        return null;
    }

    public Membre verifierSiMembreExiste(final Membre membreActif) {
        for (Membre membre : listeDesMembres) {
            if (membre.equals(membreActif)) {
                return membre;
            }
        }
        return null;
    }

    public Filiere chercherFiliere(String nom) {
        Filiere filiere;
        for (Service service : listeDesFilieres) {
            filiere = (Filiere) service;
            if (filiere.getNom().toLowerCase().equalsIgnoreCase(nom)) {
                return filiere;
            }
        }
        return null;
    }

    public void genererListFiliereEtFormation() {
        Groupe groupeInformatique = new GroupeClassique(this.getListeGroupeDisponible().size() + 1, "Groupe Informatique", admin, 0);
        Filiere info = new Filiere("Informatique", groupeInformatique);
        Groupe groupeMath = new GroupeClassique(this.getListeGroupeDisponible().size() + 1, "Math-Physique", admin, 0);
        Filiere math = new Filiere("Math-Physique", groupeMath);
        this.getListeDesFilieres().add(info);
        this.getListeDesFilieres().add(math);
        Formation stic = new Formation("STIC", info);
        Formation reseau = new Formation("Réseau", info);
        info.getListeFormation().add(stic);
        info.getListeFormation().add(reseau);
        Formation mp = new Formation("Physique", math);
        math.getListeFormation().add(mp);
        this.getListeGroupeDisponible().add(groupeInformatique);
        this.getListeGroupeDisponible().add(groupeMath);
    }

    public void genererGroupe() {
        FactoryGroupe factoryGroupe = FactoryGroupe.getInstance();
        etudiantGroupe = factoryGroupe.creerGroupe(TypeGroupe.GroupeClassique);
        etudiantGroupe.setIdGroupe(this.getListeGroupeDisponible().size() + 1);
        etudiantGroupe.setNom("Groupe Etudiant");
        etudiantGroupe.setAuteur(admin);
        this.getListeGroupeDisponible().add(etudiantGroupe);

        chercheurGroupe = factoryGroupe.creerGroupe(TypeGroupe.GroupeClassique);
        chercheurGroupe.setIdGroupe(this.getListeGroupeDisponible().size() + 1);
        chercheurGroupe.setNom("Groupe chercheur");
        chercheurGroupe.setAuteur(admin);
        this.getListeGroupeDisponible().add(chercheurGroupe);

        personnelGroupe = factoryGroupe.creerGroupe(TypeGroupe.GroupeClassique);
        personnelGroupe.setIdGroupe(this.getListeGroupeDisponible().size() + 1);
        personnelGroupe.setNom("Groupe Personnel");
        personnelGroupe.setAuteur(admin);
        this.getListeGroupeDisponible().add(personnelGroupe);

        dsiGroupe = factoryGroupe.creerGroupe(TypeGroupe.GroupeClassique);
        dsiGroupe.setIdGroupe(this.getListeGroupeDisponible().size() + 1);
        dsiGroupe.setNom("Groupe Dsi");
        dsiGroupe.setAuteur(admin);
        this.getListeGroupeDisponible().add(dsiGroupe);
    }

    public void genererEtudiantEtChercheur() {
        Filiere filiere = chercherFiliere("informatique");
        Formation formation = filiere.chercherFormation("STIC");
        FactoryMembre factoryMembre = FactoryMembre.getInstance();
        Membre membre = factoryMembre.creerMembre(TypeMembre.Etudiant);
        membre.setGroupeParDefaut(etudiantGroupe);
        membre.setNom("Yirou");
        listeDesMembres.add(membre);
        etudiantGroupe.ajouterMembre(membre);
        filiere.getListeMembre().add(membre);
        formation.getListeEtudiant().add((Etudiant) membre);

        membre = factoryMembre.creerMembre(TypeMembre.Etudiant);
        membre.setGroupeParDefaut(etudiantGroupe);
        membre.setNom("Lucas");
        listeDesMembres.add(membre);
        etudiantGroupe.ajouterMembre(membre);
        filiere.getListeMembre().add(membre);
        formation.getListeEtudiant().add((Etudiant) membre);

        filiere = chercherFiliere("Math-Physique");
        membre = factoryMembre.creerMembre(TypeMembre.Etudiant);
        membre.setGroupeParDefaut(etudiantGroupe);
        membre.setNom("George");
        listeDesMembres.add(membre);
        etudiantGroupe.ajouterMembre(membre);
        filiere.getListeMembre().add(membre);
        membre = factoryMembre.creerMembre(TypeMembre.Etudiant);
        membre.setGroupeParDefaut(etudiantGroupe);
        membre.setNom("Dudu");
        listeDesMembres.add(membre);
        etudiantGroupe.ajouterMembre(membre);
        filiere.getListeMembre().add(membre);

        membre = factoryMembre.creerMembre(TypeMembre.Chercheur);
        membre.setGroupeParDefaut(chercheurGroupe);
        membre.setNom("Christophe");
        listeDesMembres.add(membre);
        chercheurGroupe.ajouterMembre(membre);
        formation.getListeEnseignant().add((Chercheur) membre);

        membre = factoryMembre.creerMembre(TypeMembre.Chercheur);
        membre.setGroupeParDefaut(chercheurGroupe);
        membre.setNom("Christine");
        listeDesMembres.add(membre);
        chercheurGroupe.ajouterMembre(membre);

        admin = factoryMembre.creerMembre(TypeMembre.Dsi);
        admin.setGroupeParDefaut(dsiGroupe);
        admin.setNom("Admin");
        listeDesMembres.add(admin);
        admin.setGroupeParDefaut(dsiGroupe);
    }

    public Groupe chercherGroupe(final String nom) {
        for (Groupe groupe : listeGroupeDisponible) {
            if ((nom).equalsIgnoreCase(groupe.getNom())) {
                return groupe;
            }
        }
        return null;
    }

    public Groupe getEtudiantGroupe() {
        return etudiantGroupe;
    }

    public void setEtudiantGroupe(Groupe etudiantGroupe) {
        this.etudiantGroupe = etudiantGroupe;
    }

    public Groupe getPersonnelGroupe() {
        return personnelGroupe;
    }

    public void setPersonnelGroupe(Groupe personnelGroupe) {
        this.personnelGroupe = personnelGroupe;
    }

    public Groupe getChercheurGroupe() {
        return chercheurGroupe;
    }

    public void setChercheurGroupe(Groupe chercheurGroupe) {
        this.chercheurGroupe = chercheurGroupe;
    }

    public Groupe getDsiGroupe() {
        return dsiGroupe;
    }

    public void setDsiGroupe(Groupe dsiGroupe) {
        this.dsiGroupe = dsiGroupe;
    }

    public Formation deployerMembres(String nomFilere, String nomFormation) {
        Filiere filiere = chercherFiliere(nomFilere);
        return filiere.chercherFormation(nomFormation);
    }

    public void relierDocument(String str_groupe, String str_objet1, String str_objet2, String relation) {
        Groupe groupe = chercherGroupe(str_groupe);
        groupe.ajouterRelation(str_objet1, str_objet2, relation);
    }

}
