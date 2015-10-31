/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.services;

import com.tp.nasvirtuel.Groupe;
import com.tp.nasvirtuel.users.Membre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yirou
 */
public class Service {

    protected Groupe groupeParDefaut;
    protected String nom;
    protected List<Membre> listeMembre = new ArrayList<>();

    public Service(String nom, Groupe groupeParDefaut) {
        this.nom = nom;
        this.groupeParDefaut = groupeParDefaut;
    }

    public void setListeMembre(List<Membre> listeMembre) {
        this.listeMembre = listeMembre;
    }

    public List<Membre> getListeMembre() {
        return listeMembre;
    }

    public String getNom() {
        return nom;
    }

    public void setGroupeParDefaut(Groupe groupeParDefaut) {
        this.groupeParDefaut = groupeParDefaut;
    }

    public Groupe getGroupeParDefaut() {
        return groupeParDefaut;
    }

    public Service(Groupe groupeParDefaut, String nom) {
        this.groupeParDefaut = groupeParDefaut;
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
