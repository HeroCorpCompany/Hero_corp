package com.herocorp.metier.groupes;

public class GroupeMonstres extends AbstractGroupe {
    

    public GroupeMonstres () {
        super ();
    }
    public int combatForce () {
        // TODO : Récuperer la force des membre du groupe et la renvoyer, peut se faire aussi dans la classe abstract groupe si même meca pour mobs et chasseurs
        mobs = this.getListe();
        int forceTot= 0;
        for(Monstre monstre: mobs){
          forceTot+= monstre.getForce(); 
        }
        int forceMoy = forceTot/mobs.size();
        int randomParam = Math.random() * (2 - 0.5) + 0.5
        return forceMoy*randomParam;
    }
}
