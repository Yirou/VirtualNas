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
public enum TypeGroupe {

    GroupeClassique, GroupePerso, GroupeRechercheArticle, GroupeRechercheProjet;

    public static TypeGroupe getGroupe(String groupe) {
        for (TypeGroupe typeGroupe : TypeGroupe.values()) {
            if (typeGroupe.toString().equalsIgnoreCase(groupe)) {
                return typeGroupe;
            }
        }
        return GroupePerso;
    }
}
