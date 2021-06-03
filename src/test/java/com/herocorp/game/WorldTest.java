package com.herocorp.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
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
    public void testAjouterSupprimerChasseur () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        Chasseur chasseur = new Chasseur("Souli");
        world.ajouterChasseur(chasseur);
        // RES
        boolean resultat = world.supprimerChasseur(chasseur);
        // TEST
        assertTrue(resultat);
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

    public void testAjouterSupprimerDonjon () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        Donjon donjon = new Donjon();
        world.ajouterDonjon(donjon);;
        // RES
        boolean resultat = world.supprimerDonjon(donjon);
        // TEST
        assertTrue(resultat);
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

    public void testAjouterSupprimerGuilde () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        Guilde guilde = new Guilde();
        world.ajouterGuilde(guilde);
        // RES
        boolean resultat = world.supprimerGuilde(guilde);
        // TEST
        assertTrue(resultat);
    }

    public void testAjouterSupprimerGroupe () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        GroupeRaid groupe = new GroupeRaid();
        world.ajouterGroupe(groupe);
        // RES
        boolean resultat = world.supprimerGroupe(groupe);
        // TEST
        assertTrue(resultat);
    }

    @Test
    public void testGetMapLieux () {
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

    @Test
    public void testAjouterLieu () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        AbstractLieu attendu = new AbstractLieu("Forum");
        world.ajouterLieu("Forum", attendu);
        // RES
        AbstractLieu resultat = world.getLieu("Forum");
        // TEST
        assertEquals(attendu, resultat);
    }

    

}

