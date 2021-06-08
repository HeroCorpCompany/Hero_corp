package com.herocorp.services.metier.groupes;
import java.sql.Connection;
import java.util.ArrayList;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.dao.GroupeDao;
import com.herocorp.metier.acteurs.AbstractActeur;

import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

public class GroupeRaidService {

    public static GroupeRaid creerGroupe (Connection db, Donjon donjon, AbstractLieu lieu, Guilde guilde) {
        GroupeRaid groupe = new GroupeRaid();
        groupe.setCible(donjon);
        groupe.setPosition(lieu);
        if (guilde != null) {
            groupe.setGuilde(guilde);
        }
        GroupeDao.ajouterGroupe(db, groupe);
        return groupe;
    }
    
    public static boolean verifierGroupe (GroupeRaid groupe) {
        // TODO : vérifier la taille du groupe
        return (groupe.getTaille() == 10);
    }

    public static void allerDonjon (GroupeRaid groupe, Donjon donjon) {
        // TODO : changer la position du raid et de ses membres, mettre à jour le donjon
        groupe.setPosition(donjon);
        groupe.setCible(donjon);
        donjon.setGroupeRaid(groupe);
        ArrayList <AbstractActeur> listeChasseur = groupe.getListe(); 
        for(AbstractActeur chasseur: listeChasseur){
            chasseur.setPosition(donjon);
          }
    }

    public static boolean attaquerDonjon (GroupeRaid groupe) {
        // TODO : renvoyer vrai si la force du groupe est supérieure à celle du donjon, faux sinon
        double forceMoyChasseur = Double.valueOf(groupe.combatForce()); 
        GroupeMonstres grpMonstre = groupe.getCible().getGroupeMonstres();
        double forceMoyMonstres = grpMonstre.combatForce();

        return (forceMoyChasseur > forceMoyMonstres) ;
    }

    public static void ajouterChasseur (GroupeRaid groupe, Chasseur chasseur) {
        // TODO : ajouter le chasseur au groupe
        groupe.add(chasseur);
    } 

    public static void retirerChasseur (GroupeRaid groupe, Chasseur chasseur) {
        // TODO : retirer le chasseur du groupe
        groupe.remove(chasseur);
    }
}
