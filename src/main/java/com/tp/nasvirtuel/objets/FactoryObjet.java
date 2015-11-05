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
public class FactoryObjet {

    private static final FactoryObjet instance = new FactoryObjet();

    private FactoryObjet() {
    }

    public static FactoryObjet getInstance() {
        return instance;
    }

    public Objet createObjet(final String nomDocument, final TypeObjet typeObjet, final Membre membre) {
        Objet objet;
        switch (typeObjet) {
            case Document:
                objet = new Document(nomDocument, new DatesModification(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;
            case Repertoire:
                objet = new Repertoire(nomDocument, new DatesModification(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;
            case Service:
                objet = new Document(nomDocument, new DatesModification(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;

            case Trombinoscope:
                objet = new Trombinoscope(nomDocument, new DatesModification(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;
            default:
                objet = new Document(nomDocument, new DatesModification(new Date(), membre, null));
                objet.getDate().setObjetModifier(objet);
                break;
        }
        return objet;
    }
}
