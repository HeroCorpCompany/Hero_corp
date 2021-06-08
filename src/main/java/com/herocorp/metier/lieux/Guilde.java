package com.herocorp.metier.lieux;

import java.util.ArrayList;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeChasseurs;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.tools.Coord;

public class Guilde extends AbstractLieu {
    
    private GroupeChasseurs membres = new GroupeChasseurs ();
    private int argent = 0;
    private ArrayList <GroupeRaid> listeGroupes = new ArrayList<>();
    private boolean recrute = false;

    public Guilde (Coord coord) {
        super ("Guilde", coord);
        this.setType("Guilde");
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

    public int getArgent () {
        return this.argent;
    }

    public void setArgent (int newArgent) {
        this.argent = newArgent;
    }

    public int getTaille () {
        return this.membres.getTaille();
    }

    public ArrayList <GroupeRaid> getListeGroupes () {
        return this.listeGroupes;
    }

    public void ajouterGroupe (GroupeRaid groupe) {
        this.listeGroupes.add(groupe);
    }

    public boolean isRecruting () {
        return this.recrute;
    }

    public void setRecrute (boolean newRecruting) {
        this.recrute = newRecruting;
    }

}