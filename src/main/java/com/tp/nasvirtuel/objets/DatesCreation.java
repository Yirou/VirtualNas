/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.nasvirtuel.objets;

import com.tp.nasvirtuel.users.Membre;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author yirou
 */
public class DatesCreation {
    private Date dateCreation;
    private Membre membreModifier;
    private Objet objetModifier;
    private Set<DatesCreation>datesModification=new HashSet<>();

    public DatesCreation(Date dateCreation, Membre membreModifier, Objet objetModifier) {
        this.dateCreation = dateCreation;
        this.membreModifier = membreModifier;
        this.objetModifier = objetModifier;
    }

    public Date getDateCreation() {
        return dateCreation;
    }
    

    public Set<DatesCreation> getDatesModification() {
        return datesModification;
    }

    public Membre getMembreModifier() {
        return membreModifier;
    }

    public Objet getObjetModifier() {
        return objetModifier;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDatesModification(Set<DatesCreation> datesModification) {
        this.datesModification = datesModification;
    }

    public void setMembreModifier(Membre membreModifier) {
        this.membreModifier = membreModifier;
    }

    public void setObjetModifier(Objet objetModifier) {
        this.objetModifier = objetModifier;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
}
