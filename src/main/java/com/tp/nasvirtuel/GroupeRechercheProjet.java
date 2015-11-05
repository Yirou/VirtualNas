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
public class GroupeRechercheProjet extends GroupeRecherche{

    public GroupeRechercheProjet(int idGroupe, String nom, Membre auteur, int nombreAcces) {
        super(idGroupe, nom, auteur, nombreAcces);
    }

    public GroupeRechercheProjet() {
    }

    @Override
    public void genererFichier() {
    }

    @Override
    public void initialiserDossier() {
    }
    
}
