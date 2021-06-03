package com.herocorp.services.game;

import java.util.ArrayList;

import com.herocorp.game.World;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.lieux.GuildeService;
import com.herocorp.tools.Classe;


public class UpdateGuildes {
    
    public static void updateGuildes ( World world ) {
        ArrayList<Guilde> listeGuildes = world.getListeGuildes();
        for (int i = 0; i < listeGuildes.size(); i++) {
            if (listeGuildes.get(i).getArgent() < 0) {
                WorldService.detruireGuilde(world, listeGuildes.get(i));
                i--;
            }
            else {
                recrutement(world, listeGuildes.get(i));
            }
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
}
