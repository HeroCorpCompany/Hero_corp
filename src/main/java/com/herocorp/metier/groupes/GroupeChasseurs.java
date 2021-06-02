package com.herocorp.metier.groupes;

public class GroupeChasseurs extends AbstractGroupe {

    public GroupeChasseurs () {
        super ();
    }

    public int getTaille () {
        return this.liste.size();
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
