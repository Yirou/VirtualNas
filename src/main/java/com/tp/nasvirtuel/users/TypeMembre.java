/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.users;

/**
 *
 * @author Yirou
 */
public enum TypeMembre {

    Etudiant, Chercheur, Personnel, Dsi;

    public static TypeMembre getTypeMEmbre(String type) {
        for (TypeMembre typeMembre : TypeMembre.values()) {
            if (typeMembre.toString().equalsIgnoreCase(type)) {
                return typeMembre;
            }
        }
        return Etudiant;
    }
}
