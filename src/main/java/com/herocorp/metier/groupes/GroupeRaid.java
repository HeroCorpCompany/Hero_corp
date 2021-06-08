package com.herocorp.metier.groupes;

import java.util.ArrayList;

import com.herocorp.metier.acteurs.AbstractActeur;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

public class GroupeRaid extends GroupeChasseurs {

    private Guilde guilde = null;
    private Donjon cible = null;
    private int id = 0;
    
    public GroupeRaid () {
        super ();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean hasGuilde () {
        return this.guilde != null;
    }

    public void setGuilde (Guilde guilde) {
        this.guilde = guilde;
    }

    public Guilde getGuilde () {
        return this.guilde;
    }

    public boolean isPlein () {
        int size = this.getListe().size(); 
        return (size == 10);
    }

    public int combatForce () {
        // TODO : Récuperer la force des membre du groupe et la renvoyer, peut se faire aussi dans la classe abstract groupe si même meca pour mobs et chasseurs
        ArrayList <AbstractActeur> chasseurs = this.getListe();
        int forceTot= 0;
        for(AbstractActeur chasseur: chasseurs){
          forceTot+= chasseur.getForce(); 
        }
        int forceMoy = forceTot/chasseurs.size();
        return forceMoy;
    }

    public Donjon getCible () {
        return this.cible;
    }

    public void setCible (Donjon donjon) {
        this.cible = donjon;
    } 
}
