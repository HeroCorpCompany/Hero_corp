package com.herocorp.services.metier.groupes;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.Donjon;

public class GroupeRaidService {
    
    public static boolean verifierGroupe (GroupeRaid groupe) {
        // TODO : vérifier la taille du groupe
        return groupe.getTaille() == 10;
    }

    public static void allerDonjon (GroupeRaid groupe, Donjon donjon) {
        // TODO : changer la position du raid et de ses membres, mettre à jour le donjon
        groupe.setPosition(donjon);
    }

    public static void attaquerDonjon (GroupeRaid groupe) {
        // TODO : renvoyer vrai si la force du groupe est supérieure à celle du donjon, faux sinon
    }

    public static void ajouterChasseur (GroupeRaid groupe, Chasseur chasseur) {
        // TODO : ajouter le chasseur au groupe
        groupe.add(chasseur);
    } 

    public static void retirerChasseur (GroupeRaid groupe, Chasseur chasseur) {
        // TODO : retirer le chasseur du groupe
        groupe.remove(chasseur);
    }
}
