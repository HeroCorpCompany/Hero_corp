package com.herocorp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.tools.Connexion;


public class ChasseurDao {

    public static void ajouterChasseur (Connection db, Chasseur chasseur) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO Chasseur(nom, age, argent, idLieu, classe, salaire) VALUES ('%1$s', %2$d, %3$d, %4$d, '%5$s', %6$d) RETURNING idChasseur", 
                chasseur.getNom(), chasseur.getAge(), chasseur.getArgent(), chasseur.getPosition().getId(), chasseur.getClasse().getNom(), chasseur.getClasse().getSalaire());
            ResultSet rs = st.executeQuery(requete);
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

    public static Chasseur recupererChaseur (Connection db, int idChasseur) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("SELECT * FROM Chasseur WHERE idChasseur=%1$d", 
                idChasseur);
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            int id = rs.getInt("idChasseur");
            String nom = rs.getString("nom");
            int argent = rs.getInt("argent");
            int age = rs.getInt("age");
            rs.close();
            st.close();
            Chasseur chasseur = new Chasseur(nom);
            chasseur.setId(id);
            chasseur.setArgent(argent);
            chasseur.setAge(age);
            return chasseur;
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
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
