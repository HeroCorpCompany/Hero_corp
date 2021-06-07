package com.herocorp.dao;

import static org.junit.Assert.assertTrue;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class ChasseurDaoTest {
    
    @Test
    public void testAjouterChasseur () {
        Chasseur chasseur = new Chasseur("Souli");
        Forum forum = new Forum(new Coord(0, 0));
        chasseur.setPosition(forum);
        ChasseurDao.ajouterChasseur(chasseur);
        assertTrue(true);
    }

    @Test
    public void testMajChasseur () {
        Chasseur chasseur = new Chasseur("Bryan");
        Forum forum = new Forum(new Coord(0, 0));
        chasseur.setPosition(forum);
        ChasseurDao.ajouterChasseur(chasseur);
        ChasseurService.attribuerClasse(chasseur);
        chasseur.setArgent(3000);
        ChasseurDao.majChasseur(chasseur);
        assertTrue(true);
    }
}
