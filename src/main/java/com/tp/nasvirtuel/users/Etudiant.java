/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.users;

import com.tp.nasvirtuel.Groupe;
import com.tp.nasvirtuel.services.Formation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yirou
 */
public class Etudiant extends Membre {

    private List<Formation> listeFormationOuJeSuisInscrit = new ArrayList<>();

    public Etudiant(String nom, Groupe groupeParDefaut) {
        super(nom, groupeParDefaut);
    }

    public List<Formation> getListeFormationOuJeSuisInscrit() {
        return listeFormationOuJeSuisInscrit;
    }

    public void setListeFormationOuJeSuisInscrit(List<Formation> listeFormationOuJeSuisInscrit) {
        this.listeFormationOuJeSuisInscrit = listeFormationOuJeSuisInscrit;
    }

}
