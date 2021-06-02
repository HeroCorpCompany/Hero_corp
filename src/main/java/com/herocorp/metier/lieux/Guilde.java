package com.herocorp.metier.lieux;

import com.herocorp.metier.groupes.GroupeChasseurs;
import com.herocorp.tools.Coord;

public class Guilde extends AbstractLieu {
    
    private GroupeChasseurs membres = new GroupeChasseurs ();
    private int argent = 0;

    public Guilde (Coord coord) {
        super ("Guilde", coord);
    }

    public GroupeChasseurs getMembres () {
        return this.membres;
    }

    public int getArgent () {
        return this.argent;
    }

    public void setArgent (int newArgent) {
        this.argent = newArgent;
    }
}
