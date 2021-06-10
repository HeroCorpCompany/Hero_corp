package com.herocorp.services.game;

import java.util.ArrayList;
import java.util.Random;

import com.herocorp.dao.ChasseurDao;
import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.groupes.GroupeRaidService;
import com.herocorp.services.metier.lieux.ForumService;
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

public class UpdateChasseurs {
    
    public static void updateChasseurs (World world) {
        ArrayList <Chasseur> listeChasseursASupprimer = new ArrayList<>();
        int nbEnfants = 0;
        for (Chasseur chasseur : world.getListeChasseurs()) {
            if (chasseur.getAge() >= world.getAgeChasseurMort()) {
                listeChasseursASupprimer.add(chasseur);
            } 
            
            else {
                if(chasseur.getAge() >= world.getAgeChasseurReproduction())
                {
                    Random rnd = new Random();
                    if (rnd.nextDouble() <world.getChanceReproduction()){
                        nbEnfants +=1;
                    };
                };
                if (chasseur.getClasse() == Classe.CITOYEN) {
                    if (chasseur.getAge() >= world.getAgeChasseurClasse()) {
                        ChasseurService.attribuerClasse(chasseur);
                    } else {
                        // Attendre
                    }
                } else {
                    if (chasseur.getPosition() == world.getLieu("Forum")) {
                        if (chasseur.isInGroupe()) {
                            // Attendre
                        } else {
                            Guilde guilde = guildeRecrute(world);
                            if (guilde != null) {
                                WorldService.ajouterChasseurGuilde(world, chasseur, guilde);
                            } else {
                                GroupeRaid groupe = groupeDispo(world);
                                if (groupe != null) {
                                    WorldService.ajouterChasseurGroupe(world, chasseur, groupe);
                                } else {
                                    Donjon donjon = donjonLibre(world);
                                    if (donjon != null) {
                                        GroupeRaid newGroupe = GroupeRaidService.creerGroupe(world.getDb(), donjon, chasseur.getPosition(), null);
                                        donjon.setGroupeRaid(newGroupe);
                                        WorldService.ajouterChasseurGroupe(world, chasseur, newGroupe);
                                        WorldService.ajouterGroupe(world, newGroupe);
                                    } else {
                                        // Attendre
                                    }
                                }
                            }
                        }
                    } else if (chasseur.getPosition().getClass().isInstance(new Guilde(new Coord(0, 0)))) {
                        if (chasseur.isInGuilde()) {
                            if (chasseur.isInGroupe()) {
                                // Attendre
                            } else {
                                GroupeRaid groupe = groupeDispoGuilde(chasseur.getGuilde());
                                if (groupe != null) {
                                    WorldService.ajouterChasseurGroupe(world, chasseur, groupe);
                                } else {
                                    Donjon donjon = donjonLibre(world);
                                    if (donjon != null) {
                                        GroupeRaid newGroupe = GroupeRaidService.creerGroupe(world.getDb(), donjon, chasseur.getPosition(), chasseur.getGuilde());
                                        donjon.setGroupeRaid(newGroupe);
                                        WorldService.ajouterChasseurGroupe(world, chasseur, newGroupe);
                                        chasseur.getGuilde().ajouterGroupe(newGroupe);
                                    } else {
                                        // Attendre, TODO : potentiellement quitter la guilde !
                                    }
                                }
                            }
                        } else {
                            ChasseurService.changerLieu(chasseur, world.getLieu("Forum"));
                            ForumService.ajouterChasseur((Forum) world.getLieu("Forum"), chasseur);
                        }
                    } else if (chasseur.getPosition().getClass().isInstance(new Donjon(new Coord(0, 0)))) {
                        // Attendre
                    }
                }
            }
            ChasseurDao.majChasseur(world.getDb(), chasseur);
        }
        naissanceChasseurs(world,nbEnfants);
        supprimerChasseurs(world, listeChasseursASupprimer);
        
    }

    public static Guilde guildeRecrute (World world) {
        for (Guilde guilde : world.getListeGuildes()) {
            if (guilde.isRecruting()) {
                return guilde;
            }
        }
        return null;
    }

    public static GroupeRaid groupeDispo (World world) {
        for (GroupeRaid groupe : world.getListeGroupes()) {
            if (GroupeRaidService.verifierGroupe(groupe) == false) {
                return groupe;
            }
        }
        return null;
    }

    public static Donjon donjonLibre (World world) {
        for (Donjon donjon : world.getListeDonjons()) {
            if (donjon.getGroupeRaid() == null) {
                return donjon;
            }
        }
        return null;
    }

    public static GroupeRaid groupeDispoGuilde (Guilde guilde) {
        for (GroupeRaid groupe : guilde.getListeGroupes()) {
            if (GroupeRaidService.verifierGroupe(groupe) == false) {
                return groupe;
            }
        }
        return null;
    }

    public static void supprimerChasseurs (World world, ArrayList <Chasseur> listeChasseursASupprimer) {
        for (Chasseur chasseur : listeChasseursASupprimer) {
            WorldService.tuerChasseur(world, chasseur);
        }
    }

    public static void naissanceChasseurs (World world, int nbEnfants) {
        Forum forum = (Forum) world.getLieu("Forum");
        for (int i = 0; i < nbEnfants; i++) {
            Chasseur chasseur = ChasseurService.creerChasseur(world.getDb(), "Souli", forum);
            WorldService.ajouterChasseur(world,chasseur);
        }
    }
}
