package com.herocorp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Coord;

public class GuildeDao {
    
    public static void ajouterGuilde(Connection db, Guilde guilde) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO Guilde(idGuilde, argent, recrute) VALUES (%1$d, %2$d, %3$b)", 
                guilde.getId(), guilde.getArgent(), guilde.isRecruting());
            st.execute(requete);
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Guilde recupererGuilde(Connection db, int idGuilde) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("SELECT * FROM Guilde WHERE idGuilde=%1$d", 
                idGuilde);
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            int id = rs.getInt("idGuilde");
            int argent = rs.getInt("argent");
            boolean recrute = rs.getBoolean("recrute");
            rs.close();
            st.close();
            Guilde guilde = new Guilde(new Coord(0, 0));
            guilde.setId(id);
            guilde.setArgent(argent);
            guilde.setRecrute(recrute);
            return guilde;
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void majGuilde (Connection db, Guilde guilde) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("UPDATE Guilde SET argent=%1$d, recrute=%2$b WHERE idGuilde=%3$d", 
                guilde.getArgent(), guilde.isRecruting(), guilde.getId());
            st.execute(requete);
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void supprimerGuilde (Connection db, Guilde guilde) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("DELETE Guilde WHERE idGuilde=%1$d", 
                guilde.getId());
            st.execute(requete);
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
