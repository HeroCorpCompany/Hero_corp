package com.herocorp.services.game;

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
import com.herocorp.tools.Coord;

import org.junit.Test;

public class UpdateChasseursTest {

    @Test
    public void testUpdateChasseurs () {
        World world = genererWorld();
        UpdateChasseurs.updateChasseurs(world);
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
