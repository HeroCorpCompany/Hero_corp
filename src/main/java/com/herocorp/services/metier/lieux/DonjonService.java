package com.herocorp.services.metier.lieux;

import java.util.Random;

import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.metier.lieux.Donjon;
import com.herocorp.tools.Classe;

public class DonjonService {

    public static void remplirDonjon (Donjon donjon) {
        GroupeMonstres groupeMonstres = new GroupeMonstres();
        Classe classe;
        Random random = new Random();
        
        for (int i = 0; i < 10; i++){
            switch (random.nextInt(5)) {
                case 0:
                    classe = Classe.S;
                    break;

                case 1:
                    classe = Classe.A;
                    break;

                case 2:
                    classe = Classe.B;
                    break;

                case 3:
                    classe = Classe.C;
                    break;
            
                default:
                    classe = Classe.D;
                    break;
            }

            Monstre monstre = new Monstre("Vilain", classe, groupeMonstres);
            groupeMonstres.add(monstre);
        }
    
        donjon.setGroupeMonstre(groupeMonstres);
    }
    
}
