package com.herocorp.game;

public class Statistiques {
    private World world;

    public Statistiques(World world) {
        this.world = world;
    }

    @Override
    public String toString () {
        return String.format("Nombre de chasseurs : " + world.getListeChasseurs().size() + "\n" +
                             "Nombre de Donjons : " + world.getListeDonjons().size() + "\n" +
                             "Nombre de Guildes : " + world.getListeGuildes().size());
    }
}
