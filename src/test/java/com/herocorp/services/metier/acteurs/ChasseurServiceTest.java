package com.herocorp.services.metier.acteurs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Coord;

import org.junit.Test;


public class ChasseurServiceTest
{
    @Test
    public void testRejoindreGuilde() {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        Guilde attendu = new Guilde(new Coord(0, 0));
        ChasseurService.rejoindreGuilde(chasseur, attendu);
        // RES
        Guilde resultat = chasseur.getGuilde();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testQuitterGuilde() {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        Guilde guilde = new Guilde(new Coord(0, 0));
        ChasseurService.rejoindreGuilde(chasseur, guilde);
        ChasseurService.quitterGuilde(chasseur);
        // RES
        boolean resultat = chasseur.isInGuilde();
        // TEST
        assertFalse(resultat);
    }

    @Test
    public void testRejoindreGroupe() {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        GroupeRaid attendu = new GroupeRaid();
        ChasseurService.rejoindreRaid(chasseur, attendu);
        // RES
        GroupeRaid resultat = chasseur.getGroupe();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testQuitterGroupe() {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        GroupeRaid groupe = new GroupeRaid();
        ChasseurService.rejoindreRaid(chasseur, groupe);
        ChasseurService.quitterRaid(chasseur);
        // RES
        boolean resultat = chasseur.isInGroupe();
        // TEST
        assertFalse(resultat);
    }

    @Test
    public void testChangerLieu() {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        AbstractLieu attendu = new AbstractLieu("Amphi", new Coord(0, 0));
        ChasseurService.changerLieu(chasseur, attendu);
        // RES
        AbstractLieu resultat = chasseur.getPosition();
        // TEST
        assertEquals(attendu, resultat);
    }


}

