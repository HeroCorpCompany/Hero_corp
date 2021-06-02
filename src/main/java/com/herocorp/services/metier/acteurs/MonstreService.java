package com.herocorp.services.metier.acteurs;

import java.util.Random;

import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.tools.Classe;

public class MonstreService {
    
    public static Monstre genererMonstre (GroupeMonstres groupe) {
        Classe classe;
        Random rnd = new Random();
        int randomInt = rnd.nextInt(5);
        switch (randomInt) {
            case 0:
                classe = Classe.D;
                break;
            case 1:
                classe = Classe.C;
                break;
            case 2:
                classe = Classe.B;
                break;
            case 3:
                classe = Classe.A;
                break;
            case 4:
                classe = Classe.S;
                break;
            default:
                classe = Classe.D;
        }
        Monstre monstre = new Monstre("TestMonstre", classe, groupe);
        return monstre;
    }
}
