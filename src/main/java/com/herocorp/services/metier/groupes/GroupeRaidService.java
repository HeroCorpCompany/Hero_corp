package com.herocorp.services.metier.groupes;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;

public class GroupeRaidService {
    
    public static boolean verifierGroupe (GroupeRaid groupe) {
        // TODO : vérifier la taille du groupe
        return false;
    }

    public static void allerDonjon (GroupeRaid groupe) {
        // TODO : changer la position du raid et de ses membres, mettre à jour le donjon
    }

    public static void attaquerDonjon (GroupeRaid groupe) {
        // TODO : vérifier si le groupe bat le donjon, sinon le groupe meurt
    }

    public static void ajouterChasseur (GroupeRaid groupe, Chasseur chasseur) {
        // TODO : ajouter le chasseur au groupe
    } 

    public static void retirerChasseur (GroupeRaid groupe, Chasseur chasseur) {
        // TODO : retirer le chasseur du groupe
    }
}
