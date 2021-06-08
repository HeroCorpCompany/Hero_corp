package com.herocorp.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Connexion;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class GuildeDaoTest {
    
    @Test
    public void testGuildeDao () {
        Connection db = new Connexion().getConnexion();
        Guilde guilde = new Guilde(new Coord(5, 7));
        guilde.setArgent(3500);
        guilde.setRecrute(true);
        LieuDao.ajouterLieu(db, guilde);
        GuildeDao.ajouterGuilde(db, guilde);
        // RES
        Guilde guildeRes = GuildeDao.recupererGuilde(db, guilde.getId());
        // TEST
        assertEquals(guilde.getId(), guildeRes.getId());
        assertEquals(guilde.getArgent(), guildeRes.getArgent());
        assertEquals(guilde.isRecruting(), guildeRes.isRecruting());
    }
}
