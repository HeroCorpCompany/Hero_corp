package com.herocorp.metier.acteurs;

import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.tools.Classe;

public abstract class AbstractActeur {
    private int id = 0;
    private String nom;
    private Classe classe;
    private AbstractLieu position = null;

    public AbstractActeur (String nom, Classe classe) {
        this.nom = nom;
        this.classe = classe;
    }

    public String getNom () {
        return this.nom;
    }

    public int getId () {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Classe getClasse () {
        return this.classe;
    }

    public void setClasse (Classe newClasse) {
        this.classe = newClasse;
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
