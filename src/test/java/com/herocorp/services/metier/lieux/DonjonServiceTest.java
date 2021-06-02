package com.herocorp.services.metier.lieux;

import static org.junit.Assert.assertEquals;

import com.herocorp.metier.lieux.Donjon;
import com.herocorp.tools.Coord;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DonjonServiceTest
{
    @Test
    public void testRemplirDonjon()
    {
        // INIT
        Donjon donjon = new Donjon(new Coord(0, 0));
        DonjonService.remplirDonjon(donjon);
        int attendu = 10;
        // RES
        int resultat = donjon.getGroupeMonstres().getListe().size();
        // TEST
        assertEquals(attendu, resultat);
    }
}

