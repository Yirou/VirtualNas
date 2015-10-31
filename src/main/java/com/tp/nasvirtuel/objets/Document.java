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
 * @author yirou
 */
public class Document extends Objet{
    public static Icon image=new ImageIcon("src/main/resources/drawable-mdpi/document.png");
    public Document(String nom, DatesModification date) {
        super(nom, date);
    }

    @Override
    public void afficherObjet() {
        System.out.println("Je suis un Document");
    }

   
    
}
