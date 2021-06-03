package com.herocorp.services.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class WorldServiceTest
{

    @Test
    public void testUpdateTemps () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        WorldService.updateTemps(world);
        int attendu = 1;
        // RES
        int resultat = world.getTemps();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testUpdateWorld () {
        // TODO : Générer un monde et le simuler pendant un tour
        assertTrue(false);
    }

    @Test
    public void testDetruireDonjon () {
        // INIT
        Donjon donjon = new Donjon(new Coord(0, 0));
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        world.getListeDonjons().add(donjon);
        // RES
        boolean resultat = WorldService.detruireDonjon(world, donjon);
        // TEST
        assertTrue(resultat);
    }

    @Test
    public void testDetruireGuilde () {
        // INIT
        Guilde guilde = new Guilde(new Coord(0, 0));
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        world.getListeGuildes().add(guilde);
        // RES
        boolean resultat = WorldService.detruireGuilde(world, guilde);
        // TEST
        assertTrue(resultat);
    }

    @Test
    public void testDetruireGroupe () {
        // INIT
        GroupeRaid groupe = new GroupeRaid();
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        world.getListeGroupes().add(groupe);
        // RES
        boolean resultat = WorldService.detruireGroupe(world, groupe);
        // TEST
        assertTrue(resultat);
    }

    @Test
    public void testTuerChasseur () {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        world.getListeChasseurs().add(chasseur);
        // RES
        boolean resultat = WorldService.tuerChasseur(world, chasseur);
        // TEST
        assertTrue(resultat);
    }
}

