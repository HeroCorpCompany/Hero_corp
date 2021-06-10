package com.herocorp.tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {

   private Connection connexion;

   public Connexion() {
      try {
        Class.forName("org.postgresql.Driver");
         this.connexion = DriverManager.getConnection("jdbc:postgresql://tai.db.elephantsql.com/vmgplssn",
            "vmgplssn", "fF69eX1OPGpUWbKUyYJVmxoXLDNDrb1C");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }

   public Connection getConnexion () {
      return this.connexion;
   }

}
