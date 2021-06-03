package com.herocorp.services.metier.acteurs;

import static org.junit.Assert.assertEquals;

import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.metier.groupes.GroupeMonstres;

import org.junit.Test;

public class MonstreServiceTest {

    @Test
    public void testGenererMonstre () {
        // INIT
        GroupeMonstres attendu = new GroupeMonstres();
        Monstre monstre = MonstreService.genererMonstre(attendu);
        // RES
        GroupeMonstres resultat = monstre.getGroupe();
        // TEST
        assertEquals(attendu, resultat);
    }
    
}
