/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.objets;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author yirou
 */
public class Repertoire extends Objet {

    public static Icon image = new ImageIcon("src/main/resources/drawable-mdpi/folder.png");
    private List<Objet> listeObjets = new ArrayList<>();

    public Repertoire(String nom, DatesModification date) {
        super(nom, date);
    }

    public void setListeObjets(List<Objet> listeObjets) {
        this.listeObjets = listeObjets;
    }

    public List<Objet> getListeObjets() {
        return listeObjets;
    }

    @Override
    public void afficherObjet() {
        for (Objet objet : listeObjets) {
            System.out.println(objet.getNom());
        }
    }

}
