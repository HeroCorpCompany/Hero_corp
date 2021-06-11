package com.herocorp.services.metier.lieux;

import java.sql.Connection;
import java.util.Random;

import com.herocorp.dao.GuildeDao;
import com.herocorp.dao.LieuDao;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Coord;

public class GuildeService {

    public static Guilde creerGuilde (Connection db) {
        Random rnd = new Random();
        int x = rnd.nextInt(28);
        int y = rnd.nextInt(24);
        Guilde guilde = new Guilde(new Coord(x, y));
        int randomArgent = rnd.nextInt(3000);
        guilde.setArgent(randomArgent + 10000);
        LieuDao.ajouterLieu(db, guilde);
        GuildeDao.ajouterGuilde(db, guilde);
        return guilde;
    }
    
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
