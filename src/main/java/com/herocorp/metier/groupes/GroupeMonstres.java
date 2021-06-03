package com.herocorp.metier.groupes;

import java.util.ArrayList;
import java.util.Random;

import com.herocorp.metier.acteurs.AbstractActeur;

public class GroupeMonstres extends AbstractGroupe {
    

    public GroupeMonstres () {
        super ();
    }
    public double combatForce () {
        // TODO : Récuperer la force des membre du groupe et la renvoyer, peut se faire aussi dans la classe abstract groupe si même meca pour mobs et chasseurs
        ArrayList <AbstractActeur> mobs = this.getListe();
        int forceTot= 0;
        for(AbstractActeur monstre: mobs){
          forceTot+= monstre.getForce(); 
        }
        double forceMoy = forceTot/mobs.size();
        Random rnd = new Random();
        double randomParam = rnd.nextGaussian();
        return forceMoy + randomParam;
    }
}
