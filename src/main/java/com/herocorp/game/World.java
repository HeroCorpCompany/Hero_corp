package com.herocorp.game;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

public class World {

    private int temps = 0;
    private ArrayList <Chasseur> listeChasseurs;
    private ArrayList <Donjon> listeDonjons;
    private ArrayList <Guilde> listeGuildes;
    private ArrayList <GroupeRaid> listeGroupes = new ArrayList<>();
    private HashMap <String, AbstractLieu> mapLieux;

    public World (ArrayList <Chasseur> listeChasseurs, ArrayList <Donjon> listeDonjons, ArrayList <Guilde> listeGuildes, HashMap <String, AbstractLieu> mapLieux) {
        this.listeChasseurs = listeChasseurs;
        this.listeDonjons = listeDonjons;
        this.listeGuildes = listeGuildes;
        this.mapLieux = mapLieux;
    }

    public int getTemps () {
        return this.temps;
    }

    public void setTemps (int newTemps) {
        this.temps = newTemps;
    }

    public ArrayList <Chasseur> getListeChasseurs () {
        return this.listeChasseurs;
    }

    public ArrayList <Donjon> getListeDonjons () {
        return this.listeDonjons;
    }

    public ArrayList <Guilde> getListeGuildes () {
        return this.listeGuildes;
    }

    public ArrayList <GroupeRaid> getListeGroupes () {
        return this.listeGroupes;
    }

    public HashMap <String, AbstractLieu> getMapLieux () {
        return this.mapLieux;
    }
    
}
