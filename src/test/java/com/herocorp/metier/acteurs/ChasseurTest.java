package com.herocorp.metier.acteurs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ChasseurTest
{
    @Test
    public void testAge() {
        // INIT
        int attendu = 22;
        Chasseur chasseur = new Chasseur("Souli");
        chasseur.setAge(attendu);
        // RES
        int resultat = chasseur.getAge();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testArgent() {
        // INIT
        int attendu = 1200;
        Chasseur chasseur = new Chasseur("Souli");
        chasseur.setArgent(attendu);
        // RES
        int resultat = chasseur.getArgent();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGuilde() {
        // INIT
        Guilde attendu = new Guilde(new Coord(0, 0));
        Chasseur chasseur = new Chasseur("Souli");
        chasseur.setGuilde(attendu);
        // RES
        Guilde resultat = chasseur.getGuilde();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testIsInGuildeFalse() {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        // RES
        boolean resultat = chasseur.isInGuilde();
        // TEST
        assertFalse(resultat);
    }

    @Test
    public void testIsInGuildeTrue() {
        // INIT
        Guilde guilde = new Guilde(new Coord(0, 0));
        Chasseur chasseur = new Chasseur("Souli");
        chasseur.setGuilde(guilde);
        // RES
        boolean resultat = chasseur.isInGuilde();
        // TEST
        assertTrue(resultat);
    }

    @Test
    public void testGroupeRaid() {
        // INIT
        GroupeRaid attendu = new GroupeRaid();
        Chasseur chasseur = new Chasseur("Souli");
        chasseur.setGroupe(attendu);
        // RES
        GroupeRaid resultat = chasseur.getGroupe();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testIsInGroupeRaidFalse() {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        // RES
        boolean resultat = chasseur.isInGroupe();
        // TEST
        assertFalse(resultat);
    }

    @Test
    public void testIsInGroupRaidTrue() {
        // INIT
        GroupeRaid groupe = new GroupeRaid();
        Chasseur chasseur = new Chasseur("Souli");
        chasseur.setGroupe(groupe);
        // RES
        boolean resultat = chasseur.isInGroupe();
        // TEST
        assertTrue(resultat);
    }

    @Test
    public void testSalaire() {
        // INIT
        Chasseur chasseur = new Chasseur("Souli");
        chasseur.setClasse(Classe.B);
        int attendu = Classe.B.getSalaire();
        // RES
        int resultat = chasseur.getSalaire();
        // TEST
        assertEquals(attendu, resultat);
    }
}

