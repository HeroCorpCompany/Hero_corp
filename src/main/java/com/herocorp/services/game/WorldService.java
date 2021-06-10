package com.herocorp.services.game;

import com.herocorp.dao.ChasseurDao;
import com.herocorp.dao.GroupeDao;
import com.herocorp.dao.GuildeDao;
import com.herocorp.dao.LieuDao;
import com.herocorp.dao.WorldDao;
import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.groupes.GroupeRaidService;
import com.herocorp.services.metier.lieux.GuildeService;

public class WorldService {
    
    public static void updateTemps (World world) {
        int tempsActuel = world.getTemps();
        world.setTemps(tempsActuel + 1);
        for (Chasseur chasseur : world.getListeChasseurs()) {
            chasseur.setAge(chasseur.getAge()+1);
        }
    }

    public static void updateWorld (World world) {
        UpdateChasseurs.updateChasseurs(world);
        UpdateGroupes.updateGroupes(world);
        UpdateGuildes.updateGuildes(world);
        WorldService.updateTemps(world);
        UpdateDonjons.updateDonjons(world);
        WorldDao.majStats(world.getDb(), world);
    }


    public static boolean detruireDonjon (World world, Donjon donjonCible) {
        LieuDao.supprimerLieu(world.getDb(), donjonCible);
        return world.supprimerDonjon(donjonCible);
    }

    public static boolean detruireGuilde (World world, Guilde guildeCible) {
        LieuDao.supprimerLieu(world.getDb(), guildeCible);
        return world.supprimerGuilde(guildeCible);
    }

    public static boolean tuerChasseur (World world, Chasseur chasseurCible) {
        ChasseurDao.supprimerChasseur(world.getDb(), chasseurCible);
        return world.supprimerChasseur(chasseurCible);
    }

    public static boolean ajouterChasseur (World world, Chasseur chasseurCible) {
        return world.ajouterChasseur(chasseurCible);
    }

    public static boolean detruireGroupe (World world, GroupeRaid groupeCible) {
        GroupeDao.supprimerGroupe(world.getDb(), groupeCible);
        return world.supprimerGroupe(groupeCible);
    }

    public static void ajouterGroupe (World world, GroupeRaid groupe) {
        world.ajouterGroupe(groupe);
    }

    public static void ajouterChasseurGuilde(World world, Chasseur chasseur, Guilde guilde) {
        ChasseurService.rejoindreGuilde(chasseur, guilde);
        GuildeService.ajouterChasseur(guilde, chasseur);
        guilde.setRecrute(false);
        ChasseurDao.ajouterChasseurGuilde(world.getDb(), chasseur);
    }

    public static void ajouterChasseurGroupe(World world, Chasseur chasseur, GroupeRaid groupe) {
        GroupeRaidService.ajouterChasseur(groupe, chasseur);
        ChasseurService.rejoindreRaid(chasseur, groupe);
        ChasseurDao.ajouterChasseurGroupe(world.getDb(), chasseur);
    }

    public static void recompenseGuilde(World world, Guilde guilde, int argent) {
        guilde.setArgent(guilde.getArgent() + argent);
        GuildeDao.majGuilde(world.getDb(), guilde);
    }

    public static void recompenseChasseur(World world, Chasseur chasseur, int argent) {
        chasseur.agmenterArgent(argent);
        ChasseurDao.majChasseur(world.getDb(), chasseur);
    }

    public static void retirerChasseurGroupe(World world, Chasseur chasseur) {
        ChasseurService.quitterRaid(chasseur);
        ChasseurDao.majChasseur(world.getDb(), chasseur);
    }

    public static void guildePayeChasseur(World world, Chasseur chasseur, Guilde guilde) {
        guilde.setArgent(guilde.getArgent() - chasseur.getSalaire());
        chasseur.setArgent(chasseur.getArgent() + chasseur.getSalaire());
        ChasseurDao.majChasseur(world.getDb(), chasseur);
    }
}
