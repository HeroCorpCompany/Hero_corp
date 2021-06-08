package com.herocorp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.herocorp.metier.acteurs.Chasseur;


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
            if (chasseur.isInGuilde()) {
                ajouterChasseurGuilde(db, chasseur);
            }
            if (chasseur.isInGroupe()) {
                ajouterChasseurGroupe(db, chasseur);
            }
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


    public static void ajouterChasseurGuilde (Connection db, Chasseur chasseur) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO ChasseurGuilde(idChasseur, idGuilde) VALUES (%1$d, %2$d)", 
                chasseur.getId(), chasseur.getGuilde().getId());
            ResultSet rs = st.executeQuery(requete);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ajouterChasseurGroupe (Connection db, Chasseur chasseur) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO GroupeChasseur(idChasseur, idGroupe) VALUES (%1$d, %2$d)", 
                chasseur.getId(), chasseur.getGroupe().getId());
            ResultSet rs = st.executeQuery(requete);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void supprimerChasseurGroupe (Connection db, Chasseur chasseur) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("DELETE FROM GroupeChasseur WHERE idChasseur=%1$d)", 
                chasseur.getId());
            ResultSet rs = st.executeQuery(requete);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    } 

    public static void supprimerChasseurGuilde (Connection db, Chasseur chasseur) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("DELETE FROM ChasseurGuilde WHERE idChasseur=%1$d)", 
                chasseur.getId());
            ResultSet rs = st.executeQuery(requete);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void majChasseur (Connection db, Chasseur chasseur) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("UPDATE Chasseur SET age=%1$d, argent=%2$d, idLieu=%3$d, classe='%4$s', salaire=%5$d WHERE idChasseur=%6$d", 
                chasseur.getAge(), chasseur.getArgent(), chasseur.getPosition().getId(), chasseur.getClasse().getNom(), chasseur.getClasse().getSalaire(), chasseur.getId());
            ResultSet rs = st.executeQuery(requete);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void supprimerChasseur (Connection db, Chasseur chasseur) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("DELETE Chasseur WHERE idChasseur=%1$d", 
                chasseur.getId());
            ResultSet rs = st.executeQuery(requete);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
