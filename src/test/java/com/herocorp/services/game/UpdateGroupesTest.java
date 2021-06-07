package com.herocorp.services.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.AbstractActeur;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.groupes.GroupeRaidService;
import com.herocorp.services.metier.lieux.DonjonService;
import com.herocorp.services.metier.lieux.GuildeService;
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class UpdateGroupesTest {
    
    @Test
    public void testNonOui () {
        // NonOui => Pas dans un donjon, mais complet, donc le groupe doit se déplacer dans le donjon !
        // INIT
        World world = genererWorld();
        Donjon donjon = world.getListeDonjons().get(0);
        GroupeRaid groupe = new GroupeRaid();
        groupe.setPosition(world.getLieu("Forum"));
        groupe.setCible(donjon);
        for (int i = 0; i < 10; i++) {
            Chasseur chasseur = world.getListeChasseurs().get(i);
            ChasseurService.changerLieu(chasseur, world.getLieu("Forum"));
            GroupeRaidService.ajouterChasseur(groupe, chasseur);
            ChasseurService.rejoindreRaid(chasseur, groupe);
        }
        WorldService.ajouterGroupe(world, groupe);

        UpdateGroupes.updateGroupes(world);
        // RES
        AbstractLieu resultat = world.getListeGroupes().get(0).getPosition();
        // TEST
        assertEquals(donjon, resultat);
    }

    @Test
    public void testNonNon () {
        // NonNon => Pas dans un donjon et pas plein, donc le groupe attend.
        // INIT
        World world = genererWorld();
        Donjon donjon = world.getListeDonjons().get(0);
        GroupeRaid groupe = new GroupeRaid();
        groupe.setPosition(world.getLieu("Forum"));
        groupe.setCible(donjon);
        for (int i = 0; i < 9; i++) {
            Chasseur chasseur = world.getListeChasseurs().get(i);
            ChasseurService.changerLieu(chasseur, world.getLieu("Forum"));
            GroupeRaidService.ajouterChasseur(groupe, chasseur);
            ChasseurService.rejoindreRaid(chasseur, groupe);
        }
        WorldService.ajouterGroupe(world, groupe);

        UpdateGroupes.updateGroupes(world);
        // RES
        AbstractLieu resultat = world.getListeGroupes().get(0).getPosition();
        // TEST
        assertEquals(world.getLieu("Forum"), resultat);
    }

    @Test
    public void testOuiNon () {
        // OuiNon => Le groupe est dans un donjon et perd le combat, le groupe meurt.
        // INIT
        World world = genererWorld();
        int populationInitiale = world.getListeChasseurs().size();
        Donjon donjon = world.getListeDonjons().get(0);
        GroupeRaid groupe = new GroupeRaid();
        groupe.setPosition(donjon);
        groupe.setCible(donjon);
        for (int i = 0; i < 10; i++) {
            Chasseur chasseur = world.getListeChasseurs().get(i);
            chasseur.setClasse(Classe.CITOYEN);
            ChasseurService.changerLieu(chasseur, donjon);
            GroupeRaidService.ajouterChasseur(groupe, chasseur);
            ChasseurService.rejoindreRaid(chasseur, groupe);
        }
        WorldService.ajouterGroupe(world, groupe);

        UpdateGroupes.updateGroupes(world);
        // RES
        int resultat1 = world.getListeChasseurs().size();
        int resultat2 = world.getListeGroupes().size();
        // TEST
        assertEquals(populationInitiale - 10, resultat1);
        assertEquals(0, resultat2);
    }

    @Test
    public void testOuiOuiNon () {
        // OuiOuiNon => Le groupe est dans un donjon, gagne le combat mais ne sont pas une guilde donc l'argent est réparti.
        // INIT
        World world = genererWorld();
        Donjon donjon = world.getListeDonjons().get(0);
        int argentTotal = 0;
        for (AbstractActeur monstre : donjon.getGroupeMonstres().getListe()) {
            argentTotal += monstre.getClasse().getRecompense();
        }
        GroupeRaid groupe = new GroupeRaid();
        groupe.setPosition(donjon);
        groupe.setCible(donjon);
        for (int i = 0; i < 10; i++) {
            Chasseur chasseur = world.getListeChasseurs().get(i);
            chasseur.setClasse(Classe.S);
            ChasseurService.changerLieu(chasseur, donjon);
            GroupeRaidService.ajouterChasseur(groupe, chasseur);
            ChasseurService.rejoindreRaid(chasseur, groupe);
        }
        WorldService.ajouterGroupe(world, groupe);

        UpdateGroupes.updateGroupes(world);
        // RES
        Chasseur chasseur = (Chasseur) groupe.get(0);
        int resultat = chasseur.getArgent();
        // TEST
        assertEquals(argentTotal/10, resultat);
    }

    @Test
    public void testOuiOuiOUi () {
        // OuiOuiOui => Le groupe est dans un donjon, gagne le combat et sont dans une guilde donc l'argent va à la guilde.
        // INIT
        World world = genererWorld();
        Donjon donjon = world.getListeDonjons().get(0);
        Guilde guilde = world.getListeGuildes().get(0);
        guilde.setArgent(0);
        int argentTotal = 0;
        for (AbstractActeur monstre : donjon.getGroupeMonstres().getListe()) {
            argentTotal += monstre.getClasse().getRecompense();
        }
        GroupeRaid groupe = new GroupeRaid();
        groupe.setGuilde(guilde);
        groupe.setPosition(donjon);
        groupe.setCible(donjon);
        for (int i = 0; i < 10; i++) {
            Chasseur chasseur = world.getListeChasseurs().get(i);
            chasseur.setClasse(Classe.S);
            ChasseurService.changerLieu(chasseur, donjon);
            GroupeRaidService.ajouterChasseur(groupe, chasseur);
            ChasseurService.rejoindreRaid(chasseur, groupe);
            ChasseurService.rejoindreGuilde(chasseur, guilde);
            GuildeService.ajouterChasseur(guilde, chasseur);
        }
        WorldService.ajouterGroupe(world, groupe);

        UpdateGroupes.updateGroupes(world);
        // RES
        int resultat = guilde.getArgent();
        // TEST
        assertEquals(argentTotal, resultat);

    }


    public World genererWorld () {
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        Forum forum = new Forum(new Coord(0, 0));
        mapLieux.put("Forum", forum);
        for (int i = 0; i < 10; i++) {
            Donjon donjon = new Donjon(new Coord(0, 0));
            DonjonService.remplirDonjon(donjon);
            listeDonjons.add(donjon);
        }
        for (int i = 0; i < 90; i++) {
            Chasseur chasseur = new Chasseur("Souli");
            ChasseurService.attribuerClasse(chasseur);
            ChasseurService.changerLieu(chasseur, forum);
            listeChasseurs.add(chasseur);
        }
        Guilde guilde = new Guilde(new Coord(0, 0));
        listeGuildes.add(guilde);

        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        return world;
    }
}
