/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.vues.listener;

import com.tp.nasvirtuel.Groupe;
import com.tp.nasvirtuel.vues.NasManagerView;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author yirou
 */
public class ListeGroupeViewListener implements ListSelectionListener {

    JList listeGroupe;

    @Override
    public void valueChanged(ListSelectionEvent e) {
        listeGroupe = (JList) e.getSource();
        if (listeGroupe.getSelectedValue() != null) {
            String groupe = listeGroupe.getSelectedValue().toString();
            Groupe grp = NasManagerView.getInstance().getUdsView().getUniversite().chercherGroupe(groupe);
            NasManagerView.getInstance().accederAuGroupe(grp);

        }

    }

}
