package com.herocorp.metier.lieux;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeChasseurs;
import com.herocorp.tools.Coord;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ForumTest 
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

        Forum forum = new Forum(new Coord(0, 0));
        forum.addMembre(chasseur1);
        forum.addMembre(chasseur2);
        forum.addMembre(chasseur3);
        forum.removeMembre(chasseur3);
        // RES
        GroupeChasseurs resultat = forum.getMembres();
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
        Forum forum = new Forum(new Coord(0, 0));
        forum.addMembre(chasseur1);
        // TEST
        assertTrue(forum.removeMembre(chasseur1));
        assertFalse(forum.removeMembre(chasseur1));
    }
}

