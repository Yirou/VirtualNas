/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.users;

import com.tp.nasvirtuel.TypeGroupe;

/**
 *
 * @author Yirou
 */
public class FactoryMembre {

    Membre membre;
    private static final FactoryMembre instance = new FactoryMembre();

    private FactoryMembre() {

    }

    public static FactoryMembre getInstance() {
        return instance;
    }

    public Membre creerMembre(TypeMembre typeMembre) {
        switch (typeMembre) {
            case Etudiant:
                membre=new Etudiant(null, null);
                membre.getListeGroupeAuthoriseACreer().add(TypeGroupe.GroupePerso);
                membre.getListeGroupeAuthoriseACreer().add(TypeGroupe.GroupeClassique);
                break;
            case Chercheur:
                membre=new Chercheur(null, null);
                membre.getListeGroupeAuthoriseACreer().add(TypeGroupe.GroupePerso);
                membre.getListeGroupeAuthoriseACreer().add(TypeGroupe.GroupeRechercheArticle);
                membre.getListeGroupeAuthoriseACreer().add(TypeGroupe.GroupeRechercheProjet);
                break;

            case Personnel:
                membre=new Personnel(null, null);
                membre.getListeGroupeAuthoriseACreer().add(TypeGroupe.GroupePerso);
                break;

            case Dsi:
                membre=new PersonnelDSI(null, null);
                membre.getListeGroupeAuthoriseACreer().add(TypeGroupe.GroupePerso);
                membre.getListeGroupeAuthoriseACreer().add(TypeGroupe.GroupeClassique);
                break;
            default:
                membre=new Etudiant(null, null);
        }
        return membre;
    }
}
