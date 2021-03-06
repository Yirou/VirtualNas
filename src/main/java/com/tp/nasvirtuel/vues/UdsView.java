/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.vues;

import com.tp.nasvirtuel.Universite;
import com.tp.nasvirtuel.users.Membre;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author yirou
 */
public class UdsView extends javax.swing.JFrame {

    PanelDemarrage panelDemarrage;
    CenterView centerView;
    BotomView botomView;
    TopView topView;
    Universite universite;
    Membre membreActif;
    public static Color color_blue = new Color(0x00AFF0);
    public static Color color_blue_foncee = new Color(0x0C7DAF);
    public static Color color_blue_ciel = new Color(0x0095CC);

    /**
     * Creates new form UdsView
     */
    public UdsView() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout layout = new BorderLayout(5, 5);
        setLayout(new BorderLayout());
        panelDemarrage = new PanelDemarrage(this);
        centerView = new CenterView();
        botomView = new BotomView(this);
        topView = new TopView(this);
        universite = new Universite("Univ Savoie Mont Blanc");
        universite.genererGroupe();
        universite.genererListFiliereEtFormation();
        universite.genererEtudiantEtChercheur();
        add(topView, BorderLayout.NORTH);
        add(botomView, BorderLayout.SOUTH);
        centerView.getPanelPrincipal().addTab(null, panelDemarrage);
        add(centerView, BorderLayout.CENTER);
        centerView.setBackground(Color.WHITE);

    }

    public Membre getMembreActif() {
        return membreActif;
    }

    public void setMembreActif(Membre membreActif) {
        this.membreActif = membreActif;
    }

    public Universite getUniversite() {
        return universite;
    }

    public PanelDemarrage getPanelDemarrage() {
        return panelDemarrage;
    }
 
    public CenterView getCenterView() {
        return centerView;
    }

    public BotomView getBotomView() {
        return botomView;
    }

    public TopView getTopView() {
        return topView;
    }

 

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
