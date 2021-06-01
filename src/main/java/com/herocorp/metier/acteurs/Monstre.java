package com.herocorp.metier.acteurs;

import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.tools.Classe;

public class Monstre extends AbstractActeur {
    
    private GroupeMonstres groupe;

    public Monstre (String nom, Classe classe, GroupeMonstres groupe) {
        super( nom, classe );
        this.groupe = groupe;
        this.setPosition(groupe.getPosition());
    }

    public GroupeMonstres getGroupe () {
        return this.groupe;
    }

}
