package com.herocorp.services.game;

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
                    } else {
                        for (AbstractActeur acteur : groupe.getListe()) {
                            Chasseur chasseur = (Chasseur) acteur;
                            chasseur.agmenterArgent(argent / groupe.getListe().size());
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
                    }
                    WorldService.detruireGroupe(world, groupe);
                    WorldService.detruireDonjon(world, groupe.getCible());
                } else {
                    for (AbstractActeur acteur : groupe.getListe()) {
                        Chasseur chasseur = (Chasseur)acteur;
                        WorldService.tuerChasseur(world, chasseur);
                        GuildeService.retirerChasseur(chasseur.getGuilde(), chasseur);
                    }
                    WorldService.detruireGroupe(world, groupe);
                }

            } else {
                if (GroupeRaidService.verifierGroupe(groupe)) {
                    GroupeRaidService.allerDonjon(groupe, groupe.getCible());
                    for (AbstractActeur chasseur : groupe.getListe()) {
                        ChasseurService.changerLieu((Chasseur)chasseur, groupe.getCible());
                    }
                } else {
                    // Attendre
                }
            }
        }
    }
    
}
