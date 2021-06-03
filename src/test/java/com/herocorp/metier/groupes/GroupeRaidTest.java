package com.herocorp.metier.groupes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Coord;

import org.junit.Test;

/** 
 * Unit test for simple App.
 */
public class GroupeRaidTest
{
    /**d
     * Rigorous Test :-)
     */
    @Test
    public void testIsPlein()
    {
        // INIT
        Chasseur chasseur1 = new Chasseur("Pouf");
        Chasseur chasseur2 = new Chasseur("Pif");
        Chasseur chasseur3 = new Chasseur("Souli");
        Chasseur chasseur4 = new Chasseur("Bipou");
        Chasseur chasseur5 = new Chasseur("TotoroDepressif");
        Chasseur chasseur6 = new Chasseur("Po");
        Chasseur chasseur7 = new Chasseur("Bou");
        Chasseur chasseur8 = new Chasseur("Maymay");
        Chasseur chasseur9 = new Chasseur("Bribri");
        Chasseur chasseur10 = new Chasseur("Alexandrie");
        GroupeRaid groupe1 = new GroupeRaid(); 
        GroupeRaid groupe2 = new GroupeRaid(); 

        groupe1.add(chasseur1); 
        groupe1.add(chasseur2); 
        groupe1.add(chasseur3); 
        groupe1.add(chasseur4); 
        groupe1.add(chasseur5); 
        groupe1.add(chasseur6); 
        groupe1.add(chasseur7); 
        groupe1.add(chasseur8); 
        groupe1.add(chasseur9); 
        groupe1.add(chasseur10); 


        groupe2.add(chasseur1); 
        groupe2.add(chasseur2); 
        groupe2.add(chasseur3); 
        groupe2.add(chasseur4); 
        groupe2.add(chasseur5); 
        groupe2.add(chasseur6); 
        groupe2.add(chasseur7); 

        // RES 
        boolean resultat1 = groupe1.isPlein();
        boolean resultat2 = groupe2.isPlein();
        // TEST 
        assertTrue(resultat1);
        assertFalse(resultat2);

    }

    @Test
    public void testGuilde () {
        // INIT
        GroupeRaid groupe1 = new GroupeRaid();
        Guilde guilde = new Guilde(new Coord(0, 0));
        groupe1.setGuilde(guilde);
        GroupeRaid groupe2  = new GroupeRaid();
        // RES
        boolean resultat1 = groupe1.hasGuilde();
        boolean resultat2 = groupe2.hasGuilde();
        Guilde resultat3 = groupe1.getGuilde();
        // TEST
        assertTrue(resultat1);
        assertFalse(resultat2);
        assertEquals(guilde, resultat3);
    }

}

