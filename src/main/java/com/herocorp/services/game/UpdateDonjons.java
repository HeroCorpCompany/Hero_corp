package com.herocorp.services.game;
import com.herocorp.game.World;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.services.metier.lieux.DonjonService;

import java.util.Random;

import java.util.ArrayList;

public class UpdateDonjons {
    public static void updateDonjons ( World world ) {
        ArrayList<Donjon> listeDonjons = world.getListeDonjons();
        if (listeDonjons.size() < world.getNbDonjonSeuils()) {
            genererDonjons(world);
        }
    }

    public static void genererDonjons (World world) {
        Random r = new Random();
        int newDJ = r.nextInt(6); 
        for (int i = 0; i < newDJ; i++){
            Donjon donjon = DonjonService.creerDonjon(world.getDb());
            world.ajouterDonjon(donjon);
        };
    }
}
