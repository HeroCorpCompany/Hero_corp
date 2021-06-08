package com.herocorp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.tools.Connexion;

public class GroupeDao {
    
    public static void ajouterGroupe (Connection db, GroupeRaid groupe) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO Groupe(idLieu, idDonjon) VALUES (%1$d, %2$d) RETURNING idGroupe", 
                groupe.getPosition().getId(), groupe.getCible().getId());
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            int id = rs.getInt("idGroupe");
            groupe.setId(id);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static GroupeRaid recupererGroupe (Connection db, int idGroupe) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("SELECT * FROM Groupe WHERE idGroupe=%1$d", 
                idGroupe);
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            int id = rs.getInt("idGroupe");
            rs.close();
            st.close();
            GroupeRaid groupe = new GroupeRaid();
            groupe.setId(id);
            return groupe;
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
