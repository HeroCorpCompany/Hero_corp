package com.herocorp.metier.groupes;

import java.util.ArrayList;

import com.herocorp.metier.acteurs.AbstractActeur;

public class GroupeRaid extends GroupeChasseurs {
    
    public GroupeRaid () {
        super ();
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
