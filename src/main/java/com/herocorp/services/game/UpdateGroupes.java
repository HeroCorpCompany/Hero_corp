package com.herocorp.services.game;

import java.util.ArrayList;

import com.herocorp.dao.ChasseurDao;
import com.herocorp.dao.GroupeDao;
import com.herocorp.dao.GuildeDao;
import com.herocorp.game.World;
import com.herocorp.metier.acteurs.AbstractActeur;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.groupes.GroupeRaidService;
import com.herocorp.services.metier.lieux.ForumService;
import com.herocorp.services.metier.lieux.GuildeService;
import com.herocorp.tools.Coord;

public class UpdateGroupes {

    public static void updateGroupes ( World world ) {
        // TODO : voir arbre groupes
        ArrayList <GroupeRaid> listeGroupesASupprimer = new ArrayList<>();
        ArrayList <Chasseur> listeChasseursASupprimer = new ArrayList<>();
        ArrayList <Donjon> listeDonjonsASupprimer = new ArrayList<>();
        for (GroupeRaid groupe : world.getListeGroupes()) {
            if (groupe.getPosition().getClass().isInstance(new Donjon(new Coord(0, 0)))) {
                if (groupe.combatForce() >= groupe.getCible().getGroupeMonstres().combatForce()) {
                    int argent = 0;
                        for (AbstractActeur acteur : groupe.getCible().getGroupeMonstres().getListe()) {
                            Monstre monstre = (Monstre) acteur;
                            argent += monstre.getClasse().getRecompense();
                        }
                    if (groupe.hasGuilde()) {
                        groupe.getGuilde().setArgent(groupe.getGuilde().getArgent() + argent);
                        GuildeDao.majGuilde(world.getDb(), groupe.getGuilde());
                    } else {
                        for (AbstractActeur acteur : groupe.getListe()) {
                            Chasseur chasseur = (Chasseur) acteur;
                            chasseur.agmenterArgent(argent / groupe.getListe().size());
                            ChasseurDao.majChasseur(world.getDb(), chasseur);
                        }
                    }
                    for (AbstractActeur acteur : groupe.getListe()) {
                        Chasseur chasseur = (Chasseur) acteur;
                        if (chasseur.isInGuilde()) {
                            ChasseurService.changerLieu(chasseur, chasseur.getGuilde());
                        } else {
                            ChasseurService.changerLieu(chasseur, world.getLieu("Forum"));
                            ForumService.ajouterChasseur((Forum)world.getLieu("Forum"), chasseur);
                        }
                        ChasseurService.quitterRaid(chasseur);
                        ChasseurDao.majChasseur(world.getDb(), chasseur);
                    }
                    listeGroupesASupprimer.add(groupe);
                    listeDonjonsASupprimer.add(groupe.getCible());
                } else {
                    for (AbstractActeur acteur : groupe.getListe()) {
                        Chasseur chasseur = (Chasseur)acteur;
                        listeChasseursASupprimer.add(chasseur);
                        if (chasseur.getGuilde() != null) {
                            GuildeService.retirerChasseur(chasseur.getGuilde(), chasseur);
                        }
                    }
                    Donjon donjon = groupe.getCible();
                    donjon.setGroupeRaid(null);
                    listeGroupesASupprimer.add(groupe);
                }

            } else {
                if (GroupeRaidService.verifierGroupe(groupe)) {
                    GroupeRaidService.allerDonjon(groupe, groupe.getCible());
                    for (AbstractActeur chasseur : groupe.getListe()) {
                        ChasseurService.changerLieu((Chasseur)chasseur, groupe.getCible());
                        ChasseurDao.majChasseur(world.getDb(), (Chasseur)chasseur);
                    }
                } else {
                    // Attendre
                }
            }
            GroupeDao.majGroupe(world.getDb(), groupe);
        }
        supprimerChasseurs(world, listeChasseursASupprimer);
        supprimerDonjons(world, listeDonjonsASupprimer);
        supprimerGroupes(world, listeGroupesASupprimer);
    }

    public static void supprimerGroupes (World world, ArrayList <GroupeRaid> listeGroupesASupprimer) {
        for (GroupeRaid groupe : listeGroupesASupprimer) {
            WorldService.detruireGroupe(world, groupe);
        }
    }

    public static void supprimerDonjons (World world, ArrayList <Donjon> listeDonjonsASupprimer) {
        for (Donjon donjon : listeDonjonsASupprimer) {
            WorldService.detruireDonjon(world, donjon);
        }
    }

    public static void supprimerChasseurs (World world, ArrayList <Chasseur> listeChasseursASupprimer) {
        for (Chasseur chasseur : listeChasseursASupprimer) {
            WorldService.tuerChasseur(world, chasseur);
        }
    }
    
}
