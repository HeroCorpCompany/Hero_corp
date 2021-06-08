package com.herocorp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.tools.Connexion;
import com.herocorp.tools.Coord;

public class LieuDao {

    public static void ajouterLieu (Connection db, AbstractLieu lieu) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO Lieu(typeLieu, x, y) VALUES ('%1$s', %2$d, %3$d) RETURNING idLieu", 
               lieu.getType(), lieu.getPosition().x, lieu.getPosition().y);
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            int id = rs.getInt("idLieu");
            lieu.setId(id);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static AbstractLieu recupererLieu (Connection db, int id) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("SELECT * FROM Lieu WHERE idLieu=%1$d", 
                id);
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            String type = rs.getString("typeLieu");
            int x = rs.getInt("x");
            int y = rs.getInt("y");
            int newId = rs.getInt("idLieu");
            rs.close();
            st.close();
            switch (type) {
                case "Forum":
                    Forum forum = new Forum(new Coord(x, y));
                    forum.setId(newId);
                    return forum;
                case "Guilde":
                    Guilde guilde = new Guilde(new Coord(x, y));
                    guilde.setId(newId);
                    return guilde;
                case "Donjon":
                    Donjon donjon = new Donjon(new Coord(x, y));
                    donjon.setId(newId);
                    return donjon;
            }
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
