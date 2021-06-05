package com.herocorp.game;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.game.WorldService;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.lieux.DonjonService;
import com.herocorp.tools.Coord;

public class Game {
    private World world;
    private Statistiques stats;

    public Game () {
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        Forum forum = new Forum(new Coord(0, 0));
        mapLieux.put("Forum", forum);
        for (int i = 0; i < 5; i++) {
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

        this.world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        this.stats = new Statistiques(this.world);
    }

    public Game (World world) {
        this.world = world;
        this.stats = new Statistiques(this.world);
    }

    public void run (int nbIteration){
        for (int i = 0; i < nbIteration; i++) {
            update();
            render();
        }
    }

    public void update () {
        WorldService.updateWorld(this.world);
        WorldService.updateTemps(this.world);
    }

    public void render () {
        System.out.println(this.stats);
    }
}
