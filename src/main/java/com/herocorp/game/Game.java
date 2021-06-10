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
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

public class Game {
    private World world;
    private Statistiques stats;
    private int nbIteration;

    

    public Game (int nbIteration) {
        this.nbIteration = nbIteration;
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
        setVariablesWorld(this.world, nbIteration);
        this.stats = new Statistiques(this.world);
    }

    public Game (World world) {
        this.world = world;
        this.stats = new Statistiques(this.world);
    }
    public void setVariablesWorld (World world, int nbIteration){
        world.setChanceReproduction(nbIteration*world.getChanceReproduction()/50);
        world.setAgeChasseurMort((int) calcVariable(world.getAgeChasseurMort(), nbIteration));
        world.setAgeChasseurClasse((int) calcVariable(world.getAgeChasseurClasse(), nbIteration));
        world.setAgeChasseurReproduction((int) calcVariable(world.getAgeChasseurReproduction(), nbIteration));
        world.setNbDonjonSeuils((int) calcVariable(world.getNbDonjonSeuils(), nbIteration));
        world.setNbGuildeSeuil((int) calcVariable(world.getNbGuildeSeuil(), nbIteration));
    }
    public double calcVariable(int initialNumber, int nbIteration){
        return nbIteration*initialNumber/50;
    }
    public void run (int nbIteration){
        render();
        for (int i = 0; i < nbIteration; i++) {
            
            update();
            render();
        }
        
    }

    public void update () {
        WorldService.updateWorld(this.world);
    }

    public void render () {
        System.out.println(this.stats);
    }

    public int getNbIteration() {
        return this.nbIteration;
    }
}
