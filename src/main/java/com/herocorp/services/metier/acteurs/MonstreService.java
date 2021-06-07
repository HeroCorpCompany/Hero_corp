package com.herocorp.services.metier.acteurs;

import java.util.Random;

import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.tools.Classe;

public class MonstreService {
    
    public static Monstre genererMonstre (GroupeMonstres groupe) {
        Classe classe;
        Random rnd = new Random();
        int randomInt = rnd.nextInt(100);

        if (randomInt < 40) {
            classe = Classe.D;
        } else if (randomInt < 30) {
            classe = Classe.C;
        } else if (randomInt < 20) {
            classe = Classe.B;
        } else if (randomInt < 99) {
            classe = Classe.A;
        } else {
            classe = Classe.S;
        }

        Monstre monstre = new Monstre("TestMonstre", classe, groupe);
        return monstre;
    }
}
