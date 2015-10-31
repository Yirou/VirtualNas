/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel;

import com.tp.nasvirtuel.users.Membre;

/**
 *
 * @author Yirou
 */
public class GroupeClassique extends GroupeInstitutionnel {

    public GroupeClassique(int idGroupe, String nom, Membre auteur, int nombreAcces) {
        super(idGroupe, nom, auteur, nombreAcces);
    }

    public GroupeClassique() {
        
    }


    @Override
    public void genererFichier() {
        
    }
}
