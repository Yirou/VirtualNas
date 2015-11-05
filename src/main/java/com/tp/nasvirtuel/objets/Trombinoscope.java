/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.objets;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Yirou
 */
public class Trombinoscope extends Objet {

    public static Icon image = new ImageIcon("src/main/resources/drawable-mdpi/folder.png");

    public Trombinoscope(String nom, DatesModification date) {
        super(nom, date);
    }

    @Override
    public void afficherObjet() {
        System.out.println("je suis le trombinoscope");
    }

}
