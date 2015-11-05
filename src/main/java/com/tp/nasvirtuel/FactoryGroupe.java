/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel;

import java.util.Arrays;

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
                groupe.getTypeRelationPossibleDuGroupe().add(TypeRelationDuGroupe.Autre);
                break;

            case GroupePerso:
                groupe = new GroupePerso();
                groupe.getTypeRelationPossibleDuGroupe().add(TypeRelationDuGroupe.Autre);
                groupe.getTypeRelationPossibleDuGroupe().add(TypeRelationDuGroupe.Corriger);
                break;

            case GroupeRechercheArticle:
                groupe = new GroupeRechercheArticle();
                groupe.setTypeRelationPossibleDuGroupe(Arrays.asList(TypeRelationDuGroupe.values()));
                break;

            case GroupeRechercheProjet:
                groupe = new GroupeRechercheProjet();
                groupe.setTypeRelationPossibleDuGroupe(Arrays.asList(TypeRelationDuGroupe.values()));
                break;
        }
        return groupe;
    }

    public static FactoryGroupe getInstance() {
        return instance;
    }
}
