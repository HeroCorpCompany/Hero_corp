package com.herocorp.metier.acteurs;

import static org.junit.Assert.assertEquals;

import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.tools.Classe;

import org.junit.Test;

public class MonstreTest
{
    @Test
    public void testGetGroupe () {
        // INIT
        GroupeMonstres attendu = new GroupeMonstres();
        Monstre monstre = new Monstre("Alex", Classe.A , attendu);
        // RES
        GroupeMonstres resultat = monstre.getGroupe();
        // TEST
        assertEquals(attendu, resultat);
    }
}

