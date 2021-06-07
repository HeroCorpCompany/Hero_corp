package com.herocorp.services.metier.acteurs;

import java.util.Random;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Classe;

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

    public static void attribuerClasse (Chasseur chasseur) {
        Classe classe = null;
        Random rnd = new Random();
        int randomInt = rnd.nextInt(100);

        if (randomInt < 35) {
            classe = Classe.D;
        } else if (randomInt < 60) {
            classe = Classe.C;
        } else if (randomInt < 80) {
            classe = Classe.B;
        } else if (randomInt < 95) {
            classe = Classe.A;
        } else {
            classe = Classe.S;
        }
        chasseur.setClasse(classe);
    }

}
