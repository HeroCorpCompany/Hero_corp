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
        WorldService.updateChasseurs(world);
        WorldService.updateGroupes(world);
        WorldService.updateGuildes(world);
        WorldService.updateTemps(world);
    }

    public static void updateChasseurs (World world) {
        // TODO : update de tous les chasseurs du monde : Voir arbre de décision des chasseurs
        for (Chasseur chasseur : world.getListeChasseurs()) {

        }
    }

    public static void updateGroupes (World world) {
        // TODO : update de tous les groupes de raid : Voir arbre de décision des groupes
        // TODO : ajouter la gestion et la sauvegarde des groupes dans la classe World
    }

    public static void updateGuildes (World world) {
        // TODO : update de toutes les guildes : Voir arbre de décision des guildes
        for (Guilde guilde : world.getListeGuildes()) {

        }
    }

    public static void genererDonjons (World world) {
        // TODO : générer un nombre aléatoire de donjons et les ajouter à la liste des donjons
    }

    public static boolean detruireDonjon (World world, Donjon donjonCible) {
        return world.getListeDonjons().remove(donjonCible);
    }

    public static boolean detruireGuilde (World world, Guilde guildeCible) {
        return world.getListeGuildes().remove(guildeCible);
    }

    public static boolean tuerChasseur (World world, Chasseur chasseurCible) {
        return world.getListeChasseurs().remove(chasseurCible);
    }
}
