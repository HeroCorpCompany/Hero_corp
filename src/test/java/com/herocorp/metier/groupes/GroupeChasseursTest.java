package com.herocorp.metier.groupes;

import static org.junit.Assert.assertEquals;

import com.herocorp.metier.acteurs.Chasseur;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class GroupeChasseursTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testGetTaille()
    {
        // INIT
        Chasseur chasseur1 = new Chasseur("Pouf");
        Chasseur chasseur2 = new Chasseur("Pif");
        GroupeChasseurs groupe = new GroupeChasseurs(); 

        groupe.add(chasseur1); 
        groupe.add(chasseur2); 

        // RES
        int resultat = groupe.getTaille(); 

        // TEST 
        assertEquals(2,resultat);

    }

    
}

