package com.herocorp.game;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

public class World {

    private int temps = 0;
    Connection db;
    private ArrayList <Chasseur> listeChasseurs;
    private ArrayList <Donjon> listeDonjons;
    private ArrayList <Guilde> listeGuildes;
    private ArrayList <GroupeRaid> listeGroupes = new ArrayList<>();
    private HashMap <String, AbstractLieu> mapLieux;
    private int ageChasseurMort = 30;
    private int ageChasseurClasse = 3;
    private int ageChasseurReproduction = 5;
    private int nbGuildeSeuil = 5;
    private int nbDonjonSeuils = 9;
    private double chanceReproduction = 0.3;


    public World (ArrayList <Chasseur> listeChasseurs, ArrayList <Donjon> listeDonjons, ArrayList <Guilde> listeGuildes, HashMap <String, AbstractLieu> mapLieux) {
        this.listeChasseurs = listeChasseurs;
        this.listeDonjons = listeDonjons;
        this.listeGuildes = listeGuildes;
        this.mapLieux = mapLieux;
    }

    public void setConnection (Connection db) {
        this.db = db;
    }

    public Connection getDb() {
        return this.db;
    }

    public int getTemps () {
        return this.temps;
    }

    public void setTemps (int newTemps) {
        this.temps = newTemps;
    }

    public ArrayList <Chasseur> getListeChasseurs () {
        return this.listeChasseurs;
    }

    public boolean ajouterChasseur (Chasseur chasseur) {
        return this.listeChasseurs.add(chasseur);
    }

    public boolean supprimerChasseur (Chasseur chasseur) {
        return this.listeChasseurs.remove(chasseur);
    }

    public ArrayList <Donjon> getListeDonjons () {
        return this.listeDonjons;
    }

    public void ajouterDonjon (Donjon donjon) {
        this.listeDonjons.add(donjon);
    }

    public boolean supprimerDonjon (Donjon donjon) {
        return this.listeDonjons.remove(donjon);
    }

    public ArrayList <Guilde> getListeGuildes () {
        return this.listeGuildes;
    }

    public void ajouterGuilde (Guilde guilde) {
        this.listeGuildes.add(guilde);
    }

    public boolean supprimerGuilde (Guilde guilde) {
        return this.listeGuildes.remove(guilde);
    }

    public ArrayList <GroupeRaid> getListeGroupes () {
        return this.listeGroupes;
    }

    public void ajouterGroupe (GroupeRaid groupe) {
        this.listeGroupes.add(groupe);
    }

    public boolean supprimerGroupe (GroupeRaid groupe) {
        return this.listeGroupes.remove(groupe);
    }

    public HashMap <String, AbstractLieu> getMapLieux () {
        return this.mapLieux;
    }

    public void ajouterLieu (String nom, AbstractLieu lieu) {
        this.mapLieux.put(nom, lieu);
    }

    public AbstractLieu getLieu (String nom) {
        return this.mapLieux.get(nom);
    }
    public int getAgeChasseurMort() {
        return this.ageChasseurMort;
    }

    public void setAgeChasseurMort(int ageChasseurMort) {
        this.ageChasseurMort = ageChasseurMort;
    }

    public int getAgeChasseurClasse() {
        return this.ageChasseurClasse;
    }

    public void setAgeChasseurClasse(int ageChasseurClasse) {
        this.ageChasseurClasse = ageChasseurClasse;
    }

    public int getAgeChasseurReproduction() {
        return this.ageChasseurReproduction;
    }

    public void setAgeChasseurReproduction(int ageChasseurReproduction) {
        this.ageChasseurReproduction = ageChasseurReproduction;
    }

    public int getNbGuildeSeuil() {
        return this.nbGuildeSeuil;
    }

    public void setNbGuildeSeuil(int nbGuildeSeuil) {
        this.nbGuildeSeuil = nbGuildeSeuil;
    }

    public int getNbDonjonSeuils() {
        return this.nbDonjonSeuils;
    }

    public void setNbDonjonSeuils(int nbDonjonSeuils) {
        this.nbDonjonSeuils = nbDonjonSeuils;
    }

    public double getChanceReproduction() {
        return this.chanceReproduction;
    }

    public void setChanceReproduction(double chanceReproduction) {
        this.chanceReproduction = chanceReproduction;
    }
}
