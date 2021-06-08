package com.herocorp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.tools.Connexion;


public class ChasseurDao {

    public static void ajouterChasseur (Chasseur chasseur) {
        try {
            Connection db = new Connexion().getConnexion();
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO Chasseur VALUES (%1$s, %2$d, %3$s, %4$s)", 
                chasseur.getNom(), chasseur.getArgent(), chasseur.getPosition().getId(), chasseur.getClasse().getNom());
            ResultSet rs = st.executeQuery(requete);
            System.out.println("Requête exécutée");
            rs.next();
            int id = rs.getInt("idChasseur");
            chasseur.setId(id);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void majChasseur (Chasseur chasseur) {
        try {
            Connection db = new Connexion().getConnexion();
            Statement st = db.createStatement();
            String requete = String.format("UPDATE Chasseur SET (argent=%1$d, idPosition=%2$s, classe=%3$s) WHERE idChasseur=%4$s", 
                chasseur.getArgent(), chasseur.getPosition().getId(), chasseur.getClasse().getNom(), chasseur.getId());
            ResultSet rs = st.executeQuery(requete);
            System.out.println("Requête exécutée");
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
