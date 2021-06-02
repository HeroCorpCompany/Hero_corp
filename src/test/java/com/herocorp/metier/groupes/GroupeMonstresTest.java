package com.herocorp.metier.groupes;
package com.herocorp.metier.acteurs;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GroupeMonstresTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCombatForce()
    {
        Monstre Monstre1 = new Monstre("Pouf");
        Monstre Monstre2 = new Monstre("Pif");
        Monstre Monstre3 = new Monstre("Souli");
        Monstre Monstre4 = new Monstre("Bipou");
        Monstre Monstre5 = new Monstre("TotoroDepressif");
        Monstre Monstre6 = new Monstre("Po");
        Monstre Monstre7 = new Monstre("Bou");
        Monstre Monstre8 = new Monstre("Maymay");
        Monstre Monstre9 = new Monstre("Bribri");
        Monstre Monstre10 = new Monstre("Alexandrie");
        GroupeMonstres groupe1 = new GroupeMonstres(); 
        GroupeMonstres groupe2 = new GroupeMonstres(); 

        Monstre1.setClasse(Classe.A); //4
        Monstre2.setClasse(Classe.B); //3
        Monstre3.setClasse(Classe.D); //1
        Monstre4.setClasse(Classe.A); //4
        Monstre5.setClasse(Classe.B); //3
        Monstre6.setClasse(Classe.S); //5
        Monstre7.setClasse(Classe.A); //4
        Monstre8.setClasse(Classe.A); //4
        Monstre9.setClasse(Classe.S); //5
        Monstre10.setClasse(Classe.D); //1

        groupe1.add(Monstre1); 
        groupe1.add(Monstre2); 
        groupe1.add(Monstre3); 
        groupe1.add(Monstre4); 
        groupe1.add(Monstre5); 
        groupe1.add(Monstre6); 
        groupe1.add(Monstre7); 
        groupe1.add(Monstre8); 
        groupe1.add(Monstre9); 
        groupe1.add(Monstre10); 

        Random randommo = new Random(); 
        randommo.setSeed(20);
        int attendu = 34*Math.random() * (2 - 0.5) + 0.5;

        // RES
        resultat = groupe1.combatForce(); 

        // TEST
        assertEquals(resultat,attendu)
    }
}

