package com.herocorp.services.metier.acteurs;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Guilde;

public class ChasseurService {
    
    public static void rejoindreGuilde (Chasseur chasseur, Guilde guilde) {
        chasseur.setGuilde(guilde);
    }

    public static void quitterGuilde (Chasseur chasseur) {
        chasseur.setGuilde(null);
    }

    public static void rejoindreRaid (Chasseur chasseur, GroupeRaid groupe) {
        chasseur.setGroupe(groupe);
    }

    public static void quitterRaid (Chasseur chasseur) {
        chasseur.setGroupe(null);
    }

    public static void changerLieu (Chasseur chasseur, AbstractLieu lieu) {
        chasseur.setPosition(lieu);
    }

}
