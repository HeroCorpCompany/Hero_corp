package com.herocorp.services.metier.lieux;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.tools.Coord;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ForumServiceTest
{
    @Test
    public void testAjoutChasseur()
    {
        // INIT
        Forum forum = new Forum(new Coord(0, 0));
        String attendu = "Soulier";
        Chasseur chasseur = new Chasseur(attendu);
        ForumService.ajouterChasseur(forum, chasseur);
        // RES
        String resultat = forum.getMembres().get(0).getNom();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testSupprChasseur()
    {
        // INIT
        Forum forum = new Forum(new Coord(0, 0));
        String attendu = "Soulier";
        Chasseur chasseur = new Chasseur(attendu);
        ForumService.ajouterChasseur(forum, chasseur);
        // TEST
        assertTrue(ForumService.retirerChasseur(forum, chasseur));
    }
}

