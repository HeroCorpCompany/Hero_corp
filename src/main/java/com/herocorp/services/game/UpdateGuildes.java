package com.herocorp.services.game;

import java.util.ArrayList;
import java.util.Random;

import com.herocorp.dao.GuildeDao;
import com.herocorp.game.World;
import com.herocorp.metier.acteurs.AbstractActeur;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.lieux.GuildeService;
import com.herocorp.tools.Classe;

public class UpdateGuildes {
    
    public static void updateGuildes ( World world ) {
        ArrayList<Guilde> listeGuildes = world.getListeGuildes();
        if (listeGuildes.size() < world.getNbGuildeSeuil()) {
            genererGuildes(world);
        }
        for (int i = 0; i < listeGuildes.size(); i++) {
            Guilde guilde = listeGuildes.get(i);
            if (guilde.getArgent() < 0) {
                WorldService.detruireGuilde(world, guilde);
                i--;
            }
            else {
                if (world.getTemps()%20 == 0) {
                    for (AbstractActeur acteur : guilde.getMembres().getListe()) {
                        Chasseur chasseur = (Chasseur) acteur;
                        WorldService.guildePayeChasseur(world, chasseur, guilde);
                    }
                }
                recrutement(world, guilde);
            }
            GuildeDao.majGuilde(world.getDb(), guilde);
        }
    }

    public static void recrutement ( World world, Guilde guilde ) {
        if (guilde.getArgent() - (GuildeService.montantAPayer(guilde) + Classe.S.getSalaire()) >= 0) {
            guilde.setRecrute(true);
        }
        else {
            guilde.setRecrute(false);
        }
    }


    public static void genererGuildes (World world) {
        Random r = new Random();
        int newGuilde = r.nextInt(6); 
        for (int i = 0; i < newGuilde; i++){
            Guilde guilde = GuildeService.creerGuilde(world.getDb());
            world.ajouterGuilde(guilde);
        };
    }
}
