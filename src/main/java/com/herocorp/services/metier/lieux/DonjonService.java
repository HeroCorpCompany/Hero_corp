package com.herocorp.services.metier.lieux;

import java.sql.Connection;

import com.herocorp.dao.LieuDao;
import com.herocorp.dao.MonstreDao;
import com.herocorp.metier.acteurs.AbstractActeur;
import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.services.metier.acteurs.MonstreService;
import com.herocorp.tools.Coord;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.metier.lieux.Donjon;

public class DonjonService {

    public static Donjon creerDonjon (Connection db, int x, int y) {
        Donjon donjon = new Donjon(new Coord(x, y));
        LieuDao.ajouterLieu(db, donjon);
        DonjonService.remplirDonjon(donjon);
        for (AbstractActeur acteur : donjon.getGroupeMonstres().getListe()) {
            Monstre monstre = (Monstre) acteur;
            MonstreDao.ajouterMonstre(db, monstre, donjon.getId());
        }
        return donjon;
    }

    public static void remplirDonjon (Donjon donjon) {
        GroupeMonstres groupeMonstres = new GroupeMonstres();
        
        for (int i = 0; i < 10; i++){
            Monstre monstre = MonstreService.genererMonstre(groupeMonstres);
            groupeMonstres.add(monstre);
        }
    
        donjon.setGroupeMonstre(groupeMonstres);
    }
    
}
