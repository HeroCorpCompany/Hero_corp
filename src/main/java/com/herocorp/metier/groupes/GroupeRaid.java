package com.herocorp.metier.groupes;

import java.util.ArrayList;

import com.herocorp.metier.acteurs.AbstractActeur;
import com.herocorp.metier.lieux.Guilde;

public class GroupeRaid extends GroupeChasseurs {

    private Guilde guilde = null;
    
    public GroupeRaid () {
        super ();
    }

    public boolean hasGuilde () {
        return this.guilde != null;
    }

    public void setGuilde (Guilde guilde) {
        this.guilde = guilde;
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
}
