package com.herocorp.metier.acteurs;

import com.herocorp.metier.lieux.Guilde;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.tools.Classe;

public class Chasseur extends AbstractActeur {
    
    private int age = 0;
    private int argent = 0;
    private Guilde guilde = null;
    private GroupeRaid groupe = null;


    public Chasseur (String nom) {
        super( nom, Classe.CITOYEN );
    }



    public int getAge () {
        return this.age;
    }

    public void setAge (int newAge) {
        this.age = newAge;
    }



    public int getArgent () {
        return this.argent;
    }

    public void setArgent (int nouvelArgent) {
        this.argent = nouvelArgent;
    }

    public void agmenterArgent (int montant) {
        this.argent += montant;
    }


    public Guilde getGuilde () {
        return this.guilde;
    }

    public void setGuilde (Guilde newGuilde) {
        this.guilde = newGuilde;
    }

    public boolean isInGuilde () {
        return this.guilde != null;
    }



    public GroupeRaid getGroupe () {
        return this.groupe;
    }

    public void setGroupe (GroupeRaid newGroupe) {
        this.groupe = newGroupe;
    }

    public boolean isInGroupe () {
        return this.groupe != null;
    }



    public int getSalaire () {
        return this.getClasse().getSalaire();
    }

}
