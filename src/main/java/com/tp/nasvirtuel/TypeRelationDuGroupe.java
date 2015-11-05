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
public enum TypeRelationDuGroupe {

    Contredit, UneAutreVersion, UneTraduction, Etaye, Illustre, Corriger, Autre;

    public static TypeRelationDuGroupe getTypeRelation(String type) {
        for (TypeRelationDuGroupe typeRelationDuGroupe : TypeRelationDuGroupe.values()) {
            if (typeRelationDuGroupe.toString().equalsIgnoreCase(type)) {
                return typeRelationDuGroupe;
            }
        }
        return Autre;
    }

}
