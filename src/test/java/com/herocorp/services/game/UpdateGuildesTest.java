package com.herocorp.services.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.lieux.DonjonService;
import com.herocorp.services.metier.lieux.GuildeService;
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class UpdateGuildesTest {
    @Test
    public void testGroupeMonstre() {
        // INIT
        World world = genererWorld();
        
        Guilde guilde1 = new Guilde(new Coord(0, 0));
        Guilde guilde2 = new Guilde(new Coord(0, 0));
        Guilde guilde3 = new Guilde(new Coord(0, 0));

        Chasseur chasseur11 = new Chasseur("Elmer Fudd");
        Chasseur chasseur12 = new Chasseur("Elmer Fudd");
        Chasseur chasseur13 = new Chasseur("Elmer Fudd");
        chasseur11.setClasse(Classe.A);
        chasseur12.setClasse(Classe.B);
        chasseur13.setClasse(Classe.C);
        guilde1.addMembre(chasseur11);
        guilde1.addMembre(chasseur12);
        guilde1.addMembre(chasseur13);

        Chasseur chasseur21 = new Chasseur("Elmer Fudd");
        Chasseur chasseur22 = new Chasseur("Elmer Fudd");
        Chasseur chasseur23 = new Chasseur("Elmer Fudd");
        chasseur21.setClasse(Classe.A);
        chasseur22.setClasse(Classe.B);
        chasseur23.setClasse(Classe.C);
        guilde2.addMembre(chasseur21);
        guilde2.addMembre(chasseur22);
        guilde2.addMembre(chasseur23);

        Chasseur chasseur31 = new Chasseur("Elmer Fudd");
        Chasseur chasseur32 = new Chasseur("Elmer Fudd");
        Chasseur chasseur33 = new Chasseur("Elmer Fudd");
        chasseur31.setClasse(Classe.A);
        chasseur32.setClasse(Classe.B);
        chasseur33.setClasse(Classe.C);
        guilde3.addMembre(chasseur31);
        guilde3.addMembre(chasseur32);
        guilde3.addMembre(chasseur33);

        guilde1.setArgent(-100);
        guilde2.setArgent(GuildeService.montantAPayer(guilde2) + Classe.S.getSalaire() + 10);
        guilde3.setArgent(Classe.S.getSalaire() - 10);

        world.ajouterGuilde(guilde1);
        world.ajouterGuilde(guilde2);
        world.ajouterGuilde(guilde3);

        boolean attendu2 = true;
        boolean attendu3 = false;
        // RES
        boolean resultat2 = world.getListeGuildes().get(0).isRecruting();
        boolean resultat3 = world.getListeGuildes().get(1).isRecruting();

        // TEST
        assertFalse(world.supprimerGuilde(guilde1));
        assertEquals(attendu2, resultat2);
        assertEquals(attendu3, resultat3);
    }

    public World genererWorld () {
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        Forum forum = new Forum(new Coord(0, 0));
        mapLieux.put("Forum", forum);
        for (int i = 0; i < 10; i++) {
            Donjon donjon = new Donjon(new Coord(0, 0));
            DonjonService.remplirDonjon(donjon);
            listeDonjons.add(donjon);
        }
        for (int i = 0; i < 90; i++) {
            Chasseur chasseur = new Chasseur("Souli");
            ChasseurService.attribuerClasse(chasseur);
            ChasseurService.changerLieu(chasseur, forum);
            listeChasseurs.add(chasseur);
        }

        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        return world;
    }
}
