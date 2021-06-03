package com.herocorp.tools;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClasseTest
{
    @Test
    public void testGetNom() {
        // INIT
        String attendu = "B";
        Classe classe = Classe.B;
        // RES
        String resultat = classe.getNom();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGetSalaire() {
        // INIT
        int attendu = 300;
        Classe classe = Classe.B;
        // RES
        int resultat = classe.getSalaire();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGetRecompense() {
        // INIT
        int attendu = 200;
        Classe classe = Classe.B;
        // RES
        int resultat = classe.getRecompense();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGetForce() {
        // INIT
        int attendu = 3;
        Classe classe = Classe.B;
        // RES
        int resultat = classe.getForce();
        // TEST
        assertEquals(attendu, resultat);
    }
}

