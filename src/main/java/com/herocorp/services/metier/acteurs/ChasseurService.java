package com.herocorp.services.metier.acteurs;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Guilde;

public class ChasseurService {
    
    public static void rejoindreGuilde (Chasseur chasseur, Guilde guilde) {
        // TODO : Ajouter la guilde au chasseur
    }

    public static void quitterGuilde (Chasseur chasseur, Guilde guilde) {
        // TODO : Retirer la guilde du chasseur
    }

    public static void rejoindreRaid (Chasseur chasseur, GroupeRaid groupe) {
        // TODO : ajouter le groupe de raid au chasseur
    }

    public static void quitterRaid (Chasseur chasseur, GroupeRaid groupe) {
        // TODO : retirer le raid du chasseur
    }

    public static void changerLieu (Chasseur chasseur, AbstractLieu lieu) {
        // TODO : ajouter le lieu au chasseur
    }

}
