package com.herocorp.tools;

public enum Classe {
    CITOYEN("Citoyen", 10, 0, 0), D("D", 50, 20, 1), C("C", 100, 50, 2), B("B", 300, 200, 3), A("A", 1000, 600, 4), S("S", 5000, 3000, 5);

    private String nom;
    private int salaire;
    private int recompense;
    private int force;

    private Classe (String nom, int salaire, int recompense, int force) {
        this.nom = nom;
        this.salaire = salaire;
        this.recompense = recompense;
        this.force = force;
    }

    public String getNom () {
        return this.nom;
    }

    public int getSalaire () {
        return this.salaire;
    }

    public int getRecompense () {
        return this.recompense;
    }

    public int getForce () {
        return this.force;
    }
}
