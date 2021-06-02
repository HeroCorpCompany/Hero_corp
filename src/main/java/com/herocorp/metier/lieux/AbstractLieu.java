package com.herocorp.metier.lieux;

import com.herocorp.metier.groupes.AbstractGroupe;
import com.herocorp.tools.Coord;


public class AbstractLieu {
    
    private static int dernierId = 0;
    private int id;
    private String nom;
    private Coord coord;
    private AbstractGroupe habitants;

    public AbstractLieu (String nom, Coord coord) {
        this.id = AbstractLieu.dernierId;
        AbstractLieu.dernierId += 1;
        this.nom = nom;
        this.coord = coord;
    }

    public int getId () {
        return this.id;
    }

    public String getNom () {
        return this.nom;
    }

    public Coord getPosition(){
        return this.coord;
    }

    public AbstractGroupe getHabitants () {
        return this.habitants;
    }
}
