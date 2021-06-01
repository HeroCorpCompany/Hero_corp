package com.herocorp.metier.acteurs;

import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.tools.Classe;

public abstract class AbstractActeur {
    private static int dernierId = 0;
    private int id;
    private String nom;
    private Classe classe;
    private AbstractLieu position = null;

    public AbstractActeur (String nom, Classe classe) {
        this.id = AbstractActeur.dernierId;
        AbstractActeur.dernierId += 1;
        this.nom = nom;
        this.classe = classe;
    }

    public String getNom () {
        return this.nom;
    }

    public int getId () {
        return this.id;
    }

    public Classe getClasse () {
        return this.classe;
    }

    public int getForce () {
        return this.classe.getForce();
    }


    public AbstractLieu getPosition () {
        return this.position;
    }

    public void setPosition (AbstractLieu newPosition) {
        this.position = newPosition;
    }
}
