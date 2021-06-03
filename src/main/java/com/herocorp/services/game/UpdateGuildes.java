package com.herocorp.services.game;

import java.util.ArrayList;

import com.herocorp.game.World;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.lieux.GuildeService;


public class UpdateGuildes {
    
    public static void updateGuildes ( World world ) {
        ArrayList<Guilde> listeGuildes = world.getListeGuildes();
        for (int i = 0; i < listeGuildes.size(); i++) {
            updateGuild(world, listeGuildes.get(i));
        }
    }

    public static void updateGuild ( World world, Guilde guilde ) {
        if (guilde.getArgent() < 0) {
            recrutement(world, guilde);
        }
        else {
            world.supprimerGuilde(guilde);
        }
    }

    public static void recrutement ( World world, Guilde guilde ) {
        if (guilde.getArgent() - (2*GuildeService.montantAPayer(guilde) + 5000) >= 0) {
            guilde.setRecrute(true);
        }
        else {
            guilde.setRecrute(false);
        }
    }
}
