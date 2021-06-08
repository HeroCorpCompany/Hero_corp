package com.herocorp.metier.lieux;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeChasseurs;
import com.herocorp.tools.Coord;

public class Forum extends AbstractLieu {
    
    private GroupeChasseurs membres = new GroupeChasseurs ();

    public Forum (Coord coord) {
        super ("Forum", coord);
        this.setType("Forum");
    }

    public GroupeChasseurs getMembres () {
        return this.membres;
    }

    public void addMembre (Chasseur chasseur) {
        this.membres.add(chasseur);
    }

    public boolean removeMembre (Chasseur chasseur) {
        return this.membres.remove(chasseur);
    }
}
