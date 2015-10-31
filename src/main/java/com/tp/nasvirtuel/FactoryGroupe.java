/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel;

/**
 *
 * @author Yirou
 */
public class FactoryGroupe {

    private static final FactoryGroupe instance = new FactoryGroupe();
    Groupe groupe;

    private FactoryGroupe() {

    }

    public Groupe creerGroupe(TypeGroupe type) {
        switch (type) {
            case GroupeClassique:
                groupe = new GroupeClassique();
                break;

            case GroupePerso:
                groupe = new GroupePerso();
                break;

            case GroupeRechercheArticle:
                groupe = new GroupeRechercheArticle();
                break;

            case GroupeRechercheProjet:
                groupe = new GroupeRechercheProjet();
                break;
        }
        return groupe;
    }

    public static FactoryGroupe getInstance() {
        return instance;
    }
}
