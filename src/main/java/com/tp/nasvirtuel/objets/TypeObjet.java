/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.objets;

/**
 *
 * @author Yirou
 */
public enum TypeObjet {

    Document, Repertoire, Service, Objet,Trombinoscope;

    public static TypeObjet getTypeObjet(String type) {
        for (TypeObjet typeObjet : TypeObjet.values()) {
            if (typeObjet.toString().equalsIgnoreCase(type)) {
                return typeObjet;
            }
        }
        return Objet;
    }
}
