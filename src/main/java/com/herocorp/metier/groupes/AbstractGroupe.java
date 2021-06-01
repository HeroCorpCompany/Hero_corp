package com.herocorp.metier.groupes;

import java.util.ArrayList;

import com.herocorp.metier.acteurs.AbstractActeur;
import com.herocorp.metier.lieux.AbstractLieu;

public class AbstractGroupe {

    private static int dernierId = 0;
    private int id;
    private ArrayList <AbstractActeur> liste = new ArrayList <AbstractActeur> ();
    private AbstractLieu position = null;

    public AbstractGroupe () {
        this.id = AbstractGroupe.dernierId;
        AbstractGroupe.dernierId += 1;
    }

    public int getId () {
        return this.id;
    }

    public ArrayList <AbstractActeur> getListe () {
        return this.liste;
    }

    public AbstractLieu getPosition () {
        return this.position;
    }

    public void add (AbstractActeur newActeur) {
        // TODO : Ajout l'acteur à la liste
    }

    public void remove (AbstractActeur acteur) {
        // TODO : Retire l'acteur de la liste
    }
    
}
