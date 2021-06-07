package com.herocorp.services.game;

import java.util.ArrayList;
import java.util.Random;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.groupes.GroupeRaidService;
import com.herocorp.services.metier.lieux.ForumService;
import com.herocorp.services.metier.lieux.GuildeService;
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

public class UpdateChasseurs {
    
    public static void updateChasseurs (World world) {
        ArrayList <Chasseur> listeChasseursASupprimer = new ArrayList<>();
        int nbEnfants = 0;
        for (Chasseur chasseur : world.getListeChasseurs()) {
            if (chasseur.getAge() >= 150) {
                listeChasseursASupprimer.add(chasseur);
            } 
            
            else {
                if(chasseur.getAge() >= 10)
                {
                    Random rnd = new Random();
                    if (rnd.nextDouble() <0.5){
                        nbEnfants +=1;
                    };
                }
                if (chasseur.getClasse() == Classe.CITOYEN) {
                    if (chasseur.getAge() >= 5) {
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
                                ChasseurService.rejoindreGuilde(chasseur, guilde);
                                GuildeService.ajouterChasseur(guilde, chasseur);
                                guilde.setRecrute(false);
                            } else {
                                GroupeRaid groupe = groupeDispo(world);
                                if (groupe != null) {
                                    GroupeRaidService.ajouterChasseur(groupe, chasseur);
                                    ChasseurService.rejoindreRaid(chasseur, groupe);
                                } else {
                                    Donjon donjon = donjonLibre(world);
                                    if (donjon != null) {
                                        GroupeRaid newGroupe = new GroupeRaid();
                                        newGroupe.setCible(donjon);
                                        donjon.setGroupeRaid(newGroupe);
                                        ChasseurService.rejoindreRaid(chasseur, newGroupe);
                                        GroupeRaidService.ajouterChasseur(newGroupe, chasseur);
                                        WorldService.ajouterGroupe(world, newGroupe);
                                        newGroupe.setPosition(chasseur.getPosition());
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
                                    GroupeRaidService.ajouterChasseur(groupe, chasseur);
                                    ChasseurService.rejoindreRaid(chasseur, groupe);
                                } else {
                                    Donjon donjon = donjonLibre(world);
                                    if (donjon != null) {
                                        GroupeRaid newGroupe = new GroupeRaid();
                                        newGroupe.setCible(donjon);
                                        donjon.setGroupeRaid(newGroupe);
                                        GroupeRaidService.ajouterChasseur(newGroupe, chasseur);
                                        ChasseurService.rejoindreRaid(chasseur, newGroupe);
                                        chasseur.getGuilde().ajouterGroupe(newGroupe);
                                        newGroupe.setGuilde(chasseur.getGuilde());
                                        newGroupe.setPosition(chasseur.getPosition());
                                    } else {
                                        // Attendre, TODO : potentiellement quitter la guilde !
                                    }
                                }
                            }
                        } else {
                            GuildeService.retirerChasseur((Guilde) chasseur.getPosition(), chasseur);
                            ChasseurService.changerLieu(chasseur, world.getLieu("Forum"));
                            ForumService.ajouterChasseur((Forum) world.getLieu("Forum"), chasseur);
                        }
                    } else if (chasseur.getPosition().getClass().isInstance(new Donjon(new Coord(0, 0)))) {
                        // Attendre
                    }
                }
            }
        }
        supprimerChasseurs(world, listeChasseursASupprimer);
        naissanceChasseurs(world,nbEnfants);
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
        Chasseur chasseur = new Chasseur("Souli");
        for (int i = 0; i < nbEnfants; i++) {
            world.ajouterChasseur(chasseur);
        }
    }
}
