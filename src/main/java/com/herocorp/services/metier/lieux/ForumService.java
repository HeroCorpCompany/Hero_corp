package com.herocorp.services.metier.lieux;

import com.herocorp.metier.acteurs.Chasseur;
import com.herocorp.metier.lieux.Forum;

public class ForumService {
    public static void ajouterChasseur (Forum forum, Chasseur chasseur) {
        forum.addMembre(chasseur);
    }

    public static boolean retirerChasseur (Forum forum, Chasseur chasseur) {
        return forum.removeMembre(chasseur);
    }
}
