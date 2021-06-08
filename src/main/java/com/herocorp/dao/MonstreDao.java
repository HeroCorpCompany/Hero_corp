package com.herocorp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.tools.Classe;

public class MonstreDao {

    public static void ajouterMonstre (Connection db,  Monstre monstre, int idDonjon) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO Monstre(nom, classe, recompense, idLieu) VALUES ('%1$s', '%2$s', %3$d, %4$d) RETURNING idMonstre", 
               monstre.getNom(), monstre.getClasse().getNom(), monstre.getClasse().getRecompense(), idDonjon);
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            int id = rs.getInt("idMonstre");
            monstre.setId(id);
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Monstre recupererMonstre (Connection db, int idMonstre, GroupeMonstres groupe) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("SELECT * FROM Monstre WHERE idMonstre=%1$d", 
               idMonstre);
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            int id = rs.getInt("idMonstre");
            String nomClasse = rs.getString("classe");
            String nom = rs.getString("nom");
            rs.close();
            st.close();
            Monstre monstre = new Monstre(nom, Classe.D, groupe);
            monstre.setId(id);
            switch (nomClasse) {
                case "C":
                    monstre.setClasse(Classe.C);
                    break;
                case "B":
                    monstre.setClasse(Classe.B);
                    break;
                case "A":
                    monstre.setClasse(Classe.A);
                    break;
                case "S":
                    monstre.setClasse(Classe.S);
            }
            return monstre;
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
