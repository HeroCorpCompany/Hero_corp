package com.herocorp.services.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Forum;
import com.herocorp.metier.lieux.Guilde;
import com.herocorp.services.metier.acteurs.ChasseurService;
import com.herocorp.services.metier.lieux.DonjonService;
import com.herocorp.tools.Classe;
import com.herocorp.tools.Coord;

import org.junit.Test;

public class UpdateChasseursTest {

    @Test
    public void testOui () {
        // Oui : Le chasseur meurt de vieillesse
        // INIT
        World world = genererWorld();
        int nbreInitial = world.getListeChasseurs().size();
        world.getListeChasseurs().get(0).setAge(10000);
        UpdateChasseurs.updateChasseurs(world);
        // RES
        int resultat = world.getListeChasseurs().size();
        // TEST
        assertEquals(nbreInitial - 1, resultat);
    }

    @Test
    public void testNonOuiOui () {
        // NonOuiOui : Le chasseur a atteint l'âge auquel il reçoit son éveil
        // INIT
        World world = genererWorld();
        world.getListeChasseurs().get(0).setAge(200);
        UpdateChasseurs.updateChasseurs(world);
        // RES
        boolean resultat1 = world.getListeChasseurs().get(0).getClasse() != Classe.CITOYEN;
        boolean resultat2 = world.getListeChasseurs().get(1).getClasse() == Classe.CITOYEN;
        // TEST
        assertTrue(resultat1);
        assertTrue(resultat2);
    }

    @Test
    public void testNonOuiNon () {
        // NonOuiNon : Le chasseur n'a pas encore atteind le bon âge, il attend
        // INIT
        World world = genererWorld();
        world.getListeChasseurs().get(0).setAge(110);
        UpdateChasseurs.updateChasseurs(world);
        // RES
        boolean resultat = world.getListeChasseurs().get(0).getClasse() == Classe.CITOYEN;
        // TEST
        assertTrue(resultat);
    }

    @Test
    public void testNonNonDonjon () {
        // NonNonDonjon : Le chasseur se trouve dans un donjon, il attend que le groupe attaque
        // INIT
        World world = genererWorld();
        Donjon donjon = new Donjon(new Coord(0, 0));
        Chasseur chasseur = world.getListeChasseurs().get(0);
        ChasseurService.attribuerClasse(chasseur);
        ChasseurService.changerLieu(chasseur, donjon);
        UpdateChasseurs.updateChasseurs(world);
        // RES
        boolean resultat = chasseur.getPosition() == donjon;
        // TEST
        assertTrue(resultat);
    }

    @Test
    public void testNonNonForumNonOui () {
        // NonNonForumNonOui : Le chasseur n'a pas de guilde et en trouve une libre, il la rejoint
        // INIT
        World world = genererWorld();
        Guilde guilde = new Guilde(new Coord(0, 0));
        guilde.setRecrute(true);
        Chasseur chasseur = world.getListeChasseurs().get(0);
        ChasseurService.attribuerClasse(chasseur);
        UpdateChasseurs.updateChasseurs(world);
        // RES

        // TEST
    }


    public World genererWorld () {
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        Forum forum = new Forum(new Coord(0, 0));
        mapLieux.put("Forum", forum);
        for (int i = 0; i < 10; i++) {
            Donjon donjon = new Donjon(new Coord(0, 0));
            DonjonService.remplirDonjon(donjon);
            listeDonjons.add(donjon);
        }
        for (int i = 0; i < 90; i++) {
            Chasseur chasseur = new Chasseur("Souli");
            ChasseurService.changerLieu(chasseur, forum);
            listeChasseurs.add(chasseur);
        }

        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        return world;
    }
    
}
