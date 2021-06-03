package com.herocorp.services.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.groupes.GroupeRaidService;
import com.herocorp.services.metier.lieux.DonjonService;
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

        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        return world;
    }
}
