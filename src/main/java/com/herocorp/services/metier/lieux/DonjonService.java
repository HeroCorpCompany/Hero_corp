package com.herocorp.services.metier.lieux;

import com.herocorp.metier.acteurs.Monstre;
import com.herocorp.services.metier.acteurs.MonstreService;
import com.herocorp.metier.groupes.GroupeMonstres;
import com.herocorp.metier.lieux.Donjon;

public class DonjonService {

    public static void remplirDonjon (Donjon donjon) {
        GroupeMonstres groupeMonstres = new GroupeMonstres();
        
        for (int i = 0; i < 10; i++){
            Monstre monstre = MonstreService.genererMonstre(groupeMonstres);
            groupeMonstres.add(monstre);
        }
    
        donjon.setGroupeMonstre(groupeMonstres);
    }
    
}
