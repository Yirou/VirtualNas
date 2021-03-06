/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.vues;

import com.tp.nasvirtuel.Groupe;
import com.tp.nasvirtuel.objets.Document;
import com.tp.nasvirtuel.objets.Objet;
import com.tp.nasvirtuel.objets.Repertoire;
import com.tp.nasvirtuel.users.Membre;
import com.tp.nasvirtuel.vues.listener.ListeGroupeViewListener;
import com.tp.nasvirtuel.vues.listener.ObjetListener;
import com.tp.nasvirtuel.vues.listener.ObjetMouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yirou
 */
public class NasManagerView extends javax.swing.JFrame {
    
    private final String[] tableHeader = {"Nom objet"};
    private UdsView udsView;
    private static final NasManagerView nasManagerView = new NasManagerView(null, null);
    private Membre membreActif;

    /**
     * Creates new form NasManagerView
     *
     * @param udsView
     */
    private NasManagerView(UdsView udsView, Membre membreActif) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        btn_addGroupe.setIcon(new ImageIcon("src/main/resources/drawable-mdpi/add.png"));
        btn_addUserToGroupe.setIcon(new ImageIcon("src/main/resources/drawable-mdpi/add_user.png"));
        btn_addObject.setIcon(new ImageIcon("src/main/resources/drawable-mdpi/objet.png"));
        back_label.setIcon(new ImageIcon("src/main/resources/drawable-mdpi/back.png"));
        btn_logOut.setIcon(new ImageIcon("src/main/resources/drawable-mdpi/out.png"));
        btn_add_members.setIcon(new ImageIcon("src/main/resources/drawable-mdpi/add_members.png"));
        btn_add_relation.setIcon(new ImageIcon("src/main/resources/drawable-mdpi/relation.png"));
        this.udsView = udsView;
        this.membreActif = membreActif;
        this.groupeListView.addListSelectionListener(new ListeGroupeViewListener());
        this.panelObjetContent.setLayout(new FlowLayout());
        setColor();
       // changerNomMembreActif();
        
    }

    private void changerNomMembreActif() {
        nomMembreActif.setText(membreActif.getNom());
    }

    public Membre getMembreActif() {
        return membreActif;
    }
    
    public JList getGroupeListView() {
        return groupeListView;
    }
    
    public void accederAuGroupe(Groupe groupe) {
        if (membreActif.accederAuGroupe(groupe)) {
            groupe.lireContenu();
        }
        afficherObjetSurPanel(groupe);
        
    }
    
    private void afficherObjetSurPanel(Groupe groupe) {
        JButton component;
        panelObjetContent.removeAll();
        panelObjetContent.revalidate();
        panelObjetContent.repaint();
        for (Objet objet : groupe.getListeObjets()) {
            String classe = objet.getClass().getSimpleName();
            switch (classe) {
                case "Document":
                    component = new JButton();
                    component.setIcon(Document.image);
                    break;
                case "Repertoire":
                    component = new JButton();
                    component.setIcon(Repertoire.image);
                    component.addMouseListener(new ObjetMouseListener());
                    break;
                default:
                    component = new JButton();
                    component.setIcon(Objet.image);
            }
            component.setPreferredSize(new Dimension(52, 52));
            component.addActionListener(new ObjetListener());
            component.setToolTipText(objet.getNom());
            component.setName(objet.getNom());
            panelObjetContent.add(component);
        }
        panelObjetContent.revalidate();
        
    }
    
    public void afficherListeDesGroupes() {
        Vector<String> groupes = new Vector<>();
        for (Groupe groupe : membreActif.getGroupesCrees()) {
            groupes.add(groupe.getNom());
        }
        for (Groupe groupe : membreActif.getGroupesAbonne()) {
            groupes.add(groupe.getNom());
        }
        
        groupeListView.setListData(groupes);
    }
    
    public void setMembreActif(Membre membreActif) {
        this.membreActif = membreActif;
    }
    
    public static NasManagerView getInstance() {
        return nasManagerView;
    }
    
    public void setUdsView(UdsView udsView) {
        this.udsView = udsView;
    }
    
    public UdsView getUdsView() {
        return udsView;
    }
    
    public JPanel getPanelObjetContent() {
        return panelObjetContent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupeListView = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        panelObjetContent = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_addGroupe = new javax.swing.JButton();
        btn_addUserToGroupe = new javax.swing.JButton();
        btn_addObject = new javax.swing.JButton();
        btn_add_members = new javax.swing.JButton();
        btn_add_relation = new javax.swing.JButton();
        back_label = new javax.swing.JLabel();
        btn_logOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nomMembreActif = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        groupeListView.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(groupeListView);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setText("Liste des groupes disponibles");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelObjetContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelObjetContentLayout = new javax.swing.GroupLayout(panelObjetContent);
        panelObjetContent.setLayout(panelObjetContentLayout);
        panelObjetContentLayout.setHorizontalGroup(
            panelObjetContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
        );
        panelObjetContentLayout.setVerticalGroup(
            panelObjetContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_addGroupe.setToolTipText("Ajouter un groupe");
        btn_addGroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addGroupeActionPerformed(evt);
            }
        });

        btn_addUserToGroupe.setToolTipText("Ajouter un membre au groupe");
        btn_addUserToGroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addUserToGroupeActionPerformed(evt);
            }
        });

        btn_addObject.setToolTipText("Ajouter un objet au groupe");
        btn_addObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addObjectActionPerformed(evt);
            }
        });

        btn_add_members.setToolTipText("Ajouter une liste de membre");
        btn_add_members.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_membersActionPerformed(evt);
            }
        });

        btn_add_relation.setToolTipText("Relier deux documents");
        btn_add_relation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_relationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btn_addGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_addUserToGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_addObject, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add_members, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add_relation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_addGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_addUserToGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_addObject, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btn_add_members, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_add_relation, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        back_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable-mdpi/back.png"))); // NOI18N
        back_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logOutActionPerformed(evt);
            }
        });

        jLabel2.setText("Bonjour ");

        nomMembreActif.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(nomMembreActif, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelObjetContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back_label, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(nomMembreActif))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelObjetContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addGroupeActionPerformed
        new AjoutGroupe().setVisible(true);

    }//GEN-LAST:event_btn_addGroupeActionPerformed

    private void btn_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logOutActionPerformed
        this.setVisible(false);
        udsView.setVisible(true);
        panelObjetContent.removeAll();
    }//GEN-LAST:event_btn_logOutActionPerformed

    private void btn_addObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addObjectActionPerformed
        if (groupeListView.getSelectedValue() != null) {
            new AddObject().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez choisir un groupe svp!");
        }

    }//GEN-LAST:event_btn_addObjectActionPerformed

    private void btn_addUserToGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addUserToGroupeActionPerformed
        String nom = JOptionPane.showInputDialog(null, "Pseudo du membre");
        Membre membre = udsView.getUniversite().verifierSiMembreExiste(nom);
        Object oGroupe = groupeListView.getSelectedValue();
        if (membre != null) {
            if (oGroupe != null) {
                Groupe groupe = udsView.getUniversite().chercherGroupe(groupeListView.getSelectedValue().toString());
                groupe.ajouterMembre(membre);
                JOptionPane.showMessageDialog(null, "Membre bien ajouté");
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez sellectionner un groupe svp !");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Ce membre n'existe pas");
        }
    }//GEN-LAST:event_btn_addUserToGroupeActionPerformed

    private void btn_add_membersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_membersActionPerformed
        new AjouterMembreGroupe().setVisible(true);
    }//GEN-LAST:event_btn_add_membersActionPerformed

    private void btn_add_relationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_relationActionPerformed
        Object oGrp = NasManagerView.getInstance().getGroupeListView().getSelectedValue();
        if (oGrp != null) {
            new RelierDocument().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez choisir un groupe svp", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_add_relationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_label;
    private javax.swing.JButton btn_addGroupe;
    private javax.swing.JButton btn_addObject;
    private javax.swing.JButton btn_addUserToGroupe;
    private javax.swing.JButton btn_add_members;
    private javax.swing.JButton btn_add_relation;
    private javax.swing.JButton btn_logOut;
    private javax.swing.JList groupeListView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomMembreActif;
    private javax.swing.JPanel panelObjetContent;
    // End of variables declaration//GEN-END:variables

    private void setColor() {
        jPanel1.setBackground(Color.WHITE);
        jPanel2.setBackground(Color.WHITE);
        panelObjetContent.setBackground(Color.WHITE);
        jPanel4.setBackground(Color.WHITE);
        btn_addGroupe.setBackground(UdsView.color_blue);
        btn_addObject.setBackground(UdsView.color_blue);
        btn_addUserToGroupe.setBackground(UdsView.color_blue);
        back_label.setBackground(UdsView.color_blue);
        btn_add_members.setBackground(UdsView.color_blue);
        btn_add_relation.setBackground(UdsView.color_blue);
        
    }
    
}
