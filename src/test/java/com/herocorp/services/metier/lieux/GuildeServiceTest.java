package com.herocorp.services.metier.lieux;

import static org.junit.Assert.assertEquals;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GuildeServiceTest
{
    @Test
    public void testPayerSalaires()
    {
        // INIT
        Guilde guilde = new Guilde(new Coord(0, 0));
        guilde.setArgent(2000);
        Chasseur chasseur1 = new Chasseur("Souli");
        Chasseur chasseur2 = new Chasseur("Man");
        chasseur1.setClasse(Classe.A); // Salaire des classes A : 1000
        chasseur2.setClasse(Classe.B); // Salaire des classes B : 300
        guilde.addMembre(chasseur1);
        guilde.addMembre(chasseur2);
        int attendu1 = 2000-1000-300;
        int attendu2 = 1000;
        // RES
        GuildeService.payerSalaires(guilde);
        int resultat1 = guilde.getArgent();
        int resultat2 = chasseur1.getArgent();
        // TEST
        assertEquals(attendu1, resultat1);
        assertEquals(attendu2, resultat2);
    }
}

