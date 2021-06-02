package com.herocorp.services.metier.lieux;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Guilde;

public class GuildeService {
    
    public static void ajouterChasseur (Guilde guilde, Chasseur chasseur) {
        guilde.addMembre(chasseur);
    }

    public static boolean retirerChasseur (Guilde guilde, Chasseur chasseur) {
        return guilde.removeMembre(chasseur);
    }

    public static void payerSalaires (Guilde guilde, Chasseur chasseur) {
        int size = guilde.getTaille();

        for(int i = 0; i < size; i++){
            guilde.setArgent(guilde.getArgent() - ((Chasseur) guilde.getMembres().getListe().get(i)).getSalaire());
        }
    }
}
