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

    public static void payerSalaires (Guilde guilde) {
        int size = guilde.getTaille();
        for(int i = 0; i < size; i++){
            int salaire = ((Chasseur) guilde.getMembres().get(i)).getSalaire();
            guilde.setArgent(guilde.getArgent() - salaire);
            ((Chasseur) guilde.getMembres().get(i)).agmenterArgent(salaire);
        }
    }

    public static int montantAPayer (Guilde guilde) {
        int size = guilde.getTaille();
        int montant = 0;
        for(int i = 0; i < size; i++){
            int salaire = ((Chasseur) guilde.getMembres().get(i)).getSalaire();
            montant += salaire;
        }
        return montant;
    }
}
