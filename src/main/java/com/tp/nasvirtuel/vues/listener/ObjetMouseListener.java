/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.vues.listener;

import com.tp.nasvirtuel.Groupe;
import com.tp.nasvirtuel.objets.Objet;
import com.tp.nasvirtuel.vues.NasManagerView;
import com.tp.nasvirtuel.vues.RelierDocument;
import com.tp.nasvirtuel.vues.UdsPanel;
import com.tp.nasvirtuel.vues.UdsView;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Yirou
 */
public class ObjetMouseListener extends MouseAdapter {

    Component component;
    UdsView udsView;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            component = (Component) e.getSource();
            String str_groupe = NasManagerView.getInstance().getGroupeListView().getSelectedValue().toString();
            Groupe groupe = NasManagerView.getInstance().getUdsView().getUniversite().chercherGroupe(str_groupe);
            Objet objet = groupe.chercherObjet(component.getName());
            objet.afficherObjetEnRelationAvec();
        } else if (e.getClickCount() == 2) {

            new RelierDocument().setVisible(true);

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
