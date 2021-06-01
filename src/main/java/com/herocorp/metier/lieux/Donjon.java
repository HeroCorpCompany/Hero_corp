package com.herocorp.metier.lieux;

import com.herocorp.metier.groupes.GroupeRaid;

public class Donjon extends AbstractLieu {
    
    private GroupeRaid groupeRaid;

    public Donjon () {
        super ( "Donjon" );
    }

    public GroupeRaid getGroupeRaid () {
        return this.groupeRaid;
    }

    public void setGroupeRaid (GroupeRaid newGroupe) {
        this.groupeRaid = newGroupe;
    }
}
