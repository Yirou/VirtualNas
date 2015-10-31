/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.services;

import com.tp.nasvirtuel.Groupe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yirou
 */
public class Filiere extends Service {

    private List<Formation> listeFormation = new ArrayList<>();

    public Filiere(String nom, Groupe groupeParDefaut) {
        super(nom, groupeParDefaut);
    }

    public List<Formation> getListeFormation() {
        return listeFormation;
    }

    public void setListeFormation(List<Formation> listeFormation) {
        this.listeFormation = listeFormation;
    }

    public Formation chercherFormation(String nomFormation) {
        for (Formation formation : listeFormation) {
            if (formation.getNom().equalsIgnoreCase(nomFormation)) {
                return formation;
            }
        }
        return null;
    }

}
