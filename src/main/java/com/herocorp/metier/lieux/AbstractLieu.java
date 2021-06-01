package com.herocorp.metier.lieux;

import com.herocorp.metier.groupes.AbstractGroupe;

public class AbstractLieu {
    
    private static int dernierId = 0;
    private int id;
    private String nom;
    private AbstractGroupe habitants;

    public AbstractLieu (String nom) {
        this.id = AbstractLieu.dernierId;
        AbstractLieu.dernierId += 1;
        this.nom = nom;
    }

    public int getId () {
        return this.id;
    }

    public String getNom () {
        return this.nom;
    }

    public AbstractGroupe getHabitants () {
        return this.habitants;
    }
}
