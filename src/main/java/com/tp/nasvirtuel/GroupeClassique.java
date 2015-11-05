/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel;

import com.tp.nasvirtuel.objets.FactoryObjet;
import com.tp.nasvirtuel.objets.TypeObjet;
import com.tp.nasvirtuel.users.Membre;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Yirou
 */
public class GroupeClassique extends GroupeInstitutionnel {

    private List<String> listeDefaultFolder = Arrays.asList("Cours", "TD", "TP");

    public GroupeClassique(int idGroupe, String nom, Membre auteur, int nombreAcces) {
        super(idGroupe, nom, auteur, nombreAcces);
    }

    public GroupeClassique() {

    }

    public void setListeDefaultFolder(List<String> listeDefaultFolder) {
        this.listeDefaultFolder = listeDefaultFolder;
    }

    public List<String> getListeDefaultFolder() {
        return listeDefaultFolder;
    }

    @Override
    public void genererFichier() {

    }

    @Override
    public void initialiserDossier() {
        FactoryObjet factoryObjet = FactoryObjet.getInstance();
        for (String document : listeDefaultFolder) {
            System.out.println("ajoute");
            listeObjets.add(factoryObjet.createObjet(document, TypeObjet.Repertoire, null));
        }
    }
}
