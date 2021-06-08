package com.herocorp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.tools.Connexion;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class ChasseurDaoTest {
    
    @Test
    public void testAjouterChasseur () {
        // INIT
        Connection db = new Connexion().getConnexion();
        Chasseur chasseur = new Chasseur("Alex");
        Forum forum = new Forum(new Coord(0, 0));
        LieuDao.ajouterLieu(db, forum);
        chasseur.setPosition(forum);
        chasseur.setArgent(350);
        chasseur.setAge(50);
        ChasseurDao.ajouterChasseur(db, chasseur);
        // RES
        Chasseur chasseurRes = ChasseurDao.recupererChaseur(db, chasseur.getId());
        // TEST
        assertEquals(chasseur.getId(), chasseurRes.getId());
        assertEquals(chasseur.getAge(), chasseurRes.getAge());
        assertEquals(chasseur.getArgent(), chasseurRes.getArgent());
    }
}
