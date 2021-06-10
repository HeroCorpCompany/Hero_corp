package com.herocorp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.herocorp.game.World;

public class WorldDao {
    
    public static void initialiserStats (Connection db, World world) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("INSERT INTO Stats(id, temps, nbChasseurs, nbDonjons, nbGuildes) VALUES (1, %1$d, %2$d, %3$d, %4$d)", 
                world.getTemps(), world.getListeChasseurs().size(), world.getListeDonjons().size(), world.getListeGuildes().size());
            st.execute(requete);
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void majStats (Connection db, World world) {
        try {
            Statement st = db.createStatement();
            String requete = String.format("UPDATE Stats SET temps=%1$d, nbChasseurs=%2$d, nbDonjons=%3$d, nbGuildes=%4$d WHERE id=1", 
            world.getTemps(), world.getListeChasseurs().size(), world.getListeDonjons().size(), world.getListeGuildes().size());
            st.execute(requete);
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
