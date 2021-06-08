package com.herocorp.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import com.herocorp.metier.acteurs.AbstractActeur;
import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.services.metier.lieux.DonjonService;
import com.herocorp.tools.Connexion;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class MonstreDaoTest {
    
    @Test
    public void testMonstreDao () {
        // INIT
        Connection db = new Connexion().getConnexion();
        Donjon donjon = new Donjon(new Coord(3, 3));
        DonjonService.remplirDonjon(donjon);
        LieuDao.ajouterLieu(db, donjon);
        for (AbstractActeur acteur : donjon.getGroupeMonstres().getListe()) {
            Monstre monstre = (Monstre) acteur;
            MonstreDao.ajouterMonstre(db, monstre, donjon.getId());
        }
        // RES
        GroupeMonstres groupe = new GroupeMonstres();
        for (AbstractActeur acteur : donjon.getGroupeMonstres().getListe()) {
            Monstre monstre = MonstreDao.recupererMonstre(db, acteur.getId(), groupe);
            groupe.add(monstre);
        }
        // TEST
        for (int i = 0; i < groupe.getListe().size(); i++) {
            Monstre monstre = (Monstre) donjon.getGroupeMonstres().get(i);
            Monstre monstreRes = (Monstre) groupe.get(i);
            assertEquals(monstre.getId(), monstreRes.getId());
            assertEquals(monstre.getClasse(), monstreRes.getClasse());
        }
    }
}
