package com.herocorp.metier.lieux;

import com.herocorp.tools.Coord;


public class AbstractLieu {
    
    private int id;
    private String nom;
    private Coord coord;
    private String type;

    public AbstractLieu (String nom, Coord coord) {
        this.nom = nom;
        this.coord = coord;
    }

    public String getType () {
        return this.type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public int getId () {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNom () {
        return this.nom;
    }

    public Coord getPosition(){
        return this.coord;
    }
}
