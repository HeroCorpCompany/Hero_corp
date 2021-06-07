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
        int number = rnd.nextInt(5);
        switch ( number ) {
            case 0:
                classe = Classe.D;
                break;
            case 1:
                classe = Classe.C;
                break;
            case 2:
                classe = Classe.B;
                break;
            case 3:
                classe = Classe.A;
                break;
            case 4:
                classe = Classe.S;
                break;
            default:
                classe = Classe.D;
        }
        chasseur.setClasse(classe);
    }

}
