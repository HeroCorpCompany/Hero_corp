package com.herocorp.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.tools.Connexion;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class GroupeDaoTest {
    
    @Test
    public void testGroupeDao () {
        // INIT
        Connection db = new Connexion().getConnexion(); 
        Forum forum = new Forum(new Coord(0, 0));
        Donjon donjon = new Donjon(new Coord(3, 3));
        LieuDao.ajouterLieu(db, forum);
        LieuDao.ajouterLieu(db, donjon);
        GroupeRaid groupe = new GroupeRaid();
        groupe.setPosition(forum);
        groupe.setCible(donjon);
        GroupeDao.ajouterGroupe(db, groupe);
        // RES
        GroupeRaid groupeRes = GroupeDao.recupererGroupe(db, groupe.getId());
        // TEST
        assertEquals(groupe.getId(), groupeRes.getId());
    }
}
