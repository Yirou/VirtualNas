/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.objets;

import com.tp.nasvirtuel.users.Membre;
import java.util.Date;

/**
 *
 * @author yirou
 */
public class ObjetFactory {

    private static final ObjetFactory instance = new ObjetFactory();

    private ObjetFactory() {
    }

    public static ObjetFactory getInstance() {
        return instance;
    }

    public Objet createObjet(final String nomDocument, final String typeDocument, final Membre membre) {
        Objet objet;
        switch (typeDocument) {
            case "Document":
                objet = new Document(nomDocument, new DatesCreation(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;
            case "Repertoire":
                objet = new Repertoire(nomDocument, new DatesCreation(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;
            case "Service":
                objet = new Document(nomDocument, new DatesCreation(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;
            default:
                objet = new Document(nomDocument, new DatesCreation(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;
        }
        return objet;
    }
}
