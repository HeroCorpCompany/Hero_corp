package com.herocorp.game;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

public class World {

    private int temps = 0;
    private ArrayList <Chasseur> listeChasseurs = new ArrayList <Chasseur> ();
    private ArrayList <Donjon> listeDonjons = new ArrayList <Donjon> ();
    private ArrayList <Guilde> listeGuildes = new ArrayList <Guilde> ();
    private HashMap <String, AbstractLieu> mapLieux = new HashMap <String, AbstractLieu> ();

    public World () {
        // TODO : Générer les lieux, les stocker dans mapLieux, générer des donjons et la population initiale
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

    public HashMap <String, AbstractLieu> getMapLieux () {
        return this.mapLieux;
    }
    
}
