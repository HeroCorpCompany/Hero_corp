package com.herocorp.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

import org.junit.Test;

public class WorldTest
{
    @Test
    public void testTemps () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        int attendu = 30;
        world.setTemps(attendu);
        // RES
        int resultat = world.getTemps();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGetListeChasseurs () {
        // INIT
        ArrayList <Chasseur> attendu = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(attendu, listeDonjons, listeGuildes, mapLieux);
        // RES
        ArrayList <Chasseur> resultat = world.getListeChasseurs();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGetListeDonjons () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> attendu = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, attendu, listeGuildes, mapLieux);
        // RES
        ArrayList <Donjon> resultat = world.getListeDonjons();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGetListeGuildes () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> attendu = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, attendu, mapLieux);
        // RES
        ArrayList <Guilde> resultat = world.getListeGuildes();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGetListeChasseur () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> attendu = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, attendu);
        // RES
        HashMap <String, AbstractLieu> resultat = world.getMapLieux();
        // TEST
        assertEquals(attendu, resultat);
    }
}

