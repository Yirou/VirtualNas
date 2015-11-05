/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.objets;

import com.tp.nasvirtuel.TypeRelationDuGroupe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author yirou
 */
public abstract class Objet {

    protected String nom;
    protected DatesModification date;
    public static Icon image = new ImageIcon("src/main/resources/drawable-mdpi/objet.png");
    private List<Relation> listeObjetEnRelation = new ArrayList<>();

    public Objet(String nom, DatesModification date) {
        this.nom = nom;
        this.date = date;
    }

    public abstract void afficherObjet();

    public DatesModification getDate() {
        return date;
    }

    public List<Relation> getListeObjetEnRelation() {
        return listeObjetEnRelation;
    }

    public void setListeObjetEnRelation(List<Relation> listeObjetEnRelation) {
        this.listeObjetEnRelation = listeObjetEnRelation;
    }

    public void setDate(DatesModification date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterObjetEnRelationAvec(Objet o, String relation) {
        TypeRelationDuGroupe typeRelationDuGroupe = TypeRelationDuGroupe.getTypeRelation(relation);
        this.getListeObjetEnRelation().add(new Relation(o, typeRelationDuGroupe));
        afficherObjetEnRelationAvec();
    }

    public void afficherObjetEnRelationAvec() {
        for (Relation relation : listeObjetEnRelation) {
            System.out.println(this.getNom() + " est en relation de "+relation.getRelation()+" avec " + relation.getObjet().getNom());
        }
    }

}
