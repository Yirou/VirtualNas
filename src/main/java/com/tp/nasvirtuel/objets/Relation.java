/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.objets;

import com.tp.nasvirtuel.TypeRelationDuGroupe;

/**
 *
 * @author Yirou
 */
public class Relation {

    private Objet objet;
    private TypeRelationDuGroupe relation;

    public Relation(Objet objet, TypeRelationDuGroupe relation) {
        this.objet = objet;
        this.relation = relation;
    }

    public Relation() {
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    public TypeRelationDuGroupe getRelation() {
        return relation;
    }

    public void setRelation(TypeRelationDuGroupe relation) {
        this.relation = relation;
    }

}
