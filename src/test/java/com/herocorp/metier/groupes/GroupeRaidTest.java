package com.herocorp.metier.groupes;
package com.herocorp.metier.acteurs;

import static org.junit.Assert.assertTrue;

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
        Chasseur chasseur3 = new Chasseur("Miam");
        Chasseur chasseur4 = new Chasseur("Bipou");
        Chasseur chasseur5 = new Chasseur("TotoroDepressif");
        Chasseur chasseur6 = new Chasseur("Po");
        Chasseur chasseur7 = new Chasseur("Bou");
        Chasseur chasseur8 = new Chasseur("J'ai");
        Chasseur chasseur9 = new Chasseur("Plus");
        Chasseur chasseur10 = new Chasseur("D'idées");
        GroupeRaid groupe1 = new GroupeChasseurs(); 
        GroupeRaid groupe2 = new GroupeChasseurs(); 

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
        resultat1 = groupe1.isPlein();
        resultat2 = groupe2.isPlein();
        // TEST 
        assertTrue(resultat1);
        assertFalse(resultat2)

    }
}

