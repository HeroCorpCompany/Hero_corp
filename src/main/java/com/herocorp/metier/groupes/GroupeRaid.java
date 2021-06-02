package com.herocorp.metier.groupes;

public class GroupeRaid extends GroupeChasseurs {
    
    public GroupeRaid () {
        super ();
    }

    public boolean isPlein () {
        size = this.liste.size(); 
        return (size.equals(10));
    }

    public int combatForce () {
        // TODO : Récuperer la force des membre du groupe et la renvoyer, peut se faire aussi dans la classe abstract groupe si même meca pour mobs et chasseurs
        chasseurs = this.getListe();
        int forceTot= 0;
        for(Chasseur chasseur: chasseurs){
          forceTot+= chasseur.getForce(); 
        }
        int forceMoy = forceTot/chasseurs.size();
        return forceMoy;
    }
}
