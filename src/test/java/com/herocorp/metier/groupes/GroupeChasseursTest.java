package com.herocorp.metier.groupes;

import static org.junit.Assert.assertEquals;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.services.metier.acteurs.ChasseurService;

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

    @Test
    public void testCombatForce () {
        // INIT
        GroupeChasseurs groupe = new GroupeChasseurs();
        int forceTotale = 0;
        for (int i = 0; i < 10; i++) {
            Chasseur chasseur = new Chasseur("Souli");
            ChasseurService.attribuerClasse(chasseur);
            forceTotale += chasseur.getForce();
            groupe.add(chasseur);
        }
        int attendu = forceTotale / groupe.getTaille();
        // RES
        int resultat = groupe.combatForce();
        // TEST
        assertEquals(attendu, resultat);
    }

    
}

