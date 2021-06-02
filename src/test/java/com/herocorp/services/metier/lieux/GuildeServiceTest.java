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
        chasseur1.setClasse(Classe.B); // Salaire des classes B : 300
        int attendu = 2000-1000-300;
        // RES
        GuildeService.payerSalaires(guilde);
        int resultat = guilde.getArgent();
        // TEST
        assertEquals(attendu, resultat);
    }
}

