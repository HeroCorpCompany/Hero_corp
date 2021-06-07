package com.herocorp.services.game;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

public class WorldService {
    
    public static void updateTemps (World world) {
        int tempsActuel = world.getTemps();
        world.setTemps(tempsActuel + 1);
    }

    public static void updateWorld (World world) {
        UpdateChasseurs.updateChasseurs(world);
        UpdateGroupes.updateGroupes(world);
        UpdateGuildes.updateGuildes(world);
        WorldService.updateTemps(world);
        UpdateDonjons.updateDonjons(world);
    }


    public static boolean detruireDonjon (World world, Donjon donjonCible) {
        return world.supprimerDonjon(donjonCible);
    }

    public static boolean detruireGuilde (World world, Guilde guildeCible) {
        return world.supprimerGuilde(guildeCible);
    }

    public static boolean tuerChasseur (World world, Chasseur chasseurCible) {
        return world.supprimerChasseur(chasseurCible);
    }

    public static boolean detruireGroupe (World world, GroupeRaid groupeCible) {
        return world.supprimerGroupe(groupeCible);
    }

    public static void ajouterGroupe (World world, GroupeRaid groupe) {
        world.ajouterGroupe(groupe);
    }
}
