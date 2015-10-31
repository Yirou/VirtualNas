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
public class Chercheur extends Membre {

    private List<Formation> listeFormationOuJenseigne = new ArrayList<>();

    public Chercheur(String nom, Groupe groupeParDefaut) {
        super(nom, groupeParDefaut);
    }

    public void setListeFormationOuJenseigne(List<Formation> listeFormationOuJenseigne) {
        this.listeFormationOuJenseigne = listeFormationOuJenseigne;
    }

    public List<Formation> getListeFormationOuJenseigne() {
        return listeFormationOuJenseigne;
    }

}
