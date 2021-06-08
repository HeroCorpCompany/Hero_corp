package com.herocorp.dao;

import static org.junit.Assert.assertEquals;

import java.net.ConnectException;
import java.sql.Connection;

import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Connexion;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class LieuDaoTest {

    @Test
    public void testLieuDao () {
        // INIT
        Connection db = new Connexion().getConnexion();
        Forum forum = new Forum(new Coord(0, 0));
        Donjon donjon = new Donjon(new Coord(1, 3));
        Guilde guilde = new Guilde(new Coord(5, 5));
        LieuDao.ajouterLieu(db, forum);
        LieuDao.ajouterLieu(db, donjon);
        LieuDao.ajouterLieu(db, guilde);
        // RES
        Forum resForum = (Forum) LieuDao.recupererLieu(db, forum.getId());
        Donjon resDonjon = (Donjon) LieuDao.recupererLieu(db, donjon.getId());
        Guilde resGuilde = (Guilde) LieuDao.recupererLieu(db, guilde.getId());
        // TEST
        assertEquals(forum.getId(), resForum.getId());
        assertEquals(donjon.getPosition().x, resDonjon.getPosition().x);
        assertEquals(guilde.getPosition().y, resGuilde.getPosition().y);
    }
}
