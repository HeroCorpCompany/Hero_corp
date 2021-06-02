package com.herocorp.metier.lieux;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeChasseurs;
import com.herocorp.tools.Coord;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GuildeTest
{
    @Test
    public void testGestionMembres()
    {
        // INIT
        GroupeChasseurs attendu = new GroupeChasseurs();
        Chasseur chasseur1 = new Chasseur("Mailine");
        Chasseur chasseur2 = new Chasseur("Bryan");
        Chasseur chasseur3 = new Chasseur("Alex");
        attendu.add(chasseur1);
        attendu.add(chasseur2);

        Guilde guilde = new Guilde(new Coord(0, 0));
        guilde.addMembre(chasseur1);
        guilde.addMembre(chasseur2);
        guilde.addMembre(chasseur3);
        guilde.removeMembre(chasseur3);
        // RES
        GroupeChasseurs resultat = guilde.getMembres();
        // TEST
        for (int i = 0; i < resultat.getTaille(); i++){
            assertEquals(attendu.getListe().get(i).getNom(), resultat.getListe().get(i).getNom());
        }
    }

    @Test
    public void testRemove()
    {
        // INIT
        Chasseur chasseur1 = new Chasseur("Mailine");
        Guilde guilde = new Guilde(new Coord(0, 0));
        guilde.addMembre(chasseur1);
        // TEST
        assertTrue(guilde.removeMembre(chasseur1));
        assertFalse(guilde.removeMembre(chasseur1));
    }

    @Test
    public void testArgent()
    {
        // INIT
        Guilde guilde = new Guilde(new Coord(0, 0));
        int attendu = 900;
        guilde.setArgent(attendu);

        // RES
        int resultat = guilde.getArgent();
        
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testTaille()
    {
        // INIT
        Guilde guilde = new Guilde(new Coord(0, 0));
        Chasseur chasseur1 = new Chasseur("Mailine");
        Chasseur chasseur2 = new Chasseur("Bryan");
        Chasseur chasseur3 = new Chasseur("Alex");
        guilde.addMembre(chasseur1);
        guilde.addMembre(chasseur2);
        guilde.addMembre(chasseur3);
        int attendu = 3;

        // RES
        int resultat = guilde.getTaille();
        
        // TEST
        assertEquals(attendu, resultat);
    }
}

