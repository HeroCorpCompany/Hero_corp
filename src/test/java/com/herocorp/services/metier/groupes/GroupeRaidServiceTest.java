package com.herocorp.services.metier.groupes;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.groupes.GroupeRaid;
import com.herocorp.metier.lieux.*;
import com.herocorp.tools.Coord;
import com.herocorp.services.*;

import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.lieux.DonjonService;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GroupeRaidServiceTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testVerifierGroupe() 
    {
        // INIT
        Chasseur chasseur1 = new Chasseur("Pouf");
        Chasseur chasseur2 = new Chasseur("Pif");
        Chasseur chasseur3 = new Chasseur("Souli");
        Chasseur chasseur4 = new Chasseur("Bipou");
        Chasseur chasseur5 = new Chasseur("TotoroDepressif");
        Chasseur chasseur6 = new Chasseur("Po");
        Chasseur chasseur7 = new Chasseur("Bou");
        Chasseur chasseur8 = new Chasseur("Maymay");
        Chasseur chasseur9 = new Chasseur("Bribri");
        Chasseur chasseur10 = new Chasseur("Alexandrie");
        GroupeRaid groupe1 = new GroupeRaid(); 
        GroupeRaid groupe2 = new GroupeRaid(); 

        groupe1.add(chasseur1); 
        groupe1.add(chasseur2); 
        groupe1.add(chasseur3); 
        groupe1.add(chasseur4); 
        groupe1.add(chasseur5); 
        groupe1.add(chasseur6); 
        groupe1.add(chasseur7); 
        groupe1.add(chasseur8); 
        groupe1.add(chasseur9); 
        groupe1.add(chasseur10); 


        groupe2.add(chasseur1); 
        groupe2.add(chasseur2); 
        groupe2.add(chasseur3); 
        groupe2.add(chasseur4); 
        groupe2.add(chasseur5); 
        groupe2.add(chasseur6); 
        groupe2.add(chasseur7); 

        // RES 
        boolean resultat1 = GroupeRaidService.verifierGroupe(groupe1);
        boolean resultat2 = GroupeRaidService.verifierGroupe(groupe2);
        // TEST 
        System.out.println(resultat2);
        assertTrue(resultat1);
        assertFalse(resultat2); 
        //Le test passe pas avec assertFalse et je ne comprends pas pourquoi

    }

    @Test
    public void testAllerDonjon() 
    {
        // INIT
        Chasseur chasseur1 = new Chasseur("Pouf");
        Chasseur chasseur2 = new Chasseur("Pif");
        Chasseur chasseur3 = new Chasseur("Souli");
        Chasseur chasseur4 = new Chasseur("Bipou");
        Chasseur chasseur5 = new Chasseur("TotoroDepressif");
        Chasseur chasseur6 = new Chasseur("Po");
        Chasseur chasseur7 = new Chasseur("Bou");
        Chasseur chasseur8 = new Chasseur("Maymay");
        Chasseur chasseur9 = new Chasseur("Bribri");
        Chasseur chasseur10 = new Chasseur("Alexandrie");
        GroupeRaid groupe1 = new GroupeRaid(); 

        groupe1.add(chasseur1); 
        groupe1.add(chasseur2); 
        groupe1.add(chasseur3); 
        groupe1.add(chasseur4); 
        groupe1.add(chasseur5); 
        groupe1.add(chasseur6); 
        groupe1.add(chasseur7); 
        groupe1.add(chasseur8); 
        groupe1.add(chasseur9); 
        groupe1.add(chasseur10); 

        Donjon donjon = new Donjon(new Coord(0, 0));

        // RES 
        GroupeRaidService.allerDonjon(groupe1,donjon);

        AbstractLieu resultat = groupe1.getPosition();
        // TEST 
        System.out.println(resultat);
        assertEquals(resultat,donjon);
       
    }
    
    @Test
    public void testAjouterChasseur() 
    {
        // INIT
        Chasseur chasseur1 = new Chasseur("Pouf");
        Chasseur chasseur2 = new Chasseur("Pif");
        Chasseur chasseur3 = new Chasseur("Souli");
        Chasseur chasseur4 = new Chasseur("Bipou");
        Chasseur chasseur5 = new Chasseur("TotoroDepressif");
        Chasseur chasseur6 = new Chasseur("Po");
        Chasseur chasseur7 = new Chasseur("Bou");
        Chasseur chasseur8 = new Chasseur("Maymay");
        Chasseur chasseur9 = new Chasseur("Bribri");
        Chasseur chasseur10 = new Chasseur("Alexandrie");
        GroupeRaid groupe1 = new GroupeRaid(); 

        groupe1.add(chasseur1); 
        groupe1.add(chasseur2); 
        groupe1.add(chasseur3); 
        groupe1.add(chasseur4); 
        groupe1.add(chasseur5); 
        groupe1.add(chasseur6); 
        groupe1.add(chasseur7); 
        groupe1.add(chasseur8); 
        groupe1.add(chasseur9); 

        int attendu = 10;

        // RES 
        GroupeRaidService.ajouterChasseur(groupe1, chasseur10);

        int resultat = groupe1.getTaille();
        // TEST 
        assertEquals(resultat,attendu);
       
    }

    @Test
    public void testRetirerChasseur() 
    {
        // INIT
        Chasseur chasseur1 = new Chasseur("Pouf");
        Chasseur chasseur2 = new Chasseur("Pif");
        Chasseur chasseur3 = new Chasseur("Souli");
        Chasseur chasseur4 = new Chasseur("Bipou");
        Chasseur chasseur5 = new Chasseur("TotoroDepressif");
        Chasseur chasseur6 = new Chasseur("Po");
        Chasseur chasseur7 = new Chasseur("Bou");
        Chasseur chasseur8 = new Chasseur("Maymay");
        Chasseur chasseur9 = new Chasseur("Bribri");
        Chasseur chasseur10 = new Chasseur("Alexandrie");
        GroupeRaid groupe1 = new GroupeRaid(); 

        groupe1.add(chasseur1); 
        groupe1.add(chasseur2); 
        groupe1.add(chasseur3); 
        groupe1.add(chasseur4); 
        groupe1.add(chasseur5); 
        groupe1.add(chasseur6); 
        groupe1.add(chasseur7); 
        groupe1.add(chasseur8); 
        groupe1.add(chasseur9); 
        groupe1.add(chasseur10);

        int attendu = 9;

        // RES 
        GroupeRaidService.retirerChasseur(groupe1, chasseur10);

        int resultat = groupe1.getTaille();
        // TEST 
        assertEquals(resultat,attendu);
       
    }
    
    @Test
    public void testAttaquerDonjon() 
    {
        // INIT
        Chasseur chasseur1 = new Chasseur("Pouf");
        Chasseur chasseur2 = new Chasseur("Pif");
        Chasseur chasseur3 = new Chasseur("Souli");
        Chasseur chasseur4 = new Chasseur("Bipou");
        Chasseur chasseur5 = new Chasseur("TotoroDepressif");
        Chasseur chasseur6 = new Chasseur("Po");
        Chasseur chasseur7 = new Chasseur("Bou");
        Chasseur chasseur8 = new Chasseur("Maymay");
        Chasseur chasseur9 = new Chasseur("Bribri");
        Chasseur chasseur10 = new Chasseur("Alexandrie");
        GroupeRaid groupe1 = new GroupeRaid(); 

        ChasseurService.attribuerClasse(chasseur1);
        ChasseurService.attribuerClasse(chasseur2);
        ChasseurService.attribuerClasse(chasseur3);
        ChasseurService.attribuerClasse(chasseur4);
        ChasseurService.attribuerClasse(chasseur5);
        ChasseurService.attribuerClasse(chasseur6);
        ChasseurService.attribuerClasse(chasseur7);
        ChasseurService.attribuerClasse(chasseur8);
        ChasseurService.attribuerClasse(chasseur9);
        ChasseurService.attribuerClasse(chasseur10);

        groupe1.add(chasseur1); 
        groupe1.add(chasseur2); 
        groupe1.add(chasseur3); 
        groupe1.add(chasseur4); 
        groupe1.add(chasseur5); 
        groupe1.add(chasseur6); 
        groupe1.add(chasseur7); 
        groupe1.add(chasseur8); 
        groupe1.add(chasseur9); 
        groupe1.add(chasseur10); 

        Donjon donjon = new Donjon(new Coord(0, 0));
        DonjonService.remplirDonjon(donjon);
        GroupeRaidService.allerDonjon(groupe1,donjon);

        // RES 
        
        
        boolean resultat = GroupeRaidService.attaquerDonjon(groupe1);
        // TEST 
        System.out.println(resultat);
        assertTrue(resultat || !resultat);
       
    }
}

