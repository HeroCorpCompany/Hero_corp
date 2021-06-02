package com.herocorp.metier.lieux;

import static org.junit.Assert.assertEquals;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DonjonTest
{
    @Test
    public void testGroupeMonstre() {
        // INIT
        GroupeMonstres attendu = new GroupeMonstres();
        attendu.add(new Monstre("Souli", Classe.S, attendu));
        attendu.add(new Monstre("Mailine", Classe.A, attendu));
        attendu.add(new Monstre("Bryan", Classe.A, attendu));
        Donjon donjon = new Donjon(new Coord(0, 0));
        donjon.setGroupeMonstre(attendu);
        // RES
        GroupeMonstres resultat = donjon.getGroupeMonstres();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGroupeRaid() {
        // INIT
        GroupeRaid attendu = new GroupeRaid();
        attendu.add(new Chasseur("Mailine"));
        attendu.add(new Chasseur("Bryan"));
        attendu.add(new Chasseur("Alex"));
        Donjon donjon = new Donjon(new Coord(0, 0));
        donjon.setGroupeRaid(attendu);
        // RES
        GroupeRaid resultat = donjon.getGroupeRaid();
        // TEST
        assertEquals(attendu, resultat);
    }
}

