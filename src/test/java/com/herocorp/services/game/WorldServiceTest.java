package com.herocorp.services.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import com.herocorp.game.World;
import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.AbstractLieu;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.metier.lieux.Guilde;

import org.junit.Test;

public class WorldServiceTest
{

    @Test
    public void testUpdateTemps () {
        // INIT
        ArrayList <Chasseur> listeChasseurs = new ArrayList<>();
        ArrayList <Donjon> listeDonjons = new ArrayList<>();
        ArrayList <Guilde> listeGuildes = new ArrayList<>();
        HashMap <String, AbstractLieu> mapLieux = new HashMap<>();
        World world = new World(listeChasseurs, listeDonjons, listeGuildes, mapLieux);
        WorldService.updateTemps(world);
        int attendu = 1;
        // RES
        int resultat = world.getTemps();
        // TEST
        assertEquals(attendu, resultat);
    }

    @Test
    public void testUpdateWorld () {
        // TODO : Générer un monde et le simuler pendant un tour
        assertTrue(true);
    }
}

