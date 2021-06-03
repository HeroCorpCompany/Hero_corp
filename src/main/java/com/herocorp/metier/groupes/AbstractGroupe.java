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

    public AbstractActeur get(int identifiant) {
        return this.getListe().get(identifiant);
    }

    public void add (AbstractActeur newActeur) {
        this.liste.add(newActeur);
    }

    public boolean remove (AbstractActeur acteur) {
        return this.liste.remove(acteur);
    }
    
    public void setPosition (AbstractLieu newLieu){
        this.position = newLieu;
    }
}
