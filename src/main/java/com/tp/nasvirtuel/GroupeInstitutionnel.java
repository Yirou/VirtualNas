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
public abstract class GroupeInstitutionnel extends Groupe {

    public GroupeInstitutionnel(int idGroupe, String nom, Membre auteur, int nombreAcces) {
        super(idGroupe, nom, auteur, nombreAcces);
    }

    public GroupeInstitutionnel() {
    }

    
    public abstract void genererFichier();
}
