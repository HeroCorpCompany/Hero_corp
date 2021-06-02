package com.herocorp.metier.lieux;

import com.herocorp.metier.groupes.GroupeChasseurs;
import com.herocorp.tools.Coord;

public class Forum extends AbstractLieu {
    
    private GroupeChasseurs membres = new GroupeChasseurs ();

    public Forum (Coord coord) {
        super ("Forum", coord);
    }

    public GroupeChasseurs getMembres () {
        return this.membres;
    }
}
