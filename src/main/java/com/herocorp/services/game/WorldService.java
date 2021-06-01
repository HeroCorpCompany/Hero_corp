package com.herocorp.services.game;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

public class WorldService {
    
    public static void updateWorld (World world) {
        // TODO : un tour de la boucle de la simulation, update des chasseurs, puis des groupes de raid, puis des guildes
    }

    public static void updateChasseurs (World world) {
        // TODO : update de tous les chasseurs du monde : Voir arbre de décision des chasseurs
    }

    public static void updateGroupes (World world) {
        // TODO : update de tous les groupes de raid : Voir arbre de décision des groupes
    }

    public static void updateGuildes (World world) {
        // TODO : update de toutes les guildes : Voir arbre de décision des guildes
    }

    public static void genererDonjons (World world) {
        // TODO : générer un nombre aléatoire de donjons et les ajouter à la liste des donjons
    }

    public static void detruireDonjon (World world, Donjon donjon) {
        // TODO : oublier le donjon
    }

    public static void detruireGuilde (World world, Guilde guilde) {
        // TODO : oublier la guilde
    }

    public static void tuerChasseur (World world, Chasseur chasseur) {
        // TODO : oublier le chasseur
    }
}
