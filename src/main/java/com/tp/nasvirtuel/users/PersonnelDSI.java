/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.users;

import com.tp.nasvirtuel.Groupe;
import com.tp.nasvirtuel.services.Formation;

/**
 *
 * @author Yirou
 */
public class PersonnelDSI extends Personnel{

    public PersonnelDSI(String nom, Groupe groupeParDefaut) {
        super(nom, groupeParDefaut);
    }

    public void deployerMembres(Formation formation, Groupe groupe) {
        groupe.deployerMembres(formation);
    }
    
}
