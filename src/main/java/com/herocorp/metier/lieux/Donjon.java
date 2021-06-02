package com.herocorp.metier.lieux;

import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.tools.Coord;

public class Donjon extends AbstractLieu {
    
    private GroupeMonstres groupeMonstres;
    private GroupeRaid groupeRaid;

    public Donjon (Coord coord) {
        super ("Donjon" , coord);
    }

    public GroupeMonstres getGroupeMonstres () {
        return this.groupeMonstres;
    }

    public void setGroupeMonstre (GroupeMonstres newGroupe) {
        this.groupeMonstres = newGroupe;
    }

    public GroupeRaid getGroupeRaid () {
        return this.groupeRaid;
    }

    public void setGroupeRaid (GroupeRaid newGroupe) {
        this.groupeRaid = newGroupe;
    }
}
